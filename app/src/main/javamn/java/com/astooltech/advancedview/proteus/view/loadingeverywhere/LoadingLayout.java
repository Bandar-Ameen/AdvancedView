package com.astooltech.advancedview.proteus.view.loadingeverywhere;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.view.widget.OverlayLayout;


/**
 * Layout with a loading mask.
 * Created by lsjwzh on 14-8-9.
 */
public class LoadingLayout extends OverlayLayout {

    /**
     * create a LoadingLayout to wrap and replace the targetView.
     * Note: if you attachTo targetView on 'onCreate' method,targetView may be not layout complete.
     *
     * @param targetView
     * @return
     */
    public static LoadingLayout wrap(final View targetView){
         return wrap(targetView,android.R.attr.progressBarStyleLarge);
    }
    /**
     * create a LoadingLayout to wrap and replace the targetView.
     * Note: if you attachTo targetView on 'onCreate' method,targetView may be not layout complete.
     *
     * @param targetView
     * @return
     */
    public static LoadingLayout wrap(final View targetView, final int progressBarStyle){
        if(targetView==null){
            throw new IllegalArgumentException();
        }

        final LoadingLayout loadingLayout = new LoadingLayout(targetView.getContext()){
            @Override
            protected View createProgressBar() {
                return new ProgressBar(getContext(),null,progressBarStyle);
            }
        };
        loadingLayout.attachTo(targetView);
        return loadingLayout;
    }

    /**
     * reference to progressBarStyle
     */
    protected int mProgressBarStyle;

    public LoadingLayout(Context context) {
        super(context);
    }

    public LoadingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoadingLayout,
                defStyle, 0);

        mProgressBarStyle = a.getInt(
                R.styleable.LoadingLayout_leeProgressBarStyle, android.R.attr.progressBarStyleLarge);
        a.recycle();
    }


    public void showLoading(){
        showOverlay();
    }

    public void hideLoading(){
        hideOverlay();
    }

    public void setIsHideTargetViewWhenLoading(boolean isHideTargetViewWhenLoading){
        setIsHideTargetViewWhenOverlayShown(isHideTargetViewWhenLoading);
    }

    public boolean isLoadingMaskShown(){
        return isOverlayShown();
    }

    public View getLoadingMask(){
        return super.mOverlay;
    }

    /**
     * create loading mask
     * @return
     */
   /* @Override
    protected View createOverlayView() {
        LinearLayout ll = new LinearLayout(getContext());
        ll.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));
        ll.setGravity(Gravity.CENTER);
        View progressBar = createProgressBar();
        ll.addView(progressBar);
        return ll;
    }
*/
    protected View createProgressBar() {
        return new ProgressBar(getContext(),null,mProgressBarStyle);
    }
}
