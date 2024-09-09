package com.astooltech.advancedview.finaldemo;

import android.Manifest;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.spinkit.SpinKitView;
import com.astooltech.advancedview.R;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.astooltech.advancedview.GlobalClass.PREFS_NAME;
import static com.astooltech.advancedview.finaldemo.conectionbase.loginnurl;

public class b_spalsh_screen extends AppCompatActivity implements showlogin, loadSettingsFirstly.Sucessconn {
    String[] permissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private boolean isSettings = false;
   // private static final String PREFS_NAME = "TCPClientConf";
    private static final int PERMISSION_CALLBACK = 111;
    private static final int PERMISSION_REQUEST = 222;
Handler handler;
    loadSettingsFirstly f;
    com.astooltech.advancedview.database.DatabaseHelper helper;
   // private SignalRService mYourService;
    Intent mServiceIntent;
    private  boolean mBoind=false;
  //  private  SignalRService mserv;
    private  final Context mconte=this;
    Intent min;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_splash_screen);
        getsetting();
        helper=new DatabaseHelper(this);
        f=new  loadSettingsFirstly(this,conectionbase.fir);
     /* min =new Intent();
        min.setClass(mconte,SignalRService.class);*/
      //  stopService(new Intent(getApplicationContext(), YourService.class));

        //SpinKitView
      //  mYourService = new SignalRService();

        //stopForeground(true);
      /* mServiceIntent = new Intent(getApplicationContext(), mYourService.getClass());
        if (!isMyServiceRunning(mYourService.getClass())) {
           // startForegroundService(new Intent(getApplicationContext(), YourService.class));
           try {

               Intent min=new Intent();
               min.setClass(mconte,SignalRService.class);
               bindService(min,mConnection,Context.BIND_AUTO_CREATE);
               mYourService.stopForeground(true);
           }catch (Exception ex){
               startService(mServiceIntent);
           }
//getApplicationContext().stopService(mServiceIntent);
            startService(mServiceIntent);
        }*/

     /*   if (android.os.Build..VERSION.SDK_INT >= android.os.Build.VERSION_CODES.) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

        }*/
        load22();
       // settreq();

      //  loadInt();
    }

    private void load22(){
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               if(f.isexitsornot()){
                   if(f.checkNetwork()) {
                       f.downloadfilee(b_spalsh_screen.this, true);
                   }else{
                       f.downloadfilee(b_spalsh_screen.this, true);
                   }
               }else {
                   f.downloadfilee(b_spalsh_screen.this,true);
               }

            }
        },3000);
    }
