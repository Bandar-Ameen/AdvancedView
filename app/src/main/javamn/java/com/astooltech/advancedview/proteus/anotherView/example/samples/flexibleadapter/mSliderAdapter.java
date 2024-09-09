package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.autoimageslider.SliderViewAdapter;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.value.Layout;

import java.util.List;

//import com.astooltech.advancedview.proteus.v7.adapter.ProtousSliderHolder;


public class mSliderAdapter extends
        SliderViewAdapter<mSliderAdapter.SliderAdapterVH> {
    private  boolean usemultiple;
    private int mLayoutId;
    private ProteusLayoutInflater layoutInflaterrr;
    private  boolean AuroOrnot;
    private Context context;
    private List<AbstractFlexibleItem> mSliderItems;
    private Layout mlay;
    private  List<modeltypeview> mda;
    public mSliderAdapter(Context context,  List<AbstractFlexibleItem> g, ProteusLayoutInflater layoutInflaterr, ProteusView ck,List<modeltypeview> datatyp,boolean usemultiple) {

        this.usemultiple=usemultiple;
        layoutInflaterrr=layoutInflaterr;
        mSliderItems = g;
        mLayoutId = 0;
        this.mda=datatyp;
       /* mLayoutInflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
    }
    public mSliderAdapter(Context context) {
        this.context = context;
    }

    public void renewItems(List<AbstractFlexibleItem> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(AbstractFlexibleItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {

        return mSliderItems.get(position).getItemViewType();
    }
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent,int position,int viewType) {

      AbstractFlexibleItem sliderItem = mSliderItems.get(position);
        OOverIttem t=(OOverIttem)sliderItem;
        /*AbstractFlexibleItem countryModel = getItem(position);
Loh
        OOverIttem t= ((OOverIttem) countryModel);*/
        ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());



        return new SliderAdapterVH(viewx);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        return super.instantiateItem(container, position);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder,  int position) {



         AbstractFlexibleItem sliderItem = mSliderItems.get(position);
        OOverIttem yt=(OOverIttem)sliderItem;

//onCreateViewHolder(null,position,yt.getItemViewType());
      //  ProteusView viewx = layoutInflaterrr.inflate(yt.WithLayout(), yt.getdataa().getAsObject());
        //viewHolder.itemView.getAsView().=null;
       // viewHolder.itemView=viewx;
   //viewHolder=   new  SliderAdapterVH (viewx);*/
        viewHolder.itemView.getViewManager().update(yt.getdataa().getAsObject());

//*/
       // viewHolder.itemView.getViewManager().getDataContext().update(viewHolder.itemView.getViewManager().getContext(),yt.getdataa().getAsObject());


               /// yt.Getview();
        /*viewHolder.textViewDescription.setText(sliderItem.getDescription());
        viewHolder.textViewDescription.setTextSize(16);
        viewHolder.textViewDescription.setTextColor(Color.WHITE);
        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImageUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is item in position " + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mSliderItems.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        ProteusView itemView;


        public SliderAdapterVH(ProteusView itemView) {
            super(itemView.getAsView());
            this.itemView = itemView;
        }
    }

}

