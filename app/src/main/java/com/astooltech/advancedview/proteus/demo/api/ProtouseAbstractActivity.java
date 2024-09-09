package com.astooltech.advancedview.proteus.demo.api;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.astooltech.advancedview.proteus.LayoutManager;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.StyleManager;
import com.astooltech.advancedview.proteus.Styles;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views.HeaderView;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.demo.MyReceiver;
import com.astooltech.advancedview.proteus.exceptions.ProteusInflateException;
import com.astooltech.advancedview.proteus.parser.webview.gm.agentweb.filechooser.selectfile.RxActivityResult;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.skeleton.SkeletonViewGroup;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModel;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModelBuilder;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.parser.message_box;

import java.util.ArrayList;
import java.util.Map;

public abstract class ProtouseAbstractActivity extends AppCompatActivity implements MyReceiver.ConnectivityReceiverListener, FastScroller.OnScrollStateChangeListener, FlexibleAdapter.OnItemSwipeListener,FlexibleAdapter.OnItemLongClickListener,
        FlexibleAdapter.OnItemMoveListener, SearchView.OnQueryTextListener {

    protected ProteusManager.Listener mProteusManagerr;
    protected getmessage_status mgetmessage_status;
    protected notfi_refresh_data mnotfi_refresh_data;
    protected  OnFragmentInteractionListener mOnFragmentInteractionListener;
    protected   NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    protected loadfirstly mloadfirstly;
   // protected   all_action_Activity data_processing;
    public AbstractFragment mFragmentt;
    private boolean checkdata=false;
    private AppBarLayout app;
    protected DrawerLayout mDrawerr;
    protected NavigationView mNavigationView;
    protected Toolbar mToolbarr;
    protected HeaderView mHeaderVieww;
    public ProteusManager proteusManagerr;
    protected ProteusLayoutInflater layoutInflaterr;
    private notfi_refresh_data dat_refresh;
    protected ObjectValue dataa;
    protected Layout layoutt;
    protected       String[] dataURLl;
    protected   message_box messs;
    protected   getmessage_status massss;
    protected   Styles styless;
    protected AppCompatActivity Activ;
    protected ProteusLayoutInflater.ImageLoader loaderr;
    protected   Map<String, Layout> layoutss;
    protected   ViewGroup containerr;
    protected   MyReceiver tre;
    protected     String ddata;
    protected  String rrootLayout;
    protected  String llayouts;
    protected  String sstyles;
    private StyleManager styleManager = new StyleManager() {

        @Nullable
        @Override
        protected Styles getStyles() {
            return styless;
        }
    };
    private LayoutManager layoutManager = new LayoutManager() {

        @Nullable
        @Override
        protected Map<String, Layout> getLayouts() {
            return layoutss;
        }
    };



    public ProteusLayoutInflater.Callback callbackb = new ProteusLayoutInflater.Callback() {

        @NonNull
        @Override
        public ProteusView onUnknownViewType(ProteusContext context, String type, Layout layout, ObjectValue data, int index) {
            // TODO: instead return some implementation of an unknown view
            throw new ProteusInflateException("Unknown view type '" + type + "' cannot be inflated");
        }

        @Override
        public void onEvent(String event, Value value, ProteusView view) {



          //  Log.i("ProteusEvent", "mmmnnnnnnnnnnnnnnnnnnnvvvvvvvvvvvvvvvvvvvvvvvv");
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
        public void onEventAdapter(int typ, String Tag, String event, ObjectValue value, ProteusView view, EventProcessor eventproc, boolean withtage, String[] somedsta) {
           // data_processing.onEvenٍsend(typ,Tag,event,value,view,eventproc,withtage,somedsta);

        }


    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxActivityResult.register(this.getApplication());


    }
    @Override
    protected void onStop() {
        super.onStop();
        //   unregisterReceiver(tre);

/*
        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }
        //}
        registerReceiver(tre, filter);*/
        //  unregisterReceiver(tre);
    }

    @Override
    protected void onPause() {
        super.onPause();
      /*  unregisterReceiver(tre);


        IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }
        //}
        registerReceiver(tre, filter);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        //unregisterReceiver(tre);


     /*   IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }
        //}
        registerReceiver(tre, filter);*/
    }
    @Override
    protected void onStart() {
        super.onStart();

       /* IntentFilter filter = new IntentFilter();

        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

                 /*   if(dfrk.equals("0")){
                        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }else {

                    }*
        //}
        registerReceiver(tre, filter);*/
  /*  proteusManager.addListener(this);
    proteusManager.load(dataURL);*/
    }

    public void intilations(){

        proteusManagerr.addListener(mProteusManagerr);
        ProteusContext context = proteusManagerr.getProteus().createContextBuilder(this)
            //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
             .Setcontainerr(containerr).SetdataURLl(dataURLl)
                .setFrgmentMangers(getSupportFragmentManager())
                .setmDrawerr(mDrawerr)
                .setMassss(massss).setRootLayout(rrootLayout).setData(ddata).setStyles(sstyles).setLayouts(llayouts)
                .setmFragmenttv(mFragmentt)
               .SetActivitys(Activ)
            .build();


        layoutInflaterr = context.getInflater();
       // data_processing=context.getEv();
        //data_processing=;

    }
    String[] permissionList = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private boolean isSettings = false;
    private static final String PREFS_NAME = "TCPClientConf";
    private static final int PERMISSION_CALLBACK = 111;
    private static final int PERMISSION_REQUEST = 222;





    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    public void onloaddv(){

        final SkeletonViewGroup n=new SkeletonViewGroup(getApplicationContext());
        ArrayList<SkeletonModel> ske=new ArrayList<>();
        ske.add(new SkeletonModelBuilder().setChildView(containerr)
                .setIsMatchViewBoolean(true)
                .setShapeType(SkeletonModel.SHAPE_TYPE_OVAL)
                .build());
        ViewGroup.LayoutParams m=new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        n.startAnimation();
        containerr.addView(n,m);

        n.setSkeletonListener(new SkeletonViewGroup.SkeletonListener() {
            @Override
            public void onStartAnimation() {

            }

            @Override
            public void onFinishAnimation() {

            }
        });
        n.startAnimation();

        dataa = proteusManagerr.getData();
        // setmydatt();


        layoutt =proteusManagerr.getRootLayout();
        layoutss = proteusManagerr.getLayouts();
        styless = proteusManagerr.getStyles();
        // render();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);
    }
}
