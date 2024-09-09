package com.astooltech.advancedview.proteus.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.SlidingTabLayout;


public class  ProtouseSlidingTabLayout extends SlidingTabLayout implements ProteusView {

    private ProteusView.Manager viewManager;

    public ProtouseSlidingTabLayout(Context context) {
        super(context);
    }

    public ProtouseSlidingTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseSlidingTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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