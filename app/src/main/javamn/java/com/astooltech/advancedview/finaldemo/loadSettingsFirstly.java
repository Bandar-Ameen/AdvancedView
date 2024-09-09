package com.astooltech.advancedview.finaldemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.icu.text.Edits;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Menu;
import android.view.SubMenu;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.anotherView.example.utils.Utils;
import com.astooltech.advancedview.proteus.demo.api.URLdatamodel;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.custom.GetDrawbileFromString;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.value.VolleyConnect;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static com.astooltech.advancedview.finaldemo.conectionbase.SettingUrl;
import static com.astooltech.advancedview.finaldemo.conectionbase.dat;
import static com.astooltech.advancedview.finaldemo.conectionbase.loginnurl;

public class loadSettingsFirstly {
    Context c;
    String uurl;
    Gson gsonn;
    private Sucessconn sucess;
    Map<String, String> Header=new HashMap<>();
    HashMap<String,String> Headerx=new HashMap<>();
    com.astooltech.advancedview.database.DatabaseHelper help;
    private Value getvall(String val){
        try {
            Type type = new TypeToken<Value>() {

            }.getType();
            Value tempp = gsonn.fromJson(val, type);

            return tempp;
        }catch (Exception ex){
            Log.e("qqaa",ex.getMessage());
            return  new Primitive("bbbbb");
        }
    }
    private   boolean checkjsosn(String json){
        boolean ss=false;
        try{
            new JSONObject(json);
            ss=true;
        }catch (JSONException ex){

            try{
                new JSONArray(json);
            }catch (JSONException ex1){
                return  false;

            }
        }
        return ss;
    }
    public loadSettingsFirstly(Context c,String  uurl){
this.c=c;
this.uurl=uurl;
        ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(this.c);
        gsonn  = new GsonBuilder()
                .registerTypeAdapterFactory(adapterk)
                .create();
        help=new DatabaseHelper(this.c);


    }


