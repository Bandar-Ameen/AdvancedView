package com.astooltech.advancedview.proteus.v7.adapter;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.autoimageslider.SliderViewAdapter;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.custom.PrototuseSliderView;


public abstract class ProteusSliderAddapter<VH extends ProtousSliderHolder> extends SliderViewAdapter<VH> {


    public interface Builder<A extends ProteusSliderAddapter> {
        @NonNull
        A create(@NonNull PrototuseSliderView view, @NonNull ObjectValue config);
    }

}