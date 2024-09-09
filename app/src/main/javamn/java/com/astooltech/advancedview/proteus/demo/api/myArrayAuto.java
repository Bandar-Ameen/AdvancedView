package com.astooltech.advancedview.proteus.demo.api;

import com.astooltech.advancedview.proteus.value.ObjectValue;

public class myArrayAuto {
    public myArrayAuto(String tagname, ObjectValue datasorsce) {
        this.tagname = tagname;
        Datasorsce = datasorsce;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public ObjectValue getDatasorsce() {
        return Datasorsce;
    }

    public void setDatasorsce(ObjectValue datasorsce) {
        Datasorsce = datasorsce;
    }

    private  String tagname;
    private ObjectValue Datasorsce;
}