    public void addMenu(Menu men,String data){

try {
    men.clear();


    Value v = getvall(data);

    ObjectValue baseurl = v.getAsObject().get("menu").getAsObject();

    Iterator<Map.Entry<String, Value>> f = baseurl.entrySet().iterator();
    while (f.hasNext()) {
        Map.Entry<String, Value> frd = f.next();
        int ac = 0;
        if (frd.getValue().isArray()) {
            Iterator<Value> fv = frd.getValue().getAsArray().iterator();
            while (fv.hasNext()) {
                Value vc = fv.next();

                String menutyp = vc.getAsObject().get("Menu_Type").getAsString();
                String mnuactin = vc.getAsObject().get("Menu_Title").getAsString();
                int mnuactind = vc.getAsObject().get("Menu_ID").getAsInt();
                // String mnuacteven=vc.getAsObject().get("Menu_Event").getAsString();
                if (menutyp.toLowerCase().equals("submenu")) {

                    SubMenu k = men.addSubMenu(mnuactin);

                    Array ar = vc.getAsObject().get("Menu_Child").getAsArray();

                    Iterator<Value> fvv = ar.iterator();
                    while (fvv.hasNext()) {
                        Value vcc = fvv.next();
                        String mnutitle = vcc.getAsObject().get("Menu_Title").getAsString();
                        //  String mnuactevens=vc.getAsObject().get("Menu_Event").getAsString();
                        int mnuactindv = vcc.getAsObject().get("Menu_ID").getAsInt();
                        Drawable h = null;
                        try {
                            h = GetDrawbileFromString.getDrawble(vcc.getAsObject().get("Menu_Icon"), c);
                        } catch (Exception ex) {

                        }
                        if (h == null) {
                            k.add(0, mnuactindv, 0, Utils.fromHtmlCompat(mnutitle)).setIcon(R.drawable.ic_chat);
                        } else {
                            k.add(0, mnuactindv, 0, Utils.fromHtmlCompat(mnutitle)).setIcon(h);
                        }
                        ac = ac + 1;
                    }

                    k.setGroupCheckable(0, true, true);

                } else if (menutyp.toLowerCase().equals("item")) {
                    Drawable h = null;
                    try {
                        h = GetDrawbileFromString.getDrawble(vc.getAsObject().get("Menu_Icon"), c);
                    } catch (Exception ex) {

                    }
                    if (h == null) {
                        men.add(0, mnuactind, 0, Utils.fromHtmlCompat(mnuactin)).setIcon(R.drawable.ic_chat);
                    } else {
                        men.add(0, mnuactind, 0, Utils.fromHtmlCompat(mnuactin)).setIcon(h);
                    }
                    men.setGroupCheckable(0, true, true);
                    ac = ac + 1;
                } else if (menutyp.toLowerCase().equals("item_main")) {
                    Drawable h = null;
                    try {
                        h = GetDrawbileFromString.getDrawble(vc.getAsObject().get("Menu_Icon"), c);
                    } catch (Exception ex) {

                    }
                    if (h == null) {
                        men.add(0, R.id.nav_overall, 0, Utils.fromHtmlCompat(mnuactin)).setIcon(R.drawable.ic_chat);
                    } else {
                        men.add(0, R.id.nav_overall, 0, Utils.fromHtmlCompat(mnuactin)).setIcon(h);
                    }

                    //men.setQwertyMode(true);
                    men.setGroupCheckable(0, true, true);
                    ac = ac + 1;
                }


            }
        }

    }
    try {
        men.getItem(R.id.nav_overall).setChecked(true).setCheckable(true);
    } catch (Exception ex) {

    }
}catch (Exception ex){

}
        }


private void downloaddata(final Sucessconn sucessv, final int x){
        VolleyConnect dder=new VolleyConnect(this.c);
        dder.conn("get", Header, Headerx, this.uurl, "", null, new VolleyConnect.ResultResponse() {
            @Override
            public void OnSucess(String s) {
          try {
              JSONObject y= new JSONObject(s);
             String c= y.get("data").toString();//.getAsString("data");

              Value v = getvall(c);
          // Log.e("uuu",c);
              if (!v.isPrimitive()) {
                  String companyname = v.getAsObject().get(conectionbase.Companyname).getAsString();
                  String vertion = v.getAsObject().get(conectionbase.Verstion).getAsString();
                  ObjectValue baseurl = v.getAsObject().get(conectionbase.baseurl).getAsObject();
                  Iterator<Map.Entry<String, Value>> f = baseurl.entrySet().iterator();
                  while (f.hasNext()) {
                      Map.Entry<String, Value> frd = f.next();
                      if (frd.getKey().equals(conectionbase.urlonly)) {

                          ScriptModel gk1 = new ScriptModel(0, frd.getValue().getAsString(), conectionbase.urlonly);
                          help.insert(gk1);
                          // com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref(conectionbase.urlonly,frd.getValue().getAsString(),c);
                      } else {
                          List<URLdatamodel> ffd = new ArrayList<>();
                          if (frd.getValue().isArray()) {
                              if (frd.getKey().equals(SettingUrl)) {
                                  Iterator<Value> fv = frd.getValue().getAsArray().iterator();
                                  while (fv.hasNext()) {
                                      Value vc = fv.next();
                                      URLdatamodel ffdx = new URLdatamodel();
                                      String url = vc.getAsObject().getAsString(conectionbase.urlonly);
                                      String ver = vc.getAsObject().getAsString(conectionbase.Verstion);
                                      String Baselogin = vc.getAsObject().getAsString(conectionbase.Urltyp);

                                      ffdx.setBaseurl(url);
                                      ffdx.setMethodurl(Baselogin);
                                      ffdx.setMethode(ver);
                                      ffd.add(ffdx);

                                  }
                                  Gson g = new Gson();
                                  String resu = g.toJson(ffd);
                                  ScriptModel gk1 = new ScriptModel(0, resu, dat);
                                  help.insert(gk1);

                              }
                              // URLdatamodel ffd=new URLdatamodel();
                          }

                      }


                  }
                  //   String baseurlg=     v.getAsObject().get(conectionbase.baseurl).getAsString();
              }
              if(sucessv!=null) {
                  downloadfilee(sucessv,false);
              }
          }catch (Exception ex){

              if(sucessv!=null){
                  if(x==1) {
                      if (sucessv != null) {
                          sucessv.isError(ex.getMessage());
                      }
                  }else {
                      sucessv.isSucess();
                  }
              }
          }
            }


            @Override
            public void OnError(String s) {
               if(x==1) {
                   if (sucessv != null) {
                       sucessv.isError(s);
                   }
               }else {
                  // Log.e("uuu",c);
                 //  sucessv.isSucess();
               }
            }
        });
    }
   public boolean checkWifi() {
        ConnectivityManager connectivity = (ConnectivityManager) this.c.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        return info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI;
    }

