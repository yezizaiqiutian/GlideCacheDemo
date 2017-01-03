package com.gh.glidecachedemo.utils;

import java.io.File;

/**
 * @author: gh
 * @description: TODO(描述)
 * @date: 2016/12/21 15:51
 * @note:
 */

public class FileUtils {
    //判断文件是否存在
    public static boolean fileIsExists(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
    //判断文件是否存在
    public static boolean fileIsExists(File f) {
        try {
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
