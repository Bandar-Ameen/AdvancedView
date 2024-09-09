package com.astooltech.advancedview.proteus.v7.widget;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myspinnAdap extends RecyclerView.Adapter<myspinnAdap.Viewholderv> {

    @NonNull
    @Override
    public Viewholderv onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholderv holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public  class Viewholderv extends  RecyclerView.ViewHolder{


        public Viewholderv (@NonNull View itemView) {
            super(itemView);
        }
    }
}
