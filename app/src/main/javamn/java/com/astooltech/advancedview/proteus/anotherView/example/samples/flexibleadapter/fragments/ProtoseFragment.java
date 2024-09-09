package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
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
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.OverallAdapter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dialogs.BottomSheetDecorationDialog;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dialogs.OnDecorationSelectedListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ScrollableUseCaseItemCustome;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.views.HeaderView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollGridLayoutManager;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.ProteusManager;
import com.astooltech.advancedview.proteus.demo.api.URLdatamodel;

import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
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
import com.astooltech.advancedview.proteus.parser.message_box;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

public class ProtoseFragment extends AbstractFragment
        implements OnDecorationSelectedListener,  ProteusManager.Listener, getmessage_status, notfi_refresh_data   {
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    public static final String TAG = FragmentOverall.class.getSimpleName();
    private static final long INITIAL_DELAY_300 = 300L;
//private int typeFragment


    /**
     * Custom implementation of FlexibleAdapter
     */

    @Override
    public void onbackpress(String a1, String a2) {

    }
    private ProteusManager proteusManager;
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


              //  Picasso.with(context).load(url).placeholder(R.drawable.placeholder).into(new ImageLoaderTarget(callback,getActivity().getApplicationContext()));
  /*  GlideApp.with(ProteusActivity.thisget)
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

          //  data_processing.onEventsendbasic(Tag,event,value,view);





        }



        @Override
        public void onEventAdapter(final int typ, final String Tag, final String event, final ObjectValue value, final ProteusView view) {



            //data_processing.onEvenٍsend(typ,Tag,event,value,view);



        }

        @Override
        public void onEventAdapter(int typ, String Tag, String event, ObjectValue value, ProteusView view, EventProcessor eventproc, boolean withtage, String[] somedsta) {
           // data_processing.onEvenٍsend(typ,Tag,event,value,view,eventproc,withtage,somedsta);
        }


    };

    ProteusView view;
   // private ViewGroup container;
    private Gson gson;
    private Retrofit retrofit;
    private   List<resultData> allunit;
    private   List<DataValueSelect> result_setData;
    private message_box mess;
    private String Apigetdata="0";
    private String typActivity="0";
    private  String[] dataURL;
  //  private Dialog dd;
    private  ViewGroup datadaloge;
    private  boolean showdaloge;
    private static final String PREFS_NAME = "TCPClientConf";
   // private all_action_Activity data_processing;
    private com.astooltech.advancedview.proteus.demo.api.show_daloge_prograss show_daloge_prograss;
    private static  String BASE_URL = "http://0.0.0.0:8080/admin3/";
    private AbstractFragment mFragment;
    private boolean checkdata=false;
  //  private AppBarLayout app;
    private DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private HeaderView mHeaderView;






    private OverallAdapter mAdapter;
    private ScrollableUseCaseItemCustome scrollableUseCaseItem;
    private FlexibleItemDecoration mItemDecoration;
    private  int typfragmentx;
    private View viewfragmentx;
    private ProteusLayoutInflater.Callback mk;
    private Layout mlayout;
    private ProteusLayoutInflater layoutInflaterrr;
    public static ProtoseFragment newInstance(int columnCount, int typfragmentxx, View viewfragmentxx, ProteusLayoutInflater.Callback m,ProteusLayoutInflater  layoutInflaterrr,Layout ml) {

        ProtoseFragment fragment = new ProtoseFragment(typfragmentxx,viewfragmentxx,m,layoutInflaterrr,ml);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    public static ProtoseFragment newInstance(int columnCount, int typfragmentxx, View viewfragmentxx, ProteusLayoutInflater.Callback m) {

        ProtoseFragment fragment = new ProtoseFragment(typfragmentxx,viewfragmentxx,m,null,null);
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProtoseFragment(int typfragmentxx,View viewfragmentxx,ProteusLayoutInflater.Callback mkk,ProteusLayoutInflater  layoutInflaterrr,Layout ml) {
        typfragmentx=typfragmentxx;
        viewfragmentx=viewfragmentxx;
        this.mlayout=ml;
        this.layoutInflaterrr=layoutInflaterrr;

        this.mk=mkk;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Create overall items and Initialize RecyclerView
       /* if (savedInstanceState == null) {
            DatabaseService.getInstance().createOverallDatabase(getActivity().getResources());
        }*/
        initializeRecyclerView(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        proteusManager.addListener(this);
        proteusManager.load(dataURL);
       /* if (DatabaseService.getInstance().isEmpty()) {
            DatabaseService.getInstance().createOverallDatabase(getActivity().getResources());
        }*/
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    private void initializeRecyclerView(Bundle savedInstanceState) {
        // Initialize Adapter and RecyclerView
        // OverallAdapter makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        //  FlexibleAdapter.useTag("OverallAdapter");
        ccontainer=getView().findViewById(R.id.baaa);
        typFragment=typfragmentx;
        List<AbstractFlexibleItem> mkk=new ArrayList<>();
        mAdapter = new OverallAdapter(getActivity(),mkk);
        mAdapter.setOnlyEntryAnimation(true)
                .setAnimationInterpolator(new DecelerateInterpolator())
                .setAnimationInitialDelay(INITIAL_DELAY_300);

        mAdapter
                .setAutoCollapseOnExpand(false)
                .setAutoScrollOnExpand(true);
        // mAdapter.setAutoCollapseOnExpand(true);
        // Prepare the RecyclerView and attach the Adapter to it
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout
        mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
       mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        mItemDecoration = new FlexibleItemDecoration(getActivity())
                .addItemViewType(R.layout.recycler_overall_item)
                .withOffset(8) // This helps when top items are removed!!
                .withEdge(true);
        mRecyclerView.addItemDecoration(mItemDecoration);

        // After Adapter is attached to RecyclerView
        mAdapter.setLongPressDragEnabled(true);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (getView() != null) { //Fix NPE when closing app before the execution of Runnable
                    Snackbar.make(getView(), "Long press drag is enabled", Snackbar.LENGTH_SHORT).show();
                }
            }
        }, 4000L);
        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(false);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);
