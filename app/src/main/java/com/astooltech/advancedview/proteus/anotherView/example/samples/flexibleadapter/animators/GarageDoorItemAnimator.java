package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators;

import android.view.animation.Interpolator;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemAnimator;

public class GarageDoorItemAnimator extends FlexibleItemAnimator {

    public GarageDoorItemAnimator() {
    }

    public GarageDoorItemAnimator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    @Override
    protected void animateRemoveImpl(ViewHolder holder, int index) {
        ViewCompat.animate(holder.itemView)
                  .rotationX(90)
                  .translationY(-(holder.itemView.getMeasuredHeight() / 2))
                  .setDuration(300)
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultRemoveVpaListener(holder))
                  .start();
    }

    @Override
    protected boolean preAnimateAddImpl(ViewHolder holder) {
        holder.itemView.setRotationX(90);
        return true;
    }

    @Override
    protected void animateAddImpl(ViewHolder holder, int index) {
        holder.itemView.setTranslationY(-(holder.itemView.getMeasuredHeight() / 2));//This must stay here
        ViewCompat.animate(holder.itemView)
                  .rotationX(0)
                  .translationY(0)
                  .setDuration(300)
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultAddVpaListener(holder))
                  .start();
    }

}