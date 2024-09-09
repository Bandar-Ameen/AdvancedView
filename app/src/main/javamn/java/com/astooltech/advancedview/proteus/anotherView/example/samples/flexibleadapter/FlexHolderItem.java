package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter;

import android.content.Context;
import android.util.Log;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.anotherView.example.samples.HiderWithbody;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.StaggeredHeaderItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.StaggeredItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.StaggeredItemStatus;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseType;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.v7.adapter.OOverItHidertem;
import com.astooltech.advancedview.proteus.v7.adapter.OOverItHidertemheaderOnly;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.ScrollableUseCaseItemCustome;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FlexHolderItem {

   // private Map<StaggeredItemStatus, StaggeredHeaderItem> headers;

    private List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
    public List<AbstractFlexibleItem> createStaggeredDatabase(List<HiderWithbody> data) {

        mItemss.clear();


        for (int ii = 0; ii < data.size(); ii++) {

            StaggeredHeaderItem dd=new StaggeredHeaderItem(ii,data.get(ii).getHedrgropName());

            List<bodyHedaer> bodys=data.get(ii).getBodydata();
            for (int i = 0; i < bodys.size(); i++) {
                StaggeredItem it=   newStaggeredItem(ii + 1, dd,bodys.get(i).getBodytitle());

          mItemss.add(it);

            }
          //  mItems.add(it);
        }

        return  mItemss;
       // createMergedItems();
    }


   public  List<AbstractFlexibleItem>  getDataAllDataFromStringg(Value dataseteng,  ProteusLayoutInflater inflat){

        // Layout gg=infl.getViewManager().getContext().getLayout(this.layoutname);
        // String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        boolean useMultiplex = false;
        Gson gsonn = new Gson();
Layout gg=null;
Array datvalues=null;
        Map<String,List<AbstractFlexibleItem>> ddat=new HashMap<>();
        List<modeltypeview> mlti = new ArrayList<>();
        Value hederscroll=null;
        List<AbstractFlexibleItem> mItemssk = new ArrayList<AbstractFlexibleItem>();
boolean usediv=false;
        try {
            Iterator<Map.Entry<String, Value>> rre = dataseteng.getAsObject().entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if(ddertr.getKey().equals("a_enable")) {
                    String hyy = ddertr.getValue().getAsString();//.getAsObject().getAsString("a_enable");

                    if (hyy.equals("1")) {
                        useMultiplex = true;
                    }
                }
                if(ddertr.getKey().equals("Use_margin")) {
                    usediv = ddertr.getValue().getAsBoolean();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Def_Views")) {
                    gg = ddertr.getValue().getAsLayout();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Header_Views_Scroll")) {
                    hederscroll= ddertr.getValue().getAsObject();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Data_Value")) {
                    datvalues = ddertr.getValue().getAsArray();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Filter_Views")) {
                    Array ar = ddertr.getValue().getAsArray();
                    filte = new String[ar.size()];
                    int coun = 0;
                    Iterator<Value> uuu = ar.iterator();
                    while (uuu.hasNext()) {
                        Value val = uuu.next();
                        filte[coun] = val.getAsObject().getAsString("Key_Name");


                        coun = coun + 1;
                    }

                }  if(ddertr.getKey().equals("MultipleViews")) {

                    Array arm = ddertr.getValue().getAsArray();//.getAsObject().getAsArray("MultipleViews");


                    Iterator<Value> uuuk = arm.iterator();
                    while (uuuk.hasNext()) {
                        Value val = uuuk.next();

                        String vnm = val.getAsObject().getAsString("v_Name");
                        String vnmm = val.getAsObject().getAsString("v_ColumnName");
                        String vnmmk = val.getAsObject().getAsString("v_EqualValue");
                        String vnmmkk = val.getAsObject().getAsString("v_id");


                        modeltypeview ww = new modeltypeview(vnm, vnmm, vnmmk, vnmmkk);
                        mlti.add(ww);
                        ;
                    }
                }



            }


           // Value r = dtd.getAsObject().get("Result");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, datvalues);
            //  Array re=r.getAsArray();-
            int   ccc=0;
            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().get AsArray().size();
                Gson ggm = new Gson();
                ccc=ccc+1;
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {

                  try {
                      OOverItHidertemheaderOnly ioppp = new OOverItHidertemheaderOnly(mlti, useMultiplex, cx + 1, "no", gg, inflat, ddert.getValue().getAsArray().get(cx), filte);
                      //Log.e("55oooo9999999","jjjjjjjjjj");
                      Value getsubvalue = ddert.getValue().getAsArray().get(cx).getAsObject().get("Body_Value");
                    //  Log.e("55oooo9999999","jjjjjjkikkjjjj");
                      List<OOverItHidertem> y = getDataAllDataFromStringx(getsubvalue, inflat, ioppp);
                      // OOverItHidertem iopppx = new OOverItHidertem(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte,ioppp);
                     // Log.e("55oooo9999999","jjjjjjjjjooopppj");
try{
    Array  getsubvalued = ddert.getValue().getAsArray().get(cx).getAsObject().getAsArray("Marge_View");
    for (int cxx = 0; cxx < getsubvalued.size(); cxx++) {
        int row1=getsubvalued.get(cxx).getAsObject().getAsInteger("Get_Item");
        int row11=getsubvalued.get(cxx).getAsObject().getAsInteger("Remove_Item");
        mergeItem((OOverItHidertem) y.get(row1), (OOverItHidertem) y.remove(row11),y);
    }
}catch (Exception ex){

}
                      mItemssk.addAll(y);//.add(ioppp);
                  }catch (Exception ex){
                      Log.e("555999ttrreee99999999",ex.getMessage());
                  }
                  //  mItemssb.add(ioppp);
                }
            }
        }catch (Exception ex){

            Log.e("55599999999999",ex.getMessage());
        }
      /*  if(usediv) {
            createMergedItems(mItemssk);
        }*/
      // ddat.put("main",mItemssk);
