package com.astooltech.advancedview.proteus.v7.adapter;

import android.animation.Animator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;


public class ProtoisVHH  extends FlexibleViewHolder {

    @NonNull
    ProteusContext context;

    @NonNull
    public ProteusView view;

    public   ProtoisVHH(@NonNull ProteusView view, FlexibleAdapter adp) {
        super(view.getAsView(), adp, true);
        //super(view.getAsView(),adp);


        this.view = view;
        this.context = view.getViewManager().getContext();
        setFullSpan(true);
   /* com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(this.view.getAsView())
            .rippleOverlay(true).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(true).create();
*/
    }

/*
    @Override
    public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
        if (mAdapter.getRecyclerView().getLayoutManager() instanceof GridLayoutManager) {
            if (position % 2 != 0)
                AnimatorHelper.slideInFromRightAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
            else
                AnimatorHelper.slideInFromLeftAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
        } else {
            if (isForward)
                AnimatorHelper.slideInFromBottomAnimator(animators, itemView, mAdapter.getRecyclerView());
            else
                AnimatorHelper.slideInFromTopAnimator(animators, itemView, mAdapter.getRecyclerView());
        }
    }*/

}
