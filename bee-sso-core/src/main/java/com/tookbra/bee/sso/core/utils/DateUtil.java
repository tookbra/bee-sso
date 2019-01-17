package com.tookbra.bee.sso.core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tookbra
 * @date 2019/1/17
 * @description
 */
public class DateUtil {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化日期
     * @param date
     * @return
     */
    public static String formatDateTime(Date date) {
        DateFormat format = new SimpleDateFormat(DATE_TIME_FORMAT);
        return format.format(date);
    }
}
