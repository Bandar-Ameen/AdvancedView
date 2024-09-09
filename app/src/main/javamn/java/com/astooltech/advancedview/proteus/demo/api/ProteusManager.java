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

package com.astooltech.advancedview.proteus.demo.api;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.Styles;
import com.astooltech.advancedview.proteus.demo.CircleViewParser;
import com.astooltech.advancedview.proteus.design.DesignModule;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.v4.SupportV4Module;
import com.astooltech.advancedview.proteus.v7.AutoCompleteTextViewModel;
import com.astooltech.advancedview.proteus.v7.CardViewModule;
import com.astooltech.advancedview.proteus.v7.RecyclerViewModule;
import com.astooltech.advancedview.proteus.v7.SliderViewModel;
import com.astooltech.advancedview.proteus.v7.SppinerViewBModel;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import retrofit2.Retrofit;
//import retrofit2.Retrofit;

public class ProteusManager {

    private final ProteusApi api;
    private final Proteus proteus;
    private String ddata;
    private String rrootLayout;
    private String llayouts;
    private String sstyles;
    public String getDdata() {
        return ddata;
    }
    public void setDdata(String ddata) {
        this.ddata = ddata;
    }
    public String getRrootLayout() {
        return rrootLayout;
    }
    public void setRrootLayout(String rrootLayout) {
        this.rrootLayout = rrootLayout;
    }
    public String getLlayouts() {
        return llayouts;
    }
    public void setLlayouts(String llayouts) {
        this.llayouts = llayouts;
    }
    public String getSstyles() {
        return sstyles;
    }
    public void setSstyles(String sstyles) {
        this.sstyles = sstyles;
    }
    private ObjectValue data;
    private Layout rootLayout;
    private Map<String, Layout> layouts;
    private Styles styles;
private boolean checkdat;
private Activity actvityy;
    private Set<Listener> listeners = new HashSet<>();
private final Context context;
    public ProteusManager(Retrofit retrofit, Context context, Activity actvity) {
       this.context=context;
       this.actvityy=actvity;
        this.api = retrofit.create(ProteusApi.class);
        proteus = new ProteusBuilder()
                .register(SupportV4Module.create())
                .register(RecyclerViewModule.create())
                .register(SliderViewModel.create())
                .register(AutoCompleteTextViewModel.create())
                .register(SppinerViewBModel.create())
                .register(CardViewModule.create())
                .register(DesignModule.create())
                .register(new CircleViewParser())
                .build();
        //ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus().createContext(context).
        ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(proteus);
    }
    public ProteusManager( Context context,Activity actvity) {
        this.context=context;
        this.actvityy=actvity;
        this.api =null;
        checkdat=true;
        //retrofit.create(ProteusApi.class);
        proteus = new ProteusBuilder()
                .register(SupportV4Module.create())
                .register(RecyclerViewModule.create())
                .register(SliderViewModel.create())
                .register(AutoCompleteTextViewModel.create())
                .register(SppinerViewBModel.create())
                .register(CardViewModule.create())
                .register(DesignModule.create())
                .register(new CircleViewParser())
                .build();

        //ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus().createContext(context).
        ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(proteus);
    }

    public void load(String[] dataurl) {
      if(!checkdat) {
          new DataLoaderTask(this, "0", null, false, dataurl, context).execute();
      }
    }
    public void load(ArrayList<String> dataurl) {

            loaddall(dataurl);

    }
    public void update(String keytypp, Value dataa, boolean usee,String[] dataurl) {
        if(!checkdat) {
            new DataLoaderTask(this, keytypp, dataa, usee, dataurl, context).execute();
        }
    }
    public Proteus getProteus() {
        return proteus;
    }

    public ObjectValue getData() {
        return data;
    }

    public Layout getRootLayout() {
        return rootLayout;
    }

    public Map<String, Layout> getLayouts() {
        return layouts;
    }

    public Styles getStyles() {
        return styles;
    }

