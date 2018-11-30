package com.luwei6.lottery.services;

import com.luwei6.lottery.cache.RedisCacheServices;
import com.luwei6.lottery.dao.LotteryUnionLottoDao;
import com.luwei6.lottery.model.LotteryUnionLottoDto;
import com.luwei6.utils.CollectionUtils;
import com.luwei6.utils.DateUtilBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        CollectionUtils.sortByProperties(list,"blueNumber");
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
        Map<String, Object> lotteryConfigMap = redisCacheServices.getLotteryConfig("lotteryConfig1");
        Integer nextLotteryPeriod = (Integer)lotteryConfigMap.get("lotteryPeriod") + 1 ;
        Date lotteryDate = DateUtilBase.string2Date((String)lotteryConfigMap.get("lotteryDate"),DateUtilBase.DATE_FORMAT_2);
        int week = DateUtilBase.getWeekOfDate(lotteryDate);
        Date nextLotteryDate = null;
        switch (week) {
            case 0:case 2:nextLotteryDate = DateUtilBase.dateOffsetCalc(2,lotteryDate,0, false); break;
            case 4:nextLotteryDate = DateUtilBase.dateOffsetCalc(3,lotteryDate,0, false); break;
        }
        initUnionLottoRedNumList();
        LotteryUnionLottoDto dto  = new LotteryUnionLottoDto();
        dto.setLotteryDate(nextLotteryDate);
        dto.setLotteryIssue(String.valueOf(nextLotteryPeriod));
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

}