try {
    List<ScrollableUseCaseItemCustome> kk= getDataAllDataFromString(hederscroll, inflat);
    setHeadersrcoll(kk);
}catch (Exception ex){

}
        return  mItemssk;

    }

    public List<ScrollableUseCaseItemCustome> getHeadersrcoll() {
        return headersrcoll;
    }

    public void setHeadersrcoll(List<ScrollableUseCaseItemCustome> headersrcoll) {
        this.headersrcoll = headersrcoll;
    }

    private List<ScrollableUseCaseItemCustome> headersrcoll;
  public List<OOverItHidertem> getDataAllDataFromStringx(Value dataseteng,  ProteusLayoutInflater inflat,OOverItHidertemheaderOnly hedronly){

        // Layout gg=infl.getViewManager().getContext().getLayout(this.layoutname);
        // String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        boolean useMultiplex = false;
        Gson gsonn = new Gson();
        Layout gg=null;
        Array datvalues=null;
     //   Map<String,List<AbstractFlexibleItem>> ddat=new HashMap<>();
        List<modeltypeview> mlti = new ArrayList<>();
        List<OOverItHidertem> mItemssk = new ArrayList<OOverItHidertem>();
      //  List<AbstractFlexibleItem> mItemssb = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = dataseteng.getAsObject().entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if(ddertr.getKey().equals("a_enable")) {
                    String hyy = ddertr.getValue().getAsString();//.getAsObject().getAsString("a_enable");

                    if (hyy.equals("1")) {
                        useMultiplex = true;
                    }
                }
                if(ddertr.getKey().equals("Def_Views")) {
                    gg = ddertr.getValue().getAsLayout();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Data_Value")) {
                    datvalues = ddertr.getValue().getAsArray();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Filter_Views")) {
                    Array ar = ddertr.getValue().getAsArray();
                    filte = new String[ar.size()];
                    int coun = 0;
                    Iterator<Value> uuu = ar.iterator();
                    while (uuu.hasNext()) {
                        Value val = uuu.next();
                        filte[coun] = val.getAsObject().getAsString("Key_Name");


                        coun = coun + 1;
                    }

                }  if(ddertr.getKey().equals("MultipleViews")) {

                    Array arm = ddertr.getValue().getAsArray();//.getAsObject().getAsArray("MultipleViews");


                    Iterator<Value> uuuk = arm.iterator();
                    while (uuuk.hasNext()) {
                        Value val = uuuk.next();

                        String vnm = val.getAsObject().getAsString("v_Name");
                        String vnmm = val.getAsObject().getAsString("v_ColumnName");
                        String vnmmk = val.getAsObject().getAsString("v_EqualValue");
                        String vnmmkk = val.getAsObject().getAsString("v_id");


                        modeltypeview ww = new modeltypeview(vnm, vnmm, vnmmk, vnmmkk);
                        mlti.add(ww);
                        ;
                    }
                }



            }


            // Value r = dtd.getAsObject().get("Result");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, datvalues);
            //  Array re=r.getAsArray();-
            int   ccc=0;
            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson ggm = new Gson();
                ccc=ccc+1;
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                   // OOverItHidertemheaderOnly ioppp = new OOverItHidertemheaderOnly(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte);

                     OOverItHidertem ioppp = new OOverItHidertem(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte,hedronly);


                    mItemssk.add(ioppp);
                   // mItemssb.add(ioppp);
                }
            }
        }catch (Exception ex){

            Log.e("55588888888888",ex.getMessage());
        }

        return  mItemssk;

    }



    public List<ScrollableUseCaseItemCustome> getDataAllDataFromString(Value dataseteng,  ProteusLayoutInflater inflat){

        // Layout gg=infl.getViewManager().getContext().getLayout(this.layoutname);
        // String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        boolean useMultiplex = false;
        Gson gsonn = new Gson();
        Layout gg=null;
        Array datvalues=null;
        //   Map<String,List<AbstractFlexibleItem>> ddat=new HashMap<>();
        List<modeltypeview> mlti = new ArrayList<>();
        List<ScrollableUseCaseItemCustome> mItemssk = new ArrayList<ScrollableUseCaseItemCustome>();
        //  List<AbstractFlexibleItem> mItemssb = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = dataseteng.getAsObject().entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if(ddertr.getKey().equals("a_enable")) {
                    String hyy = ddertr.getValue().getAsString();//.getAsObject().getAsString("a_enable");

                    if (hyy.equals("1")) {
                        useMultiplex = true;
                    }
                }
                if(ddertr.getKey().equals("Def_Views")) {
                    gg = ddertr.getValue().getAsLayout();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Data_Value")) {
                    datvalues = ddertr.getValue().getAsArray();//.getAsString();//.getAsObject().getAsString("a_enable");


                }
                if(ddertr.getKey().equals("Filter_Views")) {
                    Array ar = ddertr.getValue().getAsArray();
                    filte = new String[ar.size()];
                    int coun = 0;
                    Iterator<Value> uuu = ar.iterator();
                    while (uuu.hasNext()) {
                        Value val = uuu.next();
                        filte[coun] = val.getAsObject().getAsString("Key_Name");


                        coun = coun + 1;
                    }

                }  if(ddertr.getKey().equals("MultipleViews")) {

                    Array arm = ddertr.getValue().getAsArray();//.getAsObject().getAsArray("MultipleViews");


                    Iterator<Value> uuuk = arm.iterator();
                    while (uuuk.hasNext()) {
                        Value val = uuuk.next();

                        String vnm = val.getAsObject().getAsString("v_Name");
                        String vnmm = val.getAsObject().getAsString("v_ColumnName");
                        String vnmmk = val.getAsObject().getAsString("v_EqualValue");
                        String vnmmkk = val.getAsObject().getAsString("v_id");


                        modeltypeview ww = new modeltypeview(vnm, vnmm, vnmmk, vnmmkk);
                        mlti.add(ww);
                        ;
                    }
                }



            }


            // Value r = dtd.getAsObject().get("Result");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, datvalues);
            //  Array re=r.getAsArray();-
            int   ccc=0;
            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson ggm = new Gson();
                ccc=ccc+1;
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                    // OOverItHidertemheaderOnly ioppp = new OOverItHidertemheaderOnly(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte);

                    ScrollableUseCaseItemCustome ioppp = new ScrollableUseCaseItemCustome(mlti, useMultiplex, cx + 1, "no",gg, inflat, ddert.getValue().getAsArray().get(cx),filte);


                    mItemssk.add(ioppp);
                    // mItemssb.add(ioppp);
                }
            }
        }catch (Exception ex){

            Log.e("555",ex.getMessage());
        }

        return  mItemssk;

    }



    public void mergeItem(OOverItHidertem mainItem, OOverItHidertem itemToMerge,List<OOverItHidertem> mItems) {
        mainItem.mergeItem(itemToMerge);
       // itemToMerge.setStatus(mainItem.getStatus());
        //Add more items already merged in itemsToMerge
        if (itemToMerge.getMergedItems() != null) {
            for (OOverItHidertem subItem : itemToMerge.getMergedItems()) {
                mainItem.mergeItem(subItem);
               // subItem.setStatus(mainItem.getStatus());
                mItems.remove(subItem);
            }
            itemToMerge.setMergedItems(null);
        }
        mItems.remove(itemToMerge);
    }
    public  StaggeredItem newStaggeredItem(int i, StaggeredHeaderItem header,String f) {
        return new StaggeredItem(i, f,header);
    }

   // public StaggeredHeaderItem getHeaderByStatus(StaggeredItemStatus a) {
       // return headers.get(a);
   // }
}
