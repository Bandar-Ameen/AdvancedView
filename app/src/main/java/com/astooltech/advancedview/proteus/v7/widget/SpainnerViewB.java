package com.astooltech.advancedview.proteus.v7.widget;

import android.view.View;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;


public class SpainnerViewB extends Spinner implements ProteusView {

    Manager manager;

    public SpainnerViewB(ProteusContext context) {
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
