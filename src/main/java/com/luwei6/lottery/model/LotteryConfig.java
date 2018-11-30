package com.luwei6.lottery.model;

import java.util.Date;

/**
 * Created by Administrator on 2018/10/30.
 */
public class LotteryConfig {
    private Integer lotteryPeriod;
    private Date lotteryDate;
    private String lotteryRedNum1;
    private String lotteryRedNum2;
    private String lotteryRedNum3;
    private String lotteryRedNum4;
    private String lotteryRedNum5;
    private String lotteryRedNum6;

    @Override
    public String toString() {
        return "LotteryConfig{" +
                "lotteryPeriod=" + lotteryPeriod +
                ", lotteryDate=" + lotteryDate +
                ", lotteryRedNum1='" + lotteryRedNum1 + '\'' +
                ", lotteryRedNum2='" + lotteryRedNum2 + '\'' +
                ", lotteryRedNum3='" + lotteryRedNum3 + '\'' +
                ", lotteryRedNum4='" + lotteryRedNum4 + '\'' +
                ", lotteryRedNum5='" + lotteryRedNum5 + '\'' +
                ", lotteryRedNum6='" + lotteryRedNum6 + '\'' +
                ", lotteryBlueNum='" + lotteryBlueNum + '\'' +
                '}';
    }

    private String lotteryBlueNum;

    public Integer getLotteryPeriod() {
        return lotteryPeriod;
    }

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public String getLotteryRedNum1() {
        return lotteryRedNum1;
    }

    public String getLotteryRedNum2() {
        return lotteryRedNum2;
    }

    public String getLotteryRedNum3() {
        return lotteryRedNum3;
    }

    public String getLotteryRedNum4() {
        return lotteryRedNum4;
    }

    public String getLotteryRedNum5() {
        return lotteryRedNum5;
    }

    public String getLotteryRedNum6() {
        return lotteryRedNum6;
    }

    public String getLotteryBlueNum() {
        return lotteryBlueNum;
    }

    public void setLotteryPeriod(Integer lotteryPeriod) {

        this.lotteryPeriod = lotteryPeriod;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public void setLotteryRedNum1(String lotteryRedNum1) {
        this.lotteryRedNum1 = lotteryRedNum1;
    }

    public void setLotteryRedNum2(String lotteryRedNum2) {
        this.lotteryRedNum2 = lotteryRedNum2;
    }

    public void setLotteryRedNum3(String lotteryRedNum3) {
        this.lotteryRedNum3 = lotteryRedNum3;
    }

    public void setLotteryRedNum4(String lotteryRedNum4) {
        this.lotteryRedNum4 = lotteryRedNum4;
    }

    public void setLotteryRedNum5(String lotteryRedNum5) {
        this.lotteryRedNum5 = lotteryRedNum5;
    }

    public void setLotteryRedNum6(String lotteryRedNum6) {
        this.lotteryRedNum6 = lotteryRedNum6;
    }

    public void setLotteryBlueNum(String lotteryBlueNum) {
        this.lotteryBlueNum = lotteryBlueNum;
    }
}
