/*
 * Copyright (C)  Justson(https://github.com/Justson/Downloader)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library;

import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author cenxiaozhong
 * @date 2019/2/9
 * @since 1.0.0
 */
public class ResourceRequest<T extends DownloadTask> {

    static final String TAG = Runtime.PREFIX + ResourceRequest.class.getSimpleName();
    private DownloadTask mDownloadTask;


    static ResourceRequest with(Context context) {
        ResourceRequest resourceRequest = new ResourceRequest();
        resourceRequest.mDownloadTask = Runtime.getInstance().getDefaultDownloadTask();
        resourceRequest.mDownloadTask.setContext(context);
        return resourceRequest;
    }

    public ResourceRequest url(@NonNull String url) {
        mDownloadTask.setUrl(url);
        return this;
    }

    public ResourceRequest target(@Nullable File target) {
        File file = target;
        if (!file.exists()) {
            try {
                File parent = file.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Runtime.getInstance().logError(TAG, "create file error .");
                return this;
            }
        }
        mDownloadTask.setFile(target);
        return this;
    }

    public ResourceRequest target(@NonNull String target) {
        if (TextUtils.isEmpty(target)) {
            return this;
        }
        return target(new File(target));
    }

    public ResourceRequest targetDir(@Nullable File target) {
        if (!target.exists()) {
            target.mkdirs();
        }
        mDownloadTask.setFile(target);
        return this;
    }

    public ResourceRequest targetDir(@NonNull String target) {
        if (TextUtils.isEmpty(target)) {
            return this;
        }
        File targetDir = new File(target);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        mDownloadTask.setFile(targetDir);
        return this;
    }

    public ResourceRequest setUniquePath(boolean uniquePath) {
        mDownloadTask.setUniquePath(uniquePath);
        return this;
    }

    public ResourceRequest setBlockMaxTime(long blockMaxTime) {
        mDownloadTask.blockMaxTime = blockMaxTime;
        return this;
    }

    public ResourceRequest target(@NonNull File target, @NonNull String authority) {
        mDownloadTask.setFile(target, authority);
        return this;
    }


    public ResourceRequest setDownloadTimeOut(long downloadTimeOut) {
        mDownloadTask.downloadTimeOut = downloadTimeOut;
        return this;
    }

    public ResourceRequest setConnectTimeOut(long connectTimeOut) {
        mDownloadTask.connectTimeOut = connectTimeOut;
        return this;
    }

    public ResourceRequest setOpenBreakPointDownload(boolean openBreakPointDownload) {
        mDownloadTask.mIsBreakPointDownload = openBreakPointDownload;
        return this;
    }

    public ResourceRequest setForceDownload(boolean force) {
        mDownloadTask.mIsForceDownload = force;
        return this;
    }

    public ResourceRequest setEnableIndicator(boolean enableIndicator) {
        mDownloadTask.mEnableIndicator = enableIndicator;
        return this;
    }


    public ResourceRequest setQuickProgress(boolean quickProgress) {
        mDownloadTask.quickProgress = quickProgress;
        return this;
    }

    public ResourceRequest setTargetCompareMD5(String targetCompareMD5) {
        mDownloadTask.targetCompareMD5 = targetCompareMD5;
        return this;
    }

    public ResourceRequest setRetry(int retry) {
        mDownloadTask.setRetry(retry);
        return this;
    }

    public ResourceRequest setIcon(@DrawableRes int icon) {
        mDownloadTask.mDownloadIcon = icon;
        return this;
    }

    public ResourceRequest setParallelDownload(boolean parallelDownload) {
        mDownloadTask.mIsParallelDownload = parallelDownload;
        return this;
    }

    public ResourceRequest addHeader(String key, String value) {
        if (mDownloadTask.mHeaders == null) {
            mDownloadTask.mHeaders = new HashMap<>();
        }
        mDownloadTask.mHeaders.put(key, value);
        return this;
    }


    public ResourceRequest autoOpenIgnoreMD5() {
        mDownloadTask.autoOpenIgnoreMD5();
        return this;
    }

    public ResourceRequest autoOpenWithMD5(String md5) {
        mDownloadTask.autoOpenWithMD5(md5);
        return this;
    }

    public ResourceRequest closeAutoOpen() {
        mDownloadTask.closeAutoOpen();
        return this;
    }

    public File get() {
        return DownloadImpl.getInstance(mDownloadTask.mContext).call(mDownloadTask);
    }

    public ResourceRequest setDownloadListener(DownloadListener downloadListener) {
        mDownloadTask.setDownloadListener(downloadListener);
        return this;
    }

    public ResourceRequest setDownloadingListener(DownloadingListener downloadListener) {
        mDownloadTask.setDownloadingListener(downloadListener);
        return this;
    }

    public ResourceRequest
    setDownloadListenerAdapter(DownloadListenerAdapter downloadListenerAdapter) {
        mDownloadTask.setDownloadListenerAdapter(downloadListenerAdapter);
        return this;
    }

    public ResourceRequest setCalculateMD5(boolean calculateMD5) {
        mDownloadTask.setCalculateMD5(calculateMD5);
        return this;
    }

    public ResourceRequest quickProgress() {
        mDownloadTask.setQuickProgress(true);
        return this;
    }

    public ResourceRequest setContentDisposition(String contentDisposition) {
        mDownloadTask.setContentDisposition(contentDisposition);
        return this;
    }

    public ResourceRequest setMimetype(String mimetype) {
        mDownloadTask.setMimetype(mimetype);
        return this;
    }

    public ResourceRequest setUserAgent(String userAgent) {
        mDownloadTask.setUserAgent(userAgent);
        return this;
    }

    public ResourceRequest setContentLength(long contentLength) {
        mDownloadTask.setContentLength(contentLength);
        return this;
    }

    public DownloadTask getDownloadTask() {
        return this.mDownloadTask;
    }

    public void enqueue() {
        DownloadImpl.getInstance(mDownloadTask.mContext).enqueue(mDownloadTask);
    }

    public void enqueue(DownloadListener downloadListener) {
        mDownloadTask.setDownloadListener(downloadListener);
        DownloadImpl.getInstance(mDownloadTask.mContext).enqueue(mDownloadTask);
    }

    public void enqueue(DownloadingListener downloadingListener) {
        mDownloadTask.setDownloadingListener(downloadingListener);
        DownloadImpl.getInstance(mDownloadTask.mContext).enqueue(mDownloadTask);
    }

    public void enqueue(DownloadListenerAdapter downloadListenerAdapter) {
        setDownloadListenerAdapter(downloadListenerAdapter);
        DownloadImpl.getInstance(mDownloadTask.mContext).enqueue(mDownloadTask);
    }

}
