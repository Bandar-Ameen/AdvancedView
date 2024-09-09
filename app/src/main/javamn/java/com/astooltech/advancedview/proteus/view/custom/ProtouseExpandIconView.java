package com.astooltech.advancedview.proteus.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.chatview.photoview.ExpandIconView;


public class ProtouseExpandIconView extends ExpandIconView implements ProteusView {

    private Manager viewManager;

    public ProtouseExpandIconView(Context context) {
        super(context);
    }

    public ProtouseExpandIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseExpandIconView(Context context, AttributeSet attrs, int defStyleAttr) {
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
