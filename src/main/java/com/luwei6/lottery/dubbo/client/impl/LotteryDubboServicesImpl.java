package com.luwei6.lottery.dubbo.client.impl;

import com.luwei6.lottery.cache.RedisCacheServices;
import com.luwei6.lottery.dubbo.client.LotteryDubboServices;
import com.luwei6.lottery.dubbo.client.model.StartLottoRequest;
import com.luwei6.lottery.dubbo.client.model.StartLottoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/7.
 */
public class LotteryDubboServicesImpl implements LotteryDubboServices{

    @Autowired
    private RedisCacheServices redisCacheServices;

    @Override
    public StartLottoResponse startLotto(StartLottoRequest startLottoRequest) {
        Map<String, Object> configMap = new HashMap<String, Object>();
        configMap.put("lotteryPeriod", 2018126);
        configMap.put("lotteryDate", "20181028");
        configMap.put("lotteryRedNum1", "01");
        configMap.put("lotteryRedNum2", "06");
        configMap.put("lotteryRedNum3", "08");
        configMap.put("lotteryRedNum4", "09");
        configMap.put("lotteryRedNum5", "19");
        configMap.put("lotteryRedNum6", "22");
        configMap.put("lotteryBlueNum", "05");
        redisCacheServices.setLotteryConfig("lotteryConfig1", configMap);
        return new StartLottoResponse();
    }
}
