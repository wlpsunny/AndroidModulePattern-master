package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * 时间工具类
 */
public class DateUtils {


    /**
     * compareToString
     * <p/>
     * 计算两个日期差输入天时分
     *
     * @param endTime  结束时间
     * @param starTime 开始时间
     * @return String DOM对象
     */
    public static final String compareToString(Date endTime, Date starTime) {
        // 两时间差,精确到毫秒
        long diff = endTime.getTime() - starTime.getTime();
        long day = diff / 86400000; // 以天数为单位取整
        long hour = diff % 86400000 / 3600000; // 以小时为单位取整
        long min = diff % 86400000 % 3600000 / 60000; // 以分钟为单位取整
        // 天时分秒
        return day + "天" + hour + "小时" + min + "分";
    }

    /**
     * @param endTime
     * @param starTime
     * @return long[时，分，秒]
     * @Description 计算两个日期相差的时分秒
     * @author guo_yfang
     * @date 2015年11月12日 下午3:45:29
     */
    public static final long[] compareToLong(Date starTime, Date endTime) {
        if (endTime == null || starTime == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        long timestamp = endTime.getTime() - starTime.getTime();
        if (timestamp <= 0) {
            return new long[]{0, 0, 0};
        }
        long timeseconds = timestamp / 1000;
        Integer day = (int) (timeseconds / (24 * 60 * 60));
        Integer hour = (int) (timeseconds / (60 * 60) - day * 24);
        long min = ((timeseconds / (60)) - day * 24 * 60 - hour * 60);
        long s = (timeseconds - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        // String str = new String(day + "天" + hour + "小时" + min + "分" + s + "秒");
        // System.out.println(str);
        hour += day * 24;
        return new long[]{hour, min, s};
    }

    /**
     * 获得当前系统时间
     *
     * @return Date
     * @author mshi
     */
    public static final Date getCurrentTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 获得当前系统时间 格式 yyyy-MM-dd
     *
     * @return Date
     * @author mshi
     */
    public static final Date getCurrentDate() {
        return getDateIgnoreTime(Calendar.getInstance().getTime());
    }

    /**
     * 获取时间上下间隔
     *
     * @param baseDate
     * @return Date[]
     * @author mshi
     */
    public static final Date[] getDifferenceDate(Date baseDate) {
        Date[] date = new Date[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date[0] = cal.getTime();
        cal.add(Calendar.DATE, 1);
        date[1] = cal.getTime();
        return date;
    }

    /**
     * 将时间的时分秒毫秒归零
     *
     * @param baseDate
     * @return Date
     * @author mshi
     */
    public static final Date getDateIgnoreTime(Date baseDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(baseDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 比较两个日期差,精确到天
     *
     * @param date1
     * @param date2
     * @return int
     * @author mshi
     */
    public static final int compareByDate(Date date1, Date date2) {
        int num = getDaysBetweenDates(date1, date2);
        if (num > 0)
            return 1;
        else if (num < 0)
            return -1;
        else if (num == 0)
            return 0;
        return num;
    }

    /**
     * 两个日期比较,精确到秒
     *
     * @param date1
     * @param date2
     * @return int
     * @author mshi
     */
    public static final int compareByDateTime(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        TimeZone timeZone = TimeZone.getDefault();
        long beginOffset = timeZone.getRawOffset();
        long endOffset = beginOffset;
        if (timeZone.inDaylightTime(date1))
            beginOffset += timeZone.getDSTSavings();
        if (timeZone.inDaylightTime(date2))
            endOffset += timeZone.getDSTSavings();
        long milli1 = (date1.getTime() + beginOffset) / 1000;
        long milli2 = (date2.getTime() + endOffset) / 1000;
        int retVal = 0;
        if (milli1 > milli2) {
            retVal = 1;
        } else if (milli1 < milli2) {
            retVal = -1;
        }
        return retVal;
    }

    /**
     * 获得两个日期差几天,精确到秒
     *
     * @param date1
     * @param date2
     * @return int
     * @author mshi
     */
    public static final long compareByDateTimeSecond(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        TimeZone timeZone = TimeZone.getDefault();
        long beginOffset = timeZone.getRawOffset();
        long endOffset = beginOffset;
        if (timeZone.inDaylightTime(date1))
            beginOffset += timeZone.getDSTSavings();
        if (timeZone.inDaylightTime(date2))
            endOffset += timeZone.getDSTSavings();
        long milli1 = (date1.getTime() + beginOffset) / 1000;
        long milli2 = (date2.getTime() + endOffset) / 1000;
        long retVal = milli1 - milli2;
        return retVal;
    }


    /**
     * 获得两个日期差几天,精确到毫秒
     *
     * @param date1
     * @param date2
     * @return int
     * @author mshi
     */
    public static final int compareByTimestamp(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        TimeZone timeZone = TimeZone.getDefault();
        long beginOffset = timeZone.getRawOffset();
        long endOffset = beginOffset;
        if (timeZone.inDaylightTime(date1))
            beginOffset += timeZone.getDSTSavings();
        if (timeZone.inDaylightTime(date2))
            endOffset += timeZone.getDSTSavings();
        long milli1 = date1.getTime() + beginOffset;
        long milli2 = date2.getTime() + endOffset;
        int retVal = 0;
        if (milli1 > milli2) {
            retVal = 1;
        } else if (milli1 < milli2) {
            retVal = -1;
        }
        return retVal;
    }

    /**
     * 获得两个日期差几天
     *
     * @param endDate
     * @param beginDate
     * @return int
     * @author mshi
     */
    public static final int getDaysBetweenDates(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        return (getDaysBetweenDates((TimeZone) null, endDate, beginDate));
    }

    /**
     * 获得两个日期差几天
     *
     * @param timeZone
     * @param endDate
     * @param beginDate
     * @return int
     * @author mshi
     */
    public static final int getDaysBetweenDates(TimeZone timeZone, Date endDate, Date beginDate) {
        if (beginDate == null || endDate == null)
            throw new IllegalArgumentException("Date cannot be null.");
        if (timeZone == null)
            timeZone = TimeZone.getDefault();
        long beginOffset = timeZone.getRawOffset();
        long endOffset = beginOffset;
        if (timeZone.inDaylightTime(beginDate))
            beginOffset += timeZone.getDSTSavings();
        if (timeZone.inDaylightTime(endDate))
            endOffset += timeZone.getDSTSavings();
        long endDays = (long) ((endDate.getTime() + endOffset) / 86400000L);
        long beginDays = (long) ((beginDate.getTime() + beginOffset) / 86400000L);
        return ((int) (endDays - beginDays));
    }

    public static final String getTimesBetweenDates(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        long timestamp = endDate.getTime() - beginDate.getTime();
        if (timestamp <= 0) {
            return null;
        }
        long timeseconds = timestamp / 1000;
        Integer day = (int) (timeseconds / (24 * 60 * 60));
        Integer hour = (int) (timeseconds / (60 * 60) - day * 24);
        long min = ((timeseconds / (60)) - day * 24 * 60 - hour * 60);
        long s = (timeseconds - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String str = new String(day + "天" + hour + "小时" + min + "分" + s + "秒");
        return str;
    }

    public static final Long getSecondsBetweenDates(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        long timestamp = endDate.getTime() - beginDate.getTime();
        if (timestamp <= 0) {
            return null;
        }
        long timeseconds = timestamp / 1000;
        return timeseconds;
    }

    /**
     * 获取两个日期的半小时差值
     *
     * @author oliver
     * @time 2015年3月19日 下午7:14:56
     */
    public static final long getHalfHoursBetweenDates(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        long timestamp = endDate.getTime() - beginDate.getTime();
        long timeseconds = timestamp / 1000;
        long halfHour = (int) Math.floor((double) timeseconds / (30 * 60));
        return halfHour;
    }

    public static final Integer getMonthsBetweenDates(Date endDate, Date beginDate) {
        if (endDate == null || beginDate == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        long timestamp = endDate.getTime() - beginDate.getTime();
        if (timestamp <= 0) {
            return -1;
        }
        int monthEnd = getMonth(endDate);
        int monthBegin = getMonth(beginDate);
        int dayEnd = getDay(endDate);
        int dayStart = getDay(beginDate);
        int yearEnd = getYear(endDate);
        int yearStart = getYear(beginDate);
        int monthFlag = 0;
        monthFlag = dayEnd - dayStart >= 0 ? 1 : 0;
        int tempMonthBetween = (monthEnd - monthBegin) + (yearEnd - yearStart) * 12;
        if (1 > monthFlag) {
            Date newDate = DateUtils.add(beginDate, Calendar.MONTH, tempMonthBetween);
            monthFlag = getDay(newDate) == getDay(endDate) ? 1 : 0;
        }

        return tempMonthBetween + monthFlag;
    }

    /**
     * 获得年份
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getYear(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.YEAR);
    }

    /**
     * 获得月份
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getMonth(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.MONTH) + 1;
    }

    /**
     * 获得天数
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getDay(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获得小时
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getHour(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.HOUR_OF_DAY);
    }

    /**
     * 获得分钟
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getMinute(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.MINUTE);
    }

    /**
     * 获得秒
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getSecond(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.SECOND);
    }

    /**
     * 获得毫秒
     *
     * @param date
     * @return int
     * @author mshi
     */
    public static final int getMilliSecond(Date date) {
        if (date == null)
            return 0;
        return getCalendarField(date, Calendar.MILLISECOND);
    }

    /**
     * 返回给定日历字段的值
     *
     * @param date
     * @param field
     * @return int
     * @author mshi
     */
    public static final int getCalendarField(Date date, int field) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(field);
    }

    /**
     * 添加或减去指定的时间量,按年
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addYear(Date date, int value) {
        return add(date, Calendar.YEAR, value);
    }

    /**
     * 添加或减去指定的时间量,按月
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addMonth(Date date, int value) {
        return add(date, Calendar.MONTH, value);
    }

    /**
     * 添加或减去指定的时间量,按日
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addDay(Date date, int value) {
        return add(date, Calendar.DAY_OF_MONTH, value);
    }

    /**
     * 添加或减去指定的时间量,按小时
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addHour(Date date, int value) {
        return add(date, Calendar.HOUR_OF_DAY, value);
    }

    /**
     * 添加或减去指定的时间量,按分钟
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addMinute(Date date, int value) {
        return add(date, Calendar.MINUTE, value);
    }

    /**
     * 添加或减去指定的时间量,按秒
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addSecond(Date date, int value) {
        return add(date, Calendar.SECOND, value);
    }

    /**
     * 添加或减去指定的时间量,按毫秒
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date addMilliSecond(Date date, int value) {
        return add(date, Calendar.MILLISECOND, value);
    }

    /**
     * 添加或减去指定的时间量
     *
     * @param date
     * @param field
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date add(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, value);
        return cal.getTime();
    }

    /**
     * 设置当前分秒为0
     *
     * @param date
     * @return Date
     * @author mshi
     */
    public static final String getNowHourString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        String str = formatTime24(cal.getTime());
        return str;
    }

    /**
     * 设置指定的时间量,按年
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setYear(Date date, int value) {
        return set(date, Calendar.YEAR, value);
    }

    /**
     * 设置指定的时间量,按月
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setMonth(Date date, int value) {
        return set(date, Calendar.MONTH, value);
    }

    /**
     * 设置指定的时间量,按日
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setDay(Date date, int value) {
        return set(date, Calendar.DAY_OF_MONTH, value);
    }

    /**
     * 设置指定的时间量,按小时
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setHour(Date date, int value) {
        return set(date, Calendar.HOUR_OF_DAY, value);
    }

    /**
     * 设置指定的时间量,按分钟
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setMinute(Date date, int value) {
        return set(date, Calendar.MINUTE, value);
    }

    /**
     * 设置指定的时间量,按秒
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setSecond(Date date, int value) {
        return set(date, Calendar.SECOND, value);
    }

    /**
     * 设置指定的时间量,按毫秒
     *
     * @param date
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date setMilliSecond(Date date, int value) {
        return set(date, Calendar.MILLISECOND, value);
    }

    /**
     * 设置指定的时间量
     *
     * @param date
     * @param field
     * @param value
     * @return Date
     * @author mshi
     */
    public static final Date set(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(field, value);
        return cal.getTime();
    }

    /**
     * 设置日期为当月的最后一天
     *
     * @param date
     * @return Date
     * @author mshi
     */
    public static final Date lastDate(Date date) {
        return addDay(addMonth(setDay(date, 1), 1), -1);
    }

    /**
     * 设置日期为当月的第一天
     *
     * @param date
     * @return Date
     * @author mshi
     */
    public static final Date firstDate(Date date) {
        return setDay(date, 1);
    }

    /**
     * 是否是当月最后一天
     *
     * @param date
     * @return boolean
     * @author mshi
     */
    public static final boolean isLastDate(Date date) {
        Date _date = date;
        Date lastDate = lastDate(_date);
        if (compareByDate(date, lastDate) == 0) {
            return true;
        }
        return false;
    }

//    public static Date parse(String aValue, SimpleDateFormat aFormat) throws ParseException {
//        if (StringUtil.isEmpty(aValue) || aFormat == null) {
//            return null;
//        }
//
//        return aFormat.parse(aValue);
//    }

    /**
     * 是否是当月第一天
     *
     * @param date
     * @return boolean
     * @author mshi
     */
    public static final boolean isFirstDate(Date date) {
        Date _date = date;
        Date firstDate = firstDate(_date);
        if (compareByDate(date, firstDate) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否是同一天
     *
     * @return boolean
     * @author mshi
     */
    public static final boolean isSameDate(Date date1, Date date2) {
        if (compareByDate(getDateIgnoreTime(date1), getDateIgnoreTime(date2)) == 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据指定格式格式化时间
     *
     * @param date
     * @param fmtString
     * @return String
     * @author mshi
     */
    public static final String format(Date date, String fmtString) {
        if (date == null) {
            return "";
        }
        DateFormat format = new SimpleDateFormat(fmtString);
        return format.format(date);
    }

    /**
     * 格式格式化时间("yyyy-MM-dd")
     *
     * @param date
     * @return String
     * @author mshi
     */
    public static final String formatDate(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 格式格式化时间("yyyy-MM-dd hh:mm:ss")
     *
     * @param date
     * @return String
     * @author mshi
     */
    public static final String formatTime(Date date) {
        return format(date, "yyyy-MM-dd hh:mm:ss");
    }

    public static final String formatTime24(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static final String formatTimeHMS24(Date date) {
        return format(date, "yyyy-MM-ddHHmmss");
    }

    public static final String formatMDHM24(Date date) {
        return format(date, "MM-dd HH:mm");
    }

    public static final String formatHM24(Date date) {
        return format(date, "HH:mm");
    }

    /**
     * 根据指定格式解析时间
     *
     * @param dateString
     * @param fmtString
     * @return Date
     * @author mshi
     */
    public static final Date parse(String dateString, String fmtString) {
        Date date = null;
        try {
            DateFormat format = new SimpleDateFormat(fmtString);
            date = format.parse(dateString);
        } catch (ParseException e) {

        }
        return date;
    }

    /**
     * 解析时间("yyyy-MM-dd")
     *
     * @param dateString
     * @return Date
     * @author mshi
     */
    public static final Date parseDate(String dateString) {
        return parse(dateString, "yyyy-MM-dd");
    }

    /**
     * 解析时间("yyyy-MM")
     *
     * @param dateString
     * @return Date
     * @author mshi
     */
    public static final Date parseDateMonth(String dateString) {
        return parse(dateString, "yyyy-MM");
    }

    /**
     * 解析时间("yyyy-MM-dd hh:mm:ss")
     *
     * @param dateString
     * @return Date
     * @author mshi
     */
    public static final Date parseTime(String dateString) {
        return parse(dateString, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 解析时间("yyyy-MM-dd hh:mm:ss")
     *
     * @return Date
     * @author mshi
     */
    public static final Date endOfDay(Date date) {
        date = set(date, Calendar.HOUR_OF_DAY, 23);
        date = set(date, Calendar.MINUTE, 59);
        return date;
    }

    /**
     * 获得两个时间之间的分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static final int getDistanceMin(Date date1, Date date2) {
        Long min = 0l;
        Long time1 = date1.getTime();
        Long time2 = date2.getTime();
        if (time1 < time2) {
            min = time2 / (60 * 1000) - time1 / (60 * 1000);
        } else {
            min = time1 / (60 * 1000) - time2 / (60 * 1000);
        }
        return min.intValue();
    }

    /***
     * 得到前一天的当前时刻
     *
     * @return add by jannal 2014年12月15日
     */
    public static final String getYesterDay(String format) {
        Calendar calendar = Calendar.getInstance();// 此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, -1); // 得到前一天
        String yestedayDate = new SimpleDateFormat(format).format(calendar.getTime());
        return yestedayDate;
    }

    /**
     * 得到前一天的当前时刻 yyyy-MM-dd
     *
     * @return add by jannal 2014年12月15日
     */
    public static final String getYesterDayDefalutFormatt() {
        return getYesterDay("yyyy-MM-dd");
    }

    /**
     * 得到当前的yyyy-MM-dd
     *
     * @return add by jannal 2014年12月16日
     */
    public static final String getCurrentDayDefalutFormatt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    /**
     * 得到当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static final String getCurrentDayTime24Formatt() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    /***
     * 指定的格式获取日期
     *
     * @param formatt
     * @return add by jannal 2014年12月25日
     */
    public static final String getDateForFormat(String formatt) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatt);
        return sdf.format(new Date());
    }

    public static final String getDateForFormat(Date date, String formatt) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatt);
        return sdf.format(date);
    }

    /***
     * 比较目标日期是否在两个日期之间
     *
     * @param startDate
     * @param endDate
     * @param goalDate
     * @return add by jannal 2014年12月25日
     */
    public static boolean dateInterval(Date startDate, Date endDate, Date goalDate) {
        int flag = DateUtils.compareByTimestamp(startDate, endDate);// startDate小于endDate 返回-1
        int start = DateUtils.compareByTimestamp(goalDate, startDate);// 第一个大于第二个返回1 否则返回-1 相等返回0
        int end = DateUtils.compareByTimestamp(goalDate, endDate);
        if (flag == -1 && start == 1 && end == -1) {
            return true;
        }
        return false;
    }

    /**
     * 返回间隔时间millioss
     *
     * @author oliver
     * @time 2015年2月10日 下午4:39:02
     */
    public static Long betweenMillions(String startTime, String endTime) {
        Long startMillioss = DateUtils.parseTime(startTime).getTime();
        Long endMillions = DateUtils.parseTime(endTime).getTime();
        Long between = endMillions - startMillioss;
        return between;
    }

    /**
     * 时间是否是当日
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        long currentTime = new Date().getTime();
        return currentTime - date.getTime() < 86400000;// 1000* 60 * 60 *24
    }

    /**
     * 获取下月第一天
     */
    public static Date getNextMonthFirstDay() {
        Date today = new Date();
        Date nextMonth = addMonth(today, 1);
        return getDateIgnoreTime(DateUtils.firstDate(nextMonth));
    }

    /**
     * 获取星期几
     *
     * @param date
     * @return
     */

    public static int getWeekOfDate(Date date) {

        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }


    public static long compareTimeTo(String dateStr1, String dateStr2, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            return sdf.parse(dateStr1).getTime() - sdf.parse(dateStr2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 近几个月，从当月1号开始
     *
     * @param value
     * @return
     */
    public static final Date addMonth2(int value) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.MONTH, value);
        return cal.getTime();
    }

    /**
     * 获取今天的时间范围
     *
     * @return 返回长度为2的字符串集合，如：[2017-11-03 00:00:00, 2017-11-03 24:00:00]
     */
    public static List<String> getTodayRange() {
        List<String> dataList = new ArrayList<>(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.DATE, 0);
        String today = dateFormat.format(calendar.getTime());
        dataList.add(today);
        dataList.add(today);
        return dataList;
    }

    /**
     * 获取昨天的时间范围
     *
     * @return 返回长度为2的字符串集合，如：[2017-11-02 00:00:00, 2017-11-02 24:00:00]
     */
    public static List<String> getYesterdayRange() {
        List<String> dataList = new ArrayList<>(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.DATE, -1);
        String yesterday = dateFormat.format(calendar.getTime());
        dataList.add(yesterday);
        dataList.add(yesterday);
        return dataList;
    }

    /**
     * 获取本周的时间范围
     *
     * @return 返回长度为2的字符串集合，如：[2017-10-30 00:00:00, 2017-11-05 24:00:00]
     */
//    public static List<String> getCurrentWeekRange() {
//        List<String> dataList = new ArrayList<>(2);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        String monday = dateFormat.format(calendar.getTime()) + " 00:00:00";
//        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        String sunday = dateFormat.format(calendar.getTime()) + " 24:00:00";
//        dataList.add(monday);
//        dataList.add(sunday);
//        return dataList;
//    }

    /**
     * 获取本周的时间范围(不带时分秒)
     *
     * @return 返回长度为2的字符串集合，如：[2017-10-30, 2017-11-05]
     */
    public static List<String> getCurrentWeekRangeNoTime() {
        List<String> dataList = new ArrayList<>(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置周一为一周之内的第一天
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        String monday = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sunday = dateFormat.format(calendar.getTime());
        dataList.add(monday);
        dataList.add(sunday);
        return dataList;
    }

    /**
     * 获取本月的时间范围
     *
     * @return 返回长度为2的字符串集合，如：[2017-11-01 00:00:00, 2017-11-30 24:00:00]
     */
    public static List<String> getCurrentMonthRange() {
        List<String> dataList = new ArrayList<>(2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String firstDayOfMonth = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        String lastDayOfMonth = dateFormat.format(calendar.getTime());
        dataList.add(firstDayOfMonth);
        dataList.add(lastDayOfMonth);
        return dataList;
    }

}
