package com.astooltech.advancedview.proteus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/**
 * Layout with amount of Overlay views.
 * Created by lsjwzh on 14-8-9.
 */
public abstract class MultiOverlayLayout extends FrameLayout {

    protected SparseArray<View> mOverlays = new SparseArray<View>();
    protected View mTargetView;
    protected MultiOverlayAdapter mMultiOverlayAdapter;

    public MultiOverlayLayout(Context context) {
        super(context);
    }

    public MultiOverlayLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiOverlayLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    /**
     * use LoadingLayout itself to wrap and replace the targetView.
     * Note: if you attachTo targetView on 'onCreate' method,targetView may be not layout complete.
     *
     * @param targetView
     * @return
     */
    public void attachTo(final View targetView){
        if(targetView==null){
            throw new IllegalArgumentException();
        }
        mTargetView = targetView;

        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        this.setLayoutParams(layoutParams);
        if(targetView.getParent()!=null&&targetView.getParent() instanceof ViewGroup){
            ViewGroup targetViewParent = (ViewGroup) targetView.getParent();
            int targetViewPosInParent = targetViewParent.indexOfChild(targetView);
            targetViewParent.removeView(targetView);
            targetViewParent.addView(this,targetViewPosInParent);
            this.addView(targetView);
        }else {
            ViewUtil.addGlobalLayoutListenerOnce(targetView, new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    if (targetView.getParent() == null) {
                        return;
                    }
                    ViewGroup targetViewParent = (ViewGroup) targetView.getParent();
                    int targetViewPosInParent = targetViewParent.indexOfChild(targetView);
                    targetViewParent.removeView(targetView);
                    targetViewParent.addView(MultiOverlayLayout.this, targetViewPosInParent);
                    MultiOverlayLayout.this.addView(targetView);
                }
            });
        }
    }

    public void setAdapter(MultiOverlayAdapter multiOverlayAdapter){
        this.mMultiOverlayAdapter = multiOverlayAdapter;
        checkAdapter();
    }

    public MultiOverlayAdapter getAdapter(){
        return mMultiOverlayAdapter;
    }

    /**
     * show overlay at spec position
     * @param index
     */
    public void showOverlay(int index){
        checkAdapter();
        checkIndexBound(index);
        if(mOverlays.get(index)==null) {
            mOverlays.put(index,mMultiOverlayAdapter.getView(index,mTargetView));
            this.addView(mOverlays.get(index),index<getChildCount()?index:getChildCount());
        }
        mOverlays.get(index).setVisibility(VISIBLE);
    }

    /**
     * hide overlay at spec position
     * @param index
     */
    public void hideOverlay(int index){
        checkAdapter();
        checkIndexBound(index);
        if(mOverlays.get(index)!=null) {
            mOverlays.get(index).setVisibility(GONE);
        }
    }

    public boolean isOverlayShown(int index){
        return mOverlays.get(index)!=null && mOverlays.get(index).getVisibility()==VISIBLE;
    }

    public View getOverlayView(int index){
        return mOverlays.get(index);
    }

    void checkAdapter(){
        if(mMultiOverlayAdapter==null){
            throw new IllegalStateException("must set adapter before");
        }
    }
    void checkIndexBound(int index) {
        if(index>=mMultiOverlayAdapter.getCount()){
            throw new IndexOutOfBoundsException();
        }
    }

}
