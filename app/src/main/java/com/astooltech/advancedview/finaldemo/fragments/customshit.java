package com.astooltech.advancedview.finaldemo.fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.MainActivity;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseType;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.conectionbase;
import com.astooltech.advancedview.finaldemo.flex;
import com.astooltech.advancedview.finaldemo.loadSettingsFirstly;
import com.astooltech.advancedview.finaldemo.protuseTestParser;
import com.google.android.material.snackbar.Snackbar;




public class customshit extends com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractShitFragment implements getmessage_status,StatuseLayout {

    public static final String TAG = customshit.class.getSimpleName();
    private DrawerLayout mDrawer;
    private AbstractFragment mFragment;
    private StatuseLayout suces;
    private loadSettingsFirstly loadfirstly;
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;
    private FlexibleItemDecoration mDivider;
    private boolean configure;
    private MenuItem mSearchView;
    private ProteusView.Manager mang;
    private boolean usecustomedta;
    private ObjectValue obj;
private String names;
    private boolean use;
    public static customshit newInstance(boolean configure,DrawerLayout d,StatuseLayout suces,AbstractFragment mFragment) {
        customshit fragment = new customshit(configure,d,suces,mFragment);
        Bundle args = new Bundle();
        args.putBoolean(ARG_CONFIGURE, configure);
        fragment.setArguments(args);
        return fragment;
    }
    public static customshit newInstance(boolean configure,DrawerLayout d,StatuseLayout suces,AbstractFragment mFragment,ProteusView.Manager mang,String names) {
        customshit fragment = new customshit(configure,d,suces,mFragment,mang,names);
        Bundle args = new Bundle();
        args.putBoolean(ARG_CONFIGURE, configure);
        fragment.setArguments(args);
        return fragment;
    }
    public static customshit newInstance(boolean configure, ProteusView.Manager mang, String name, ObjectValue obj, boolean use ) {
        customshit fragment = new customshit(configure,mang,name,obj,use);
        Bundle args = new Bundle();
        args.putBoolean(ARG_CONFIGURE, configure);
        fragment.setArguments(args);
        return fragment;
    }
    public customshit(boolean c, ProteusView.Manager mang, String names, ObjectValue objj, boolean use) {
        this.use=use;
        this.usecustomedta=c;
        this.mang=mang;
        this.names=names;
        this.obj=objj;
    }
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public customshit() {
    }
    public customshit(boolean x,DrawerLayout mDrawer,StatuseLayout suces,AbstractFragment mFragment) {
      this.use=x;
        this.mDrawer=mDrawer;
        this.suces=suces;
        this.mFragment=mFragment;
    }
    public customshit(boolean x,DrawerLayout mDrawer,StatuseLayout suces,AbstractFragment mFragment,ProteusView.Manager mang,String names) {
        this.use=x;
        this.mDrawer=mDrawer;
        this.suces=suces;
        this.mFragment=mFragment;
        this.mang=mang;
        this.names=names;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            configure = savedInstanceState.getBoolean(ARG_CONFIGURE);
        } else if (getArguments() != null) {
            configure = getArguments().getBoolean(ARG_CONFIGURE);
        }
    }

    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }

    @SuppressLint("RestrictedApi")
    @Override
      public void setupDialog(@NonNull Dialog dialog, int style) {
          //super.setupDialog(dialog, style);
      //  AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


          dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

          // t.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restore FAB button and icon
        initializeFab();

        FlexibleAdapter.useTag("AsyncFilterAdapter");
        // IMPORTANT! Upgrading to Support Library v26, stableIds must remain = false.
        // StableIds cause the entry animation not animate properly: alpha property of views
        // remain 1 (item not changed) while the entry animation requires the view to be invisible
        // when Swapping / Changing the Adapter.
        if (configure) {
            // Create configuration list
            DatabaseService.getInstance().createConfigurationDatabase(getResources());
            mAdapter = new FlexibleAdapter<>(DatabaseService.getInstance().getDatabaseList(),
                    getActivity(), false);
        } else {
            // Create Database with custom size
            // N. of items (1000 items it's already a medium size)
            DatabaseService.getInstance().createEndlessDatabase(DatabaseConfiguration.size);
            mAdapter = new FlexibleAdapter<>(DatabaseService.getInstance().getDatabaseList(),
                    getActivity(), false);
        }

        initializeRecyclerView();
        configure = !configure;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Revert the change so next time the "if-else" is executed correctly
        configure = !configure;
        outState.putBoolean(ARG_CONFIGURE, configure);
        super.onSaveInstanceState(outState);
    }
    public void onloadd(ViewGroup container){

        try {
            // data = proteusManager.getData();
            // setmydatt();
            String[] dds = new String[]{"0"};

            // skeletonViewGroup.stopShimmer();
            // setdata();
            ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus().createContextBuilder(getContext())
                    //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                    //.setCallback(callbackb)
                    .Setcontainerr(container).SetdataURLl(dds)
                    .setFrgmentMangers(getChildFragmentManager())
                    .setmDrawerr(mang.getContext().getmDrawerr())
                    .setMassss(this)
                    .setmFragmenttv(mang.getContext().getmFragmenttv())
                    .SetActivitys((AppCompatActivity) getActivity()).setStatuse(this)
                    .build(use ? null : mang.getContext().GetLayouts(), names, mang.getContext().GetStyles(), this.usecustomedta ? this.obj : mang.getContext().getData());

            //  setdata();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);*/
        }catch (Exception ex){
            Log.e("error Rtotation",ex.getMessage());
        }
    }
    public void onloaddx(ViewGroup container){

        if(loadfirstly==null){
            loadfirstly=new loadSettingsFirstly(getContext(), conectionbase.fir);
        }
        // data = proteusManager.getData();
        // setmydatt();
String[] dds=new String[]{"0"};

        // skeletonViewGroup.stopShimmer();
        // setdata();
        proteus.createContextBuilder(getContext())
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dds)
                .setFrgmentMangers(getChildFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(this)
                .setmFragmenttv(mFragment)
                .SetActivitys((AppCompatActivity)getActivity()).setStatuse(suces)
                .build(mang.getContext().GetLayouts(),names,mang.getContext().GetStyles(),mang.getContext().getData());

        //  setdata();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);*/
    }

    private void initializeRecyclerView() {
        // Settings for FlipView
        try {
            FlipView.resetLayoutAnimationDelay(true, 1000L);
          /*  try {
                A_loadingbar = getView().findViewById(com.astooltech.advancedview.R.id.fragment_Loading);
                A_loadingbar.setShowlogin(this);
                A_loadingbar.setMessagess(Whiting);
                //  dqq.attachTo(loginsys);
                A_loadingbar.showLoading();
            }catch (Exception ex){

            }*/
            // Size limit = MAX_VALUE will always animate the changes
            mAdapter.setAnimateChangesWithDiffUtil(DatabaseConfiguration.animateWithDiffUtil)
                    .setAnimateToLimit(DatabaseConfiguration.animateToLimit)
                    // When true, filtering on big list is very slow!
                    .setNotifyMoveOfFilteredItems(DatabaseConfiguration.notifyMove)
                    .setNotifyChangeOfUnfilteredItems(DatabaseConfiguration.notifyChange)
                    .setAnimationInitialDelay(100L)
                    .setAnimationOnForwardScrolling(true)
                    .setAnimationOnReverseScrolling(true)
                    .setOnlyEntryAnimation(true);
            if (mRecyclerView == null) {
                mRecyclerView = getView().findViewById(com.astooltech.advancedview.R.id.recycler_view);
                mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
                // Adapter changes won't affect the size of the RecyclerView
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setVisibility(View.GONE);
            }
            if (ccontainer == null) {

                //ccontainer=(ViewGroup)getView().findViewById(R.id.container_without_sweep);
                View v = getView().findViewById(com.astooltech.advancedview.R.id.baaa);
                //  getView().findViewById(R.id.container_without_sweep).setVisibility(View.GONE);
                ccontainer = (ViewGroup) v;
                ccontainer.setFocusable(false);

            }


            onloadd(ccontainer);


            //  }
            // ViewHolders are different so we do NOT swap Adapters
            mRecyclerView.setAdapter(mAdapter);
            // Custom divider item decorator with Offset
            if (mDivider == null) {
                mDivider = new FlexibleItemDecoration(getActivity())
                        .withDivider(com.astooltech.advancedview.R.drawable.divider_large);
            }

            // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!
            SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(com.astooltech.advancedview.R.id.swipeRefreshLayout);
            swipeRefreshLayout.setEnabled(!configure);

            mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);
            swipeRefreshLayout.setProgressViewEndTarget(true, 0);
            swipeRefreshLayout.setRefreshing(true);
            swipeRefreshLayout.setSelected(true);

            swipeRefreshLayout.setNestedScrollingEnabled(true);

            swipeRefreshLayout.setSlingshotDistance(0);
            if (configure) {
                mFab.setImageResource(R.drawable.ic_check_white_24dp);
                mRecyclerView.addItemDecoration(mDivider);
                FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
                fastScroller.setEnabled(false);
            } else {
                try {

             /* mFab.setImageResource(R.drawable.ic_settings_white_24dp);
              mRecyclerView.removeItemDecoration(mDivider);
              FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
              fastScroller.addOnScrollStateChangeListener( getActivity());
              mAdapter.setFastScroller(fastScroller);*/
                }catch (Exception ex){

                }
            }

            // New empty views handling, to set after FastScroller
            try {
                EmptyViewHelper.create(mAdapter,
                        getView().findViewById(R.id.empty_view),
                        getView().findViewById(R.id.filter_view),
                        (EmptyViewHelper.OnEmptyViewListener) getActivity()); // Optional!!

                // Settings for FlipView
                FlipView.stopLayoutAnimation();
                showFab(1200L);
            }catch (Exception ex){

            }
           /* try {

                mFab.setImageResource(com.astooltech.advancedview.R.drawable.ic_check_white_24dp);
                mRecyclerView.addItemDecoration(mDivider);
                FastScroller fastScroller = getView().findViewById(com.astooltech.advancedview.R.id.fast_scroller);
                fastScroller.setEnabled(false);


                // New empty views handling, to set after FastScroller
                EmptyViewHelper.create(mAdapter,
                        getView().findViewById(com.astooltech.advancedview.R.id.empty_view),
                        getView().findViewById(com.astooltech.advancedview.R.id.filter_view),
                        (EmptyViewHelper.OnEmptyViewListener) getActivity()); // Optional!!

                // Settings for FlipView
                FlipView.stopLayoutAnimation();
                showFab(1200L);
            } catch (Exception ex) {

            }*/
        }catch (Exception ex){
            Log.e("error Rtotation",ex.getMessage());
        }
    }
    private void initializeRecyclerViewx() {
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);
       /* if(proteus==null){
            proteus=   new ProteusBuilder().register(Updatek).register(OpenActivity).register(new protuseTestParser()).register(OpenActivityhidlib )
                    /* .register(SupportV4Module.create())
                     .register(RecyclerViewModule.create())
                     .register(SliderViewModel.create())
                     .register(AutoCompleteTextViewModel.create())
                     .register(SppinerViewBModel.create())
                     .register(CardViewModule.create())
                     .register(DesignModule.create())
                     .register(new CircleViewParser())
                    .build();
        }*/
        // Size limit = MAX_VALUE will always animate the changes
        mAdapter.setAnimateChangesWithDiffUtil(DatabaseConfiguration.animateWithDiffUtil)
                .setAnimateToLimit(DatabaseConfiguration.animateToLimit)
                // When true, filtering on big list is very slow!
                .setNotifyMoveOfFilteredItems(DatabaseConfiguration.notifyMove)
                .setNotifyChangeOfUnfilteredItems(DatabaseConfiguration.notifyChange)
                .setAnimationInitialDelay(100L)
                .setAnimationOnForwardScrolling(true)
                .setAnimationOnReverseScrolling(true)
                .setOnlyEntryAnimation(true);
        if (mRecyclerView == null) {
            mRecyclerView = getView().findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
            // Adapter changes won't affect the size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setVisibility(View.GONE);
        }
        if(ccontainer==null){

           /* ccontainer=(ViewGroup)getView().findViewById(com.astooltech.advancedview.R.id.container_without_sweep);
           SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(com.astooltech.advancedview.R.id.swipeRefreshLayout);
            swipeRefreshLayout.setEnabled(true);
            ccontainer.setFocusable(false);*/
            //.setEnabled(true);
            View v=getView().findViewById(R.id.baaa);
         //   getView().findViewById(R.id.container_without_sweep).setVisibility(View.GONE);
ccontainer=(ViewGroup)v;
            ccontainer.setFocusable(false);

        }
        onloadd(ccontainer);
        // ViewHolders are different so we do NOT swap Adapters
        mRecyclerView.setAdapter(mAdapter);
        // Custom divider item decorator with Offset
        if (mDivider == null) {
            mDivider = new FlexibleItemDecoration(getActivity())
                    .withDivider(R.drawable.divider_large);
        }

        // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!
        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(!configure);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);
       swipeRefreshLayout.setProgressViewEndTarget(true,0);
        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setSelected(true);

        swipeRefreshLayout.setNestedScrollingEnabled(true);

        swipeRefreshLayout.setSlingshotDistance(0);

        if (configure) {
            mFab.setImageResource(R.drawable.ic_check_white_24dp);
            mRecyclerView.addItemDecoration(mDivider);
            FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
            fastScroller.setEnabled(false);
        } else {
          try {

             /* mFab.setImageResource(R.drawable.ic_settings_white_24dp);
              mRecyclerView.removeItemDecoration(mDivider);
              FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
              fastScroller.addOnScrollStateChangeListener( getActivity());
              mAdapter.setFastScroller(fastScroller);*/
          }catch (Exception ex){

          }
        }

        // New empty views handling, to set after FastScroller
        try {
            EmptyViewHelper.create(mAdapter,
                    getView().findViewById(R.id.empty_view),
                    getView().findViewById(R.id.filter_view),
                    (EmptyViewHelper.OnEmptyViewListener) getActivity()); // Optional!!

            // Settings for FlipView
            FlipView.stopLayoutAnimation();
            showFab(1200L);
        }catch (Exception ex){

        }
    }

    @Override
    public void performFabAction() {
        hideFab(); //Give time to hide FAB before changing everything
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (configure) {
                    onActivityCreated(null);
                    mSearchView.setVisible(false);
                    configure = false;
                } else {
                    Snackbar.make(getView(), "Created list with " + DatabaseConfiguration.size + " items", Snackbar.LENGTH_LONG).show();
                    onActivityCreated(null);
                    mSearchView.setVisible(mAdapter.getItemCount() > 0);
                    configure = true;
                }
            }
        }, 200L);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.v(TAG, "onCreateOptionsMenu called!");
        inflater.inflate(R.menu.menu_filter, menu);

        mListener.initSearchView(menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mSearchView = menu.findItem(R.id.action_search);
        menu.add(0,0,0,"ggggggggggg");
        mSearchView.setVisible(mAdapter.getItemCount() > 0 &&
                DatabaseService.getInstance().getDatabaseType() != DatabaseType.CONFIGURATION);
    }

    private void hideFab() {
        ViewCompat.animate(mFab)
                .scaleX(0f).scaleY(0f)
                .alpha(0f).setDuration(50)
                .start();
    }

    private void showFab(long delay) {
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewCompat.animate(mFab)
                        .scaleX(1f).scaleY(1f)
                        .alpha(1f).setDuration(200)
                        .start();
            }
        }, delay);
    }

    @Override
    public void showmessage(String s, int i, String s1) {

    }

    @Override
    public void loadfinshed() {

    }

    @Override
    public void onerror(String s, Object o) {

    }

    @Override
    public void OnRetray() {

    }
}