package com.luwei6.lottery.model;

import java.util.Date;

public class LotteryCycleDto {

    private String cycleCode;

    private Integer lotteryCycleTypeId;

    private Date cycleBeginDate;

    private Date cycleEndDate;

    private Long curNumber;

    private String state;

    private Long totalCount;

    private Long winCount;

    private Long pressCount;

    private Long pressWinCount;

    private String number1;

    private String number2;

    public String getCycleCode() {
        return cycleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.CYCLE_CODE
     *
     * @param cycleCode the value for LOTTERY_CYCLE.CYCLE_CODE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setCycleCode(String cycleCode) {
        this.cycleCode = cycleCode == null ? null : cycleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.LOTTERY_CYCLE_TYPE_ID
     *
     * @return the value of LOTTERY_CYCLE.LOTTERY_CYCLE_TYPE_ID
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Integer getLotteryCycleTypeId() {
        return lotteryCycleTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.LOTTERY_CYCLE_TYPE_ID
     *
     * @param lotteryCycleTypeId the value for LOTTERY_CYCLE.LOTTERY_CYCLE_TYPE_ID
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setLotteryCycleTypeId(Integer lotteryCycleTypeId) {
        this.lotteryCycleTypeId = lotteryCycleTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.CYCLE_BEGIN_DATE
     *
     * @return the value of LOTTERY_CYCLE.CYCLE_BEGIN_DATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Date getCycleBeginDate() {
        return cycleBeginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.CYCLE_BEGIN_DATE
     *
     * @param cycleBeginDate the value for LOTTERY_CYCLE.CYCLE_BEGIN_DATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setCycleBeginDate(Date cycleBeginDate) {
        this.cycleBeginDate = cycleBeginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.CYCLE_END_DATE
     *
     * @return the value of LOTTERY_CYCLE.CYCLE_END_DATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Date getCycleEndDate() {
        return cycleEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.CYCLE_END_DATE
     *
     * @param cycleEndDate the value for LOTTERY_CYCLE.CYCLE_END_DATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setCycleEndDate(Date cycleEndDate) {
        this.cycleEndDate = cycleEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.CUR_NUMBER
     *
     * @return the value of LOTTERY_CYCLE.CUR_NUMBER
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Long getCurNumber() {
        return curNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.CUR_NUMBER
     *
     * @param curNumber the value for LOTTERY_CYCLE.CUR_NUMBER
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setCurNumber(Long curNumber) {
        this.curNumber = curNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.STATE
     *
     * @return the value of LOTTERY_CYCLE.STATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.STATE
     *
     * @param state the value for LOTTERY_CYCLE.STATE
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.TOTAL_COUNT
     *
     * @return the value of LOTTERY_CYCLE.TOTAL_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.TOTAL_COUNT
     *
     * @param totalCount the value for LOTTERY_CYCLE.TOTAL_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.WIN_COUNT
     *
     * @return the value of LOTTERY_CYCLE.WIN_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Long getWinCount() {
        return winCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.WIN_COUNT
     *
     * @param winCount the value for LOTTERY_CYCLE.WIN_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setWinCount(Long winCount) {
        this.winCount = winCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.PRESS_COUNT
     *
     * @return the value of LOTTERY_CYCLE.PRESS_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Long getPressCount() {
        return pressCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.PRESS_COUNT
     *
     * @param pressCount the value for LOTTERY_CYCLE.PRESS_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setPressCount(Long pressCount) {
        this.pressCount = pressCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column LOTTERY_CYCLE.PRESS_WIN_COUNT
     *
     * @return the value of LOTTERY_CYCLE.PRESS_WIN_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public Long getPressWinCount() {
        return pressWinCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column LOTTERY_CYCLE.PRESS_WIN_COUNT
     *
     * @param pressWinCount the value for LOTTERY_CYCLE.PRESS_WIN_COUNT
     *
     * @mbg.generated Thu Dec 12 14:28:03 CST 2019
     */
    public void setPressWinCount(Long pressWinCount) {
        this.pressWinCount = pressWinCount;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }
}