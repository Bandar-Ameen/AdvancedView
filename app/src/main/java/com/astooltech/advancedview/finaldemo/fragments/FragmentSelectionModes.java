package com.astooltech.advancedview.finaldemo.fragments;

import android.os.Bundle;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ExampleAdapter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ScrollableUseCaseItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.finaldemo.flex;
import com.google.android.material.snackbar.Snackbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentSelectionModes extends AbstractFragment {

    public static final String TAG = FragmentSelectionModes.class.getSimpleName();
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    /**
     * Custom implementation of FlexibleAdapter
     */
    private ExampleAdapter mAdapter;


    @SuppressWarnings("unused")
    public static FragmentSelectionModes newInstance(int columnCount) {
        FragmentSelectionModes fragment = new FragmentSelectionModes();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentSelectionModes() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Create New Database and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createEndlessDatabase(200);
        }
        initializeRecyclerView(savedInstanceState);

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    private void initializeRecyclerView(Bundle savedInstanceState) {
        // Get the Database list
        List<AbstractFlexibleItem> items = DatabaseService.getInstance().getDatabaseList();

        // Initialize Adapter and RecyclerView
        // ExampleAdapter makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        FlexibleAdapter.useTag("SelectionModesAdapter");
        mAdapter = new ExampleAdapter(items, getActivity());
        mAdapter.setNotifyChangeOfUnfilteredItems(true) //true is the default! This will rebind new item when refreshed
                .setMode(SelectableAdapter.Mode.SINGLE);

        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Divider item decorator with DrawOver enabled
        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity())
                .withDivider(R.drawable.divider, R.layout.recycler_simple_item)
                .withDrawOver(true));
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(getView(), "Selection SINGLE is enabled", Snackbar.LENGTH_SHORT).show();
            }
        }, 1500L);

        // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!!!
        FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
        fastScroller.setAutoHideEnabled(true);        //true is the default value!
        fastScroller.setAutoHideDelayInMillis(1000L); //1000ms is the default value!
        fastScroller.setMinimumScrollThreshold(70); //0 pixel is the default value! When > 0 it mimics the fling gesture
        fastScroller.addOnScrollStateChangeListener((flex) getActivity());
        // The color (accentColor) is automatically fetched by the FastScroller constructor, but you can change it at runtime
        // fastScroller.setBubbleAndHandleColor(Color.RED);
        mAdapter.setFastScroller(fastScroller);

        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(true);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.SINGLE);

        // Add 2 Scrollable Headers
        mAdapter.addUserLearnedSelection(savedInstanceState == null);
        mAdapter.addScrollableHeaderWithDelay(new ScrollableUseCaseItem(
                getString(R.string.selection_modes_use_case_title),
                getString(R.string.selection_modes_use_case_description)), 1200L, true
        );
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_selection_modes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_list_type)
            mAdapter.setAnimationOnForwardScrolling(true);
        return super.onOptionsItemSelected(item);
    }

}