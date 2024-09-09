package com.astooltech.advancedview.proteus.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;

public class ProtouseVideoLayout extends VideoLayout implements ProteusView {

    Manager viewManager;

    public ProtouseVideoLayout(Context context) {
        super(context);
    }

    public ProtouseVideoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
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
