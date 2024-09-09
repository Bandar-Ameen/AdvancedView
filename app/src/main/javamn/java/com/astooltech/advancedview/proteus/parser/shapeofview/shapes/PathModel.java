package com.astooltech.advancedview.proteus.parser.shapeofview.shapes;

import com.google.gson.annotations.SerializedName;

public class PathModel {
    @SerializedName("Path_data")
    private String Path_data;
    @SerializedName("Color_Path")
    private String Color_Path;
    @SerializedName("typ")
    private int typ;

    public String getPath_data() {
        return Path_data;
    }

    public void setPath_data(String path_data) {
        Path_data = path_data;
    }

    public String getColor_Path() {
        return Color_Path;
    }

    public void setColor_Path(String color_Path) {
        Color_Path = color_Path;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }
}
