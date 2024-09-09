package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.v7.widget.AutoCompleteTextViewB;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.HashMap;
import java.util.Map;


public class AutoCompleteTextViewFactory {

    private Map<String, AutoCompleteTextViewBparserAdapter.Builder> adapters = new HashMap<>();

    public void register(@NonNull String type, @NonNull AutoCompleteTextViewBparserAdapter.Builder builder) {
        adapters.put(type, builder);
    }

    @Nullable
    public AutoCompleteTextViewBparserAdapter.Builder remove(@NonNull String type) {
        return adapters.remove(type);
    }

    public AutoCompleteTextViewBparserAdapter create(@NonNull String type, @NonNull AutoCompleteTextViewB view, @NonNull ObjectValue config) {
        return adapters.get(type).create(view, config);
    }
}