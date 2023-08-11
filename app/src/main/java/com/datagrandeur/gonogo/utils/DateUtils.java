package com.datagrandeur.gonogo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date getDate(long timeMillis){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return new Date(timeMillis);
    }

}
