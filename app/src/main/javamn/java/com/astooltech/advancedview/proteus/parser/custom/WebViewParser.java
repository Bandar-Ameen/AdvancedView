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

package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.inlineactivityresult.request.RequestFabric;
import com.astooltech.advancedview.proteus.parser.NotificationActivity;
import com.astooltech.advancedview.proteus.parser.NotificationHelper;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.demo.ProtouseNewActivity;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;
import com.astooltech.advancedview.proteus.parser.webview.gm.JavaScript_and_Java;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.PermissionInterceptor;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadListenerAdapter;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Extra;
import com.astooltech.advancedview.proteus.parser.webview.gm.model.Script;
import com.astooltech.advancedview.proteus.parser.webview.gm.util.DownloadHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.retrofiturlmanager.NetWorkManager;
import com.astooltech.advancedview.proteus.retrofiturlmanager.RetrofitUrlManager;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProteusWebView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.spinkit.sprite.Sprite;
import com.astooltech.advancedview.spinkit.style.Wave;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.astooltech.advancedview.proteus.retrofiturlmanager.api.Api.DOUBAN_DOMAIN_NAME;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class WebViewParser<T extends AdvancedWebView> extends ViewTypeParser<T>  {


  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable MaterialRippleLayout  parent, int dataIndex) {
    return new ProteusRappleLayout(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
    return new TextInputLayoutB(context);
  }

  @NonNull
  @Override
  public String getType() {
    return "WebView";
  }

    @Override
    public void BordcastRecever(String Broad) {
        super.BordcastRecever(Broad);
try {
    if (getview != null) {

        getview.getViewManager().getActionEventView().sendEvent(null, 7000, Broad);
    }
}catch (Exception ex){

}
    }

    @Override
    public void ReceveSearch(String Broad, String viewID) {
        super.ReceveSearch(Broad, viewID);
      if(Broad.equals("0")) {
          if (getview != null) {
              getview.getViewManager().getActionEventView().sendEvent(null, 178000, Broad);
          }
      }else{
          if (getview != null) {
              String getse = getview.getAsView().getTag(R.id.tag3).toString();

              if (viewID.equals(getse)) {
                  getview.getViewManager().getActionEventView().sendEvent(null, 78000, Broad);
              }
          }


      }
    }

    @Nullable
  @Override
  public String getParentType() {
    return "View";
  }

  private static ProteusView getview;
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
      getview=new ProteusWebView(context);
    return getview;
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);

  }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
      if(typoper==20){
          if(getview!=null){
             try {
                 ProteusWebView qww = (ProteusWebView) getview;
                 if (qww.hasFocus()) {
                    /* if (qww.canGoBack()) {

                         qww.getViewManager().getContext().getProteusManagerrb().notifySuccessOnBack("1", "1");

                     } else {
                         qww.getViewManager().getContext().getProteusManagerrb().notifySuccessOnBack("0", "0");
                     }*/
                 }
             }catch (Exception ex){

             }
          }
      }else {
          if (view instanceof ProteusWebView) {
              SetGetFindWebView((ProteusWebView) view, data, typoper);
          }
      }
    }
    private static void SetGetFindWebView( ProteusWebView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

//dt.getViewManager().getLayout().type.getViewManager().getContext().getProteusResources().getParsers().getParser()
                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            dt.reload();
                            // datb.setDataGet(String.valueOf(dt.isChecked()));

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


                            dt.loadUrl("javascript:" + d);
                        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }
    }


    @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor(Attributes.WebView.Url, new StringAttributeProcessor<T>() {
      @SuppressLint("SetJavaScriptEnabled")
      @Override
      public void setString(T view, String value) {
        view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        view.getSettings().setLoadsImagesAutomatically(true);
        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setUseWideViewPort(true);
        view.getSettings().setLoadWithOverviewMode(true);
        view.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);//.setJavaScriptEnabled(true);
       view.setWebViewClient(new WebViewClient(){
         @Override
         public void onPageStarted(WebView view, String url, Bitmap favicon) {
           super.onPageStarted(view, url, favicon);

         }

         @Override
         public void onPageFinished(WebView view, String url) {
           super.onPageFinished(view, url);
         }
       });

        view.loadUrl(value);

      }

    });


    addAttributeProcessor("DataUrl", new AttributeProcessor<T>() {
      @Override
      public void handleBinding(T view, Binding value) {

      }

    private void  downloadsecriptt(Context context,String url) {
        makeToastOnUiThread(context,"dddd"
                + " " + url, Toast.LENGTH_SHORT);
        String scriptStr = DownloadHelper.downloadScript(url);
        if (scriptStr == null) {
          makeToastOnUiThread(context,"dddd1"
                  + " " + url, Toast.LENGTH_SHORT);
          return;
        }
        Script script = Script.parse(scriptStr, url);
        if (script == null) {
         // Log.d(TAG, "Error parsing script:\n" + scriptStr);
          makeToastOnUiThread(context,"dddd3"
                  + " " + url, Toast.LENGTH_SHORT);
          return;
        }

        //scriptStore.add(script);
        makeToastOnUiThread(context,"تم" + " " + script, Toast.LENGTH_LONG);
      }
      private void makeToastOnUiThread(final Context context, final String message, final int length) {
        ((AppCompatActivity)context.getApplicationContext()).runOnUiThread(new Runnable() {
          public void run() {
            Toast.makeText(((Activity)context.getApplicationContext()), message, length).show();
          }
        });
      }

        private void showResult(final String result,Context c) {
            new AlertDialog.Builder(c)
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



        public void adjustResizeOnGlobalLayout(final int b,final int boton,final ProteusView v,final View cont,final View Docereview,final Context c) {
            // final View decorView = getWindow().getDecorView();
            // final ViewGroup viewGroup = (ViewGroup) findViewById(viewGroupId);
            //Docereview .getViewTreeObserver().addOnGlobalLayoutListener(null);
            Docereview .getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
                    Rect rect = new Rect();
                  Docereview.getWindowVisibleDisplayFrame(rect);
                    int paddingBottom = displayMetrics.heightPixels - rect.bottom+boton;

                    if (cont.getPaddingBottom() != paddingBottom) {
                        // showing/hiding the soft keyboard
                        cont.setPadding(cont.getPaddingLeft(), cont.getPaddingTop()+b, cont.getPaddingRight(), paddingBottom);
                    } else {
                        // soft keyboard shown/hidden and padding changed
                        if (paddingBottom != 0) {
                            // soft keyboard shown, scroll active element into view in case it is blocked by the soft keyboard



                            ((ProteusWebView)v).evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", null);
                            //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                            //  v.getViewManager().getContext().getParser("WebView").ReceveSearch("0","0");

                        }
                    }
                }
            });
        }

