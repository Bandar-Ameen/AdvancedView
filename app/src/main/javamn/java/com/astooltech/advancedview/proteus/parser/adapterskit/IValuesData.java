package com.astooltech.advancedview.proteus.parser.adapterskit;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;

import java.util.List;
import java.util.Map;

public interface IValuesData {
    void sendData(String datab, int typdata);
    void setDataAdvanced(Map<String, List<AbstractFlexibleItem>> datresult, int typ);
}
