package com.astooltech.advancedview.proteus.anotherView.example.samples.anim;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class FlipDownItemAnimator extends PendingItemAnimator {

    public FlipDownItemAnimator() {
        setAddDuration(1000);
        setRemoveDuration(500);
    }

    @Override
    protected boolean prepHolderForAnimateRemove(ViewHolder holder) {
        return true;
    }

    @Override
    protected ViewPropertyAnimatorCompat animateRemoveImpl(ViewHolder holder) {
        return ViewCompat.animate(holder.itemView)
                         .rotationY(90)
                         .translationX(-(holder.itemView.getMeasuredWidth() / 4))
                         .scaleX(0.5F)
                         .scaleY(0.5F)
                         .setInterpolator(new AccelerateInterpolator());
    }

    @Override
    protected void onRemoveCanceled(ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView, 0);
        ViewCompat.setTranslationX(holder.itemView, 0);
        ViewCompat.setScaleX(holder.itemView, 1);
        ViewCompat.setScaleY(holder.itemView, 1);
    }

    @Override
    protected boolean prepHolderForAnimateAdd(ViewHolder holder) {
        ViewCompat.setTranslationX(holder.itemView, -(holder.itemView.getMeasuredWidth() / 2));
        ViewCompat.setRotationY(holder.itemView, -90);
        return true;
    }

    @Override
    protected ViewPropertyAnimatorCompat animateAddImpl(ViewHolder holder) {
        return ViewCompat.animate(holder.itemView)
                         .rotationY(0)
                         .translationX(0)
                         .setInterpolator(new BounceInterpolator());
    }

    @Override
    protected void onAddCanceled(ViewHolder holder) {
        ViewCompat.setRotationY(holder.itemView, 0);
        ViewCompat.setTranslationX(holder.itemView, 0);
    }
}
