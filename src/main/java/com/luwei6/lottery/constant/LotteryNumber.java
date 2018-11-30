package com.luwei6.lottery.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/26.
 */
public class LotteryNumber {
    public static List<Long> unionLottoRedNumList = new ArrayList<Long>();
    private static List<Long> unionLottoBlueNumList = new ArrayList<Long>();
    static {

    }

    private void initUnionLottoRedNumList() {
        for(int i=1; i<=33 ;i++) {
            unionLottoRedNumList.add(Long.valueOf(i));
        }
    }
    private void initUnionLottoBlueNumList() {
        for(int i=1; i<=16 ;i++) {
            unionLottoRedNumList.add(Long.valueOf(i));
        }
    }
}
