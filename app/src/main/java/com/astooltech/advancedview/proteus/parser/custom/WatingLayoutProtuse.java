package com.astooltech.advancedview.proteus.parser.custom;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class WatingLayoutProtuse extends WatingLayout implements ProteusView {

    Manager viewManager;



    public WatingLayoutProtuse(Context context) {


        super(context,
                null);
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
