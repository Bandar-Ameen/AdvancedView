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

package com.astooltech.advancedview.proteus;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.design.widget.WatingBarView;
import com.astooltech.advancedview.proteus.parser.CustomStringRequest;
import com.astooltech.advancedview.proteus.parser.Utility;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadTask;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.RxActivityResult;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.astooltech.advancedview.proteus.view.protuseTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.demo.ImageLoaderTarget;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;

import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.demo.connectedActivityMdel;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.DrawableValue;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusImageView;
import com.astooltech.advancedview.spinkit.sprite.Sprite;
import com.astooltech.advancedview.spinkit.style.Wave;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ProteusContext
 *
 * @author aditya.sharat
 */

public class ProteusContext extends ContextWrapper implements ProteusLayoutInflater.Callback,ProteusLayoutInflater.ImageLoader {




    @NonNull
    private final ProteusResources resources;

    @Nullable
    private final ProteusLayoutInflater.Callback callback;

    @Nullable
    private final ProteusLayoutInflater.ImageLoader loader;

    private ProteusLayoutInflater inflater;
 //   private all_action_Activity setAllEvent;

    public AppCompatActivity getActvityAllt() {
        return ActvityAllt;
    }

    private AppCompatActivity ActvityAllt;
    public ViewGroup getContainerrb() {
        return containerrb;
    }

    public ProteusManager getProteusManagerrb() {
        return proteusManagerrb;
    }

    public String[] getDataURLl() {
        return dataURLl;
    }

    public getmessage_status getMassss() {
        return massss;
    }

    private   ViewGroup containerrb;
    private ProteusManager proteusManagerrb;
    private       String[] dataURLl;
    private getmessage_status massss;
    private FragmentManager frgmentMangers;

    public FragmentManager getFrgmentMangers() {
        return frgmentMangers;
    }

    public AbstractFragment getmFragmenttv() {
        return mFragmenttv;
    }

    public DrawerLayout getmDrawerr() {
        return mDrawerr;
    }

    private    AbstractFragment mFragmenttv;
    private  DrawerLayout mDrawerr;
    private Gson gn;

    public ObjectValue getData() {
        return Data;
    }

    public void setData(ObjectValue data) {
        Data = data;
    }

    public Layout getRootLayout() {
        return RootLayout;
    }

    public void setRootLayout(Layout rootLayout) {
        RootLayout = rootLayout;
    }

    private ObjectValue Data;
    private Layout RootLayout;

    @NonNull
    public Map<String, ViewTypeParser> getParsers() {
        return parsers;
    }

    public void setParsers(@NonNull Map<String, ViewTypeParser> parsers) {
        this.parsers = parsers;
    }

    public ALLEventManger getEventMangee() {
        return eventMangee;
    }

    public void setEventMangee(ALLEventManger eventMangee) {
        this.eventMangee = eventMangee;
    }

    private  ALLEventManger eventMangee;
    @Nullable
    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public void setFunctionManager(@NonNull FunctionManager functionManager) {
        this.functionManager = functionManager;
    }

    @Nullable
    public StyleManager getStyleManager() {
        return styleManager;
    }

    public void setStyleManager(@Nullable StyleManager styleManager) {
        this.styleManager = styleManager;
    }

    @NonNull
    private  Map<String, ViewTypeParser> parsers;

    @Nullable
    private  LayoutManager layoutManager;

    @NonNull
    private  FunctionManager functionManager;

    public StatuseLayout getStatusee() {
        return statusee;
    }

    public void setStatusee(StatuseLayout statusee) {
        this.statusee = statusee;
    }
private Layout ALayout;

    public Layout getALayout() {
        return ALayout;
    }

    public void setALayout(Layout ALayout) {
        this.ALayout = ALayout;
    }

    public ObjectValue getAData() {
        return AData;
    }

