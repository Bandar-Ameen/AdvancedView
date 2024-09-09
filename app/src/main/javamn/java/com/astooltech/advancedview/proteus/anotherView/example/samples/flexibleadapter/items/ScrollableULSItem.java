package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * Item dedicated only for User Learns Selection view (located always at the top in the Adapter).
 * <p>This item is a Scrollable Header.</p>
 */
public class ScrollableULSItem extends AbstractItem<ScrollableULSItem.ULSViewHolder> {

    public ScrollableULSItem(String id) {
        super(id);
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return spanCount;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_scrollable_uls_item;
    }

    @Override
    public ULSViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ULSViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ULSViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();
        DrawableUtils.setBackgroundCompat(holder.itemView, DrawableUtils.getRippleDrawable(
                DrawableUtils.getColorDrawable(context.getResources().getColor(R.color.material_color_purple_50)),
                DrawableUtils.getColorControlHighlight(context))
        );
        holder.mImageView.setImageResource(R.drawable.ic_account_circle_white_24dp);
        holder.itemView.setActivated(true);
        holder.mTitle.setSelected(true);//For marquee!!
        holder.mTitle.setText(Utils.fromHtmlCompat(getTitle()));
        holder.mSubtitle.setText(Utils.fromHtmlCompat(getSubtitle()));
    }

    /**
     * Used for UserLearnsSelection.
     */
    class ULSViewHolder extends FlexibleViewHolder {

        ImageView mImageView;
        TextView mTitle;
        TextView mSubtitle;
        ImageView mDismissIcon;

        ULSViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);
            mImageView = view.findViewById(R.id.image);
            mDismissIcon = view.findViewById(R.id.dismiss_icon);
            mDismissIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseConfiguration.userLearnedSelection = true;
                    //Don't need anymore to set permanent deletion for Scrollable Headers and Footers
                    //mAdapter.setPermanentDelete(true);
                    //noinspection unchecked
                    mAdapter.removeScrollableHeader(ScrollableULSItem.this);
                    //mAdapter.setPermanentDelete(false);
                }
            });

            // Support for StaggeredGridLayoutManager
            setFullSpan(true);
        }

        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            AnimatorHelper.slideInFromTopAnimator(animators, itemView, mAdapter.getRecyclerView());
        }
    }

    @Override
    public String toString() {
        return "ScrollableULSItem[" + super.toString() + "]";
    }

}