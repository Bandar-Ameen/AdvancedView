package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.Payload;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.google.gson.Gson;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteFilterA;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.ExtendedDictionaryAutocompleteProviderA;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ProgressItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.parser.adapterskit.AdapterRefresh;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.adapterskit.getAllvalue;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusProgressBar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class AAadpterme  extends FlexibleAdapter<AbstractFlexibleItem> implements
      FlexibleAdapter.EndlessScrollListener, AdapterRefresh, IValuesData,ProteusView.Manager.ActionEventViewForUto {

    private List<AbstractFlexibleItem> mListItems;
    private ExtendedDictionaryAutocompleteProviderA mExtendedDictionaryAutocompleteProvider;
    private ExtendedDictionaryAutocompleteFilterA mDictionaryAutocompleteFilter;
    private LayoutInflater mLayoutInflater;
    private  boolean usemultiple;
    private int mLayoutId;
    private ProteusLayoutInflater layoutInflaterrr;
    private  boolean AuroOrnot=true;
    private ProteusView EmptyView;
    private ProteusView EmptyViewFilter;
private IValuesData aevnt;
private ProteusView.Manager.ActionEventViewForUto aventd;
    public AdapterRefresh getDatarefresh() {
        return datarefresh;
    }

    public void setDatarefresh(AdapterRefresh datarefresh) {
        this.datarefresh = datarefresh;
    }

    private AdapterRefresh datarefresh;
    private boolean isloadingnow;
  private   List<AbstractFlexibleItem> mListItemsSer;
private getAllvalue getallvall;

    public ProteusView getPview() {
        return pview;
    }
private String sweepref="0";
    public void setPview(ProteusView pview) {
        this.pview = pview;
    }

    private ProteusView pview;
    public Value getDatafroview() {
        return datafroview;
    }

    public void setDatafroview(Value datafroview) {
        this.datafroview = datafroview;
    }

    private Value datafroview;
    public AAadpterme(@Nullable List<AbstractFlexibleItem> items, getAllvalue getallvalllx, ProteusProgressBar  b) {
        super(items);
        mListItems=items;
        getallvalllx.setEventAdapter(this);

      this.setEndlessScrollListener(this, b==null? new ProgressItem(): new ProgressItem(b));
this.getallvall=getallvalllx;
        setDatarefresh(this);
    /*   mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProviderA(items,null,null,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilterA(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);*/
    }
    public AAadpterme(@Nullable List<AbstractFlexibleItem> items,Value datafroviewm,ProteusView pview) {
        super(items);
        mListItems=items;
     //   getallvalllx.setEventAdapter(this);
        setDatarefresh(this);
        aevnt=this;
        aventd=this;
        ((ProteusRecyclerView) pview).setAdapter(this);

        setPview(pview);
        setDatafroview(datafroviewm);
        this.setEndlessScrollListener(this,  new ProgressItem());
        flexad(getDatafroview().getAsObject().getAsObject("animation"));
    //    this.getallvall=getallvalllx;

    /*   mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProviderA(items,null,null,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilterA(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);*/
    }
    public AAadpterme(@Nullable List<AbstractFlexibleItem> items,Value datafroviewm,ProteusView pview,ProteusView empityview,ProteusView filterEmpty) {
        super(items);

        mListItems=items;
        this.EmptyView=empityview;
        this.EmptyViewFilter=filterEmpty;
        //   getallvalllx.setEventAdapter(this);
        setDatarefresh(this);
        aevnt=this;
        aventd=this;
        ((ProteusRecyclerView) pview).setAdapter(this);
        EmptyViewHelper.create(this,
                this.EmptyView.getAsView(),
                this.EmptyViewFilter.getAsView());
        setPview(pview);
        setDatafroview(datafroviewm);
        this.setEndlessScrollListener(this,  new ProgressItem());
        flexad(getDatafroview().getAsObject().getAsObject("animation"));
        //    this.getallvall=getallvalllx;

    /*   mExtendedDictionaryAutocompleteProvider = new ExtendedDictionaryAutocompleteProviderA(items,null,null,usemultiple);
        mDictionaryAutocompleteFilter = new ExtendedDictionaryAutocompleteFilterA(mExtendedDictionaryAutocompleteProvider, this);
        mDictionaryAutocompleteFilter.useCache(true);*/
    }


    public AAadpterme (@Nullable List<AbstractFlexibleItem> items){
        super(items);
        mListItems=items;

    }
    public static AAadpterme newInstaince(@Nullable List<AbstractFlexibleItem> items,Value datafroviewm,ProteusView pview){
AAadpterme g=new AAadpterme(items,datafroviewm,pview);

return  g;

    }
    public static AAadpterme newInstaince(@Nullable List<AbstractFlexibleItem> items,Value datafroviewm,ProteusView pview,ProteusView empityview,ProteusView filterEmpty){
        AAadpterme g=new AAadpterme(items,datafroviewm,pview,empityview,filterEmpty);

        return  g;

    }
    @Override
    public void onFastScrollerStateChange(boolean scrolling) {
        if (scrolling) {
          //  hideFab();
        } else {
          //  showFab();
        }
    }
    public void SearchTextOnline(String text){

        sweepref="0";
        this.removeRange(0,getItemCount());
        loadalltegret(aevnt,aventd, ((ProteusRecyclerView) getPview()),0,0,getDatafroview(),text,true);


    }
    public void removeFilter(){
        this.setFilter(null);
        this.AhasFilter(false);
    }

    public void SearchText(String text){

        if (this.hasNewFilter(text)) {
          this.setFilter(text);
if(mListItemsSer!=null) {
    // Fill and Filter mItems with your custom list and automatically animate the changes
    // - Option A: Use the internal list as original list
    this.filterItems(mListItemsSer, DatabaseConfiguration.delay);
}
            // - Option B: Provide any new list to filter
            //mAdapter.filterItems(DatabaseService.getInstance().getDatabaseList(), DatabaseConfiguration.delay);
        }
    }





public void fflt(String text){
    mDictionaryAutocompleteFilter.filter(text);
}





    /*@Override
    public AbstractFlexibleItem getItem(int position) {
        return mListItems.get(position);
    }*/

    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AbstractFlexibleItem countryModel = getItem(position);

        OOverIttem t= ((OOverIttem) countryModel);

        if(usemultiple) {
            String inflatename = "0";
            for (int cx = 0; cx < t.getWith().size(); cx++) {
                modeltypeview k = t.getWith().get(cx);
                // String datget = data.getAsObject().get(k.getV_ColumnName()).toString();
                if (Integer.parseInt(k.getV_id()) == t.getItemViewType()) {

                    inflatename = k.getV_Name();
                }
                // data.getAsObject().get()
            }

            if (inflatename.equals("0")) {
                ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

                return viewx.getAsView();
            } else {

                ProteusView viewx = layoutInflaterrr.inflate(inflatename, t.getdataa().getAsObject());

                return viewx.getAsView();
            }
        }else {
            ProteusView viewx = layoutInflaterrr.inflate(t.WithLayout(), t.getdataa().getAsObject());

            return viewx.getAsView();
        }
    }

