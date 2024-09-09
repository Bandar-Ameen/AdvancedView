package com.astooltech.advancedview.proteus.v7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteFilter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteProvider;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<AbstractFlexibleItem> {


    private List<AbstractFlexibleItem> mListItems;
    private ExtendedDictionaryAutocompleteProvider mExtendedDictionaryAutocompleteProvider;
    private ExtendedDictionaryAutocompleteFilter mDictionaryAutocompleteFilter;
    private LayoutInflater mLayoutInflater;
    private  boolean usemultiple;
    private int mLayoutId;
    private ProteusLayoutInflater layoutInflaterrr;
    public SpinnerAdapter(Context context, int textViewResourceId, List<AbstractFlexibleItem> g, ProteusLayoutInflater layoutInflaterr, ProteusView ck, List<modeltypeview> datatyp, boolean usemultiple) {
        super(context, 0);

        this.usemultiple=usemultiple;
        layoutInflaterrr=layoutInflaterr;
        mListItems = new ArrayList<>();
        mLayoutId = 0;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
