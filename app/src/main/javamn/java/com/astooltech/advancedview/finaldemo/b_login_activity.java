package com.astooltech.advancedview.finaldemo;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.parser.ValuesModel;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.parser.message_box;
import com.astooltech.advancedview.proteus.parser.typ_message;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;
import com.google.gson.Gson;
import com.astooltech.advancedview.R;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

import static com.astooltech.advancedview.finaldemo.conectionbase.loginnurl;


public class b_login_activity extends AppCompatActivity   implements showlogin {
    String[] permissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final String PREFS_NAME = "TCPClientConf";
    private boolean isSettings = false;
    EditText userr, pass_name;
    Button btnlog;
    TextView reg;
   // Button opensavjson;
   // Button preview;
    Spinner usertyp;
    showlogin eventshow;
    message_box mess;
    private com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView loginsys;
    boolean checkiflog=false;
    private Timer timer;
    private TimerTask timerTask;
    private Request request;
   // check_responbody nnb=new check_responbody(this);
   // private  SignalRService mserv;
    private  final Context mconte=this;

private  boolean mBoind=false;

//List<acess_model>dataadapa;
    private static final int PERMISSION_CALLBACK = 111;
    private static final int PERMISSION_REQUEST = 222;
    com.astooltech.advancedview.database.DatabaseHelper helper;
private loginonlly log;
    Handler handler;
    Loadinglayoutt dqq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_act);
        helper=new DatabaseHelper(this);
        eventshow=this;
//View v= getLayoutInflater().inflate(R.layout.login_act,null);
        mess=new message_box(getApplicationContext());
        loginsys=(com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView)findViewById(R.id.loginsys);

      dqq  =findViewById(R.id.kkm);


dqq.setShowlogin(this);
dqq.setMessagess("Now Loading wait");
    //  dqq.attachTo(loginsys);
        dqq.showLoading();

        load2();
/*userr=(EditText)findViewById(R.id.user_names);
        loginsys=(AdvancedWebView)findViewById(R.id.loginsys);
        reg=(TextView)findViewById(R.id.reg);
       // pass_namevp=(EditText)findViewById(R.id.pass_namev);
        usertyp=(Spinner) findViewById(R.id.usertyp);
pass_name=(EditText)findViewById(R.id.pass_name);
 btnlog=(Button)findViewById(R.id.btn_login);*/
        //opensavjson=(Button)findViewById(R.id.btn_loginm);
        //preview=(Button)findViewById(R.id.btn_loginmv);
      //  loadspinner();
       /* log=new loginonlly(this);
        try {
            String getvall = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("mainlogin", this);
            log.runwebview(loginsys, getvall);
        }catch (Exception ex){

        }*/
     //   RequestQueue que= Volley.newRequestQueue(this);

       /* opensavjson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 Intent intent=new   Intent(b_login_activity.this,com.ordersalsemyntofi.astolnotf.json2view.savejson.class);
                startActivity(intent);
            }
        });*/

     /*   preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mserv.sendMessage_To(1);
                 Intent intent=new   Intent(b_login_activity.this,com.ordersalsemyntofi.astolnotf.json2view.MainActivity.class);
                startActivity(intent);
            }
        });*/
   /*  reg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new   Intent(b_login_activity.this,MainActivity2.class);
             startActivity(intent);
         }
     });
 btnlog.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
       String baseurl="http://192.168.1.101:80";
         String urll="/api/astoolacount/login";
         getdatusertyp googlePlaec = (getdatusertyp) usertyp.getSelectedItem();
         String c=  googlePlaec.getID().toString();
         String emailk=c.equals("1") ?userr.getText().toString():"no@email.com";
String resuu=getdatafrom("aapi");
try {
    String resul[] = GlobalClass.getBaseURL(resuu);
    baseurl=resul[0];
    urll=resul[1];
}catch (Exception ex){

}
     new AsyncTaskRunner().execute(getauthont(userr.getText().toString(),pass_name.getText().toString()),c,emailk,baseurl,urll);
     }
 });

 */
        //  loadInt();
    }
    private void load2(){
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                load();
            }
        },1000);
    }
