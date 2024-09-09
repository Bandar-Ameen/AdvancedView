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

public class FadeInDownItemAnimator extends FlexibleItemAnimator {

    public FadeInDownItemAnimator() {
    }

    public FadeInDownItemAnimator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    @Override
    protected void animateRemoveImpl(final RecyclerView.ViewHolder holder, final int index) {
        ViewCompat.animate(holder.itemView)
                  .translationY(-holder.itemView.getHeight() * .25f)
                  .alpha(0)
                  .setDuration(getRemoveDuration())
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultRemoveVpaListener(holder))
                  .start();
    }

    @Override
    protected boolean preAnimateAddImpl(final RecyclerView.ViewHolder holder) {
        holder.itemView.setTranslationY(-holder.itemView.getHeight() * .25f);
        holder.itemView.setAlpha(0);
        return true;
    }

    @Override
    protected void animateAddImpl(final RecyclerView.ViewHolder holder, final int index) {
        ViewCompat.animate(holder.itemView)
                  .translationY(0)
                  .alpha(1)
                  .setDuration(getAddDuration())
                  .setInterpolator(mInterpolator)
                  .setListener(new DefaultAddVpaListener(holder))
                  .start();
    }

}