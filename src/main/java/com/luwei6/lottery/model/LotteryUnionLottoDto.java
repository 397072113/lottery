package com.luwei6.lottery.model;

import java.util.Date;

public class LotteryUnionLottoDto {

    private Integer luckyNumberId;

    private Date lotteryDate;

    private String lotteryIssue;

    private Integer lotteryType;

    private Long redNumber1;

    private String redNumber1Status;

    private Long redNumber2;

    private String redNumber2Status;

    private Long redNumber3;

    private String redNumber3Status;

    private Long redNumber4;

    private String redNumber4Status;

    private Long redNumber5;

    private String redNumber5Status;

    private Long redNumber6;

    private String redNumber6Status;

    private Long blueNumber;

    private String blueNumberStatus;

    private Long partId;

    private Long pressWinCount;

    public Integer getLuckyNumberId() {
        return luckyNumberId;
    }

    public void setLuckyNumberId(Integer luckyNumberId) {
        this.luckyNumberId = luckyNumberId;
    }

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public String getLotteryIssue() {
        return lotteryIssue;
    }

    public void setLotteryIssue(String lotteryIssue) {
        this.lotteryIssue = lotteryIssue == null ? null : lotteryIssue.trim();
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Long getRedNumber1() {
        return redNumber1;
    }

    public void setRedNumber1(Long redNumber1) {
        this.redNumber1 = redNumber1;
    }

    public String getRedNumber1Status() {
        return redNumber1Status;
    }

    public void setRedNumber1Status(String redNumber1Status) {
        this.redNumber1Status = redNumber1Status == null ? null : redNumber1Status.trim();
    }

    public Long getRedNumber2() {
        return redNumber2;
    }

    public void setRedNumber2(Long redNumber2) {
        this.redNumber2 = redNumber2;
    }

    public String getRedNumber2Status() {
        return redNumber2Status;
    }


    public void setRedNumber2Status(String redNumber2Status) {
        this.redNumber2Status = redNumber2Status == null ? null : redNumber2Status.trim();
    }

    public Long getRedNumber3() {
        return redNumber3;
    }


    public void setRedNumber3(Long redNumber3) {
        this.redNumber3 = redNumber3;
    }

    public String getRedNumber3Status() {
        return redNumber3Status;
    }

    public void setRedNumber3Status(String redNumber3Status) {
        this.redNumber3Status = redNumber3Status == null ? null : redNumber3Status.trim();
    }

    public Long getRedNumber4() {
        return redNumber4;
    }

    public void setRedNumber4(Long redNumber4) {
        this.redNumber4 = redNumber4;
    }

    public String getRedNumber4Status() {
        return redNumber4Status;
    }

    public void setRedNumber4Status(String redNumber4Status) {
        this.redNumber4Status = redNumber4Status == null ? null : redNumber4Status.trim();
    }

    public Long getRedNumber5() {
        return redNumber5;
    }

    public void setRedNumber5(Long redNumber5) {
        this.redNumber5 = redNumber5;
    }

    public String getRedNumber5Status() {
        return redNumber5Status;
    }

    public void setRedNumber5Status(String redNumber5Status) {
        this.redNumber5Status = redNumber5Status == null ? null : redNumber5Status.trim();
    }

    public Long getRedNumber6() {
        return redNumber6;
    }

    public void setRedNumber6(Long redNumber6) {
        this.redNumber6 = redNumber6;
    }

    public String getRedNumber6Status() {
        return redNumber6Status;
    }

    public void setRedNumber6Status(String redNumber6Status) {
        this.redNumber6Status = redNumber6Status == null ? null : redNumber6Status.trim();
    }

    public Long getBlueNumber() {
        return blueNumber;
    }

    public void setBlueNumber(Long blueNumber) {
        this.blueNumber = blueNumber;
    }

    public String getBlueNumberStatus() {
        return blueNumberStatus;
    }

    public void setBlueNumberStatus(String blueNumberStatus) {
        this.blueNumberStatus = blueNumberStatus == null ? null : blueNumberStatus.trim();
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getPressWinCount() {
        return pressWinCount;
    }

    public void setPressWinCount(Long pressWinCount) {
        this.pressWinCount = pressWinCount;
    }
}