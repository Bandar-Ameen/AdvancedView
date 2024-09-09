package com.astooltech.advancedview.finaldemo.widget;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;


public class prtouseChatviews extends ChatView implements ProteusView {

    Manager viewManager;



    public prtouseChatviews(Context context) {


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
