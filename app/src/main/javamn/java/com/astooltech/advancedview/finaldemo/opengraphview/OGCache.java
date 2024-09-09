package com.astooltech.advancedview.finaldemo.opengraphview;

import android.graphics.Bitmap;

import android.text.TextUtils;
import android.util.LruCache;

import androidx.annotation.Nullable;

import com.astooltech.advancedview.finaldemo.opengraphview.network.model.OGData;


public class OGCache {

    private static OGCache mOGCache;
    private LruCache<String, OGData> mOGDataCache;
    private LruCache<String, Bitmap> mImageCache;

    public static OGCache getInstance() {
        if (mOGCache == null) {
            mOGCache = new OGCache();
        }
        return mOGCache;
    }

    private OGCache() {
        final int max = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = max / 8;
        mOGDataCache = new LruCache<>(cacheSize);
        mImageCache = new LruCache<>(cacheSize);
    }

    public void add(String url, OGData ogData) {
        if (get(url) == null) {
            mOGDataCache.put(url, ogData);
        }
    }

    @Nullable
    public OGData get(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return mOGDataCache.get(url);
    }

    public void addImage(String url, Bitmap bitmap) {
        if (TextUtils.isEmpty(url) || bitmap == null) {
            return;
        }
        if (getImage(url) == null) {
            mImageCache.put(url, bitmap);
        }
    }

    @Nullable
    public Bitmap getImage(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return mImageCache.get(url);
    }
}
