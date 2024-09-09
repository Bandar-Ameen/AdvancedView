package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.animation.Animator;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.AnimatorHelper;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * Scrollable SubHeader and SubFooter Item. When visible, will be a Header or a Footer,
 * depending where the parent has been initially added!
 */
public class ScrollableSubItem extends AbstractItem<ScrollableSubItem.ChildViewHolder> {

    public ScrollableSubItem(String id) {
        super(id);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_scrollable_sub_item;
    }

    @Override
    public ChildViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ChildViewHolder(view, adapter);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bindViewHolder(FlexibleAdapter adapter, ChildViewHolder holder, int position, List payloads) {
        String title = "Scrollable SubItem " + adapter.getSubPositionOf(this);
        holder.mTitle.setText(title);
    }

    /**
     * Provide a reference to the views for each data item.
     * Complex data labels may need more than one view per item, and
     * you provide access to all the views for a data item in a view holder.
     */
    static final class ChildViewHolder extends FlexibleViewHolder {

        TextView mTitle;

        ChildViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);
            this.mTitle = view.findViewById(R.id.title);
        }

        @Override
        public void scrollAnimators(@NonNull List<Animator> animators, int position, boolean isForward) {
            AnimatorHelper.scaleAnimator(animators, itemView, 0f);
        }
    }

    @Override
    public String toString() {
        return "ScrollableSubItem[" + super.toString() + "]";
    }

}