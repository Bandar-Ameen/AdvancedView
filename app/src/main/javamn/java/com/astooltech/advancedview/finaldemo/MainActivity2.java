package com.astooltech.advancedview.finaldemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ProcessLifecycleOwner;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.finaldemo.fragments.MainfragmentActivity;
import com.astooltech.advancedview.proteus.dynimicScript.RJSBridge;
//import com.astooltech.advancedview.proteus.dynimicScript.RJSResult;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;
import com.astooltech.advancedview.proteus.value.VolleyConnect;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.ProgressLayout;
import com.astooltech.advancedview.proteus.view.widget.MultiOverlayAdapter;


import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.astooltech.advancedview.GlobalClass.PREFS_NAME;
import static com.astooltech.advancedview.proteus.chatview.demo.ChatViewTestActivity.SELECT_VIDEO;

import org.json.JSONObject;


public class MainActivity2 extends AppCompatActivity {
   ProgressLayout ee;
    Button d1,d2,d3,d4;
    EditText ff;
    EditText ffl;
    EditText ffll;
    loadSettingsFirstly f;
    com.astooltech.advancedview.database.DatabaseHelper helper;

  public String res(String f){
      Log.e("uuu",f.toString());
      return f;
  }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        helper=new DatabaseHelper(this);
        f = new loadSettingsFirstly(MainActivity2.this, conectionbase.fir);
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .build();
        IntentFilter filter = new IntentFilter();

        filter.addAction("message");

        registerReceiver(getpro(), filter);
       // registerReceiver();

      /*h.SetLisiner(new SignalRConnectionbtweenClass() {
          @Override
          public void isconnected() {

          }

          @Override
          public void errorConnected() {

          }

          @Override
          public void sendData(String send, String typ, Object objdata) {

          }

          @Override
          public void ReceveData(String send, String typ, Object objdata) {
Toast.makeText(getApplication(),"gggggggggggg",Toast.LENGTH_LONG).show();
          }
      });*/
        ImageLoader.getInstance().init(config);
        d2=(Button)findViewById(R.id.uui2);
     final   GenericStatusLayout ffk= new GenericStatusLayout(this);
//final Button ffv=new Button( this);
//ffv.setLayoutParams(new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,200));
//ffk.attachTo(ffv);

      //  ed.showOverlay();
        //MultiOverlayAdapter eee=ffk.getAdapter();
       // d2.setVisibility(View.GONE);
GenericStatusLayout dqq=new GenericStatusLayout(this);
        //dqq.setLayoutParams(new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.));

      ee=(ProgressLayout) findViewById(R.id.ee);
        dqq.attachTo(ee);
       // dqq.attachTo(d2);
        dqq.showLoading();
     // ee.attachTo(d2);

        d1=(Button)findViewById(R.id.uui);
        d3=(Button)findViewById(R.id.uui3);

        ff=(EditText) findViewById(R.id.kk);
        ffl=(EditText) findViewById(R.id.kkl);
        ffll=(EditText) findViewById(R.id.kkll);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    openActivity(ff.getText().toString());
                /*    ScriptModel ;gk1 = new ScriptModel(0, "00",ff.getText().toString());

                    if(ff.getText().toString().startsWith("2")) {
                        String urlk=ffl.getText().toString();
                        ScriptModel gk1l = new ScriptModel(0,ffll.getText().toString(),urlk);
                        helper.insert(gk1l);
                        Log.e("uuu","Tamddddd");
                    }


                     else   if(ff.getText().toString().equals("1")) {



                        Map<String, String> Header=new HashMap<>();
                        HashMap<String,String> Headerx=new HashMap<>();

                        VolleyConnect dder = new VolleyConnect(MainActivity2.this);
                     final   String urlk=ffl.getText().toString();

                        dder.conn("get", Header, Headerx, urlk, "", null, new VolleyConnect.ResultResponse() {
                            @Override
                            public void OnSucess(String s) {
                                //   Log.e("uuubbb",s);
                                try {
                                    JSONObject y= new JSONObject(s);
                                    String c= y.get("data").toString();//.getAsString("data");
                                    Log.e("uuu","Tam");
                                    //Value v = getvall(c);
                                    ScriptModel gk1 = new ScriptModel(0, c, urlk);
                                    helper.insert(gk1);
                                }catch (Exception ex){
                                    Log.e("uuubbfffb",ex.getMessage());
                                }
                            }

                            @Override
                            public void OnError(String s) {
                                Log.e("iimnnn",s);
                            }
                        });




                            Log.e("mmurl", conectionbase.Alayout+"@@@"+conectionbase.Alayouts);

                    }else{

                        ff.setText(helper.getAllNotes(gk1).get(0).getContent());

                    }*/
                  //  ff.setText(helper.getAllNotesb(gk1).get(0)..getContent());
                  /*  if(ff.getText().toString().equals("1")) {

                        String SERVER_METHOD_SEND_TO = "get_weather";

                    }else    if(ff.getText().toString().equals("2")) {

                        String SERVER_METHOD_SEND_TO = "change_weather";

                    }else {
                       Object ob = RJSBridge.interpret(this, ff.getText().toString()).get(0).getResult();


                                      Toast.makeText(getApplicationContext(),ob.toString(),Toast.LENGTH_LONG).show();

                    }*/
                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 if(ff.getText().toString().equals("1")){
                    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("hii", ff.getText().toString(), getApplicationContext());
                }else   if(ff.getText().toString().equals("0")){
                    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("hii", ff.getText().toString(), getApplicationContext());
                }
              else  if(ff.getText().toString().equals("2")){


                      Intent intent=new   Intent(MainActivity2.this,com.astooltech.advancedview.proteus.chatview.demo.ChatViewTestActivity.class);
                     startActivity(intent);
                }

