package com.astooltech.advancedview.proteus.parser;

import android.graphics.drawable.Drawable;

import com.astooltech.advancedview.proteus.value.Value;
import com.google.gson.annotations.SerializedName;
import com.astooltech.advancedview.proteus.value.Layout;

public class TabModel {
    @SerializedName("ContentTitle")
    private String ContentTitle;
    @SerializedName("ContentColor")
    private String ContentColor;
    @SerializedName("ContentMain")
private  String ContentMain;


    public Drawable getImagSelect() {
        return ImageSelect;
    }

    public void setImagSelect(Drawable imagSelect) {
        ImageSelect = imagSelect;
    }

    public Drawable getImageUnselect() {
        return ImageUnSelect;
    }

    public void setImageUnselect(Drawable imageUnselect) {
        ImageUnSelect = imageUnselect;
    }
    @SerializedName("ImageSelect")
    private Drawable ImageSelect;

    public Layout getLay() {
        return lay;
    }

    public void setLay(Layout lay) {
        this.lay = lay;
    }

    private Layout lay;

    public Value getAnotherval() {
        return anotherval;
    }

    public void setAnotherval(Value anotherval) {
        this.anotherval = anotherval;
    }

    private Value anotherval;
    public TabModel(String contentTitle, String contentColor, String contentMain, Drawable imageSelect, Drawable imageUnSelect, int contentMainCount, String contentView, String contentType,Layout las) {
       this.lay=las;
        ContentTitle = contentTitle;
        ContentColor = contentColor;
        ContentMain = contentMain;
        ImageSelect = imageSelect;
        ImageUnSelect = imageUnSelect;
        ContentMainCount = contentMainCount;
        ContentView = contentView;
        ContentType = contentType;
    }

    @SerializedName("ImageUnSelect")
    private  Drawable ImageUnSelect;
    public String getContentMain() {
        return ContentMain;
    }

    public void setContentMain(String contentMain) {
        ContentMain = contentMain;
    }

    public int getContentMainCount() {
        return ContentMainCount;
    }

    public void setContentMainCount(int contentMainCount) {
        ContentMainCount = contentMainCount;
    }
    @SerializedName("ContentMainCount")
    private int ContentMainCount;
    public String getContentTitle() {
        return ContentTitle;
    }

    public void setContentTitle(String contentTitle) {
        ContentTitle = contentTitle;
    }

    public String getContentColor() {
        return ContentColor;
    }

    public void setContentColor(String contentColor) {
        ContentColor = contentColor;
    }

    public String getContentView() {
        return ContentView;
    }

    public void setContentView(String contentView) {
        ContentView = contentView;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }

    @SerializedName("ContentView")
    private String ContentView;
    @SerializedName("ContentType")
    private String ContentType;
}
