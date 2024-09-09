package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.good;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class ProtouseGoodView  extends androidx.appcompat.widget.AppCompatButton implements ProteusView {

    private Manager viewManager;

    public ProtouseGoodView (Context context) {
        super(context);
    }

    public ProtouseGoodView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseGoodView (Context context, AttributeSet attrs, int defStyleAttr) {
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
