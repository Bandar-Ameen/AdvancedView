package com.astooltech.advancedview.proteus.view.custom.switchbutton.shinebutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class PrototuseShineButton  extends ShineButton implements ProteusView {

    private Manager viewManager;

    public PrototuseShineButton(Context context) {
        super(context);
    }

    public PrototuseShineButton (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrototuseShineButton (Context context, AttributeSet attrs, int defStyleAttr) {
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