private void load2(){

    //settreq();

    handler=new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            login();
        }
    },1000);
}
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("ddd", "Service status Running");
                return true;
            }
        }
        // Log.i ("ddd", "Service status Not running");
        return false;
    }
    private void login(){
        String acesstokk=getdatafrom("acesstoken");
        String reftokk=getdatafrom("refacesstoken");
        String usernames=getdatafrom("usernames");
        if(!acesstokk.equals("NO")){
            if(!reftokk.equals("NO"))
            {
                GlobalClass.acesstoken=acesstokk;
                GlobalClass.refreshtoken=reftokk;
                GlobalClass.username=usernames;

               // bindService(min,mConnection,Context.BIND_AUTO_CREATE);
               // mYourService.stopForeground(true);
                qforOpeningActivity();
            }else {
                forOpeningActivity();
            }

        }else {
            forOpeningActivity();
        }
    }
    private final ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to SignalRService, cast the IBinder and get SignalRService instance
          /*  SignalRService.LocalBinder binder = (SignalRService.LocalBinder) service;
            mserv = binder.getService();
            mBoind = true;*/
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBoind = false;
        }
    };
    private void getsetting(){

        String c1=getdatafrom("c1");
        String c2=getdatafrom("c2");
        String c3=getdatafrom("c3");
        String c4=getdatafrom("c4");
        if(!c1.isEmpty()){
            if(c1.equals("1")){
               // check.setChecked(true);
                GlobalClass.check1=true;
            }else {
                //check.setChecked(false);
                GlobalClass.check1=false;
            }

        }else {
           // check.setChecked(false);
            GlobalClass.check1=false;
        }
        if(!c4.isEmpty()){
            if(c4.equals("1")){
                // check.setChecked(true);
                GlobalClass.check4=true;
            }else {
                //check.setChecked(false);
                GlobalClass.check4=false;
            }

        }else {
            // check.setChecked(false);
            GlobalClass.check4=false;
        }
        if(!c2.isEmpty()){
            if(c2.equals("1")){
               // che2.setChecked(true);
                GlobalClass.check2=true;
            }else {
               // che2.setChecked(false);
                GlobalClass.check2=false;
            }

        }else {
            GlobalClass.check2=false;
           // che2.setChecked(false);
        }
        if(!c3.isEmpty()){
            if(c3.equals("1")){
               // chek3.setChecked(true);
                GlobalClass.check3=true;
            }else {
               // chek3.setChecked(false);
                GlobalClass.check3=false;
            }

        }else {
           // chek3.setChecked(false);
            GlobalClass.check3=false;
        }

    }
    private String getdatafrom(String textt){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }
    public void loadInt(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            ChkPerm();
        }else{
            afterPermission();
        }
    }


    private void afterPermission() {

    /*    File folderPdf=new File(FOLDER_PDF);

        if (!folderPdf.exists()){
            folderPdf.mkdir();
            forOpeningActivity();
        }else {
            forOpeningActivity();
        }
*/
    }

    public void forOpeningActivity(){
      Intent intent=new   Intent(b_spalsh_screen.this,b_login_activity.class);
      startActivity(intent);
      finish();
    }
    public void qforOpeningActivity(){
        Intent intent=new   Intent(b_spalsh_screen.this,b_login_activity.class);
        startActivity(intent);
          finish();
    }
    public void qforOpeningActivity2(){
        Intent intent=new   Intent(b_spalsh_screen.this,MainActivity2.class);
        startActivity(intent);
        finish();
    }
    public void ChkPerm(){
        if(forSelfPermission()){

            if(shouldShow()){
                permissionCallBack();
            }  else {
                //just request the permission
                ActivityCompat.requestPermissions(b_spalsh_screen.this,permissionList, PERMISSION_CALLBACK);
            }
        } else {
            //You already have the permission, just go ahead.
            afterPermission();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_CALLBACK){
            //check if all permissions are granted
            boolean allgranted = false;
            for(int i=0;i<grantResults.length;i++){
                if(grantResults[i]== PackageManager.PERMISSION_GRANTED){
                    allgranted = true;
                } else {
                    allgranted = false;
                    break;
                }
            }

            if(allgranted){
                afterPermission();
            } else if(shouldShow()){

                permissionCallBack();
            } else {

                permissionSettings();
                Toast.makeText(getBaseContext(),"Unable to get Permission", Toast.LENGTH_LONG).show();
            }
        }
    }



    private boolean forSelfPermission(){
        boolean allgranted = false;
        for(int i=0;i<permissionList.length;i++){

            if (ActivityCompat.checkSelfPermission(b_spalsh_screen.this, permissionList[i]) != PackageManager.PERMISSION_GRANTED) {
                allgranted = true;
                break;
            } else {
                allgranted = false;
            }
        }

        if (allgranted){
            return true;
        }else{
            return false;
        }

    }

    private boolean resultPermission(){
        boolean allgranted = false;
        for(int i=0;i<permissionList.length;i++){

            if (ActivityCompat.checkSelfPermission(b_spalsh_screen.this, permissionList[i]) == PackageManager.PERMISSION_GRANTED) {
                allgranted = true;
            } else {
                allgranted = false;
                break;
            }
        }

        if (allgranted){
            return true;
        }else{
            return false;
        }

    }


    private boolean shouldShow(){

        boolean allgranted = false;
        for(int i=0;i<permissionList.length;i++){
            if (ActivityCompat.shouldShowRequestPermissionRationale(b_spalsh_screen.this, permissionList[i])) {
                allgranted = true;
                break;
            } else {
                allgranted = false;
            }
        }

        if (allgranted){
            return true;
        }else{
            return false;
        }
    }

    private void permissionCallBack(){
        AlertDialog.Builder builder = new AlertDialog.Builder(b_spalsh_screen.this);
        builder.setTitle("Need Multiple Permissions");
        builder.setMessage("This app needs Multiple permissions.");
        builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                ActivityCompat.requestPermissions(b_spalsh_screen.this,permissionList, PERMISSION_CALLBACK);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    private void permissionSettings(){
        AlertDialog.Builder builder = new AlertDialog.Builder(b_spalsh_screen.this);
        builder.setTitle("Need Multiple Permissions");
        builder.setMessage("This app needs permission allow them from settings.");
        builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                isSettings = true;
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivityForResult(intent, PERMISSION_REQUEST);
                // Toast.makeText(getBaseContext(), "Go to Permissions to Grant  Camera and Location", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }
    public  void settreq(){
        Log.e("r",loginnurl);
if(loginnurl.startsWith("http")){
    qforOpeningActivity();
}else {
    load22();
}

       /// new instweb.Builderweb().Builderweb(b_spalsh_screen.this,b_spalsh_screen.this,helper);
     /* final   String BASE_URL =   com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("mapi",getApplicationContext()); //"http://0.0.0.0:8080/api/astoolacount/login";

        RequestQueue q= Volley.newRequestQueue(this);

        StringRequest requestd = new StringRequest(Request.Method.POST, BASE_URL ,new com.android.volley.Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                ScriptModel g=new ScriptModel(0,response,"mainlogin");




                // com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(hedde.get(cx).getKeyValue(),context);
                helper.insert(g);
                new instweb.Builderweb().Builderweb(b_spalsh_screen.this,b_spalsh_screen.this,helper);
                //login();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                qforOpeningActivity2();
                //  String ff=g.toJson(error.);

                //  Log.i ("dddmmmmmmm", ff);

            }
        }){

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {

                JSONObject obj=new   JSONObject();

                try {
                    obj.put("hhh", "jhjhjh");
                }catch (Exception ex){

                }
                return obj.toString().getBytes();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                //add params <key,value>
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  headers = new HashMap<String, String>();

                return headers;
            }

        };
        requestd.setRetryPolicy(new DefaultRetryPolicy(6000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        q.add(requestd);*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("R","result");
        if (requestCode == PERMISSION_REQUEST) {

            if (resultPermission()){
                Log.d("R","result s");
                afterPermission();
            }else{
                Log.d("R","result c");
                ChkPerm();
            }

        }
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
       /* if (isSettings) {
            Log.d("R","resume");
            if (resultPermission()){
                Log.d("R","resume s");
                afterPermission();
            }else{
                Log.d("R","resume c");
                ChkPerm();
            }

            isSettings=false;
        }*/
    }


    @Override
    public void loadfinshed() {
        load2();
    }

    @Override
    public void onerror(String mess, Object ob) {
        Log.e ("ddd", mess);
    }

    @Override
    public void OnRetray() {

    }

    @Override
    public void loadmainActivity() {

    }

    @Override
    public void isSucess() {
        settreq();
    }

    @Override
    public void isError(String e) {
Toast.makeText(this,e,Toast.LENGTH_LONG).show();
    }
}
