package com.gh.glidecachedemo.utils;

import java.security.MessageDigest;

/**
 * @author: gh
 * @description:
 * @date: 2016/9/14 13:56.
 */
public class Md5 {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public Md5() {
    }

    public static String hexdigest(String string) {
        String s = null;

        try {
            s = hexdigest(string.getBytes());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return s;
    }

    public static String hexdigest(byte[] bytes) {
        String s = null;

        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(bytes);
            byte[] tmp = e.digest();
            char[] str = new char[32];
            int k = 0;

            for (int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            s = new String(str);
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return s;
    }

    public static String getFileName(String url) {
        return hexdigest(url) == null ? GetTimestamp.getTimestamp() : hexdigest(url);
    }
}
