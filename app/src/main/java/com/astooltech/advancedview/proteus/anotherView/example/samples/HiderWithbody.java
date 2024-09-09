package com.astooltech.advancedview.proteus.anotherView.example.samples;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ScrollHederItems;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.bodyHedaer;

import java.util.List;

public class HiderWithbody {

    public ScrollHederItems getScrollHeder() {
        return ScrollHeder;
    }

    public void setScrollHeder(ScrollHederItems scrollHeder) {
        ScrollHeder = scrollHeder;
    }

    private ScrollHederItems ScrollHeder;
    public int getHiderGroup() {
        return HiderGroup;
    }

    public void setHiderGroup(int hiderGroup) {
        HiderGroup = hiderGroup;
    }

    public String getHedrgropName() {
        return hedrgropName;
    }

    public void setHedrgropName(String hedrgropName) {
        this.hedrgropName = hedrgropName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<bodyHedaer> getBodydata() {
        return bodydata;
    }

    public void setBodydata(List<bodyHedaer> bodydata) {
        this.bodydata = bodydata;
    }

    private int HiderGroup;
    private String hedrgropName;
    private  int order;

    private List<bodyHedaer> bodydata;

}
