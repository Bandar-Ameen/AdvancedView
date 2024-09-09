package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.holders;

import android.view.View;
import android.widget.TextView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.models.ItemModel;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractSectionableItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFilterable;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IHolder;
import com.astooltech.advancedview.proteus.anotherView.viewholders.FlexibleViewHolder;

import java.util.List;

//import  com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.models.ItemModel;

/**
 * The holder item is just a wrapper for the Model item.
 *
 * <p>Holder item can be used to display the same modelData in multiple RecyclerViews managed by
 * different Adapters, you can implement a derived IFlexible item to HOLD your data model object!</p>
 *
 * In this way you can separate the memory zones of the flags (enabled, expanded, hidden,
 * selectable) used by a specific Adapter, to be independent by another Adapter. For instance,
 * an item can be Shown and Expanded in a RV, while in the other RV can be Hidden or Not Expanded!
 *
 * @author Davide Steduto
 * @since 19/10/2016
 */
public class ItemHolder extends AbstractSectionableItem<ItemHolder.ItemViewHolder, HeaderHolder>
        implements IFilterable<String>, IHolder<ItemModel> {

    private ItemModel model;

    /**
     * The header item must in its bounds, it must implement IHeader, therefore: HeaderHolder!
     */
    public ItemHolder(ItemModel model, HeaderHolder header) {
        super(header);
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemHolder) {
            ItemHolder inItem = (ItemHolder) o;
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
    public ItemModel getModel() {
        return model;
    }

    /**
     * Filter is applied to the model fields.
     */
    @Override
    public boolean filter(String constraint) {
        return model.getTitle() != null && model.getTitle().toLowerCase().trim().contains(constraint) ||
                model.getSubtitle() != null && model.getSubtitle().toLowerCase().trim().contains(constraint);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_holder_item;
    }

    @Override
    public ItemViewHolder createViewHolder(View view, FlexibleAdapter adapter,int viewType) {
        return new ItemViewHolder(view, adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, ItemViewHolder holder, int position, List payloads) {
        holder.mTitle.setText(model.getTitle());
        holder.mSubtitle.setText(model.getSubtitle());
    }

    static class ItemViewHolder extends FlexibleViewHolder {

        //@BindView(R.id.title)
        public TextView mTitle;
       // @BindView(R.id.subtitle)
        public TextView mSubtitle;

        /**
         * Default constructor.
         */
        ItemViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter);

            mTitle=view.findViewById(R.id.title);
            mSubtitle=view.findViewById(R.id.subtitle);
          //  ButterKnife.bind(this, view);
        }
    }

}