package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ProgressItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.Payload;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter.Mode;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemDecoration;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.helpers.EmptyViewHelper;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class FragmentInstagramHeaders extends AbstractFragment
        implements FlexibleAdapter.EndlessScrollListener {

    public static final String TAG = FragmentInstagramHeaders.class.getSimpleName();
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }
    /**
     * Custom implementation of FlexibleAdapter
     */
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;


    public static FragmentInstagramHeaders newInstance() {
        return new FragmentInstagramHeaders();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentInstagramHeaders() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Create New Database and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createInstagramHeadersDatabase(15);
        }
        initializeRecyclerView();

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void initializeRecyclerView() {
        // Initialize Adapter and RecyclerView
        // true = it makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        FlexibleAdapter.useTag("InstagramHeadersAdapter");
        mAdapter = new FlexibleAdapter<>(null, getActivity(), true);
        mAdapter.addListener(getActivity())
                .setAnimationOnForwardScrolling(true)
                .setAnimationOnReverseScrolling(true);
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 24dpi as empty space between sections (each post)
        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity())
                .withSectionGapOffset(24));

        // New empty views handling
        EmptyViewHelper.create(mAdapter, getView().findViewById(R.id.empty_view));

        mAdapter.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
                .setStickyHeaders(true) //Make headers sticky
                // Endless scroll with 1 item threshold
                .setLoadingMoreAtStartUp(true)
                .setEndlessScrollListener(this, new ProgressItem())
                .setEndlessScrollThreshold(1); //Default=1

        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(true);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, Mode.IDLE);
    }

    /**
     * No more data to load.
     * <p>This method is called if any limit is reached (<b>targetCount</b> or <b>pageSize</b>
     * must be set) AND if new data is <u>temporary</u> unavailable (ex. no connection or no
     * new updates remotely). If no new data, a {@link FlexibleAdapter#notifyItemChanged(int, Object)}
     * with a payload {@link Payload#NO_MORE_LOAD} is triggered on the <i>progressItem</i>.</p>
     *
     * @param newItemsSize the last size of the new items loaded
     * @see FlexibleAdapter#setEndlessTargetCount(int)
     * @see FlexibleAdapter#setEndlessPageSize(int)
     * @since 5.0.0-rc1
     */
    @Override
    public void noMoreLoad(int newItemsSize) {
        // This method will never be called if No limits are set and loading more will always
        // produce new items (as this example does)
    }

    /**
     * Loads more data.
     * <p>Use {@code lastPosition} and {@code currentPage} to know what to load next.</p>
     * {@code lastPosition} is the count of the main items without Scrollable Headers.
     *
     * @param lastPosition the position of the last main item in the adapter
     * @param currentPage  the current page
     * @since 5.0.0-b6
     * <br>5.0.0-rc1 added {@code lastPosition} and {@code currentPage} as parameters
     */
    @Override
    public void onLoadMore(int lastPosition, int currentPage) {
        Log.i(TAG, "onLoadMore invoked!");
        // Simulating asynchronous call
        new Handler().postDelayed(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                final List<AbstractFlexibleItem> newItems = new ArrayList<>(10);

                // Simulating success/failure
                int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
                for (int i = 1; i <= 10; i++) {
                    newItems.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
                }

                // Callback the Adapter to notify the change
                // Items will be added to the end of the main list
                mAdapter.onLoadMoreComplete(newItems);
                Log.d(TAG, "newItemsSize=" + newItems.size());
                Log.d(TAG, "EndlessCurrentPage=" + mAdapter.getEndlessCurrentPage());
                Log.d(TAG, "EndlessPageSize=" + mAdapter.getEndlessPageSize());
                Log.d(TAG, "EndlessTargetCount=" + mAdapter.getEndlessTargetCount());

                // Notify user
                if (getActivity() != null && newItems.size() > 0) {
                    Toast.makeText(getActivity(),
                            "Fetched " + newItems.size() + " new items",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_list_type)
            mAdapter.setAnimationOnForwardScrolling(true);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected GridLayoutManager createNewGridLayoutManager() {
        return null;
    }
}