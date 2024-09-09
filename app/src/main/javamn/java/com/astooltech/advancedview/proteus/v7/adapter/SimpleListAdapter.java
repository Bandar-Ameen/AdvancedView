/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.v7.adapter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.demo.api.notfi_refresh_data;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;


import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * SimpleListAdapter.
 *
 * @author adityasharat
 */
public class SimpleListAdapter  extends ProteusRecyclerViewAdapter<ProteusViewHolder>  implements View.OnClickListener {

    private static final String ATTRIBUTE_ITEM_LAYOUT = "item-layout";
    private static final String ATTRIBUTE_ITEM_COUNT = "item-count";
    private static final int ITEM_VIEW_TYPE_LOADING = Integer.MAX_VALUE - 50; // Magic

    private notfi_refresh_data dataevent;
    public static final Builder<SimpleListAdapter> BUILDER = new Builder<SimpleListAdapter>() {
        @NonNull
        @Override
        public SimpleListAdapter create(@NonNull ProteusRecyclerView view, @NonNull ObjectValue config) {
            Layout layout = config.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
//Gson g=new Gson();


            Integer count = config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT)==null?0:config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT);
            Integer countt =  config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT)==null?0:config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT);
            ObjectValue data = view.getViewManager().getDataContext().getData();

            ProteusView.Manager mang=null;
            try {
                mang = view.getViewManager();
            }catch (Exception ex){

            }
            //  String ccc= g.toJson(layout.data);
            //  Log.i("ProteusEventWithTag", "ffffffffffffffffffffffffffffffffff"+ccc);
            ProteusContext context = (ProteusContext) view.getContext();

            return new SimpleListAdapter(context.getInflater(), data, layout, count != null ? count : 0,view, countt,mang);
        }
    };



    private ProteusLayoutInflater inflater;
    private  boolean loading = true;
    private  int page = 0;
    private Handler handler;

    private ObjectValue data;
    private ObjectValue maydatav;
    private int count;
    private Layout layout;
    private Map<String, Value> scope;
    private  String getlay;
    private ProteusRecyclerView viewb;
    private static ObjectValue ccff=new ObjectValue();
    private  String tagname;
    private  int indexx=0;
    private int finalcount=0;
    private  String[] filterdata;

    private ProteusView.Manager mymanger;
    public boolean showw=false;
    private   String useapi;
    private   String methodtap;
    private String requestbody;
    private   String urldat;
    private String bbb;
    private  boolean isstalloading=false;
    private SimpleListAdapter(ProteusLayoutInflater inflater, ObjectValue data, Layout layout, int count, ProteusRecyclerView viewbb,int fincount,ProteusView.Manager mymanger) {

        this.inflater = inflater;
        this.data = data;
        this.count = count;
        this.getlay=layout.type;
        this.layout = new Layout(layout.type, layout.attributes, null, layout.extras);
        this.scope = layout.data;
        this.mymanger=mymanger;
        Gson g=new Gson();
        this.finalcount=fincount;
        this.viewb=viewbb;
        try {
            filterdata = viewbb.getTag(R.id.filterdata).toString().split("#");
        }catch (Exception ex){

        }
        try {
            indexx=Integer.parseInt(viewbb.getTag(R.id.indexIDtage).toString());
        }catch (Exception ex){


        }
        this.handler = new Handler();

        handler.removeCallbacks(fakeCallback);
        // adapter = new RecyclerPersonAdapterr(dddd.getRandomData(initialItems));
        loading = false;
        page = 0;

        int layoutOrientation;
        try{
            urldat = String.valueOf(viewbb.getTag(R.id.Recleapi_url));
            methodtap = String.valueOf(viewbb.getAsView().getTag(R.id.Recleapi_Method));
            requestbody = String.valueOf(viewbb.getAsView().getTag(R.id.Recleapi_body));
            bbb = String.valueOf(viewbb.getAsView().getTag(R.id.tag2));
            useapi =String.valueOf(viewbb.getAsView().getTag(R.id.Recleapi_use));
        }catch (Exception ex){

        }
        // Log.i("ProteusEventWithTag", "vvvvvvvvvvvvvvvmmmmm"+g.toJson( this.scope));
    }

    public  boolean checkifdelete(Value val,boolean checkfieldname,String filedname,String con) {
        boolean ffertt = false;

        Iterator<Map.Entry<String, Value>> vvm = val.getAsObject().entrySet().iterator();
        int countre = 0;
        boolean gggg = false;
        while (vvm.hasNext()) {

            //البحث عن الحذف
            Map.Entry<String, Value> dderttu = vvm.next();


            if (dderttu.getValue().isArray()) {
                Array ttv = dderttu.getValue().getAsArray();
                Gson ggf = new Gson();

                String cc = ggf.toJson(ttv);//  .toString();



            } else {

                String gp = dderttu.getValue().toString();//.getAsObject().get("name").toString();

                if(checkfieldname) {


                    if (dderttu.getKey().equals(filedname)) {
                        if (!gp.contains(con)) {
                            gggg = true;

                        }
                    }

                }else {

                    if (!gp.contains(con)) {
                        //  Log.i("z00000000000yy", bb.get(xxcm).toString() + "@@" + gp);
                        gggg = true;

                    }
                }
                if (gggg) {


                    ffertt=true;
                    // vvm.remove();
                    // vvvk.remove();
                }

                countre = countre + 1;
            }
        }


        return  ffertt;
    }


    //set
    @Override
    public ProteusViewHolder onCreateViewHolder(ViewGroup parent, int type) {

        ViewGroup.LayoutParams gg=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
     /* SkeletonViewGroup jjj=new SkeletonViewGroup(parent.getContext());
    Log.i("ProteusEventWithTag", "ffffffffffffffffffffffffffffffffff");

      ArrayList<SkeletonModel> kk=new ArrayList<>();
par
*/





        // Log.i("ProteusEventWithTag", String.valueOf(parent.getChildCount())+"hhhhhhhhhhhhhh");
        ProteusView view = inflater.inflate(layout ,new ObjectValue());

        // Log.i("ProteusEventWithTag", "ffffffffffffffffffffffffffffffffff");
    /* view.
      kk.add(new SkeletonModelBuilder().setChildView(view.getAsView()).setCustomHeight(ConverterUnitUtil.dpToPx(
              view.getAsView().getContext(),500f
      )).setCustomWidth( ConverterUnitUtil.dpToPx(view.getAsView().getContext(),500f)).build());
      jjj.setSkeletonModels(kk);
      parent.addView(jjj);
*/
        // Log.i("ProteusEventWithTag", String.valueOf(type));
        // com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(view.getAsView())
        // .rippleOverlay(false).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(false).create();*/
  /* return  new ProteusViewHolder(MaterialRippleLayout.on(view.getAsView()).rippleAlpha(0.8f)
            .rippleOverlay(true).rippleColor(R.color.astoolBorderInputColor).create()
    );*/
        return new ProteusViewHolder(view);
    }
    public  void myupdate(ObjectValue serachtext) {



      /*data=serachtext;
      count=100;
      notifyDataSetChanged();*/
    }
    public  void resitcountt(String serachtext){


        Gson yy=new Gson();
        if(maydatav==null){

            copydata hh=new copydata(data.copy());
            maydatav=hh.getresults();
        }

        new AsyncTaskRunner(serachtext).execute(maydatav);


    }


    private Runnable fakeCallbackk = new Runnable() {
        @Override
        public void run() {

            // Log.d("Paginate",   "هههههههههxxiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiMMMMMMMMMMM"  + "يتم التحمي");

            if(!isstalloading) {
                isstalloading=true;
                loadref();
            }

            //Log.d("Paginate", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiuuuuyyyyyyyyy");
        }
    };



    public void  setloading(boolean show){


        this.showw=show;
    }


    public  void loadref(){

        Gson bb = new Gson();
        String hhh = "jj";

        String keyname = "";
        for (Map.Entry<String, Value> entry : this.mymanger.getDataContext().getData().entrySet()) {
            keyname = entry.getKey();
        }
        //final ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(((ProteusRecyclerView) view).getViewManager().getContext());
        final Array vvc = this.mymanger.getDataContext().getData().get(keyname).getAsArray();
        String vv = bb.toJson(this.mymanger.getDataContext().getData());
        // final SimpleListAdapter sim = (SimpleListAdapter) view.getAdapter();
        final int bbb = this.mymanger.getDataContext().getData().get(keyname).getAsArray().size();

        //   Log.i("hhhhhhhhhhhhhh",String.valueOf(bbb));
        String prograssnam ="no";// ((ProteusRecyclerView) viewb).getTag(R.id.scrollPrograss).toString();
        if (prograssnam.equals("no")) {
            try {
                EventProcessor uuip = new EventProcessor() {
                    @Override
                    public void setOnEventListener(View view, Value value) {

                    }

                    @Override
                    public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
                        super.triggerAdapter(typ, withtage, Tagv, event, value, view);
                        if (typ == 5) {
                            //show Prograss
                            if (Tagv.equals("0")) {

                                if (value != null) {

                                    Array vffd = value.getAsArray("s1");

                                    for (int xxc = 0; xxc < vffd.size(); xxc++) {


                                        vvc.add(vffd.get(xxc));
                                    }
                                    //  isload = false;

                                    //  Log.i("xxxxxxxxxxx", "ooooooooooooooopxxxxxxxx"+String.valueOf(value.get("s1").getAsArray().size()));
                                    //  assert sim != null;
                                    change_data(value.get("s1").getAsArray().size());
                                    notifyItemInserted(bbb);
                                } else {
                                    // isload = false;

                                }
                            }
                            if (Tagv.equals("1")) {
                                // isload = true;
                            }

                        }
                    }
                };

                //  uuip.triggerAdapter(5, false, "1", prograssnam, null, ((ProteusRecyclerView) viewb));

                showprograssbarr(((ProteusView) viewb), String.valueOf(bbb), prograssnam, uuip);

            }catch (Exception ex){

                Log.i("xxffxxff",ex.getMessage());
                showw=true;
                notifyDataSetChanged();
                showw=false;
            }
        }

    }
    private Runnable fakeCallback = new Runnable() {
        @Override
        public void run() {
            // page++;

            //  final SimpleListAdapter sim = (SimpleListAdapter) this.getAdapter();
            //  sim.setloading(false);
            Log.d("Paginate", "iiiiiiiikkkkkkkllllllllllllllllll");

           /* if(!hasLoadedAllItems()) {
                count++;
                // notifyDataSetChanged();
            }*/
            //   Log.i("oooooo","nowwwwwvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
            loading = false;
//}
            // SimpleListAdapter cc=  (SimpleListAdapter)V.Adapter;
            // adapter.add(dddd.getRandomData(itemsPerPage));
            //  loading = false;

            //notifyDataSetChanged();
            //  ppii.endsrcoll(1,1);
            //ppii.onLoadMore(0,0);
        }
    };


    // @Override
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {
        //   Log.i("oooooo","nowwwwwvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

    }

    public class AsyncTaskRunner extends AsyncTask<ObjectValue,ObjectValue, ObjectValue> {

        //   private String resp;
        boolean tt=false;

        // ProgressDialog progressDialog;
        String serachtext="0";
        String bbaat="0";
        public     AsyncTaskRunner(String serach){
            serachtext=serach;

        }
        @Override
        protected ObjectValue doInBackground(final ObjectValue... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            ObjectValue maydata=params[0];
            ObjectValue uu=null;
            int countwithout=0;
            try {

                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");

              /*  String Postmethod=params[1];
                String requestbody=params[2];
                final String refresh=params[3];
                final String without=params[4];*/



                ObjectValue filteredPlacesList=new ObjectValue();

                Array bb=new Array();


                ObjectValue uuiop=    loadload(maydata,null,filteredPlacesList,"0",serachtext,bb);
                copydata hh=new copydata(uuiop.copy());
                ObjectValue ff=hh.getresults();

                int cooo=0;

                ObjectValue uiop=new ObjectValue();
                String keynammm="0";
                // copydata hh=new copydata(maydata);
                // ObjectValue ff=hh.getresults();
                Iterator<Map.Entry<String, Value>> vv = ff.entrySet().iterator();
                while (vv.hasNext()) {

                    Map.Entry<String, Value> ddertt = vv.next();
                    keynammm=ddertt.getKey();
                    Gson ggff = new Gson();

                    String ccn = ggff.toJson(ddertt.getValue());//  .toString();
                    if(ddertt.getValue().isArray()){
                        Iterator<Value> vvvk = ddertt.getValue().getAsArray().iterator();
                        int zzz=0;
                        while (vvvk.hasNext()) {
                            Value vvvkk=vvvk.next();
                            zzz=zzz+1;
                            if(vvvkk.isArray()) {
                                Array ttv = vvvkk.getAsArray();
                                Gson ggf = new Gson();
                            }else  if(vvvkk.isObject())
                            {

                                try {

                                    List<Boolean> hhvk=new ArrayList<>();
                                    boolean finall=true;
                                    for (int xxc = 0; xxc < filterdata.length; xxc++) {
                                        //Iterator<Map.Entry<String, Value>> vvm = vvvkk.getAsObject().entrySet().iterator();
                                        boolean cx = checkifdelete(vvvkk, true, filterdata[xxc], serachtext.toString());
                                        hhvk.add(cx);
                                    }
                                    for (int xxc = 0; xxc < hhvk.size(); xxc++) {
                                        if(!hhvk.get(xxc)){
                                            finall=false;
                                        }
                                    }
                                    countwithout=countwithout+1;
                                    if(finall){

                                        vvvk.remove();

                                    }else {
                                        cooo=cooo+1;
                                    }



                                }catch (Exception ex){

                                    //Gson uuiop=new Gson();

                                }
                            }else {


                                if(!vvvkk.toString().contains(serachtext.toString())){

                                    vvvk.remove();
                                }else {
                                    cooo=cooo+1;
                                }


                            }

                        }


                    }else

                    if(ddertt.getValue().isObject()){
                        Iterator<Map.Entry<String, Value>> vvv = ddertt.getValue().getAsObject().entrySet().iterator();
                        while (vvv.hasNext()) {

                            Map.Entry<String, Value> dderttv = vvv.next();
                            // Log.i("zzzzxxxxxxxMMMMkkkkkk",dderttv.getKey());
                        }

                    }

                }



                // loadanotherr(ff,bb,false,null);


                count= cooo;
                uu=ff;


            } catch (Exception ex) {
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            if (serachtext == null || serachtext.length() == 0) {

                count=  countwithout;
                return maydata;

            }else {
                return uu;
            }
        }


        @Override
        protected void onPostExecute(ObjectValue result) {
            try {
             /*   data=null;
                data=result;*/
                data=null;
                data=result;
                // notifyDataSetChanged();
                notifyDataSetChanged();
            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(ObjectValue... text) {
            // finalResult.setText(text[0]);

        }
    }

    public  void loadanotherr(ObjectValue ff,Array bb,boolean isarreay,Array datab ){


        if(isarreay){

            try {
                Iterator<Value> vvv = datab.iterator();
                while (vvv.hasNext()) {



                    Value bbk = vvv.next();
                    if(bbk.isObject()){
                        loadanotherr(bbk.getAsObject(),bb,false,null);

                    }else if(bbk.isArray())
                    {
                        loadanotherr(bbk.getAsObject(),bb,true,bbk.getAsArray());

                    }else {
                        // Log.i("zxxxxxxxxxxxxxx", bbk);
                        boolean c = serand(bbk.toString(), bb);
                        if (!c) {
                            vvv.remove();

                        }
                    }
                }
            }catch (Exception ex){

                //  Log.i("zxxxxxxxxxxxxxx", ex.getMessage()+"vvvvvvvvvvvvvv");
            }
        }else {
            Iterator<Map.Entry<String, Value>> vv = ff.entrySet().iterator();
            while (vv.hasNext()) {

                Value ddert = vv.next().getValue();
                if (ddert.isArray()) {
                    try {
                        Iterator<Value> vvv = ddert.getAsArray().iterator();
                        while (vvv.hasNext()) {


                            Value bbk = vvv.next();
                            if (bbk.isObject()) {
                                loadanotherr(bbk.getAsObject(), bb, false, null);

                            } else if (bbk.isArray()) {
                                loadanotherr(bbk.getAsObject(), bb, true, bbk.getAsArray());

                            } else {
                                // Log.i("zxxxxxxxxxxxxxx", bbk);
                                boolean c = serand(bbk.toString(), bb);
                                if (!c) {
                                    vvv.remove();

                                }
                            }
                        }
                    } catch (Exception ex) {

                        //  Log.i("zxxxxxxxxxxxxxx", ex.getMessage()+"vvvvvvvvvvvvvv");
                    }
                } else if (ddert.isObject()) {
                    loadanotherr(ddert.getAsObject(), bb, false, null);
                } else {
                    String bbk = ddert.toString();
                    // Log.i("zxxxxxxxxxxxxxx", bbk);
                    boolean c = serand(bbk, bb);
                    if (!c) {
                        vv.remove();

                    }
                }

            }
        }
    }


    public boolean serand(String serchtext,Array comparr){

        boolean cc=false;
        for (int xxc = 0; xxc < comparr.size(); xxc++) {
            if(comparr.get(xxc).toString().equals(serchtext)) {
                cc=true;
            }

        }

        return  cc;
    }


    public  void removeda(ObjectValue entry,Array addda,Array combar ){

        // ObjectValue iio=new ObjectValue();
        if(entry!=null){

            for (Map.Entry<String, Value> entryv : entry.entrySet()) {
                try {

                    if(entryv.getValue().isObject()) {
                        ObjectValue ff = entryv.getValue().getAsObject();
                        // Log.i("zxxxxxxxxxxxxxx","oooooooooooooooooooooooooooooooB");
                        //iio.add(entryv.getKey(),entryv.getValue());
                        removeda(ff,null,combar );
                    } else if(entryv.getValue().isArray()) {
                        Array ff = entryv.getValue().getAsArray();
                        // iio.add(entryv.getKey(),ff);
                        // Log.i("zxxxxxxxxxxxxxx","oooooooooooooooooooooooooooooooA");
                        removeda(null,ff,combar );

                    }else {
                        // Log.i("zxxxxxxxxxxxxxx","ooooooooooooooooooooooooooooooo");
                        boolean gger=serand(entryv.getValue().toString(),combar);
                        if(!gger){

                        }



                    }
                }catch (Exception ex){

                }
            }
        }else {
            for (int xxc = 0; xxc < addda.size(); xxc++) {

                try {

                    if(addda.get(xxc).isArray()) {
                        Array uuip = addda.get(xxc).getAsArray();

                        // adddata.add(u,arr.get(xxc));
                        removeda(null,uuip,combar );
                    }else  if(addda.get(xxc).isObject()){
                        ObjectValue ffv = addda.get(xxc).getAsObject();
                        removeda(ffv,null,combar );

                    } else {
                        try {


                            boolean gger=serand(addda.get(xxc).toString(),combar);

                            Gson bb=new Gson();
                            //  Log.i("zxxxxxxxxxxxxxx","oooooooooooooooooooooooooooooooBKKKKK"+bb.toJson(addda));

                            addda.remove(xxc);
                            // Log.i("zxxxxxxxxxxxxxx","oooooooooooooooooooooooooooooooBKKKKK"+bb.toJson(addda));

                            // if(xxc!=0){
                            //  addda.remove(xxc);
                            // }
             /* if(!gger){
                Log.i("zxxxxxxxxxxxxxx","oooooooooooooooooooooooooooooooBKKKKK");

              }
*/
              /*if(addda.get(xxc).toString().contains(serchnam)) {

                addda.add(arr.get(xxc).toString());
              }*/

                        }catch (Exception ex){

                        }

                    }
                }catch (Exception ex){

                }



            }

        }


    }


    public  ObjectValue loadload(ObjectValue entry,Array arr,ObjectValue adddata,String keynam,String serchnam,Array addda ){

        ObjectValue iio=new ObjectValue();
        if(entry!=null){

            for (Map.Entry<String, Value> entryv : entry.entrySet()) {
                try {

                    if(entryv.getValue().isObject()) {
                        ObjectValue ff = entryv.getValue().getAsObject();
                        iio.add(entryv.getKey(),entryv.getValue());
                        loadload(ff, null,adddata,entryv.getKey(),serchnam,addda);
                    } else if(entryv.getValue().isArray()) {
                        Array ff = entryv.getValue().getAsArray();
                        iio.add(entryv.getKey(),ff);
                        loadload(null, ff,adddata,entryv.getKey(),serchnam,addda);

                    }else {
                        if(entryv.getValue().toString().contains(serchnam)){

                            addda.add(entryv.getValue());
                        }

                        //  Log.i("ProteusEventWithTag", "ddddddddddddddddAAA"+entryv.toString());

                    }
                }catch (Exception ex){

                }
            }
        }else {
            for (int xxc = 0; xxc < arr.size(); xxc++) {

                try {

                    if(arr.get(xxc).isArray()) {
                        Array uuip = arr.get(xxc).getAsArray();

                        // adddata.add(u,arr.get(xxc));
                        loadload(null, uuip,adddata,keynam,serchnam,addda);
                    }else  if(arr.get(xxc).isObject()){
                        ObjectValue ffv = arr.get(xxc).getAsObject();
                        loadload(ffv, null,adddata,keynam,serchnam,addda);

                    } else {
                        try {
                            if(arr.get(xxc).toString().contains(serchnam)) {

                                addda.add(arr.get(xxc).toString());
                            }

                        }catch (Exception ex){

                        }

                    }
                }catch (Exception ex){

                }



            }

        }

        return  iio;
    }

    @Override
    public void onBindViewHolder(final ProteusViewHolder holder, final int position) {



        Gson vv=new Gson();
        final DataContext context = DataContext.create(holder.context, data, position, scope);
        //  Log.i("Proteusagttttttttttttt", vv.toJson(context.getData()));

        String useclick="0";
        String TypAction="0";
        try{

            useclick =String.valueOf(holder.view.getAsView().getTag(R.id.TageUseclick));
            TypAction =String.valueOf(holder.view.getAsView().getTag(R.id.tagtypaction));
        }catch (Exception ex){

            useclick="0";
        }
        if(useclick.equals("1")) {


            final String finalTypAction = TypAction;
            holder.view.getAsView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Gson gsonn = new Gson();

                    Object[] vvcx = context.getData().entrySet().toArray();

                    EventProcessor uuip = new EventProcessor() {
                        @Override
                        public void setOnEventListener(View view, Value value) {

                        }
                    }; //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);


                    uuip.triggerAdapter(1, false, finalTypAction, "h", context.getData(), holder.view);

                    // holder.view.getViewManager().GetData(holder.view,context.getData(),2,"d");
                    // String vvcx=gg.toJson(context.getData()..entrySet());
                    //Log.i("ProteusEventWithTag", vvcx + holder.view.getClass().getName() + "تم النقررررر");
                }
            });
        }
        Gson gsonn = new Gson();

        // Log.i("ProteusEventWithTag", gsonn.toJson(context.getScope()) + "تم النقررررر");
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        holder.view.getViewManager().update(context.getData());

    }


    public void refreshdata(){
        this.notifyDataSetChanged();



    }
    @Override
    public int getItemCount() {
        return count;
    }
    public  void showprograssbarr(ProteusView view,String countItem,String prograssnam,EventProcessor uuipx) throws MalformedURLException {


        Log.i("oopoiiii","0000000");

        if(useapi.equals("1")) {


            String resul[] = GlobalClass.getBaseURL(urldat);

          //  GlobalClass.BseUrl2 = resul[0];

            String mmn = "'";
            char d = mmn.charAt(0);
            String mmnd = "@";
            char dd = mmnd.charAt(0);
            requestbody = requestbody.replace('#', '"').replace(dd, d);
            // String bbb = "[]";
            try {


                CharSequence oopp=countItem;

                bbb = bbb.replace('#', '"').replace(dd, d).replace("$",oopp);



                new AsyncTaskRunnerv(view,prograssnam,uuipx).execute(resul[1],methodtap,bbb,"1","0");

                // JSONObject js=new JSONObject(datab);
                // Gson hnn = new Gson();
                // bbb=hnn.toJson(datab);
            } catch (Exception ex) {

                loadrefd();
            }
            // checknull = false;
            // Log.i("ProteusEventWithTag", bbb);
      /*  Gson hn = new Gson();
        Type type = new TypeToken<List<DataValueSelect>>() {

        }.getType();
        List<DataValueSelect> kmn = hn.fromJson(bbb, type);
*/
            //   String typad = kmn.get(0).getUnitName();
        /*allunit = null;
        allunit = new ArrayList<resultData>();
        serchhview(container, kmn);
        for (int cxx = 0; cxx < allunit.size(); cxx++) {

            Log.i("ProteusEventWithTag", allunit.get(cxx).getDataGet());
            Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
            requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }*/
           //Log.i("ProteusEventWithTag", requestbody);
        }


    }
    public  void loadrefd(){
        isstalloading=false;
        showw=true;
        notifyDataSetChanged();
        showw=false;

    }
    class AsyncTaskRunnerv extends AsyncTask<String, String, String> {

        private String resp;
        boolean tt=false;

        // ProgressDialog progressDialog;
        String bbaa="0";
        String bbaat="0";
        public ProteusView protvv;
        public   String prograssnn;
        public EventProcessor uuip;
        AsyncTaskRunnerv(ProteusView myview, String prograssnnm, EventProcessor uuipp) {
            this.protvv = myview;
            this.prograssnn=prograssnnm;
            this.uuip=uuipp;


        }

        @Override
        protected String doInBackground(final String... params) {
            // publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);

                String URL=params[0];
                String Postmethod=params[1];
                String requestbody=params[2];
                final String refresh=params[3];
                final String without=params[4];
                String contettyp="application/json; charset=UTF-8";
                String userAgentt="fromandroid";
                final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);
                RequestBody requestBodyBinary = null;

                requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                // sendreq(params[0],params[1],params[2]);
                Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary):Retrofitapi.GetMethod(URL,requestBodyBinary);

                call.enqueue(new Callback<ResponseBody>() {


                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {

                            assert response.body() != null;
                            // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");
                            String x="mydesin";

                            if(response.isSuccessful()) {

                                String jm= "{s1:"+response.body().string()+"}";

                                if(refresh.equals("1")) {
                                    ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                    Gson gsonn = new GsonBuilder()
                                            .registerTypeAdapterFactory(adapter)
                                            .create();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();
                                    Value tempp = gsonn.fromJson(jm, type);
                                    uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv));
                                    loadrefd();

                                }else{
                                    loadrefd();

                                }


                            }else{
                                try {
                                    assert response.errorBody() != null;
                                    String k="{s1:"+response.errorBody().string()+"}";
                                    if(refresh.equals("1")) {
                                        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                        Gson gsonn = new GsonBuilder()
                                                .registerTypeAdapterFactory(adapter)
                                                .create();
                                        Type type = new TypeToken<Value>() {

                                        }.getType();
                                        Value tempp = gsonn.fromJson(k, type);
                                        uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv));
                                        loadrefd();
                                        // aooldder(without,container, tempp.getAsObject());
                                    }else {
                                        //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                        loadrefd();

                                        // masss.showmessage(k);

                                    }
                                    // masss.showmessage(ex.getMessage());



                                    //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                    // savetoref(x, response.errorBody().string());
                                    //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                }catch (IOException ex){

                                    //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));

                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                    loadrefd();
                                    // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                }
                            }


                        } catch (Exception ex) {

                            //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));

                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                            loadrefd();
                            // masss.showmessage(ex.getMessage());
                            // stoptimertask();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        //  stoptimertask();

                        // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");

                        uuip.triggerAdapter(20, false, t.getMessage()+"لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));

                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                        loadrefd();
                        // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                        //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                    }
                });


            } catch (Exception ex) {
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return bbaa;
        }


        @Override
        protected void onPostExecute(String result) {
            try {

            }catch (Exception e){

                e.printStackTrace();
            }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

            // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
        }


        @Override
        protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
        }


        @Override
        protected void onProgressUpdate(String... text) {
            // finalResult.setText(text[0]);

        }
    }
    //@Override
    public void change_data(int coun) {

        // Log.i("ProteusEventWithTag", "تم التحديثث");

        count=coun;
        //this.data.entrySet().clear();;
    /*this.data=dataupdate;
    ProteusView view = inflater.inflate(layout, new ObjectValue());
    view.getViewManager().update(this.data);*/
        this
                .notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Log.i("ProteusEventWithTag", "تم التحديثث");
    }



    class VH extends RecyclerView.ViewHolder {
        // TextView tvLoading;

        public VH(View itemView) {
            super(itemView);
            //  tvLoading = (TextView) itemView.findViewById(R.id.tv_loading_text);
        }
    }
}
