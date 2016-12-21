# GlideCacheDemo
Glide utils 判断Glide是否缓存该url，如有缓存，读取缓存的地址。（例如微信查看原图后一直显示原图）

具体用法:

```Java
1判断是否有缓存
T.S(mActivity, GlideUtils.haveCache(mContext, imageUrl) ? "有缓存" : "无缓存");
2获取缓存路径
T.S(mActivity, GlideUtils.getCache(mContext, imageUrl) + "");//如果没有缓存则路径为null
3缓存图片
GlideUtils.cacheImage(imageUrl, mContext, new MyGlideCacheListener());//可以设置缓存路径,缓存监听等具体看代码
```
