package com.astooltech.advancedview.finaldemo.fragments;

import android.os.Bundle;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.ExampleAdapter;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FadeInDownItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FadeInItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FadeInLeftItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FadeInRightItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FadeInUpItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FlipInBottomXItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.FlipInTopXItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.LandingItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.OvershootInLeftItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.OvershootInRightItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.ScaleInItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.SlideInDownItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.SlideInLeftItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.SlideInRightItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators.SlideInUpItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ScrollableUseCaseItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseConfiguration;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.SelectableAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemAnimator;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.anotherView.flipview.FlipView;
import com.astooltech.advancedview.R;


/**
 * Testing different types of item animators including scrolling animations.
 */
public class FragmentAnimators extends AbstractFragment {

    public static final String TAG = FragmentAnimators.class.getSimpleName();

    private ExampleAdapter mAdapter;

    /* Spinner selected item */
    private static int selectedItemAnimator = -1;
    private static int selectedScrollAnimator = -1;

    public static FragmentAnimators newInstance() {
        return new FragmentAnimators();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentAnimators() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Create New Database and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createAnimatorsDatabase(20); //N. of sections
        }
        initializeRecyclerView(savedInstanceState);

        // Restore FAB button and icon
        initializeFab();

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @SuppressWarnings({"ConstantConditions", "NullableProblems"})
    private void initializeRecyclerView(Bundle savedInstanceState) {
        FlexibleAdapter.useTag("AnimatorsAdapter");
        mAdapter = new ExampleAdapter(DatabaseService.getInstance().getDatabaseList(), getActivity());
        mAdapter.expandItemsAtStartUp()
                .setAutoCollapseOnExpand(false)
                .setAutoScrollOnExpand(true)
                .setOnlyEntryAnimation(false)
                .setAnimationEntryStep(true) //In Overall, watch the effect at initial loading when Grid Layout is set
                .setAnimationOnForwardScrolling(DatabaseConfiguration.animateOnForwardScrolling)
                .setAnimationOnReverseScrolling(true)
                .setAnimationInterpolator(new DecelerateInterpolator())
                .setAnimationDuration(300L);
        mRecyclerView = getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(createNewLinearLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        //mRecyclerView.setHasFixedSize(true); //Size of RV will not change

        // NOTE: Custom item animators inherit 'canReuseUpdatedViewHolder()' from Default Item
        // Animator. It will return true if a Payload is provided. FlexibleAdapter is actually
        // sending Payloads onItemChange notifications.
        mRecyclerView.setItemAnimator(new FlexibleItemAnimator());
        initializeSpinnerItemAnimators();
        initializeSpinnerScrollAnimators();

        mAdapter.setSwipeEnabled(true)
                .getItemTouchHelperCallback()
                .setSwipeFlags(ItemTouchHelper.RIGHT); //Enable swipe

        SwipeRefreshLayout swipeRefreshLayout = getView().findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setEnabled(false);
        mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, SelectableAdapter.Mode.IDLE);

        // Add 1 Scrollable Header
        mAdapter.addScrollableHeader(new ScrollableUseCaseItem(
                getString(R.string.animator_use_case_title),
                getString(R.string.animator_use_case_description)));
    }

    @Override
    public void performFabAction() {
        int size = 1 + DatabaseService.getInstance().getDatabaseList().size();
        AbstractFlexibleItem item = DatabaseService.newAnimatorItem(size);
        DatabaseService.getInstance().addItem(item);
        mAdapter.addItem(mAdapter.getItemCount(), item);
    }

    @Override
    public void showNewLayoutInfo(MenuItem item) {
        super.showNewLayoutInfo(item);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.showLayoutInfo(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.v(TAG, "onCreateOptionsMenu called!");
        inflater.inflate(R.menu.menu_animators, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sub_item_specific) {
            item.setChecked(!item.isChecked());
            DatabaseConfiguration.subItemSpecificAnimation = item.isChecked();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().findViewById(R.id.layout_for_spinners).setVisibility(View.GONE);
    }

    private void initializeSpinnerItemAnimators() {
        // Creating adapter for spinner1
        ArrayAdapter<AnimatorType> spinnerAdapter = new ArrayAdapter<AnimatorType>(
                getActivity(), android.R.layout.simple_spinner_item, AnimatorType.values()) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundResource(R.drawable.selector_item_light);
                view.setActivated(position == selectedItemAnimator);
                return view;
            }
        };

        // Drop down layout style - list view with radio button
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Make visible spinner configuration
        getActivity().findViewById(R.id.layout_for_spinners).setVisibility(View.VISIBLE);

        Spinner spinner = getActivity().findViewById(R.id.spinner_item_animators);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(7);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mRecyclerView.setItemAnimator(AnimatorType.values()[position].getAnimator());
                mRecyclerView.getItemAnimator().setAddDuration(500);
                mRecyclerView.getItemAnimator().setRemoveDuration(500);
                selectedItemAnimator = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initializeSpinnerScrollAnimators() {
        // Creating adapter for spinner2
        ArrayAdapter<com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentAnimators.ScrollAnimatorType> spinnerAdapter = new ArrayAdapter<com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentAnimators.ScrollAnimatorType>(
                getActivity(), android.R.layout.simple_spinner_item, com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentAnimators.ScrollAnimatorType.values()) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                view.setBackgroundResource(R.drawable.selector_item_light);
                view.setActivated(position == selectedScrollAnimator);
                return view;
            }
        };

        // Drop down layout style - list view with radio button
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Make visible spinner configuration
        getActivity().findViewById(R.id.layout_for_spinners).setVisibility(View.VISIBLE);

        Spinner spinner = getActivity().findViewById(R.id.spinner_scrolling_animation);
        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DatabaseConfiguration.scrollAnimatorType = com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.FragmentAnimators.ScrollAnimatorType.values()[position];
                selectedScrollAnimator = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public enum AnimatorType {
        FadeIn(new FadeInItemAnimator(new OvershootInterpolator(1f))),
        FadeInDown(new FadeInDownItemAnimator(new OvershootInterpolator(1f))),
        FadeInUp(new FadeInUpItemAnimator(new OvershootInterpolator(1f))),
        FadeInLeft(new FadeInLeftItemAnimator(new OvershootInterpolator(1f))),
        FadeInRight(new FadeInRightItemAnimator(new OvershootInterpolator(1f))),
        Landing(new LandingItemAnimator(new OvershootInterpolator(1f))),
        ScaleIn(new ScaleInItemAnimator(new OvershootInterpolator(1f))),
        FlipInTopX(new FlipInTopXItemAnimator(new DecelerateInterpolator(1f))), //Makes use of index inside
        FlipInBottomX(new FlipInBottomXItemAnimator(new OvershootInterpolator(1f))),
        SlideInLeft(new SlideInLeftItemAnimator(new OvershootInterpolator(1f))),
        SlideInRight(new SlideInRightItemAnimator(new OvershootInterpolator(1f))),
        SlideInDown(new SlideInDownItemAnimator(new OvershootInterpolator(1f))),
        SlideInUp(new SlideInUpItemAnimator(new OvershootInterpolator(1f))),
        OvershootInRight(new OvershootInRightItemAnimator(1f)),
        OvershootInLeft(new OvershootInLeftItemAnimator(1f));

        private FlexibleItemAnimator mAnimator;

        AnimatorType(FlexibleItemAnimator animator) {
            mAnimator = animator;
        }

        public FlexibleItemAnimator getAnimator() {
            return mAnimator;
        }
    }



}