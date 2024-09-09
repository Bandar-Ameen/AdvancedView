
package com.astooltech.advancedview.finaldemo.fragments;

import android.os.Bundle;

import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseType;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.conectionbase;
import com.astooltech.advancedview.finaldemo.flex;
import com.astooltech.advancedview.finaldemo.loadSettingsFirstly;
import com.astooltech.advancedview.finaldemo.protuseTestParser;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ExampleAdapter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.MainActivity;


import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ScrollableUseCaseItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter.Mode;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;

import java.util.List;


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
@SuppressWarnings("ConstantConditions")
public class customefragment extends AbstractFragment implements getmessage_status {

    public static final String TAG = customefragment.class.getSimpleName();
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;
    private FlexibleItemDecoration mDivider;
    private boolean configure;
    private MenuItem mSearchView;
    private  DrawerLayout mDrawer;
    private AbstractFragment mFragment;
    private StatuseLayout suces;
    private loadSettingsFirstly loadfirstly;
    private ProteusLayoutInflater infla;
    private String nameinfli;
    private ObjectValue obj;
    private static final String STATE_ACTIVE_FRAGMENT = "active_fragment";
    public static customefragment newInstance(boolean configure,DrawerLayout d,StatuseLayout suces,AbstractFragment mFragment,ProteusLayoutInflater infla,String nameinfli,ObjectValue obj) {


        customefragment fragment = new customefragment(d,suces,mFragment,infla,nameinfli,obj);
        Bundle args = new Bundle();
        args.putBoolean(ARG_CONFIGURE, configure);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public customefragment() {
    }
    public customefragment(DrawerLayout mDrawer,StatuseLayout suces,AbstractFragment mFragment,ProteusLayoutInflater infla,String nameinfli,ObjectValue obj) {
        this.mDrawer=mDrawer;
        this.suces=suces;
        this.mFragment=mFragment;
        this.infla=infla;
        this.nameinfli=nameinfli;
        this.obj=obj;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            if (savedInstanceState != null) {
                configure = savedInstanceState.getBoolean(ARG_CONFIGURE);
            } else if (getArguments() != null) {
                configure = getArguments().getBoolean(ARG_CONFIGURE);
            }
            if (savedInstanceState != null) {
                mFragment = (AbstractFragment) getActivity().getSupportFragmentManager().getFragment(savedInstanceState, STATE_ACTIVE_FRAGMENT);
            }
            setRetainInstance(true);
        }catch (Exception ex){

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
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
            setRetainInstance(true);
        }catch (Exception ex){

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Revert the change so next time the "if-else" is executed correctly
        try {
            configure = !configure;
            outState.putBoolean(ARG_CONFIGURE, configure);
            mAdapter.onSaveInstanceState(outState);
            getActivity().getSupportFragmentManager().putFragment(outState, this.nameinfli, this);
            super.onSaveInstanceState(outState);
            setRetainInstance(true);
        }catch (Exception ex){

        }
        // super.onSaveInstanceState(outState);
    }
    public void onloadd(ViewGroup container){

        if(loadfirstly==null){
            loadfirstly=new loadSettingsFirstly(getContext(),conectionbase.fir);
        }
        // data = proteusManager.getData();
        // setmydatt();

        com.astooltech.advancedview.database.DatabaseHelper tt=new DatabaseHelper(getContext());

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
        ScriptModel gx=new ScriptModel(0,"00",loadfirstly.getfulUrl(conectionbase.Alayout));
        List<ScriptModel> hx= tt.getAllNotes(gx);
        String rrootLayout=    hx.get(0).getContent();

        Log.e("ggg",rrootLayout);
        // String llayouts = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[3],this);
        ScriptModel gx1=new ScriptModel(0,"00", loadfirstly.getfulUrl(conectionbase.Alayouts));
        List<ScriptModel>  hx1= tt.getAllNotes(gx1);
        String llayouts=    hx1.get(0).getContent();
        String[] dataURL=new String[]{"0"};
        Log.e("ggg",llayouts);
        // String sstyles = com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom(dataURL[4],this);
        ScriptModel gx11=new ScriptModel(0,"00", loadfirstly.getfulUrl(conectionbase.AStyles));
        List<ScriptModel>  hx11= tt.getAllNotes(gx11);
        String sstyles=    hx11.get(0).getContent();
        // skeletonViewGroup.stopShimmer();
        // setdata();
        Log.e("jjn",llayouts);
        Log.e("jj",ddata);
        proteus.createContextBuilder(getContext())
                //.SetAllEvent(new all_action_Activity(containerr,this,proteusManagerr,dataURLl,layoutInflaterr,massss,getSupportFragmentManager(), mFragmentt,mDrawerr))
                //.setCallback(callbackb)
                .Setcontainerr(container).SetdataURLl(dataURL)
                .setFrgmentMangers(getChildFragmentManager())
                .setmDrawerr(mDrawer)
                .setMassss(this).setRootLayout(rrootLayout).setData(ddata).setStyles(sstyles).setLayouts(llayouts)
                .setmFragmenttv(mFragment)
                .SetActivitys((AppCompatActivity)getActivity()).setStatuse(suces)
                .build();

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
/*if(proteus==null){
    proteus=   new ProteusBuilder().register(Updatek).register(Allevtshit).register(OpenActivity).register(new protuseTestParser()).register(OpenActivityhidlib )

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
            // if(ccontainer==null){

            // ccontainer=(ViewGroup)getView().findViewById(R.id.baaa);
            //   getView().findViewById(R.id.container_without_sweep).setVisibility(View.GONE);
            View v = getView().findViewById(R.id.baaa);
            ccontainer = (ViewGroup) v;
            ccontainer.setFocusable(false);


            //  }
            A_dataVaqlue = this.obj;
            A_layoutInflater = this.infla;
            A_ContentViewlayout = this.nameinfli;
            try {
                ProteusView pp = A_layoutInflater.inflate(A_ContentViewlayout, A_dataVaqlue, ccontainer, 1);


                ccontainer.addView(pp.getAsView());
            } catch (Exception ex) {
                // Toast.makeText(getContext(),"dddddd"+ex.getMessage(),Toast.LENGTH_LONG).show();
            }
            //  onloadd(ccontainer);
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
                mFab.setImageResource(R.drawable.ic_settings_white_24dp);
                mRecyclerView.removeItemDecoration(mDivider);
                FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
                fastScroller.addOnScrollStateChangeListener((flex) getActivity());
                mAdapter.setFastScroller(fastScroller);
            }

            // New empty views handling, to set after FastScroller
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
}