package com.astooltech.advancedview.proteus.parser.adapterskit;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.custom.protouseFastScroller;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusProgressBar;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class getAllvalue implements IValuesData, ProteusView.Manager.ActionEventViewForUto  {

    private Context c;
    private ProteusView infl;
    private Value iio;
    private String valy;
    private  Layout lay;
    private  String apiData;
    private  String apiheader;
    private  String apibody;
    private  String apiurl;
    private  String fastsecrol;
    private  String apimethod;
    private  String apimequary="";
    private  String keyfromresponse;

    public TextInputLayoutB getSearchtext() {
        return searchtext;
    }

    public void setSearchtext(TextInputLayoutB searchtext) {
        this.searchtext = searchtext;
    }

    private TextInputLayoutB searchtext;
    public ProteusProgressBar getProgras() {
        return progras;
    }

    public void setProgras(ProteusProgressBar progras) {
        this.progras = progras;
    }

    private ProteusProgressBar progras;
    public protouseFastScroller getFastscroll() {
        return fastscroll;
    }

    public void setFastscroll(protouseFastScroller fastscroll) {
        this.fastscroll = fastscroll;
    }

    private protouseFastScroller fastscroll;
    public AdapterRefresh getEventAdapter() {
        return eventAdapter;
    }

    public void setEventAdapter(AdapterRefresh eventAdapter) {
        this.eventAdapter = eventAdapter;
    }

    private  AdapterRefresh eventAdapter;
    private ProteusView.Manager.ActionEventViewForUto even;
public  getAllvalue(ProteusView infll,String value){

    this.infl=infll;
    this.valy=value;
    this.c=infl.getAsView().getContext();
this.infl.getViewManager().setActionEventViewAuto(this);
    even=this;


}


public  Value GetVAluee(){


    return  iio;
}


public void loadalltegret(int numberreload,int counrtnumber){
    loadd();
    Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

Value getval=this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.toJson(ttrt);*/
  try {
      Value countt=new Primitive(numberreload);
      Value tot=new Primitive(counrtnumber);

     this.infl.getViewManager().getContext().getAllEven("Data_From").callToRecycleview(infl.getAsView().getContext(),

              infl.getViewManager().getContext().getActvityAllt(), getval, 0, infl, this, this,countt,tot);


      // this.infl.getViewManager().getContext().getCallback().onEventAdapter(15550, datv, String.valueOf(numberreload),null , infl);

      // this.infl.getViewManager().getContext().getCallback().onEventAdapter(3550, true, String.valueOf(0), String.valueOf(numberreload),null, null,null);
  }catch (Exception ex){

  }
  }

public List<AbstractFlexibleItem> getDataAll( Layout dalay){
    this.lay=dalay;


    String namkey="no";
    String namkeydata="no";
    Value usemultiple=null;
    String filte[] = null;
    Gson gsonn = new Gson();
    List<modeltypeview> mlti = new ArrayList<>();
    List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
    try {
        Iterator<Map.Entry<String, Value>> rre = dalay.extras.entrySet().iterator();
        while (rre.hasNext()) {
            Map.Entry<String, Value> ddertr = rre.next();

            if (ddertr.getKey().equals(Attributes.View.IDdata)) {
                apiData = ddertr.getValue().getAsString();


            }
            if (ddertr.getKey().equals(Attributes.View.APIRequestbody)) {
                apibody = ddertr.getValue().getAsString();
            }

            if (ddertr.getKey().equals(Attributes.View.APIMethod)) {
                apimethod = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals(Attributes.View.ApiHedaer)) {
                apiheader = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals(Attributes.View.APIURL)) {
                apiurl = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals(Attributes.View.key_from_response)) {
                keyfromresponse = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals(Attributes.View.ApiQuary)) {
                apimequary = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals("KeyName")) {
                namkey = ddertr.getValue().getAsString();
            }
            if (ddertr.getKey().equals("ScrollFast")) {
                protouseFastScroller ee=(protouseFastScroller)infl.getViewManager().getContext().getInflater().inflate(ddertr.getValue().getAsLayout(),new ObjectValue());

            setFastscroll(ee);
            }
            if (ddertr.getKey().equals("Progress")) {
               ProteusProgressBar ee=(ProteusProgressBar)infl.getViewManager().getContext().getInflater().inflate(ddertr.getValue().getAsLayout(),new ObjectValue());

                setProgras(ee);
            }
            if (ddertr.getKey().equals("Search")) {
                TextInputLayoutB ee=(TextInputLayoutB)infl.getViewManager().getContext().getInflater().inflate(ddertr.getValue().getAsLayout(),new ObjectValue());

              setSearchtext(ee);
            }

            if (ddertr.getKey().equals("FilterName")) {
                filte = ddertr.getValue().getAsString().split("#");
            }
            if (ddertr.getKey().equals("UseMultiple")) {
                usemultiple = ddertr.getValue();
            }
           // Log.i("777",gsonn.toJson(ddertr));
           /*
            if (ddert.keyname.equals("UseMultiple")) {
                usemultiple = ddert.value;
            }
            if (ddert.keyname.equals("data")) {
                Iterator<Map.Entry<String, Value>> rre = ddert.value.getAsObject().entrySet().iterator();
                int de = 0;
                while (rre.hasNext()) {
                    Map.Entry<String, Value> ddertr = rre.next();
                    de = de + 1;
                    if (de == 1) {
                        namkeydata = ddertr.getKey();
                    }
                }
            }*/
        }
//getAsObject().getAsString("KeyName");
        this.iio = createList(namkey);
        boolean useMultiplex = false;
        String valuu = "[]";

        //  String namkey="no";
        try {


            //  useOfline = anima.getAsBoolean("a_use_offline");
            //ObjectValue  = dalay.getAsObject().getAsObject("UseMultiple");


            useMultiplex = usemultiple.getAsObject().getAsBoolean("a_enable");
            valuu = usemultiple.getAsObject().getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

            //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

            ;

            //  Log.i("9988xx",gsonn.toJson(jkm));
            Type typez = new TypeToken<List<modeltypeview>>() {

            }.getType();
            mlti = gsonn.fromJson(valuu, typez);

        } catch (Exception ex) {
            //  Log.i("9988",ex.getMessage());
        }


        Value r = iio.getAsObject().get("s1");
        ObjectValue zz = new ObjectValue();
        zz.add(namkeydata, r);
        //  Array re=r.getAsArray();


        int ccc=0;
        Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
        while (vv.hasNext()) {
            Map.Entry<String, Value> ddert = vv.next();
            // counnnt = ddert.getValue().getAsArray().size();
            Gson gg = new Gson();
            ccc=ccc+1;

          /*  if (ccc==1){

                Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue().getAsArray().get(0)));
            }*/
            //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
            // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
            for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                OOverIttem ioppp = new OOverIttem(mlti, useMultiplex, cx + 1, "no", dalay, this.infl.getViewManager().getContext().getInflater(), ddert.getValue().getAsArray().get(cx),filte);
                mItemss.add(ioppp);

            }
        }
    }catch (Exception ex){

        Log.e("555",ex.getMessage());
    }

    return  mItemss;

}



