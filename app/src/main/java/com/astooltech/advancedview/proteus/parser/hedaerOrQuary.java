package com.astooltech.advancedview.proteus.parser;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class hedaerOrQuary {

    public hedaerOrQuary(String keyName, String keyValue, String keyType, String viewName) {
        this.keyName = keyName;
        KeyValue = keyValue;
        KeyType = keyType;
        ViewName = viewName;
    }
    @SerializedName("keyName")
    private  String keyName;
    @SerializedName("KeyValue")
    private  String KeyValue;

    public Map<String, Object> getDatvalue() {
        return datvalue;
    }

    public void setDatvalue(Map<String, Object> datvalue) {
        this.datvalue = datvalue;
    }

    private Map<String,Object> datvalue;
    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return KeyValue;
    }

    public void setKeyValue(String keyValue) {
        KeyValue = keyValue;
    }

    public String getKeyType() {
        return KeyType;
    }

    public void setKeyType(String keyType) {
        KeyType = keyType;
    }

    public String getViewName() {
        return ViewName;
    }

    public void setViewName(String viewName) {
        ViewName = viewName;
    }
    @SerializedName("KeyType")
    private  String KeyType;
    @SerializedName("ViewName")
    private  String ViewName;

}
