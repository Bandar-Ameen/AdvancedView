package com.astooltech.advancedview.proteus.v7.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;


public class VHA extends BaseAdap {
    @NonNull
    final ProteusContext context;

    @NonNull
    public final ProteusView view;


    VHA(@NonNull ProteusView view, int resource) {
        super(view,resource);
        // super(view);
        this.view = view;
        this.context = view.getViewManager().getContext();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    public Filter getallFilt(){

        return  getFilter();
    }
    @NonNull
    @Override
    public Filter getFilter() {
        return super.getFilter();
    }


}
