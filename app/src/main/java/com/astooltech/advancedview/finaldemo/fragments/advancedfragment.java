package com.astooltech.advancedview.finaldemo.fragments;

import static com.astooltech.advancedview.GlobalClass.Whiting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.finaldemo.conectionbase;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dialogs.EditItemDialog;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.OnFragmentInteractionListener;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.customefragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.UndoHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.google.android.material.navigation.NavigationView;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;
import java.util.Objects;

public class advancedfragment extends AbstractFragment implements
        ActionMode.Callback, EditItemDialog.OnEditItemListener, SearchView.OnQueryTextListener,
        UndoHelper.OnActionListener, EmptyViewHelper.OnEmptyViewListener,
        FlexibleAdapter.OnItemClickListener, FlexibleAdapter.OnItemLongClickListener,
        FlexibleAdapter.OnItemMoveListener, FlexibleAdapter.OnItemSwipeListener,
        FastScroller.OnScrollStateChangeListener,
        NavigationView.OnNavigationItemSelectedListener,
        OnFragmentInteractionListener, StatuseLayout, getmessage_status {

    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;
    private FlexibleItemDecoration mDivider;
    private DrawerLayout mDrawer;
    private Proteus proteus;
    private StatuseLayout suces;
    private String layouts;
    private String layoutsb;
    private String style;
    ProteusContext x;
    private ProteusLayoutInflater infla;
    private boolean configure;
    public static advancedfragment newInstance(Proteus proteuss,String layoutsa) {
        advancedfragment fragment = new advancedfragment(proteuss,layoutsa,"{}","{}");
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    public advancedfragment(Proteus proteuss,String layoutsa,String layoutsb,String style){
this.suces=this;
try {
    if (ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus() == null) {
        if (proteuss == null) {
            this.proteus = new ProteusBuilder()

                    .build();
        } else {
            this.proteus = proteuss;
        }
    } else {
        this.proteus = ProteusTypeAdapterFactory.PROTEUS_INSTANCE_HOLDER.getProteus();
    }
}catch(Exception  ex){
    this.proteus=proteuss;
}
//this.proteus=proteuss;
this.layouts=layoutsa;
this.layoutsb=layoutsb;
this.style=style;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restore FAB button and icon
        try {
            try {
                initializeFab();
            }catch(Exception ex){

            }
            //FlexibleAdapter.useTag("AsyncFilterAdapter");
            // IMPORTANT! Upgrading to Support Library v26, stableIds must remain = false.
            // StableIds cause the entry animation not animate properly: alpha property of views
            // remain 1 (item not changed) while the entry animation requires the view to be invisible
            // when Swapping / Changing the Adapter.

          try{
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
          }catch (Exception ex){
              Log.e("Rtothhionk",ex.getMessage());
          }
            addview();
            configure = !configure;
        }catch (Exception ex){
            Log.e("Rtotationk",ex.getMessage());
        }
    }
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }

    private  void intilisze(){

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .build();

        ImageLoader.getInstance().init(config);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

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
    public void onTitleModified(int position, String newTitle) {

    }

    @Override
    public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int mode) {

    }

    @Override
    public void initSearchView(Menu menu) {

    }

    @Override
    public void onFastScrollerStateChange(boolean scrolling) {

    }

    @Override
    public boolean onItemClick(View view, int position) {
        return false;
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
    public void onUpdateEmptyDataView(int size) {

    }

    @Override
    public void onUpdateEmptyFilterView(int size) {

    }

    @Override
    public void onActionCanceled(int action, List<Integer> positions) {

    }

    @Override
    public void onActionConfirmed(int action, int event) {

    }
    public AppCompatActivity getAppCompatActivity() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            return (AppCompatActivity) activity;
        }
        return null; // Return null if the activity is not an instance of AppCompatActivity
    }
    @Override
    public void showmessage(String message, int typ, String keyname) {

    }
    public  void addview(){

        onloaddx(this.layouts,this.layoutsb,this.style);

    }
    public void onloaddx(String llayouts,String rrootLayout,String sstyles){

        try {
            A_loadingbar = getView().findViewById(R.id.fragment_Loading);
            A_loadingbar.setShowlogin(this);
            A_loadingbar.setMessagess(Whiting);
            //  dqq.attachTo(loginsys);
            A_loadingbar.showLoading();
        }catch (Exception ex){
            Log.e("vvionccc",ex.getMessage());
        }

        try {

            String ddata = "{}";

            View v = getView().findViewById(R.id.baaa);

            ccontainer = (ViewGroup) v;
            ccontainer.setFocusable(false);

            String[] dataURL = new String[]{"0"};



            x = proteus.createContextBuilder(getAppCompatActivity())
                    //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                    //.setCallback(callbackb)
                    .Setcontainerr(ccontainer).SetdataURLl(dataURL)
                    .setFrgmentMangers(getAppCompatActivity().getSupportFragmentManager())
                    .setmDrawerr(mDrawer)
                    .setMassss(this).setRootLayout("0").setData("0").setStyles("{}").setLayouts(llayouts)//.setRootLayout(rrootLayout).setData(ddata).setStyles(sstyles).setLayouts(llayouts)
                    .setmFragmenttv(this)
                    .SetActivitys(getAppCompatActivity()).setStatuse(this)
                    .build();

            infla = x.getInflater();
            Log.e("error Rtotationccc","vvvvvvvvv");
            initializeRecyclerView();
        }catch (Exception ex){
            Log.e("error Rtotationccc",ex.getMessage());
        }
        //  setdata();
      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                n.finishAnimation();
            }
        }, 5000);*/
    }

    private void initializeRecyclerView() {
        try {
            Log.e("hh","mmnbbb");
            if (A_viewManager == null) {
                A_viewManager = this.x.getrootViewManger();
            }
            if (A_dataVaqlue == null) {
                A_dataVaqlue = new ObjectValue();
            }
            if (A_ContentViewlayout == null) {
                A_ContentViewlayout = "{}";
            }

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
            }
            //  if(ccontainer==null){




            //}

            try {

            } catch (Exception ex) {

            }
            insview();
            mRecyclerView.setVisibility(View.GONE);
            // ViewHolders are different so we do NOT swap Adapters
            mRecyclerView.setAdapter(mAdapter);
            // Custom divider item decorator with Offset
            if (mDivider == null) {
                mDivider = new FlexibleItemDecoration(getActivity())
                        .withDivider(R.drawable.divider_large);
            }
            try {
                // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!
                SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
                swipeRefreshLayout.setEnabled(!configure);

                // mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);
                swipeRefreshLayout.setProgressViewEndTarget(true, 0);
                swipeRefreshLayout.setRefreshing(true);
                swipeRefreshLayout.setSelected(true);

                swipeRefreshLayout.setNestedScrollingEnabled(true);

                swipeRefreshLayout.setSlingshotDistance(0);

                // mFab.setImageResource(R.drawable.ic_check_white_24dp);
                mRecyclerView.addItemDecoration(mDivider);

            } catch (Exception ex) {
                Log.e("errorvcc Rtotation",ex.getMessage());
            }
        }catch (Exception ex){
            Log.e("error Rtotation",ex.getMessage());
        }
    }
    public void insview(){
        try {

            suces.loadfinshed();
        }catch (Exception ex){

            suces.onerror(ex.getMessage(),ex.getMessage());

        }


    }
    @Override
    public void loadfinshed() {
        try {
            A_loadingbar.hideLoading();
            A_loadingbar.hideError();
        }catch (Exception ex){

        }
    }

    @Override
    public void onerror(String mess, Object ob) {
        try {
            A_loadingbar.setMessagess(mess);
            A_loadingbar.hideLoading();
            A_loadingbar.showError();
        }catch (Exception f){

        }
    }

    @Override
    public void OnRetray() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
