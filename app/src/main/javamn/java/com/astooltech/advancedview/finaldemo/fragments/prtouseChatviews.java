package com.astooltech.advancedview.finaldemo.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.R;


public class prtouseChatviews extends com.astooltech.advancedview.proteus.chatview.widget.ChatView implements ProteusView {

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
