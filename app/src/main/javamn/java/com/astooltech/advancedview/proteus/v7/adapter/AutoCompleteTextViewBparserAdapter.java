package com.astooltech.advancedview.proteus.v7.adapter;

import android.widget.BaseAdapter;
import android.widget.Filterable;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.v7.widget.AutoCompleteTextViewB;
import com.astooltech.advancedview.proteus.value.ObjectValue;


public abstract class AutoCompleteTextViewBparserAdapter <  VH extends VHH> extends BaseAdapter implements Filterable {




    public interface Builder<A extends AutoCompleteTextViewBparserAdapter > {
        @NonNull
        A create(@NonNull AutoCompleteTextViewB view, @NonNull ObjectValue config);
    }

}