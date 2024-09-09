package com.astooltech.advancedview.proteus.parser.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.skeleton.SkeletonViewGroup;


public class ProtouseSkeletonViewGroup extends SkeletonViewGroup implements ProteusView {

    private Manager viewManager;

    public ProtouseSkeletonViewGroup(Context context) {
        super(context);
    }

    public ProtouseSkeletonViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseSkeletonViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
