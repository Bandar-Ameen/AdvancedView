package com.astooltech.advancedview.proteus.v7.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;

import java.util.List;

public class arryAdppterr extends ArrayAdapter {

    @NonNull
    final ProteusContext context;

    @NonNull
    public final ProteusView view;
    public arryAdppterr(ProteusView view,ProteusContext contextt,@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
        super(context, resource, textViewResourceId, objects);
        this.view = view;
        this.context = view.getViewManager().getContext();
    }
}
