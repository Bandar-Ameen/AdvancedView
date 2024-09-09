package com.astooltech.advancedview.proteus.view.custom.switchbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class PrototuseReadMoreTextView extends ReadMoreTextView implements ProteusView {

    private Manager viewManager;

    public PrototuseReadMoreTextView(Context context) {
        super(context);
    }

    public PrototuseReadMoreTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PrototuseReadMoreTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
