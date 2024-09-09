package com.astooltech.advancedview.proteus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusView;

public class TextInputLayoutB  extends com.google.android.material.textfield.TextInputLayout implements ProteusView {

    private Manager viewManager;

    public TextInputLayoutB(Context context) {
        super(context,null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox );
    }

    public TextInputLayoutB(Context context, AttributeSet attrs) {
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


