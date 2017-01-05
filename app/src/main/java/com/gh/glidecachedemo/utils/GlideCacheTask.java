package com.gh.glidecachedemo.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author: gh
 * @description: 执行缓存AsyncTask
 * @date: 2016/12/21 09:55
 * @note:
 */

public class GlideCacheTask extends AsyncTask<String, Void, File> {
    private Context context;
    private String imgUrl;
    private File cacheFile;
    private GlideCacheListener listener;

//    public GlideCacheTask(Context context) {
//        this(context, null, null);
//    }
//
//    public GlideCacheTask(Context context, GlideCacheListener listener) {
//        this(context, null, listener);
//    }
//
//    public GlideCacheTask(Context context, File cacheFile) {
//        this(context, cacheFile, null);
//    }

    public GlideCacheTask(Context context, File cacheFile, GlideCacheListener listener) {
        this.context = context;
        this.cacheFile = cacheFile == null?context.getExternalCacheDir():cacheFile;
        this.listener = listener;
    }

    @Override
    protected File doInBackground(String... params) {
        imgUrl = params[0];
        File oldfile;
        File newfile = new File(cacheFile+ Md5.getFileName(imgUrl));
        try {
            oldfile = Glide.with(context)
                    .load(imgUrl)
                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
//            throw new NullPointerException();
        } catch (Exception ex) {
            if (listener != null) {
                listener.error(ex);
            }
            oldfile = null;
        }
        if (oldfile != null) {
            //将缓存文件copy, 命名为图片格式文件
//        copyFile(path, Environment.getExternalStorageDirectory().getAbsolutePath() + "/#gh/"+ Md5.getFileName(imgUrl));
//        copyFile(path, context.getExternalCacheDir()+ Md5.getFileName(imgUrl));
            copyFile(oldfile.getAbsolutePath(), newfile.getAbsolutePath());
        }
        return newfile;
    }

    @Override
    protected void onPostExecute(File result) {

    }

    /**
     * oldPath: 图片缓存的路径
     * newPath: 图片缓存copy的路径
     */
    public void copyFile(String oldPath, String newPath) {
        try {
            int byteRead;
            File oldFile = new File(oldPath);
            if (oldFile.exists()) {
                InputStream inStream = new FileInputStream(oldPath);
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1024];
                while ((byteRead = inStream.read(buffer)) != -1) {
                    fs.write(buffer, 0, byteRead);
                }
                inStream.close();

                if (listener != null) {
                    listener.success(newPath);
                }
            } else {
                if (listener != null) {
                    listener.error(new NullPointerException("没有找到源文件"));
                }
            }
//            throw new RuntimeException();
        }
        catch (Exception e) {
            if (listener != null) {
                listener.error(e);
            }
            System.out.println("复制文件操作出错");
            e.printStackTrace();
        }
    }
}