public  void wendownload(EventProcessor uupk,boolean check,Context c,Array htmlvalue,boolean useupdat,ProteusWebView view){
    List<hedaerOrQuary> kj =new ArrayList<>();
    // String[] urlsecript = value.getAsObject().getAsString("m_urls").split("#");
    Iterator<Value> getval=htmlvalue.iterator();
    while (getval.hasNext()){
        Value va=getval.next();
        String Namekey=va.getAsObject().getAsString("Key_Name");
        String Namekeyval=va.getAsObject().getAsString("Key_Value");
        String Namekeytyp=va.getAsObject().getAsString("Key_Type");
        String Namekeyview=va.getAsObject().getAsString("View_Name");
        hedaerOrQuary g=new hedaerOrQuary(Namekey,Namekeyval,Namekeytyp,Namekeyview);

        kj.add(g);

    }
    DatabaseHelper db_operations = new DatabaseHelper(c);
    // List<hedaerOrQuary> kj = getdata(htmlvalue);
    List<hedaerOrQuary> uio = new ArrayList<>();
    for (int cx = 0; cx < kj.size(); cx++) {
        String typ = kj.get(cx).getKeyType().toLowerCase();

        if (typ.equals("htmltag")) {

            String val = kj.get(cx).getKeyValue();
            ScriptModel g=new ScriptModel(0,"00", val);
            String valux="";
            try {
                List<ScriptModel> h = db_operations.getAllNotes(g);
                valux=h.get(0).getContent();
            }catch (Exception ex){
                check=true;
                useupdat=true;
            }
            if(valux.equals("")){
                useupdat=true;
            }
            hedaerOrQuary i = new hedaerOrQuary("0", val, "0", "0");
            uio.add(i);

        }
        //  hedde.add(hedded.get(cx));
    }

    if (useupdat) {

        view.clearHistory();
        view.clearCache(true);
        view.clearFormData();
        // view.getSettings().
        int ssde=0;
        for (int cx = 0; cx < uio.size(); cx++) {
            ssde=ssde+1;
            new DownloadFileFromURL(c, uio.get(cx).getKeyValue()).execute(
                    uio.get(cx).getKeyValue()
                    ,String.valueOf(cx)
                    ,String.valueOf(ssde),
                    String.valueOf(uio.size()));  //(urlsecript);
        }


    }


}
        public void runwebview(final ProteusWebView view,Value value){

            try {

                WatingLayoutProtuse layou=null;
                try{
                 layou =( WatingLayoutProtuse)view.getAsView().getRootView();
                }catch (Exception ex){

                }

                final WatingLayoutProtuse  layouu=  layou;
                if(layouu!=null){
                    layouu.startWating();
                }
            /* LinearLayout   tabsContainer = new LinearLayout(view.getContext());
                tabsContainer.setGravity(Gravity.CENTER_VERTICAL);
                tabsContainer.setOrientation(LinearLayout.VERTICAL);
                tabsContainer.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
               // LinearLayout kjj=new LinearLayout(view.getContext(), ViewGroup.LayoutParams.MATCH_PARENT);

                ProgressBar eert=new ProgressBar(view.getContext());

                Sprite gx=  new Wave();//:(type.equals("2")?new ChasingDots():new CubeGrid()));
                gx.setColor(R.color.green);
gx.start();

eert.setIndeterminateDrawable(gx);
                ViewGroup r =(ViewGroup) view.getRootView();

                tabsContainer.addView(eert);
                view.setLinwting(tabsContainer);

                r.addView(tabsContainer);

ProteusView errorss=null;
try {
    Layout dfrk = value.getAsObject().getAsLayout("Error_View");
    errorss = view.getViewManager().getContext().getInflater().inflate(dfrk, new ObjectValue());
    errorss.getAsView().setVisibility(View.GONE);
    view.setErrorView(errorss);
    r.addView(errorss.getAsView());
}catch (Exception ex){

}*/

           // eert.setIndeterminate();
                /*Drawable d=view.getResources().getDrawable(R.drawable.b_raple2);
view.setBackground(d);*/
              /*  DynamicBox    box=new DynamicBox(view.getContext(),view.getRootView());
                box.setLoadingMessage("now Loading....");
                box.setInternetOffMessage("no Enternet Connection");
                box.setOtherExceptionMessage("noooo other");
                box.setClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                box.showLoadingLayout();
                final     DynamicBox boxx=box;*/
              ObjectValue Whenerror=null;
                ObjectValue WhenfinishEvent=null;
                try {
                    Whenerror = value.getAsObject().getAsObject("When_Error_Event");
                    WhenfinishEvent = value.getAsObject().getAsObject("When_Finish_Event");
                }catch (Exception ex){

                }
             final    ObjectValue Whenerrorr=     Whenerror;
            final     ObjectValue WhenfinishEventr=WhenfinishEvent;
                final   String dfr  = value.getAsObject().getAsString("Use_Service_Function");
try {
    final boolean dfrk = value.getAsObject().getAsBoolean("Use_KeyBoard");
    final int dfrkk = value.getAsObject().getAsInteger("Use_KeyBoardB");
    final int dfrkkt = value.getAsObject().getAsInteger("Use_KeyBoardT");
    if (dfrk) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                adjustResizeOnGlobalLayout(dfrkkt,dfrkk,view, view.getAsView().getRootView(), view.getAsView().getRootView(), view.getContext());
                //view.getViewManager().getContext().adjustResizeOnGlobalLayout();
            }
        }, 100);
    }
}catch (Exception ex){

}
//view.setFocusableInTouchMode();
               // ()

                boolean useerroe = value.getAsObject().getAsBoolean("use_error");
                String ht = value.getAsObject().getAsString("m_html");
                String urlm = value.getAsObject().getAsString("m_url");
                String urlmk = "[]"; //value.getAsObject().getAsString("m_get_data");
                String urlmerreo = value.getAsObject().getAsString("m_error");
            Array htmlvalue = value.getAsObject().getAsArray("html_value");
                boolean usegetData = false;
                try {
                    usegetData = value.getAsObject().getAsBoolean("use_get_data");
                    urlmk = view.getTag(R.id.web_get_data).toString();
                } catch (Exception ex) {

                }
                boolean checkuse = value.getAsObject().getAsBoolean("Use_Url");
                boolean upda = value.getAsObject().getAsBoolean("update");

                List<hedaerOrQuary> kj =new ArrayList<>();
                // String[] urlsecript = value.getAsObject().getAsString("m_urls").split("#");
