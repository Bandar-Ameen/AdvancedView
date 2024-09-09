package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.Proteus;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollGridLayoutManager;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollStaggeredLayoutManager;
import com.astooltech.advancedview.proteus.view.LodaingLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public abstract class AbstractShitFragment extends BottomSheetDialogFragment {

    public static final String TAG = AbstractFragment.class.getSimpleName();
    protected static final String ARG_COLUMN_COUNT = "column_count";
    protected static final String ARG_CONFIGURE = "dynamic_list";

    protected OnFragmentInteractionListener mListener;
    protected int mColumnCount = 2;
    protected RecyclerView mRecyclerView;
    protected FloatingActionButton mFab;
    protected int typFragment;
    protected View viewfragment;
    protected ViewGroup ccontainer;
    protected Proteus proteus;
    protected ViewGroup ccontainer_without_sweep;
    protected SwipeRefreshLayout Swep_layout;
    protected LodaingLayout A_loadingbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ccontainer=getActivity().findViewById(R.id.baaa);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        //Contribution for specific action buttons in the Toolbar
        setHasOptionsMenu(true);

    }
    protected abstract void childFragments(View view,Bundle savedInstanceState);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_recycler_view, container, false);
        childFragments(v,savedInstanceState);
        return v;


    }

    /**
     * Display FAB button and restore default icon
     */
    protected void initializeFab() {
        mFab = getActivity().findViewById(R.id.fab);
        mFab.setImageResource(R.drawable.fab_add);
        ViewCompat.animate(mFab)
                .scaleX(1f).scaleY(1f)
                .alpha(1f).setDuration(100)
                .setStartDelay(300L)
                .start();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            mListener=addlis();
            //throw new RuntimeException(activity.toString()
            //  + " must implement OnFragmentInteractionListener");
        }
    }
    private OnFragmentInteractionListener addlis(){
        OnFragmentInteractionListener tr=new OnFragmentInteractionListener() {
            @Override
            public void onFragmentChange(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, int mode) {

            }

            @Override
            public void initSearchView(Menu menu) {

            }
        };

        return tr;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        if (id == R.id.action_list_type) {
            if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
                item.setIcon(R.drawable.ic_view_grid_white_24dp);
                item.setTitle(R.string.grid_layout);//next click
                showNewLayoutInfo(item);
            } else if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
                item.setIcon(R.drawable.ic_view_agenda_white_24dp);
                item.setTitle(R.string.linear_layout);//next click
                showNewLayoutInfo(item);
            } else {
                mRecyclerView.setLayoutManager(createNewGridLayoutManager());
                item.setIcon(R.drawable.ic_dashboard_white_24dp);
                item.setTitle(R.string.staggered_layout);//next click
                showNewLayoutInfo(item);
            }

        }
        return super.onOptionsItemSelected(item);
    }

    protected LinearLayoutManager createNewLinearLayoutManager() {
        return new SmoothScrollLinearLayoutManager(getActivity());
    }

    protected GridLayoutManager createNewGridLayoutManager() {
        return new SmoothScrollGridLayoutManager(getActivity(), mColumnCount);
    }

    protected StaggeredGridLayoutManager createNewStaggeredGridLayoutManager() {
        return new SmoothScrollStaggeredLayoutManager(getActivity(), mColumnCount);
    }

    public void performFabAction() {
        //default implementation does nothing
    }

    public int getContextMenuResId() {
        //default Menu Context is returned
        return R.menu.menu_context;
    }

    @CallSuper
    public void showNewLayoutInfo(final MenuItem item) {
        // item.setEnabled(false);
        if(typFragment==0) {

            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    item.setEnabled(true);
                }
            }, 1000L);
        }
    }

}