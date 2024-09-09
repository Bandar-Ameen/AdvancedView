
package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusView;
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
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.astooltech.advancedview.GlobalClass.Whiting;


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
@SuppressWarnings("ConstantConditions")
public class customefragment extends AbstractFragment implements getmessage_status,StatuseLayout {

    public static final String TAG = customefragment.class.getSimpleName();

    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;
    private FlexibleItemDecoration mDivider;
    private boolean configure;
    private MenuItem mSearchView;
    private  DrawerLayout mDrawer;
    private ProteusView vies;
    private StatuseLayout suces;
private ProteusView.Manager viewManager;
private  String  ContentViewlayout;
private  ObjectValue dataVaqlue;
    public static customefragment newInstance(boolean configure, ProteusView.Manager  vies,String  ContentViewlayout,ObjectValue dataVaqlue) {
        customefragment fragment = new customefragment(configure,vies,ContentViewlayout, dataVaqlue);
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
    public customefragment(boolean c,ProteusView.Manager  vies,String  ContentViewlayout,ObjectValue dataVaqlue) {
        this.viewManager=vies;
        this.ContentViewlayout=ContentViewlayout;
        this.dataVaqlue=dataVaqlue;
        this.suces=this;

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
    setRetainInstance(true);
}catch (Exception ex){

}
    }
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restore FAB button and icon
      try {
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
      }catch (Exception ex){

      }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Revert the change so next time the "if-else" is executed correctly
        configure = !configure;
        outState.putBoolean(ARG_CONFIGURE, configure);
        super.onSaveInstanceState(outState);

    }
  /*  public void onloadd(ViewGroup container){
if(this.vies!=null){

    ProteusView view = getInflater().inflate(getlayoutroot(), datagetdat(), containerrb, 0);
if(this.vies.getAsView().getParent()!=null){

    ((ViewGroup)this.vies.getAsView().getParent()).removeView(this.vies.getAsView());
   // container.removeView(container.getParent());
}
    container.addView(this.vies.getAsView());
}

    }*/
    private void initializeRecyclerView() {
try {
    if (A_viewManager == null) {
        A_viewManager = this.viewManager;
    }
    if (A_dataVaqlue == null) {
        A_dataVaqlue = this.dataVaqlue;
    }
    if (A_ContentViewlayout == null) {
        A_ContentViewlayout = this.ContentViewlayout;
    }
  try {
        A_loadingbar = getView().findViewById(R.id.fragment_Loading);
        A_loadingbar.setShowlogin(this);
        A_loadingbar.setMessagess(Whiting);
        //  dqq.attachTo(loginsys);
        A_loadingbar.showLoading();
    }catch (Exception ex){

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

    View v = getView().findViewById(R.id.baaa);
    //  getView().findViewById(R.id.container_without_sweep).setVisibility(View.GONE);
    ccontainer = (ViewGroup) v;
    ccontainer.setFocusable(false);


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
  /*  FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
    fastScroller.setEnabled(false);


    // New empty views handling, to set after FastScroller
    EmptyViewHelper.create(mAdapter,
            getView().findViewById(R.id.empty_view),
            getView().findViewById(R.id.filter_view),
            (EmptyViewHelper.OnEmptyViewListener) getActivity()); // Optional!!

    // Settings for FlipView
    FlipView.stopLayoutAnimation();
    showFab(1200L);*/
    } catch (Exception ex) {

    }
}catch (Exception ex){
    Log.e("error Rtotation",ex.getMessage());
}
    }
    public void insview(){
        try {
           /* try {
                this.ccontainer.removeAllViews();
            } catch (Exception ex) {

            }*/
            ProteusView view = A_viewManager.getContext().getInflater().inflate(A_ContentViewlayout, A_dataVaqlue, ccontainer, 0);
            //  System.out.println("inflate time: " + (System.currentTimeMillis() - start));

            // Add the inflated view to the container
            ccontainer.addView(view.getAsView());
           suces.loadfinshed();
        }catch (Exception ex){

                suces.onerror(ex.getMessage(),ex.getMessage());

        }


    }
    @Override
    public void performFabAction() {
      /*  hideFab(); //Give time to hide FAB before changing everything
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
        }, 200L);*/
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
       /* Log.v(TAG, "onCreateOptionsMenu called!");
        inflater.inflate(R.menu.menu_filter, menu);
        mListener.initSearchView(menu);*/
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
       /* mSearchView = menu.findItem(R.id.action_search);
        mSearchView.setVisible(mAdapter.getItemCount() > 0 &&
                DatabaseService.getInstance().getDatabaseType() != DatabaseType.CONFIGURATION);*/
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
}