private void loadd(){
    String namkey="no";
    String namkeydata="no";
    Value usemultiple=null;
    String filte[] = null;
    Gson gsonn = new Gson();
    List<modeltypeview> mlti = new ArrayList<>();
    List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
    try {
        Iterator<Layout.Attribute> rre = lay.attributes.iterator();
        while (rre.hasNext()) {
            Layout.Attribute ddertr = rre.next();
           // Log.i("uuuu",gsonn.toJson(lay.extras));
            if (ddertr.keyname.equals(Attributes.View.IDdata)) {
                apiData = ddertr.value.getAsString();


            }
            if (ddertr.keyname.equals(Attributes.View.APIRequestbody)) {
                apibody =ddertr.value.getAsString();
            }

            if (ddertr.keyname.equals(Attributes.View.APIMethod)) {
                apimethod = ddertr.value.getAsString();
            }
            if (ddertr.keyname.equals(Attributes.View.ApiHedaer)) {
                apiheader =ddertr.value.getAsString();
            }
            if (ddertr.keyname.equals(Attributes.View.APIURL)) {
                apiurl =ddertr.value.getAsString();
            }
            if (ddertr.keyname.equals(Attributes.View.key_from_response)) {
                keyfromresponse = ddertr.value.getAsString();
            }
            if (ddertr.keyname.equals(Attributes.View.ApiQuary)) {
                apimequary = ddertr.value.getAsString();
            }
          /*  if (ddertr.keyname.equals("KeyName")) {
                namkey = ddertr.getValue().getAsString();
            }
            if (ddertr.keyname.equals("FilterName")) {
                filte = ddertr.getValue().getAsString().split("#");
            }
            if (ddertr.keyname.equals("UseMultiple")) {
                usemultiple = ddertr.getValue();
            }*/
            // Log.i("777",gsonn.toJson(ddertr));
           /*
            if (ddert.keyname.equals("UseMultiple")) {
                usemultiple = ddert.value;
            }
            if (ddert.keyname.equals("data")) {
                Iterator<Map.Entry<String, Value>> rre = ddert.value.getAsObject().entrySet().iterator();
                int de = 0;
                while (rre.hasNext()) {
                    Map.Entry<String, Value> ddertr = rre.next();
                    de = de + 1;
                    if (de == 1) {
                        namkeydata = ddertr.getKey();
                    }
                }
            }*/
        }
    }catch (Exception ex){

    }


}
    public List<AbstractFlexibleItem> getDataAll(){

        String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        Gson gsonn = new Gson();
        List<modeltypeview> mlti = new ArrayList<>();
        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = lay.extras.entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if (ddertr.getKey().equals("KeyName")) {
                    namkey = ddertr.getValue().getAsString();
                }
                if (ddertr.getKey().equals("FilterName")) {
                    filte = ddertr.getValue().getAsString().split("#");
                }
                if (ddertr.getKey().equals("UseMultiple")) {
                    usemultiple = ddertr.getValue();
                }
                // Log.i("777",gsonn.toJson(ddertr));
           /*
            if (ddert.keyname.equals("UseMultiple")) {
                usemultiple = ddert.value;
            }
            if (ddert.keyname.equals("data")) {
                Iterator<Map.Entry<String, Value>> rre = ddert.value.getAsObject().entrySet().iterator();
                int de = 0;
                while (rre.hasNext()) {
                    Map.Entry<String, Value> ddertr = rre.next();
                    de = de + 1;
                    if (de == 1) {
                        namkeydata = ddertr.getKey();
                    }
                }
            }*/
            }
