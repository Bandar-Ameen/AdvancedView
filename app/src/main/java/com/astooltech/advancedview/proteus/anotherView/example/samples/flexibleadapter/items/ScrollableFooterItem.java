package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.anotherView.viewholders.AnimatedViewHolder;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * This item is a Scrollable Footer.
 */
public class ScrollableFooterItem extends AbstractItem<ScrollableFooterItem.FooterViewHolder> {

    public ScrollableFooterItem(String id) {
        super(id);
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return spanCount;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_scrollable_footer_item;
    }

    @Override
    public FooterViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new FooterViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, FooterViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();
        DrawableUtils.setBackgroundCompat(holder.itemView, DrawableUtils.getRippleDrawable(
                DrawableUtils.getColorDrawable(context.getResources().getColor(R.color.material_color_light_green_50)),
                DrawableUtils.getColorControlHighlight(context))
        );
        holder.mTitle.setText(Utils.fromHtmlCompat(getTitle()));
        holder.mSubtitle.setText(Utils.fromHtmlCompat(getSubtitle()));
    }

    class FooterViewHolder extends FlexibleViewHolder implements AnimatedViewHolder {

        TextView mTitle;
        TextView mSubtitle;
        ImageView mDismissIcon;

        FooterViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);
            mDismissIcon = view.findViewById(R.id.dismiss_icon);
            mDismissIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Don't need anymore to set permanent deletion for Scrollable Headers and Footers
                    //mAdapter.setPermanentDelete(true);
                    //noinspection unchecked
                    mAdapter.removeScrollableFooter(ScrollableFooterItem.this);
                    //mAdapter.setPermanentDelete(false);
                }
            });

            // Support for StaggeredGridLayoutManager
            setFullSpan(true);
        }

        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            AnimatorHelper.slideInFromBottomAnimator(animators, itemView, mAdapter.getRecyclerView());
        }

        @Override
        public boolean preAnimateAddImpl() {
            itemView.setTranslationY(itemView.getHeight());
            itemView.setAlpha(0);
            return true;
        }

        @Override
        public boolean preAnimateRemoveImpl() {
            return false;
        }

        @Override
        public boolean animateAddImpl(ViewPropertyAnimatorListener listener, long addDuration, int index) {
            ViewCompat.animate(itemView)
                      .translationY(0)
                      .alpha(1)
                      .setDuration(addDuration)
                      .setInterpolator(new DecelerateInterpolator())
                      .setListener(listener)
                      .start();
            return true;
        }

        @Override
        public boolean animateRemoveImpl(ViewPropertyAnimatorListener listener, long removeDuration, int index) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ScrollableFooterItem[" + super.toString() + "]";
    }

}