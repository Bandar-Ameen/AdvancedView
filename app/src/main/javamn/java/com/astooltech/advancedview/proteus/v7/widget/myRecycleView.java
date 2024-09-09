package com.astooltech.advancedview.proteus.v7.widget;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.view.PrototoseSwiperView;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;
import com.google.gson.Gson;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.AAadpterme;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ProgressItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class myRecycleView<V extends RecyclerView> extends ViewTypeParser<V> {
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    public static final String ATTRIBUTE_ADAPTER = "adapter";
    public static final String ATTRIBUTE_LAYOUT_MANAGER = "layout_manager";
    public static String typAdapter = "layout_manager";
    public static final String ATTRIBUTE_TYPE = ProteusConstants.TYPE;
    private boolean isload = false;
    //public static final String oritation = ProteusConstants.oritation;

    private boolean loading = false;
    private int page = 0;
    private Handler handler;




    @NonNull
    @Override
    public String getType() {
        return "ARecyclerView";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }
    @Override
    public void BordcastRecever(String Broad) {
        super.BordcastRecever(Broad);

        if(getview!=null){

            getview.getViewManager().getActionEventView().sendEvent(null,7000,Broad);
        }

    }

    @Override
    public void ReceveSearch(String Broad, String viewID) {
        super.ReceveSearch(Broad, viewID);
        if(getview!=null){
            try {
                if(getview.getViewManager().getActionEventView()!=null) {
                    DataValueSelect eert = new DataValueSelect(Broad, viewID, "g", 0, "h");
                    getview.getViewManager().getActionEventView().sendEvent(null, 7000, eert);
                }
            }catch (Exception ex){

            }
            }
    }

    private static ProteusRecyclerView getview;
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        getview=new ProteusRecyclerView(context);
        return getview;

        //return new ProteusRecyclerView(context);
    }

    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new AdapterBasedViewManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof ProteusRecyclerView){
            SetGetFindTSppinerSweep((ProteusRecyclerView)view,data,typoper);
        }

    }

    private Value getvaluefromdat(String keyna, ObjectValue erx){
        Value val=null;
        Iterator<Map.Entry<String, Value>> uuo = erx.getAsObject().entrySet().iterator();
        while (uuo.hasNext()) {
            Map.Entry<String, Value> qqe = uuo.next();
            try {
                if (qqe.getKey().toLowerCase().equals(keyna.toLowerCase())) {
                    val=qqe.getValue();
                }
            }catch (Exception ex){

            }
        }
        return val;
    }

    private  void getwithanotheroper(ProteusRecyclerView dt, DataValueSelect datb, int typoper){
        ProteusRecyclerView  ccc = dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();


                        AAadpterme refresha = (AAadpterme) dt.getAdapter();



                        val.add("GetData", new Primitive(refresha.getItemCount()));//.getText().toString()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiop",ex.getMessage());
                    }



                }
                else if (datb.getTypselect().equals("3")){
                    ObjectValue val = datb.getAnotherDatat();


                    AAadpterme refresha = (AAadpterme) dt.getAdapter();



                    val.add("GetData", new Primitive(refresha.getEndlessCurrentPage()));//.getText().toString()));
                    val.add("ViewId", new Primitive(IDDdat));
                    val.add("index_id", new Primitive(datb.getIdexid()));
                    val.add("Type", new Primitive(datb.getTypselect()));
                }
                else if (datb.getTypselect().equals("4")){
                    ObjectValue val = datb.getAnotherDatat();


                    AAadpterme refresha = (AAadpterme) dt.getAdapter();



                    val.add("GetData", new Primitive(refresha.getEndlessPageSize()));//.getText().toString()));
                    val.add("ViewId", new Primitive(IDDdat));
                    val.add("index_id", new Primitive(datb.getIdexid()));
                    val.add("Type", new Primitive(datb.getTypselect()));
                }
                else if (datb.getTypselect().equals("1") ||datb.getTypselect().toLowerCase().equals("getvisibility")) {
                    try {
                        ObjectValue val = datb.getAnotherDatat();
                        val.add("GetData", new Primitive(dt.getVisibility()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                } else {


                    try {
                        ObjectValue val = datb.getAnotherDatat();
                        val.add("GetData", new Primitive(dt.isEnabled()));
                        val.add("ViewId", new Primitive(IDDdat));
                        val.add("index_id", new Primitive(datb.getIdexid()));
                        val.add("Type", new Primitive(datb.getTypselect()));
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }
                }

            }


        }else   if (typoper == 3) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            Value typ=  getvaluefromdat("Type",datb.getAnotherDatat());

            if (IDDdat.equals(datb.getIDUnit())) {
                if (typ.getAsString().equals("0")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());

                        if(va.getAsString().toLowerCase().equals("true")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");

                           // dt.setRefreshing(true);
                        }
                        else if(dt.equals("1")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");
                        }else{
                            //dt.setRefreshing(false);
                        }



                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }


                else if (typ.getAsString().equals("5")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.startsWith("true")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");

                        }
                        else if(s.startsWith("1")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");
                        }else{

                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                }

                else if (typ.getAsString().equals("1")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.startsWith("true")){
                            dt.setVisibility(View.VISIBLE);
                        }
                        else if(s.startsWith("1")){
                            dt.setVisibility(View.VISIBLE);
                        }else{
                            dt.setVisibility(View.GONE);
                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                }

                else if (typ.getAsString().equals("2")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.toLowerCase().equals("true")){
                            dt.setEnabled(true);
                        }
                        else if(s.equals("1")){
                            dt.setEnabled(true);
                        }else{
                            dt.setEnabled(false);
                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


                }

            }


        }
    }


    private void SetGetFindTSppinerSweep(ProteusRecyclerView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            /// dt.set
                            // datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/
                        }else   if(datb.getTypselect().equals("1")) {
                            dt.setVisibility(View.VISIBLE);
                        }
                        else   if(datb.getTypselect().equals("2")) {
                            dt.setVisibility(View.GONE);
                        }
                        else   if(datb.getTypselect().equals("3")) {
                            dt.setEnabled(false);
                        }

                        else   if(datb.getTypselect().equals("4")) {
                            dt.setEnabled(true);
                        }


                        else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();


                            //  dt.getSelectedItem();
                          /*  flexAdapterrrr tur=( flexAdapterrrr) dt.getAdapter();
                            int postin=  tur.getallItemPostionByname(d);
*/
                          //  dt.setRefreshing(false);
                        }

                    }
                }

            }

        }else{



            getwithanotheroper(dt,datb,typoper);
        }
    }



    @Override
    protected void addAttributeProcessors() {



        addAttributeProcessor("mdata", new AttributeProcessor<V>() {
            @Override
            public void handleValue(final V view, Value value) {

              //  ((ProteusRecyclerView) view).getViewManager().Statuselayout().showLoading();
                ObjectValue obj=value.getAsObject().getAsObject("Layout_manager");
               String orintation=obj.getAsString("Orientation");
                String typlat=obj.getAsString("Layout_Type");
              int typlatg=obj.getAsInteger("Layout_Space");
                int typlatgc=obj.getAsInteger("Layout_Row");
             boolean useOnlinesearchh=false;
             try{
                 useOnlinesearchh=obj.getAsBoolean("use_online_search");
             }catch(Exception ex){


             }
              final   boolean useOnlinesearch=useOnlinesearchh;
               boolean vall=obj.getAsBoolean("Reverse");
            final String     urlmk = view.getTag(R.id.tag3).toString();

                final IValuesData iop= new IValuesData() {
                    @Override
                    public void sendData(String datab, int typdata) {

                    }
                    @Override
                    public void setDataAdvanced(Map<String,List<AbstractFlexibleItem>> datresult, int typ) {

                        final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                      //  hv.onLoadMoreComplete(datresult);

                    }
                };
            //    view.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout
                List<AbstractFlexibleItem> itt=new ArrayList<>();
                final ProteusRecyclerView ert=   ((ProteusRecyclerView) view);

      if(ert.getViewManager().getActionEventView()==null){

          ert.getViewManager().setActionEventView(new ProteusView.Manager.ActionEventView() {
              @Override
              public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {


                  DataValueSelect wwe=(DataValueSelect)anotherdata;
                  if(urlmk.equals(wwe.getUnitName())) {
                      AAadpterme refresha = (AAadpterme) ert.getAdapter();
                      if(useOnlinesearch){
                          refresha.SearchTextOnline(wwe.getIDUnit());
                      }else {
                          refresha.SearchText(wwe.getIDUnit());
                      }
                  }
              }

              @Override
              public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {
                  String[] dattyps=anotherdata.split("#");

                  if(urlmk.equals(dattyps[0])) {
                      AAadpterme refresha = (AAadpterme) ert.getAdapter();


                      refresha.reftesh(dattyps[1]);

                  }
              }

              @Override
              public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

              }

              @Override
              public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

              }
          });
      }

              //  FlexibleAdapter mnbb = new FlexibleAdapter(itt);
             //   view.setAdapter(mnbb);

                final ProteusView.Manager.ActionEventViewForUto wer= new ProteusView.Manager.ActionEventViewForUto() {
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
                };

                int orientation=0;
                int dicrol=0;
               // Log.i("Proteus", hh );
               if(orintation.toLowerCase().startsWith("h")){

                    orientation =  LinearLayoutManager.HORIZONTAL;
                    dicrol=DividerItemDecoration.HORIZONTAL;
                }else{
                    orientation =  LinearLayoutManager.VERTICAL;
                    dicrol= DividerItemDecoration.VERTICAL;
                }

                GradientDrawable j=new GradientDrawable(GradientDrawable.Orientation.BR_TL,new int[]{0xfff7f7f7,0xfff7f7f7});
                try {
                    j.setSize(typlatg,typlatg);
                }catch (Exception ex){

                    j.setSize(20, 20);
                }
                DividerItemDecoration nn=new DividerItemDecoration(view.getContext(),dicrol);
                nn.setDrawable(j);
                view.addItemDecoration(nn);
                if(typlat.toLowerCase().startsWith("l")){

                    if(orintation.toLowerCase().startsWith("h")) {
                        view.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, vall));
                    }else{

                        view.setLayoutManager(new LinearLayoutManager(view.getContext(),  LinearLayoutManager.VERTICAL, vall));
                    }

                }else{
                    GridLayoutManager ff = new GridLayoutManager(view.getContext(), typlatgc);
                    view.setLayoutManager(ff);
                }
                //view.addItemDecoration(new GridSpacingItemDecoration());