/*
        // Add 1 Scrollable Header
        try {
            scrollableUseCaseItem = new ScrollableUseCaseItemCustome(
                    getString(R.string.overall_use_case_title),
                    getString(R.string.overall_use_case_description), this.mlayout, this.layoutInflaterrr);
            // Delayed! So entry animation will perform together
            mAdapter.addScrollableHeaderWithDelay(scrollableUseCaseItem, INITIAL_DELAY_300, true);
        }catch (Exception ex){

        }*/
        showdaloge=false;

        // String  resul[]=GlobalClass.getBaseURL(urldat);

        //  String typp[]=new String[]{"0","dataUrl","layouturl","layouturl","styleurl"};

      //  Bundle bundle=savedInstanceState.getExtras();
        if (savedInstanceState != null) {
            typActivity= savedInstanceState.getString("typActivity");
            Apigetdata = savedInstanceState.getString("api");

        }


        //  mDrawer.open();
       // app=(AppBarLayout)findViewById(R.id.app_bar);
        // app.setVisibility(View.GONE);
        dataURL=    getdataa(Apigetdata);

        masss=this;
        dat_refresh=this;



        allunit=new ArrayList<resultData>();
        result_setData=new  ArrayList<DataValueSelect>();
        // set the toolbar

        try {
            mess = new message_box(getActivity());
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

           // container = findViewById(R.id.recycler_view_container);
            String layouuuu = "";
            String dataa = "";


            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(getActivity());
            gson = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();

            // add gson to retrofit to allow deserializing proteus resources when fetched via retrofit
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();


            proteusManager = new ProteusManager(retrofit,getActivity(),getActivity());


            ProteusContext context = proteusManager.getProteus().createContextBuilder(getActivity())
                    //.setLayoutManager(layoutManager)//.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                    //.setCallback(callbackb)
                .Setcontainerr(ccontainer).SetdataURLl(dataURL)
                    .setFrgmentMangers(getActivity().getSupportFragmentManager())
                    .setmDrawerr(mDrawer)
                    .setMassss(masss).SetActivitys((AppCompatActivity)getActivity())
                    .setmFragmenttv(mFragment)
                  //  .SetproteusManagerrb(proteusManager)
                   .build();


            layoutInflater = context.getInflater();

          //  data_processing=context.getEv(); //new all_action_Activity(ccontainer,getActivity(),proteusManager,dataURL,layoutInflater,masss,getActivity().getSupportFragmentManager(), this,mDrawer);
            show_daloge_prograss=new show_daloge_prograss(getActivity());
            /*dd=   show_daloge_prograss.showdailog();
            dd.show();*/


        }catch (Exception ex){

            Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
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
    private String getdatafrom(String textt){

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }

    @Override
    public void onPause() {
        super.onPause();
        proteusManager.removeListener(this);
    }
    @Override
    public void onLoad() {
        // container



        final SkeletonViewGroup n=new SkeletonViewGroup(getActivity().getApplicationContext());
        ArrayList<SkeletonModel> ske=new ArrayList<>();
        ske.add(new SkeletonModelBuilder().setChildView(ccontainer)
                .setIsMatchViewBoolean(true)
                .setShapeType(SkeletonModel.SHAPE_TYPE_OVAL)
                .build());
        ViewGroup.LayoutParams m=new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

        n.startAnimation();
        ccontainer.addView(n,m);

        n.setSkeletonListener(new SkeletonViewGroup.SkeletonListener() {
            @Override
            public void onStartAnimation() {

            }

            @Override
            public void onFinishAnimation() {

            }
        });
        n.startAnimation();

        data = proteusManager.getData();
        // setmydatt();


        layout =proteusManager.getRootLayout();
        layouts = proteusManager.getLayouts();
        styles = proteusManager.getStyles();
        render();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);
        //Toast.makeText(this, "تم", Toast.LENGTH_SHORT).show();
    }

    void render() {

        // remove the current view
        ccontainer.removeAllViews();

        // Inflate a new view using proteus
        long start = System.currentTimeMillis();
        view = layoutInflater.inflate(layout, data, ccontainer, 0);
       // System.out.println("inflate time: " + (System.currentTimeMillis() - start));

        // Add the inflated view to the container
        ccontainer.addView(view.getAsView());
        //showalertonly("hh");
       // dd.dismiss();
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
    public void showmessage(String message,int typp,String keyname) {
        try {

         //   data_processing.SetAlldatashowprograsshed();
            if(typp==1) {

                mess.customToast(message);
            }else  if(typp==5){
                if(!keyname.equals("0")) {
                    // mess.customToast(keyname);
                    ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(getActivity());
                    Gson gsonn = new GsonBuilder()
                            .registerTypeAdapterFactory(adapter)
                            .create();
                    Type type = new TypeToken<Value>() {

                    }.getType();
                    Value tempp = gsonn.fromJson(message, type);
                    showmeesav(tempp.getAsObject(),"h",keyname);
                }else {

                    mess.customToast(message);
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
    public void change_data(String nameAdapter, int typ,ObjectValue dataupdate) {

    }

    @Override
    public void onError(@NonNull Object e) {
       // dd.dismiss();
        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showNewLayoutInfo(MenuItem item) {
        super.showNewLayoutInfo(item);

        mAdapter.showLayoutInfo(true);
        // }
    }

    @Override
    protected LinearLayoutManager createNewLinearLayoutManager() {
        /// if(typfragmentx==0) {
        mAdapter.setAnimationEntryStep(true);
        // }
        return super.createNewLinearLayoutManager();
    }

    @Override
    protected GridLayoutManager createNewGridLayoutManager() {

        mAdapter.setAnimationEntryStep(false);
        GridLayoutManager gridLayoutManager = new SmoothScrollGridLayoutManager(getActivity(), mColumnCount);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItem(position).getSpanSize(mColumnCount, position);
            }
        });

        return gridLayoutManager;
    }

    @Override
    protected StaggeredGridLayoutManager createNewStaggeredGridLayoutManager() {

        mAdapter.setAnimationEntryStep(true);
        // }
        return super.createNewStaggeredGridLayoutManager();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_overall, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);


       /* MenuItem gridMenuItem = menu.findItem(R.id.action_list_type);
        if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            gridMenuItem.setIcon(R.drawable.ic_view_agenda_white_24dp);
            gridMenuItem.setTitle(R.string.linear_layout);
        } else if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            gridMenuItem.setIcon(R.drawable.ic_dashboard_white_24dp);
            gridMenuItem.setTitle(R.string.staggered_layout);
        } else {
            gridMenuItem.setIcon(R.drawable.ic_view_grid_white_24dp);
            gridMenuItem.setTitle(R.string.grid_layout);
        }
*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_list_type) {
            mAdapter.setAnimationOnForwardScrolling(true);
        } else if (item.getItemId() == R.id.action_decoration) {
            BottomSheetDecorationDialog bottomSheetDialogFragment = BottomSheetDecorationDialog.newInstance(R.layout.bottom_sheet_item_decoration, this);
            bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), BottomSheetDecorationDialog.TAG);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDecorationSelected() {

        mAdapter.invalidateItemDecorations(200l);

    }

    @Override
    public FlexibleItemDecoration getItemDecoration() {
        return mItemDecoration;
    }



}