/*
 * Copyright 2017 Davide Steduto & Arpinca
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
package com.astooltech.advancedview.proteus.anotherView.fastscroller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class ScrollbarAnimator {

    private static final String TRANSLATION_X = "translationX";

    protected View bar, handle;
    protected AnimatorSet scrollbarAnimatorSet;
    protected long delayInMillis, durationInMillis;
    protected boolean handleAlwaysVisible;

    private boolean isAnimating;

    public ScrollbarAnimator(View bar, View handle, boolean handleAlwaysVisible, long delayInMillis, long durationInMillis) {
        this.bar = bar;
        this.handle = handle;
        this.handleAlwaysVisible = handleAlwaysVisible;
        this.delayInMillis = delayInMillis;
        this.durationInMillis = durationInMillis;
    }

    public void setDelayInMillis(long delayInMillis) {
        this.delayInMillis = delayInMillis;
    }

    public boolean isAnimating() {
        return isAnimating;
    }

    public void showScrollbar() {
        if (bar == null || handle == null) {
            return;
        }

        if (isAnimating) {
            scrollbarAnimatorSet.cancel();
        }

        if (bar.getVisibility() == View.INVISIBLE || handle.getVisibility() == View.INVISIBLE) {
            bar.setVisibility(View.VISIBLE);
            handle.setVisibility(View.VISIBLE);

            scrollbarAnimatorSet = createAnimator(bar, handle, true);
            scrollbarAnimatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    onShowAnimationStop(bar, handle);
                    isAnimating = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    super.onAnimationCancel(animation);
                    onShowAnimationStop(bar, handle);
                    isAnimating = false;
                }
            });
            scrollbarAnimatorSet.start();
            isAnimating = true;
        }
    }

    public void hideScrollbar() {
        if (bar == null || handle == null) {
            return;
        }

        if (isAnimating) {
            scrollbarAnimatorSet.cancel();
        }

        scrollbarAnimatorSet = createAnimator(bar, handle, false);
        scrollbarAnimatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                onHideAnimationStop(bar, handle);
                isAnimating = false;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                onHideAnimationStop(bar, handle);
                isAnimating = false;
            }
        });
        scrollbarAnimatorSet.start();
        isAnimating = true;
    }

    protected AnimatorSet createAnimator(View bar, View handle, boolean showFlag) {
        ObjectAnimator barAnimator = ObjectAnimator.ofFloat(bar, TRANSLATION_X, showFlag ? 0 : bar.getWidth());
        AnimatorSet animator = new AnimatorSet();
        if (handleAlwaysVisible) {
            animator.play(barAnimator);
        } else {
            ObjectAnimator handleAnimator = ObjectAnimator.ofFloat(handle, TRANSLATION_X, showFlag ? 0 : handle.getWidth());
            animator.playTogether(barAnimator, handleAnimator);
        }
        animator.setDuration(durationInMillis);
        if (!showFlag) {
            animator.setStartDelay(delayInMillis);
        }
        return animator;
    }

    protected void onShowAnimationStop(View bar, View handle) {
        // do something
    }

    protected void onHideAnimationStop(View bar, View handle) {
        bar.setVisibility(View.INVISIBLE);
        if (!handleAlwaysVisible) {
            handle.setVisibility(View.INVISIBLE);
        }
        bar.setTranslationX(0);
        handle.setTranslationX(0);
    }

}