Iterator<Value> getval=htmlvalue.iterator();
while (getval.hasNext()){
    Value va=getval.next();
    String Namekey=va.getAsObject().getAsString("Key_Name");
    String Namekeyval=va.getAsObject().getAsString("Key_Value");
    String Namekeytyp=va.getAsObject().getAsString("Key_Type");
    String Namekeyview=va.getAsObject().getAsString("View_Name");
    hedaerOrQuary g=new hedaerOrQuary(Namekey,Namekeyval,Namekeytyp,Namekeyview);

    kj.add(g);

}
                DatabaseHelper db_operations = new DatabaseHelper(view.getContext());
               // List<hedaerOrQuary> kj = getdata(htmlvalue);
                List<hedaerOrQuary> uio = new ArrayList<>();
                for (int cx = 0; cx < kj.size(); cx++) {
                    String typ = kj.get(cx).getKeyType().toLowerCase();

                    if (typ.equals("htmltag")) {

                        String val = kj.get(cx).getKeyValue();
                        ScriptModel g=new ScriptModel(0,"00", val);
                        String valux="";
                        try {
                            List<ScriptModel> h = db_operations.getAllNotes(g);
                            valux=h.get(0).getContent();
                        }catch (Exception ex){
                            upda=true;
                        }
                        if(valux.equals("")){
                            upda=true;
                        }
                        hedaerOrQuary i = new hedaerOrQuary("0", val, "0", "0");
                        uio.add(i);

                    }
                    //  hedde.add(hedded.get(cx));
                }
                final String[] data = gethderOr(kj, view.getContext(), db_operations, usegetData, urlmk);
