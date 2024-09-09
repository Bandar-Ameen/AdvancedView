package com.astooltech.advancedview.finaldemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.NotificationActivity;
import com.astooltech.advancedview.proteus.parser.NotificationHelper;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.typ_message;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;
import com.astooltech.advancedview.proteus.parser.webview.gm.JavaScript_and_Java;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.PermissionInterceptor;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadListenerAdapter;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Extra;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.retrofiturlmanager.NetWorkManager;
import com.astooltech.advancedview.proteus.retrofiturlmanager.RetrofitUrlManager;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusWebView;
import com.astooltech.advancedview.spinkit.sprite.Sprite;
import com.astooltech.advancedview.spinkit.style.Wave;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import com.astooltech.advancedview.R;
import static android.content.Context.NOTIFICATION_SERVICE;
import static com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom;
import static com.astooltech.advancedview.proteus.retrofiturlmanager.api.Api.DOUBAN_DOMAIN_NAME;

public class loginonlly {
private Context context;
private Gson gsonn;
private showlogin showload;
    AdvancedWebView viwsk;
    com.astooltech.advancedview.database.DatabaseHelper helper;
public loginonlly(Context context,showlogin showload){
    this.context=context;

this.showload=showload;
    helper=new DatabaseHelper(context);

    ProteusTypeAdapterFactory adapterk = new ProteusTypeAdapterFactory(this.context);
    gsonn  = new GsonBuilder()
            .registerTypeAdapterFactory(adapterk)
            .create();
}

private Value getvall(String val){
try {
    Type type = new TypeToken<Value>() {

    }.getType();
    Value tempp = gsonn.fromJson(val, type);
    return tempp;
}catch (Exception ex){

    return  new Primitive("bbbbb");
}
}

