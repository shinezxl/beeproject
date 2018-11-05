package com.bee.util;

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
}
