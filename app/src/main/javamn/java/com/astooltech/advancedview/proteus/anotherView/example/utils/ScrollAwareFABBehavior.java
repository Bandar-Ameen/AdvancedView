package com.astooltech.advancedview.proteus.anotherView.example.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    private boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(@NonNull final CoordinatorLayout coordinatorLayout,
                                       @NonNull final FloatingActionButton child,
                                       @NonNull final View directTargetChild,
                                       @NonNull final View target,
                                       final int nestedScrollAxes,
                                       final int type) {
        // Ensure we react to vertical scrolling
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes, type);
    }

    @Override
    public void onNestedScroll(@NonNull final CoordinatorLayout coordinatorLayout,
                               @NonNull final FloatingActionButton fab,
                               @NonNull final View target,
                               final int dxConsumed,
                               final int dyConsumed,
                               final int dxUnconsumed,
                               final int dyUnconsumed,
                               final int type) {
        super.onNestedScroll(coordinatorLayout, fab, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if (!enabled) return;
        if (dyConsumed > 0 && fab.getVisibility() == View.VISIBLE) {
            // User scrolled down and the FAB is currently visible -> hide the FAB
            fab.hide();
        } else if (dyConsumed < 0 && fab.getVisibility() != View.VISIBLE) {
            // User scrolled up and the FAB is currently not visible -> show the FAB
            fab.postDelayed(new Runnable() {
                @Override
                public void run() {
                    fab.show();
                }
            }, 200L);
        }
    }

}