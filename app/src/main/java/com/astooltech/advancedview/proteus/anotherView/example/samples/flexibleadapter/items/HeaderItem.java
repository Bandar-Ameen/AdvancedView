package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractHeaderItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.ISectionable;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

/**
 * This is a header item with custom layout for section headers.
 * <p><b>Note:</b> THIS ITEM IS NOT A SCROLLABLE HEADER.</p>
 * A Section should not contain others Sections and headers are not Sectionable!
 */
public class HeaderItem
        extends AbstractHeaderItem<HeaderItem.HeaderViewHolder>
        implements IFilterable<String> {

    private String id;
    private String title;
    private String subtitle;
    /* number of times this item has been refreshed */
    protected int updates;

    public HeaderItem(String id) {
        super();
        this.id = id;
        setDraggable(true);
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof HeaderItem) {
            HeaderItem inItem = (HeaderItem) inObject;
            return this.getId().equals(inItem.getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return this.subtitle + (getUpdates() > 0 ? " - u" + getUpdates() : "");
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return spanCount;
    }

    public int getUpdates() {
        return updates;
    }

    public void increaseUpdates() {
        this.updates++;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_header_item;
    }

    @Override
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new HeaderViewHolder(view, adapter);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bindViewHolder(FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {
        if (payloads.size() > 0) {
            Log.d(this.getClass().getSimpleName(), "HeaderItem " + id + " Payload " + payloads);
        } else {
            holder.mTitle.setText(getTitle());
        }
        List<ISectionable> sectionableList = adapter.getSectionItems(this);
        int size = sectionableList.size();
        setSubtitle(size == 0 ? "Empty section" : size + " section items");
        holder.mSubtitle.setText(getSubtitle());
    }

    @Override
    public boolean filter(String constraint) {
        return getTitle() != null && getTitle().toLowerCase().trim().contains(constraint);
    }

    static class HeaderViewHolder extends FlexibleViewHolder {

        TextView mTitle;
        TextView mSubtitle;
        ImageView mHandleView;

        HeaderViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true);//True for sticky
            mTitle = view.findViewById(R.id.title);
            mSubtitle = view.findViewById(R.id.subtitle);
            mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("HeaderTitle", "Registered internal click on Header TitleTextView! " + mTitle.getText() + " position=" + getFlexibleAdapterPosition());
                }
            });
            this.mHandleView = view.findViewById(R.id.row_handle);
            if (adapter.isHandleDragEnabled()) {
                this.mHandleView.setVisibility(View.VISIBLE);
                setDragHandleView(mHandleView);
            } else {
                this.mHandleView.setVisibility(View.GONE);
            }

            // Support for StaggeredGridLayoutManager
            setFullSpan(true);
        }

        @Override
        public String toString() {
            return super.toString() + " " + mTitle.getText();
        }
    }

    @Override
    public String toString() {
        return "HeaderItem[id=" + id +
                ", title=" + title + "]";
    }

}