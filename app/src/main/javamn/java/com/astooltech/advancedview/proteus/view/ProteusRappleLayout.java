package com.astooltech.advancedview.proteus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;

//com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout

public class ProteusRappleLayout extends com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout implements ProteusView {

    private Manager viewManager;

    public ProteusRappleLayout(Context context) {
        super(context);
    }

    public ProteusRappleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProteusRappleLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