    public void setAData(ObjectValue AData) {
        this.AData = AData;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    private ObjectValue AData;
 private boolean check;
    private StatuseLayout statusee;
    @Nullable
    private  StyleManager styleManager;
    ProteusContext(Context base
                  ,
                   @Nullable ProteusLayoutInflater.Callback callback,ViewGroup con,ProteusManager proteusManager,String[] dataURL,getmessage_status masss,FragmentManager fm, AbstractFragment mFragment,DrawerLayout drawer,AppCompatActivity ActvityAlltv, String  Stringdata,
                   String StringrootLayout,
                   String Stringlayouts,
                   String Stringstyles,Layout mroot,ObjectValue d,Gson cx, ProteusResources resources,StatuseLayout statuse,boolean check,Layout layot,ObjectValue datobj,ProteusLayoutInflater.ImageLoader im) {
        super(base);
        setStatusee(statuse);
        setCheck(check);
        setALayout(layot);
        setAData(datobj);
           this.callback = callback;
          if(im==null) {
              this.loader = this;
          }else{
              this.loader=im;
          }
           setJson(cx);
           if(!check) {
               setStringdata(Stringdata);
               setStringrootLayout(StringrootLayout);
               setStringlayouts(Stringlayouts);
               setStringstyles(Stringstyles);
           }
/*setParsers(parsers);
setFunctionManager(functionManager);*/
//setEventMangee(ev);

           this.resources = resources;
           this.containerrb = con;
           this.massss = masss;
           this.proteusManagerrb = proteusManager;
           this.dataURLl = dataURL;
           this.frgmentMangers = fm;
           this.mFragmenttv = mFragment;
           this.mDrawerr = drawer;
           this.ActvityAllt = ActvityAlltv;
      /*  ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(base);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();*/

           intin(base);

           setData(d);
           setRootLayout(mroot);
           insview();

        // this.setAllEvent= //new all_action_Activity(containerr,base,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr);

    }

    public void adjustResizeOnGlobalLayout() {
        // final View decorView = getWindow().getDecorView();
        // final ViewGroup viewGroup = (ViewGroup) findViewById(viewGroupId);
        getActvityAllt().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(null);
        getActvityAllt().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                Rect rect = new Rect();
                getActvityAllt().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int paddingBottom = displayMetrics.heightPixels - rect.bottom;

                if (getContainerrb().getPaddingBottom() != paddingBottom) {
                    // showing/hiding the soft keyboard
                    getContainerrb().setPadding(getContainerrb().getPaddingLeft(), getContainerrb().getPaddingTop(), getContainerrb().getPaddingRight(), paddingBottom);
                } else {
                    // soft keyboard shown/hidden and padding changed
                    if (paddingBottom != 0) {
                        // soft keyboard shown, scroll active element into view in case it is blocked by the soft keyboard
                        getParser("WebView").ReceveSearch("0","0");

                    }
                }
            }
        });
    }


    public void setJson(Gson f){

        this.gn=f;
    }
    public Gson getJson(){

        return this.gn;

    }