try {
    int mode = obj.getAsInteger("ScrollModes");

    if (mode == 1) {
        view.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
    }
    if (mode == 2) {
        view.setOverScrollMode(RecyclerView.OVER_SCROLL_ALWAYS);
    }
    if (mode == 3) {
        view.setOverScrollMode(RecyclerView.OVER_SCROLL_IF_CONTENT_SCROLLS);
    }
}catch (Exception ex){

}
               Value ghh=  value.getAsObject().get("Data_From");
                boolean check=false;
try {
    Layout typlatgf = value.getAsObject().getAsLayout("Empty_View");
    Layout typlatgff = value.getAsObject().getAsLayout("Empty_View_Filter");
    ProteusView em = ((ProteusRecyclerView) view).getViewManager().getContext().getInflater().inflate(typlatgf, new ObjectValue());
    ProteusView emf = ((ProteusRecyclerView) view).getViewManager().getContext().getInflater().inflate(typlatgff, new ObjectValue());
    AAadpterme.newInstaince(itt, ghh, ((ProteusRecyclerView) view),em,emf);

}catch (Exception ex){
    check=true;
}
if(check) {
    AAadpterme.newInstaince(itt, ghh, ((ProteusRecyclerView) view));

}

            }

            @Override
            public void handleResource(V view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {

            }

            public void flexad(ProteusRecyclerView v, FlexibleAdapter.EndlessScrollListener ddf, FlexibleAdapter mnbb, ObjectValue anima){
                long INITIAL_DELAY_300 = 300L;
              /*  mnbb.setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                        .setAnimationInterpolator(new DecelerateInterpolator())
                        .setAnimationInitialDelay(INITIAL_DELAY_300);

                mnbb.setAutoCollapseOnExpand(anima.getAsBoolean("a_expand_out"))
                        .setAutoScrollOnExpand(anima.getAsBoolean("a_expand"))
                        .setOnlyEntryAnimation(anima.getAsBoolean("a_enter"))
                        .setAnimationEntryStep(
                                anima.getAsBoolean("a_enter_step")
                        ) //In Overall, watch the effect at initial loading when Grid Layout is set
                        .setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling)
                        .setAnimationOnReverseScrolling(anima.getAsBoolean("a_anim_rev"))
                        .setAnimationInterpolator(new DecelerateInterpolator())


                        .setAnimationDuration(300L);
                v.setItemAnimator(new FlexibleItemAnimator());
                mnbb.setEndlessTargetCount(anima.getAsInteger("a_endless_count")).setEndlessPageSize(anima.getAsInteger("a_endless_page"));
                // mnbb.setLoadingMoreAtStartUp(true)
*/

                // mnbb.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
                //  .setStickyHeaders(true) //Make headers sticky
                // Endless scroll with 1 item threshold

                if (anima.getAsBoolean("a_use_endless")) {

                    mnbb.setEndlessScrollListener(ddf, new ProgressItem());
                }
                mnbb.setTopEndless(true);
             /*
                mnbb.setLoadingMoreAtStartUp(anima.getAsBoolean("a_load_start")).setLongPressDragEnabled(anima.getAsBoolean("a_drage"))
                        //.setEndlessScrollListener(this, new ProgressItem())
                        .setEndlessScrollThreshold(1).setNotifyMoveOfFilteredItems(false) //When true, filtering on big list is very slow, not in this case!
                        .setNotifyChangeOfUnfilteredItems(true); //true by default

                if (anima.getAsBoolean("a_anim_for")) {
                    mnbb.setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling);
                }*/

            }


            public void loadalltegret(IValuesData vc , ProteusView.Manager.ActionEventViewForUto dd, ProteusView infl, int numberreload, int counrtnumber, Value v){

                Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

                Value getval=v;//this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.toJson(ttrt);*/
                try {
                    Value countt=new Primitive(numberreload);
                    Value tot=new Primitive(counrtnumber);

                    infl.getViewManager().getContext().getAllEven("Data_From").callToRecycleview(infl.getAsView().getContext(),

                            infl.getViewManager().getContext().getActvityAllt(), getval, 0, infl, vc, dd,countt,tot);


                    // this.infl.getViewManager().getContext().getCallback().onEventAdapter(15550, datv, String.valueOf(numberreload),null , infl);

                    // this.infl.getViewManager().getContext().getCallback().onEventAdapter(3550, true, String.valueOf(0), String.valueOf(numberreload),null, null,null);
                }catch (Exception ex){

                }
            }

        });



        addAttributeProcessor("Recycle", new AttributeProcessor<V>() {
            @Override
            public void handleValue(V view, Value value) {
                String typp=value.getAsObject().get("typ").toString();

                if(typp.equals("v")) {
                    view.setLayoutManager(new  LinearLayoutManager(view.getContext()));
                }else{
                    view.setLayoutManager(new LinearLayoutManager(view.getContext()));
                }
            }

            @Override
            public void handleResource(V view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {

            }
        });
    }
}