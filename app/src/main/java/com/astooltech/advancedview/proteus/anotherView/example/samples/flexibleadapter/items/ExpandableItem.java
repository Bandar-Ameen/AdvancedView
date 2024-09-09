package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IExpandable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.ISectionable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.FlexibleUtils;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.proteus.anotherView.viewholders.ExpandableViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * If you don't have fields in common better to extend directly from
 * {@link  com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractExpandableItem} to benefit of the already
 * implemented methods around subItems list.
 */
public class ExpandableItem extends AbstractItem<ExpandableItem.ParentViewHolder>
        implements ISectionable<ExpandableItem.ParentViewHolder, HeaderItem>,
        IExpandable<ExpandableItem.ParentViewHolder, SubItem>,
        IFilterable<String> {

    /* The header of this item */
    HeaderItem header;

    /* subItems list */
    private List<SubItem> mSubItems;

    /* Flags for FlexibleAdapter */
    private boolean mExpanded = false;

    public ExpandableItem(String id, HeaderItem header) {
        super(id);
        this.header = header;
        setDraggable(true);
        setSwipeable(true);
    }

    @Override
    public HeaderItem getHeader() {
        return header;
    }

    @Override
    public void setHeader(HeaderItem header) {
        this.header = header;
    }

    @Override
    public boolean isExpanded() {
        return mExpanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        mExpanded = expanded;
    }

    @Override
    public int getExpansionLevel() {
        return 0;
    }

    @Override
    public List<SubItem> getSubItems() {
        return mSubItems;
    }

    public final boolean hasSubItems() {
        return mSubItems != null && mSubItems.size() > 0;
    }

    public boolean removeSubItem(SubItem item) {
        return item != null && mSubItems.remove(item);
    }

    public boolean removeSubItem(int position) {
        if (mSubItems != null && position >= 0 && position < mSubItems.size()) {
            mSubItems.remove(position);
            return true;
        }
        return false;
    }

    public void addSubItem(SubItem subItem) {
        if (mSubItems == null)
            mSubItems = new ArrayList<>();
        mSubItems.add(subItem);
    }

    public void addSubItem(int position, SubItem subItem) {
        if (mSubItems != null && position >= 0 && position < mSubItems.size()) {
            mSubItems.add(position, subItem);
        } else
            addSubItem(subItem);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_expandable_item;
    }

    @Override
    public ParentViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ParentViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter<IFlexible> adapter, ParentViewHolder holder, int position, List<Object> payloads) {
        Context context = holder.itemView.getContext();

        // Subtitle
        setSubtitle(adapter.getCurrentChildren(this).size() + " subItems"
                + (getHeader() != null ? " - " + getHeader().getId() : "")
                + (getUpdates() > 0 ? " - u" + getUpdates() : ""));

        // Background, when bound the first time
        if (payloads.size() == 0) {
            Drawable drawable = DrawableUtils.getSelectableBackgroundCompat(
                    Color.WHITE, Color.parseColor("#dddddd"), // Same color of divider
                    DrawableUtils.getColorControlHighlight(context));
            DrawableUtils.setBackgroundCompat(holder.itemView, drawable);
            DrawableUtils.setBackgroundCompat(holder.frontView, drawable);
        }

        if (payloads.size() > 0) {
            Log.d(this.getClass().getSimpleName(), "ExpandableItem Payload " + payloads);
            if (adapter.hasFilter()) {
                FlexibleUtils.highlightText(holder.mSubtitle, getSubtitle(), adapter.getFilter(String.class));
            } else {
                holder.mSubtitle.setText(getSubtitle());
            }
            // We stop the process here, we only want to update the subtitle

        } else {
            // DemoApp: INNER ANIMATION EXAMPLE! ImageView - Handle Flip Animation on
            // Select ALL and Deselect ALL
            if (adapter.isSelectAll() || adapter.isLastItemInActionMode()) {
                // Consume the Animation
                holder.mFlipView.flip(adapter.isSelected(position), 200L);
            } else {
                // Display the current flip status
                holder.mFlipView.flipSilently(adapter.isSelected(position));
            }

            // In case of searchText matches with Title or with a field this will be highlighted
            if (adapter.hasFilter()) {
                String filter = adapter.getFilter(String.class);
                FlexibleUtils.highlightWords(holder.mTitle, getTitle(), filter);
                FlexibleUtils.highlightWords(holder.mSubtitle, getSubtitle(), filter);
            } else {
                holder.mTitle.setText(getTitle());
                holder.mSubtitle.setText(getSubtitle());
            }
        }
    }

    @Override
    public boolean filter(String constraint) {
        return getTitle() != null && getTitle().toLowerCase().trim().contains(constraint) ||
                getSubtitle() != null && getSubtitle().toLowerCase().trim().contains(constraint);
    }

    /**
     * This ViewHolder is expandable and collapsible.
     */
    static final class ParentViewHolder extends ExpandableViewHolder {

        FlipView mFlipView;
        TextView mTitle;
        TextView mSubtitle;
        ImageView mHandleView;
        Context mContext;
        View frontView;
        View rearLeftView;
        View rearRightView;

        public boolean swiped = false;

        ParentViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mContext = view.getContext();
            this.mTitle = view.findViewById(R.id.title);
            this.mSubtitle = view.findViewById(R.id.subtitle);
            this.mFlipView = view.findViewById(R.id.image);
            this.mFlipView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mAdapter.mItemLongClickListener != null) {
                        mAdapter.mItemLongClickListener.onItemLongClick(getAdapterPosition());
                        Toast.makeText(mContext, "ImageClick on " + mTitle.getText() + " position " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        toggleActivation();
                    }
                }
            });
            this.mHandleView = view.findViewById(R.id.row_handle);
            setDragHandleView(mHandleView);

            this.frontView = view.findViewById(R.id.front_view);
            this.rearLeftView = view.findViewById(R.id.rear_left_view);
            this.rearRightView = view.findViewById(R.id.rear_right_view);
        }

        @Override
        protected void setDragHandleView(@NonNull View view) {
            if (mAdapter.isHandleDragEnabled()) {
                view.setVisibility(View.VISIBLE);
                super.setDragHandleView(view);
            } else {
                view.setVisibility(View.GONE);
            }
        }

        @Override
        public void toggleActivation() {
            super.toggleActivation();
            // Here we use a custom Animation inside the ItemView
            mFlipView.flip(mAdapter.isSelected(getAdapterPosition()));
        }

        @Override
        public float getActivationElevation() {
            return  com.astooltech.advancedview.proteus.anotherView.example.utils.Utils.dpToPx(itemView.getContext(), 4f);
        }

        @Override
        protected boolean shouldActivateViewWhileSwiping() {
            return false;//default=false
        }

        @Override
        protected boolean shouldAddSelectionInActionMode() {
            return false;//default=false
        }

        @Override
        protected void expandView(int position) {
            super.expandView(position);
            mAdapter.invalidateItemDecorations(100);
        }

        @Override
        protected void collapseView(int position) {
            super.collapseView(position);
            mAdapter.invalidateItemDecorations(100);
        }

        @Override
        public View getFrontView() {
            return frontView;
        }

        @Override
        public View getRearLeftView() {
            return rearLeftView;
        }

        @Override
        public View getRearRightView() {
            return rearRightView;
        }

        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            if (mAdapter.getRecyclerView().getLayoutManager() instanceof GridLayoutManager ||
                    mAdapter.getRecyclerView().getLayoutManager() instanceof StaggeredGridLayoutManager) {
                if (position % 2 != 0)
                    AnimatorHelper.slideInFromRightAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
                else
                    AnimatorHelper.slideInFromLeftAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
            } else {
                // Linear layout
                if (mAdapter.isSelected(position))
                    AnimatorHelper.slideInFromRightAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
                else
                    AnimatorHelper.slideInFromLeftAnimator(animators, itemView, mAdapter.getRecyclerView(), 0.5f);
            }
        }

        @Override
        public void onItemReleased(int position) {
            swiped = (mActionState == ItemTouchHelper.ACTION_STATE_SWIPE);
            super.onItemReleased(position);
        }
    }

    @Override
    public String toString() {
        return "ExpandableItem[" + super.toString() + "//SubItems" + mSubItems + "]";
    }

}