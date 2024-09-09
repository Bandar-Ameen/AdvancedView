package com.astooltech.advancedview.finaldemo.opengraphview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.finaldemo.fragments.AdvancedWebView;


public class OpenGraphViewProtouse extends OpenGraphView implements ProteusView {

    private Manager viewManager;

    public OpenGraphViewProtouse(Context context) {
        super(context);
    }

    public OpenGraphViewProtouse(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OpenGraphViewProtouse(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProteusWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
      super(context, attrs, defStyleAttr, defStyleRes);
    }
  */
    @Override
    public Manager getViewManager() {
        return viewManager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {
        this.viewManager = manager;
    }

    @NonNull
    @Override
    public View getAsView() {
        return this;
    }
}
