package com.astooltech.advancedview.proteus.v7.adapter;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.v7.widget.AutoCompleteTextViewB;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.astooltech.advancedview.GlobalClass.PREFS_NAME;


public class SimpleListAdapter3    extends AutoCompleteTextViewBparserAdapter<VHH>  {

    private ProteusLayoutInflater inflater;
    private static final String ATTRIBUTE_ITEM_LAYOUT = "item-layout";
    private static final String ATTRIBUTE_ITEM_COUNT = "item-count";
    private ObjectValue data;
    private ObjectValue datav;

    private   static  ObjectValue mydat;
    private int count;
    private Layout layout;
    private   AutoCompleteTextViewB viewb;
    private Map<String, Value> scope;
    private ObjectValue maydata;
    private  String tagname;
    private  String[] filterdata;
private  int indexx=0;
    public static final AutoCompleteTextViewBparserAdapter.Builder<SimpleListAdapter3> BUILDER = new AutoCompleteTextViewBparserAdapter.Builder<SimpleListAdapter3>() {
        @NonNull
        @Override
        public SimpleListAdapter3 create(@NonNull AutoCompleteTextViewB view, @NonNull ObjectValue config) {
            Layout layout = config.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
            Integer count = config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT);
            ObjectValue data = view.getViewManager().getDataContext().getData();
            SharedPreferences settings = view.getViewManager().getContext().getSharedPreferences(PREFS_NAME, 0);
            final String mpp = settings.getString("d", "");
//Log.i("rrrrrrr",mpp);


            JsonArray bb=new JsonArray();




            /*
ObjectValue ff=new ObjectValue();
ff.add("s",tempp.getAsObject());*/
            ProteusContext context = (ProteusContext) view.getContext();

            return new SimpleListAdapter3(context.getInflater(), data, layout, count != null ? count : 0,view);
        }
    };



    public  void loadanotherr(ObjectValue ff,Array bb,boolean isarreay,Array datab,String notremove ){


        if(isarreay){

            try {
                Iterator<Value> vvv = datab.iterator();
                while (vvv.hasNext()) {



                    Value bbk = vvv.next();
                    if(bbk.isObject()){
                        loadanotherr(bbk.getAsObject(),bb,false,null,notremove);

                    }else if(bbk.isArray())
                    {
                        loadanotherr(bbk.getAsObject(),bb,true,bbk.getAsArray(),notremove);

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

                Map.Entry<String, Value> ddertt = vv.next();
              Value  ddert=ddertt.getValue();
                String  Stringg = ddertt.getKey();
                if(!Stringg.equals(notremove) && !Stringg.equals("name")) {
                    if (ddert.isArray()) {
                        try {
                            Iterator<Value> vvv = ddert.getAsArray().iterator();
                            while (vvv.hasNext()) {


                                Value bbk = vvv.next();
                                if (bbk.isObject()) {

                                    loadanotherr(bbk.getAsObject(), bb, false, null, notremove);

                                } else if (bbk.isArray()) {
                                    loadanotherr(bbk.getAsObject(), bb, true, bbk.getAsArray(), notremove);

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
                        loadanotherr(ddert.getAsObject(), bb, false, null, notremove);
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


    @Override
    public Filter getFilter(){


        // Your Search logic goes here..
        Filter filter = new Filter() {

//int indexx=0;

            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {



                ObjectValue jj =(ObjectValue)results.values;// Array();// data.get("items").getAsArray();
              //  Log.i("gggggggccccc",String.valueOf(results.count));
              data=null;
               count=results.count;
             data=jj;


                notifyDataSetChanged();
                notifyDataSetInvalidated();

            }


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results=new FilterResults();


                  //  copydata hhv=new copydata(GlobalClass.datsorce.get(indexx).getDatasorsce().copy());
                    //maydata=hhv.getresults();

                ObjectValue filteredPlacesList=new ObjectValue();

                Array bb=new Array();

               Gson tt=new Gson();
int cooo=0;
               ObjectValue uiop=new ObjectValue();
               String keynammm="0";
                copydata hh=new copydata(maydata);
                ObjectValue ff=hh.getresults();
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
                                        boolean cx = checkifdelete(vvvkk, true, filterdata[xxc], constraint.toString());
                                        hhvk.add(cx);
                                    }
                                    for (int xxc = 0; xxc < hhvk.size(); xxc++) {
                                        if(!hhvk.get(xxc)){
                                            finall=false;
                                        }
                                    }

                                if(finall){

                                    vvvk.remove();

                                }else {
                                    cooo=cooo+1;
                                }



                                }catch (Exception ex){

                                    Gson uuiop=new Gson();

                                }
                            }else {


                                if(!vvvkk.toString().contains(constraint.toString())){

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
                data=null;

                synchronized (this) {
                    // set the Filtered result to return

                    results.count =5;//cooo;
                    results.values = ff;

                }

                   //  ;

            /* results.count=1;
                data=ff;
                count=1;*/
               // notifyDataSetChanged();
                //  data=jj;

            return results;
        }

    };
   return filter;
}

    public  SimpleListAdapter3(ProteusLayoutInflater inflater, ObjectValue data, Layout layout, int count,AutoCompleteTextViewB viewbb) {



        this.inflater = inflater;
        this.data = data;
      //  this.mydat=(ObjectValue)viewbb.getTag(R.id.valueStorage);
   try {
       this.tagname = viewbb.getTag(R.id.tag3).toString();



   }catch (Exception e){

       this.tagname="@";
   }
       // Gson ffr=new Gson();

      //  ObjectValue jj =(ObjectValue)results.values;// Array();// data.get("items").getAsArray();
      //  Log.i("ggggggg",ffr.toJson(this.mydat));
        this.count = count;
        this.layout = new Layout(layout.type, layout.attributes, null, layout.extras);
        this.scope = layout.data;
        this.viewb=viewbb;

        try {
            filterdata = viewbb.getTag(R.id.filterdata).toString().split("#");
        }catch (Exception ex){

        }
try {
  indexx=Integer.parseInt(viewbb.getTag(R.id.indexIDtage).toString());
}catch (Exception ex){


}
    }


   /* public ObjectValue getData() {
        ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        DataContext context = viewv.getViewManager().getDataContext();
        // DataContext context = DataContext.create(this., data, i, scope);
        // Log.i("ProteusEventWithTag", String.valueOf(position));
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        viewv.getViewManager().update(context.getData());
        return  viewv.getAsView();
    }
*/

   /* @Override
    public int getCount() {
        return 0;
    }


    @Override
    public Object getItem(int i) {
        ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        DataContext context = viewv.getViewManager().getDataContext();
        // DataContext context = DataContext.create(this., data, i, scope);
        // Log.i("ProteusEventWithTag", String.valueOf(position));
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        viewv.getViewManager().update(context.getData());
        return  viewv.getAsView();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
*/


    @Override
    public int getCount() {

        // ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        // DataContext context = viewv.getViewManager().getDataContext();
        // DataContext context = DataContext.create(this., data, i, scope);
        //  Log.i("ProteusEventWithTag","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        return count;//  viewv.getViewManager().getDataContext().getData().entrySet().size();


    }

    @Override
    public Object getItem(int i) {
        final ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        final DataContext context = viewv.getViewManager().getDataContext();
        final DataContext contextm = DataContext.create(viewv.getViewManager().getContext(), data, i, scope);




        // DataContext context = DataContext.create(this., data, i, scope);
        //  Log.i("ProteusEventWithTag","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        viewv.getViewManager().update(context.getData());
        return  viewv.getAsView();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        final ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        //  DataContext context = viewv.getViewManager().getDataContext();
        final DataContext context = DataContext.create(viewv.getViewManager().getContext(), data, i, scope);

        String useclick="0";
        String TypAction="0";
       // viewv.getAsView().setTag(R.id.tageSetvalue,"");
       // viewv.getAsView().setTag(R.id.tageSetvalue,context.getData());

        try{

            useclick =String.valueOf(viewv.getAsView().getTag(R.id.TageUseclick));
            TypAction =String.valueOf(viewv.getAsView().getTag(R.id.tagtypaction));
        }catch (Exception ex){

            useclick="0";
        }
        if(useclick.equals("1")) {


            final String finalTypAction = TypAction;
            viewv.getAsView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   // Gson gsonn = new Gson();

                   // Object[] vvcx = context.getData().entrySet().toArray();

                    EventProcessor uuip = new EventProcessor() {
                        @Override
                        public void setOnEventListener(View view, Value value) {

                        }
                    }; //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);


                    uuip.triggerAdapter(2, false, finalTypAction, "h", context.getData(), viewv);

                    // holder.view.getViewManager().GetData(holder.view,context.getData(),2,"d");
                    // String vvcx=gg.toJson(context.getData()..entrySet());
                    // Log.i("ProteusEventWithTag", vvcx + ho.view.getClass().getName() + "تم النقررررر");
                }
            });
        }




        // Log.i("ProteusEventWithTag","hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        // Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
        viewv.getViewManager().update(context.getData());
        return  viewv.getAsView();
    }



   /* @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProteusView view = inflater.inflate(layout, new ObjectValue());


    /* com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout.on(view.getAsView())
            .rippleOverlay(false).rippleAlpha(0.8f).rippleColor(0xFF585858).rippleHover(false).create();

        return new ProteusViewHolder(view);
    }
 */
}


