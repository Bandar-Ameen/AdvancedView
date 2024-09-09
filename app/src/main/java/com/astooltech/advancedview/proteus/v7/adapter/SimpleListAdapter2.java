package com.astooltech.advancedview.proteus.v7.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.v7.widget.SpainnerViewB;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import java.util.Iterator;
import java.util.Map;


public class SimpleListAdapter2    extends SpainnerViewParserAdapter<VHH>  {

    private ProteusLayoutInflater inflater;
    private static final String ATTRIBUTE_ITEM_LAYOUT = "item-layout";
    private static final String ATTRIBUTE_ITEM_COUNT = "item-count";
    private ObjectValue data;
    private int count;
    private Layout layout;
    private Map<String, Value> scope;
    public static final SpainnerViewParserAdapter.Builder<SimpleListAdapter2> BUILDER = new SpainnerViewParserAdapter.Builder<SimpleListAdapter2>() {
        @NonNull
        @Override
        public SimpleListAdapter2 create(@NonNull SpainnerViewB view, @NonNull ObjectValue config) {
            Layout layout = config.getAsObject().getAsLayout(ATTRIBUTE_ITEM_LAYOUT);
            Integer count = config.getAsObject().getAsInteger(ATTRIBUTE_ITEM_COUNT);
            ObjectValue data = view.getViewManager().getDataContext().getData();
            ProteusContext context = (ProteusContext) view.getContext();

            return new SimpleListAdapter2(context.getInflater(), data, layout, count != null ? count : 0);
        }
    };







      public  SimpleListAdapter2(ProteusLayoutInflater inflater, ObjectValue data, Layout layout, int count) {



          this.inflater = inflater;
          this.data = data;
          this.count = count;
          this.layout = new Layout(layout.type, layout.attributes, null, layout.extras);
          this.scope = layout.data;
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
                        if (gp.equals(con)) {
                            gggg = true;

                        }
                    }

                }else {

                    if (gp.equals(con)) {
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

    public int getpostionse(String getvalue,String IDname){
       // Log.i("iiiiiix",  IDname);
int resultss=0;
int postions=0;
            Gson yy=new Gson();


            ObjectValue filteredPlacesList=new ObjectValue();

            Array bb=new Array();



            int cooo=0;
            int countwithout=0;
            ObjectValue uiop=new ObjectValue();
            String keynammm="0";

            Iterator<Map.Entry<String, Value>> vv = data.entrySet().iterator();
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

                                Gson gg=new Gson();

                                postions+=1;
                           boolean checkk =    checkifdelete(vvvkk,true,IDname,getvalue);
                          if(checkk){
                              resultss= (postions==0?1:postions)-1;
                              Log.i("iiiiiix",   String.valueOf(resultss));
                             // postions
                          }


                              /*  List<Boolean> hhvk=new ArrayList<>();
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
                                }*/

                               /* if(finall){

                                    vvvk.remove();

                                }else {
                                    cooo=cooo+1;
                                }
*/


                            }catch (Exception ex){

                                //Gson uuiop=new Gson();

                            }
                        }else {


                          /*  if(!vvvkk.toString().contains(serachtext.toString())){

                                vvvk.remove();
                            }else {
                                cooo=cooo+1;
                            }*/


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






        return   resultss;



    }


    @Override
    public Object getItem(int i) {
        ProteusView viewv = inflater.inflate(layout, new ObjectValue());
        DataContext context = viewv.getViewManager().getDataContext();
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


        ProteusView viewv = inflater.inflate(layout, new ObjectValue());
      //  DataContext context = viewv.getViewManager().getDataContext();
        DataContext context = DataContext.create(viewv.getViewManager().getContext(), data, i, scope);
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


