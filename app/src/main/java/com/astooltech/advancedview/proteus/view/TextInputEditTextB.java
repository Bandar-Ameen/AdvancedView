package com.astooltech.advancedview.proteus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class TextInputEditTextB extends com.google.android.material.textfield.TextInputEditText implements ProteusView {

    private Manager viewManager;

    public TextInputEditTextB(Context context) {
        super(context);
    }

    public TextInputEditTextB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextInputEditTextB(Context context, AttributeSet attrs, int defStyleAttr) {
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
