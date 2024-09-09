package com.astooltech.advancedview.proteus.view.custom.switchbutton.marqueen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class ProtouseMarqueeView  extends MarqueeView implements ProteusView {

    private Manager viewManager;

    public ProtouseMarqueeView (Context context) {
        super(context);
    }

    public ProtouseMarqueeView (Context context, AttributeSet attrs) {
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
