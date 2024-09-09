package com.astooltech.advancedview.proteus.design.widget;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.astooltech.advancedview.proteus.ProteusView;

public class protousToolBarView  extends Toolbar implements ProteusView {

private Manager manager;

        public protousToolBarView(Context context) {
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