public void searchh(){

}
    @Override
    public void noMoreLoad(int newItemsSize) {

    }

    @Override
    public void onLoadMore(final int lastPosition, int currentPage) {

final  int finn=lastPosition;
        final int countt=this.getItemCount();
        final  AAadpterme eert=this;
        if (this.hasFilter()) {
            this.onLoadMoreComplete(null);
            return;
        } else if (this.AhasFilter()) {
            this.onLoadMoreComplete(null);

            return;
        }
        new Handler().postDelayed(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                final List<AbstractFlexibleItem> newItems = new ArrayList<>(3);
                boolean check = true;
                String[] anoth = new String[]{"0"};

if(getallvall==null){
    loadalltegret(aevnt,aventd, ((ProteusRecyclerView) getPview()),lastPosition,0,getDatafroview(),"0",false);

}else {
    getallvall.loadalltegret(getItemCount(), finn);
}


            }
        }, 3000);
    }
    public void loadalltegret(IValuesData vc , ProteusView.Manager.ActionEventViewForUto dd, ProteusView infl, int numberreload, int counrtnumber, Value v,String SearchTex,boolean usesearch){
//this.updateItem();
        Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

        Value getval=v;//this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.toJson(ttrt);*/
        try {
            Value countt=new Primitive(numberreload);
            Value tot=new Primitive(counrtnumber);
            Value useSearch=new Primitive(usesearch);
            Value totser=new Primitive(SearchTex);
            infl.getViewManager().getContext().getAllEven("Data_From").callToRecycleview(infl.getAsView().getContext(),

                    infl.getViewManager().getContext().getActvityAllt(), getval, 0, infl, vc, dd,countt,tot,totser,useSearch);


            // this.infl.getViewManager().getContext().getCallback().onEventAdapter(15550, datv, String.valueOf(numberreload),null , infl);

            // this.infl.getViewManager().getContext().getCallback().onEventAdapter(3550, true, String.valueOf(0), String.valueOf(numberreload),null, null,null);
        }catch (Exception ex){

        }
    }
