package com.astooltech.advancedview.proteus.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.proteus.ProteusView;


public class PrototoseSwiperView extends SwipeRefreshLayout implements ProteusView {

    private Manager viewManager;

    @SuppressLint("ResourceAsColor")
    public PrototoseSwiperView(Context context) {
        super(context);

      //  this.setBackgroundColor(R.color.green);
    }

    @Override
    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        return super.onResolvePointerIcon(event, pointerIndex);

       // PointerIcon.load(Resources.getSystem().).create(R.drawable.addbtn,0,0);
      //  MotionEvent.PointerProperties ff=new MotionEvent.PointerProperties();

       // event.
    }

    @SuppressLint("ResourceAsColor")
    public PrototoseSwiperView(Context context, AttributeSet attrs) {
        super(context, attrs);

       // this.setBackgroundColor(R.color.green);

    }



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
