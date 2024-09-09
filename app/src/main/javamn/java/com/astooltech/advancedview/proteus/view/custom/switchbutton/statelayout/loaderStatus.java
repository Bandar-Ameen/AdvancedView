package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout;

import android.view.View;

public class loaderStatus implements  StatusLoader.Adapter {



    @Override
    public View getView(StatusLoader.Holder holder, View convertView, int status) {
        return new DefaultStatusView(holder.getContext(),status,holder.getRetryListener());
    }
}