final  String[] datc=data;
final  String htt=ht;
                final ProteusWebView viewxm=view;


                // Log.i("090",urlmk);
                //  String[]  css = value.getAsObject().getAsString("m_urlCss").split("#");
             if (upda) {

                    view.clearHistory();
                    view.clearCache(true);
                    view.clearFormData();
                   // view.getSettings().
                    int ssde=0;
                    for (int cx = 0; cx < uio.size(); cx++) {
                        ssde=ssde+1;
                        new DownloadFileFromURL(view.getContext(), uio.get(cx).getKeyValue()).execute(
                                  uio.get(cx).getKeyValue()
                                ,String.valueOf(cx)
                                ,String.valueOf(ssde),
                                String.valueOf(uio.size()));  //(urlsecript);
                    }


                } else {


                }

                try {



                    ht = String.format(ht, data);
                    if (useerroe) {
                        urlmerreo = String.format(urlmerreo, data);
                    }
                } catch (Exception ex) {


                }


                final String urlmerreoo = urlmerreo;
                final boolean n = false;
                final boolean useerror = useerroe;


                final EventProcessor uuip = new EventProcessor() {
                    @Override
                    public void setOnEventListener(View view, Value value) {

                    }

                    @Override
                    public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
                        super.triggerAdapter(typ, withtage, Tagv, event, value, view);
                    }

                    @Override
                    public void trigger(boolean withtage, String Tagv, String event, Value value, ProteusView view) {
                        super.trigger(withtage, Tagv, event, value, view);
                    }

                    @Override
                    public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view, EventProcessor proces, String[] somedsta) {
                        super.triggerAdapter(typ, withtage, Tagv, event, value, view, proces, somedsta);
                    }
                };
                ProteusView.Manager.ActionEventView Actv = new ProteusView.Manager.ActionEventView() {
                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

//Log.i("")

                        if(typ==12600){
                            try {

                             //   Log.e("fff","ffffffffff");
                                final hedaerOrQuary ddertt = ( hedaerOrQuary) anotherdata;
                                final Gson gd = view.getViewManager().getContext().getJson();
                                final Type type = new TypeToken<Value>() {

                                }.getType();
                                Handler uih=new Handler(Looper.getMainLooper());
                                uih.post(new Runnable() {
                                    @Override
                                    public void run() {
                                      try {
                                          ObjectValue tempp = gd.fromJson(ddertt.getKeyValue(), type);
                                          view.getViewManager().getContext().getAllEven(ddertt.getKeyName()).call(view.getContext(), view.getViewManager().getContext().getActvityAllt(),
                                                  tempp, 0, view);
                                      }catch (Exception ex){
                                       //   Log.e("fff","ffffffffffmm"+ex.getMessage());
                                      }
                                      }
                                });

                            }catch (Exception ex){
                              //  Log.e("fff","ffffffffff"+ex.getMessage());
                            }
                            }
                       else if(typ==1600){
                            view.loadUrl("javascript:" + anotherdata.toString().replace('#','"'));

                        }else {

                            uuip.triggerAdapter(20, false, anotherdata.toString(), "h", null, (ProteusView) view);
                        }
                    }

                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {


                        if(typ==8000){

                            Intent intent = new Intent(view.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                            // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("data", anotherdata);
                            view.getViewManager().getContext().getActvityAllt().startActivity(intent);
                            //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                        }
                       else if(typ==7000){

                            String datee=dfr+"(\""+anotherdata+"\")";

                            view.loadUrl("javascript:" + datee);
                          //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                        }
                        else if(typ==178000){

                            // String datee=dfr+"(\""++"\")";

                            view.evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", null);
                            //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                        }

                        else if(typ==78000){

                           // String datee=dfr+"(\""++"\")";

                            view.loadUrl("javascript:" + anotherdata);
                            //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                        }
                       else if(typ==1700){
                            view.loadUrl("javascript:" + anotherdata.replace('#','"'));

                        }else
                        if(typ==1600){
                            view.loadUrl("javascript:" + anotherdata.replace('#','"'));

                        }else {
                            boolean kjj = anotherdata.startsWith("[");
                            String ggvc = kjj ? anotherdata : "[" + anotherdata + "]";
                            String k = "{s1:" + ggvc + "}";
                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(view.getContext());
                            Gson gsonn = new GsonBuilder()
                                    .registerTypeAdapterFactory(adapter)
                                    .create();
                            Type type = new TypeToken<Value>() {

                            }.getType();
                            Value tempp = gsonn.fromJson(k, type);

//Gson u=new Gson();
                            //  String vcc=u.toJson(tempp.getAsObject());
                            uuip.trigger(true, "WebView", "myWeb", tempp.getAsObject(), (ProteusView) view);
                        }

                    }

                    @Override
                    public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                }

                    @Override
                    public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                    }
                };
                ((ProteusWebView) view).getViewManager().setActionEventView(Actv);

                view.addJavascriptInterface(new JavaScript_and_Java(view.getContext(),Actv,view), "Android");


             //   view.setDownloadListener(new );
                AdvancedWebView.Listener t = new AdvancedWebView.Listener() {
                    @Override
                    public void onPageStarted(String url, Bitmap favicon) {
                        if(layouu!=null){
                            layouu.startWating();
                        }
                       // view.getLinwting().setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onPageFinished(String url) {
                        view.setHaserror(false);

                        try {
                            String v = WhenfinishEventr.get("Event_Type").getAsString();
                            view.getViewManager().getContext().getAllEven(v).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), WhenfinishEventr, 0, view, view.getViewManager().getDataContext().getData());
                        }catch (Exception ex){

                        }
                        if(layouu!=null){
                            layouu.Stopwa();//.startWating();
                        }
                      /* view.getLinwting().setVisibility(View.GONE);

                        if(view.getErrorView()!=null){
                            view.getErrorView().getAsView().setVisibility(View.GONE);
                        }*/
                       // view.setVisibility(View.VISIBLE);
                        //boxx.hideAll();
                    }

                    @Override
                    public void onPageError(int errorCode, String description, String failingUrl) {
                        if(layouu!=null){
                            layouu.showError(description);//.startWating();
                        }
                   try {
                       String v = Whenerrorr.get("Event_Type").getAsString();
                       view.getViewManager().getContext().getAllEven(v).call(view.getAsView().getContext(), view.getViewManager().getContext().getActvityAllt(), Whenerrorr, 0, view, view.getViewManager().getDataContext().getData());
                   }catch (Exception ex){

                   }
                        view.setHaserror(true);
                        if (useerror) {
                           /* view.getLinwting().setVisibility(View.GONE);


                            // view.clearView();
                           if(view.getErrorView()!=null){
                               view.getErrorView().getAsView().setVisibility(View.VISIBLE);
                           }*/
                           //  view.setVisibility(View.GONE);
                            ((ProteusWebView) view).loadHtml(urlmerreoo);
                            // super.onReceivedError(view, request, error);
                        }

                        // Log.i("090","gggggmmmmmm");
                    }

                    @Override
                    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
                    //    AdvancedWebView.handleDownload(view.getContext(),url,suggestedFilename);
                       // final long begin1 = SystemClock.elapsedRealtime();
                        //com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl.getImpl()
                        final long begin = SystemClock.elapsedRealtime();
                     final String chinalid="55";
                        showHeadsUpNotification("Starting",chinalid,view.getContext());
                      //  DownloadNotifier ff=;

                        DownloadImpl.with(view.getContext())
                                .url(url)//.setForceDownload(true)
                                .enqueue(new DownloadListenerAdapter() {
                                    @Override
                                    public void onProgress(String url, long downloaded, long length, long usedTime) {
                                        super.onProgress(url, downloaded, length, usedTime);
                                      //  showHeadsUpNotification("Downloading....",view.getContext());
                                        //                        Log.i(TAG, " progress:" + downloaded + " url:" + url);
                                    }

                                    @Override
                                    public boolean onResult(Throwable throwable, Uri path, String url, Extra extra) {
                                        showHeadsUpNotification("Compated"+ path.getPath(),chinalid,view.getContext());
                                       // Log.i("888", " path:" + path + " url:" + url + " length:" + new File(path.getPath()).length());
                                      //  Log.i("888", " DownloadImpl time:" + (SystemClock.elapsedRealtime() - begin) + " length:" + new File(path.getPath()).length());
                                        //run3();
                                        return super.onResult(throwable, path, url, extra);
                                    }
                                });

                      /*  DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                        request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType));
                        request.setDescription("Downloading file...");
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimeType));
                        DownloadManager dm = (DownloadManager) view.getAsView().getContext().getSystemService(DOWNLOAD_SERVICE);
                        dm.enqueue(request);
                        Toast.makeText(view.getAsView().getContext().getApplicationContext(), "Downloading...", Toast.LENGTH_SHORT).show();

                        BroadcastReceiver onComplete = new BroadcastReceiver() {
                            @Override
                            public void onReceive(Context context, Intent intent) {
                                Toast.makeText(view.getAsView().getContext().getApplicationContext(), "Downloading Complete", Toast.LENGTH_SHORT).show();
                            }

                            //   view.getAsView().getContext().getApplicationContext().startActivity(f);


                        };

                        view.getAsView().getContext().registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));

*/
                      /*  String vbb="data:application/pdf;base64,";
                        if (url.startsWith("data:")) {  //when url is base64 encoded data
                            String path = createAndSaveFileFromBase64Url(url,view.getContext());
                            return;
                        }

                        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                        request.setMimeType(mimeType);
                        String cookies = CookieManager.getInstance().getCookie(url);
                        request.addRequestHeader("cookie", cookies);
                        request.addRequestHeader("User-Agent", userAgent);
                        request.setDescription("download file");
                        String filename = URLUtil.guessFileName(url, contentDisposition, mimeType);
                        request.setTitle(filename);
                        request.allowScanningByMediaScanner();
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, filename);
                        DownloadManager dm = (DownloadManager) view.getAsView().getContext().getSystemService(DOWNLOAD_SERVICE);
                        dm.enqueue(request);

                        showStandardNotification("Start download.....",view.getContext());

                    */

                       // Toast.makeText(view.getAsView().getContext(), "يتم", Toast.LENGTH_LONG).show();
                       /* Intent intenttvfxg=new Intent( view.getAsView().getContext(),com.astooltech.advancedview.diff_pri.diff_show_only_pdf.class);
                        intenttvfxg.putExtra("name",fb);

                        view.getAsView().getContext().startActivity(intenttvfxg);*/
                    }

                    public void showStandardNotification(String te,Context conn) {

                        int notificationId = new Random().nextInt();

                        Intent intent = new Intent(conn, NotificationActivity.class);
                        PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);
                        RemoteViews b=new RemoteViews("h",R.layout.recycler_animator_expandable_item);

                        NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                                "Notification", te, R.drawable.ic_notifications, pIntent);

                        NotificationHelper.showNotification(conn, notificationId, notification.build());

                    }

                    public void showHeadsUpNotification(String te,String chnlid,Context c) {


                        NotificationManager notificationManager = (NotificationManager)c.getSystemService(NOTIFICATION_SERVICE);
                        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(c);
                        NotificationCompat.Builder builder = null;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            int importance = NotificationManager.IMPORTANCE_HIGH;
                            NotificationChannel notificationChannel = new NotificationChannel(chnlid, "Astoolntofi",importance);

                            notificationChannel.setShowBadge(true);
                            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                            notificationManager.createNotificationChannel(notificationChannel);
                            builder = new NotificationCompat.Builder(c, notificationChannel.getId()).setSmallIcon(R.drawable.ic_notifications);


                        } else {
                            builder = new NotificationCompat.Builder(c);
                        }
                        builder.setContentTitle(te+" downloading..")
                                .setContentText(te)
                                .setPriority(NotificationCompat.PRIORITY_HIGH);
                        notificationManagerCompat.notify(1,builder.build());
            }
                    public String createAndSaveFileFromBase64Url(String url,Context c) {
                       try {
                           String filetype = url.substring(url.indexOf("/") + 1, url.indexOf(";"));
                           String filename = System.currentTimeMillis() + "." + filetype;
                           File file = new File(Environment.getExternalStorageDirectory(), GlobalClass.fileDIRECTORY +"/"+filename);

                           try {
                               if (file.exists())
                                   file.mkdirs();
                               if (!file.exists())
                                   file.createNewFile();

                               String base64EncodedString = url.substring(url.indexOf(",") + 1);
                               byte[] decodedBytes = Base64.decode(base64EncodedString, Base64.DEFAULT);
                               OutputStream os = new FileOutputStream(file);
                               os.write(decodedBytes);
                               os.close();

                               //Tell the media scanner about the new file so that it is immediately available to the user.
                               MediaScannerConnection.scanFile(c,
                                       new String[]{file.toString()}, null,
                                       new MediaScannerConnection.OnScanCompletedListener() {
                                           public void onScanCompleted(String path, Uri uri) {


                                               Log.i("ExternalStorage", "Scanned " + path + ":");
                                               Log.i("ExternalStorage", "-> uri=" + uri);
                                           }
                                       });
                               showStandardNotification(file.getAbsolutePath(),c);
                               //Set notification after download complete and add "click to view" action to that
                             /*  String mimetype = url.substring(url.indexOf(":") + 1, url.indexOf("/"));
                               Intent intent = new Intent();
                               intent.setAction(android.content.Intent.ACTION_VIEW);
                               intent.setDataAndType(Uri.fromFile(file), (mimetype + "/*"));
                               PendingIntent pIntent = PendingIntent.getActivity(c, 0, intent, 0);

                               Notification notification = new NotificationCompat.Builder(c)
                                       .setSmallIcon(R.mipmap.ic_launcher)
                                       .setContentText("vvv")
                                       .setContentTitle(filename)
                                       .setContentIntent(pIntent)
                                       .build();

                               notification.flags |= Notification.FLAG_AUTO_CANCEL;
                               int notificationId = 85851;
                               NotificationManager notificationManager = (NotificationManager) c.getSystemService(Context.NOTIFICATION_SERVICE);
                               notificationManager.notify(notificationId, notification);
                         */

                           } catch (IOException e) {
                               Log.w("ExternalStorage", "Error writing " + file, e);
                               Toast.makeText(c, "error", Toast.LENGTH_LONG).show();
                           }

                           return file.toString();
                       }catch (Exception ex){

                       }

                       return "no";
                    }
                    private void checkDownloadPermission(Context c) {
                       /* if (c.getApplicationContext().shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            Toast.makeText(c, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                        }*/
                    }
                    @Override
                    public void onExternalPageRequest(String url) {
                       // DownloadTask dd=new DownloadTask();
                      //  dd.
                    }

                    @Override
                    public void openFileChosser(Intent intent, ValueCallback<Uri> fileUploadCallbackFirst, ValueCallback<Uri[]> fileUploadCallbackSecond) {
                        try {
                            PendingIntent pendingIntent = PendingIntent.getActivity(view.getAsView().getContext(), 0, intent, 0);

                            com.astooltech.advancedview.inlineactivityresult.request.Request request = RequestFabric.create(pendingIntent.getIntentSender(), null, 0, 0, 0, null);

                            myMethod(request, fileUploadCallbackFirst, fileUploadCallbackSecond);
                        }catch (Exception exm){
                            Log.e("7788", exm.getMessage());
                        }
                    }


                    private void myMethod(com.astooltech.advancedview.inlineactivityresult.request.Request request, final ValueCallback<Uri> fileUploadCallbackFirst,  ValueCallback<Uri[]> fileUploadCallbackSecond) {
                        final    ValueCallback<Uri[]> fileUploadCallbackSecondd=fileUploadCallbackSecond;
                        new InlineActivityResult(view.getViewManager().getContext().getActvityAllt())
                                .startForResult(request, new ActivityResultListener() {

                                    @Override
                                    public void onSuccess(com.astooltech.advancedview.inlineactivityresult.Result result) {
                                        //Uri extras = result.getData().getData();//.getData().getExtras();

                                        //int resultCode = result.getRequestCode();//.resultCode();


                                        // Uri contentURI = ;
                                        try {
                                            Intent  intent=result.getData();
                                            // Log.e("7788", "ggggggghhhhhhhhhhggg");
                                            if (intent != null) {
                                                if (fileUploadCallbackFirst != null) {
                                                    //   Log.e("7788", "ggggggghhhhhhhhhhggg");
                                                    fileUploadCallbackFirst.onReceiveValue(intent.getData());
                                                    //fileUploadCallbackFirst = null;
                                                }
                                                else if (fileUploadCallbackSecondd != null) {
                                                    Uri[] dataUris = null;
                                                    // Log.e("7788", "ggggggghhhhhhhhhhggg");
                                                    try {
                                                        if (intent.getDataString() != null) {
                                                            dataUris = new Uri[] { Uri.parse(intent.getDataString()) };
                                                        }
                                                        else {
                                                            if (Build.VERSION.SDK_INT >= 16) {
                                                                if (intent.getClipData() != null) {
                                                                    final int numSelectedFiles = intent.getClipData().getItemCount();

                                                                    dataUris = new Uri[numSelectedFiles];

                                                                    for (int i = 0; i < numSelectedFiles; i++) {
                                                                        dataUris[i] = intent.getClipData().getItemAt(i).getUri();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    catch (Exception ignored) {
                                                        //   Log.e("778hh8", ignored.getMessage());
                                                    }

                                                    fileUploadCallbackSecondd.onReceiveValue(dataUris);

                                                }
                                            }
                                        } catch (Exception e) {
                                            Log.e("7788", e.getMessage());
                                            //Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                                        }

                                    }

                                    @Override
                                    public void onFailed(com.astooltech.advancedview.inlineactivityresult.Result result) {
                                        /// Log.e("7788", "gggggggggg");
                                    }
                                });
                    }

                };

                boolean useback = value.getAsObject().getAsBoolean("enab_back");

                final ProteusWebView ffm = (ProteusWebView) view;
              /*  if (useback) {
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                    view.requestFocus();
*/

                    //    ((Activity)view.getContext()..getApplicationContext())
                    view.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View view, int i, KeyEvent keyEvent) {
                            if (i == KeyEvent.KEYCODE_BACK) {
                              if(!ffm.isHaserror()) {

                                  if (ffm.canGoBack()) {
                                      ffm.goBack();
return true;
                                  } else {
                                    //  ffm.getViewManager().getContext().getActvityAllt().set
                                    //  ffm.getViewManager().
                                      return false;
                                  }
                              }else{

                                  return  false;
                              }
                            }
                            return  false;
                        }
                    });

                //}
                ((ProteusWebView) view).setListener(((ProteusWebView) view).getViewManager().getContext().getActvityAllt(),t,0,mPermissionInterceptor);
              //  DefaultDownloadImpl.create(ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteusActivity(),view,mPermissionInterceptor);

                //Log.i("ProteusEventWithTag", ht);
                view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                boolean scrollOntoch = value.getAsObject().getAsBoolean("scroll_On_touch");

                if (scrollOntoch) {

                    view.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {

                            return (motionEvent.getAction() == MotionEvent.ACTION_MOVE);
                        }
                    });
                }
                view.setLongClickable(value.getAsObject().getAsBoolean("enab_long_click"));
               try {
                   view.getSettings().setDomStorageEnabled(value.getAsObject().getAsBoolean("enab_stor_dom"));
               }catch (Exception  ex){

               }

                view.getSettings().setAllowContentAccess(true);
                view.getSettings().setAllowFileAccess(true);
                view.setVerticalScrollBarEnabled(value.getAsObject().getAsBoolean("scroll_V"));
                view.setHorizontalScrollBarEnabled(value.getAsObject().getAsBoolean("scroll_H"));
                view.getSettings().setLoadsImagesAutomatically(value.getAsObject().getAsBoolean("image_auto"));
                view.getSettings().setJavaScriptEnabled(value.getAsObject().getAsBoolean("enab_java"));
                view.getSettings().setUseWideViewPort(value.getAsObject().getAsBoolean("enab_port"));
                view.setDesktopMode(value.getAsObject().getAsBoolean("enab_desktop"));
                view.getSettings().setSupportMultipleWindows(value.getAsObject().getAsBoolean("enab_multiplwindow"));//.setLoadWithOverviewMode(true);
                view.getSettings().setLoadWithOverviewMode(value.getAsObject().getAsBoolean("enab_OverViewMode"));
                view.getSettings().setJavaScriptCanOpenWindowsAutomatically(value.getAsObject().getAsBoolean("enab_Open_window_Auto"));//.setJavaScriptEnabled(true);
                view.setCookiesEnabled(value.getAsObject().getAsBoolean("enab_cookies"));

                if (checkuse) {

                    view.loadUrl(urlm);
                } else {

                    view.loadHtml(ht, "file:///android_asset/", null, "UTF-8");

                }