  public   boolean checkNetwork() {
        ConnectivityManager connectivity = (ConnectivityManager) this.c.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        }
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
    public boolean isexitsornot(){

        ScriptModel gk1 = new ScriptModel(0, "00", conectionbase.urlonly);
        GlobalClass.BseUrl= help.getAllNotes(gk1).get(0).getContent();
        GlobalClass.BseUrl2= help.getAllNotes(gk1).get(0).getContent();
        ScriptModel g=new ScriptModel(0,"00", dat);
        List<ScriptModel>  h= help.getAllNotes(g);


        String ddata=    h.get(0).getContent();

        try {
            Gson ff = new Gson();
            Type type = new TypeToken<List<URLdatamodel>>() {

            }.getType();
            List<URLdatamodel> kmn = ff.fromJson(ddata, type);
            Iterator<URLdatamodel> f = kmn.iterator();
            while (f.hasNext()) {
                URLdatamodel frd = f.next();
            if(frd.getMethodurl().equals(conectionbase.loginn)){
                loginnurl=getfulUrl( frd.getBaseurl());
            }
                if(frd.getMethodurl().equals(conectionbase.layout)){
                    conectionbase.Alayout=getfulUrl( frd.getBaseurl());
                }
                if(frd.getMethodurl().equals(conectionbase.layouts)){
                    conectionbase.Alayouts=getfulUrl( frd.getBaseurl());
                }
                if(frd.getMethodurl().equals(conectionbase.Styles)){
                    conectionbase.AStyles=getfulUrl( frd.getBaseurl());
                }
            }
        }catch (Exception ex){

        }

        if(!ddata.equals("")) {
            return  true;
        } else {
            return false;
        }
    }

public String getfulUrl(String ur){
String reu=ur;
    if(reu.startsWith("/")){
        String urll=GlobalClass.BseUrl2;
        int len=urll.length();
        String res=urll;
        if(urll.endsWith("/")){
            res=urll.substring(0,len-1);
        }
        reu=res+reu;
    }
    return reu;
}
    public void downloadfilee(Sucessconn chek,boolean update){

   boolean  check=   checkNetwork();
        if(update){
    if(check) {
        downloaddata(chek, 0);
    }else {
        update=false;
    }
}
        ScriptModel g=new ScriptModel(0,"00", dat);
        List<ScriptModel>  h= help.getAllNotes(g);
        String ddata=    h.get(0).getContent();
if(!ddata.equals("")) {
   try {

       Gson ff = new Gson();
       Type type = new TypeToken<List<URLdatamodel>>() {

       }.getType();
       List<URLdatamodel> kmn = ff.fromJson(ddata, type);

       Iterator<URLdatamodel> f = kmn.iterator();
       while (f.hasNext()) {
           URLdatamodel frd = f.next();
           final URLdatamodel vvv = frd;
           VolleyConnect dder = new VolleyConnect(this.c);
String urlk=getfulUrl(frd.getBaseurl());

           dder.conn("get", Header, Headerx, urlk, "", null, new VolleyConnect.ResultResponse() {
               @Override
               public void OnSucess(String s) {
                //   Log.e("uuubbb",s);
                   try {
                       JSONObject y= new JSONObject(s);
                       String c= y.get("data").toString();//.getAsString("data");
                      Log.e("uuu",vvv.getBaseurl()+c);
                       //Value v = getvall(c);
                       ScriptModel gk1 = new ScriptModel(0, c, getfulUrl(vvv.getBaseurl()));
                       help.insert(gk1);
                   }catch (Exception ex){
                       Log.e("uuubbfffb",ex.getMessage());
                   }
               }

               @Override
               public void OnError(String s) {

               }
           });
       }
       if(!update) {
           chek.isSucess();
       }
   }catch (Exception ex){
       downloaddata(chek,0);
   }
}else {
   // chek.isError("Not");
    downloaddata(chek,1);
  //  chek.isError("not found");
}
    }
    public interface Sucessconn{
        void isSucess();
        void isError(String e);


    }
}
