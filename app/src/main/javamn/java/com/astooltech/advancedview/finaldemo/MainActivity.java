package com.astooltech.advancedview.finaldemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.inlineactivityresult.InlineActivityResult;
import com.astooltech.advancedview.inlineactivityresult.callbacks.ActivityResultListener;
import com.astooltech.advancedview.inlineactivityresult.request.RequestFabric;
import com.astooltech.advancedview.proteus.ALLEvent;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.BottomShitDaloge;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentOverall;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views.HeaderView;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.demo.CircleViewParser;
import com.astooltech.advancedview.proteus.demo.MyReceiver;
import com.astooltech.advancedview.proteus.demo.ProteusActivity;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.URLdatamodel;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.demo.api.loadfirstly;
import com.astooltech.advancedview.proteus.demo.api.notfi_refresh_data;
import com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss;
import com.astooltech.advancedview.proteus.demo.converter.GsonConverterFactory;
import com.astooltech.advancedview.proteus.design.DesignModule;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.NotificationActivity;
import com.astooltech.advancedview.proteus.parser.NotificationHelper;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.adapterskit.ShitDailogeFragments;
import com.astooltech.advancedview.proteus.parser.message_box;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.Action;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentActionFragment;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebPermissions;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentWebUtils;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.RxActivityResult;
import com.astooltech.advancedview.proteus.v4.SupportV4Module;
import com.astooltech.advancedview.proteus.v7.AutoCompleteTextViewModel;
import com.astooltech.advancedview.proteus.v7.CardViewModule;
import com.astooltech.advancedview.proteus.v7.RecyclerViewModule;
import com.astooltech.advancedview.proteus.v7.SliderViewModel;
import com.astooltech.advancedview.proteus.v7.SppinerViewBModel;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.LodaingLayout;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.astooltech.advancedview.proteus.view.custom.DynamicBox;
import com.astooltech.advancedview.finaldemo.fragments.customshit;
import com.astooltech.advancedview.finaldemo.opengraphview.OpenGraphViewProtouseParser;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import retrofit2.Retrofit;

import static com.astooltech.advancedview.GlobalClass.Whiting;
import static com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic.BASE_URL;
import static com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.agentwebcor.AgentActionFragment.start;