    public void addListener(@NonNull Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(@NonNull Listener listener) {
        listeners.remove(listener);
    }

    private void broadcast(@Nullable Object e) {
        if (e == null) {
            notifySuccess();
        } else {
            notifyError(e);
        }
    }

    private void notifySuccess() {
        for (Listener listener : listeners) {
            listener.onLoad();
        }
    }
   public void notifySuccessOnBack(String a1,String a2) {
        for (Listener listener : listeners) {
            listener.onbackpress(a1,a2);
        }
    }
    private void notifyError(@NonNull Object e) {
        for (Listener listener : listeners) {
            listener.onError(e);
        }
    }
public void sendsend(String parsernam,String mess){

        this.getProteus().createContext(context).getParser(parsernam).BordcastRecever(mess);
}

    public void sendsend(String parsernam,String mess,int typ){

        this.getProteus().createContext(context).getParser(parsernam).GetAndSetData(null,null,20,mess,mess);
    }
    private static class DataLoaderTask extends AsyncTask<Void, Void, Exception> {

        private final ProteusManager manager;
private  String keyname;
private  Value Dataaa;
private  boolean usee;
private  String [] dataurl;
private  Context cc;
private boolean cfx=false;
        DataLoaderTask(ProteusManager manager,String keytyp,Value data,boolean use,String [] dataurl,Context context) {
           this.cc=context;
            this.manager = manager;
            this.usee=use;
            this
                    .Dataaa=data;
            this
                    .keyname=keytyp;
            this.dataurl=dataurl;
            boolean eer=false;
           try {
               String mdat = getdatafrom(this.dataurl[1]);
               String mdat1 = getdatafrom(this.dataurl[2]);
               String mdat2 = getdatafrom(this.dataurl[3]);
               String mdat3 = getdatafrom(this.dataurl[4]);
               if (mdat.equals("NO")) {
                   eer = true;
               }
               if (mdat1.equals("NO")) {
                   eer = true;
               }

               if (mdat3.equals("NO")) {
                   eer = true;
               }
               if (mdat2.equals("NO")) {
                   eer = true;
               }
               if (!eer) {
                   loadfromcustom();
               }

           }catch (Exception ex){

           }

        }
        public  void savetoref(String keyname,String kayval){
            try {

                SharedPreferences settings = cc.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.remove(keyname);
                editor.putString(keyname,kayval);
                editor.commit();
            }catch (Exception ex){
             //   Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        private String getdatafrom(String textt){

            SharedPreferences settings =cc.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
            final String mpp = settings.getString(textt, "");
            if (mpp.isEmpty()) {
                return "NO";
            }else {
                return mpp;
            }


        }
        public Map<String,Layout> getlayoutfromString(String dataa) throws JSONException {
           // Log.i("ee", "ERROR: " +"sdsdddddddddd");
            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
            Gson gsonn = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();
            Type type = new TypeToken<Value>() {

            }.getType();
           ObjectValue tempp = gsonn.fromJson(dataa, type);

            HashMap<String,Layout> iio=new HashMap<>();
            Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
            while (vv.hasNext()) {
try {
    Map.Entry<String, Value> ddertt = vv.next();
    iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
    //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
}catch (Exception ex){
    Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
}
            }


            return iio;
        }
        @Override
        protected Exception doInBackground(Void... params) {

            try {
                ProteusApi api = manager.api;
               Object dataset  =(this.dataurl[0].equals("0")?api.getUserDataWithGet(this.dataurl[1]):api.getUserDataWithPost(this.dataurl[1])).execute().body();
                Gson gx=new Gson();
                String mdat=gx.toJson(dataset);
                savetoref(this.dataurl[1],mdat);
                ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(cc);
                Gson gsonnk = new GsonBuilder()
                        .registerTypeAdapterFactory(adapterk)
                        .create();
                Type typek = new TypeToken<Value>() {

                }.getType();
                Value temppk = gsonnk.fromJson(mdat, typek);
                manager.data=temppk.getAsObject();


                if(usee){


                    // ObjectValue dataupdate =new ObjectValue();

                   // data.add("s",c);
                    manager.data.add(keyname,Dataaa);

                }





                    Object df    =(this.dataurl[0].equals("0")?api.getLayoutWithGet(this.dataurl[2]):api.getLayoutWithPOST(this.dataurl[2])).execute().body(); //api.getLayout().execute().body();
Gson g=new Gson();
String rootlaout=g.toJson(df);
savetoref(this.dataurl[2],rootlaout);
             // Log.i("888",);


                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
                Gson gsonn = new GsonBuilder()
                        .registerTypeAdapterFactory(adapter)
                        .create();
                Type type = new TypeToken<Value>() {

                }.getType();

                try{
                Value tempp = gsonn.fromJson(rootlaout, type);

                manager.rootLayout=tempp.getAsLayout();
                } catch (Exception e) {
                    Log.e("ee", "ERROR: " + e.getMessage());
                    return e;
                }
              //  manager.layouts

                   Object layouuuts     =(this.dataurl[0].equals("0")?api.getLayoutsWithGet(this.dataurl[3]):api.getLayoutsWithPost(this.dataurl[3])).execute().body(); //api. //api.getLayouts().execute().body();
                String laoutt=g.toJson(layouuuts );
                savetoref(this.dataurl[3],laoutt);
               // Value layy = gsonn.fromJson(rootlaout, type);

                //HashMap<String ,Layout> ff=new HashMap<>();
              //  ff.put("ff",tempp.getAsLayout());

              try {
                  manager.layouts = getlayoutfromString(laoutt);
               } catch (Exception e) {
                Log.e("ee", "ERROR: " + e.getMessage());
                return e;
            }

              //  manager.styles

                Gson xx=new Gson();
//Log.i("77",xx.toJson(this.dataurl));

                    Object stylee = (this.dataurl[0].equals("0") ? api.getStylesWithGet(this.dataurl[4]) : api.getStylesWithPOST(this.dataurl[4])).execute().body(); //api.getStyles().execute().body();

                    String styleet = g.toJson(stylee);
                    savetoref(this.dataurl[4], laoutt);

                   // ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);

                  try {
                      Gson gsonnx = new GsonBuilder()
                              .registerTypeAdapterFactory(adapter)
                              .create();
                      Type typex = new TypeToken<Styles>() {

                      }.getType();

                      Styles temppsty = gsonnx.fromJson(styleet, typex);
                      manager.styles = temppsty;
                  } catch (Exception e) {
                      Log.e("ee", "ERROR: " + e.getMessage());
                      return e;
                  }
              //  manager.rootLayout=tempp.getAsLayout();

            } catch (Exception e) {
                Log.i("6666", e.getClass().getCanonicalName());
                if (e instanceof com.google.gson.stream.MalformedJsonException) {
return e;
                } else {
                  //  Log.i("6666", e.getClass().getCanonicalName());
                    try {
                        ProteusApi api = manager.api;

                        String mdat = getdatafrom(this.dataurl[1]);

                        ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(cc);
                        Gson gsonnk = new GsonBuilder()
                                .registerTypeAdapterFactory(adapterk)
                                .create();
                        Type typek = new TypeToken<Value>() {

                        }.getType();
                        Value temppk = gsonnk.fromJson(mdat, typek);
                        manager.data = temppk.getAsObject();


                        String rootlaout = getdatafrom(this.dataurl[2]);

                        // Log.i("888",);
                        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
                        Gson gsonn = new GsonBuilder()
                                .registerTypeAdapterFactory(adapter)
                                .create();
                        Type type = new TypeToken<Value>() {

                        }.getType();
                        Value tempp = gsonn.fromJson(rootlaout, type);
                        manager.rootLayout = tempp.getAsLayout();

                        //  manager.layouts


                        String laoutt = getdatafrom(this.dataurl[3]);
                        // savetoref(this.dataurl[3],laoutt);
                        // Value layy = gsonn.fromJson(rootlaout, type);

                        //HashMap<String ,Layout> ff=new HashMap<>();
                        //  ff.put("ff",tempp.getAsLayout());
                        try {
                            manager.layouts = getlayoutfromString(laoutt);
                        } catch (JSONException ex) {
                            Log.e("ee", "ERROR: " + e.getMessage());
                            return ex;
                            //ex.printStackTrace();
                        }


                        //  manager.styles


                        String styleet = getdatafrom(this.dataurl[4]);


                        // ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
                        Gson gsonnx = new GsonBuilder()
                                .registerTypeAdapterFactory(adapter)
                                .create();
                        Type typex = new TypeToken<Styles>() {

                        }.getType();
                        Styles temppsty = gsonnx.fromJson(styleet, typex);
                        manager.styles = temppsty;


                        Log.e("ee", "ERROR: " + e.getMessage());
                        return null;
                    } catch (Exception ex) {
                        Log.e("ee", "ERROR: " + e.getMessage());
                        return ex;
                    }
                }
            }
            return null;
        }
private  void loadfromcustom(){
try {
    ProteusApi api = manager.api;

    String mdat = getdatafrom(this.dataurl[1]);

    ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(cc);
    Gson gsonnk = new GsonBuilder()
            .registerTypeAdapterFactory(adapterk)
            .create();
    Type typek = new TypeToken<Value>() {

    }.getType();
    Value temppk = gsonnk.fromJson(mdat, typek);
    manager.data = temppk.getAsObject();

    manager.setDdata(mdat);

    String rootlaout = getdatafrom(this.dataurl[2]);
    manager.setRrootLayout(rootlaout);
    // Log.i("888",);
    ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
    Gson gsonn = new GsonBuilder()
            .registerTypeAdapterFactory(adapter)
            .create();
    Type type = new TypeToken<Value>() {

    }.getType();
    Value tempp = gsonn.fromJson(rootlaout, type);
    manager.rootLayout = tempp.getAsLayout();

    //  manager.layouts


    String laoutt = getdatafrom(this.dataurl[3]);
    manager.setLlayouts(laoutt);
    // savetoref(this.dataurl[3],laoutt);
    // Value layy = gsonn.fromJson(rootlaout, type);

    //HashMap<String ,Layout> ff=new HashMap<>();
    //  ff.put("ff",tempp.getAsLayout());
    try {
        manager.layouts = getlayoutfromString(laoutt);
    } catch (JSONException ex) {
        ex.printStackTrace();
    }


    //  manager.styles


    String styleet = getdatafrom(this.dataurl[4]);

    manager.setSstyles(styleet);
    // ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
    Gson gsonnx = new GsonBuilder()
            .registerTypeAdapterFactory(adapter)
            .create();
    Type typex = new TypeToken<Styles>() {

    }.getType();
    Styles temppsty = gsonnx.fromJson(styleet, typex);
    manager.styles = temppsty;
    manager.broadcast(null);
    cfx=true;
}catch (Exception ex){
    manager.broadcast(ex.getMessage());
}



}
        @Override
        protected void onPostExecute(Exception e) {
            super.onPostExecute(e);
           if(!cfx) {

               manager.broadcast(e.getMessage());
           }
        }
    }


    public void loaddall(ArrayList<String> data){

        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(context);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type type = new TypeToken<Value>() {

        }.getType();

        String styleet = data.get(0);//getdatafrom(this.dataurl[4]);

Log.i("kk","1");
        // ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(cc);
        Gson gsonnx = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type typex = new TypeToken<Styles>() {

        }.getType();
        this.setSstyles(styleet);
        this.setDdata(data.get(3));
        Styles temppsty = gsonnx.fromJson(styleet, typex);
        ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(context);
        Gson gsonnk = new GsonBuilder()
                .registerTypeAdapterFactory(adapterk)
                .create();
        Type typek = new TypeToken<Value>() {

        }.getType();

        Value temppk = gsonnk.fromJson(data.get(3), typek);

        Log.i("kk","4");
        this.data = temppk.getAsObject();
        Log.i("kk","1");
        try {
            this.styles = temppsty;

        //    this.layouts = getlayoutfromString(data.get(1));

        /*    Log.i("kk","2");
                Value tempp = gsonn.fromJson(data.get(2), type);

                this.rootLayout=tempp.getAsLayout();

            Log.i("kk","3");
*/

            this.broadcast(null);

        }catch (Exception ex) {

            this.broadcast(ex);

        }
    }
    public Map<String,Layout> getlayoutfromString(String dataa) throws JSONException {
        // Log.i("ee", "ERROR: " +"sdsdddddddddd");
        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(context);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type type = new TypeToken<Value>() {

        }.getType();
        ObjectValue tempp = gsonn.fromJson(dataa, type);

        HashMap<String,Layout> iio=new HashMap<>();
        Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
        while (vv.hasNext()) {
            try {
                Map.Entry<String, Value> ddertt = vv.next();
                iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
                //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
            }catch (Exception ex){
                Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
            }
        }


        return iio;
    }
    public interface Listener {

        void onLoad();
        void onbackpress(String a1, String a2);
        void onError(@NonNull Object e);


    }
}