public void reftesh(String sweeprefresh){
    sweepref=sweeprefresh;
    this.removeRange(0,getItemCount());
    loadalltegret(aevnt,aventd, ((ProteusRecyclerView) getPview()),0,0,getDatafroview(),"0",false);
}
    public void flexad( ObjectValue anima){
        long INITIAL_DELAY_300 = 300L;
        long INITIAL_DELAY_400 = 300L;
        try {
            String y = anima.get("a_delay_a").getAsString();
           INITIAL_DELAY_300 = Long.parseLong(y);
            String yy = anima.get("a_delay_b").getAsString();
            INITIAL_DELAY_400 = Long.parseLong(yy);

        }catch (Exception ex){

        }

                this.setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                        .setAnimationInterpolator(new DecelerateInterpolator())
                        .setAnimationInitialDelay(INITIAL_DELAY_300);

                this.setAutoCollapseOnExpand(anima.getAsBoolean("a_expand_out"))
                        .setAutoScrollOnExpand(anima.getAsBoolean("a_expand"))
                        .setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                        .setAnimationEntryStep(
                                anima.getAsBoolean("a_enter_step")
                        ) //In Overall, watch the effect at initial loading when Grid Layout is set
                        .setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling)
                        .setAnimationOnReverseScrolling(anima.getAsBoolean("a_anim_rev"))
                        .setAnimationInterpolator(new DecelerateInterpolator())


                        .setAnimationDuration(INITIAL_DELAY_400);
        //((ProteusRecyclerView) getPview()).setItemAnimator(new FlexibleItemAnimator());
            this.setEndlessTargetCount(anima.getAsInteger("a_endless_count")).setEndlessPageSize(anima.getAsInteger("a_endless_page"));


        this.setTopEndless(anima.getAsBoolean("a_use_top"));

                this.setLoadingMoreAtStartUp(anima.getAsBoolean("a_load_start")).setLongPressDragEnabled(anima.getAsBoolean("a_drage"))
                        //.setEndlessScrollListener(this, new ProgressItem())
                        .setEndlessScrollThreshold(1).setNotifyMoveOfFilteredItems(false) //When true, filtering on big list is very slow, not in this case!
                        .setNotifyChangeOfUnfilteredItems(true); //true by default

                if (anima.getAsBoolean("a_anim_for")) {
                   this.setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling);
                }

    }

    @Override
    public void OnGetData(Map<String,List<AbstractFlexibleItem>> data) {

      boolean checkerror=false;
        Iterator<Map.Entry<String, List<AbstractFlexibleItem>>> ddd=data.entrySet().iterator();
        while (ddd.hasNext()){
           Map.Entry<String,List<AbstractFlexibleItem>> ddert=ddd.next();
            if(ddert.getKey().equals("error")){
            checkerror=true;
            }
           if(ddert.getKey().equals("main")){
if(!sweepref.equals("0")){

    //getPview().getViewManager().getContext().getParser("SwipeRefreshLayout").BordcastRecever(sweepref);
}
                this.onLoadMoreComplete(ddert.getValue());
            }else {
                if(this.mListItemsSer==null) {
                    this.mListItemsSer = ddert.getValue();
                }else {
                    this.mListItemsSer.addAll(ddert.getValue());

                }
            }

        }

        if(checkerror){
            this.noMoreLoad(0);
        }

    }

    @Override
    public void sendEventA(@Nullable ObjectValue data, int typ, Object anotherdata) {

    }

    @Override
    public void sendEventA(@Nullable ObjectValue data, int typ, String anotherdata) {

    }

    @Override
    public void getresultsearchA(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

    }

    @Override
    public void getFragmentA(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

    }

    @Override
    public void sendData(String datab, int typdata) {

    }

    @Override
    public void setDataAdvanced(Map<String,List<AbstractFlexibleItem>> datresult, int typ) {
        boolean checkerror=false;
        Iterator<Map.Entry<String, List<AbstractFlexibleItem>>> ddd=datresult.entrySet().iterator();
        while (ddd.hasNext()){
            Map.Entry<String,List<AbstractFlexibleItem>> ddert=ddd.next();
            if(ddert.getKey().equals("error")){
                checkerror=true;
            }
            if(ddert.getKey().equals("main")){
                if(!sweepref.equals("0")){

                   // getPview().getViewManager().getContext().getParser("SwipeRefreshLayout").BordcastRecever(sweepref);
                }

                this.onLoadMoreComplete(ddert.getValue());
            }else {
                if(this.mListItemsSer==null) {
                    this.mListItemsSer = ddert.getValue();
                }else {
                    this.mListItemsSer.addAll(ddert.getValue());

                }
            }

        }
        if(checkerror){
            this.noMoreLoad(0);
        }
    }






}
