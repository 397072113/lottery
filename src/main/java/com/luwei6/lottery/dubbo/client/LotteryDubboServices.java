package com.luwei6.lottery.dubbo.client;

import com.luwei6.lottery.dubbo.client.model.StartLottoRequest;
import com.luwei6.lottery.dubbo.client.model.StartLottoResponse;

/**
 * Created by Administrator on 2018/11/7.
 */
public interface LotteryDubboServices {

    /**
     * 开奖接口
     */
    public StartLottoResponse startLotto(StartLottoRequest startLottoRequest);
}
