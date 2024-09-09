package com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class protouseInboxLayoutScrollView extends InboxLayoutScrollView implements ProteusView {

    private Manager viewManager;

    public protouseInboxLayoutScrollView(Context context) {
        super(context);
    }

    public protouseInboxLayoutScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public protouseInboxLayoutScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
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
