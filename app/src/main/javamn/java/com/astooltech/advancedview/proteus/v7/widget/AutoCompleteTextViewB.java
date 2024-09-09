package com.astooltech.advancedview.proteus.v7.widget;

import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.DynamicAutoCompleteTextView;


public class AutoCompleteTextViewB extends DynamicAutoCompleteTextView implements ProteusView {

    Manager manager;

    public AutoCompleteTextViewB(ProteusContext context) {
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
