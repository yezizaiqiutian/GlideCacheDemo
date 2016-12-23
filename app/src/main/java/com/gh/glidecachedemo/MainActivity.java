package com.gh.glidecachedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gh.glidecachedemo.utils.GlideCacheListener;
import com.gh.glidecachedemo.utils.GlideUtils;
import com.gh.glidecachedemo.utils.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.gh.glidecachedemo.utils.T.S;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.id_iv_showimage)
    ImageView id_iv_showimage;

    private Context mContext = this;
    private Activity mActivity = this;
    private String imageUrl = "http://desk.fd.zol-img.com.cn/t_s960x600c5/g4/M00/0D/01/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.id_btn_download, R.id.id_btn_havecache, R.id.id_btn_getcache, R.id.id_btn_showimageonlycache})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_download:
                //缓存图片
                GlideUtils.cacheImage(imageUrl, mContext, new MyGlideCacheListener());
                break;
            case R.id.id_btn_havecache:
                //是否有缓存
                T.S(mActivity, GlideUtils.haveCache(mContext, imageUrl) ? "有缓存" : "无缓存");
                break;
            case R.id.id_btn_getcache:
                //读取有缓存
                T.S(mActivity, GlideUtils.getCache(mContext, imageUrl) + "");
                break;
            case R.id.id_btn_showimageonlycache:
                //只从缓存中读取
                Glide.with(mActivity).load(GlideUtils.getCache(mContext, imageUrl)).into(id_iv_showimage);
                break;
        }
    }

    private class MyGlideCacheListener implements GlideCacheListener {

        @Override
        public void success(String path) {
            S(mActivity, "缓存成功");
        }

        @Override
        public void error(Exception e) {
            S(mActivity, "缓存失败");
        }
    }
}