//getAsObject().getAsString("KeyName");
            this.iio = createList(namkey);
            boolean useMultiplex = false;
            String valuu = "[]";

            //  String namkey="no";
            try {


                //  useOfline = anima.getAsBoolean("a_use_offline");
                //ObjectValue  = dalay.getAsObject().getAsObject("UseMultiple");


                useMultiplex = usemultiple.getAsObject().getAsBoolean("a_enable");
                valuu = usemultiple.getAsObject().getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                ;

                //  Log.i("9988xx",gsonn.toJson(jkm));
                Type typez = new TypeToken<List<modeltypeview>>() {

                }.getType();
                mlti = gsonn.fromJson(valuu, typez);

            } catch (Exception ex) {
                //  Log.i("9988",ex.getMessage());
            }


            Value r = iio.getAsObject().get("s1");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, r);
            //  Array re=r.getAsArray();

            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson gg = new Gson();
                //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                    OOverIttem ioppp = new OOverIttem(mlti, useMultiplex, cx + 1, "no",lay, this.infl.getViewManager().getContext().getInflater(), ddert.getValue().getAsArray().get(cx),filte);
                    mItemss.add(ioppp);

                }
            }
        }catch (Exception ex){

            Log.e("555",ex.getMessage());
        }

        return  mItemss;

    }

    public List<AbstractFlexibleItem> getDataAllDataFromString(String dtd){

        String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;
        Gson gsonn = new Gson();
        List<modeltypeview> mlti = new ArrayList<>();
        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = lay.extras.entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if (ddertr.getKey().equals("KeyName")) {
                    namkey = ddertr.getValue().getAsString();
                }
                if (ddertr.getKey().equals("FilterName")) {
                    filte = ddertr.getValue().getAsString().split("#");
                }
                if (ddertr.getKey().equals("UseMultiple")) {
                    usemultiple = ddertr.getValue();
                }
                // Log.i("777",gsonn.toJson(ddertr));
           /*
            if (ddert.keyname.equals("UseMultiple")) {
                usemultiple = ddert.value;
            }
            if (ddert.keyname.equals("data")) {
                Iterator<Map.Entry<String, Value>> rre = ddert.value.getAsObject().entrySet().iterator();
                int de = 0;
                while (rre.hasNext()) {
                    Map.Entry<String, Value> ddertr = rre.next();
                    de = de + 1;
                    if (de == 1) {
                        namkeydata = ddertr.getKey();
                    }
                }
            }*/
            }
