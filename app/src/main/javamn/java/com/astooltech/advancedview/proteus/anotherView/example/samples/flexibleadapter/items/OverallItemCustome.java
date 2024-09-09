package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items;

import android.view.View;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.v7.adapter.ProtoisVH;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.List;


public class OverallItemCustome extends AbstractFlexibleItem<ProtoisVH> {

    private String tit;
    private Layout layout;
    private   ProteusLayoutInflater layoutInflaterrr;
    private  int pos;

    public OverallItemCustome(int pos,String title, String subTitle,Layout cx,  ProteusLayoutInflater layoutInflaterrrx ) {
       // super("UC");
this.tit=title;
this.pos=pos;
        //  Layout cx = objectValue.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
        this.layout = new Layout(cx.type, cx.attributes, null, cx.extras);
        this.layoutInflaterrr= layoutInflaterrrx;

    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return spanCount;
    }

    @Override
    public int getLayoutRes() {

      //  Log.i("8888",R.layout.recycler_scrollable_usecase_item+"vvbbbbb"+pos);
        return R.layout.recycler_scrollable_usecase_item;
    }



    @Override
    public ProtoisVH createViewHolder(View view, FlexibleAdapter<IFlexible> adapter,int viewtyp) {
       // ProteusLayoutInflater ww= ProteusLayoutInflater();

    // Log.i("8888",viewtyp+"vvbbbbb"+pos);

     /*  if(pos==0) {
           ProteusView viewx = layoutInflaterrr.inflate(layout, new ObjectValue());
           return new ProtoisVH(viewx, adapter);
       }else {*/
           ProteusView viewx = layoutInflaterrr.inflate(layout, new ObjectValue());
           // ProteusView viewx = layoutInflaterrr[viewtyp].getViewManager().getContext().getInflater().inflate(this.tit, new ObjectValue());
           return new ProtoisVH(viewx, adapter);
      // }
        // return null;
    }

    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, ProtoisVH holder, int position, List<Object> payloads) {
      /*  Context context = holder.itemView.getContext();
        DrawableUtils.setBackgroundCompat(holder.itemView, DrawableUtils.getRippleDrawable(
                DrawableUtils.getColorDrawable(context.getResources().getColor(R.color.material_color_deep_purple_50)),
                DrawableUtils.getColorControlHighlight(context))
        );*/
        holder.setFullSpan(true);
    }

    @Override
    public int getItemViewType() {


        return pos;//super.getItemViewType();
    }

    @Override
    public String toString() {
        return "ScrollableUseCaseItem[" + super.toString() + "]";
    }

}