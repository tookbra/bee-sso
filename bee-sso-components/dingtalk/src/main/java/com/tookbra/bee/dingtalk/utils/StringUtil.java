package com.tookbra.bee.dingtalk.utils;

import com.tookbra.bee.sso.core.utils.DateUtil;

import java.util.Date;

/**
 * @author tookbra
 * @date 2019/2/26
 * @description
 */
public class StringUtil {

    /**
     *
     * @param value
     * @return
     */
    public static String convertToString(Object value) {
        String val;
        if(value == null) {
            val = null;
        } else if (value instanceof String) {
            val = (String)value;
        } else if (value instanceof Integer) {
            val = ((Integer) value).toString();
        } else if (value instanceof Long) {
            val = ((Long) value).toString();
        } else if (value instanceof Float) {
            val = ((Float) value).toString();
        } else if (value instanceof Double) {
            val = ((Double) value).toString();
        } else if (value instanceof Boolean) {
            val = ((Boolean) value).toString();
        } else if (value instanceof Date) {
            val = DateUtil.formatDateTime((Date) value);
        } else {
            val = value.toString();
        }
        return val;
    }
}
