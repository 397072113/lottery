package com.luwei6.lottery.services;

import com.alibaba.dubbo.common.json.JSONObject;
import com.luwei6.lottery.cache.RedisCacheServices;
import com.luwei6.lottery.dao.LotteryCycleDtoMapper;
import com.luwei6.lottery.dao.LotteryUnionLottoDao;
import com.luwei6.lottery.model.LotteryCycleDto;
import com.luwei6.lottery.model.LotteryUnionLottoDto;
import com.luwei6.utils.DateUtilBase;
import com.luwei6.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.ArrayUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Administrator on 2018/10/26.
 */
@Service
public class LotteryUnionLottoService {
    public static List<Long> unionLottoRedNumList = new ArrayList<Long>();
    private static List<Long> unionLottoBlueNumList = new ArrayList<Long>();

    @Autowired
    private LotteryUnionLottoDao lotteryUnionLottoDao;

    @Autowired
    private RedisCacheServices redisCacheServices;

    @Autowired
    private LotteryCycleDtoMapper lotteryCycleDtoMapper;

    /**
     * 生成16个彩号
     * @return
     * @throws Exception
     */
    public List<LotteryUnionLottoDto> generateUnionLottoList() throws Exception {
        initUnionLottoBlueNumList();
        List<LotteryUnionLottoDto> list = new ArrayList<LotteryUnionLottoDto>();
        for(int i=1;i<=16;i++) {
            LotteryUnionLottoDto dto = generateUnionLotto();
            list.add(dto);
        }
        com.luwei6.utils.CollectionUtils.sortByProperties(list,"blueNumber");
        for (LotteryUnionLottoDto lulDto:list) {
            addLotteryUnionLotto(lulDto);
        }
        return list;
    }

    /**
     * 生成单一的彩号
     * @return
     * @throws Exception
     */
    public LotteryUnionLottoDto generateUnionLotto() throws Exception {
        LotteryCycleDto qryPram = new LotteryCycleDto();
        qryPram.setState("A");
        qryPram.setLotteryCycleTypeId(1);
        qryPram.setCycleEndDate(new Date());
        LotteryCycleDto currentCycle = lotteryCycleDtoMapper.selectCurrentLotteryCycle(qryPram);
        Date lotteryDate = DateUtilBase.string2Date("20191031");
        int week = DateUtilBase.getWeekOfDate(lotteryDate);
        Date nextLotteryDate = null;
        switch (week) {
            case 0:case 2:nextLotteryDate = DateUtilBase.dateOffsetCalc(2,lotteryDate,0, false); break;
            case 4:nextLotteryDate = DateUtilBase.dateOffsetCalc(3,lotteryDate,0, false); break;
        }
        initUnionLottoRedNumList();
        LotteryUnionLottoDto dto  = new LotteryUnionLottoDto();
        dto.setLotteryDate(nextLotteryDate);
        dto.setLotteryIssue(String.valueOf(currentCycle.getCycleCode()));
        dto.setLotteryType(1);
        Class dtoClass = LotteryUnionLottoDto.class;
        Random random=new Random();
        Long[] redNumArray = new Long[6];
        for (int i = 1; i <= 6; i++) {
            int index = random.nextInt(unionLottoRedNumList.size());
            Long redNum = unionLottoRedNumList.get(index);
            redNumArray[i-1] = redNum;
            unionLottoRedNumList.remove(index);
        }
        Arrays.sort(redNumArray);
        for(int j = 1 ; j<= 6; j++) {
            String methodName = "setRedNumber"+ j;
            Method declaredMethod = dtoClass.getMethod(methodName,Long.class);
            declaredMethod.invoke(dto,redNumArray[j-1]);

        }
        int blueIndex = random.nextInt(unionLottoBlueNumList.size());
        Long blueNum = unionLottoBlueNumList.get(blueIndex);
        dto.setBlueNumber(blueNum);
        unionLottoBlueNumList.remove(blueIndex);
        return dto;
    }

