package com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusView;

public class CustomeWeb extends android.widget.LinearLayout implements ProteusView {

    private Manager viewManager;

    public CustomeWeb(Context context) {
        super(context);
    }

    public CustomeWeb(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomeWeb(Context context, AttributeSet attrs, int defStyleAttr) {
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