final boolean checkusee=checkuse;
                final String urlmm=urlm;
                final String httx=ht;
                if(layou!=null){
                    if(layou.getCustomEventWenerror()==null) {
                        layou.setCustomEventWenerror(new layoutEventClick() {
                            @Override
                            public void A_showError_Layout(String message) {
                                if (checkusee) {

                                    view.loadUrl(urlmm);
                                } else {

                                    view.loadHtml(httx, "file:///android_asset/", null, "UTF-8");

                                }
                            }

                            @Override
                            public void A_showView_layout() {

                            }
                        });
                    }
                }
            }catch (Exception ex){

                Toast.makeText(view.getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
            }


        }
        public void loadfromfile(ProteusWebView view,String datak){
         /*   final String[] data = gethderOr(kj, view.getContext(), db_operations, usegetData, urlmk);
            view.reload();
            view.clearHistory();
            view.clearCache(true);
            view.clearFormData();
            view.loadHtml(datak, "file:///android_asset/", null, "UTF-8");
*/

        }
        public PermissionInterceptor mPermissionInterceptor = new PermissionInterceptor() {

            /**
             * PermissionInterceptor 能达到 url1 允许授权， url2 拒绝授权的效果。
             * @param url
             * @param permissions
             * @param action
             * @return true 该Url对应页面请求权限进行拦截 ，false 表示不拦截。
             */
            @Override
            public boolean intercept(String url, String[] permissions, String action) {
                // Log.i(TAG, "mUrl:" + url + "  permission:" + mGson.toJson(permissions) + " action:" + action);
                return false;
            }
        };
      @Override
      public void handleValue(final T view, Value value) {

        final ProteusWebView k=((ProteusWebView) view);
          EventProcessor uuipkp = new EventProcessor() {


              public void reloadss(String indexx,String valu){
                  //[Integer.parseInt(indexx)]=valu;
              }
              @Override
              public void setOnEventListener(View view, Value value) {

              }

              @Override
              public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
                  super.triggerAdapter(typ, withtage, Tagv, event, value, view);


              }

              @Override
              public void trigger(boolean withtage, String Tagv, String event, Value value, ProteusView view) {
                  super.trigger(withtage, Tagv, event, value, view);
                //  Log.e("ttttttttt","jjjjjjjjjjjjjjjjjjjjjjjj");
                  if(Tagv.equals("10000")) {
                     // Log.e("ttttttttt","jjjjjjjjjjjjjjjjjjjjjjjj");

                  }

              }

              @Override
              public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view, EventProcessor proces, String[] somedsta) {
                  super.triggerAdapter(typ, withtage, Tagv, event, value, view, proces, somedsta);
              }
          };
          runwebview(k, value);

        /*  boolean upda = value.getAsObject().getAsBoolean("update");
          Array htmlvalue = value.getAsObject().getAsArray("html_value");
          wendownload(uuipkp,upda,view.getContext(),htmlvalue,upda,k);*/

          //  makeToastOnUiThreadv(((ProteusWebView)view).getAsView().getContext(),((ProteusWebView)view),value);

      }


      public  List<hedaerOrQuary> getdata(String Datavalue){

          Datavalue = Datavalue.replace('#', '"');
          Gson hnb = new Gson();
          Type type = new TypeToken<List<hedaerOrQuary>>() {

          }.getType();
          List<hedaerOrQuary> hedde = hnb.fromJson(Datavalue, type);

          return hedde;
      }
        public String[]  gethderOr( List<hedaerOrQuary> hedde,Context con, DatabaseHelper db_operations,boolean usegetdata,String getdataa){
            String[] str=null;
            try {
               // Datavalue = Datavalue.replace('#', '"');
                Gson hnb = new Gson();
                Type type = new TypeToken<List<hedaerOrQuary>>() {

                }.getType();
              //  List<hedaerOrQuary> hedde = hnb.fromJson(Datavalue, type);

                if(usegetdata){

                    getdataa = getdataa.replace('#', '"');
                  //  Gson hnb = new Gson();

                    List<hedaerOrQuary> hedded = hnb.fromJson(getdataa, type);
                    for (int cx = 0; cx < hedded.size(); cx++) {
                        hedde.add(hedded.get(cx));
                    }

                }


                str=new String[hedde.size()];
                for (int cx = 0; cx < hedde.size(); cx++) {
                    String typ= hedde.get(cx).getKeyType().toLowerCase();
                    if(typ.equals("apikey")){
                        String kk=getdatafrom("acesstoken",con);
                        hedde.get(cx).setKeyValue(kk);

                    }
                    if(typ.equals("qmark")){
                       char mar='"';

                        hedde.get(cx).setKeyValue(String.valueOf(mar));

                    }
                    if(typ.toLowerCase().equals("percent")){
                        char mar='%';

                        hedde.get(cx).setKeyValue(String.valueOf(mar));

                    }
                    if(typ.equals("htmltag")){
                        char mar='"';
                       // Log.i("999mm",hedde.get(cx).getKeyValue());
                        ScriptModel g=new ScriptModel(0,"00", hedde.get(cx).getKeyValue());
                        List<ScriptModel>  h=  db_operations.getAllNotes(g);
                    String resu=    h.get(0).getContent();
                    if(resu.equals("")){
                        hedde.get(cx).setKeyValue(hedde.get(cx).getKeyValue());
                    }else {
                        hedde.get(cx).setKeyValue(h.get(0).getContent());
                    }
                       // int siz=h.get(0).getContent().length();
                       // Log.i("999mm",siz+"@@");

                    }
                    if(typ.equals("ID_device")){
                        String kk= GlobalClass.UserAppID;///getdatafrom("acesstoken");
                        hedde.get(cx).setKeyValue(kk);

                    }
str[cx]=hedde.get(cx).getKeyValue();
                }
                //  serchhviewByheader(showdaloge ? datadaloge : container, hedde);


                //  List<hedaerOrQuary> dataa=gethderOr(apiheder);


                return str;
            }catch (Exception ex){
                return   str;
            }

        }
      private String getdatafrom(String textt,Context c){

        SharedPreferences settings =c.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
          return "NO";
        }else {
          return mpp;
        }


      }
      @Override
      public void handleResource(T view, Resource resource) {
        throw new IllegalArgumentException("children cannot be a resource");
      }

      @Override
      public void handleAttributeResource(T view, AttributeResource attribute) {
        throw new IllegalArgumentException("children cannot be a resource");
      }

      @Override
      public void handleStyleResource(T view, StyleResource style) {
        throw new IllegalArgumentException("children cannot be a style attribute");
      }




      class DownloadFileFromURL extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Bar Dialog
         * */
        @Override
        protected void onPreExecute() {
          super.onPreExecute();
          //showDialog(progress_bar_type);
        }
        Context c;
        String uurl;
         // EventProcessor actw;
        public  DownloadFileFromURL(Context con,String uurl){
          this.uurl=uurl;
          this.c=con;

        }

        /**
         * Downloading file in background thread
         * */



        private void saveresult(String results){
            ScriptModel g=new ScriptModel(0,results,uurl);
            DatabaseHelper db_operations;
            db_operations=new DatabaseHelper(c);

    db_operations.insert(g);
//}
        }

        private <T> ObservableTransformer<T, T> getDefaultTransformer() {
          return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
              return upstream.subscribeOn(Schedulers.io())
                      .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                         // mProgressDialog.show();
                        }
                      })
                      .subscribeOn(AndroidSchedulers.mainThread())
                      .observeOn(AndroidSchedulers.mainThread())
                      .doAfterTerminate(new Action() {
                        @Override
                        public void run() throws Exception {
                         // mProgressDialog.dismiss();
                        }
                      });
            }
          };
        }

        private Observer<ResponseBody> getDefaultObserver(final boolean update) {
          return new Observer<ResponseBody>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ResponseBody response) {
              try {

                // if(response)
                String string = response.string();
                  saveresult(string);

                //showResult(string);

                //Log.i("test", string);
               // showResult(string);
              } catch (IOException e) {
                e.printStackTrace();
              }
            }

            @Override
            public void onError(Throwable throwable) {
              throwable.printStackTrace();
            //  showResult(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
          };
        }
        @Override
        protected String doInBackground(String... f_url) {
          int count;
          String TAG="9988";
          try {

            HttpUrl httpUrl = RetrofitUrlManager.getInstance().fetchDomain(DOUBAN_DOMAIN_NAME);
            if (httpUrl == null || !httpUrl.toString().equals(f_url[0])) { //可以在 App 运行时随意切换某个接口的 BaseUrl
              RetrofitUrlManager.getInstance().putDomain(DOUBAN_DOMAIN_NAME, f_url[0]);
            }
            String getvalu1=f_url[2];
            String ddf=f_url[3];
            boolean uut=false;
            if(getvalu1.equals(ddf)){
                uut=true;
            }

            NetWorkManager
                    .getInstance()
                    .getThreeApiService()
                    .getUsers(f_url[0])
                    .compose(this.<ResponseBody>getDefaultTransformer())
                    .subscribe(getDefaultObserver(uut));


            //  final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);

          }catch (Exception ex){

          }

          return null;
        }

        /**
         * Updating progress bar
         * */
        protected void onProgressUpdate(String... progress) {
          // setting progress percentage
          //  pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        @Override
        protected void onPostExecute(String file_url) {

         // Log.i("998899",uurl+"hhhhhhhhhhhhhhhhhhhhhhhhhh"+file_url);
          // dismiss the dialog after the file was downloaded
          //  dismissDialog(progress_bar_type);

        }

      }
    });

    addAttributeProcessor(Attributes.WebView.HTML, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.loadData(value, "text/html", "UTF-8");
      }
    });
  }
}
