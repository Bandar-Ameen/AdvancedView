package com.astooltech.advancedview.proteus.demo;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.view.LodaingLayout;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
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
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.URLdatamodel;

import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.demo.api.loadfirstly;
import com.astooltech.advancedview.proteus.demo.api.notfi_refresh_data;
import com.astooltech.advancedview.proteus.demo.api.resultData;
import com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.skeleton.SkeletonViewGroup;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModel;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModelBuilder;
import com.astooltech.advancedview.proteus.value.DrawableValue;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.custom.DynamicBox;
import com.astooltech.advancedview.proteus.parser.message_box;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

import static com.astooltech.advancedview.GlobalClass.Whiting;

public class ProtouseNewActivity extends AppCompatActivity implements  getmessage_status, notfi_refresh_data, OnFragmentInteractionListener,  NavigationView.OnNavigationItemSelectedListener, loadfirstly,MyReceiver.ConnectivityReceiverListener, FlexibleAdapter.OnItemMoveListener, SearchView.OnQueryTextListener,FlexibleAdapter.OnItemSwipeListener,FlexibleAdapter.OnItemLongClickListener, FastScroller.OnScrollStateChangeListener, StatuseLayout {



    private ViewGroup container;
    public  static ProteusView getasvi;
    //public ProteusManager proteusManager;
    private ProteusLayoutInflater layoutInflater;
    private notfi_refresh_data dat_refresh;
    ObjectValue data;
    Layout layout;
    Styles styles;
    getmessage_status masss;
    Map<String, Layout> layouts;
    public AbstractFragment mFragment;
    private boolean checkdata=false;
    private AppBarLayout app;
    public DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private HeaderView mHeaderView;
    public   String[] dataURL;
    private Gson gson;
    private  loadfirstly loadfirst;
    private Retrofit retrofit;
    private   List<resultData> allunit;
    private   List<DataValueSelect> result_setData;
    private   message_box mess;
    private String Apigetdata="0";
    private String typActivity="0";
    private static  String BASE_URL = "";
    private Dialog dd;

