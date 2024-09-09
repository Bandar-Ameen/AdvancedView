package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.v7.widget.SpainnerViewB;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.HashMap;
import java.util.Map;


public class SppinerViewAdapterFactory {

    private Map<String, SpainnerViewParserAdapter.Builder> adapters = new HashMap<>();

    public void register(@NonNull String type, @NonNull SpainnerViewParserAdapter.Builder builder) {
        adapters.put(type, builder);
    }

    @Nullable
    public SpainnerViewParserAdapter.Builder remove(@NonNull String type) {
        return adapters.remove(type);
    }

    public SpainnerViewParserAdapter create(@NonNull String type, @NonNull SpainnerViewB view, @NonNull ObjectValue config) {
        return adapters.get(type).create(view, config);
    }
}
