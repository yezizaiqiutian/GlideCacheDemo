package com.gh.glidecachedemo.utils;

import android.text.TextUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author: gh
 * @description: 获取时间戳
 * @date: 2016/10/14 15:32.
 */
public class GetTimestamp {

    private static String defaultDateFormat = "yyyyMMddHHmmss";

    public static String getTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        return String.valueOf(time);
    }

    public static String getTimestamp(String dateFormat) {
        if (!TextUtils.isEmpty(dateFormat)) {
            defaultDateFormat = dateFormat;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        SimpleDateFormat format = new SimpleDateFormat(defaultDateFormat);
        return format.format(time);
    }
    public static long getTimestampF() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long time = timestamp.getTime();
        return time;
    }

}
