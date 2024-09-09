package com.astooltech.advancedview.finaldemo;

import android.app.Activity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.ScrollableLayoutItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.services.DatabaseService;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.google.android.material.internal.ScrimInsetsFrameLayout;


/**
 * This is a custom implementation extending FlexibleAdapter. {@code AbstractFlexibleItem} is
 * used as most common Item for ALL view types.
 * <p>Binding is delegated via items (AutoMap), you <u>cannot</u> implement
 * {@code getItemViewType, onCreateViewHolder, onBindViewHolder}.</p>
 * Check {@code ExampleAdapter} for <b>METHOD A</b> (new way).
 *
 * @see ExampleAdapter
 * @see AbstractFlexibleItem
 */
public class OverallAdapter extends FlexibleAdapter<AbstractFlexibleItem> {

    private static final String TAG = OverallAdapter.class.getSimpleName();

    public OverallAdapter(Activity activity) {
        //true = Items implement hashCode() and have stableIds!
        super(DatabaseService.getInstance().getDatabaseList(), activity, true);
    }

    /*
     * HEADER/FOOTER VIEW
     * This method show how to add Header/Footer View as it was for ListView.
     * The secret is the position! 0 for Header; itemCount for Footer ;-)
     * The view is represented by a custom Item type to better represent any dynamic content.
     */
    public void showLayoutInfo(boolean scrollToPosition) {
        if (!hasFilter()) {

            //Define Example View
            final ScrollableLayoutItem item = new ScrollableLayoutItem("LAY-L");
            if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                item.setId("LAY-S");
                item.setTitle(mRecyclerView.getContext().getString(R.string.staggered_layout));
            } else if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                item.setId("LAY-G");
                item.setTitle(mRecyclerView.getContext().getString(R.string.grid_layout));
            } else {
                item.setTitle(mRecyclerView.getContext().getString(R.string.linear_layout));
            }
            item.setSubtitle(mRecyclerView.getContext().getString(
                    R.string.columns,
                    String.valueOf(getFlexibleLayoutManager().getSpanCount()))
            );
            addScrollableHeaderWithDelay(item, 300L, scrollToPosition);
            removeScrollableHeaderWithDelay(item, 2000L);
        }
    }

}