/**
 * Copyright 2010 ZTEsoft Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ZTEsoft Inc.
 * Use is subject to license terms.
 * 
 * $Tracker List
 * 
 * $TaskId: $ $Date: 9:24:36 AM (May 9, 2008) $comments: create 
 * $TaskId: $ $Date: 3:56:36 PM (SEP 13, 2010) $comments: upgrade jvm to jvm1.5 
 *  
 *  
 */
package com.luwei6.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * <p>
 * Title: ZSMART
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: ztesoft
 * </p>
 * 
 * @author chen.weizheng 鏀硅繘鑷猂97
 * @version 0.1
 */
public class DateUtilBase {

//    private static final ZSmartLogger logger = ZSmartLogger.getLogger(DateUtilBase.class);

    public static Date MAX_VALUE = offsetYear(getNowDate(), 100);

    // 鏃ユ湡绫诲瀷

    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";

    public static final String DATE_FORMAT_2 = "yyyyMMdd";

    public static final String DATETIME_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT_3 = "yyyy-MM-dd HH-mm-ss";

    public static final String DATETIME_FORMAT_2 = "yyyyMMddHHmmss";

    public static final String DATETIME_FORMAT_4 = "yyyy/MM/dd HH:mm:ss";

    public static final String DATETIME_FORMAT_5 = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATETIME_FORMAT_6 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_3 = "yyyy年MM月dd日";

    public static final int DIFFER_IN_SECOND = 0;

    public static final int DIFFER_IN_MINUTE = 1;

    public static final int DIFFER_IN_HOUR = 2;

    public static final int DIFFER_IN_DAYS = 3;

    public static final String DEFAULT_DATE_FORMAT = DATE_FORMAT_1;

    public static final String DEFAULT_TIME_FORMAT = DATETIME_FORMAT_1;

    public static final String NAME_FILE_DATE_FORMAT = "yyyyMMdd_HHmmss";

    public static final String[] DATE_FORMAT_SUPPORT = {
        DATETIME_FORMAT_1, DATETIME_FORMAT_2, DATETIME_FORMAT_3, DATETIME_FORMAT_4, DATE_FORMAT_1, DATE_FORMAT_2,
        DATE_FORMAT_3
    };

    public static SimpleDateFormat getDateFormat(String format) {
        /*
         * SimpleDateFormat sdf = (SimpleDateFormat) aDateFormateMap.get(format); if (sdf == null) { sdf = new
         * SimpleDateFormat(format); aDateFormateMap.put(format, sdf); }
         */
        return new SimpleDateFormat(format);
    }

    public static String date2String(Date date, String format) {
        if (date == null) {
            return "";
            // 如果为空，填入当前时间的代码取消。框架中不应含有这种带业务逻辑的代码。 zhang.nanyu commented the
            // code 2008-12-12
            // date = new Date();
        }
        SimpleDateFormat sdf = getDateFormat(format);
        return sdf.format(date);
    }

    public static String date2String(Date date) {
        return date2String(date, DEFAULT_DATE_FORMAT);
    }

    public static String getCurrentDate() {
        Date date = new Date();
        return date2String(date, DEFAULT_DATE_FORMAT);
    }

    public static String getNameFileCurrentDate() {
        Date date = new Date();
        return date2String(date, NAME_FILE_DATE_FORMAT);
    }

