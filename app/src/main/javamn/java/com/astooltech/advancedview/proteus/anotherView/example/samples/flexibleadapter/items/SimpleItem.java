package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.ISectionable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.FlexibleUtils;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.io.Serializable;
import java.util.List;

/**
 * <b>Tip:</b> Consider to extend directly from
 * {@link  com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem} to benefit of the already
 * implemented methods (getter and setters).
 */
public class SimpleItem extends AbstractItem<SimpleItem.SimpleViewHolder>
        implements ISectionable<SimpleItem.SimpleViewHolder, HeaderItem>, IFilterable<String>, Serializable {

    /* The header of this item */
    HeaderItem header;

    private SimpleItem(String id) {
        super(id);
        setDraggable(true);
        setSwipeable(true);
    }

    public SimpleItem(String id, HeaderItem header) {
        this(id);
        this.header = header;
    }

    @Override
    public String getSubtitle() {
        return getId()
                + (getHeader() != null ? " - " + getHeader().getId() : "")
                + (getUpdates() > 0 ? " - u" + getUpdates() : "");
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
    public int getLayoutRes() {
        return R.layout.recycler_simple_item;
    }

    @Override
    public SimpleViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new SimpleViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, SimpleViewHolder holder, int position, List<Object> payloads) {
        Context context = holder.itemView.getContext();

        // Background, when bound the first time
        if (payloads.size() == 0) {
            Drawable drawable = DrawableUtils.getSelectableBackgroundCompat(
                    Color.WHITE, Color.parseColor("#dddddd"), //Same color of divider
                    DrawableUtils.getColorControlHighlight(context));
            DrawableUtils.setBackgroundCompat(holder.itemView, drawable);
            DrawableUtils.setBackgroundCompat(holder.frontView, drawable);
        }

        // Display the current flip status
        holder.mFlipView.flipSilently(adapter.isSelected(position));

        // In case of any Words in the searchText matches with Title this will be highlighted
        if (adapter.hasFilter()) {
            String filter = adapter.getFilter(String.class);
            FlexibleUtils.highlightWords(holder.mTitle, getTitle(), filter);
            FlexibleUtils.highlightWords(holder.mSubtitle, getSubtitle(), filter);
        } else {
            holder.mTitle.setText(getTitle());
            holder.mSubtitle.setText(getSubtitle());
        }
    }

    @Override
    public boolean filter(String constraint) {
        for (String word : constraint.split(FlexibleUtils.SPLIT_EXPRESSION)) {
            if (getTitle().toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    static final class SimpleViewHolder extends FlexibleViewHolder {

        FlipView mFlipView;
        TextView mTitle;
        TextView mSubtitle;
        ImageView mHandleView;
        Context mContext;
        View frontView;
        View rearLeftView;
        View rearRightView;

        boolean swiped = false;

        SimpleViewHolder(View view, FlexibleAdapter adapter) {
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
        public void onClick(View view) {
            Toast.makeText(mContext, "Click on " + mTitle.getText() + " position " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            super.onClick(view);
        }

        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(mContext, "LongClick on " + mTitle.getText() + " position " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            return super.onLongClick(view);
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
                //Linear layout
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
        return "SimpleItem[" + super.toString() + "]";
    }

}