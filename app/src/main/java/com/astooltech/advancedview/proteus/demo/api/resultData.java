package com.astooltech.advancedview.proteus.demo.api;

import com.google.gson.annotations.SerializedName;

public class resultData {



    @SerializedName("ID_unit")
    private Integer iDUnit;

    public Integer getiDUnit() {
        return iDUnit;
    }

    public void setiDUnit(Integer iDUnit) {
        this.iDUnit = iDUnit;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDataGet() {
        return DataGet;
    }

    public void setDataGet(String dataGet) {
        DataGet = dataGet;
    }

    public resultData(Integer iDUnit, String unitName, String dataGet) {
        this.iDUnit = iDUnit;
        this.unitName = unitName;
        DataGet = dataGet;
    }

    @SerializedName("unit_name")
    private String unitName;

    @SerializedName("getData_ID")
    private String DataGet;
}
