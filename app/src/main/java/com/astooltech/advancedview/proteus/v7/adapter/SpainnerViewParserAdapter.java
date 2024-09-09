package com.astooltech.advancedview.proteus.v7.adapter;

import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.v7.widget.SpainnerViewB;
import com.astooltech.advancedview.proteus.value.ObjectValue;


public abstract class SpainnerViewParserAdapter< VH extends VHH> extends BaseAdapter {


    public interface Builder<A extends SpainnerViewParserAdapter> {
        @NonNull
        A create(@NonNull SpainnerViewB view, @NonNull ObjectValue config);
    }

}


