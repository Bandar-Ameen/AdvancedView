package com.astooltech.advancedview.proteus.parser;

import android.os.Parcel;
import android.os.Parcelable;

public class ValuesModel implements Parcelable {
    public static final Creator<ValuesModel> CREATOR = new Creator<ValuesModel>() {
        public ValuesModel createFromParcel(Parcel in) {
            return new ValuesModel(in);
        }

        public ValuesModel[] newArray(int size) {
            return new ValuesModel[size];
        }
    };
    String headerType;
    String key;
    String value;

    public ValuesModel(String key, String value, String headerType) {
        setKey(key);
        setValue(value);
        setHeaderType(headerType);
    }

    public String getHeaderType() {
        return this.headerType;
    }

    public void setHeaderType(String headerType) {
        this.headerType = headerType;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    protected ValuesModel(Parcel in) {
        this.key = in.readString();
        this.value = in.readString();
        this.headerType = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.key);
        dest.writeString(this.value);
        dest.writeString(this.headerType);
    }
}
