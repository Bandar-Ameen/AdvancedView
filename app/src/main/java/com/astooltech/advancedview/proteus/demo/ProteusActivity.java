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

package com.astooltech.advancedview.proteus.demo;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.CursorWindow;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.demo.api.ProteusApi;
import com.astooltech.advancedview.proteus.demo.api.ProtuseLisiner;
import com.astooltech.advancedview.proteus.design.DesignModule;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.DownloadImpl;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.download.library.Downloader;
import com.astooltech.advancedview.proteus.v4.SupportV4Module;
import com.astooltech.advancedview.proteus.v7.AutoCompleteTextViewModel;
import com.astooltech.advancedview.proteus.v7.CardViewModule;
import com.astooltech.advancedview.proteus.v7.RecyclerViewModule;
import com.astooltech.advancedview.proteus.v7.SliderViewModel;
import com.astooltech.advancedview.proteus.v7.SppinerViewBModel;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.LayoutManager;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.StyleManager;
import com.astooltech.advancedview.proteus.Styles;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentOverall;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views.HeaderView;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.ProtouseAbstractActivity;
import com.astooltech.advancedview.proteus.demo.api.URLdatamodel;

import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.demo.api.loadfirstly;
import com.astooltech.advancedview.proteus.demo.api.notfi_refresh_data;
import com.astooltech.advancedview.proteus.demo.api.resultData;
import com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss;
import com.astooltech.advancedview.proteus.demo.converter.GsonConverterFactory;
import com.astooltech.advancedview.proteus.exceptions.ProteusInflateException;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.skeleton.SkeletonViewGroup;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModel;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModelBuilder;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.DrawableValue;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.custom.DynamicBox;
import com.astooltech.advancedview.proteus.parser.message_box;

