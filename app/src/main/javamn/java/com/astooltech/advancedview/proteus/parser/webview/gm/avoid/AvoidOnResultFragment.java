package com.astooltech.advancedview.proteus.parser.webview.gm.avoid;


import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by ruoyun on 2019-07-16.
 * Author:若云
 * Mail:zyhdvlp@gmail.com
 * Depiction:
 */
public class AvoidOnResultFragment extends Fragment {

    //生命周期状态
    public static final int INITIALIZING = 0;     // Not yet created.
    public static final int STOPPED = 3;          // Fully created, not started.
    public static final int STARTED = 4;          // Created and started, not resumed.
    public static final int DESTROYED = 6;

    private int mState = INITIALIZING;

    //默认值
    private static int mRequestCodeStart = 65000;
    private static int mRequestCodeEnd = 65535;

    private static int mRequestCodeCounter = mRequestCodeStart;
    private SparseArray<AvoidOnResultHelper.ActivityCallback> mActivityCallbacks = new SparseArray<>();
    private SparseArray<AvoidOnResultHelper.PermissionsCallBack> mPermissionsCallbacks = new SparseArray<>();
    private Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap<LifecycleListener, Boolean>());

    public AvoidOnResultFragment() {
    }

    static void setRequestCodeRange(int start, int end) {
        mRequestCodeStart = start;
        mRequestCodeEnd = end;
        mRequestCodeCounter = start;
    }

    /**
     * 打开 activity
     *
     * @param intent
     * @param options
     * @param activityCallback
     */
    public void startActivityForResult(Intent intent, @Nullable Bundle options, AvoidOnResultHelper.ActivityCallback activityCallback) {

       // Activity dd=getActivity();

       // Log.e("888",dd.getClass().getName());
        checkRequestCodeCounter();
        mRequestCodeCounter++;
        mActivityCallbacks.append(mRequestCodeCounter, activityCallback);
        startActivityForResult(intent, mRequestCodeCounter, options);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AvoidOnResultHelper.ActivityCallback activityCallback = mActivityCallbacks.get(requestCode);
        if (activityCallback != null) {
            activityCallback.onActivityResult(resultCode, data);
            mActivityCallbacks.remove(requestCode);
        }
    }

    /**
     * 请求权限
     *
     * @param permissions
     * @param permissionsCallBack
     */
    public void requestPermissions(@NonNull String[] permissions, @NonNull AvoidOnResultHelper.PermissionsCallBack permissionsCallBack) {
        checkRequestCodeCounter();
        mRequestCodeCounter++;
        mPermissionsCallbacks.append(mRequestCodeCounter, permissionsCallBack);
        requestPermissions(permissions, mRequestCodeCounter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AvoidOnResultHelper.PermissionsCallBack permissionsCallBack = mPermissionsCallbacks.get(requestCode);
        if (permissionsCallBack != null) {
            permissionsCallBack.onRequestPermissionsResult(permissions, grantResults);
            mPermissionsCallbacks.remove(requestCode);
        }
    }

    /**
     * 生命周期
     */
    public void addLifecycleListener(@NonNull LifecycleListener listener, boolean isSticky) {
        lifecycleListeners.add(listener);
        if (isSticky) {
            switch (mState) {
                case STARTED:
                    listener.onStart();
                    break;
                case STOPPED:
                    listener.onStop();
                    break;
                case DESTROYED:
                    listener.onDestroy();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @param listener
     */
    public void removeLifecycleListener(@NonNull LifecycleListener listener) {
        lifecycleListeners.remove(listener);
    }

    @Override
    public void onStart() {
        super.onStart();
        mState = STARTED;
        for (LifecycleListener lifecycleListener : lifecycleListeners) {
            lifecycleListener.onStart();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mState = STOPPED;
        for (LifecycleListener lifecycleListener : lifecycleListeners) {
            lifecycleListener.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mState = DESTROYED;
        for (LifecycleListener lifecycleListener : lifecycleListeners) {
            lifecycleListener.onDestroy();
        }
        lifecycleListeners.clear();
        lifecycleListeners = null;
        mActivityCallbacks = null;
        mPermissionsCallbacks = null;
    }

    private void checkRequestCodeCounter() {
        if (mRequestCodeCounter >= mRequestCodeEnd) {
            mRequestCodeCounter = mRequestCodeStart;
        }
    }
}