    ArrayList<String> mydatt=new ArrayList<>();
    private String xback="0";
    LodaingLayout contin;
   /* @Override
    public void onbackpress(String a1, String a2) {
        xback=a1;
       // if(a1.equals("0")){
           // finish();
       // }
    }*/
    @Override
    public void onBackPressed() {
       // proteusManager.sendsend("WebView","back",1);

         super.onBackPressed();

    }
    //private all_action_Activity data_processing;
private Proteus proteus;
    private com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss show_daloge_prograss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_activity_main_dd);

      try {

        //  Log.e("gggggvvxx","kkkkkkkkkkk");
          container = findViewById(R.id.recycler_view_container);
          contin=findViewById(R.id.waitcontiner);
          contin.setShowlogin(this);
          contin.setMessagess(Whiting);
          //  dqq.attachTo(loginsys);
          contin.showLoading();

          //setContentView(R.layout.activity_protouse_new);
          loadfirst = this;
          connectivityReceiverListener = this;

String showtollbaa="0";
          String drawer="0";
          Bundle bundle = getIntent().getExtras();
          if (bundle != null) {
              typActivity = bundle.getString("data");
              //  Apigetdata = bundle.getString("api");
              try{
                  showtollbaa = bundle.getString("Toolbar");
                  drawer = bundle.getString("Drawer");
              }catch (Exception ex){

              }

          }
       //   Log.e("gggggvvxx","kkkkkkkkkkk");
          initializeFragment(savedInstanceState);
        //  Log.e("gggggvvxx","kkkkkkkkkkk");
          initializeToolbar();
       //   Log.e("gggggvvxx","kkkkkkkkkkk");
          initializeDrawer();
         // Log.e("gggggvvxx","kkkkkkkkkkk");
          //  mDrawer.open();
          try {
              app = (AppBarLayout) findViewById(R.id.app_bar);
              assert showtollbaa != null;
              if(showtollbaa.equals("1")){
                  app.setVisibility(View.GONE);
                  app.setEnabled(false);
              }
              if(drawer.equals("1")){
                  mDrawer.setVisibility(View.GONE);
                  mDrawer.setEnabled(false);
              }
          }catch(Exception ex){
             // Log.e("gggggvvxx","kkkkkkkkkkk"+ex.getMessage());
          }

          // app.setVisibility(View.GONE);
          try {
              dataURL = getdataa(Apigetdata);
          }catch (Exception ex){
             // Log.e("gggggvvxx","kkkkkkkkkkkmmmmmm"+ex.getMessage());
          }
        //  Log.e("gggggvvxx","kkkkkkkkkkkmmmmmm1");
          dat_refresh = this;


          allunit = new ArrayList<resultData>();
          result_setData = new ArrayList<DataValueSelect>();
         // Log.e("gggggvvxx","kkkkkkkkkkkmmmmmm2");
          // set the toolbar

          try {
              mess = new message_box(getApplicationContext());
             // Log.e("gggggvvxx","kkkkkkkkkkkmmmmmm2");
             try {
                 BASE_URL = dataURL[5];//getdatafrom("ip");
             }catch (Exception ex){
                // Log.e("gggggvvxx","kkkkkkkkkkkmmmmmmxxxxxxx"+ex.getMessage());
             }
           //   Log.e("gggggvvxx","kkkkkkkkkkkmmmmmm3");
              container = findViewById(R.id.recycler_view_container);

              String layouuuu = "";
              String dataa = "";
              String ffg = "{#ddd#:{#type#:#LinearLayout#}}";
              ffg = ffg.replace('#', '"');

              mydatt.add("{}");
              mydatt.add(typActivity);
              mydatt.add(ffg);
              mydatt.add("{}");

              if(  ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus()==null) {
                  proteus = new ProteusBuilder()

                          .build();
              }else {
                  proteus=ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus();
              }
             /* proteusManager = new ProteusManager(this, ProtouseNewActivity.this);

              proteusManager.addListener(this);*/
              show_daloge_prograss = new show_daloge_prograss(ProtouseNewActivity.this);

           /* dd=   show_daloge_prograss.showdailog();
            dd.show();*/
              new Handler().postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      loadfirst.loadfist(typActivity);
                      //new AsyncTaskRunner().execute();
                  }
              }, 200);


          } catch (Exception ex) {
              Log.e("gggggvvxx","kkkkkkkkkkkmmmmmmfffff"+ex.getMessage());
          }

          //getasvi.getViewManager().getContext().getCallback().onEventAdapter(3000,"no","no",null,getasvi);
          //  private ProteusLayoutInflater.Callback callback = connectedActivityMdel.getinstance().getlisiner(). {


          // data_processing=new all_action_Activity(container,this,proteusManager,dataURL,getasvi.getViewManager().getContext().getInflater(),masss,getSupportFragmentManager(), mFragment,mDrawer);
      }catch (Exception ex){

          Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG);
      }
    }


    public Map<String,Layout> getlayoutfromString(String dataa) throws JSONException {
        // Log.i("ee", "ERROR: " +"sdsdddddddddd");
        ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(this);
        Gson gsonn = new GsonBuilder()
                .registerTypeAdapterFactory(adapter)
                .create();
        Type type = new TypeToken<Value>() {

        }.getType();
        ObjectValue tempp = gsonn.fromJson(dataa, type);

        HashMap<String,Layout> iio=new HashMap<>();
        Iterator<Map.Entry<String, Value>> vv = tempp.entrySet().iterator();
        while (vv.hasNext()) {
            try {
                Map.Entry<String, Value> ddertt = vv.next();
                iio.put(ddertt.getKey(), ddertt.getValue().getAsLayout());
                //  Log.i("ee", "ERROR: " + "sdsdddddddddd" + String.valueOf(ddertt.getValue().isLayout()));
            }catch (Exception ex){
                Log.i(getClass().getName(), "ERROR: " + ex.getMessage());
            }
        }


        return iio;
    }
    private static final String PREFS_NAME = "TCPClientConf";
    private String getdatafrom(String textt){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


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
    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    private void initializeToolbar() {
        //com.astooltech.advancedview.proteus.anotherView.flexibleadapter.utils.Log.d("initializeToolbar as actionBar");
       try {
           mToolbar = (Toolbar) findViewById(R.id.toolbar);
           mHeaderView = (HeaderView) findViewById(R.id.toolbar_header_view);
           mHeaderView.bindTo(getString(R.string.app_name), getString(R.string.overall));
           //mToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
           // Toolbar will now take on default Action Bar characteristics

           setSupportActionBar(mToolbar);
           mToolbar.inflateMenu(R.menu.menu_overall);
       }catch (Exception ex){
        Log.e("draweera",ex.getMessage());
    }
    }



    private void initializeDrawer() {
       try {
           mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
           ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                   this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
           mDrawer.addDrawerListener(toggle);
           toggle.syncState();

           mNavigationView = (NavigationView) findViewById(R.id.nav_view);
           mNavigationView.setNavigationItemSelectedListener(this);

           Menu dd = mNavigationView.getMenu();
           dd.add("ddddddsssss");
       }catch (Exception ex){
           Log.e("draweer",ex.getMessage());
       }
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
    public void onloadd(String d){

        setdata(d);
    }


    public void setdata(String dat){

        intilations(dat);

    }
    public void intilations(String d){

        proteus.createContextBuilder(this)
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dataURL)
                .setFrgmentMangers(getSupportFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(masss).setRootLayout("0").setData("0").setStyles("{}").setLayouts(d)
                .setmFragmenttv(mFragment)
                .SetActivitys(this).setStatuse(this)
                .build();


    }
    private ProteusLayoutInflater.ImageLoader loader = new ProteusLayoutInflater.ImageLoader() {
        @Override
        public void getBitmap(ProteusView view, String url, final DrawableValue.AsyncCallback callback)  {

            try {


               // Picasso.get().load(url).placeholder(R.drawable.placeholder).into(new  ImageLoaderTarget(callback,getApplicationContext()));
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
       // getasvi.getViewManager().getContext().getCallback().onEventAdapter(3001,"no","no",null,getasvi);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int mode) {

    }

    @Override
    public void initSearchView(Menu menu) {

    }


  /*  @Override
    public void onError(@NonNull Object e) {
       // dd.dismiss();
        box.setOtherExceptionMessage(e.toString());
        box.setOtherExceptionTitle("Error");
       box.showExceptionLayout();
    }*/
    public void refreshallviews(String f){
        //  proteusManager.removeListener(this);
        onloadd(f);
    }
    public void refreshallviewss(final String d){
       /* proteusManager.removeListener(this);
        proteusManager.addListener(this);*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadfirst.loadfist(d);
                //new AsyncTaskRunner().execute();
            }
        },200);
        //  onloadd();
    }
    @Override
    public void showmessage(String message,int typp,String keyname) {
        try {

            if(typp==1000) {
                //refreshallviewss();;
            }else{

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
    public void loadfist(Object ob) {
      if(ob!=null) {

          refreshallviews(ob.toString());
      }else{
          Log.e("nulll","nullllllllllllll");
      }
        // proteusManager.load(mydatt);
    }

    @Override
    public void change_data(String nameAdapter, int typ, ObjectValue dataupdate) {

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
    private BroadcastReceiver prodac;
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

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        registerReceiver(getpro(), filter);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected, int typ, String Dataa) {
      try {
         // proteusManager.sendsend("WebView", Dataa);
      }catch (Exception ex){

      }
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

    @Override
    public void loadfinshed() {
        contin.hideLoading();
    }

    @Override
    public void onerror(String mess, Object ob) {
        contin.setMessagess(mess);
        contin.hideLoading();
        contin.showError();
    }

    @Override
    public void OnRetray() {

    }
}