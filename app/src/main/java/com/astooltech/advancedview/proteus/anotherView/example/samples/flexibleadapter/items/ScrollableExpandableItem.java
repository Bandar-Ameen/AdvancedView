package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IExpandable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.anotherView.viewholders.ExpandableViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Scrollable Header and Footer Item that can be expanded too. When visible, all the subItems
 * will be Headers or Footers as well, depending where the parent has been initially added!
 */
public class ScrollableExpandableItem extends AbstractItem<ScrollableExpandableItem.ScrollableExpandableViewHolder>
        implements IExpandable<ScrollableExpandableItem.ScrollableExpandableViewHolder, ScrollableSubItem> {

    /* Flags for FlexibleAdapter */
    private boolean mExpanded = false;

    /* subItems list */
    private List<ScrollableSubItem> mSubItems;


    public ScrollableExpandableItem(String id) {
        super(id);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_scrollable_expandable_item;
    }

    @Override
    public ScrollableExpandableViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ScrollableExpandableViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, ScrollableExpandableViewHolder holder, int position, List payloads) {
        Context context = holder.itemView.getContext();
        DrawableUtils.setBackgroundCompat(holder.itemView, DrawableUtils.getRippleDrawable(
                DrawableUtils.getColorDrawable(context.getResources().getColor(R.color.material_color_amber_50)),
                DrawableUtils.getColorControlHighlight(context))
        );
        holder.mTitle.setSelected(true);//For marquee!!
        holder.mTitle.setText(Utils.fromHtmlCompat(getTitle()));
        holder.mSubtitle.setText(Utils.fromHtmlCompat(getSubtitle()));
    }

    @Override
    public boolean isExpanded() {
        return mExpanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.mExpanded = expanded;
    }

    @Override
    public int getExpansionLevel() {
        return 0;
    }

    @Override
    public List<ScrollableSubItem> getSubItems() {
        return mSubItems;
    }

    public void addSubItem(ScrollableSubItem subItem) {
        if (mSubItems == null)
            mSubItems = new ArrayList<>();
        mSubItems.add(subItem);
    }

    static class ScrollableExpandableViewHolder extends ExpandableViewHolder {

        public TextView mTitle;
        public TextView mSubtitle;

        ScrollableExpandableViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true);
            mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);

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
        return "ScrollableExpandableItem[" + super.toString() + "]";
    }
}