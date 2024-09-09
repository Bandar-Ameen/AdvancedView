package com.astooltech.advancedview.proteus.parser.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;


public class protouseFastScroller extends FastScroller implements ProteusView {

    Manager viewManager;

    public protouseFastScroller(Context context) {
        super(context);
    }

    public protouseFastScroller(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public protouseFastScroller(Context context, AttributeSet attrs, int defStyleAttr) {
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
