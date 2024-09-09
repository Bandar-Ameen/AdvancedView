package com.astooltech.advancedview.proteus.demo.api;

import com.google.gson.annotations.SerializedName;

public class URLdatamodel {

    @SerializedName("url")
    private  String baseurl;

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public String getMethodurl() {
        return methodurl;
    }

    public void setMethodurl(String methodurl) {
        this.methodurl = methodurl;
    }
    @SerializedName("m")
    private  String methode;
    @SerializedName("murl")
    private String methodurl;
}