import org.json.JSONException;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.json.JSONObject;
import org.jsoup.safety.Cleaner;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class ProteusActivity extends AppCompatActivity implements ProteusManager.Listener, getmessage_status, notfi_refresh_data, OnFragmentInteractionListener,  NavigationView.OnNavigationItemSelectedListener, loadfirstly,MyReceiver.ConnectivityReceiverListener, FlexibleAdapter.OnItemMoveListener, SearchView.OnQueryTextListener,FlexibleAdapter.OnItemSwipeListener,FlexibleAdapter.OnItemLongClickListener, FastScroller.OnScrollStateChangeListener {

    public ProteusManager proteusManager;
    private ProteusLayoutInflater layoutInflater;
    private notfi_refresh_data dat_refresh;
    ObjectValue data;
    Layout layout;
    Styles styles;
    Map<String, Layout> layouts;
    getmessage_status masss;
    private StyleManager styleManager = new StyleManager() {

        @Nullable
        @Override
        protected Styles getStyles() {
            return styles;
        }
    };

    private LayoutManager layoutManager = new LayoutManager() {

        @Nullable
        @Override
        protected Map<String, Layout> getLayouts() {
            return layouts;
        }
    };

    /**
     * Simple implementation of ImageLoader for loading images from url in background.
     */
    private ProteusLayoutInflater.ImageLoader loader = new ProteusLayoutInflater.ImageLoader() {
        @Override
        public void getBitmap(ProteusView view, String url, final DrawableValue.AsyncCallback callback)  {

            try {


//Picasso.with(this).load(url).placeholder(R.drawable.progress_drawable_seekbar).
                //  Picasso.get().load(url).placeholder(R.drawable.placeholder).into(new  ImageLoaderTarget(callback,getApplicationContext()));
  /*  GlideApp.with(ProteusActivity.this)
            .load(url)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.image_broken)
            .into(new ImageLoaderTarget(callback));*/
                // callback.apply(convertBitmapToDrawable(bitmap, view.getAsView().getContext()));
  /*Bitmap v = Picasso.get().load(url).placeholder(R.drawable.placeholder).get();
    callback.setBitmap(v);*/
                // view.B.setBitmap(v);

                //  callback.setBitmap(v);//.placeholder(R.drawable.placeholder).into(h_1);
            }catch (Exception ex){



            }


        }
    };

    /**
     * Implementation of Callback. This is where we get callbacks from proteus regarding
     * errors and events.
     */
    private String xback="0";
    @Override
    public void onbackpress(String a1, String a2) {
        xback=a1;

    }

    private ProteusLayoutInflater.Callback callback = new ProteusLayoutInflater.Callback() {

        @NonNull
        @Override
        public ProteusView onUnknownViewType(ProteusContext context, String type, Layout layout, ObjectValue data, int index) {
            // TODO: instead return some implementation of an unknown view
            throw new ProteusInflateException("Unknown view type '" + type + "' cannot be inflated");
        }

        @Override
        public void onEvent(String event, Value value, ProteusView view) {



            Log.i("ProteusEvent", "mmmnnnnnnnnnnnnnnnnnnnvvvvvvvvvvvvvvvvvvvvvvvv");
        }




        public  void getValueAndSetToView(){



        }
        private  boolean checknull=false;




        @Override
        public void onEventTage(final String Tag, final String event, final Value value, final ProteusView view) {

           // data_processing.onEventsendbasic(Tag,event,value,view);





        }



        @Override
        public void onEventAdapter(final int typ, final String Tag, final String event, final ObjectValue value, final ProteusView view) {



           // data_processing.onEvenٍsend(typ,Tag,event,value,view);



        }

        @Override
        public void onEventAdapter(int typ, String Tag, String event, ObjectValue value, ProteusView view, EventProcessor eventproc,boolean withtage,String[] somedsta) {
           // data_processing.onEvenٍsend(typ,Tag,event,value,view,eventproc,withtage,somedsta);
        }


    };

    ProteusView view;
    private ViewGroup container;
    private Gson gson;
    private Retrofit retrofit;
    private   List<resultData> allunit;
    private   List<DataValueSelect> result_setData;
    private   message_box mess;
    private String Apigetdata="0";
    private String typActivity="0";
    public   String[] dataURL;
    private  Dialog dd;
    private  ViewGroup datadaloge;
    private  loadfirstly loadfirst;
    private  boolean showdaloge;
    private static final String PREFS_NAME = "TCPClientConf";

    private show_daloge_prograss show_daloge_prograss;
    private static  String BASE_URL = "http://0.0.0.0:8080/admin3/";
    public AbstractFragment mFragment;
    private boolean checkdata=false;
    private AppBarLayout app;
    public DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private HeaderView mHeaderView;
    private BroadcastReceiver prodac;
    private DynamicBox box;
    //private OverlayLayout mlayout;
    //   private ShimmerFrameLayout skeletonViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_activity_main_dd);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //  MyReceiver.connectivityReceiverListener=this;
        //  myReceiver = new MyReceiver();

        //    // AppController.getInstance().setConnectivityListener(this);
        //   checkConnection();
        showdaloge=false;
        loadfirst=this;
        // String  resul[]=GlobalClass.getBaseURL(urldat);

        //  String typp[]=new String[]{"0","dataUrl","layouturl","layouturl","styleurl"};

        Bundle bundle=getIntent().getExtras();
        if (bundle != null) {
            typActivity= bundle.getString("typActivity");
            Apigetdata = bundle.getString("api");

        }

        initializeFragment(savedInstanceState);
        initializeToolbar();
        initializeDrawer();
        //  mDrawer.open();
        app=(AppBarLayout)findViewById(R.id.app_bar);

        // app.setVisibility(View.GONE);
        dataURL=    getdataa(Apigetdata);


        dat_refresh=this;



        allunit=new ArrayList<resultData>();
        result_setData=new  ArrayList<DataValueSelect>();
        // set the toolbar

        try {
            mess = new message_box(getApplicationContext());
            BASE_URL = dataURL[5];//getdatafrom("ip");

            //  Log.i("vvvv",BASE_URL);
            // Toolbar toolbar = findViewById(R.id.toolbar);
            // setSupportActionBar(toolbar);

            // setBoolean refresh button click
   /* FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        alert("AlertDialogLayout");
      }
    });*/

            container = findViewById(R.id.recycler_view_container);
            box=new DynamicBox(this,container);
            box.setLoadingMessage("now Loading....");
            box.setInternetOffMessage("no Enternet Connection");
            box.setOtherExceptionMessage("noooo other");
            box.setClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            box.showLoadingLayout();
       /* mlayout=new OverlayLayout(this) {
            @Override
            protected View createOverlayView() {

              TextView dd=new TextView(ProteusActivity.this);
              dd.setText("fffffffffff");
                return dd;
            }
        };
        mlayout.attachTo(container);
        mlayout.showOverlay();*/

            //  skeletonViewGroup =(ShimmerFrameLayout) findViewById(R.id.shimmer_view_container);

            //  skeletonViewGroup.startShimmer();
            String layouuuu = "";
            String dataa = "";


            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(this);
            gson = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();


            // add gson to retrofit to allow deserializing proteus resources when fetched via retrofit
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


            proteusManager = new ProteusManager(retrofit,this,ProteusActivity.this);
            connectivityReceiverListener=this;
       /* ProteusContext context = proteusManager.getProteus().createContextBuilder(this)
                .setLayoutManager(layoutManager)
                .setCallback(callback)
                .setImageLoader(loader)
                .setStyleManager(styleManager)
                .build();

        layoutInflater = context.getInflater();

        data_processing=new all_action_Activity(container,this,proteusManager,dataURL,layoutInflater,masss,getSupportFragmentManager(), mFragment,mDrawer);
        connectedActivityMdel.getinstance().setlisner(callback);
        connectedActivityMdel.getinstance().setInflater(layoutInflater);
        show_daloge_prograss=new show_daloge_prograss(ProteusActivity.this);
        proteusManager.addListener(this);

mDrawer=mDrawer;
        intilations();
        */
            proteusManager.addListener(this);
            show_daloge_prograss=new show_daloge_prograss(this);

      /*  dd=   show_daloge_prograss.showdailog();
        dd.show();*/
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadfirst.loadfist("h");
                    //new AsyncTaskRunner().execute();
                }
            },200);



        }catch (Exception ex){

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
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

    private BroadcastReceiver getpro(){
        if(prodac==null){

            prodac=ccet;
        }
        return prodac;

    }
    public void sendntofc(){}


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

    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    private void initializeToolbar() {
        //com.ordersalsemyntofi.astolnotf.dynimicall.proteus.anotherView.flexibleadapter.utils.Log.d("initializeToolbar as actionBar");
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setVisibility(View.GONE);
        mHeaderView = (HeaderView) findViewById(R.id.toolbar_header_view);
        mHeaderView.bindTo(getString(R.string.app_name), getString(R.string.overall));
        //mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        // Toolbar will now take on default Action Bar characteristics

        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_overall);
    }



    private void initializeDrawer() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
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

    private  String[] getdataa(String data){
        String[] ddd=new
                String[]{"he"};
        try {
            String dataa = "0";
            if (data.equals("0")) {
                dataa = getdatafrom("ip");

            } else {
                dataa = data;
            }
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
    private String getdatafrom(String textt){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }

    @Override
    protected void onResume() {
        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        registerReceiver(getpro(), filter);
        super.onResume();
    }



    @Override
    protected void onPause() {
        unregisterReceiver(getpro());
        super.onPause();

    }

    public void refreshallviews(){
        //  proteusManager.removeListener(this);
        onloadd();
    }
    public void refreshallviewss(){

        proteusManager.removeListener(this);
        proteusManager.addListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadfirst.loadfist("h");
                //new AsyncTaskRunner().execute();
            }
        },200);
        //  onloadd();
    }
    /* @Override
     public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main, menu);
       return true;
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();
       switch (id) {
         case R.id.reload:
          // reload();
           return true;
       }
       return super.onOptionsItemSelected(item);
     } render
   */
    @Override
    public void onLoad() {
        // container


        refreshallviews();

        //Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
    }


    public void onloadd(){


        data = proteusManager.getData();
        // setmydatt();


        layout =proteusManager.getRootLayout();
        layouts = proteusManager.getLayouts();
        styles = proteusManager.getStyles();
     String   ddata=proteusManager.getDdata();
     String   sstyles=proteusManager.getSstyles();
     String   llayouts=proteusManager.getLlayouts();
      String  rrootLayout=proteusManager.getRrootLayout();
        // skeletonViewGroup.stopShimmer();
        setdata();
       proteusManager.getProteus().createContextBuilder(this)
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dataURL)
                .setFrgmentMangers(getSupportFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(masss).setRootLayout(rrootLayout).setData(ddata).setStyles(sstyles).setLayouts(llayouts)
                .setmFragmenttv(mFragment)
                .SetActivitys(this)
                .build();
box.hideAll();
        //  setdata();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);*/
    }
    public void setmydatt(){
        Array c=new Array();
        c.add("hello1");
        c.add("hello2");
        c.add("hello3");
        c.add("hello4");
        data.add("bandar",c);


    }
    @Override
    public void onError(@NonNull Object e) {
        box.setOtherExceptionMessage(e.toString());
        box.setOtherExceptionTitle("Error");
        box.showExceptionLayout();
        box.setClickListener(null);
        box.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshallviewss();
                checkkn=false;
            }
        });
        if(checkkn){
            mess.customToast(e.toString());
        }

    }
    private boolean checkkn;
    private void alert(String namee,String Dataav ) {

        try {
       /* Intent intent = new Intent(getApplicationContext(),  ProteusActivity.class);

        startActivity(intent);
*/
            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(ProteusActivity.this);
            Gson gsonn = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();
            Type type = new TypeToken<Value>() {

            }.getType();
            Value tempp = gsonn.fromJson(Dataav, type);
            ObjectValue kknm=new ObjectValue();
            kknm.add("s0",tempp);

            ProteusView view = layoutInflater.inflate(namee, kknm);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setView(view.getAsView())
                    .setPositiveButton(R.string.action_alert_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            showdaloge=false;
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
            showdaloge=true;
            // Log.i("kkmmnnnnnn","hghghghghggfgfgfgfgf");
            datadaloge=(ViewGroup)view.getAsView();
            // Log.i("kkmmnnnnnn","hghghghghggfgfgfgfgf");

        }catch (Exception ex){


            showdaloge=false;
        }
    }


    void render() {

        // remove the current view
        //  container.removeAllViews();

        // Inflate a new view using proteus
        long start = System.currentTimeMillis();
      /*  view = layoutInflaterr.inflate(layoutt, dataa, containerr, 0);
        // System.out.println("inflate time: " + (System.currentTimeMillis() - start));

        // Add the inflated view to the container
        containerr.addView(view.getAsView());
        box.hideAll();*/
        checkkn=true;
        //  mlayout.hideOverlay();
        //showalertonly("hh");
        //  skeletonViewGroup.stopShimmer();

        // dd.dismiss();
    }
    private void showalertonly(String namee){

        ProteusView view = layoutInflater.inflate("my", proteusManager.getData());

        Toast toast = new Toast(this.getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view.getAsView());
        toast.show();
    }

    void reload() {
        //proteusManager.update();
    }

    public void showmeesav(ObjectValue ff,String keyold,String keynam){


        Iterator<Map.Entry<String, Value>> vv = ff.entrySet().iterator();
        while (vv.hasNext()) {

            Map.Entry<String, Value> ddertt = vv.next();
            if(ddertt.getValue().isObject()){
                if(keynam.equals(ddertt.getKey())){
                    mess.customToast(ddertt.getValue().toString());

                }else {
                    showmeesav(ddertt.getValue().getAsObject(), keyold, keynam);
                }
            }else  if(ddertt.getValue().isArray()) {


                for(int cc=0;cc<ddertt.getValue().getAsArray().size();cc++){





                    if(ddertt.getValue().getAsArray().get(cc).isObject()){
                        String kkm= ddertt.getValue().getAsArray().get(cc).getAsObject().get(keynam).toString();
                        if(kkm!=null) {
                            mess.customToast(kkm);
                            //showmeesav(ddertt.getValue().getAsArray().get(cc).getAsObject(), keyold, keynam);
                        }else {
                            showmeesav(ddertt.getValue().getAsArray().get(cc).getAsObject(), keyold, keynam);
                        }
                    }else {
                        //  Gson g=new Gson();
                        Log.i("88888", ddertt.getValue().getAsArray().get(cc).toString());
                    }
                }

        /* Iterator<Value> mk = ddertt.getValue().getAsArray().iterator();
         while (mk.hasNext()) {

           Value ggt = mk.next();

           if(ggt.isObject()){
               showmeesav(ggt.getAsObject(),keyold,keynam);
           } else   if(ggt.isArray()) {

              // String keynammm = ggt.getKey();



           }else{
               mess.customToast(ggt.toString());
           }
         }*/



                //   mess.customToast(g.toJson(ddertt.getValue().getAsArray()));
                // }
            }
        }


    }


    @Override
    public void showmessage(String message,int typp,String keyname) {
        try {

            if(typp==1000) {
                refreshallviewss();;
            }else{
               /// data_processing.SetAlldatashowprograsshed();
                if(typp==1) {

                    mess.customToast(message);
                }else  if(typp==5) {
                    if (!keyname.equals("0")) {
                        // mess.customToast(keyname);
                        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(this);
                        Gson gsonn = new GsonBuilder()
                                .registerTypeAdapterFactory(adapter)
                                .create();
                        Type type = new TypeToken<Value>() {

                        }.getType();
                        Value tempp = gsonn.fromJson(message, type);
                        showmeesav(tempp.getAsObject(), "h", keyname);
                    } else {

                        mess.customToast(message);
                    }
                }
                //  mess.customToast(tempp.getAsObject().get(keyname).toString());

            }
            // proteusManager.update();
        }catch (Exception ex){
            mess.customToast(ex.getMessage()+"not parser");

        }
    }

    @Override
    public void change_data(String nameAdapter, int typ,ObjectValue dataupdate) {

    }


    @Override
    public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int mode) {

    }

    private SearchView mSearchView;
    @Override
    public void initSearchView(final Menu menu) {
        // Associate searchable configuration with the SearchView
        //com.ordersalsemyntofi.astolnotf.dynimicall.proteus.anotherView.flexibleadapter.utils.Log.d("onCreateOptionsMenu setup SearchView!");
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        if (searchItem != null) {
            MenuItemCompat.setOnActionExpandListener(
                    searchItem, new MenuItemCompat.OnActionExpandListener() {
                        @Override
                        public boolean onMenuItemActionExpand(MenuItem item) {
                            MenuItem listTypeItem = menu.findItem(R.id.action_list_type);
                            if (listTypeItem != null)
                                listTypeItem.setVisible(false);
                            //hideFab();
                            return true;
                        }

                        @Override
                        public boolean onMenuItemActionCollapse(MenuItem item) {
                            MenuItem listTypeItem = menu.findItem(R.id.action_list_type);
                            if (listTypeItem != null)
                                listTypeItem.setVisible(true);
                            //showFab();
                            return true;
                        }
                    });
            mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            mSearchView.setInputType(InputType.TYPE_TEXT_VARIATION_FILTER);
            mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE | EditorInfo.IME_FLAG_NO_FULLSCREEN);
            mSearchView.setQueryHint(getString(R.string.action_search));
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            mSearchView.setOnQueryTextListener(this);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public void loadfist(Object ob) {
        proteusManager.load(dataURL);
    }
    /*Views declaration*/
    Button btnExplicitBroadcast;
    private boolean isConnected;
    //  private LinearLayout linearNoConnectionAvailable,linearConnectionAvailable;
    private Button errorPageRetry;
    /*My Receiver declaration*/


    public void onNetworkConnectionChanged(boolean isConnected) {
        isConnected = isConnected;
        if (isConnected) {
            //    linearConnectionAvailable.setVisibility(View.VISIBLE);
            //  linearNoConnectionAvailable.setVisibility(View.GONE);
            Toast.makeText(this, "WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();
        } else {
            //   linearConnectionAvailable.setVisibility(View.GONE);
            // linearNoConnectionAvailable.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Ooops! No WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();

        }
    }
    private void initView() {

    }

    private void checkConnection() {
      /*  isConnected = MyReceiver.isConnected();
        if (isConnected) {
        //    linearConnectionAvailable.setVisibility(View.VISIBLE);
          //  linearNoConnectionAvailable.setVisibility(View.GONE);
            Toast.makeText(this, "WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();
        } else {
         //   linearConnectionAvailable.setVisibility(View.GONE);
           // linearNoConnectionAvailable.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Ooops! No WiFi/Mobile Networks Connected!", Toast.LENGTH_SHORT).show();

        }*/
    }

    @Override
    public void onBackPressed() {
        // proteusManager.sendsend("WebView","back",1);

        //  if(xback=="0"){
        super.onBackPressed();
//}
        // super.onBackPressed();

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected, int typ, String Dataa) {
       // proteusManager.sendsend("WebView",Dataa);
    }

    @Override
    public void onFastScrollerStateChange(boolean scrolling) {

    }

    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

    }

    @Override
    public boolean shouldMoveItem(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    @Override
    public void onItemSwipe(int position, int direction) {

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        boolean tt=false;

        // ProgressDialog progressDialog;
        String bbaa="0";
        String bbaat="0";
        @Override
        protected String doInBackground(final String... params) {
            // ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(getApplicationContext());

            //   proteusManager.load(dataURL);
           /* gson = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();

            // add gson to retrofit to allow deserializing proteus resources when fetched via retrofit
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            proteusManager = new ProteusManager(retrofit,getApplicationContext());
            proteusManager.addListener(ProteusActivity.this);
            proteusManager.load(dataURL);
            ProteusContext context = proteusManager.getProteus().createContextBuilder(getApplicationContext())
                    .setLayoutManager(layoutManager)
                    .setCallback(callback)
                    .setImageLoader(loader)
                    .setStyleManager(styleManager)
                    .build();

            layoutInflater = context.getInflater();

            data_processing=new all_action_Activity(container,getApplicationContext(),proteusManager,dataURL,layoutInflater,masss,getSupportFragmentManager(), mFragment,mDrawer);
           */
            return  "0";

        }


    }
}