package com.astooltech.advancedview.proteus.v7;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.vlayout.LayoutHelper;
import com.astooltech.advancedview.vlayout.LayoutManagerHelper;
import com.astooltech.advancedview.vlayout.VirtualLayoutManager;
import com.astooltech.advancedview.vlayout.layout.LayoutChunkResult;


public class ProtouseOnePlusNLayoutHelper extends LayoutHelper implements ProteusView {





    Manager manager;


    @Override
    public Manager getViewManager() {


        return manager;
    }

    @Override
    public void setViewManager(@NonNull Manager manager) {


        //  manager.setActionEventView(Act);
        this.manager = manager;


    }


    @NonNull
    @Override
    public View getAsView() {
     bindLayoutView(this.getAsView());
        return getFixedView();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void setItemCount(int itemCount) {

    }

    @Override
    public void doLayout(RecyclerView.Recycler recycler, RecyclerView.State state, VirtualLayoutManager.LayoutStateWrapper layoutState, LayoutChunkResult result, LayoutManagerHelper helper) {

    }

    @Override
    public void beforeLayout(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutManagerHelper helper) {

    }

    @Override
    public void afterLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int startPosition, int endPosition, int scrolled, LayoutManagerHelper helper) {

    }

    @Override
    public void adjustLayout(int startPosition, int endPosition, LayoutManagerHelper helper) {

    }

    @Override
    public void clear(LayoutManagerHelper helper) {

    }

    @Override
    public boolean requireLayoutView() {
        return false;
    }

    @Override
    public void bindLayoutView(View layoutView) {

    }

    @Override
    public boolean isFixLayout() {
        return false;
    }

    @Override
    public int computeAlignOffset(int offset, boolean isLayoutEnd, boolean useAnchor, LayoutManagerHelper helper) {
        return 0;
    }

    @Override
    public int computeMarginStart(int offset, boolean isLayoutEnd, boolean useAnchor, LayoutManagerHelper helper) {
        return 0;
    }

    @Override
    public int computeMarginEnd(int offset, boolean isLayoutEnd, boolean useAnchor, LayoutManagerHelper helper) {
        return 0;
    }

    @Override
    public int computePaddingStart(int offset, boolean isLayoutEnd, boolean useAnchor, LayoutManagerHelper helper) {
        return 0;
    }

    @Override
    public int computePaddingEnd(int offset, boolean isLayoutEnd, boolean useAnchor, LayoutManagerHelper helper) {
        return 0;
    }

    /* public ProtouseOnePlusNLayoutHelper(Context context) {
         super(context);
     }

     public ProtouseOnePlusNLayoutHelper(Context context, AttributeSet attrs) {
         super(context, attrs);
     }

     public ProtouseOnePlusNLayoutHelper(Context context, AttributeSet attrs, int defStyleAttr) {
         super(context, attrs, defStyleAttr);
     }



     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     public ProteusButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
         super(context, attrs, defStyleAttr, defStyleRes);
     }
 */

}
