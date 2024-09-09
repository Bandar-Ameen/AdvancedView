package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.holders;

import android.view.View;
import android.widget.TextView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.models.HeaderModel;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractHeaderItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IHolder;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

//import  com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.models.HeaderModel;

/**
 * The holder item is just a wrapper for the Model item.
 *
 * @author Davide Steduto
 * @since 19/10/2016
 */
public class HeaderHolder
        extends AbstractHeaderItem<HeaderHolder.HeaderViewHolder>
        implements IFilterable<String>, IHolder<HeaderModel> {

    private HeaderModel model;

    public HeaderHolder(HeaderModel model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof HeaderHolder) {
            HeaderHolder inItem = (HeaderHolder) o;
            return model.equals(inItem.getModel());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }

    /**
     * @return the model object
     */
    @Override
    public HeaderModel getModel() {
        return model;
    }

    /**
     * Filter is applied to the model fields.
     */
    @Override
    public boolean filter(String constraint) {
        return model.getTitle() != null && model.getTitle().equals(constraint);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_holder_header;
    }

    @Override
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new HeaderViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, HeaderViewHolder holder, int position, List payloads) {
        holder.mTitle.setText(model.getTitle());
        List sectionableList = adapter.getSectionItems(this);
        String subTitle = (sectionableList.isEmpty() ? "Empty section" :
                sectionableList.size() + " section items");
        holder.mSubtitle.setText(subTitle);
    }

    static class HeaderViewHolder extends FlexibleViewHolder {

      //  @BindView(R.id.title)
        public TextView mTitle;
     //   @BindView(R.id.subtitle)
        public TextView mSubtitle;

        /**
         * Default constructor.
         */
        HeaderViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true);//true only for header items when will be sticky
          mTitle=view.findViewById(R.id.title);
            mSubtitle=view.findViewById(R.id.subtitle);
           // ButterKnife.bind(this, view);
        }
    }

}