    public void adjustResizeOnGlobalLayout(final int b,final int boton,final AdvancedWebView v,final View cont,final View Docereview,final Context c) {
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



                      v.evaluateJavascript("if (document.activeElement) { document.activeElement.scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"}); }", null);
                        //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                        //  v.getViewManager().getContext().getParser("WebView").ReceveSearch("0","0");

                    }
                }
            }
        });
    }

    public void runwebview(final AdvancedWebView view,String getda){

        try {

            Log.e("h",getda);
            Value value= getvall(getda);
            try {
                final boolean dfrk = value.getAsObject().getAsBoolean("Use_KeyBoard");
                final int dfrkk = value.getAsObject().getAsInteger("Use_KeyBoardB");
                final int dfrkkt = value.getAsObject().getAsInteger("Use_KeyBoardT");
                if (dfrk) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            adjustResizeOnGlobalLayout(dfrkkt,dfrkk,view, view.getRootView(), view.getRootView(), view.getContext());
                            //view.getViewManager().getContext().adjustResizeOnGlobalLayout();
                        }
                    }, 100);
                }
            }catch (Exception ex){

            }

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
            // List<hedaerOrQuary> kj = getdata(htmlvalue);
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

                view.clearHistory();
                view.clearCache(true);
                view.clearFormData();
                // view.getSettings().
                for (int cx = 0; cx < uio.size(); cx++) {

                    new DownloadFileFromURL(view.getContext(), uio.get(cx).getKeyValue()).execute(uio.get(cx).getKeyValue());  //(urlsecript);
                }


            } else {

            }

            try {

                String[] data = gethderOr(kj, view.getContext(), usegetData, urlmk);


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

                   /* if(typ==12600){

                    }
                    else if(typ==1600){
                        view.loadUrl("javascript:" + anotherdata.toString().replace('#','"'));

                    }else {

                        uuip.triggerAdapter(20, false, anotherdata.toString(), "h", null, (ProteusView) view);
                    }*/
                }
                public  String setpashash(String pp){

                    // mess.customToast(MD5(pp).toUpperCase()+"@@@@"+MD5(MD5(pp).toUpperCase()));
                    String gg=getbase64(MD5(MD5(pp).toUpperCase()));
                    return  gg;
                }

                public  String getbase64(String textt){

                    String gg= org.apache.commons.codec.binary.Base64.encodeBase64String(textt.getBytes());
                    return gg;
                }
                public String MD5(String md5) {
                    try {
                        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                        byte[] array = md.digest(md5.getBytes("UTF-8"));
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < array.length; ++i) {
                            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                        }
                        return sb.toString();
                    } catch (java.security.NoSuchAlgorithmException e) {
                    } catch(UnsupportedEncodingException ex){
                    }
                    return null;
                }
                private  String getauthont(String usernames,String password){

                    String totl=usernames+":"+setpashash(password);
                    byte[] encodbyr= org.apache.commons.codec.binary.Base64.encodeBase64(totl.getBytes());
                    //Basic
                    String mm=new String(encodbyr);
                    String tott="Basic "+mm;
                    return  tott;

                }
                @Override
                public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {


                    if(typ==8000){

                        Type type = new TypeToken<Value>() {

                        }.getType();
                        Value tempp = gsonn.fromJson(anotherdata, type);

                     ObjectValue vc=   tempp.getAsObject();
                  String user=   vc.get("User_Name").getAsString();
                        String userx=   vc.get("User_Password").getAsString();
                        String usertype=   vc.get("User_Type").getAsString();
                        String useremail=   vc.get("User_Email").getAsString();
String   baseurl="0";
String urll="0";
                        String resuu=com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("aapi",context);
                        try {
                            String resul[] = GlobalClass.getBaseURL(resuu);
                            baseurl=resul[0];
                            urll=resul[1];
                        }catch (Exception ex){

                        }
                        new AsyncTaskRunner().execute(getauthont(user,userx),usertype,useremail,baseurl,urll);
                      //new  AsyncTaskRunner().execute();
                        /*Intent intent = new Intent(view.getViewManager().getContext().getActvityAllt(), ProtouseNewActivity.class);
                        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("data", anotherdata);
                        view.getViewManager().getContext().getActvityAllt().startActivity(intent);*/
                        //  Log.i("xxccxx",anotherdata+"BandarAmeen");
                    } else if(typ==9000){
try {
    String jm = anotherdata;
    JSONObject js = new JSONObject(jm);
    String bvc = js.get("data").toString();
    JSONObject jsm = new JSONObject(bvc);
    String mnb = "Bearer " + jsm.get("accessToken").toString();
    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("acesstoken", mnb, context);
    GlobalClass.acesstoken = mnb;
    GlobalClass.refreshtoken = jsm.get("refreshToken").toString();
    GlobalClass.username = jsm.get("usernames").toString();
    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("refacesstoken", jsm.get("refreshToken").toString(), context);
    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("usernames", jsm.get("usernames").toString(), context);
    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("profile", jsm.get("profile").toString(), context);
    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("alfra", jsm.get("alfraname").toString(), context);
    showload.loadmainActivity();

  /*  String mess = "Ok enter";
    String res = "Response_Login(\"" + mess + "\",1);";
    viwsk.loadUrl("javascript:" + res);*/
}catch (Exception ex){

}
                    }
                    else if(typ==7000){
                        Intent intent=new   Intent(context,MainActivity.class);
                        context.startActivity(intent);
                      //  String datee=dfr+"(\""+anotherdata+"\")";

                       // view.loadUrl("javascript:" + datee);
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

                        Type type = new TypeToken<Value>() {

                        }.getType();
                        Value tempp = gsonn.fromJson(k, type);

//Gson u=new Gson();
                        //  String vcc=u.toJson(tempp.getAsObject());
                        //uuip.trigger(true, "WebView", "myWeb", tempp.getAsObject(), (ProteusView) view);
                    }

                }

                @Override
                public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                }

                @Override
                public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                }
            };


            view.addJavascriptInterface(new JavaScript_and_JavaLogin(view.getContext(),Actv), "Android");


            //   view.setDownloadListener(new );
            AdvancedWebView.Listener t = new AdvancedWebView.Listener() {
                @Override
                public void onPageStarted(String url, Bitmap favicon) {
                   // view.getLinwting().setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageFinished(String url) {
                    view.setHaserror(false);
                    /*view.getLinwting().setVisibility(View.GONE);

                    if(view.getErrorView()!=null){
                        view.getErrorView().getAsView().setVisibility(View.GONE);
                    }
                    view.setVisibility(View.VISIBLE);*/
                    showload.loadfinshed();
                    //boxx.hideAll();
                }

                @Override
                public void onPageError(int errorCode, String description, String failingUrl) {
                    view.setHaserror(true);
                    if (useerror) {
                       // view.getLinwting().setVisibility(View.GONE);

            /*view.setFocusable(false);
            view.setFocusableInTouchMode(false);
            view.requestFocus();*/
                        // view.clearView();
                      /*  if(view.getErrorView()!=null){
                            view.getErrorView().getAsView().setVisibility(View.VISIBLE);
                        }*/
                        //  view.setVisibility(View.GONE);
                         view.loadHtml(urlmerreoo);
                        // super.onReceivedError(view, request, error);
                    }
                    showload.onerror(description,description);

                    // Log.i("090","gggggmmmmmm");
                }

                @Override
                public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
                    //    AdvancedWebView.handleDownload(view.getContext(),url,suggestedFilename);
                    // final long begin1 = SystemClock.elapsedRealtime();
                    //com.ordersalsemyntofi.astolnotf.dynimicall.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl.getImpl()
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


                }

                public void showStandardNotification(String te, Context conn) {

                    int notificationId = new Random().nextInt();

                    Intent intent = new Intent(conn, NotificationActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);

                    NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                            "Notification", te, R.drawable.ic_notifications, pIntent);

                    NotificationHelper.showNotification(conn, notificationId, notification.build());

                }

                public void showHeadsUpNotification(String te,String chnlid,Context c) {


                    NotificationManager notificationManager = (NotificationManager)c.getSystemService(NOTIFICATION_SERVICE);
                    NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(c);
                    NotificationCompat.Builder builder = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
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
                public void openFileChosser(Intent intent, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback1) {

                }
            };

            boolean useback = value.getAsObject().getAsBoolean("enab_back");
         view.setListener((Activity) context,t,0,mPermissionInterceptor);
            final AdvancedWebView ffm =view;
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

                            } else {
                                return false;
                            }
                            return true;
                        }else{

                            return  false;
                        }
                    }
                    return  false;
                }
            });



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
            viwsk=view;
        }catch (Exception ex){

            Toast.makeText(view.getContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
        }


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

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        boolean tt=false;

        // ProgressDialog progressDialog;
        String bbaa="0";
        String bbaat="0";
        Map<String, Object> hedermap = new HashMap<>();//Map<String, Object>();
        Map<String, String> hedermapVolley = new HashMap<>();//Map<String, Object>();
        HashMap<String, String> quarymap = new HashMap<>();//HashMap<String, String>();
        String URL = "no";
        String URL2 = "no";
        String Postmethod = "no";
        String requestbody = "nos";
        final String refresh = "0";///params[3];
        List<hedaerOrQuary> responsee = new ArrayList<>();
        boolean UseCustomData = false;
        // ObjectValue mCustomedata = new ObjectValue();
        @Override
        protected String doInBackground(final String... params) {
            //  publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {

                //   notifi();

                // StringRequest
                //  mess.customToast(params[1]);
                String contettyp="application/json; charset=UTF-8";
                String userAgentt=GlobalClass.UserAppID;
                hedermap.put("Authorization",params[0]);


                hedermap.put("usertyp",params[1]);


                hedermap.put("User-Agent",userAgentt);


                hedermap.put("email",params[2]);
                hedermap.put("Content-Type",contettyp);
/*  hedermap.put("Authorization",params[0]);
*
* @Header("Authorization") String headers,
                                              @Header("usertyp") String usertyp,
                                              @Header("User-Agent") String useragent,
                                              @Header("email") String email,

                                              @Header("Content-Type") String kont
* */


                final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit(params[3]).create(retrofit_dynimcic.class);
                RequestBody requestBodyBinary = null;

                requestBodyBinary = RequestBody.create(MediaType.parse(contettyp), requestbody);

                // sendreq(params[0],params[1],params[2]);
                Call<ResponseBody> call = Postmethod.toLowerCase().equals("post") ? Retrofitapi.PostMethod(params[4], requestBodyBinary, hedermap, quarymap) : Retrofitapi.GetMethod(params[4], hedermap, quarymap);
             /*   final ApiInterface Retrofitapi = RetrofitData.getRetrofit().create(ApiInterface.class);


               // sendreq(params[0],params[1],params[2]);
                Call<String> call = Retrofitapi.getsinprodunitsslisto(params[0],params[1],userAgentt,params[2],contettyp);
*/
                call.enqueue(new Callback<ResponseBody>() {


                    @Override
                    public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                        try {

                            assert response.body() != null;
                            String x="mydesin";
                            //  Gson f=new Gson();
                            //   String df=f.toJson(response);
                            if(response.isSuccessful()) {

                                String jm=response.body().string();
                                JSONObject js=new JSONObject(jm);
                                String bvc=js.get("data").toString();
                                JSONObject jsm=new JSONObject(bvc);
                                // mess.customToast(js.get("accessToken").toString());
                                //  mess.customToast(jsm.get("usernames").toString());
                                String mnb=  "Bearer "+jsm.get("accessToken").toString();
                                com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("acesstoken", mnb,context);
                                GlobalClass.acesstoken=mnb;
                                GlobalClass.refreshtoken =jsm.get("refreshToken").toString();
                                GlobalClass.username = jsm.get("usernames").toString();
                                com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("refacesstoken", jsm.get("refreshToken").toString(),context);
                                com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("usernames", jsm.get("usernames").toString(),context);

                                com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("profile", jsm.get("profile").toString(),context);
                                com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("alfra", jsm.get("alfraname").toString(),context);
                               String mess="Ok enter";
                                String res="Response_Login(\""+mess+"\",1);";
                                viwsk.loadUrl("javascript:" + res);

                            }else{
                                try {
                                  //  Log.e("dddmmmmmmmkkkkkkkkk", "hghghghghg");//.body());
                                    assert response.errorBody() != null;
                                    String k=response.errorBody().string();
String res="Response_Login(\""+k+"\",2);";
                                   viwsk.loadUrl("javascript:" + res);
                                    //typ_message v= typ_message.messagrror;
                                  //  mess.customToast(k,v,true);
                                    // savetoref(x, response.errorBody().string());
                                    //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                }catch (IOException ex){

                                }
                            }

                        } catch (Exception ex) {

                            String res="Response_Login(\""+ex.getMessage()+"\",2);";
                            viwsk.loadUrl("javascript:" + res);
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        //stoptimertask();
                      //  mess.customToast(t.getMessage()+"لا يوجد إتصال بالشبكة");
                        //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

                        Log.d("tag", "Error -> " + t.toString());
                    }
                });


            } catch (Exception ex) {
                String res="Response_Login(\""+ex.getMessage()+"\",2);";
                viwsk.loadUrl("javascript:" + res);

            }
            return bbaa;
        }

        /*    private final ServiceConnection mConnection = new ServiceConnection() {

                @Override
                public void onServiceConnected(ComponentName className,
                                               IBinder service) {
                    // We've bound to SignalRService, cast the IBinder and get SignalRService instance
                    SignalRService.LocalBinder binder = (SignalRService.LocalBinder) service;
                    mserv = binder.getService();
                    mBoind = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName arg0) {
                    mBoind = false;
                }
            };*/
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


           // com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(hedde.get(cx).getKeyValue(),context);
            helper.insert(g);
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

    public String[]  gethderOr( List<hedaerOrQuary> hedde,Context con,boolean usegetdata,String getdataa){
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
                    List<ScriptModel>  h=helper.getAllNotes(g);
                    hedde.get(cx).setKeyValue(h.get(0).getContent());
                  //  hedde.get(cx).setKeyValue(resu);
                    // int siz=h.get(0).getContent().length();
                    // Log.i("999mm",siz+"@@");

                }
                if(typ.equals("ID_device")){
                    String kk= Settings.Secure.ANDROID_ID;///getdatafrom("acesstoken");
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

}
