package com.astooltech.advancedview.proteus.v7.adapter;

import com.google.gson.annotations.SerializedName;

public class modeltypeview {


    @SerializedName("v_Name")
    private  String vName;
    @SerializedName("v_ColumnName")
    private String vColumnName;
    @SerializedName("v_EqualValue")
    private  String vEqualValue;

    public String getV_id() {
        return vid;
    }

    public void setV_id(String v_id) {
        this.vid = v_id;
    }

    @SerializedName("v_id")
    private  String vid;
    public String getV_Name() {
        return vName;
    }

    public void setV_Name(String v_Name) {
        this.vName = v_Name;
    }

    public String getV_ColumnName() {
        return vColumnName;
    }

    public void setV_ColumnName(String v_ColumnName) {
        this.vColumnName = v_ColumnName;
    }

    public String getV_EqualValue() {
        return vEqualValue;
    }

    public modeltypeview(String v_Name, String v_ColumnName, String v_EqualValue, String v_id) {
        this.vName = v_Name;
        this.vColumnName = v_ColumnName;
        this.vEqualValue = v_EqualValue;
        this.vid = v_id;
    }

    public void setV_EqualValue(String v_EqualValue) {
        this.vEqualValue = v_EqualValue;
    }
}
