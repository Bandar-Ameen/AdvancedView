/*
 * Copyright 2016-2017 Davide Steduto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.FlexibleAdapter;

import java.util.List;

/**
 * Generic implementation of {@link IFlexible} interface with most useful methods to manage
 * selection and view holder methods.
 *
 * @param <VH> {@link RecyclerView.ViewHolder}
 * @author Davide Steduto
 * @since 20/01/2016 Created
 * <br>21/04/2017 ViewHolders methods are now abstract
 * <br>08/12/2017 New callback methods when view is attached/detached/recycled
 * <br>22/04/2018 Item is born with draggable and swipeable enabled
 */
@SuppressWarnings("WeakerAccess")
public abstract class AbstractFlexibleItem<VH extends RecyclerView.ViewHolder>
        implements IFlexible<VH> {

    /* Item flags recognized by the FlexibleAdapter */
    protected boolean mEnabled = true, mHidden = false,
            mSelectable = true, mDraggable = true, mSwipeable = true;

    /*---------------*/
    /* BASIC METHODS */
    /*---------------*/

    /**
     * You <b>MUST</b> implement this method to compare items <b>unique</b> identifiers.
     * <p>Adapter needs this method to distinguish them and pick up correct items.</p>
     * See <a href="http://developer.android.com/reference/java/lang/Object.html#equals(java.lang.Object)">
     * Writing a correct {@code equals} method</a> to implement your own {@code equals} method.
     * <p><b>Hint:</b> If you don't use unique IDs, reimplement with Basic Java implementation:
     * <pre>
     * public boolean equals(Object o) {
     *     return this == o;
     * }</pre></p>
     * <p><b>Important Note:</b> When used with {@code Hash[Map,Set]}, the general contract for the
     * {@code equals} and {@link #hashCode()} methods is that if {@code equals} returns {@code true}
     * for any two objects, then {@code hashCode()} must return the same value for these objects.
     * This means that subclasses of {@code Object} usually override either both methods or neither
     * of them.</p>
     *
     * @param o instance to compare
     * @return true if items are equals, false otherwise.
     */
    @Override
    public abstract boolean equals(Object o);

    @Override
    public boolean isEnabled() {
        return mEnabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        mEnabled = enabled;
    }

    @Override
    public boolean isHidden() {
        return mHidden;
    }

    @Override
    public void setHidden(boolean hidden) {
        mHidden = hidden;
    }

    @Override
    public int getSpanSize(int spanCount, int position) {
        return 1;
    }

    @Override
    public boolean shouldNotifyChange(IFlexible newItem) {
        return true;
    }

    /*--------------------*/
    /* SELECTABLE METHODS */
    /*--------------------*/

    @Override
    public boolean isSelectable() {
        return mSelectable;
    }

    @Override
    public void setSelectable(boolean selectable) {
        this.mSelectable = selectable;
    }

    @Override
    public String getBubbleText(int position) {
        return String.valueOf(position + 1);
    }

    /*-------------------*/
    /* TOUCHABLE METHODS */
    /*-------------------*/

    @Override
    public boolean isDraggable() {
        return mDraggable;
    }

    @Override
    public void setDraggable(boolean draggable) {
        mDraggable = draggable;
    }

    @Override
    public boolean isSwipeable() {
        return mSwipeable;
    }

    @Override
    public void setSwipeable(boolean swipeable) {
        mSwipeable = swipeable;
    }

    /*---------------------*/
    /* VIEW HOLDER METHODS */
    /*---------------------*/

    /**
     * {@inheritDoc}
     * <p>If not overridden return value is the same of {@link #getLayoutRes()}.</p>
     */
    @Override
    public int getItemViewType() {
        return getLayoutRes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract int getLayoutRes();

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract VH createViewHolder(View view, FlexibleAdapter<IFlexible> adapter,int viewtyp);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void bindViewHolder(FlexibleAdapter<IFlexible> adapter, VH holder, int position, List<Object> payloads);

    /**
     * {@inheritDoc}
     */
    @Override
    public void unbindViewHolder(FlexibleAdapter<IFlexible> adapter, VH holder, int position) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewAttached(FlexibleAdapter<IFlexible> adapter, VH holder, int position) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewDetached(FlexibleAdapter<IFlexible> adapter, VH holder, int position) {
    }

}