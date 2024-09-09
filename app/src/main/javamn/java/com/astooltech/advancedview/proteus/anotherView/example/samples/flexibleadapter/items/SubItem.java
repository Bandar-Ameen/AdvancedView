package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IHeader;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.FlexibleUtils;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * If you don't have many fields in common better to extend directly from
 * {@link  com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem} to benefit of the already
 * implemented methods (getter and setters).
 */
public class SubItem extends AbstractItem<SubItem.ChildViewHolder> implements IFilterable<String> {

    /**
     * The header of this item
     */
    IHeader header;

    public SubItem(String id) {
        super(id);
        setDraggable(true);
    }

    /**
     * Called by the FlexibleAdapter when it wants to check if this item should be bound
     * again with new content.
     * <p>
     * You should return {@code true} whether you want this item will be updated because
     * its visual representations will change.
     * <p>
     * This method is called only if {@link FlexibleAdapter#setNotifyChangeOfUnfilteredItems(boolean)}
     * is enabled.
     * <p>Default value is {@code true}.</p>
     *
     * @param newItem The new item object with the new content
     * @return True will trigger a new binding to display new content, false if the content shown
     * is already the latest data.
     */
    @Override
    public boolean shouldNotifyChange(IFlexible newItem) {
        SubItem subItem = (SubItem) newItem;
        return !title.equals(subItem.getTitle()); // Should be bound again if title is different
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_sub_item;
    }

    @Override
    public ChildViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ChildViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, ChildViewHolder holder, int position, List<Object> payloads) {
        //In case of searchText matches with Title or with an SimpleItem's field
        // this will be highlighted
        if (adapter.hasFilter()) {
            Context context = holder.itemView.getContext();
            String filter = adapter.getFilter(String.class);
            FlexibleUtils.highlightText(holder.mTitle, getTitle(), filter,
                    context.getResources().getColor(R.color.colorAccent_light));
        } else {
            holder.mTitle.setText(getTitle());
        }
    }

    @Override
    public boolean filter(String constraint) {
        return getTitle() != null && getTitle().toLowerCase().trim().contains(constraint);
    }

    /**
     * Provide a reference to the views for each data item.
     * Complex data labels may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    static final class ChildViewHolder extends FlexibleViewHolder {

        public ImageView mHandleView;
        public TextView mTitle;

        public ChildViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mTitle = view.findViewById(R.id.title);
            this.mHandleView = view.findViewById(R.id.row_handle);
            if (adapter.isHandleDragEnabled()) {
                this.mHandleView.setVisibility(View.VISIBLE);
                setDragHandleView(mHandleView);
            } else {
                this.mHandleView.setVisibility(View.GONE);
            }
        }

        @Override
        public float getActivationElevation() {
            return  Utils.dpToPx(itemView.getContext(), 4f);
        }

        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            AnimatorHelper.scaleAnimator(animators, itemView, 0f);
        }
    }

    @Override
    public String toString() {
        return "SubItem[" + super.toString() + "]";
    }

}