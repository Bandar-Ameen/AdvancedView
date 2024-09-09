package com.astooltech.advancedview.proteus.design.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusView;

public class DateTimePakerView extends TextView implements ProteusView {

    private ProteusView.Manager manager;


    public DateTimePakerView(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
    }

    @Override
    public ProteusView.Manager getViewManager() {
        return manager;
    }

    @Override
    public void setViewManager(@NonNull ProteusView.Manager manager) {
        this.manager = manager;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
