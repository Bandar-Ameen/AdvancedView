package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ExampleAdapter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.MainActivity;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter.Mode;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollGridLayoutManager;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentExpandableMultiLevel extends AbstractFragment {

    public static final String TAG = FragmentExpandableMultiLevel.class.getSimpleName();

    private ExampleAdapter mAdapter;
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    public static FragmentExpandableMultiLevel newInstance(int columnCount) {
        FragmentExpandableMultiLevel fragment = new FragmentExpandableMultiLevel();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentExpandableMultiLevel() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Create New Database and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createExpandableMultiLevelDatabase(50);
        }
        initializeRecyclerView(savedInstanceState);

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    private void initializeRecyclerView(Bundle savedInstanceState) {
        // Initialize Adapter and RecyclerView
        // ExampleAdapter makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        FlexibleAdapter.useTag("ExpandableMultiLevelAdapter");
        mAdapter = new ExampleAdapter(DatabaseService.getInstance().getDatabaseList(), getActivity());
        mAdapter.expandItemsAtStartUp()
                .setNotifyMoveOfFilteredItems(true)
                .setAutoCollapseOnExpand(false)
                .setMinCollapsibleLevel(1) //Auto-collapse only items with level >= 1 (avoid to collapse also sections!)
                .setAutoScrollOnExpand(true);
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!!!
        FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
        fastScroller.addOnScrollStateChangeListener((MainActivity) getActivity());
        mAdapter.setFastScroller(fastScroller);

        // New empty views handling, to set after FastScroller
        EmptyViewHelper.create(mAdapter,
                getView().findViewById(R.id.empty_view),
                getView().findViewById(R.id.filter_view));

        mAdapter.setLongPressDragEnabled(true) //Enable long press to drag items
                .setHandleDragEnabled(true) //Enable handle drag
                .setSwipeEnabled(true); //Enable swipe items
        //.setDisplayHeadersAtStartUp(true); //Show Headers at startUp: not necessary if Headers are also Expandable!

        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity())
                .withSectionGapOffset(24));

        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(true);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, Mode.IDLE);

        // Add 1 Scrollable Header
        mAdapter.addUserLearnedSelection(savedInstanceState == null);
    }

    @Override
    public void showNewLayoutInfo(MenuItem item) {
        super.showNewLayoutInfo(item);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.showLayoutInfo(false);
    }

    @Override
    protected GridLayoutManager createNewGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new SmoothScrollGridLayoutManager(getActivity(), mColumnCount);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // NOTE: If you use simple integers to identify the ViewType,
                // here, you should use them and not Layout integers
                int itemViewType = mAdapter.getItemViewType(position);
                if (itemViewType == R.layout.recycler_scrollable_layout_item || itemViewType == R.layout.recycler_scrollable_uls_item || itemViewType == R.layout.recycler_header_item || itemViewType == R.layout.recycler_expandable_header_item || itemViewType == R.layout.recycler_expandable_item) {
                    return mColumnCount;
                }
                return 1;
            }
        });
        return gridLayoutManager;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.v(TAG, "onCreateOptionsMenu called!");
        inflater.inflate(R.menu.menu_expandable, menu);
        mListener.initSearchView(menu);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_recursive_collapse) {
            if (mAdapter.isRecursiveCollapse()) {
                mAdapter.setRecursiveCollapse(false);
                item.setChecked(false);
                Snackbar.make(getView(), "Recursive-Collapse is disabled", Snackbar.LENGTH_SHORT).show();
            } else {
                mAdapter.setRecursiveCollapse(true);
                item.setChecked(true);
                Snackbar.make(getView(), "Recursive-Collapse is enabled", Snackbar.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}