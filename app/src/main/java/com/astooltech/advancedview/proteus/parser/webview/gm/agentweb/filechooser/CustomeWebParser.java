package com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.inlineactivityresult.request.RequestFabric;
import com.astooltech.advancedview.proteus.parser.NotificationActivity;
import com.astooltech.advancedview.proteus.parser.NotificationHelper;
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
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;
import com.astooltech.advancedview.proteus.parser.webview.gm.JavaScript_and_Java;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AbsAgentWebSettings;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWeb;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebConfig;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.DefaultDownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.DefaultWebClient;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.IAgentWebSettings;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.MiddlewareWebChromeBase;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.MiddlewareWebClientBase;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.PermissionInterceptor;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.WebListenerManager;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.WebViewClient;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadListenerAdapter;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Extra;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.ResourceRequest;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.retrofiturlmanager.NetWorkManager;
import com.astooltech.advancedview.proteus.retrofiturlmanager.RetrofitUrlManager;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProteusWebView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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

import static android.content.Context.DOWNLOAD_SERVICE;
import static com.astooltech.advancedview.proteus.retrofiturlmanager.api.Api.DOUBAN_DOMAIN_NAME;


public class CustomeWebParser<T extends LinearLayout> extends ViewTypeParser<T> {


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
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
        return "WebLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {
        return new CustomeWeb(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {



        addAttributeProcessor("DataUrl", new AttributeProcessor<T>() {

            public void adjustResizeOnGlobalLayout(final int boton,final AgentWeb v,final View cont,final View Docereview,final Context c) {
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
                            cont.setPadding(cont.getPaddingLeft(), cont.getPaddingTop(), cont.getPaddingRight(), paddingBottom);
                        } else {
                            // soft keyboard shown/hidden and padding changed
                            if (paddingBottom != 0) {
                                // soft keyboard shown, scroll active element into view in case it is blocked by the soft keyboard



                                ((WebView)v.getWebCreator().getWebView()).evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", null);
                                //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                                //  v.getViewManager().getContext().getParser("WebView").ReceveSearch("0","0");

                            }
                        }
                    }
                });
            }

            @Override
                    public void handleValue(final T view, Value value) {



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
                        // String[] urlsecript = value.getAsObject().getAsString("m_urls").split("#");
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


                        List<hedaerOrQuary> uio = new ArrayList<>();
                        for (int cx = 0; cx < kj.size(); cx++) {
                            String typ = kj.get(cx).getKeyType().toLowerCase();

                            if (typ.equals("htmltag")) {

                                String val = kj.get(cx).getKeyValue();
                                hedaerOrQuary i = new hedaerOrQuary("0", val, "0", "0");
                                uio.add(i);

                            }
                            //  hedde.add(hedded.get(cx));
                        }

                        // Log.i("090",urlmk);
                        //  String[]  css = value.getAsObject().getAsString("m_urlCss").split("#");
                        if (upda) {
                            for (int cx = 0; cx < uio.size(); cx++) {

                                new DownloadFileFromURL(view.getContext(), uio.get(cx).getKeyValue()).execute(uio.get(cx).getKeyValue());  //(urlsecript);
                            }


                        } else {

   /* DatabaseHelper db_operations;
    db_operations=new DatabaseHelper(view.getContext());
    for (int cx = 0; cx < urlsecript.length; cx++) {
        ScriptModel g=new ScriptModel(0,"00",urlsecript[cx]);
     List<ScriptModel>  h=  db_operations.getAllNotes(g);
        showResult(h.get(0).getContent(),view.getContext());
    }*/
                        }

                        try {
                            DatabaseHelper db_operations = new DatabaseHelper(view.getContext());
                            String[] data = gethderOr(kj, view.getContext(), db_operations, usegetData, urlmk);


                            ht = String.format(ht, data);
                            if (useerroe) {
                                urlmerreo = String.format(urlmerreo, data);
                            }
                        } catch (Exception ex) {


                        }

if(checkuse){
    ht=urlm;
}

                        final String urlmerreoo = urlmerreo;
                        final boolean n = false;
                        final boolean useerror = useerroe;
                    // String urll=value.getAsObject().get("uurl").getAsString();
                        AgentWeb mAgentWeb=null;
                        IAgentWebSettings yu=     getSettings(value,((CustomeWeb)view).getViewManager().getContext().getActvityAllt());

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


                         final AgentWeb finalMAgentWeb = mAgentWeb;
                        mAgentWeb     = AgentWeb.with(((CustomeWeb)view).getViewManager().getContext().getActvityAllt())//
                                .setAgentWebParent((LinearLayout) view, -1, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))//传入AgentWeb的父控件。
                                .useDefaultIndicator(-1, 3)//设置进度条颜色与高度，-1为默认值，高度为2，单位为dp。
                                .setAgentWebWebSettings(yu)//设置 IAgentWebSettings。
                                .setWebViewClient(mWebViewClient)//WebViewClient ， 与 WebView 使用一致 ，但是请勿获取WebView调用setWebViewClient(xx)方法了,会覆盖AgentWeb DefaultWebClient,同时相应的中间件也会失效。

