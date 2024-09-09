package com.astooltech.advancedview.finaldemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;

public class protuseTest extends Loadinglayoutt implements ProteusView {

    Manager viewManager;

    public protuseTest(Context context) {
        super(context);
    }

    public protuseTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public protuseTest(Context context, AttributeSet attrs, int defStyleAttr) {
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
