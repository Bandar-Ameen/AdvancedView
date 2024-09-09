package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.view.widget.OverlayLayout;


public class ProtouseMultipleStatusView  extends OverlayLayout implements ProteusView {

    private Manager viewManager;

    public ProtouseMultipleStatusView (Context context) {
        super(context);
    }

    public ProtouseMultipleStatusView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProtouseMultipleStatusView (Context context, AttributeSet attrs, int defStyleAttr) {
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
