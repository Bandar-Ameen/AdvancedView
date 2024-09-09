package com.astooltech.advancedview.proteus.v7.widget;

import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

public class datafiltermo {



    private ObjectValue afterproces;
    private Value data;
    private  boolean useVolleyy;


    public ObjectValue getAfterproces() {
        return afterproces;
    }

    public void setAfterproces(ObjectValue afterproces) {
        this.afterproces = afterproces;
    }

    public Value getData() {
        return data;
    }

    public void setData(Value data) {
        this.data = data;
    }

    public boolean isUseVolleyy() {
        return useVolleyy;
    }

    public void setUseVolleyy(boolean useVolleyy) {
        this.useVolleyy = useVolleyy;
    }
}
