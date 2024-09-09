package com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.entity;

import android.graphics.drawable.Drawable;

import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.CustomTabEntity;

public class TabEntity implements CustomTabEntity {
    public String title;
    public int selectedIcon;
    public int unSelectedIcon;
    public int typp;
    public Drawable selacounn;
    public Drawable unSell;
    public TabEntity(String title, int selectedIcon, int unSelectedIcon,int typ,Drawable selacoun,Drawable unSel) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unSelectedIcon = unSelectedIcon;
        this.typp=typ;
        this.selacounn=selacoun;
        this.unSell=unSel;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectedIcon;
    }

    @Override
    public Drawable getTabSelectedIconA() {
        return  selacounn;
    }

    @Override
    public Drawable getTabUnselectedIconA() {
        return unSell;
    }

    @Override
    public int typSelect() {
        return typp;
    }
}
