package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;

public class Autocmpleteadter extends ArrayAdapter<AbstractFlexibleItem> {
    public Autocmpleteadter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