//getAsObject().getAsString("KeyName");
            this.iio = createListWithoutDatabase(dtd);
            boolean useMultiplex = false;
            String valuu = "[]";

            //  String namkey="no";
            try {


                //  useOfline = anima.getAsBoolean("a_use_offline");
                //ObjectValue  = dalay.getAsObject().getAsObject("UseMultiple");


                useMultiplex = usemultiple.getAsObject().getAsBoolean("a_enable");
                valuu = usemultiple.getAsObject().getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                ;

                //  Log.i("9988xx",gsonn.toJson(jkm));
                Type typez = new TypeToken<List<modeltypeview>>() {

                }.getType();
                mlti = gsonn.fromJson(valuu, typez);

            } catch (Exception ex) {
                //  Log.i("9988",ex.getMessage());
            }


            Value r = iio.getAsObject().get("s1");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, r);
            //  Array re=r.getAsArray();

            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson gg = new Gson();
                //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                    OOverIttem ioppp = new OOverIttem(mlti, useMultiplex, cx + 1, "no",lay, this.infl.getViewManager().getContext().getInflater(), ddert.getValue().getAsArray().get(cx),filte);
                    mItemss.add(ioppp);

                }
            }
        }catch (Exception ex){

            Log.e("555",ex.getMessage());
        }

        return  mItemss;

    }
    public List<AbstractFlexibleItem> getDataAllDataFromString(Value dtd){
        Gson gsonn = new Gson();
        Log.i("000", "$$$@@@mm0000" + gsonn.toJson(lay));
        String namkey="no";
        String namkeydata="no";
        Value usemultiple=null;
        String filte[] = null;

        List<modeltypeview> mlti = new ArrayList<>();
        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        try {
            Iterator<Map.Entry<String, Value>> rre = lay.extras.entrySet().iterator();
            while (rre.hasNext()) {
                Map.Entry<String, Value> ddertr = rre.next();
                if (ddertr.getKey().equals("KeyName")) {
                    namkey = ddertr.getValue().getAsString();
                }
                if (ddertr.getKey().equals("FilterName")) {
                    filte = ddertr.getValue().getAsString().split("#");
                }
                if (ddertr.getKey().equals("UseMultiple")) {
                    usemultiple = ddertr.getValue();
                }
                // Log.i("777",gsonn.toJson(ddertr));
           /*
            if (ddert.keyname.equals("UseMultiple")) {
                usemultiple = ddert.value;
            }
            if (ddert.keyname.equals("data")) {
                Iterator<Map.Entry<String, Value>> rre = ddert.value.getAsObject().entrySet().iterator();
                int de = 0;
                while (rre.hasNext()) {
                    Map.Entry<String, Value> ddertr = rre.next();
                    de = de + 1;
                    if (de == 1) {
                        namkeydata = ddertr.getKey();
                    }
                }
            }*/
            }
//getAsObject().getAsString("KeyName");
            this.iio = dtd;
            boolean useMultiplex = false;
            String valuu = "[]";

            //  String namkey="no";
            try {


                //  useOfline = anima.getAsBoolean("a_use_offline");
                //ObjectValue  = dalay.getAsObject().getAsObject("UseMultiple");


                useMultiplex = usemultiple.getAsObject().getAsBoolean("a_enable");
                valuu = usemultiple.getAsObject().getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                ;
//$$$@@@mm0000{"attributes":[{"id":65,"keyname":"paddingBottom","value":{"unit":1,"value":0.0}},{"id":24,"keyname":"Key_from_response","value":{"value":"0"}},{"id":16,"keyname":"d_key","value":{"value":"loveem"}},{"id":51,"keyname":"data_id","value":{"value":"[\r\n{#data_id#:#hell#,#data_set#:#1#,#data_get#:#1#}\r\n\r\n,{#data_id#:#bb#,#data_set#:#bb#,#data_get#:#bb#}\r\n,\r\n{#data_id#:#vv#,#data_set#:#vv#,#data_get#:#vv#}\r\n,\r\n{#data_id#:#grou#,#data_set#:#grou#,#data_get#:#mmyk#},\r\n{#data_id#:#Count_Element#,#data_set#:#Count_Element#,#data_get#:#Count_Element#},\r\n{#data_id#:#Total_Element#,#data_set#:#Total_Element#,#data_get#:#Total_Element#}\r\n\r\n]"}},{"id":34,"keyname":"api_body","value":{"value":"\r\n          {#databody#:[{#databodymmmmm#:[{#databodymmmmmxxxxxxxxxxx#:#2#,#currID#:#1#,#typ#:#2#,#month#:#0#,#typsender#:#1#,#buyorsalse#:#1#,                   #groupID#:#0#,#prodID#:#0#,#barcode#:#0#}],#currID#:#1#,#typ#:#4#,#month#:#0#,#typsender#:#1#,#buyorsalse#:#1#,                   #groupID#:#0#,#count_item#:#%5$s#,#total_item#:#%6$s#}]}"}},{"id":22,"keyname":"Api_Header","value":{"value":"[\r\n{#keyName#:#Authorization#,#KeyValue#:#nameu#,#KeyType#:#apikey#, #ViewName#:#nameu#}\r\n ,{#keyName#:#name#,#KeyValue#:#name#,#KeyType#:#apikey#, #ViewName#:#name#}\r\n\r\n]"}},{"id":11,"keyname":"api_method","value":{"value":"post"}},{"id":15,"keyname":"api_url","value":{"value":"https://astooltech.com/api/v1/test2.json"}}],"data":{"user":{"tokens":[{"isArray":false,"isArrayIndex":false,"isBinding":false,"value":"items"}]},"my":{"tokens":[{"isArray":true,"isArrayIndex":false,"isBinding":false,"value":"items"},{"isArray":false,"isArrayIndex":true,"isBinding":false,"value":"$index"}]}},"extras":{"members":{"layout":{"value":"DataDrivenExamplevmy"},"KeyName":{"value":"recycleserchhm"},"Progress":{"attributes":[{"id":6,"keyname":"layout_height","value":{"unit":1,"value":50.0}},{"id":58,"keyname":"layout_width","value":{"unit":1,"value":90.0}},{"id":52,"keyname":"data_primary","value":{"value":"saveprograsus"}},{"id":118,"keyname":"style_bar","value":{"members":{"color_bar":{"value":"#2cdb81"},"typ_bar":{"value":"1"}}}}],"extras":{"members":{"mm":{"value":{"value":"1.0"}},"gravity":{"value":"center"},"text":{"value":"ADD gh CART"}}},"type":"ProgressBar"},"Search":{"attributes":[{"id":58,"keyname":"layout_width","value":{"unit":-1,"value":-1.0}},{"id":6,"keyname":"layout_height","value":{"unit":-1,"value":-2.0}},{"id":62,"keyname":"paddingLeft","value":{"unit":1,"value":16.0}},{"id":118,"keyname":"starticon","value":{"fontfont":"@drawable/addbtn","isdroblefont":false,"resId":2131230813}},{"id":123,"keyname":"lboxcolor","value":{"fontfont":"@color/green","isdroblefont":false,"resId":2131099911}},{"id":122,"keyname":"lhint","value":{"value":"الuuuuuuuبريد الالكتروني "}},{"id":76,"keyname":"id","value":{"value":"email"}},{"id":52,"keyname":"data_primary","value":{"value":"email"}},{"id":47,"keyname":"d_NullValue","value":{"value":true}},{"id":46,"keyname":"d_OnErrorText","value":{"value":"يرجي ادخال البريد الالكتروني "}},{"id":119,"keyname":"endicon","value":{"url":"@drawable/addbbtn"}},{"id":64,"keyname":"paddingRight","value":{"unit":1,"value":16.0}},{"id":63,"keyname":"paddingTop","value":{"unit":1,"value":8.0}},{"id":125,"keyname":"children","value":{"values":[{"attributes":[{"id":50,"keyname":"tooltipText","value":{"value":"البريد الإلكتروني "}},{"id":140,"keyname":"text","value":{"tokens":[{"isArray":false,"isArrayIndex":false,"isBinding":false,"value":"AlertDialogLayout"},{"isArray":true,"isArrayIndex":false,"isBinding":false,"value":"my"},{"isArray":false,"isArrayIndex":true,"isBinding":false,"value":"0"},{"isArray":false,"isArrayIndex":false,"isBinding":false,"value":"email"}]}},{"id":64,"keyname":"paddingRight","value":{"unit":1,"value":15.0}},{"id":58,"keyname":"layout_width","value":{"unit":-1,"value":-1.0}},{"id":6,"keyname":"layout_height","value":{"unit":-1,"value":-1.0}},{"id":5,"keyname":"background","value":{"fon
                //  Log.i("9988xx",gsonn.toJson(jkm));
                Type typez = new TypeToken<List<modeltypeview>>() {

                }.getType();
                mlti = gsonn.fromJson(valuu, typez);

            } catch (Exception ex) {
                //  Log.i("9988",ex.getMessage());
            }


            Value r = iio.getAsObject().get("s1");
            ObjectValue zz = new ObjectValue();
            zz.add(namkeydata, r);
            //  Array re=r.getAsArray();-
            // 1102$$$@@@0000{"members":{"drugName_ar":{"value":"رفامول 120 مجم شراب"},"prodCompDrugId":{"value":"6"},"spare3":{"value":""},"scientificDrugId":{"value":"292"},"pack":{"value":"Syrup 60ml"},"spare2":{"value":"5"},"cashBonus":{"value":"30"},"spare1":{"value":"2020/8/14"},"unit":{"value":"باكت"},"price":{"value":"620"},"yupBonus":{"value":"10"},"drugName_en":{"value":"Rfamol 120ml Syrup"},"id":{"value":{"value":"1"}},"proxyDrugId":{"value":"1"}}}
int   ccc=0;
            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
            while (vv.hasNext()) {
                Map.Entry<String, Value> ddert = vv.next();
                // counnnt = ddert.getValue().getAsArray().size();
                Gson gg = new Gson();

               /* ccc=ccc+1;

                if (ccc==1){

                    Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue().getAsArray().get(0)));
                }*/
                //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {
                    OOverIttem ioppp = new OOverIttem(mlti, useMultiplex, cx + 1, "no",lay, this.infl.getViewManager().getContext().getInflater(), ddert.getValue().getAsArray().get(cx),filte);
                    mItemss.add(ioppp);

                }
            }
        }catch (Exception ex){

            Log.e("555",ex.getMessage());
        }

        return  mItemss;

    }
    private Value createList(String dat) {

        //Log.i("ffffdddd",dat);
        ScriptModel g = new ScriptModel(0, "no",dat);
        DatabaseHelper db_operations;
        db_operations = new DatabaseHelper(c);
        List<ScriptModel> x = db_operations.getAllNotes(g);
        String val = x.get(0).getContent();
        String k=val;//"{s1:"+val+"}";
      //  Log.i("ffffdddd",k);
        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(c);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type type = new TypeToken<Value>() {

        }.getType();
        Value tempp = gsonn.fromJson(k, type);


        return tempp;
    }

    private Value createListWithoutDatabase(String dat) {

        //Log.i("ffffdddd",dat);



        String k= dat.startsWith("{")?dat:"{s1:"+dat+"}";
        //  Log.i("ffffdddd",k);
        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(c);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type type = new TypeToken<Value>() {

        }.getType();
        Value tempp = gsonn.fromJson(k, type);


        return tempp;
    }

    @Override
    public void sendData(String datab, int typdata) {

    }

    @Override
    public void setDataAdvanced(Map<String,List<AbstractFlexibleItem>>  datresult, int typ) {

      /*  Map<String,List<AbstractFlexibleItem>> datau=new HashMap<>();
        datau.put("main",datresult);
        datau.put("mains",datresult);*/
        getEventAdapter().OnGetData(datresult);
    }

    @Override
    public void sendEventA(@Nullable ObjectValue data, int typ, Object anotherdata) {

    }

    @Override
    public void sendEventA(@Nullable ObjectValue data, int typ, String anotherdata) {
        if(typ==67606){
           // Log.i("666","ddddddvvvvvvvvvxxxx"+anotherdata);
            List<AbstractFlexibleItem> tt=  getDataAllDataFromString(data);
            List<AbstractFlexibleItem> tty=  getDataAllDataFromString(data);
            Map<String,List<AbstractFlexibleItem>> datau=new HashMap<>();
            datau.put("main",tt);
            datau.put("mains",tty);
            getEventAdapter().OnGetData(datau);
        }
  else  if(typ==6766){
    List<AbstractFlexibleItem> tt=  getDataAllDataFromString(anotherdata);
            List<AbstractFlexibleItem> tty=  getDataAllDataFromString(anotherdata);
            Map<String,List<AbstractFlexibleItem>> datau=new HashMap<>();
            datau.put("main",tt);
            datau.put("mains",tty);
            getEventAdapter().OnGetData(datau);
}else if(typ==6767){


    }else if(typ==6768){
            List<AbstractFlexibleItem> tt=  getDataAllDataFromString(anotherdata);
            List<AbstractFlexibleItem> tty=  getDataAllDataFromString(anotherdata);
            Map<String,List<AbstractFlexibleItem>> datau=new HashMap<>();
            datau.put("main",tt);
            datau.put("mains",tty);
            getEventAdapter().OnGetData(datau);
    }
else{
    String[] mnb = null;
    Gson hvn = new Gson();
    Type typex = new TypeToken<String[]>() {

    }.getType();
    mnb = hvn.fromJson(anotherdata, typex);
    new AsyncTaskRunnerv(false, mnb, false).execute(mnb[0], mnb[1], mnb[2], mnb[3], mnb[4], mnb[5], mnb[6], mnb[7], mnb[8], mnb[9], mnb[10], mnb[11], mnb[12]);
}
    }

    @Override
    public void getresultsearchA(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

    }

    @Override
    public void getFragmentA(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

    }


    class AsyncTaskRunnerv extends AsyncTask<String, String, String> {

        private String resp;
        boolean tt=false;

        // ProgressDialog progressDialog;
        String bbaa="0";
        String bbaat="0";

        public   String prograssnn;

        public  boolean checkk;
        public  String[] anoth;
        public boolean useoffline;
        AsyncTaskRunnerv(boolean checkkm,String[] anothh,boolean useofflinee) {



            this.checkk=checkkm;
            this.anoth=anothh;
            this.useoffline=useofflinee;

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

                Map<String,Object> hedermap=new HashMap<>();//Map<String, Object>();
                HashMap<String,String> quarymap=new HashMap<>();//HashMap<String, String>();
                try {
                    String heder=params[8];
                    String quary=params[9];
                    //  Log.i("4444444",heder);
                    Gson hnb = new Gson();
                    Type type = new TypeToken<List<hedaerOrQuary>>() {

                    }.getType();
                    List<hedaerOrQuary> hedde = hnb.fromJson(heder, type);
                    for (int cx = 0; cx < hedde.size(); cx++) {
                        hedermap.put(hedde.get(cx).getKeyName(),hedde.get(cx).getKeyValue());
                        //  Log.i("44444446555",hedde.get(cx).getKeyName());
                    }
                    List<hedaerOrQuary> qur = hnb.fromJson(quary, type);
                    for (int cx = 0; cx < qur.size(); cx++) {
                        quarymap.put(qur.get(cx).getKeyName(),qur.get(cx).getKeyValue());

                    }

                    //  dd.put()
                }catch (Exception ex){
//Log.i("4444444vvv",ex.getMessage());
                    Log.i("0000xx",params[12]);
                }

                String contettyp="application/json; charset=UTF-8";
                String userAgentt="fromandroid";
                final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(params[12]).create(retrofit_dynimcic.class);
                RequestBody requestBodyBinary = null;

                requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                // sendreq(params[0],params[1],params[2]);
                Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary,hedermap,quarymap):Retrofitapi.GetMethod(URL,hedermap,quarymap);
                Log.i("0000xx",params[12]);
                call.enqueue(new Callback<ResponseBody>() {


                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {
                            assert response.body() != null;

                            //   showResult(response.body().string(),protvv.getAsView());
                            String x="mydesin";
                           // Log.i("0000xx",response.body().string());
                            if(response.isSuccessful()) {

                                String kk= response.body().string();
                                // assert response.errorBody() != null;
                                try {
                                    String responseKey = params[11];

                                    if(!responseKey.equals("0")) {
                                        JSONObject js = new JSONObject(kk);
                                        kk = js.get(responseKey).toString();
                                    }
                                }catch (Exception ex){

                                }
                                String k="{s1:"+kk+"}";
                                if(refresh.equals("1")) {
                                    try {

                                        if(useoffline) {
                                            String mng = "kw";//((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                            ScriptModel g = new ScriptModel(0, k, mng);
                                            DatabaseHelper db_operations;
                                            db_operations = new DatabaseHelper(c);
                                            db_operations.insert(g);
                                        }
                                    }catch (Exception ex){

                                    }


                                    //  loadrefd();
                                    // aooldder(without,container, tempp.getAsObject());
                                }else {
                                    //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));

                                    // loadrefd();

                                    // masss.showmessage(k);

                                }

                                even.sendEventA(null,6766,k);
                                String   prograssnam="0";
                                try {
                                    prograssnam =anoth[0];//enabprograss
                                }catch (Exception ex){

                                }


                            }else{
                                try {
                                    assert response.errorBody() != null;


                                    String kk= response.errorBody().string();


                                    //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                    // savetoref(x, response.errorBody().string());
                                    //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                }catch (IOException ex){

                                    //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                                    even.sendEventA(null,6767,null);
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                                   // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                }
                            }


                        } catch (Exception ex) {
                            even.sendEventA(null,6767,null);
                            //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((ProteusRecyclerView) protvv));
                           // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                            // loadrefd();
                            // masss.showmessage(ex.getMessage());
                            // stoptimertask();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        //  stoptimertask();

                        // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                        if(t.getMessage().startsWith("Unable to resolve host")){
                            try {

                                if(useoffline) {
                                   // String mng = ((ProteusRecyclerView) protvv).getTag(R.id.tag3).toString();
                                   // FlexibleAdapter uk=(FlexibleAdapter) ((ProteusRecyclerView) protvv).getAdapter();
                                    //if(uk.getItemCount()==0) {

                                        ScriptModel g = new ScriptModel(0, "no", "keyn");
                                        DatabaseHelper db_operations;
                                        db_operations = new DatabaseHelper(c);
                                        List<ScriptModel> x = db_operations.getAllNotes(g);
                                        String val = x.get(0).getContent();
                                    even.sendEventA(null,6768,val);
                                      /*  ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                        Gson gsonn = new GsonBuilder()
                                                .registerTypeAdapterFactory(adapter)
                                                .create();
                                        Type type = new TypeToken<Value>() {

                                        }.getType();
                                        Value tempp = gsonn.fromJson(val, type);*/
                                        //uuip.triggerAdapter(52, checkk, val, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv), uuip, anoth);
                                   // }else{

                                       // uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                                        //uuip.triggerAdapter(52, checkk, val, prograssnn, tempp.getAsObject(), ((ProteusRecyclerView) protvv), uuip, anoth);
                                    //}
                                }else {
                                   // uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                                }
                            }catch (Exception ex){

                            }

                        }else {
                          //  uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((ProteusRecyclerView) protvv));
                        }
                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                        // loadrefd();
                        // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                        //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                    }
                });


            } catch (Exception ex) {

                Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((ProteusRecyclerView) protvv));
                //  loadrefd();
                // masss.showmessage(ex.getMessage());
                // ex.getMessage();

            }
            return bbaa;
        }
        private void showResult(String result, View c) {
            new AlertDialog.Builder(c.getContext())
                    .setMessage(result)
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create()
                    .show();
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
}