    /**
     * Date to SqlDate
     * 
     * @param date Date
     * @return Date
     */
    public static java.sql.Date dateToSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        else if (date instanceof java.sql.Date) {
            return (java.sql.Date) date;
        }
        else {
            return new java.sql.Date(date.getTime());
        }
    }

    public static java.sql.Date string2SQLDate(String date) {
        java.sql.Date ret = null;
        if (date == null || date.length() == 0) {
            return ret;
        }
        if (date.length() > 11) {
            if (date.indexOf('-') > 0) {
                if (date.indexOf(':') > 0) {
                    ret = string2SQLDate(date, DATETIME_FORMAT_1);
                }
                else {
                    ret = string2SQLDate(date, DATETIME_FORMAT_3);
                }
            }
            else if (date.indexOf('/') > 0) {
                ret = string2SQLDate(date, DATETIME_FORMAT_4);
            }
            else {
                ret = string2SQLDate(date, DATETIME_FORMAT_2);
            }
        }
        else {
            if (date.indexOf('-') > 0) {
                ret = string2SQLDate(date, DATE_FORMAT_1);
            }
            else if (date.length() == 8) {
                ret = string2SQLDate(date, DATE_FORMAT_2);
            }
            else {
                ret = string2SQLDate(date, DATE_FORMAT_3);
            }
        }
        return ret;
    }

    public static java.sql.Date string2SQLDate(String date, String format) {
        boolean isSucc = true;
        Exception operateException = null;
        if (!ValidateUtil.validateNotEmpty(format)) {
            isSucc = false;
            operateException = new IllegalArgumentException("the date format string is null!");
        }
        SimpleDateFormat sdf = getDateFormat(format);
        if (!ValidateUtil.validateNotNull(sdf)) {
            isSucc = false;
            operateException = new IllegalArgumentException(
                "the date format string is not matching available format object");
        }
        Date tmpDate = null;
        try {
            if (isSucc) {
                tmpDate = sdf.parse(date);
            }
        }
        catch (Exception e) {
            isSucc = false;
            operateException = e;
        }

        if (!isSucc) {
//            logger.error("the date string " + date + " is not matching format: " + format, operateException);
            if (operateException instanceof IllegalArgumentException) {
                throw (IllegalArgumentException) operateException;
            }
            else {
                throw new IllegalArgumentException("the date string " + date + " is not matching format: " + format
                    + ".\n cause by :" + operateException.toString());
            }
        }
        else {
            return new java.sql.Date(tmpDate.getTime());
        }
    }

    public static Date string2Date(String date) {
        Date ret = null;
        if (date == null || date.length() == 0) {
            return ret;
        }
        if (date.length() > 11) {
            if (date.indexOf('-') > 0) {
                if (date.indexOf(':') > 0) {
                    ret = string2Date(date, DATETIME_FORMAT_1);
                }
                else {
                    ret = string2Date(date, DATETIME_FORMAT_3);
                }
            }
            else if (date.indexOf('/') > 0) {
                ret = string2Date(date, DATETIME_FORMAT_4);
            }
            else {
                ret = string2Date(date, DATETIME_FORMAT_2);
            }
        }
        else {
            if (date.indexOf('-') > 0) {
                ret = string2Date(date, DATE_FORMAT_1);
            }
            else if (date.length() == 8) {
                ret = string2Date(date, DATE_FORMAT_2);
            }
            else {
                ret = string2Date(date, DATE_FORMAT_3);
            }
        }
        return ret;
    }

    public static Date string2Date(String date, String format) {
        if (!ValidateUtil.validateNotEmpty(format)) {
            throw new IllegalArgumentException("the date format string is null!");
        }
        SimpleDateFormat sdf = getDateFormat(format);
        if (!ValidateUtil.validateNotNull(sdf)) {
            throw new IllegalArgumentException("the date format string is not matching available format object");
        }
        try {
            return sdf.parse(date);
        }
        catch (ParseException e) {
            throw new IllegalArgumentException("the date string " + date + " is not matching format: " + format, e);
        }
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * 
     * @return
     */
    public static String getStandardNowTime() {
        SimpleDateFormat sdf = getDateFormat(DEFAULT_TIME_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * yyyy-MM-dd
     * 
     * @return java.sql.Date 锟斤拷前锟斤拷锟斤拷锟斤拷时锟斤拷
     */
    public static java.sql.Date getNowDate() {
        return new java.sql.Date(new Date().getTime());
    }

    /**
     * @param date Date 锟斤拷始时锟斤拷
     * @param seconds long
     * @return Date
     */
    public static java.sql.Date offsetSecond(java.sql.Date date, long seconds) {
        if (date == null) {
            return null;
        }
        // modified by chi.yuxing task(529008)
        long time = date.getTime();
        long time2 = time + (seconds * 1000);
        long time3 = time + (seconds * 1000) - 60 * 60 * 1000;
        java.sql.Date date2 = new java.sql.Date(time2);
        java.sql.Date date3 = new java.sql.Date(time3);

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        Calendar calendarDate2 = Calendar.getInstance();
        calendarDate2.setTime(date2);
        Calendar calendarDate3 = Calendar.getInstance();
        calendarDate3.setTime(date3);

        long dstDate = calendarDate.get(Calendar.DST_OFFSET);
        long dstDate2 = calendarDate2.get(Calendar.DST_OFFSET);
        long dstDate3 = calendarDate3.get(Calendar.DST_OFFSET);

        long dstOffset = dstDate - dstDate2;
        // 前后两个日期偏移相同（含不偏移）或者夏令日开始的那个小时不用补偿，否则要补偿偏移量。
        if (dstOffset == 0 || (dstDate2 - dstDate3 != 0 && dstDate2 != 0)) {
            return date2;
        }
        else {
            return new java.sql.Date(time2 + dstOffset);
        }
    }

    /**
     * @param date Date 锟斤拷始时锟斤拷
     * @return Date
     */
    public static java.sql.Date offsetMinute(java.sql.Date date, long minutes) {
        return offsetSecond(date, 60 * minutes);
    }

    /**
     * @param date Date 锟斤拷始时锟斤拷
     * @return Date
     */
    public static java.sql.Date offsetHour(java.sql.Date date, long hours) {
        return offsetMinute(date, 60 * hours);
    }

    /**
     * @param date Date 锟斤拷始时锟斤拷
     * @return Date
     */
    public static java.sql.Date offsetDay(java.sql.Date date, int days) {
        return offsetHour(date, 24 * days);
    }

    /**
     * @param date Date 锟斤拷始时锟斤拷
     * @return Date
     */
    public static java.sql.Date offsetWeek(java.sql.Date date, int weeks) {
        return offsetDay(date, 7 * weeks);
    }

    /**
     * @param date Date
     * @return Date
     */
    public static java.sql.Date getLastDayOfMonth(java.sql.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, maxDay);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    /**
     * 获取入参时间的当月1号零点零分零秒<br>
     * 
     * @param date Date
     * @return Date
     */
    public static java.sql.Date getBeginDayOfMonth(java.sql.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    /**
     * @param date1
     * @param months
     * @return
     */
    public static java.sql.Date offsetMonth(java.sql.Date date1, int months) {
        if (date1 == null) {
            return null;
        }

        java.sql.Date date = new java.sql.Date(date1.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, months);

        int newMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (curDay == maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);

        }
        else {
            if (curDay > newMaxDay) {
                calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);
            }
            else {
                calendar.set(Calendar.DAY_OF_MONTH, curDay);
            }
        }

        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    /**
     * @param date origrinal date
     * @param years offset years
     * @return offset date
     */
    public static java.sql.Date offsetYear(java.sql.Date date, int years) {
        if (date == null) {
            return null;
        }

        java.sql.Date newdate = (java.sql.Date) date.clone();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newdate);
        calendar.add(Calendar.YEAR, years);
        newdate.setTime(calendar.getTimeInMillis());
        return newdate;
    }

    /**
     * 杩斿洖涓や釜鏃ユ湡闂寸殑宸�
     * 
     * @param beginDate
     * @param endDate
     * @param returnType 杩斿洖鐨勫崟浣嶏細0:绉掞紝1锛氬垎锛�2灏忔椂锛�3锛氬ぉ
     * @return
     */
    public static long differDateInDays(java.sql.Date beginDate, java.sql.Date endDate, int returnType) {
        long begin = beginDate.getTime();
        long end = endDate.getTime();
        long surplus = begin - end;

        // begin --modified by chi.yuxing (task:529008)
        Calendar calendarBeginDate = Calendar.getInstance();
        calendarBeginDate.setTime(beginDate);

        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);

        long dstOffset = calendarBeginDate.get(Calendar.DST_OFFSET) - calendarEndDate.get(Calendar.DST_OFFSET);
        surplus += dstOffset;
        // end!

        long ret = 0;
        switch (returnType) {
            case 0:
                ret = surplus / 1000;
                break;
            case 1:
                ret = surplus / 1000 / 60;
                break;
            case 2:
                // 杩斿洖灏忔椂
                ret = surplus / 1000 / 60 / 60;
                break;
            case 3:
                ret = surplus / 1000 / 60 / 60 / 24;
                break;
            default:
                break;
        }

        return ret;
    }

    private static boolean isAsc(String firstStr, String secondStr) {
        return (firstStr.compareTo(secondStr) < 0);
    }

    /**
     * 锟斤拷鍒ゆ柇鏃ユ湡鏄惁鍦ㄦ寚瀹氳寖鍥村唴
     * 
     * @param date String 指锟斤拷时锟斤拷
     * @param beginDate String
     * @param endDate String
     * @return boolean 锟斤拷
     */
    public static boolean isInRange(String date, String beginDate, String endDate){
        if (!ValidateUtil.validateNotNull(date) || !ValidateUtil.validateNotNull(beginDate)
            || !ValidateUtil.validateNotNull(endDate)) {
//            ExceptionHandler.publish("");
        }

        int dateLen = date.length();
        int beginDateLen = date.length();
        int endDateLen = date.length();

        if (beginDateLen != dateLen || endDateLen != endDateLen) {
//            ExceptionHandler.publish("");
        }

        boolean asc = isAsc(beginDate, endDate);

        if (asc) {
            if (date.compareTo(beginDate) >= 0 && date.compareTo(endDate) <= 0) {
                return true;
            }
        }
        else {
            if (date.compareTo(beginDate) >= 0 || date.compareTo(endDate) <= 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * 锟斤拷锟藉垽鏂棩鏈熸槸鍚﹀湪鎸囧畾鑼冨洿鍐�
     * 
     * @param date Date
     * @param beginDate Date
     * @param endDate Date
     * @return boolean
     */
    public static boolean isInRange(Date date, Date beginDate, Date endDate) {
        long time = date.getTime();
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();

        return time >= beginTime && time <= endTime;
    }

    /**
     * 姣旇緝鏃ユ湡澶у皬锟绞憋拷锟饺较达拷小鍓嶅悗
     * 
     * @param beginDate Date 锟斤拷围锟斤拷始时锟斤拷
     * @param endDate Date 锟斤拷围锟斤拷锟斤拷时锟斤拷
     * @return boolean
     */
    public static int compare(Date beginDate, Date endDate) {
        int ret = 1;
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();

        if (beginTime > endTime) {
            ret = 2;
        }
        if (beginTime == endTime) {
            ret = 1;
        }
        if (beginTime < endTime) {
            ret = 0;
        }
        return ret;
    }

    /**
     * 返回某个时间的日期 zhang.nanyu added 2008-06-17
     * 
     * @param input
     * @return
     */
    public static java.sql.Date getFullDate(java.sql.Date input) {
        // 每天的毫秒数。(这种算法有时区的问题。)
        // final long dayMilSeconds = 1000*60*60*24;
        //
        // long milSeconds = input.getTime();
        //
        // long dateInMilSeconds = (milSeconds/dayMilSeconds)*dayMilSeconds;
        // System.out.println(dateInMilSeconds);
        // return new java.sql.Date(dateInMilSeconds);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(input);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        // System.out.println(calendar.getTimeInMillis());

        return new java.sql.Date(calendar.getTimeInMillis());

    }

    /**
     * 计算时间偏移
     * 
     * @param offset 偏移的值
     * @param dateTimeStr 具体的时间日期字符串
     * @param intout 是输入还是输出，如果是0表示输入，则在对应时间上加上偏移量返回，如果是1表示输出，则在对应时间上减去偏移量
     * @return
     */
    public static Date dateOffsetCalc(int offset, String dateTimeStr, int intout) {
        Date ret = string2Date(dateTimeStr);
        boolean hasTimeStr = false;
        if (dateTimeStr.length() > 11) {
            hasTimeStr = true;
        }
        else {
            hasTimeStr = false;
        }
        if (ret != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(ret);
            if (intout == 0) { // 表示是输入，加上偏移量
                if (hasTimeStr) {
                    cal.add(Calendar.SECOND, offset);
                }
                else {
                    cal.add(Calendar.DATE, offset);
                }
            }
            else {
                if (hasTimeStr) {
                    cal.add(Calendar.SECOND, (-1 * offset));
                }
                else {
                    cal.add(Calendar.DATE, (-1 * offset));
                }
            }
            ret = cal.getTime();
        }
        return ret;
    }/**
     * 计算时间偏移
     *
     * @param offset 偏移的值
     * @param date 具体的时间日期字符串
     * @param intout 是输入还是输出，如果是0表示输入，则在对应时间上加上偏移量返回，如果是1表示输出，则在对应时间上减去偏移量
     * @param  hasTimeStr true 偏移秒，false 偏移日
     * @return
     */
    public static Date dateOffsetCalc(int offset, Date date, int intout, boolean hasTimeStr) {
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if (intout == 0) { // 表示是输入，加上偏移量
                if (hasTimeStr) {
                    cal.add(Calendar.SECOND, offset);
                }
                else {
                    cal.add(Calendar.DATE, offset);
                }
            }
            else {
                if (hasTimeStr) {
                    cal.add(Calendar.SECOND, (-1 * offset));
                }
                else {
                    cal.add(Calendar.DATE, (-1 * offset));
                }
            }
            date = cal.getTime();
        }
        return date;
    }

    /**
     * 计算SqlDate的偏移量
     * 
     * @param offset
     * @param dateTimeStr
     * @param intout
     * @return
     */
    public static java.sql.Date sqlDateOffsetCalc(int offset, String dateTimeStr, int intout) {
        Date ret = dateOffsetCalc(offset, dateTimeStr, intout);
        if (ret != null) {
            return new java.sql.Date(ret.getTime());
        }
        return null;
    }

    /**
     * 获取传入日期时周几,周日返回0
     * @param date
     * @return
     */
    public static int getWeekOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }

}
