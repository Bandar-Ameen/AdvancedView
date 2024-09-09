package com.astooltech.advancedview.finaldemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.core.content.ContextCompat;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JavaScript_and_JavaLogin {

    ProteusView.Manager.ActionEventView con;
    Context conn;
    public JavaScript_and_JavaLogin( Context conn,ProteusView.Manager.ActionEventView con){

        this.con=con;
        this.conn=conn;
    }

    @JavascriptInterface
    public void AndroidFunction(String t,int typ){


        con.sendEvent(null,typ,t);
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
        con.sendEvent(null,7000,dv);
       // con.sendEvent(null,8000,dv);
        //  RJSBridge.interpret(context, dcx);
        // intent.putExtra("typActivity", "0");
        // intent.putExtra("api", aoiOpen);



    }
    @JavascriptInterface
    public void AndroidFunctionLogin(String jsondata){
        con.sendEvent(null,8000,jsondata);




    }
    @JavascriptInterface
    public void AndroidFunctionLoginFrom(String jsondata){
        con.sendEvent(null,9000,jsondata);




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



    @JavascriptInterface
    public void AndroidFunctionOpenAlert(String alertname,String data,int typ){
        try {


        }catch (Exception e){

        }

        //  Toast.makeText(con,tex,Toast.LENGTH_LONG).show();
    }


    @JavascriptInterface
    public void AndroidFunctionLoadFunction(String dat,String json) {
        hedaerOrQuary dder=new hedaerOrQuary(dat,json,"0","0");
        con.sendEvent(null, 12600, dder);
        // dat.length
    }






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



}