    /**
     * 开奖
     * @return
     */
    public void drawLotter() throws Exception {
        LotteryCycleDto dto = new LotteryCycleDto();
        dto.setState("A");
        List<LotteryCycleDto> lotteryCycleList = lotteryCycleDtoMapper.selectAllLotteryCycle(dto);
        if (!CollectionUtils.isEmpty(lotteryCycleList)) {
            for (LotteryCycleDto cycleItem:lotteryCycleList) {
                if (StringUtil.isEmpty(cycleItem.getNumber1()) || StringUtil.isEmpty(cycleItem.getNumber2())) {
                    continue;
                }
                String[] redNumberArray = cycleItem.getNumber1().split(",");
                String blueNbr = cycleItem.getNumber2();

                Long winCount = 0L;
                Long pressWinCount = 0L;
                LotteryUnionLottoDto lotteryDto = new LotteryUnionLottoDto();
                lotteryDto.setLotteryIssue(cycleItem.getCycleCode());
                List<LotteryUnionLottoDto> lotteryList =  lotteryUnionLottoDao.selectByDto(lotteryDto);
                if (!CollectionUtils.isEmpty(lotteryList)) {

                    for (LotteryUnionLottoDto lotteryItem:lotteryList) {
                        int redWins = 0;
                        int blueWins = 0;
                        if (blueNbr.equals(String.valueOf(lotteryItem.getBlueNumber()))) {
                            blueWins = 1;
                            lotteryItem.setBlueNumberStatus("A");
                        }
                        for(int j = 1 ; j<= 6; j++) {
                            String methodGetName = "getRedNumber"+ j;
                            String methodSetName = "setRedNumber"+ j + "Status";
                            Method declaredGetMethod = lotteryItem.getClass().getMethod(methodGetName);
                            Method declaredSetMethod = lotteryItem.getClass().getMethod(methodSetName, String.class);
                            Long redNbr = (Long)declaredGetMethod.invoke(lotteryItem);
                            if (ArrayUtils.contains(redNumberArray, String.valueOf(redNbr))) {
                                redWins ++;
                                declaredSetMethod.invoke(lotteryItem, "A");
                            }
                        }
                        Long oneWinMoney = 0L;
                        if ((blueWins > 0 && redWins < 3) ) {
                            oneWinMoney = 5L;
                        }
                        else if ((blueWins > 0 && redWins == 3) || redWins == 4) {
                            oneWinMoney = 10L;
                        }
                        else if ((blueWins > 0 && redWins == 4) || redWins == 5) {
                            oneWinMoney = 200L;
                        }
                        else if (blueWins > 0 && redWins == 5) {
                            oneWinMoney = 3000L;
                        }
                        else if (redWins == 6) {
                            oneWinMoney = 100000L;
                        }
                        else if (blueWins > 0 && redWins == 6) {
                            oneWinMoney = 5000000L;
                        }
                        pressWinCount = pressWinCount + oneWinMoney;
                        lotteryItem.setPressWinCount(oneWinMoney);
                        lotteryUnionLottoDao.updateByPrimaryKey(lotteryItem);

                    }
                    cycleItem.setTotalCount(Long.valueOf(lotteryList.size()));
                    cycleItem.setWinCount(winCount);
                    cycleItem.setPressCount(Long.valueOf(lotteryList.size()*2));
                    cycleItem.setPressWinCount(pressWinCount);
                    cycleItem.setState("C");
                }
                else {
                    cycleItem.setState("X");
                }
                lotteryCycleDtoMapper.updateByPrimaryKey(cycleItem);
            }
        }
    }

    public int addLotteryUnionLotto(LotteryUnionLottoDto lotteryUnionLottoDto) {
        lotteryUnionLottoDto.setLuckyNumberId(lotteryUnionLottoDao.findNextLuckyNumberId());
        return lotteryUnionLottoDao.insert(lotteryUnionLottoDto);
    }

    private void initUnionLottoRedNumList() {
        unionLottoRedNumList = new ArrayList<Long>();
        for (int i = 1; i <= 33; i++) {
            unionLottoRedNumList.add(Long.valueOf(i));
        }
    }

    private void initUnionLottoBlueNumList() {
        unionLottoBlueNumList = new ArrayList<Long>();
        for (int i = 1; i <= 16; i++) {
            unionLottoBlueNumList.add(Long.valueOf(i));
        }
    }

    public List<LotteryUnionLottoDto> qryLotteryList(LotteryUnionLottoDto dto) {
        return lotteryUnionLottoDao.selectByDto(dto);
    }

    public List<LotteryCycleDto> queryLotteryCycle(LotteryCycleDto dto) {
        List<LotteryCycleDto> list = lotteryCycleDtoMapper.selectAllLotteryCycle(dto);
        return list;
    }


}
