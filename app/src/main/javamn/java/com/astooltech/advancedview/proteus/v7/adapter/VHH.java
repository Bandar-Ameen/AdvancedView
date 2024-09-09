package com.astooltech.advancedview.proteus.v7.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;

public class VHH extends BaseAdap  {
    @NonNull
    final ProteusContext context;

    @Override
    public void addAll(Object[] items) {
        super.addAll(items);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @NonNull
    public final ProteusView view;


      VHH(@NonNull ProteusView view, int resource) {
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

    public  Filter getallFilt(){

          return  getFilter();
    }
    @NonNull
    @Override
    public Filter getFilter() {
        return super.getFilter();
    }


}
