package com.astooltech.advancedview.finaldemo.fragments;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class viewWatingGetProtuse extends viewWatingGet implements ProteusView {

    Manager viewManager;



    public viewWatingGetProtuse(Context context) {


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
