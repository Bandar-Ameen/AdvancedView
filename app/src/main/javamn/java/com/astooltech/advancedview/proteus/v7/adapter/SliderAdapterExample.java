package com.astooltech.advancedview.proteus.v7.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.custom.PrototuseSliderView;

import java.util.Map;

public class SliderAdapterExample extends
        ProteusSliderAddapter<ProtousSliderHolder>  implements View.OnClickListener {
    private ProteusLayoutInflater inflater;
    private static final String ATTRIBUTE_ITEM_LAYOUT = "item-layout";
    private static final String ATTRIBUTE_ITEM_COUNT = "item-count";
    private ObjectValue data;
    private int count;
    private Layout layout;
    private Map<String, Value> scope;
    public static final ProteusSliderAddapter.Builder<SliderAdapterExample> BUILDER = new ProteusSliderAddapter.Builder<SliderAdapterExample>() {
        @NonNull
        @Override
        public SliderAdapterExample create(@NonNull PrototuseSliderView view, @NonNull ObjectValue config) {
            Layout layout = config.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
            Integer count = config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT);
            ObjectValue data = view.getViewManager().getDataContext().getData();
            ProteusContext context = (ProteusContext) view.getContext();

            return new SliderAdapterExample(context.getInflater(), data, layout, count != null ? count : 0);
        }
    };

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public  SliderAdapterExample(ProteusLayoutInflater inflater, ObjectValue data, Layout layout, int count) {



        this.inflater = inflater;
        this.data = data;
        this.count = count;
        this.layout = new Layout(layout.type, layout.attributes, null, layout.extras);
        this.scope = layout.data;
    }

    @Override
    public ProtousSliderHolder onCreateViewHolder(ViewGroup parent, int position,int viewType) {

        ProteusView view = inflater.inflate(layout ,new ObjectValue());


        return new ProtousSliderHolder(view);


    }

    /*   @Override
        public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
            return new SliderAdapterVH(inflate);
        }
    */
    @Override
    public void onBindViewHolder(ProtousSliderHolder viewHolder, int position) {
        final DataContext context = DataContext.create(viewHolder.context, data, position, scope);

        viewHolder.view.getViewManager().update(context.getData());
    }
    @Override
    public int getCount() {
        return count;
    }


    @Override
    public void onClick(View view) {

    }



}
