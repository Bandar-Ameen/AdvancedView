package com.astooltech.advancedview.proteus.v7;

import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;


public class mmodelinfalers {

    public Layout getNameinflater() {
        return nameinflater;
    }

    public mmodelinfalers(Layout nameinflater, int typeinflater, ObjectValue dataobj) {
        this.nameinflater = nameinflater;
        this.typeinflater = typeinflater;
        this.dataobj = dataobj;
    }

    public void setNameinflater(Layout nameinflater) {
        this.nameinflater = nameinflater;
    }

    public int getTypeinflater() {
        return typeinflater;
    }

    public void setTypeinflater(int typeinflater) {
        this.typeinflater = typeinflater;
    }

    public ObjectValue getDataobj() {
        return dataobj;
    }

    public void setDataobj(ObjectValue dataobj) {
        this.dataobj = dataobj;
    }

    private Layout nameinflater;
    private int typeinflater;
  private   ObjectValue dataobj;
}