                 else {
                    com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("hi", ff.getText().toString(), getApplicationContext());
                }
                // com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("mapi",ff.getText().toString(),getApplicationContext());
            }
        });
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  savetoref("mapi",ff.getText().toString());
               if(ff.getText().toString().equals("1")){

                       Intent intent=new   Intent(MainActivity2.this,b_spalsh_screen.class);
                       startActivity(intent);
                       finish();

               }
                if(ff.getText().toString().equals("2")){
                    Intent intent=new   Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                if(ff.getText().toString().equals("7")){
                    Intent intent=new   Intent(MainActivity2.this,flex.class);
                    startActivity(intent);
                  //  finish();
                }
                if(ff.getText().toString().equals("9")){
                    Intent intent=new   Intent(MainActivity2.this,com.astooltech.advancedview.finaldemo.liveo.navigationliveo.MainActivity.class);
                    startActivity(intent);
                    //  finish();
                }
                if(ff.getText().toString().equals("10")){
                    Intent intent=new   Intent(MainActivity2.this, MainfragmentActivity.class);
                    startActivity(intent);
                    //  finish();
                }

                if(ff.getText().toString().equals("5")){
                    Intent intent=new   Intent(MainActivity2.this,com.astooltech.advancedview.finaldemo.liveo.interfaces.MainActivity.class);
                    startActivity(intent);
                    //  finish();
                }



                if(ff.getText().toString().equals("3")){
                    ffk.hideEmpty();//Empty();
                    ffk.hideError();

                    ffk.showLoading();
                }
                if(ff.getText().toString().equals("4")){
                    ffk.hideEmpty();//Empty();
                    ffk.hideError();
                    ffk.hideLoading();
                    ffk.attachTo(d2);
                   // ffk.showOverlay(0);
                }

                if(!ff.getText().toString().equals("7")){

                    // ffk.showOverlay(0);
                }
                if(ff.getText().toString().equals("5")){

                  // Gson g=new Gson();
              Toast.makeText(getApplicationContext(),String.valueOf(Build.VERSION.SDK_INT),Toast.LENGTH_LONG).show();

                    // ffk.showOverlay(0);
                }

            }
        });

        //ee.addView(ffk);

    }
    BroadcastReceiver ccet=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //  mcontext=context;

            /*get action name from activity which is trigger the broadcast receiver*/
            String action = intent.getAction();

            /*check action name*/
            if(action.equals("message")) {

                Toast.makeText(getApplicationContext(),"ffff",Toast.LENGTH_LONG).show();

            }

        }
    };

  private void openActivity(String eew){
      try{




          Class<?> tclas = Class.forName(eew);
          Intent intent = new Intent(this, tclas);

          //  intent.putExtra("data", dv);
      //    ActivityOptions op=ActivityOptions.makeCustomAnimation(context,R.anim.fade_in,R.anim.fade_out);
          // v.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
          //views.getViewManager().getContext().getActvityAllt().startActivity(intent,op.toBundle());
       startActivity(intent);
      }catch (ClassNotFoundException ex){
          Log.e("777", ex.getMessage());
      }
  }
    private BroadcastReceiver prodac;
    private BroadcastReceiver getpro(){
        if(prodac==null){

            prodac=ccet;
        }
        return prodac;

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Uri> mSelected;
       // mSelected = Matisse.obtainResult(data);
   Log.e("rr",     getPathVideo(data.getData()));
    }
    public String getPathVideo(Uri uri) {
        System.out.println("getpath "+uri.toString());
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if(cursor!=null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        else return null;
    }
    @Override public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("message");
        registerReceiver(getpro(),filter);

    }
    @Override public void onPause() {
        super.onPause();
        unregisterReceiver(getpro());



    }
    public  void savetoref(String keyname, String kayval){
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
    MultiOverlayAdapter eu= new MultiOverlayAdapter() {
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public View getView(int i, View view) {
            return null;
        }
    };


 /* @Subscribe
    public void onLocationChanged(QiscusCommentReceivedEvent event) {
        // Stop existing download, if it exists.

    Log.e("yyuuuyyyyyyuu",    event.getQiscusComment().getExtraPayload());
        /* if (downloadTask != null) {
            downloadTask.cancel(true);
        }

        // Trigger a background download of an image for the new location.
        downloadTask = new LocationMapFragment.DownloadTask();
        downloadTask.execute(String.format(URL, event.lat, event.lon));
    }*/
}