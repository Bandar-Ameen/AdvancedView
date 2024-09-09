package com.astooltech.advancedview.proteus.demo.api;

import com.google.gson.annotations.SerializedName;

public class OpenActivityModel {

    public String getApibody() {
        return apibody;
    }

    public void setApibody(String apibody) {
        this.apibody = apibody;
    }

    public String getApiquery() {
        return apiquery;
    }

    public void setApiquery(String apiquery) {
        this.apiquery = apiquery;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiheader() {
        return apiheader;
    }

    public void setApiheader(String apiheader) {
        this.apiheader = apiheader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyresponse() {
        return keyresponse;
    }

    public void setKeyresponse(String keyresponse) {
        this.keyresponse = keyresponse;
    }
    @SerializedName("keyresponse")
    private  String keyresponse;
    @SerializedName("apibody")
    private String apibody;
    @SerializedName("apiquery")
    private String apiquery;
    @SerializedName("method")
    private String method;
    @SerializedName("url")
    private String url;
    @SerializedName("apiheader")
    private String apiheader;
    @SerializedName("type")
    private String type;
}
