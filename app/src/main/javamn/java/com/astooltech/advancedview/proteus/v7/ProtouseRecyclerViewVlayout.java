package com.astooltech.advancedview.proteus.v7;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;


public class ProtouseRecyclerViewVlayout extends RecyclerView implements ProteusView {

    Manager manager;


    public ProtouseRecyclerViewVlayout(ProteusContext context) {
        super(context);
    }

    @Override
    public Manager getViewManager() {


        return manager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {


        //  manager.setActionEventView(Act);
        this.manager = manager;


    }


    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