public  void load(){

    ScriptModel g=new ScriptModel(0,"00", loginnurl);
    List<ScriptModel> h=helper.getAllNotes(g);
   // Log.e("dddd","ddddddd"+loginnurl);
    //   hedde.get(cx).setKeyValue(h.get(0).getContent());
    String getvall =h.get(0).getContent(); //com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("mainlogin", instwebf);
   Log.e("dddd",getvall);
    loginonlly log=new loginonlly(this,this);


   // qaa.setLayoutParams(new ViewGroup.LayoutParams(AdvancedWebView.LayoutParams.MATCH_PARENT,AdvancedWebView.LayoutParams.WRAP_CONTENT));
    log.runwebview(loginsys, getvall);

   // loginsys.addR.setLayoutParams(new AdvancedWebView.LayoutParams(AdvancedWebView.LayoutParams.MATCH_PARENT,AdvancedWebView.LayoutParams.MATCH_PARENT));

}
    public  void settreq(){
        final   String BASE_URL =   com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("mapi",getApplicationContext()); //"http://0.0.0.0:8080/api/astoolacount/login";

        RequestQueue q= Volley.newRequestQueue(this);

        StringRequest requestd = new StringRequest(com.android.volley.Request.Method.POST, BASE_URL ,new com.android.volley.Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                ScriptModel g=new ScriptModel(0,response,"mainlogin");




                // com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(hedde.get(cx).getKeyValue(),context);
                helper.insert(g);
                load();
                //login();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                eventshow.onerror(error.getMessage(),0);
               // qforOpeningActivity2();
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
                // add headers <key,value>
               /* headers.put("email", email);
                headers.put("usertyp", usertyp);
                headers.put("Authorization", auth);*/
                return headers;
            }

        };
        requestd.setRetryPolicy(new DefaultRetryPolicy(6000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        q.add(requestd);
    }
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    final OkHttpClient client = new OkHttpClient();

    String post(String json,String  auth,String email,String userty) throws IOException {
      //  RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("http://192.168.1.101:80/api/astoolacount/login")
                .method("GET", null) .addHeader("email", email)

                .addHeader("usertyp", userty)
                .addHeader("Authorization", auth)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    String bowlingJson(String email, String author) {





        return "{'email':'"+email+"',"
                + "'Authorization':'"+author+"',"
                + "'usertyp':1"
                     + "]}";
    }

    @Override
    public void loadfinshed() {

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dqq.hideOverlay(0);
                loginsys.setVisibility(View.VISIBLE);

            }
        },1000);


    }

    @Override
    public void onerror(String mess, Object ob) {
        dqq.hideOverlay(0);
        loginsys.setVisibility(View.GONE);
        dqq.setMessagess(mess);
        dqq.showError();

    }

    @Override
    public void OnRetray() {
        dqq.hideError();
        loginsys.setVisibility(View.GONE);
        dqq.showLoading();
        //settreq();
    }

    @Override
    public void loadmainActivity() {
        Intent intent=new   Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    public  class  getdatusertyp{

        public String getUsertyp() {
            return usertyp;
        }

        public void setUsertyp(String usertyp) {
            this.usertyp = usertyp;
        }

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

        private String usertyp;
        private  Integer ID;

        @Override
        public String toString() {
            return usertyp;
        }
    }
    public void  loadspinner(){

        List<getdatusertyp> m=new ArrayList<getdatusertyp>();
        getdatusertyp a=new getdatusertyp();
        getdatusertyp aa=new getdatusertyp();
        a.ID=1;
        aa.ID=0;
        a.usertyp="عميل";
        aa.usertyp="موظف";
        m.add(a);
        m.add(aa);
        ArrayAdapter<getdatusertyp> k=new ArrayAdapter<getdatusertyp>(this,android.R.layout.simple_spinner_item,m);
        k.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        usertyp.setAdapter(k);

    }


    private final OkHttpClient clients = new OkHttpClient();

    public void runbb() throws Exception {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

        try (Response response = clients.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

           /* Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }*/

            Log.i ("dddmmmmmmmmmmmmmm",response.toString());
        }
    }
    public  String setpashash(String pp){

       // mess.customToast(MD5(pp).toUpperCase()+"@@@@"+MD5(MD5(pp).toUpperCase()));
        String gg=getbase64(MD5(MD5(pp).toUpperCase()));
        return  gg;
    }

    public  String getbase64(String textt){

        String gg=Base64.encodeBase64String(textt.getBytes());
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

    private void login(){
      String acesstokk=getdatafrom("acesstoken");
      String reftokk=getdatafrom("refacesstoken");
        if(!acesstokk.equals("NO")){
            GlobalClass.acesstoken=acesstokk;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

      /* Intent restrt=new Intent(getApplicationContext(),this.getClass());
        restrt.setPackage(getPackageName());
        PendingIntent restart=PendingIntent.getService(getApplicationContext(),1,restrt,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager=(AlarmManager)getApplication().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+10,restart);

        //bindService(intent, mConnection, Context.BIND_AUTO_CREATE);


        // stoptimer();
        //  starttimer();
        Intent brodacst=new Intent();
        brodacst.setAction("restartservice");
        brodacst.setClass(this,restart_service.class);
        this.sendBroadcast(brodacst);*/
    }

    public void runactivity(){
        stoptimertask();
        qforOpeningActivity();

    }

    public void stoptimertask() {

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        checkiflog=false;

    }
    public void startTimer() {
        timer = new Timer();
        timerTask = new TimerTask() {
            public void run() {
             if(checkiflog) {
    runactivity();
                 }
                // Log.i("dddCount", "=========  "+ ());
            }
        };
        timer.schedule(timerTask, 5000, 2000); //
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

    //acesstoken
    public  void savetoref(String keyname,String kayval){
        try {

            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove(keyname);
            editor.putString(keyname,kayval);
            editor.commit();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void qforOpeningActivity(){
        Intent intent=new   Intent(b_login_activity.this,MainActivity.class);
        startActivity(intent);
          finish();
    }
    public  Map<String, Object> networkResponseToMap(NetworkResponse networkResponse) {
        Map<String, Object> response = new HashMap();
        try {


            Log.i("dddmmmmmmmkkkkkkkkk", networkResponse.headers.toString());
            Log.i("dddmmmmmmmkkkkkkkkk", networkResponse.data.toString());
        }catch (Exception ex){


        }
        response.put("headers", networkResponse.headers);
        response.put("data", new String(networkResponse.data));
        response.put("networkTimeMs", Long.valueOf(networkResponse.networkTimeMs));
        response.put("notModified", Boolean.valueOf(networkResponse.notModified));
        response.put("statusCode", Integer.valueOf(networkResponse.statusCode));
        return response;
    }










       /* RequestQueue q=Volley.newRequestQueue(this);
        String url="jj";
        JsonObjectRequest h=new JsonObjectRequest(com.android.volley.Request.Method.GET, url, , new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        q.add(h);*/

    private  String getauthont(String usernames,String password){

        String totl=usernames+":"+setpashash(password);
        byte[] encodbyr= Base64.encodeBase64(totl.getBytes());
        //Basic
String mm=new String(encodbyr);
String tott="Basic "+mm;
        return  tott;

    }
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
                String userAgentt=Settings.Secure.ANDROID_ID;
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

    Log.e("dddmmmmmmmkkkkkkkkk", jm);//.body());
//Gson mn=new Gson();
//response_cacher bn=mn.fromJson(jm,response_cacher.class);
    JSONObject js=new JSONObject(jm);
String bvc=js.get("data").toString();
    JSONObject jsm=new JSONObject(bvc);
   // mess.customToast(js.get("accessToken").toString());
  //  mess.customToast(jsm.get("usernames").toString());
  String mnb=  "Bearer "+jsm.get("accessToken").toString();
    savetoref("acesstoken", mnb);
    GlobalClass.acesstoken=mnb;
    GlobalClass.refreshtoken =jsm.get("refreshToken").toString();
    GlobalClass.username = jsm.get("usernames").toString();
    savetoref("refacesstoken", jsm.get("refreshToken").toString());
    savetoref("usernames", jsm.get("usernames").toString());

    savetoref("profile", jsm.get("profile").toString());
    savetoref("alfra", jsm.get("alfraname").toString());
    checkiflog=true;
  /*  Intent min=new Intent();
    min.setClass(mconte,SignalRService.class);
    bindService(min,mConnection,Context.BIND_AUTO_CREATE);*/
    qforOpeningActivity();
    // savetoref(x, response.body());
    Log.e("dddmmmmmmmkkkkkkkkk", response.body().string());//.body());

}else{
try {
    Log.e("dddmmmmmmmkkkkkkkkk", "hghghghghg");//.body());
    assert response.errorBody() != null;
String k=response.errorBody().string();
    typ_message v= typ_message.messagrror;
    mess.customToast(k,v,true);
   // savetoref(x, response.errorBody().string());
  //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
}catch (IOException ex){

}
}

                        } catch (Exception ex) {

                            mess.customToast(ex.getMessage());
                            stoptimertask();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        stoptimertask();
                            mess.customToast(t.getMessage()+"لا يوجد إتصال بالشبكة");
                        //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

                        Log.d("tag", "Error -> " + t.toString());
                    }
                });


            } catch (Exception ex) {
                mess.customToast(ex.getMessage());
                ex.getMessage();

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

}