private Layout getlayoutroot(){
if(!isCheck()) {
    Type type = new TypeToken<Value>() {

    }.getType();

    if (getRootLayout() != null) {
        return getRootLayout();
    } else {

        if (getStringrootLayout().equals("0")) {
            return getRootLayout();

        } else {
            Value tempp = getJson().fromJson(getStringrootLayout(), type);

            return tempp.getAsLayout();
        }
    }
}else {

   return getALayout();
}
}
    public void Update(String root,String layout,String  ff,String ccx){
        this.containerrb.removeAllViews();
try {
    Map<String, Layout> r = getlayoutfromString(root);

}catch (Exception ex){

}
     //   this.proteusManagerrb.update("0",null,false,this.dataURLl);
    }
    private Map<String,Layout> getlayoutfromString(String dataa) throws JSONException {
        // Log.i("ee", "ERROR: " +"sdsdddddddddd");

        Type type = new TypeToken<Value>() {

        }.getType();
        ObjectValue tempp = getJson().fromJson(dataa, type);

        HashMap<String,Layout> iio=new HashMap<>();
        Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
        while (vv.hasNext()) {
            try {
                Map.Entry<String, Value> ddertt = vv.next();
                if(ddertt.getKey().toLowerCase().equals("root_layout")){
                    setRootLayout(ddertt.getValue().getAsLayout());
                }else if(ddertt.getKey().toLowerCase().equals("data_layout")){
                    setData(ddertt.getValue().getAsObject());
                }else {

                    iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
                }
                //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
            }catch (Exception ex){
                Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
            }
        }


        return iio;
    }

    public void intin(Context basee){

        ProteusLayoutInflater tt= getInflater();
      //  this.setAllEvent= new all_action_Activity(getContainerrb(),basee,getProteusManagerrb(),getDataURLl(),tt,getMassss(),getFrgmentMangers(), getmFragmenttv(),getmDrawerr());
        connectedActivityMdel.getinstance().setlisner(this);
        connectedActivityMdel.getinstance().setInflater(tt);
    }
    @Nullable
    public ProteusLayoutInflater.Callback getCallback() {
        return this;
    }

    @NonNull
    public FunctionManager getFunctionManager() {
        return resources.getFunctionManager();
    }

    @NonNull
    public Function getFunction(@NonNull String name) {
        return resources.getFunction(name);
    }
    @NonNull
    public ALLEvent getAllEven(@NonNull String name) {
        return resources.getALLEvent(name);
    }
    @Nullable
    public Layout getLayout(@NonNull String name) {
        return resources.getLayout(name);
    }
    @Nullable
    public void addlayout(ObjectValue valueadd) {


            resources.addlayout(valueadd);


    }
    public Map<String, Layout> GetLayouts(){

        return  resources.GetLayouts();
    }
    public Styles GetStyles(){

        return  resources.getStyles();
    }
    @Nullable
    public ProteusLayoutInflater.ImageLoader getLoader() {
        return loader;
    }

    @NonNull
    public ProteusLayoutInflater getInflater(@NonNull IdGenerator idGenerator) {
        if (null == this.inflater) {
            this.inflater = new SimpleLayoutInflater(this, idGenerator);
        }
        return this.inflater;
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

    public  Value getvalueFromString(String datall,String keyselectt){
       String keyselect=keyselectt.replace('#','.');
        try {
            Gson g = getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = g.fromJson(datall, type);
            try {
                if(tempp.isPrimitive("data")) {
                    String mval = tempp.getAsString("data");
                    boolean check = checkjsosn(mval);
                    if (check) {
                        ObjectValue tempp2 = g.fromJson(mval, type);
                        tempp.remove("data");
                        tempp.add("data", tempp2);
                    }
                }
            }catch (Exception e){

                Log.e("qqaa",e.getMessage());
            }
            Value resul=null;
            String[] resull=keyselect.split("\\.");
            for(int z=0;z<resull.length;z++){
                try {
                    if (resull[z].endsWith("]")) {
                        String resum = resull[z];
                        if (resul != null) {
                            try {


                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();

                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = resul.getAsObject().getAsArray(nameonly).get(getintt);

                            } catch (Exception ex) {

                            }
                        } else {
                            try {
                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();
                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = tempp.get(nameonly).getAsArray().get(getintt);
                            } catch (Exception ex) {

                            }
                        }
                    } else {
                        String resum = resull[z];
                        if (resul == null) {
                            ;
                            if (resum.endsWith("]")) {
                                try {
                                    String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                    int x = resum.length() - nanmm.length();
                                    String nameonly = resum.substring(0, x);
                                    String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                    int getintt = Integer.parseInt(gett);
                                    resul = tempp.get(nameonly).getAsArray().get(getintt);
                                } catch (Exception ex) {

                                }
                            } else {
                                //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                resul = tempp.get(resull[z]);
                            }
                        } else {
                            try {
                                if (resum.endsWith("]")) {
                                    try {
                                        String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                        int x = resum.length() - nanmm.length();
                                        String nameonly = resum.substring(0, x);
                                        String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                        int getintt = Integer.parseInt(gett);
                                        resul = resul.getAsObject().getAsArray(nameonly).get(getintt);
                                    } catch (Exception ex) {

                                    }
                                } else {
                                    //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                    if (resul.getAsObject().isPrimitive(resum)) {
                                        resul = resul.getAsObject().get(resum);
                                    } else {

                                        resul = resul.getAsObject().get(resum);
                                    }
                                }
                            } catch (Exception ex) {

                            }
                        }
                    }
                }catch (Exception ex){

                }
            }
            try {
                if(resul!=null) {
                    if (resul.isArray()) {
                        resul = resul.getAsArray();
                    }
                    if (resul.isObject()) {
                        resul = resul.getAsObject();
                    }
                    if (resul.isPrimitive()) {
                        resul = new Primitive(resul.toString());
                    }
                }else{
                    resul=tempp;
                }
            }catch (Exception ex){


            }
            if(keyselect.equals("0")) {
                ObjectValue obj=new ObjectValue();
                obj.add("Result",tempp);
                return obj;

            }else {
                ObjectValue obj=new ObjectValue();
                obj.add("Result",resul);
                return obj;
            }

        }catch (Exception ex){
            Log.e("f555xxx",ex.getMessage());
        }


        Array er=new Array();
        return  er;
    }

    public Value getvalueFromStringg(String datall,String keyselect){
        try {
            // Gson gc=new Gson();
            // Array h = new Array();
            Gson g = getJson();
            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = g.fromJson(datall, type);
            try {
                if(tempp.isPrimitive("data")) {
                    String mval = tempp.getAsString("data");
                    boolean check = checkjsosn(mval);
                    if (check) {
                        ObjectValue tempp2 = g.fromJson(mval, type);
                        tempp.remove("data");
                        tempp.add("data", tempp2);
                    }
                }
            }catch (Exception e){

                Log.e("qqaa",e.getMessage());
            }
            Value resul=null;
            String[] resull=keyselect.split("#");
            for(int z=0;z<resull.length;z++){
                try {
                    if (resull[z].endsWith("]")) {
                        String resum = resull[z];
                        if (resul != null) {
                            try {


                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();

                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = resul.getAsObject().getAsArray(nameonly).get(getintt);

                            } catch (Exception ex) {

                            }
                        } else {
                            try {
                                String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                int x = resum.length() - nanmm.length();
                                String nameonly = resum.substring(0, x);
                                String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                int getintt = Integer.parseInt(gett);
                                resul = tempp.get(nameonly).getAsArray().get(getintt);
                            } catch (Exception ex) {

                            }
                        }
                    } else {
                        String resum = resull[z];
                        if (resul == null) {
                            ;
                            if (resum.endsWith("]")) {
                                try {
                                    String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                    int x = resum.length() - nanmm.length();
                                    String nameonly = resum.substring(0, x);
                                    String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                    int getintt = Integer.parseInt(gett);
                                    resul = tempp.get(nameonly).getAsArray().get(getintt);
                                } catch (Exception ex) {

                                }
                            } else {
                                //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                resul = tempp.get(resull[z]);
                            }
                        } else {
                            try {
                                if (resum.endsWith("]")) {
                                    try {
                                        String nanmm = resum.substring(resum.indexOf("["), resum.length());
                                        int x = resum.length() - nanmm.length();
                                        String nameonly = resum.substring(0, x);
                                        String gett = nanmm.substring(nanmm.indexOf("[") + 1, nanmm.indexOf("]"));
                                        int getintt = Integer.parseInt(gett);
                                        resul = resul.getAsObject().getAsArray(nameonly).get(getintt);
                                    } catch (Exception ex) {

                                    }
                                } else {
                                    //  String resulx = resum.substring(resum.indexOf("[") + 1, resum.indexOf("]"));
                                    if (resul.getAsObject().isPrimitive(resum)) {
                                        resul = resul.getAsObject().get(resum);
                                    } else {

                                        resul = resul.getAsObject().get(resum);
                                    }
                                }
                            } catch (Exception ex) {

                            }
                        }
                    }
                }catch (Exception ex){

                }
            }
            try {
                if(resul!=null) {
                    if (resul.isArray()) {
                        resul = resul.getAsArray();
                    }
                    if (resul.isObject()) {
                        resul = resul.getAsObject();
                    }
                    if (resul.isPrimitive()) {
                        resul = new Primitive(resul.toString());
                    }
                }else{
                    resul=tempp;
                }
            }catch (Exception ex){


            }
            // DataContext.create(views.getViewManager().getContext(),tempp,0);// .DataBinding().DataBinding();
            //views.getViewManager().getContext().getFunctionManager().get(""). Binding.DataBinding. tempp.get(keyselect.replace('#', '@')); //views.getViewManager().getDataContext().getData().getAsBinding(keyselect.replace('#', '@'));
            if(keyselect.equals("0")) {
                ObjectValue obj=new ObjectValue();
                obj.add("Result",tempp);
                return obj;

            }else {
                ObjectValue obj=new ObjectValue();
                obj.add("Result",resul);
                return obj;
            }
        }catch (Exception ex){
            Log.e("f555xxx",ex.getMessage());
        }


        Array er=new Array();
        return  er;
    }





    @NonNull
    public ProteusLayoutInflater getInflater() {
        return getInflater(new SimpleIdGenerator());
    }

    @Nullable
    public ViewTypeParser getParser(String type) {
        return resources.getParsers().get(type);
    }

    @NonNull
    public ProteusResources getProteusResources() {
        return resources;
    }

    public String getStringdata() {
        return Stringdata;
    }

    public void setStringdata(String stringdata) {
        Stringdata = stringdata;
    }

    public String getStringrootLayout() {
        return StringrootLayout;
    }

    public void setStringrootLayout(String stringrootLayout) {
        StringrootLayout = stringrootLayout;
    }

    public String getStringlayouts() {
        return Stringlayouts;
    }

    public void setStringlayouts(String stringlayouts) {
        Stringlayouts = stringlayouts;
    }

    public String getStringstyles() {
        return Stringstyles;
    }

    public void setStringstyles(String stringstyles) {
        Stringstyles = stringstyles;
    }

    private String  Stringdata;
    private String StringrootLayout;
    private String Stringlayouts;
    private String Stringstyles;
    private ObjectValue datagetdat(){
try {
    if(!isCheck()) {
        // ObjectValue objeck=null;
        if (getStringdata().equals("0")) {
            return getData();
        } else {
            Type typek = new TypeToken<Value>() {

            }.getType();

            if (!checkjsosn(getStringdata())) {
                setStringdata("{}");
            }
            Value temppk = getJson().fromJson(getStringdata(), typek);
            return temppk.getAsObject();
        }
    }else {
        return getAData();
    }
}catch (Exception ex){
    return new ObjectValue();
}

    }
  private   ProteusView.Manager ViewManager;
    private void  setViewManger(ProteusView.Manager man){
        this.ViewManager=man;
    }
    public  ProteusView.Manager getrootViewManger(){

        return this.ViewManager;
    }
    public void insview(){
       try {
           try {
               this.containerrb.removeAllViews();
           } catch (Exception ex) {

           }
           ProteusView view = getInflater().inflate(getlayoutroot(), datagetdat(), containerrb, 0);
           setViewManger(view.getViewManager());
           //  System.out.println("inflate time: " + (System.currentTimeMillis() - start));

           // Add the inflated view to the container
           containerrb.addView(view.getAsView());
           getStatusee().loadfinshed();
       }catch (Exception ex){
          if(getStatusee()!=null){
              getStatusee().onerror(ex.getMessage(),ex.getMessage());
          }
       }


    }

    @Nullable
    public Map<String, Value> getStyle(String name) {
        return resources.getStyle(name);
    }

    @NonNull
    @Override
    public ProteusView onUnknownViewType(ProteusContext context, String type, Layout layout, ObjectValue data, int index) {
        return null;
    }

    @Override
    public void onEvent(String event, Value value, ProteusView view) {

    }

    @Override
    public void onEventTage(String Tag, String event, Value value, ProteusView view) {
        //setAllEvent.onEventsendbasic(Tag,event,value,view);
    }

    @Override
    public void onEventAdapter(int typ, String Tag, String event, ObjectValue value, ProteusView view) {
        //setAllEvent.onEvenٍsend(typ,Tag,event,value,view);
    }

    @Override
    public void onEventAdapter(int typ, String Tag, String event, ObjectValue value, ProteusView view, EventProcessor eventproc, boolean withtage, String[] somedsta) {
      //  setAllEvent.onEvenٍsend(typ,Tag,event,value,view,eventproc,withtage,somedsta);

    }

    @Override
    public void getBitmap(ProteusView view, String url, DrawableValue.AsyncCallback callback) {

  /*  CircularProgressDrawable rr=new CircularProgressDrawable(view.getAsView().getContext());
    rr.setColorSchemeColors(R.color.primary,R.color.pink,R.color.colorAccent);
    rr.setCenterRadius(30f);
    rr.setStrokeWidth(5f);

   //rr.i
    rr.start();*/
//callback.setDrawable(rr);
        if (view instanceof ProteusImageView) {
            //callback.setDrawable();

            //   Layout lay=view.getViewManager().getLayout().attributes.extras.getAsObject().getAsLayout(Attributes.View.ErrorMessagew);
           try {
               ProteusView k = (ProteusView) view;
               WatingBarView v = (WatingBarView) k.getViewManager().getContext().getInflater().inflate(((ProteusView) view).getViewManager().getLayout().extras.get("BarWating").getAsLayout(), k.getViewManager().getDataContext().getData());

               //  view.setIndeterminateDrawable(g)
               //progressBar.setIndeterminateDrawable(g);
               // Glide.with(view.getAsView().getContext()).load(url).centerCrop().placeholder(g).override(400,400).into((ProteusImageView) view.getAsView());
               //rr.setArrowDimensions(100f,100f);

      /*  Sprite g=  new Wave();//:(type.equals("2")?new ChasingDots():new CubeGrid()));
        g.setColor(R.color.green);
        g.setDrawBounds(10,10,10,10);*/
               // g.setScale(1f);
               //g.clipSquare(new Rect(50,50,50,50));
               //g.setPivotX(10f);
               // g.setPivotY(10f);
               //g.setAutoMirrored(false);
//g.setTranslateY(0);
//g.setTranslateX(50);
               //  g.setTranslateXPercentage(200);
               // g.setTranslateYPercentage(200);
               // g.start();
               Picasso.with(view.getAsView().getContext()).load(url).placeholder(v.getIndeterminateDrawable()).into(new ImageLoaderTarget(callback, getApplicationContext(), view));

           }catch (Exception ex){

               try {
                   Picasso.with(view.getAsView().getContext()).load(url).into(new ImageLoaderTarget(callback, getApplicationContext(), view));
               }catch (Exception exm){

               }
           }

        }
    }
    /**
     * Builder
     *
     * @author adityasharat
     */
    public static class Builder {

        @NonNull
        private final Context base;

        @NonNull
        private final FunctionManager functionManager;

        @NonNull
        private final Map<String, ViewTypeParser> parsers;

        @Nullable
        private ProteusLayoutInflater.ImageLoader loader;

        @Nullable
        private ProteusLayoutInflater.Callback callback;

        private   ViewGroup containerrb;
        private ProteusManager proteusManagerrb;
        private       String[] dataURLl;
        private getmessage_status massss;
        public Builder setData(String data) {
            this.data = data;
            return  this;
        }

        public Builder setRootLayout(String rootLayout) {
            this.rootLayout = rootLayout;
            return  this;
        }
        public Builder setImageLoader(ProteusLayoutInflater.ImageLoader im) {
            this.loader = im;
            return  this;
        }
        public Builder  setLayouts(String layouts) {
            this.layouts = layouts;
            return  this;
        }

        public Builder setStyles(String styles) {
            this.styles = styles;
            return  this;
        }

        private String  data;
        private String rootLayout;
        private String layouts;
        private String styles;
private StatuseLayout statu;
        public void setData(ObjectValue data) {
            Data = data;
        }

        public void setRootLayout(Layout rootLayout) {
            RootLayout = rootLayout;
        }

        public void setRayouts(Map<String, Layout> rayouts) {
            Layouts = rayouts;
        }

        public void setStyles(com.astooltech.advancedview.proteus.Styles styles) {
            Styles = styles;
        }

        private ObjectValue Data;
        private Layout RootLayout;
        private Map<String, Layout> Layouts;
        private Styles Styles;
        public Builder setStatuse(StatuseLayout massss) {
            this.statu = massss;
            return  this;
        }
        public Builder setMassss(getmessage_status massss) {
            this.massss = massss;
            return  this;
        }

        public Builder setFrgmentMangers(FragmentManager frgmentMangers) {
            this.frgmentMangers = frgmentMangers;
            return  this;
        }

        public Builder setmFragmenttv(AbstractFragment mFragmenttv) {
            this.mFragmenttv = mFragmenttv;
            return  this;
        }

        public Builder setmDrawerr(DrawerLayout mDrawerr) {
            this.mDrawerr = mDrawerr;
            return  this;
        }

        private FragmentManager frgmentMangers;
        private    AbstractFragment mFragmenttv;
        private  DrawerLayout mDrawerr;
        @Nullable
      //  private LayoutManager layoutManager;
        private AppCompatActivity ActvityAll;
private Gson gsonn;
        @Nullable
        private StyleManager styleManager;
      //  private all_action_Activity setAllEventx;
        @NonNull
        public  final ALLEventManger eventManger;
        Builder(@NonNull Context context, @NonNull Map<String, ViewTypeParser> parsers, @NonNull FunctionManager functionManager,ALLEventManger eventMangee) {
            this.base = context;
            this.parsers = parsers;
            this.functionManager = functionManager;
            this.eventManger=eventMangee;

            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(base);
          gsonn = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();

        }



        public  Builder Setcontainerr(ViewGroup setAllEventt){
            containerrb=setAllEventt;
            return  this;
        }
        public  Builder SetActivitys(AppCompatActivity ActvityAllt){
            ActvityAll=ActvityAllt;
            return  this;
        }


        public  Builder SetdataURLl(String[] setAllEventt){
            dataURLl=setAllEventt;
            return  this;
        }

        public Builder setCallback(@Nullable ProteusLayoutInflater.Callback callback) {
            this.callback = callback;
            return this;
        }



        private StyleManager styleManagerx = new StyleManager() {

            @Nullable
            @Override
            protected Styles getStyles() {
                Styles temppsty=null;
                Type typex = new TypeToken<Styles>() {

                }.getType();
                if(styles.equals("0")){
                    temppsty=Styles;
                }else {
                    if (!checkjsosn(styles)) {

                      setStyles("{}");
                    }
                    temppsty = gsonn.fromJson(styles, typex);
                }
                return temppsty;
            }
        };
        private Map<String,Layout> getlayoutfromStringx(String dataa) throws JSONException {
            // Log.i("ee", "ERROR: " +"sdsdddddddddd");

            Type type = new TypeToken<Value>() {

            }.getType();
            ObjectValue tempp = gsonn.fromJson(dataa, type);

            HashMap<String,Layout> iio=new HashMap<>();
            Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
            while (vv.hasNext()) {
                try {
                    Map.Entry<String, Value> ddertt = vv.next();
                    if(ddertt.getKey().toLowerCase().equals("root_layout")){
                        //Log.e("ffffaaaaa","fgggggggf");
                        setRootLayout(ddertt.getValue().getAsLayout());
                    }else if(ddertt.getKey().toLowerCase().equals("data_layout")){
                        setData(ddertt.getValue().getAsObject());
                    }

                    else {

                        iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
                    }
                    //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
                }catch (Exception ex){
                    Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
                }
            }
            setRayouts(iio);

            return iio;
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
private void getfrom (){


    Type typex = new TypeToken<Value>() {

    }.getType();

   Value temppsty = gsonn.fromJson(layouts, typex);

   temppsty.getAsObject();


}

        private LayoutManager layoutManagerx = new LayoutManager() {

            @Nullable
            @Override
            protected Map<String, Layout> getLayouts() {

                Map<String, Layout> k=null;
                try {

                    if (!checkjsosn(layouts)) {

                      setLayouts("{}");
                    }
                    k = getlayoutfromStringx(layouts);

                }catch (Exception ex){

                }

                return k;
            }
        };
        public ProteusContext build() {
           // layoutManagerx
          //  layoutManagerx
try {
   if(rootLayout.equals("0")){

       getlayoutfromStringx(layouts);
   }
}catch (Exception ex){

}
/*
ObjectValue vvv=new ObjectValue();
vvv.get("hh").getAsLayout().
            String ett=gsonn.toJson(RootLayout);
            Log.e("ffff",ett);*/
          //  Log.e("ffff",layouts);
            RxActivityResult.register(ActvityAll.getApplication());
            ProteusResources resources = new ProteusResources(parsers, layoutManagerx, functionManager, styleManagerx,eventManger);
            return new ProteusContext(base, callback,containerrb,proteusManagerrb,dataURLl,massss,frgmentMangers,mFragmenttv,mDrawerr,ActvityAll,data,rootLayout,layouts,styles,RootLayout,Data,gsonn,resources,statu,false,null,new ObjectValue(),loader);
        }
        public ProteusContext build(Map<String, Layout> layoutsa, String layott, final Styles stayl,ObjectValue obj) {
            // layoutManagerx
            //  layoutManagerx
            boolean t=false;
            Map<String, Layout> fd=null;
            if(layoutsa==null){
                t=true;
                try {
                 fd=   getlayoutfromStringx(layott);
                }catch (Exception ex){

                }
                //RootLayout=
            }
            final Map<String, Layout> layoutsak=t?fd:layoutsa;
         final    Layout layot = t?RootLayout:layoutsa.get(layott);

         final ObjectValue objj=t?Data:obj;
/*
ObjectValue vvv=new ObjectValue();
vvv.get("hh").getAsLayout().
            String ett=gsonn.toJson(RootLayout);
            Log.e("ffff",ett);*/
            //  Log.e("ffff",layouts);
            RxActivityResult.register(ActvityAll.getApplication());
            ProteusResources resources = new ProteusResources(parsers, new LayoutManager() {
                @Nullable
                @Override
                protected Map<String, Layout> getLayouts() {
                    return layoutsak;
                }
            }, functionManager, new StyleManager() {
                @Nullable
                @Override
                protected com.astooltech.advancedview.proteus.Styles getStyles() {
                 return    stayl;
                }
            }, eventManger);
            return new ProteusContext(base, callback,containerrb,proteusManagerrb,dataURLl,massss,frgmentMangers,mFragmenttv,mDrawerr,ActvityAll,data,rootLayout,layouts,styles,RootLayout,Data,gsonn,resources,statu,true,layot,objj,loader);
        }

    }
}
