package com.astooltech.advancedview.proteus.parser.expandablelayout;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;

import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;

/**
 * Created by SilenceDut on 16/8/21.
 */

class Utils {

     static ScrolledParent getScrolledParent (ViewGroup child) {

        ViewParent parent= child.getParent();
        int childBetweenParentCount =0;
        while (parent!=null){
            if((parent instanceof RecyclerView || parent instanceof AbsListView)) {
                ScrolledParent scrolledParent = new ScrolledParent();
                scrolledParent.scrolledView = (ViewGroup)parent;
                scrolledParent.childBetweenParentCount =childBetweenParentCount;
                return scrolledParent;
            }
            if((parent instanceof ProteusRecyclerView || parent instanceof AbsListView)) {
                ScrolledParent scrolledParent = new ScrolledParent();
                scrolledParent.scrolledView = (ViewGroup)parent;
                scrolledParent.childBetweenParentCount =childBetweenParentCount;
                return scrolledParent;
            }


            childBetweenParentCount++;
            parent = parent.getParent();
        }
        return null;
    }

    static ValueAnimator createParentAnimator(final View parent,int distance ,long duration) {

        ValueAnimator parentAnimator = ValueAnimator.ofInt(0,distance);

        parentAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            int lastDy;
            int dy;
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dy = (int)animation.getAnimatedValue()-lastDy;
                lastDy = (int)animation.getAnimatedValue();
                parent.scrollBy(0,dy);
            }
        });
        parentAnimator.setDuration(duration);

        return  parentAnimator;
    }




}
