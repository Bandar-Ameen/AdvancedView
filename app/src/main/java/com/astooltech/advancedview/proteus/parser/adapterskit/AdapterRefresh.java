package com.astooltech.advancedview.proteus.parser.adapterskit;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;

import java.util.List;
import java.util.Map;

public interface AdapterRefresh {

    void OnGetData(Map<String, List<AbstractFlexibleItem>> data);
}
