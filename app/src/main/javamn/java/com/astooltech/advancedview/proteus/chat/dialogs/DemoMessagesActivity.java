package com.astooltech.advancedview.proteus.chat.dialogs;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.Styles;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentOverall;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views.HeaderView;
import com.astooltech.advancedview.proteus.chat.commons.ImageLoader;
import com.astooltech.advancedview.proteus.chat.commons.data.fixtures.MessagesFixtures;
import com.astooltech.advancedview.proteus.chat.commons.data.model.Message;
import com.astooltech.advancedview.proteus.chat.messages.MessagesListAdapter;
import com.astooltech.advancedview.proteus.chat.utils.AppUtils;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.ProtouseAbstractActivity;
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
import com.astooltech.advancedview.proteus.parser.message_box;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Retrofit;

/*
 * Created by troy379 on 04.04.17.
 */
public abstract class DemoMessagesActivity extends ProtouseAbstractActivity
        implements MessagesListAdapter.SelectionListener,
        MessagesListAdapter.OnLoadMoreListener, ProteusManager.Listener, getmessage_status, notfi_refresh_data, OnFragmentInteractionListener,  NavigationView.OnNavigationItemSelectedListener, loadfirstly  {

    private static final int TOTAL_MESSAGES_COUNT = 100;

    protected final String senderId = "0";
    protected ImageLoader imageLoader;

    protected MessagesListAdapter<Message> messagesAdapter;
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
    private loadfirstly loadfirst;
    private Retrofit retrofit;
    private List<resultData> allunit;
    private   List<DataValueSelect> result_setData;
    private message_box mess;
    private String Apigetdata="0";
    private String typActivity="0";
    private static  String BASE_URL = "http://0.0.0.0:8080/admin3/";
    private Dialog dd;
    ArrayList<String> mydatt=new ArrayList<>();
    private com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss show_daloge_prograss;

    private Menu menu;
    private int selectionCount;
    private Date lastLoadedDate;
    protected String[] mdat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_activity_main_dd);
        container = findViewById(R.id.recycler_view_container);
        //setContentView(R.layout.activity_protouse_new);
        loadfirst=this;
       /* container=(ViewGroup)findViewById(R.id.mycontiner);
        container.addView(getasvi.getAsView());*/


        // String  resul[]=GlobalClass.getBaseURL(urldat);

        //  String typp[]=new String[]{"0","dataUrl","layouturl","layouturl","styleurl"};

        Bundle bundle=getIntent().getExtras();
        if (bundle != null) {
            typActivity= bundle.getString("data");
            //  Apigetdata = bundle.getString("api");

        }
       String df= "layouts.json";
        String ddd=getdatafrom(df);
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
            String layouuuu = "";
            String dataa = "";


          /*  ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(this);
            gson = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();

            // add gson to retrofit to allow deserializing proteus resources when fetched via retrofit
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();*/


            String ffg="{#ddd#:{#type#:#LinearLayout#}}";
            ffg=  ffg.replace('#','"');

            mydatt.add("{}");
            mydatt.add(ddd);
            mydatt.add(ddd);
            mydatt.add("{}");
          /*  proteusManager = new ProteusManager(this,DemoMessagesActivity.this);

            proteusManager.addListener(this);*/
            show_daloge_prograss=new show_daloge_prograss(DemoMessagesActivity.this);

            dd=   show_daloge_prograss.showdailog();
            dd.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadfirst.loadfist("h");
                    //new AsyncTaskRunner().execute();
                }
            },200);


        }catch (Exception ex){

        }

        imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, @Nullable String url, @Nullable Object payload) {
                Picasso.with(imageView.getContext()).load(url).into(imageView);
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.chat_actions_menu, menu);
        onSelectionChanged(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_delete) {
            messagesAdapter.deleteSelectedMessages();
        } else if (itemId == R.id.action_copy) {
            messagesAdapter.copySelectedMessagesText(this, getMessageStringFormatter(), true);
            AppUtils.showToast(this, R.string.text_forgot_password, true);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (selectionCount == 0) {
            super.onBackPressed();
        } else {
            messagesAdapter.unselectAllItems();
        }
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount) {
        Log.i("TAG", "onLoadMore: " + page + " " + totalItemsCount);
        if (totalItemsCount < TOTAL_MESSAGES_COUNT) {
            loadMessages();
        }
    }

    @Override
    public void onSelectionChanged(int count) {
        this.selectionCount = count;
      /*  menu.findItem(R.id.action_delete).setVisible(count > 0);
        menu.findItem(R.id.action_copy).setVisible(count > 0);*/
    }

    protected void loadMessages() {
        //imitation of internet connection
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Message> messages = MessagesFixtures.getMessages(lastLoadedDate);
                lastLoadedDate = messages.get(messages.size() - 1).getCreatedAt();
                messagesAdapter.addToEnd(messages, false);
            }
        }, 1000);
    }

    private MessagesListAdapter.Formatter<Message> getMessageStringFormatter() {
        return new MessagesListAdapter.Formatter<Message>() {
            @Override
            public String format(Message message) {
                String createdAt = new SimpleDateFormat("MMM d, EEE 'at' h:mm a", Locale.getDefault())
                        .format(message.getCreatedAt());

                String text = message.getText();
                if (text == null) text = "[attachment]";

                return String.format(Locale.getDefault(), "%s: %s (%s)",
                        message.getUser().getName(), text, createdAt);
            }
        };
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
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
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
    public void onloadd(){

        final SkeletonViewGroup n=new SkeletonViewGroup(getApplicationContext());
        ArrayList<SkeletonModel> ske=new ArrayList<>();
        ske.add(new SkeletonModelBuilder().setChildView(container)
                .setIsMatchViewBoolean(true)
                .setShapeType(SkeletonModel.SHAPE_TYPE_OVAL)
                .build());
        ViewGroup.LayoutParams m=new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        n.startAnimation();
        container.addView(n,m);

        n.setSkeletonListener(new SkeletonViewGroup.SkeletonListener() {
            @Override
            public void onStartAnimation() {

            }

            @Override
            public void onFinishAnimation() {

            }
        });
        n.startAnimation();

       // data = proteusManager.getData();
        // setmydatt();

        try {
            Map<String, Layout> yt = getlayoutfromString(mydatt.get(1));
            int cx = 0;
            for (Map.Entry<String, Layout> tu : yt.entrySet()) {

                cx = cx + 1;
                if (cx == 1) {
                    layout = tu.getValue();
                }
            }
            //  layout =//proteusManager.getRootLayout();
            layouts = yt;// proteusManager.getLayouts();
        }catch (Exception ex){


        }
    //    styles = proteusManager.getStyles();
        setdata();
        render();
        //  setdata();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);
    }

    void render() {

        // remove the current view
        //  container.removeAllViews();

        // Inflate a new view using proteus
        long start = System.currentTimeMillis();

        ProteusView view = layoutInflaterr.inflate(layoutt, dataa, containerr, 0);
        //  System.out.println("inflate time: " + (System.currentTimeMillis() - start));

        // Add the inflated view to the container
        containerr.addView(view.getAsView());
        //showalertonly("hh");
        dd.dismiss();
        messagesAdapter.addToStart(MessagesFixtures.getTextMessage(), true,layoutInflaterr,mdat);
    }
    public void setdata(){
      //  proteusManagerr=proteusManager;
        dataURLl=dataURL;
        masss=this;
        massss=this;
        mDrawerr=mDrawer;
        layoutt=layout;
        layoutss=layouts;

        containerr=container;
        mFragmentt=mFragment;
        styless=styles;
        loaderr=loader;
        dataa=data;
        mProteusManagerr=this;
        intilations();

    }
    private ProteusLayoutInflater.ImageLoader loader = new ProteusLayoutInflater.ImageLoader() {
        @Override
        public void getBitmap(ProteusView view, String url, final DrawableValue.AsyncCallback callback)  {

            try {


              //  Picasso.get().load(url).placeholder(R.drawable.placeholder).into(new ImageLoaderTarget(callback,getApplicationContext()));
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

    @Override
    public void onLoad() {
        refreshallviews();
    }


    @Override
    public void onError(@NonNull Object e) {
        // dd.dismiss();
        dd.dismiss();
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
    public void refreshallviews(){
        //  proteusManager.removeListener(this);
        onloadd();
    }
    public void refreshallviewss(){
      /* proteusManager.removeListener(this);
        proteusManager.addListener(this);*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadfirst.loadfist("h");
                //new AsyncTaskRunner().execute();
            }
        },200);
        //  onloadd();
    }
    @Override
    public void showmessage(String message,int typp,String keyname) {
        try {

            if(typp==1000) {
                refreshallviewss();;
            }else{
              //  data_processing.SetAlldatashowprograsshed();
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
        //proteusManager.load(mydatt);
    }

    @Override
    public void change_data(String nameAdapter, int typ, ObjectValue dataupdate) {

    }
}
