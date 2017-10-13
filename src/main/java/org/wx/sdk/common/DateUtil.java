package org.wx.sdk.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 与时间日期相关的工具类
 * @version 2013-05-17
 */
public class DateUtil {
    /** 日志对象 */
    private static final Logger logger = Logger.getLogger(DateUtil.class.getName());
    /** 时间格式 yyyy-MM-dd HH:mm:ss */
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /** 时间格式 yyyy-MM-dd */
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    /** 时间格式 yyyy/MM/dd HH:mm:ss */
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /** 时间格式 yyyy/MM/dd */
    private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy/MM/dd");
    /** 时间格式 yyyy-MM-dd HH:mm */
    private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /** 时间格式 yyyy/MM/dd HH:mm */
    private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    /** 时间格式 yyyyMMdd */
    private static final SimpleDateFormat sdf7 = new SimpleDateFormat("yyyyMMdd");
    /** 时间格式 yyyy-MM-dd HH:mm, Locale.CHINESE*/
    private static final SimpleDateFormat sdf8 =  new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.CHINESE);
    
    /**
     * 正则表达示解析
     * @param str 日期字符串
     * @return 日期{@link Date}
     */
    public static Date parse(String str) {
        Date date = null;
        Pattern p1 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Matcher m1 = p1.matcher(str);
        Pattern p2 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2}$");
        Matcher m2 = p2.matcher(str);
        Pattern p3 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
        Matcher m3 = p3.matcher(str);
        Pattern p4 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2}$");
        Matcher m4 = p4.matcher(str);
        Pattern p5 = Pattern.compile("^\\d{2,4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}:\\d{1,2}$");
        Matcher m5 = p5.matcher(str);
        Pattern p6 = Pattern.compile("^\\d{2,4}\\/\\d{1,2}\\/\\d{1,2} \\d{1,2}:\\d{1,2}$");
        Matcher m6 = p6.matcher(str);
        Pattern p7 = Pattern.compile("^\\d{2,4}\\d{1,2}\\d{1,2}$");
        Matcher m7 = p7.matcher(str);
        Pattern p8 = Pattern.compile("^\\d{1,2}-\\d{1,2} +(([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])$"); //12-12 00:00
        Matcher m8 = p8.matcher(str);
        
        try {
            if (m1.matches())
                date = sdf1.parse(str);
            else if (m2.matches())
                date = sdf2.parse(str);
            else if (m3.matches())
                date = sdf3.parse(str);
            else if (m4.matches())
                date = sdf4.parse(str);
            else if (m5.matches())
                date = sdf5.parse(str);
            else if (m6.matches())
                date = sdf6.parse(str);
            else if (m7.matches())
                date = sdf7.parse(str);
            else if (m8.matches()){
            	Calendar cal = Calendar.getInstance();
            	int year = cal.get(Calendar.YEAR);
            	str = year+"-"+str;
            	date = sdf8.parse(str);
            }
        } catch (ParseException e) {
            logger.error(e.getMessage());
            return null;
        }
        return date;
    }

    /**
     * 格式化 yyyy-MM-dd HH:mm:ss
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd HH:mm:ss
     */
    public static String format1(Date date) {
        return sdf1.format(date);
    }
    
    /**
     * 格式化 yyyy-MM-dd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd
     */
    public static String format2(Date date) {
        return sdf2.format(date);
    }
    
    /**
     * 格式化 yyyy/MM/dd HH:mm:ss
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd HH:mm:ss
     */
    public static String format3(Date date) {
        return sdf3.format(date);
    }
    
    /**
     * 格式化yyyy/MM/dd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd
     */
    public static String format4(Date date) {
        return sdf4.format(date);
    }
    
    /**
     * 格式化 yyyy-MM-dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy-MM-dd HH:mm
     */
    public static String format5(Date date) {
        return sdf5.format(date);
    }
    
    /**
     * 格式化 yyyy/MM/dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyy/MM/dd HH:mm
     */
    public static String format6(Date date) {
        return sdf6.format(date);
    }
    
    /**
     * 格式化 yyyyMMdd
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:yyyyMMdd
     */
    public static String format7(Date date) {
        return sdf7.format(date);
    }

    /**
     * 格式化 MM-dd HH:mm
     * @param date 日期 {@link Date}
     * @return 时间字符串  eg:MM-dd HH:mm
     */
    public static String format8(Date date) {
        return sdf8.format(date);
    }
    
    /**
     * 格式化指定的格式
     * @param date 		日期 {@link Date}
     * @param pattern  	日期格式字符串
     * @return 时间字符串 
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 判断传入的Long时间是否当前月
     * @param time	时间戳 
     * @return true or false
     */
    public static boolean isNowMonthTime(Long time) {
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        calendar.setTime(new Date(time));
        if(nowYear == calendar.get(Calendar.YEAR) && nowMonth == calendar.get(Calendar.MONTH)){
            return true;
        }else{
            return false;
        }
    }
}