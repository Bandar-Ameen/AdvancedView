package com.astooltech.advancedview.proteus.v7.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;

public class BaseAdap extends ArrayAdapter {


    public BaseAdap(@NonNull ProteusView view,int resource) {
        super(view.getAsView().getContext(),resource);
        this.context = view.getViewManager().getContext();
        this.view = view;
    }

    @NonNull
    final ProteusContext context;

    @NonNull
    public final ProteusView view;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }


    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    public ProteusView getView() {
        return view;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override

    public ProteusContext getContext() {
        return context;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return super.getFilter();
    }
}
