/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.view.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by kiran.kumar on 13/05/14.
 */
public class AspectRatioFrameLayout extends FrameLayout {

  private int mAspectRatioWidth;
  private int mAspectRatioHeight;

  public AspectRatioFrameLayout(Context context) {
    super(context);
  }

  public AspectRatioFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public AspectRatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if (mAspectRatioHeight > 0 && mAspectRatioWidth > 0) {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);

      int originalWidth = getMeasuredWidth();

      int originalHeight = getMeasuredHeight();

      int finalWidth, finalHeight;

      if (originalHeight == 0) {
        finalHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth;
        finalWidth = originalWidth;
      } else if (originalWidth == 0) {
        finalWidth = originalHeight * mAspectRatioWidth / mAspectRatioHeight;
        finalHeight = originalHeight;
      } else {
        finalHeight = originalHeight;
        finalWidth = originalWidth;
      }


      super.onMeasure(
        MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY),
        MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY));
    } else {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  }

  public void setAspectRatioWidth(int mAspectRatioWidth) {
    this.mAspectRatioWidth = mAspectRatioWidth;
  }

  public void setAspectRatioHeight(int mAspectRatioHeight) {
    this.mAspectRatioHeight = mAspectRatioHeight;
  }
}
