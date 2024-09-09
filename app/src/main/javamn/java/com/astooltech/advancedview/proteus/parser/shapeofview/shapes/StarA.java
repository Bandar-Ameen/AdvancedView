package com.astooltech.advancedview.proteus.parser.shapeofview.shapes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class StarA extends StarView implements ProteusView {

    Manager viewManager;

    public StarA(Context context) {
        super(context);
    }

    public StarA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StarA(Context context, AttributeSet attrs, int defStyleAttr) {
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
