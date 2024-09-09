package com.astooltech.advancedview.proteus.v7.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.List;
import java.util.Map;

public class anotherAdapter extends AbstractFlexibleItem<ProtoisVH> {

   private  ObjectValue data;
   private ProteusLayoutInflater layoutInflater;
    private Map<String, Value> scopep;
    private String scope;
    private  String idd;
    //;
   public  anotherAdapter(ObjectValue objectValue,ProteusLayoutInflater layoutInflaterr, String  layout,String idd){
       this.data=objectValue;
       this.layoutInflater=layoutInflaterr;
       this.scope = layout;
       this.idd=idd;
     //  this.scopep=scopepp;

   }
    @Override
    public boolean equals(Object o) {
        return false;
    }

 //   public ObjectValue getdataset()
    @Override
    public int hashCode() {
        return idd.hashCode();
    }

    @SuppressLint("ResourceType")
    @Override
    public int getLayoutRes() {
        return R.layout.recycler_instagram_item;
    }

    @Override
    public ProtoisVH createViewHolder(View view, FlexibleAdapter<IFlexible> adapter,int viewType) {
      // ObjectValue ccf=  data.entrySet().iterator().next().getValue().getAsArray().get(Integer.parseInt(idd)).getAsObject();//, contextv.getInflater()
        ProteusView   viewx = layoutInflater.inflate(scope ,data);
//adapter.notifyDataSetChanged();
        return new ProtoisVH(viewx,adapter);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void bindViewHolder(FlexibleAdapter<IFlexible> adapter, ProtoisVH holder, int position, List<Object> payloads) {

       try {
           ViewGroup eerrt = (ViewGroup) holder.view;

           eerrt.removeAllViews();
         //  ObjectValue ccf = data; //data.entrySet().iterator().next().getValue().getAsArray().get(position).getAsObject();//, contextv.getInflater()
           ProteusView viewx = layoutInflater.inflate(scope, data);
           eerrt.addView(viewx.getAsView());
       }catch (Exception ex){

       }
    }
}
