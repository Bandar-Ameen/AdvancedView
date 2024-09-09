package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.skeleton.SkeletonView;


public class ProtouseSkeletonViewA extends SkeletonView implements ProteusView {

    Manager viewManager;

    public ProtouseSkeletonViewA(Context context) {
        super(context);
    }

    public ProtouseSkeletonViewA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseSkeletonViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProtouseSkeletonViewA(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public Manager getViewManager() {
        return viewManager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {
        this.viewManager = manager;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