public class MainActivity extends AppCompatActivity implements  getmessage_status, notfi_refresh_data, OnFragmentInteractionListener,  NavigationView.OnNavigationItemSelectedListener, loadfirstly, MyReceiver.ConnectivityReceiverListener, FlexibleAdapter.OnItemMoveListener, SearchView.OnQueryTextListener,FlexibleAdapter.OnItemSwipeListener,FlexibleAdapter.OnItemLongClickListener, FastScroller.OnScrollStateChangeListener, StatuseLayout,loadSettingsFirstly.Sucessconn {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button bt1,bt2;
    private AppBarLayout app;
    public DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    getmessage_status masss;
    private HeaderView mHeaderView;
    private BroadcastReceiver prodac;
    private loadSettingsFirstly f;
    private  Proteus proteus;
    private    String[] dataURL;
    public AbstractFragment mFragment;
    private ViewGroup container;
    private Retrofit retrofit;
    private  loadfirstly loadfirst;
    LodaingLayout contin;
    public  String BASE_URLx = "http://0.0.0.0:8080";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.aa_activity_main_dd);
        f=new  loadSettingsFirstly(this,conectionbase.fir);
        initializeFragment(savedInstanceState);
        initializeToolbar();
        initializeDrawer();
        //RxActivityResult.register(this);
        //  mDrawer.open();
        loadfirst=this;
        app=(AppBarLayout)findViewById(R.id.app_bar);






        app=(AppBarLayout)findViewById(com.astooltech.advancedview.R.id.app_bar);

        app.setVisibility(View.GONE);
        dataURL=    getdataa();

        container = findViewById(R.id.recycler_view_container);
        contin=findViewById(com.astooltech.advancedview.R.id.waitcontiner);
        container.setVisibility(View.GONE);
        contin.setMessagess(Whiting);
        //  dqq.attachTo(loginsys);
        contin.showLoading();
        contin.setShowlogin(this);
       /* box=new DynamicBox(this,container);
        box.setLoadingMessage("now Loading....");
        box.setInternetOffMessage("no Enternet Connection");
        box.setOtherExceptionMessage("noooo other");
        box.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        box.showLoadingLayout();*/

        // mess = new message_box(getApplicationContext());
        try {
            BASE_URLx = dataURL[5];//getdatafrom("ip");
        }catch (Exception ex){

        }

        proteus=   new ProteusBuilder().register(new OpenGraphViewProtouseParser())
                /* .register(SupportV4Module.create())
                 .register(RecyclerViewModule.create())
                 .register(SliderViewModel.create())
                 .register(AutoCompleteTextViewModel.create())
                 .register(SppinerViewBModel.create())
                 .register(CardViewModule.create())
                 .register(DesignModule.create())
                 .register(new CircleViewParser())*/
                .build();
        // ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.setProteus(proteus);
        //  proteusManager = new getprotouse(retrofit,this, this);
        connectivityReceiverListener=this;
        /* loadfromcustom();*/
       /* ed1=(EditText)findViewById(R.id.url1);
        ed2=(EditText)findViewById(R.id.url2);
        ed3=(EditText)findViewById(R.id.url3);
        ed4=(EditText)findViewById(R.id.url4);
        ed5=(EditText)findViewById(R.id.method);
        bt1=(Button)findViewById(R.id.btnsave);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loaddds();
            }
        });
        bt2=(Button)findViewById(R.id.btlogin);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadddsv();
            }
        });*/
        // proteusManager.addListener(this);
        //    show_daloge_prograss=new show_daloge_prograss(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                f.isexitsornot();
                loadfirst.loadfist("h");
                //new AsyncTaskRunner().execute();
            }
        },200);

    }




    public void setdata(){
        //proteusManagerr=proteusManager;
        //dataURLl=dataURL;
        masss=this;
       /* massss=this;
        mDrawerr=mDrawer;
        layoutt=layout;
        layoutss=layouts;

        containerr=container;
        mFragmentt=mFragment;
        styless=styles;
        loaderr=loader;
        dataa=data;
        mProteusManagerr=this;
        Activ=this;*/

     /*   tre    = new MyReceiver();
        MyReceiver.connectivityReceiverListener = this;
        MyReceiver.usefilter=true;
        MyReceiver.Filtername="android.net.conn.CONNECTIVITY_CHANGE";

        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }*
        //}*/
        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        registerReceiver(getpro(), filter);
        //  intilations();

    }
    public void open(){
        bittomshitdaloge tr=new bittomshitdaloge(this);
        tr.show(getSupportFragmentManager(),"bbnnn");

    }
    public void onloadd(){


        // data = proteusManager.getData();
        // setmydatt();

        com.astooltech.advancedview.database.DatabaseHelper tt=new DatabaseHelper(this);

     /*   String   ddata=proteusManager.getDdata();

        String   sstyles=proteusManager.getSstyles();
        String   llayouts=proteusManager.getLlayouts();
        String  rrootLayout=proteusManager.getRrootLayout();
*/
     /*   ScriptModel g=new ScriptModel(0,"00", dataURL[1]);
        List<ScriptModel>  h= tt.getAllNotes(g);*/
        String ddata=    "{}";
        // String ddata = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[1],this);

        //String rrootLayout = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[2],this);
        ScriptModel gx=new ScriptModel(0,"00",f.getfulUrl(conectionbase.Alayout));
        List<ScriptModel>  hx= tt.getAllNotes(gx);
        String rrootLayout=    hx.get(0).getContent();

        // Log.e("ggg",rrootLayout);
        // String llayouts = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[3],this);
        ScriptModel gx1=new ScriptModel(0,"00", f.getfulUrl(conectionbase.Alayouts));
        List<ScriptModel>  hx1= tt.getAllNotes(gx1);
        String llayouts=    hx1.get(0).getContent();

        //  Log.e("ggg",llayouts);
        // String sstyles = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[4],this);
        ScriptModel gx11=new ScriptModel(0,"00", f.getfulUrl(conectionbase.AStyles));
        List<ScriptModel>  hx11= tt.getAllNotes(gx11);
        String sstyles=    hx11.get(0).getContent();
        // skeletonViewGroup.stopShimmer();
        setdata();
        proteus.createContextBuilder(this)
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dataURL)
                .setFrgmentMangers(getSupportFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(masss).setRootLayout(rrootLayout).setData(ddata).setStyles(sstyles).setLayouts(llayouts)
                .setmFragmenttv(mFragment)
                .SetActivitys(this).setStatuse(this)
                .build();

        //  setdata();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);*/
    }
    private  void loadfromcustom(){
        try {
            //  ProteusApi api = manager.api;
            Toast.makeText(this,"f",Toast.LENGTH_LONG);
            String mdat = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[1],this);

            String rootlaout = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[2],this);
            Log.e("ggg",rootlaout);
            String laoutt = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[3],this);

            Log.i("ggg",laoutt);
            String styleet = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[4],this);


            // setdata(,mdat,rootlaout,styleet);
        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
            // manager.broadcast(ex.getMessage());
        }



    }
    public void setdata(String layouts,String data,String rootlayout,String sty){
        // proteusManagerr=proteusManager;
        //dataURLl=dataURL;
        masss=this;
      /*massss=this;
      mDrawerr=mDrawer;
      layoutt=layout;
layoutss=layouts;

      containerr=container;
      mFragmentt=mFragment;
      styless=styles;
      loaderr=loader;
      dataa=data;
      mProteusManagerr=this;
      Activ=this;*/

     /*   tre    = new MyReceiver();
        MyReceiver.connectivityReceiverListener = this;
        MyReceiver.usefilter=true;
        MyReceiver.Filtername="android.net.conn.CONNECTIVITY_CHANGE";

        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }*
        //}*/
        /*IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        registerReceiver(getpro(), filter);*/


        proteus.createContextBuilder(this)
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dataURL)
                .setFrgmentMangers(getSupportFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(masss).setRootLayout(rootlayout).setData(data).setStyles(sty).setLayouts(layouts)
                .setmFragmenttv(mFragment)
                .SetActivitys(this).setStatuse(this)
                .build();
        //box.hideAll();
        //intilations();

    }
    private BroadcastReceiver getpro(){
        if(prodac==null){

            prodac=ccet;
        }
        return prodac;

    }
    MyReceiver.ConnectivityReceiverListener connectivityReceiverListener;
    BroadcastReceiver ccet=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //  mcontext=context;

            /*get action name from activity which is trigger the broadcast receiver*/
            String action = intent.getAction();

            /*check action name*/
            if (("android.net.conn.CONNECTIVITY_CHANGE").equals(action)) {
                String datvcx=intent.getDataString()+"@@@"+intent.getPackage()+"@@";
                ConnectivityManager cm = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null
                        && activeNetwork.isConnectedOrConnecting();
                //  Log.e("receiver", "on");
                if (connectivityReceiverListener != null) {
                    connectivityReceiverListener.onNetworkConnectionChanged(isConnected, 1, datvcx);
                }

            }

        }
    };
    private  String[] getdataa(){
        String[] ddd=new
                String[]{"he"};
        try {
            String dataa = "0";
            //  if (data.equals("0")) {
            dataa = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("api",this);;

          /*  } else {
                dataa = data;
            }*/
            //Log.i("jjjjjjjjj",dataa);

            Gson ff = new Gson();
            Type type = new TypeToken<List<URLdatamodel>>() {

            }.getType();
            List<URLdatamodel> kmn = ff.fromJson(dataa, type);


            return new String[]{kmn.get(0).getMethode(), kmn.get(0).getMethodurl(), kmn.get(1).getMethodurl(), kmn.get(2).getMethodurl(), kmn.get(3).getMethodurl(), kmn.get(4).getBaseurl()};
        }catch (Exception ex){
            // Log.i("jjjjjjjjj",ex.getMessage());
            return  ddd;

        }
    }

    public void loadddsv(){
        try {
            Intent b = new Intent(MainActivity.this, com.astooltech.advancedview.proteus.demo.ProteusActivity.class);
            b.putExtra("typActivity", "0");
            String grtd=com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("api",this);
            b.putExtra("api", grtd);
            startActivity(b);
        }catch (Exception ex){

        }
    }
    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    private void initializeToolbar() {
        //com.ordersalsemyntofi.astolnotf.dynimicall.proteus.anotherView.flexibleadapter.utils.Log.d("initializeToolbar as actionBar");
        mToolbar = (Toolbar) findViewById(com.astooltech.advancedview.R.id.toolbar);
        mToolbar.setVisibility(View.GONE);
        mHeaderView = (HeaderView) findViewById(com.astooltech.advancedview.R.id.toolbar_header_view);
        mHeaderView.bindTo(getString(com.astooltech.advancedview.R.string.app_name), getString(com.astooltech.advancedview.R.string.overall));
        //mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        // Toolbar will now take on default Action Bar characteristics

        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(com.astooltech.advancedview.R.menu.menu_overall);
    }


    private void initializeDrawer() {
        mDrawer = (DrawerLayout) findViewById(com.astooltech.advancedview.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, com.astooltech.advancedview.R.string.navigation_drawer_open, com.astooltech.advancedview.R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(com.astooltech.advancedview.R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        Menu dd=mNavigationView.getMenu();
        dd.add("ddddddsssss");
        // Version
      /*  TextView appVersion = mNavigationView.getHeaderView(0).findViewById(R.id.app_version);
        appVersion.setText(getString(R.string.about_version, Utils.getVersionName(this)));*/
    }
    public void initializeFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mFragment = (AbstractFragment) getSupportFragmentManager().getFragment(savedInstanceState, STATE_ACTIVE_FRAGMENT);
        }
        DatabaseService.getInstance().createOverallDatabase(getApplicationContext().getResources());
        if (mFragment == null) {
            mFragment = FragmentOverall.newInstance(2,0,null,DatabaseService.getInstance().getDatabaseList());
        }
      /*  FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.recycler_view_container,
                mFragment).commit();*/

        //recycler_view_container
    }

    public void loaddds(){
        try {


            Gson ff = new Gson();
            Type type = (new TypeToken<List<URLdatamodel>>() {
            }).getType();
            List<URLdatamodel> kmn = (List) ff.fromJson(ed1.getText().toString(), type);
            String jsonn = ff.toJson(kmn);
            com.astooltech.advancedview.proteus.demo.SaveAndGetValue.savetoref("api",jsonn,this);

        }catch (Exception ex){
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG);
        }
    }



    @Override
    public void showmessage(String s, int i, String s1) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int i) {

    }

    @Override
    public void initSearchView(Menu menu) {

    }

    @Override
    public void onFastScrollerStateChange(boolean b) {

    }

    @Override
    public void onItemLongClick(int i) {

    }

    @Override
    public boolean shouldMoveItem(int i, int i1) {
        return false;
    }

    @Override
    public void onItemMove(int i, int i1) {

    }

    @Override
    public void onItemSwipe(int i, int i1) {

    }

    @Override
    public void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public void loadfist(Object o) {
        onloadd();
        //   box.hideAll();
        //proteusManager.load(dataURL);
    }

    @Override
    public void change_data(String s, int i, ObjectValue objectValue) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onNetworkConnectionChanged(boolean b, int i, String s) {

    }

    @Override
    public void loadfinshed() {

        //  Log.e("hghghghg","jhjhjhjhjhjh");
        //  Toast.makeText(this,"hhhhhhhhhhhhh",Toast.LENGTH_LONG).show();

        contin.hideLoading();
        container.setVisibility(View.VISIBLE);
    }

    @Override
    public void onerror(String mess, Object ob) {

        // Log.e("hghghghg","jhjhjhjhjhjh");
        contin.setMessagess(mess);
        contin.hideLoading();
        contin.showError();
    }


    @Override
    public void OnRetray() {

    }

    @Override
    public void isSucess() {

    }

    @Override
    public void isError(String e) {

    }
}