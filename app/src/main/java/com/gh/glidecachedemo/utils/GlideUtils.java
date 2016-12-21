package com.gh.glidecachedemo.utils;

import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * @author: gh
 * @description: 由于Glide没有提供获取缓存是否存在的方法(或者我没找到), 对Glide进行二次封装以便于使用
 * @date: 2016/12/21 15:45
 * @note:
 */

public class GlideUtils {

    /**
     * 获取缓存的路径
     *
     * @param context
     * @param fileUrl
     * @return 有:路径    无:null
     */
    public static String getCache(Context context, String fileUrl) {
        String path = context.getExternalCacheDir() + Md5.getFileName(fileUrl);
        return haveCache(context, fileUrl) ? path : null;
    }

    /**
     * 判断是否有缓存
     *
     * @param context
     * @param fileUrl
     * @return
     */
    public static boolean haveCache(Context context, String fileUrl) {
        return FileUtils.fileIsExists(context.getExternalCacheDir() + Md5.getFileName(fileUrl));
    }

    /**
     * 缓存图片
     * @param fileUrl
     * @param context
     */
    public static void cacheImage(String fileUrl, Context context) {
        cacheImage(fileUrl, context, null, null);
    }

    /**
     * 缓存图片
     * @param fileUrl
     * @param context
     * @param cacheFile
     */
    public static void cacheImage(String fileUrl, Context context, File cacheFile) {
        cacheImage(fileUrl, context, cacheFile, null);
    }

    /**
     * 缓存图片
     *
     * @param fileUrl
     * @param context
     * @param listener
     */
    public static void cacheImage(String fileUrl, Context context, GlideCacheListener listener) {
        cacheImage(fileUrl, context, null, listener);
    }

    /**
     * 缓存图片
     *
     * @param fileUrl
     * @param context
     * @param cacheFile
     * @param listener
     */
    public static void cacheImage(String fileUrl, Context context, File cacheFile, GlideCacheListener listener) {
        new GlideCacheTask(context, cacheFile, listener).execute(fileUrl);
    }

    /**
     * 缓存多张图片
     * @param fileUrls
     * @param context
     */
    public static void cacheImage(List<String> fileUrls, Context context ) {
        for (String fileUrl : fileUrls) {
            cacheImage(fileUrl, context, null, null);
        }
    }

    /**
     * 缓存多张图片
     * @param fileUrls
     * @param context
     * @param cacheFile
     */
    public static void cacheImage(List<String> fileUrls, Context context, File cacheFile) {
        for (String fileUrl : fileUrls) {
            cacheImage(fileUrl, context, cacheFile, null);
        }
    }
}
