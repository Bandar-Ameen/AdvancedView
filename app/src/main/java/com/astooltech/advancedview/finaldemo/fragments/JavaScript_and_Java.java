package com.astooltech.advancedview.finaldemo.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.parser.NotificationActivity;
import com.astooltech.advancedview.proteus.parser.NotificationHelper;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;

import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWeb;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebUtils;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.PermissionInterceptor;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import static android.content.Context.NOTIFICATION_SERVICE;
import static com.astooltech.advancedview.proteus.parser.NotificationHelper.GROUP_KEY;
import static com.astooltech.advancedview.proteus.parser.NotificationHelper.REPLY_CLICK;
import static com.astooltech.advancedview.proteus.parser.NotificationHelper.REPLY_TEXT_KEY;


public class JavaScript_and_Java {

    ProteusView.Manager.ActionEventView con;
    Context conn;
    public JavaScript_and_Java(Context conn, ProteusView.Manager.ActionEventView con){

        this.con=con;
        this.conn=conn;
    }

    @JavascriptInterface
    public void AndroidFunction(String t,int typ){


        con.sendEvent(null,typ,t);
      //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public String AndroidFunctionSaveData(String t,String keyname){

        ScriptModel g=new ScriptModel(0,t,keyname);
        DatabaseHelper db_operations;
        db_operations=new DatabaseHelper(conn);
        db_operations.insert(g);
      //  con.sendEvent(null,typ,t);

        return  "hell bandar";
        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public String AndroidFunctionDeleteData(String t,String keyname){


        //  con.sendEvent(null,typ,t);

        return  "hell bandar";
        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public void AndroidFunctionOpenActivity(String dv){

        // String dvv = new String(Base64.decode (dv,Base64.DEFAULT), StandardCharsets.UTF_8);//, "UTF-8");


  /*  java.util.Base64.Decoder kkj= java.util.Base64.getDecoder();
 String cx=new String(kkj.decode(dv));
   String dvv =cx;// com.itextpdf.text.pdf.codec.Base64.decodeToObject(dv).toString();
    //;
    // aoiOpen=valunul?ob.get("base_api").toString(): String.valueOf(view.getAsView().getTag(R.id.tagAPIOpen)).
    String x = dvv;//new String( com.itextpdf.text.pdf.codec.Base64.decode(dv));

    Log.i("77", x);*/
        // String dcx=   "android.content.Intent intent = new android.content.Intent(this.context.getApplicationContext(),  ProteusActivity.class);((Activity)this.context).startActivity(intent)";
        // String ee[]=new String[]{"\""};
        // dv=String.format(dv,ee);

        //  ProteusView view = layoutInflater.inflate(dv, new ObjectValue());

        //  ProtouseNewActivity.getasvi=view;

    con.sendEvent(null,8000,dv);

        //  RJSBridge.interpret(context, dcx);
        // intent.putExtra("typActivity", "0");
        // intent.putExtra("api", aoiOpen);



    }
    @JavascriptInterface
    public String AndroidFunctionGetData(String t,String keyname){
try {
    ScriptModel g = new ScriptModel(0, t, keyname);
    DatabaseHelper db_operations;
    db_operations = new DatabaseHelper(conn);
    List<ScriptModel> x = db_operations.getAllNotes(g);

    //  con.sendEvent(null,typ,t);

    return x.get(0).getContent();
}catch (Exception e){
    return "not found";
}



        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }

    private WeakReference<AgentWeb> mReference = null;
    private WeakReference<Activity> mActivityWeakReference = null;
    private WeakReference<AdvancedWebView> mReferencee = null;
    private WeakReference<Activity> mActivityWeakReferencee = null;
    private String TAG = this.getClass().getSimpleName();

  public JavaScript_and_Java(Context conn, ProteusView.Manager.ActionEventView con, AgentWeb agentWeb, Activity activity) {
        this.con=con;
        this.conn=conn;
        mReference = new WeakReference<AgentWeb>(agentWeb);
        mActivityWeakReference = new WeakReference<Activity>(activity);
    }
    public JavaScript_and_Java(Context conn, ProteusView.Manager.ActionEventView con, AdvancedWebView agentWeb) {
        this.con=con;
        this.conn=conn;
        mReferencee = new WeakReference<AdvancedWebView>(agentWeb);
      //  mActivityWeakReferencee = new WeakReference<Activity>(activity);
    }

    @JavascriptInterface
    public void uploadFile() {
        uploadFile("*/*");
    }
    String[] permissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private final int FROM_INTENTION_CODE = 21;


    @JavascriptInterface
    public void uploadFilee(String acceptType) {
      //  LogUtils.i(TAG, acceptType + "  " + mActivityWeakReference.get() + "  " + mReference.get());
        if (mActivityWeakReferencee.get() != null && mReferencee.get() != null) {
            AgentWebUtils.showFileChooserCompat(mActivityWeakReferencee.get(),
                    mReferencee.get(),
                    null,
                    null,
                    mReferencee.get().getPermissionInterceptor(),
                    null,
                    acceptType,
                    new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message msg) {
                            if (mReferencee.get() != null) {
                                mReferencee.get().getJsAccessEntrace()
                                        .quickCallJs("uploadFileResult",
                                                msg.obj instanceof String ? (String) msg.obj : null);
                            }
                            return true;
                        }
                    }
            );
        }
    }
    @JavascriptInterface
    public void uploadFile(String acceptType) {
        //  LogUtils.i(TAG, acceptType + "  " + mActivityWeakReference.get() + "  " + mReference.get());
        if (mActivityWeakReference.get() != null && mReference.get() != null) {
            AgentWebUtils.showFileChooserCompat(mActivityWeakReference.get(),
                    mReference.get().getWebCreator().getWebView(),
                    null,
                    null,
                    mReference.get().getPermissionInterceptor(),
                    null,
                    acceptType,
                    new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message msg) {
                            if (mReference.get() != null) {
                                mReference.get().getJsAccessEntrace()
                                        .quickCallJs("uploadFileResult",
                                                msg.obj instanceof String ? (String) msg.obj : null);
                            }
                            return true;
                        }
                    }
            );
        }
    }
    @JavascriptInterface
    public String AndroidFunctionSelectFileResults(){
        try {
            ScriptModel g = new ScriptModel(0, "SelectFile", "SelectFile");
            DatabaseHelper db_operations;
            db_operations = new DatabaseHelper(conn);
            List<ScriptModel> x = db_operations.getAllNotes(g);

            //  con.sendEvent(null,typ,t);

            return x.get(0).getContent();
        }catch (Exception e){
            return "not found";
        }

        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public void AndroidFunctionOpenAlert(String alertname,String data,int typ){
        try {


        }catch (Exception e){

        }

        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @JavascriptInterface
    public void AndroidFunctionNoti(String t,int typ){


        if(typ==1) {
            showStandardNotification(t);
        }
        if(typ==2) {
            showHeadsUpNotification(t);
        }
        if(typ==3) {
            showRemoteInputNotification(t);
        }
        if(typ==4) {
            showSummaryNotification(t);
        }
      /*  int notificationId = new Random().nextInt();

        Intent intent = new Intent(conn, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);

        NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                "Notification", t, R.drawable.ic_notifications, pIntent);
     //   RemoteViews f=new RemoteViews(conn.getPackageName(),R.layout.notification_custom);
      //  notification.setContent(f);
        NotificationHelper.showNotification(conn, notificationId, notification.build());
*/
        //  mynotificatins.sendNotification(t, 1, conn,String.valueOf(typ));
        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
  public void AndroidFunctionSelectFile(final String dat) {
       /* ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteusActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(conn);
        pictureDialog.setTitle("الرجاء الاختيار");
        String[] pictureDialogItems = {"الاستيديو", "الكاميراء"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                onCameraAction(dat,1);
                                break;
                            case 1:
                                onCameraAction(dat,2);
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
});*/
    }

    @JavascriptInterface
    public void AndroidFunctionLoadFunction(String dat,String json) {
        hedaerOrQuary dder=new hedaerOrQuary(dat,json,"0","0");
        con.sendEvent(null, 12600, dder);
        // dat.length
    }
    private int GALLERY = 1, CAMERA = 2;





    public byte[] getbyt(InputStream in)  {

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        try {
            int buff = 1024;
            byte[] buffv = new byte[buff];
            int len = 0;
            while ((len = in.read(buffv)) != -1) {
                byteArrayOutputStream.write(buffv, 0, len);


            }
        }catch (Exception ex){

            Log.i("77",ex.getMessage());
        }
        return  byteArrayOutputStream.toByteArray();
    }

    public boolean showFileChooserCompat(Activity activity,
                                                WebView webView,
                                                ValueCallback<Uri[]> valueCallbacks,
                                                WebChromeClient.FileChooserParams fileChooserParams,
                                                PermissionInterceptor permissionInterceptor,
                                                ValueCallback valueCallback,
                                                String mimeType,
                                                Handler.Callback jsChannelCallback
    ) {
        try {
            Class<?> clz = Class.forName("com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.FileChooser");
            Object mFileChooser$Builder = clz.getDeclaredMethod("newBuilder",
                    Activity.class, WebView.class)
                    .invoke(null, activity, webView);
            clz = mFileChooser$Builder.getClass();
            Method mMethod = null;
            if (valueCallbacks != null) {
                mMethod = clz.getDeclaredMethod("setUriValueCallbacks", ValueCallback.class);
                mMethod.setAccessible(true);
                mMethod.invoke(mFileChooser$Builder, valueCallbacks);
            }
            if (fileChooserParams != null) {
              //  mMethod = clz.getDeclaredMethod("setFileChooserParams", WebChromeClient.FileChooserParams.class);
                mMethod.setAccessible(true);
                mMethod.invoke(mFileChooser$Builder, fileChooserParams);
            }
            if (valueCallback != null) {
                mMethod = clz.getDeclaredMethod("setUriValueCallback", ValueCallback.class);
                mMethod.setAccessible(true);
                mMethod.invoke(mFileChooser$Builder, valueCallback);
            }
            if (!TextUtils.isEmpty(mimeType)) {
//                LogUtils.i(TAG, Arrays.toString(clz.getDeclaredMethods()));
                mMethod = clz.getDeclaredMethod("setAcceptType", String.class);
                mMethod.setAccessible(true);
                mMethod.invoke(mFileChooser$Builder, mimeType);
            }
            if (jsChannelCallback != null) {
                mMethod = clz.getDeclaredMethod("setJsChannelCallback", Handler.Callback.class);
                mMethod.setAccessible(true);
                mMethod.invoke(mFileChooser$Builder, jsChannelCallback);
            }
            mMethod = clz.getDeclaredMethod("setPermissionInterceptor", PermissionInterceptor.class);
            mMethod.setAccessible(true);
            mMethod.invoke(mFileChooser$Builder, permissionInterceptor);
            mMethod = clz.getDeclaredMethod("build");
            mMethod.setAccessible(true);
            Object mFileChooser = mMethod.invoke(mFileChooser$Builder);
            mMethod = mFileChooser.getClass().getDeclaredMethod("openFileChooser");
            mMethod.setAccessible(true);
            mMethod.invoke(mFileChooser);
        } catch (Throwable throwable) {

            if (throwable instanceof ClassNotFoundException) {
              Log.e("noo", "Please check whether compile'com.just.agentweb:filechooser:x.x.x' dependency was added.");
            }
            if (valueCallbacks != null) {
             Log.i("uyuy", "onReceiveValue empty");
                return false;
            }
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        }
        return true;
    }

    public void showStandardNotification(String te) {

        int notificationId = new Random().nextInt();

        Intent intent = new Intent(conn, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);

        NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                "Notification", te, com.astooltech.advancedview.R.drawable.ic_notifications, pIntent);

        NotificationHelper.showNotification(conn, notificationId, notification.build());

    }

    public void showHeadsUpNotification(String te) {


        NotificationManager notificationManager = (NotificationManager)conn.getSystemService(NOTIFICATION_SERVICE);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(conn);
        NotificationCompat.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel("1", "Astoolntofi",importance);

            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new NotificationCompat.Builder(conn, notificationChannel.getId()).setSmallIcon(com.astooltech.advancedview.R.drawable.camera_icon);


        } else {
            builder = new NotificationCompat.Builder(conn);
        }
        builder.setContentTitle("hhhhhh")
                .setContentText(te)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        notificationManagerCompat.notify(1,builder.build());
      /*  int notificationId = new Random().nextInt();

        Intent intent = new Intent(this, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent positive = new Intent(this, NotificationReceiver.class);
        positive.putExtra("notiID", notificationId);
        positive.setAction(POSITIVE_CLICK);

        PendingIntent pIntent_positive = PendingIntent.getBroadcast(this, notificationId, positive, PendingIntent.FLAG_CANCEL_CURRENT);

        Intent negative = new Intent(this, NotificationReceiver.class);
        negative.putExtra("notiID", notificationId);
        negative.setAction(NEGATIVE_CLICK);

        PendingIntent pIntent_negative = PendingIntent.getBroadcast(this, notificationId, negative, PendingIntent.FLAG_CANCEL_CURRENT);


        NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(this,
                "Notification", "Heads-Up Notification!", R.drawable.ic_notifications, pIntent);

        notification.setPriority(Notification.PRIORITY_HIGH).setVibrate(new long[0]);

        notification.addAction(new NotificationCompat.Action(R.drawable.ic_notifications, "Postive", pIntent_positive));
        notification.addAction(new NotificationCompat.Action(R.drawable.ic_notifications, "Negative", pIntent_negative));

        NotificationHelper.showNotification(this, notificationId, notification.build());*/
    }

    public void showRemoteInputNotification(String te) {

        int notificationId = new Random().nextInt();

        NotificationCompat.Builder notification = NotificationHelper.createNotificationBuider(conn,
                "Remote Input", te, com.astooltech.advancedview.R.drawable.ic_notifications);

        notification.setGroupSummary(true);
        notification.setGroup("KEY_NOTIFICATION_GROUP1");

        Intent remote_intent = new Intent(conn, NotificationActivity.class);
        remote_intent.putExtra("notiID", notificationId);
        remote_intent.setAction(REPLY_CLICK);

        PendingIntent pIntent_positive = PendingIntent.getBroadcast(conn, notificationId, remote_intent, PendingIntent.FLAG_CANCEL_CURRENT);


        RemoteInput remoteInput = new RemoteInput.Builder(REPLY_TEXT_KEY)
                .setLabel("Type Something")
                .build();

        // Create the reply action and add the remote input.

        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(com.astooltech.advancedview.R.drawable.ic_send, "Reply", pIntent_positive)
                        .addRemoteInput(remoteInput)
                        .build();

        notification.addAction(action);
        notification.setColor(ContextCompat.getColor(conn, com.astooltech.advancedview.R.color.colorAccent));

        NotificationHelper.showNotification(conn, notificationId, notification.build());
    }


    public void showSummaryNotification(String te) {

        int notificationId = new Random().nextInt();

        Intent intent = new Intent(conn, NotificationActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(conn, 0, intent, 0);

        Bitmap largeIcon = BitmapFactory.decodeResource(conn.getResources(),
                com.astooltech.advancedview.R.drawable.audio_icon);

        NotificationCompat.Builder summary_notification = NotificationHelper.createNotificationBuider(conn,
                "2 new messages", te, com.astooltech.advancedview.R.drawable.ic_notifications, pIntent);

        summary_notification.setStyle(new NotificationCompat.InboxStyle()
                .addLine("Ashwin  Check this out")
                .addLine("Ranjith  Launch Party")
                .setBigContentTitle("2 new messages")
                .setSummaryText("2 new messages"))
                .setLargeIcon(largeIcon)
                .setGroupSummary(true)
                .setContentIntent(pIntent)
                .setGroup(GROUP_KEY).build();

        int notificationId1 = new Random().nextInt();

        NotificationCompat.Builder notification1 = NotificationHelper.createNotificationBuider(conn,
                "Ashwin", "Check this out", com.astooltech.advancedview.R.drawable.ic_notifications, pIntent);

        int notificationId2 = new Random().nextInt();

        NotificationCompat.Builder notification2 = NotificationHelper.createNotificationBuider(conn,
                "Ranjith", "Launch Party", com.astooltech.advancedview.R.drawable.ic_notifications, pIntent);

        NotificationHelper.showNotification(conn, notificationId1, notification1.build());
        NotificationHelper.showNotification(conn, notificationId2, notification2.build());

        NotificationHelper.showNotification(conn, notificationId, summary_notification.build());
    }
}
