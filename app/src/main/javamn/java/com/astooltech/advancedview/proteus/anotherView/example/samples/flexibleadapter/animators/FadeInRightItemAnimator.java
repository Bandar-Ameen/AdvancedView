/*
 * Copyright (C) 2015 Wasabeef
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
package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.animators;

import android.view.animation.Interpolator;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.common.FlexibleItemAnimator;

public class FadeInRightItemAnimator extends FlexibleItemAnimator {

    public FadeInRightItemAnimator() {
    }

    public FadeInRightItemAnimator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    @Override
    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder, final int index) {
        ViewCompat.animate(holder.itemView)
                  .translationX(holder.itemView.getRootView().getWidth() * .25f)
                  .alpha(0)
                  .setDuration(getRemoveDuration())
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultRemoveVpaListener(holder))
                  .start();
    }

    @Override
    protected boolean preAnimateAddImpl(final RecyclerView.ViewHolder holder) {
        holder.itemView.setTranslationX(holder.itemView.getRootView().getWidth() * .25f);
        holder.itemView.setAlpha(0);
        return true;
    }

    @Override
    protected void animateAddImpl(final RecyclerView.ViewHolder holder, final int index) {
        ViewCompat.animate(holder.itemView)
                  .translationX(0)
                  .alpha(1)
                  .setDuration(getAddDuration())
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultAddVpaListener(holder))
                  .start();
    }

}