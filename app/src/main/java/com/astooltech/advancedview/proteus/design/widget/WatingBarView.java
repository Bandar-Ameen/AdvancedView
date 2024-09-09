package com.astooltech.advancedview.proteus.design.widget;

import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.spinkit.SpinKitView;

public class WatingBarView extends SpinKitView implements ProteusView {

    private Manager manager;

    public WatingBarView(ProteusContext context) {
        super(context);
    }



    @Override
    public Manager getViewManager() {
        return manager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {
        this.manager = manager;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
