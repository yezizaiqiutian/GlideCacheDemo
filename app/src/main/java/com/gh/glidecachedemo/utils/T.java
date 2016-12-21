package com.gh.glidecachedemo.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * @author: gh
 * @description: Toast统一管理类
 * @date: 2016/10/14 10:31.
 */
public class T {
    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     * 针对R.string.xx
     * S    short
     *
     * @param activity
     * @param message
     */
    public static void S(final Activity activity, final int message) {
        show(activity, message, Toast.LENGTH_SHORT);
    }

    /**
     * 短时间显示Toast
     * S    short
     *
     * @param activity
     * @param message
     */
    public static void S(final Activity activity, final String message) {
        show(activity, message, Toast.LENGTH_SHORT);
    }

    /**
     * 短时间显示Toast
     * SO    short    Object
     *
     * @param activity
     * @param message
     */
    public static void SO(final Activity activity, final Object message) {
        show(activity, message.toString(), Toast.LENGTH_SHORT);
    }

    /**
     * 长时间显示Toast
     * 针对R.string.xx
     * L    long
     *
     * @param activity
     * @param message
     */
    public static void L(final Activity activity, final int message) {
        show(activity, message, Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast
     * L    long
     *
     * @param activity
     * @param message
     */
    public static void L(final Activity activity, final String message) {
        show(activity, message, Toast.LENGTH_LONG);
    }

    /**
     * 长时间显示Toast
     * SO   long    Object
     *
     * @param activity
     * @param message
     */
    public static void LO(final Activity activity, final Object message) {
        show(activity, message.toString(), Toast.LENGTH_LONG);
    }

    /**
     * 自定义显示Toast时间
     * D    duration
     *
     * @param activity
     * @param message
     * @param duration
     */
    public static void D(final Activity activity, final int message, final int duration) {
        show(activity, message, duration);
    }

    /**
     * 自定义显示Toast时间
     * D    duration
     *
     * @param activity
     * @param message
     * @param duration
     */
    public static void D(final Activity activity, final String message, final int duration) {
        show(activity, message, duration);
    }

    /**
     * 自定义显示Toast时间
     * DO    duration   Object
     *
     * @param activity
     * @param message
     * @param duration
     */
    public static void DO(final Activity activity, final Object message, final int duration) {
        show(activity, message.toString(), duration);
    }

    private static void show(final Activity activity, final Object message, final int duration) {
        if (isShow)
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(activity, message.toString(), duration).show();
                }
            });
    }
}
