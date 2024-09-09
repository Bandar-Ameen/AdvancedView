package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.HeaderItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.IFlexible;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentViewPager extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = FragmentViewPager.class.getSimpleName();

    private int mSection;
    private FlexibleAdapter mAdapter;

    public FragmentViewPager() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FragmentViewPager newInstance(int sectionNumber) {
        FragmentViewPager fragment = new FragmentViewPager();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mSection = getArguments().getInt(ARG_SECTION_NUMBER);
            Log.d(TAG, "Creating new Fragment for Section " + mSection);
        }

        // Contribution for specific action buttons in the Toolbar
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Initialize RecyclerView
        initializeRecyclerView();

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mAdapter != null) {
            mAdapter.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && mAdapter != null) {
            mAdapter.onRestoreInstanceState(savedInstanceState);
        }
    }

    private void initializeRecyclerView() {
        // Initialize Adapter and RecyclerView
        // Use of stableIds, I strongly suggest to implement 'item.hashCode()'
        FlexibleAdapter.useTag("ViewPagerAdapter");
        mAdapter = new FlexibleAdapter<>(createList(50, 5), getActivity(), true);
        mAdapter.setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling);

        RecyclerView mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add FastScroll to the RecyclerView, after the Adapter has been attached the RecyclerView!!!
        FastScroller fastScroller = getView().findViewById(R.id.fast_scroller);
        mAdapter.setFastScroller(fastScroller);

        // Sticky Headers
        mAdapter.setDisplayHeadersAtStartUp(true)
                .setStickyHeaders(true);
    }

    private List<IFlexible> createList(int size, int headers) {
        HeaderItem header = null;
        List<IFlexible> items = new ArrayList<>();
        int lastHeaderId = 0;
        for (int i = 0; i < size; i++) {
            header = i % Math.round(size / headers) == 0 ?
                    DatabaseService.newHeader(++lastHeaderId) : header;
            items.add(DatabaseService.newSimpleItem(i + 1, header));
        }
        return items;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        // Headers are shown?
        MenuItem headersMenuItem = menu.findItem(R.id.action_show_hide_headers);
        if (headersMenuItem != null) {
            headersMenuItem.setTitle(mAdapter.areHeadersShown() ? R.string.hide_headers : R.string.show_headers);
        }
        // Sticky Header item?
        MenuItem stickyItem = menu.findItem(R.id.action_sticky_headers);
        if (stickyItem != null) {
            stickyItem.setEnabled(mAdapter.areHeadersShown());
            stickyItem.setChecked(mAdapter.areHeadersSticky());
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sticky_headers) {
            item.setChecked(!mAdapter.areHeadersSticky());
            mAdapter.setStickyHeaders(!mAdapter.areHeadersSticky());
        } else if (id == R.id.action_show_hide_headers) {
            if (mAdapter.areHeadersShown()) {
                mAdapter.hideAllHeaders();
                item.setTitle(R.string.show_headers);
            } else {
                mAdapter.showAllHeaders();
                item.setTitle(R.string.hide_headers);
            }
        }
        return super.onOptionsItemSelected(item);
    }

}