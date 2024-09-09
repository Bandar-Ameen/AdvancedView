package com.astooltech.advancedview.proteus.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.astooltech.advancedview.proteus.ProteusView;

public class ProtoDrawerLayoutView extends DrawerLayout implements ProteusView {

private ProteusView.Manager viewManager;

public  ProtoDrawerLayoutView(Context context) {
        super(context);
        }

public  ProtoDrawerLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        }

public  ProtoDrawerLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
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
