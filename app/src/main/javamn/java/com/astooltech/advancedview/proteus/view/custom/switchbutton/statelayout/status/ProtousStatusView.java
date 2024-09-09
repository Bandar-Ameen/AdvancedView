package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusView;


public class ProtousStatusView  extends StatusView implements ProteusView {

    private Manager viewManager;

    public ProtousStatusView (Context context) {
        super(context);
    }

    public ProtousStatusView (Context context, AttributeSet attrs) {
        super(context, attrs,0,R.layout.msv_layout_error_view,R.layout.msv_layout_loading_view,R.layout.msv_layout_empty_view);
    }

    public ProtousStatusView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr,R.layout.msv_layout_error_view,R.layout.msv_layout_loading_view,R.layout.msv_layout_empty_view);
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