                                .setContext(view.getContext())
                                .setWebChromeClient(new CommonWebChromeClient()) //WebChromeClient
                                .setPermissionInterceptor(mPermissionInterceptor) //权限拦截 2.0.0 加入。
                                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK) //严格模式 Android 4.2.2 以下会放弃注入对象 ，使用AgentWebView没影响。
                                .setAgentWebUIController(new UIController(((CustomeWeb) view).getViewManager().getContext().getActvityAllt())) //自定义UI  AgentWeb3.0.0 加入。
                              .setView((CustomeWeb)view)
                                .setMainFrameErrorView(R.layout.agentweb_error_page, -1) //参数1是错误显示的布局，参数2点击刷新控件ID -1表示点击整个布局都刷新， AgentWeb 3.0.0 加入。
                                .useMiddlewareWebChrome(getMiddlewareWebChrome()) //设置WebChromeClient中间件，支持多个WebChromeClient，AgentWeb 3.0.0 加入。
                              //  .additionalHttpHeader(getUrl(urll), "cookie", "41bc7ddf04a26b91803f6b11817a5a1c")
                                .useMiddlewareWebClient(getMiddlewareWebClient()) //设置WebViewClient中间件，支持多个WebViewClient， AgentWeb 3.0.0 加入。
                                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他页面时，弹窗质询用户前往其他应用 AgentWeb 3.0.0 加入。
                                .interceptUnkownUrl() //拦截找不到相关页面的Url AgentWeb 3.0.0 加入。
                                .createAgentWeb()//创建AgentWeb。
                                .ready().goWith(checkuse,ht, "file:///android_asset/", null, "UTF-8");
                               // .goWith(checkuse,ht, "file:///android_asset/", null, "UTF-8");
                      mAgentWeb.clearWebCache();
                                //(getUrl(urll)); //WebView载入该url地址的页面并显示。

                      /*  AgentWeb.PreAgentWeb ff=new AgentWeb.PreAgentWeb();
                        ff.*/





                        AgentWebConfig.debug();
                        //mAgentWeb.getWebCreator().getWebView()  获取WebView .
                        // AgentWeb 没有把WebView的功能全面覆盖 ，所以某些设置 AgentWeb 没有提供 ， 请从WebView方面入手设置。
                        mAgentWeb.getWebCreator().getWebView().setOverScrollMode(WebView.OVER_SCROLL_NEVER);

                        mAgentWeb.getWebCreator().getWebView().setVerticalScrollBarEnabled(value.getAsObject().getAsBoolean("scroll_V"));
                        mAgentWeb.getWebCreator().getWebView().setHorizontalScrollBarEnabled(value.getAsObject().getAsBoolean("scroll_H"));
                        mAgentWeb.getWebCreator().getWebView().getSettings().setLoadsImagesAutomatically(value.getAsObject().getAsBoolean("image_auto"));
                        mAgentWeb.getWebCreator().getWebView().getSettings().setJavaScriptEnabled(value.getAsObject().getAsBoolean("enab_java"));
                        mAgentWeb.getWebCreator().getWebView().getSettings().setUseWideViewPort(value.getAsObject().getAsBoolean("enab_port"));
                    //    mAgentWeb.getWebCreator().getWebView().setDesktopMode(value.getAsObject().getAsBoolean("enab_desktop"));
                        mAgentWeb.getWebCreator().getWebView().getSettings().setSupportMultipleWindows(value.getAsObject().getAsBoolean("enab_multiplwindow"));//.setLoadWithOverviewMode(true);
                        mAgentWeb.getWebCreator().getWebView().getSettings().setLoadWithOverviewMode(value.getAsObject().getAsBoolean("enab_OverViewMode"));
                        mAgentWeb.getWebCreator().getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(value.getAsObject().getAsBoolean("enab_Open_window_Auto"));//.setJavaScriptEnabled(true);
                     //   mAgentWeb.getWebCreator().getWebView().getSettings().setCookiesEnabled(value.getAsObject().getAsBoolean("enab_cookies"));
                        ((CustomeWeb) view).getViewManager().setActionEventView(mAgentWeb.getEventt());


                try {
                    final    AgentWeb finalMAgentWebb=mAgentWeb;
                    final boolean dfrk = value.getAsObject().getAsBoolean("Use_KeyBoard");
                    final int dfrkk = value.getAsObject().getAsInteger("Use_KeyBoardB");
                    if (dfrk) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                adjustResizeOnGlobalLayout(dfrkk, finalMAgentWebb, view.getRootView(), view.getRootView(), view.getContext());
                                //view.getViewManager().getContext().adjustResizeOnGlobalLayout();
                            }
                        }, 100);
                    }
                }catch (Exception ex){

                }
                        //mAgentWeb.getWebCreator().getWebView()  获取WebView .

                     //   initView(view);

                    }

                    @Override
                    public void handleResource(T view, Resource resource) {

                    }

                    @Override
                    public void handleAttributeResource(T view, AttributeResource attribute) {

                    }

                    @Override
                    public void handleStyleResource(T view, StyleResource style) {

                    }
            public void runwebview(final ProteusWebView view, Value value){

                try {
                    boolean useerroe = value.getAsObject().getAsBoolean("use_error");
                    String ht = value.getAsObject().getAsString("m_html");
                    String urlm = value.getAsObject().getAsString("m_url");
                    String urlmk = "[]"; //value.getAsObject().getAsString("m_get_data");
                    String urlmerreo = value.getAsObject().getAsString("m_error");
                    String htmlvalue = value.getAsObject().getAsString("html_value");
                    boolean usegetData = false;
                    try {
                        usegetData = value.getAsObject().getAsBoolean("use_get_data");
                        urlmk = view.getTag(R.id.web_get_data).toString();
                    } catch (Exception ex) {

                    }
                    boolean checkuse = value.getAsObject().getAsBoolean("Use_Url");
                    boolean upda = value.getAsObject().getAsBoolean("update");
                    // String[] urlsecript = value.getAsObject().getAsString("m_urls").split("#");


                    List<hedaerOrQuary> kj = getdata(htmlvalue);
                    List<hedaerOrQuary> uio = new ArrayList<>();
                    for (int cx = 0; cx < kj.size(); cx++) {
                        String typ = kj.get(cx).getKeyType().toLowerCase();

                        if (typ.equals("htmltag")) {

                            String val = kj.get(cx).getKeyValue();
                            hedaerOrQuary i = new hedaerOrQuary("0", val, "0", "0");
                            uio.add(i);

                        }
                        //  hedde.add(hedded.get(cx));
                    }

                    // Log.i("090",urlmk);
                    //  String[]  css = value.getAsObject().getAsString("m_urlCss").split("#");
                    if (upda) {
                        for (int cx = 0; cx < uio.size(); cx++) {

                            new DownloadFileFromURL(view.getContext(), uio.get(cx).getKeyValue()).execute(uio.get(cx).getKeyValue());  //(urlsecript);
                        }


                    } else {

   /* DatabaseHelper db_operations;
    db_operations=new DatabaseHelper(view.getContext());
    for (int cx = 0; cx < urlsecript.length; cx++) {
        ScriptModel g=new ScriptModel(0,"00",urlsecript[cx]);
     List<ScriptModel>  h=  db_operations.getAllNotes(g);
        showResult(h.get(0).getContent(),view.getContext());
    }*/
                    }

                    try {
                        DatabaseHelper db_operations = new DatabaseHelper(view.getContext());
                        String[] data = gethderOr(kj, view.getContext(), db_operations, usegetData, urlmk);


                        ht = String.format(ht, data);
                        if (useerroe) {
                            urlmerreo = String.format(urlmerreo, data);
                        }
                    } catch (Exception ex) {


                    }


                    // ht=ht.replace('#','"');



       /* String []datresult=new String[urlsecript.length];

        for (int cxx = 0; cxx < datresult.length; cxx++) {
          try {
            datresult[cxx]= getdatafrom(urlsecript[cxx],view.getContext());


          }catch (Exception ex){

          }

          //Log.i("ProteusEventWithTag", allunit.get(cxx).getDataGet());
          //  Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
          // requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }*/
      /*  for (int cxx = urlsecript.length; cxx < (urlsecript.length+css.length); cxx++) {
          try {
            datresult[cxx]= getdatafrom(css[urlsecript.length-cxx],view.getContext());

          }catch (Exception ex){

          }


          //  Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
          // requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }*/

                    final String urlmerreoo = urlmerreo;
                    final boolean n = false;
                    final boolean useerror = useerroe;
                    //Log.i("ProteusEventWithTag", ht);
/*view.evaluateJavascript("hh", new ValueCallback<String>() {
    @Override
    public void onReceiveValue(String s) {

    }
});*/

//view.onPause();
                    //        ((Activity)view.getContext().getApplicationContext()).onBackPressed();


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
                            if(typ==1600){
                                view.loadUrl("javascript:" + anotherdata.toString().replace('#','"'));

                            }else {

                                uuip.triggerAdapter(20, false, anotherdata.toString(), "h", null, (ProteusView) view);
                            }
                        }

                        @Override
                        public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {

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

                    view.addJavascriptInterface(new JavaScript_and_Java(view.getContext(),Actv), "Android");

                    AdvancedWebView.Listener t = new AdvancedWebView.Listener() {
                        @Override
                        public void onPageStarted(String url, Bitmap favicon) {

                        }

                        @Override
                        public void onPageFinished(String url) {
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

                        private void myMethod(com.astooltech.advancedview.inlineactivityresult.request.Request request, final ValueCallback<Uri> fileUploadCallbackFirst, final ValueCallback<Uri[]> fileUploadCallbackSecond) {
                            new InlineActivityResult(view.getViewManager().getContext().getActvityAllt())
                                    .startForResult(request, new ActivityResultListener() {

                                        @Override
                                        public void onSuccess(com.astooltech.advancedview.inlineactivityresult.Result result) {
                                            //Uri extras = result.getData().getData();//.getData().getExtras();

                                            //int resultCode = result.getRequestCode();//.resultCode();


                                            // Uri contentURI = ;
                                            try {
                                                Intent  intent=result.getData();
                                                if (intent != null) {
                                                    if (fileUploadCallbackFirst != null) {
                                                        fileUploadCallbackFirst.onReceiveValue(intent.getData());
                                                        //fileUploadCallbackFirst = null;
                                                    }
                                                    else if (fileUploadCallbackSecond != null) {
                                                        Uri[] dataUris = null;

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
                                                            Log.e("778hh8", ignored.getMessage());
                                                        }


                                                    }
                                                }
                                            } catch (Exception e) {
                                                Log.e("7788", e.getMessage());
                                                //Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                                            }

                                        }

                                        @Override
                                        public void onFailed(com.astooltech.advancedview.inlineactivityresult.Result result) {

                                        }
                                    });
                        }

                        @Override
                        public void onPageError(int errorCode, String description, String failingUrl) {
                            if (useerror) {
            /*view.setFocusable(false);
            view.setFocusableInTouchMode(false);
            view.requestFocus();*/
                                // view.clearView();
                                ((ProteusWebView) view).loadHtml(urlmerreoo);
                                // super.onReceivedError(view, request, error);
                            }

                            // Log.i("090","gggggmmmmmm");
                        }

                        @Override
                        public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
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
                            String vbb="data:application/pdf;base64,";
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
                            // Toast.makeText(view.getAsView().getContext(), "يتم", Toast.LENGTH_LONG).show();
                       /* Intent intenttvfxg=new Intent( view.getAsView().getContext(),com.astooltech.advancedview.diff_pri.diff_show_only_pdf.class);
                        intenttvfxg.putExtra("name",fb);

                        view.getAsView().getContext().startActivity(intenttvfxg);*/
                        }

                        public void showStandardNotification(String te, Context conn) {

                            int notificationId = new Random().nextInt();

                            Intent intent = new Intent(conn, NotificationActivity.class);
                            PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);

                            NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                                    "Notification", te, R.drawable.ic_notifications, pIntent);

                            NotificationHelper.showNotification(conn, notificationId, notification.build());

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

                        }
                    };

                    boolean useback = value.getAsObject().getAsBoolean("enab_back");

                    final ProteusWebView ffm = (ProteusWebView) view;
                    if (useback) {
                        view.setFocusable(true);
                        view.setFocusableInTouchMode(true);
                        view.requestFocus();


                        //    ((Activity)view.getContext()..getApplicationContext())
                        view.setOnKeyListener(new View.OnKeyListener() {
                            @Override
                            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                                if (i == KeyEvent.KEYCODE_BACK) {
                                    if (!ffm.onBackPressed()) {
                                        // ffm.


                                        //  Log.i("9999mm", "rrrrrrrrrr");
                                        return true;
                                    } else {

                                        return false;
                                    }
                                } else {
                                    // Log.i("9999", "rrrrrrrrrr");
                                    return false;
                                }
                            }
                        });

                    }
                    ((ProteusWebView) view).setListenerr(t, 0);
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
              /*  IndicatorController mIndicatorController =
                        (this.mIndicatorController == null) ?
                                IndicatorHandler.getInstance().inJectIndicator(mWebCreator.offer())
                                : this.mIndicatorController;
                DefaultChromeClient mDefaultChromeClient =
                        new DefaultChromeClient(ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteusActivity(),
                                this.mIndicatorController = mIndicatorController,
                                null, this.mIVideo = getIVideo(),
                                this.mPermissionInterceptor, mWebCreator.getWebView());*/
                    // view.setWebViewClient(mWebViewClient);//WebViewClient ， 与 WebView 使用一致 ，但是请勿获取WebView调用setWebViewClient(xx)方法了,会覆盖AgentWeb DefaultWebClient,同时相应的中间件也会失效。
                    view.setWebChromeClient(new WebChromeClient());
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


                    view.setWebViewClient(new android.webkit.WebViewClient() {
                                              @Override
                                              public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                                  super.onPageStarted(view, url, favicon);

                                              }

                                              @Override
                                              public void onPageFinished(WebView view, String url) {
                                                  super.onPageFinished(view, url);


                                              }


                                              @Override


                                              public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {


                                              }
                                          }

                    );

                    //  Log.i("99","ooooooo");
                    if (checkuse) {

                        view.loadUrl(urlm);
                    } else {

                        view.loadHtml(ht, "file:///android_asset/", null, "UTF-8");

                    }
                }catch (Exception ex){

                    Toast.makeText(view.getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }


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
                            hedde.get(cx).setKeyValue(h.get(0).getContent());
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
            protected MiddlewareWebClientBase getMiddlewareWebClient() {
                MiddlewareWebClientBase mMiddleWareWebClient;
                return mMiddleWareWebClient = new MiddlewareWebViewClient() {
                    /**
                     *
                     * @param view
                     * @param url
                     * @return
                     */
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                       // Log.e(TAG, "MiddlewareWebClientBase#shouldOverrideUrlLoading url:" + url);
				/*if (url.startsWith("agentweb")) { // 拦截 url，不执行 DefaultWebClient#shouldOverrideUrlLoading
					Log.i(TAG, "agentweb scheme ~");
					return true;
				}*/

                        if (super.shouldOverrideUrlLoading(view, url)) { // 执行 DefaultWebClient#shouldOverrideUrlLoading
                            return true;
                        }
                        // do you work
                        return false;
                    }

                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                      //  Log.e(TAG, "MiddlewareWebClientBase#shouldOverrideUrlLoading request url:" + request.getUrl().toString());
                        return super.shouldOverrideUrlLoading(view, request);
                    }


                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                        if (request.isForMainFrame() && error.getErrorCode() != -1) {
                            super.onReceivedError(view, request, error);
                        }
                    }
                };
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
                public  DownloadFileFromURL(Context con,String uurl){
                    this.uurl=uurl;
                    this.c=con;
                }
                public  void savetoref(String keyname,String kayval){
                    try {

                        SharedPreferences settings = c.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.remove(keyname);
                        editor.putString(keyname,kayval);
                        editor.commit();
                    }catch (Exception ex){
                        //   Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                /**
                 * Downloading file in background thread
                 * */



                private void saveresult(String results){
                    ScriptModel g=new ScriptModel(0,results,uurl);
                    DatabaseHelper db_operations;
                    db_operations=new DatabaseHelper(c);
         /* int cx=  results.length();
            int cou=2310170;
if(cx>=cou) {

    int fd=cx/2;
    String getsaize = results.length() + "@@" + uurl;

    String resultsss=results.substring(0,fd);
    ScriptModel gg=new ScriptModel(0,resultsss,uurl);
    Log.i("9999",resultsss.length()+"@@"+ getsaize);
    db_operations.insert(gg);

}else {*/
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

                private Observer<ResponseBody> getDefaultObserver() {
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
                        // URL url = new URL();
                        //Log.i("998899",url.toString());
           /* StringBuilder out = new StringBuilder();
            Reader in = null;
            HttpURLConnection con = null;
            char[] buffer = new char[4096];
            try {
              URL u = new URL(f_url[0]);
              con = (HttpURLConnection) u.openConnection();
              con.setReadTimeout(5000);
              con.setRequestMethod("GET");
              con.setUseCaches(false);
              con.connect();
              InputStream is = con.getInputStream();
              in = new UnicodeReader(is, con.getContentEncoding());
              int bytesRead;
              while ((bytesRead = in.read(buffer, 0, 4096)) != -1) {
                if (bytesRead > 0) {
                  out.append(buffer, 0, bytesRead);
                }
              }
            } catch (MalformedURLException e) {
              Log.e(TAG, Log.getStackTraceString(e));
              return null;
            } catch (IOException e) {
              Log.e(TAG, Log.getStackTraceString(e));
              try {
                InputStream errorStream = con != null ? con.getErrorStream() : null;
                if (errorStream != null) {
                  in = new UnicodeReader(errorStream, null);
                  int bytesRead;
                  StringBuilder errorStr = new StringBuilder();
                  while ((bytesRead = in.read(buffer, 0, 4096)) != -1) {
                    if (bytesRead > 0) {
                      errorStr.append(buffer, 0, bytesRead);
                    }
                  }
                  in.close();
                  Log.e(TAG, errorStr.toString());
                }
              } catch (Exception ignored) {
              }
              return null;
            } catch (Exception e) {
              Log.e(TAG, Log.getStackTraceString(e));
              return null;
            } finally {
              try {
                if (in != null) {
                  in.close();
                }
              } catch (Exception ignored) {
              }
              if (con != null) {
                con.disconnect();
              }
            }

          //  Log.i("998899",out.toString());
            return out.toString();




            */


                        HttpUrl httpUrl = RetrofitUrlManager.getInstance().fetchDomain(DOUBAN_DOMAIN_NAME);
                        if (httpUrl == null || !httpUrl.toString().equals(f_url[0])) { //可以在 App 运行时随意切换某个接口的 BaseUrl
                            RetrofitUrlManager.getInstance().putDomain(DOUBAN_DOMAIN_NAME, f_url[0]);
                        }
                        NetWorkManager
                                .getInstance()
                                .getThreeApiService()
                                .getUsers(f_url[0])
                                .compose(this.<ResponseBody>getDefaultTransformer())
                                .subscribe(getDefaultObserver());


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
            protected PermissionInterceptor mPermissionInterceptor = new PermissionInterceptor() {

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

            protected MiddlewareWebChromeBase getMiddlewareWebChrome() {
                MiddlewareWebChromeBase mMiddleWareWebChrome;
                return mMiddleWareWebChrome = new MiddlewareChromeClient() {
                };
            }
            public IAgentWebSettings getSettings(final Value value, final Activity x) {
                return new AbsAgentWebSettings() {
                    private AgentWeb mAgentWeb;

                    @Override
                    protected void bindAgentWebSupport(AgentWeb agentWeb) {

                      // agentWeb.getAgentWebSettings().getWebSettings().
                        this.mAgentWeb = agentWeb;
                    }

                    /**
                     * AgentWeb 4.0.0 内部删除了 DownloadListener 监听 ，以及相关API ，将 Download 部分完全抽离出来独立一个库，
                     * AgentWeb 4.0.0 内部删除了 DownloadListener 监听 ，以及相关API ，将 Download 部分完全抽离出来独立一个库，
                     * 如果你需要使用 AgentWeb Download 部分 ， 请依赖上 compile 'com.download.library:Downloader:4.1.1' ，
                     * 如果你需要监听下载结果，请自定义 AgentWebSetting ， New 出 DefaultDownloadImpl
                     * 实现进度或者结果监听，例如下面这个例子，如果你不需要监听进度，或者下载结果，下面 setDownloader 的例子可以忽略。
                     * @param webView
                     * @param downloadListener
                     * @return WebListenerManager
                     */
                    @Override
                    public WebListenerManager setDownloader(final WebView webView, android.webkit.DownloadListener downloadListener) {
                        return super.setDownloader(webView,
                                new DefaultDownloadImpl(x,
                                        webView,
                                        this.mAgentWeb.getPermissionInterceptor()) {

                                    @Override
                                    protected ResourceRequest createResourceRequest(String url) {
                                        return DownloadImpl.getInstance(webView.getContext())
                                                .url(url)
                                                .quickProgress()
                                                .addHeader("", "")
                                                .setEnableIndicator(true)
                                                .autoOpenIgnoreMD5()
                                                .setRetry(5)
                                                .setBlockMaxTime(100000L);
                                    }

                                    @Override
                                    protected void taskEnqueue(ResourceRequest resourceRequest) {
                                        resourceRequest.enqueue(new DownloadListenerAdapter() {
                                            @Override
                                            public void onStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength, Extra extra) {
                                                super.onStart(url, userAgent, contentDisposition, mimetype, contentLength, extra);
                                            }

                                            @MainThread
                                            @Override
                                            public void onProgress(String url, long downloaded, long length, long usedTime) {
                                                super.onProgress(url, downloaded, length, usedTime);
                                            }

                                            @Override
                                            public boolean onResult(Throwable throwable, Uri path, String url, Extra extra) {
                                                return super.onResult(throwable, path, url, extra);
                                            }
                                        });
                                    }
                                });
                    }
                };
            }

            public String getUrl(String url) {
                String target = "";

                if (TextUtils.isEmpty(target = url)) {
                    target = "http://cw.gzyunjuchuang.com/";
                }
               return target;
            }

            protected WebViewClient mWebViewClient = new WebViewClient() {

                private HashMap<String, Long> timer = new HashMap<>();

                @Override
                public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    super.onReceivedError(view, request, error);
                }

                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    return super.shouldOverrideUrlLoading(view, request);
                }

                @Nullable
                @Override
                public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                    return super.shouldInterceptRequest(view, request);
                }

                //
                @Override
                public boolean shouldOverrideUrlLoading(final WebView view, String url) {

                    //   Log.i(TAG, "view:" + new Gson().toJson(view.getHitTestResult()));
                    //  Log.i(TAG, "mWebViewClient shouldOverrideUrlLoading:" + url);
                    //优酷想唤起自己应用播放该视频 ， 下面拦截地址返回 true  则会在应用内 H5 播放 ，禁止优酷唤起播放该视频， 如果返回 false ， DefaultWebClient  会根据intent 协议处理 该地址 ， 首先匹配该应用存不存在 ，如果存在 ， 唤起该应用播放 ， 如果不存在 ， 则跳到应用市场下载该应用 .
                    if (url.startsWith("intent://") && url.contains("com.youku.phone")) {
                        return true;
                    }
			/*else if (isAlipay(view, mUrl))   //1.2.5开始不用调用该方法了 ，只要引入支付宝sdk即可 ， DefaultWebClient 默认会处理相应url调起支付宝
			    return true;*/
                    return super.shouldOverrideUrlLoading(view, url);
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    // Log.i(TAG, "mUrl:" + url + " onPageStarted  target:" + getUrl());
                    timer.put(url, System.currentTimeMillis());
                    /*if (url.equals(getUrl())) {
                        pageNavigator(View.GONE);
                    } else {
                        pageNavigator(View.VISIBLE);
                    }*/
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);

                    if (timer.get(url) != null) {
                        long overTime = System.currentTimeMillis();
                        Long startTime = timer.get(url);
                        // Log.i(TAG, "  page mUrl:" + url + "  used time:" + (overTime - startTime));
                    }

                }
                /*错误页回调该方法 ， 如果重写了该方法， 上面传入了布局将不会显示 ， 交由开发者实现，注意参数对齐。*/
	   /* public void onMainFrameError(AbsAgentWebUIController agentWebUIController, WebView view, int errorCode, String description, String failingUrl) {

            Log.i(TAG, "AgentWebFragment onMainFrameError");
            agentWebUIController.onMainFrameError(view,errorCode,description,failingUrl);

        }*/

                @Override
                public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    super.onReceivedHttpError(view, request, errorResponse);

//			Log.i(TAG, "onReceivedHttpError:" + 3 + "  request:" + mGson.toJson(request) + "  errorResponse:" + mGson.toJson(errorResponse));
                }

                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                    super.onReceivedSslError(view, handler, error);
                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    super.onReceivedError(view, errorCode, description, failingUrl);

//			Log.i(TAG, "onReceivedError:" + errorCode + "  description:" + description + "  errorResponse:" + failingUrl);
                }
            };
                });
        addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }


            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });
        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringToFront();
                    view.invalidate();
                }

            }
        });


        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerDrawable(drawable);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerPadding((int) dimension);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    int dividerMode = ParseHelper.parseDividerMode(value);
                    // noinspection ResourceType
                    view.setShowDividers(dividerMode);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {
                view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
    }

}
