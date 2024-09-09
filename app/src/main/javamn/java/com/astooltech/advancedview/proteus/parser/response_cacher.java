package com.astooltech.advancedview.proteus.parser;


import com.google.gson.annotations.SerializedName;


public class response_cacher {

    @SerializedName("message")
   // @Expose
    private String message;
    @SerializedName("statuseCode")
   // @Expose
    private String statuseCode;
    @SerializedName("data")
   // @Expose
    private String data;
  //  private final static long serialVersionUID = -496570370621150240L;

    /**
     * No args constructor for use in serialization
     *
     */
    public response_cacher() {
    }

    /**
     *
     * @param data
     * @param message
     * @param statuseCode
     */
    public response_cacher(String message, String statuseCode, String data) {
        super();
        this.message = message;
        this.statuseCode = statuseCode;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatuseCode() {
        return statuseCode;
    }

    public void setStatuseCode(String statuseCode) {
        this.statuseCode = statuseCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
