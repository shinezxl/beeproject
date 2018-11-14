package com.bee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String dateToStr(Date date,String formatStr){
        if (null == date){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        String format = simpleDateFormat.format(date);
        return format;
    }

    public static Date strToDate(String str,String formatStr){
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
