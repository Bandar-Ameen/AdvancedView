package com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener;

import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

public interface CustomTabEntity {
    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();

    @DrawableRes
    int getTabUnselectedIcon();

    Drawable getTabSelectedIconA();
    Drawable getTabUnselectedIconA();
    int typSelect();
}