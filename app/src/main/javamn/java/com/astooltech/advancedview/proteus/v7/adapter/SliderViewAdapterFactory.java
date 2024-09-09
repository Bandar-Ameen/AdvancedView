package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.custom.PrototuseSliderView;

import java.util.HashMap;
import java.util.Map;


public class SliderViewAdapterFactory {

    private Map<String, ProteusSliderAddapter.Builder> adapters = new HashMap<>();

    public void register(@NonNull String type, @NonNull ProteusSliderAddapter.Builder builder) {
        adapters.put(type, builder);
    }

    @Nullable
    public ProteusSliderAddapter.Builder remove(@NonNull String type) {
        return adapters.remove(type);
    }

    public ProteusSliderAddapter create(@NonNull String type, @NonNull PrototuseSliderView view, @NonNull ObjectValue config) {
        return adapters.get(type).create(view, config);
    }
}
