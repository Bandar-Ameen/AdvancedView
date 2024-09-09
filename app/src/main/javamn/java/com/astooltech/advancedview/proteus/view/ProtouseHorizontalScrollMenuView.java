package com.astooltech.advancedview.proteus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.horizontalscrollmenulibrary.custom_views.HorizontalScrollMenuView;

public class ProtouseHorizontalScrollMenuView extends HorizontalScrollMenuView implements ProteusView {

    private ProteusView.Manager viewManager;

    public ProtouseHorizontalScrollMenuView(Context context) {
        super(context);
    }

    public ProtouseHorizontalScrollMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public ProteusView.Manager getViewManager() {
        return viewManager;
    }

    @Override
    public void setViewManager(@NonNull ProteusView.Manager manager) {
        this.viewManager = manager;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }


}
