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

package com.astooltech.advancedview.proteus.design.widget;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.NumberAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * CollapsingToolbarLayoutParser
 *
 * @author adityasharat
 */

public class CollapsingToolbarLayoutParser<V extends CollapsingToolbarLayout> extends ViewTypeParser<V> {

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
    return new ProteusRappleLayout(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
    return new TextInputLayoutB(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }
  @NonNull
  @Override
  public String getType() {
    return "CollapsingToolbarLayout";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "FrameLayout";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusCollapsingToolbarLayout(context);
  }

  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor("collapsedTitleGravity", new GravityAttributeProcessor<V>() {
      @Override
      public void setGravity(V view, @Gravity int gravity) {
        view.setCollapsedTitleGravity(gravity);

      }
    });

    addAttributeProcessor("contentScrim", new DrawableResourceProcessor<V>() {
      @Override
      public void setDrawable(V view, Drawable drawable) {
        view.setContentScrim(drawable);
      }
    });

    addAttributeProcessor("expandedTitleGravity", new GravityAttributeProcessor<V>() {
      @Override
      public void setGravity(V view, @Gravity int gravity) {
        view.setExpandedTitleGravity(gravity);
      }
    });

    addAttributeProcessor("expandedTitleMargin", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setExpandedTitleMargin((int) dimension, (int) dimension, (int) dimension, (int) dimension);
      }
    });

    addAttributeProcessor("expandedTitleMarginBottom", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setExpandedTitleMarginBottom((int) dimension);
      }
    });

    addAttributeProcessor("expandedTitleMarginEnd", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setExpandedTitleMarginEnd((int) dimension);
      }
    });

    addAttributeProcessor("expandedTitleMarginStart", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setExpandedTitleMarginStart((int) dimension);
      }
    });

    addAttributeProcessor("expandedTitleMarginTop", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setExpandedTitleMarginTop((int) dimension);
      }
    });

    addAttributeProcessor("scrimAnimationDuration", new NumberAttributeProcessor<V>() {
      @Override
      public void setNumber(V view, @NonNull Number value) {
        view.setScrimAnimationDuration(value.longValue());
      }
    });


    addAttributeProcessor("scrimVisibleHeightTrigger", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setScrimVisibleHeightTrigger((int) dimension);
      }
    });

    addAttributeProcessor("statusBarScrim", new DrawableResourceProcessor<V>() {
      @Override
      public void setDrawable(V view, Drawable drawable) {
        view.setStatusBarScrim(drawable);

      }
    });

    addAttributeProcessor("title", new StringAttributeProcessor<V>() {
      @Override
      public void setString(V view, String value) {
        view.setTitle(value);
      }
    });

    addAttributeProcessor("titleEnabled", new BooleanAttributeProcessor<V>() {
      @Override
      public void setBoolean(V view, boolean value) {
        view.setTitleEnabled(value);
      }
    });
  }
}
