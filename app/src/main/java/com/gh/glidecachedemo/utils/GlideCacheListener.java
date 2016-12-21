package com.gh.glidecachedemo.utils;

/**
 * @author: gh
 * @description: 缓存图片监听
 * @date: 2016/12/21 16:01
 * @note:
 */

public interface GlideCacheListener {

    void success(String path);

    void error(Exception e);
}
