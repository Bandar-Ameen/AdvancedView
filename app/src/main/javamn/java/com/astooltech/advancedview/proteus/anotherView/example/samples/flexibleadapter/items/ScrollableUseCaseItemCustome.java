package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.content.Context;
import android.view.View;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.DrawableUtils;
import com.astooltech.advancedview.proteus.v7.adapter.ProtoisVH;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.List;


public class ScrollableUseCaseItemCustome extends AbstractItem<ProtoisVH> {

   private Layout layout;
    private ProteusLayoutInflater layoutInflaterrr;
    public ScrollableUseCaseItemCustome(String title, String subTitle,Layout cx, ProteusLayoutInflater layoutInflaterrrx ) {
        super("UC");

      //  Layout cx = objectValue.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
       this.layoutInflaterrr= layoutInflaterrrx;
        setTitle(title);
        setSubtitle(subTitle);
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return spanCount;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.recycler_scrollable_usecase_item;
    }

    @Override
    public ProtoisVH createViewHolder(View view, FlexibleAdapter<IFlexible> adapter,int viewType) {

        ProteusView viewx = layoutInflaterrr.inflate(layout, new ObjectValue());
        return new ProtoisVH(viewx, adapter);
       // return null;
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, ProtoisVH holder, int position, List<Object> payloads) {
        Context context = holder.itemView.getContext();
        DrawableUtils.setBackgroundCompat(holder.itemView, DrawableUtils.getRippleDrawable(
                DrawableUtils.getColorDrawable(context.getResources().getColor(R.color.material_color_deep_purple_50)),
                DrawableUtils.getColorControlHighlight(context))
        );
        holder.setFullSpan(true);
    }




    @Override
    public String toString() {
        return "ScrollableUseCaseItem[" + super.toString() + "]";
    }

}