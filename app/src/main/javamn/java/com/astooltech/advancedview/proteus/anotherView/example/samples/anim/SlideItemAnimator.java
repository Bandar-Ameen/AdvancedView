package com.astooltech.advancedview.proteus.anotherView.example.samples.anim;

import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;

public class SlideItemAnimator extends PendingItemAnimator {

    public SlideItemAnimator() {
        setAddDuration(1000);
        setRemoveDuration(500);
        setMoveDuration(500);
    }

    @Override
    protected boolean prepHolderForAnimateRemove(ViewHolder holder) {
        return true;
    }

    protected ViewPropertyAnimatorCompat animateRemoveImpl(ViewHolder holder) {
        final View view = holder.itemView;
        ViewCompat.animate(view).cancel();
        return ViewCompat.animate(view)
                         .translationX(Utils.getScreenDimensions(holder.itemView.getContext()).x)
                         .setInterpolator(new AnticipateOvershootInterpolator());
    }

    @Override
    protected void onRemoveCanceled(ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, 0);
    }

    @Override
    protected boolean prepHolderForAnimateAdd(ViewHolder holder) {
        int width = getWidth(holder);
        ViewCompat.setTranslationX(holder.itemView, width);
        return true;
    }

    protected ViewPropertyAnimatorCompat animateAddImpl(ViewHolder holder) {
        final View view = holder.itemView;
        ViewCompat.animate(view).cancel();
        int width = getWidth(holder);
        return ViewCompat.animate(view)
                         .translationXBy(-width)
                         .setInterpolator(new BounceInterpolator());
    }

    @Override
    protected void onAddCanceled(ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, 0);
    }

    public int getWidth(ViewHolder holder) {
        return getWidth(holder.itemView);
    }

    public int getWidth(View itemView) {
        return itemView.getMeasuredWidth() + itemView.getPaddingRight() + ((LayoutParams) itemView.getLayoutParams()).rightMargin;
    }
}