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

import android.content.Context;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.appbar.AppBarLayout;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * AppBarLayoutParser
 *
 * @author adityasharat
 */

public class AppBarLayoutParser<V extends AppBarLayout> extends ViewTypeParser<V> {
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
    return new ProteusRappleLayout(context);
  }
  @NonNull
  @Override
  public String getType() {
    return "AppBarLayout";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "LinearLayout";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusAppBarLayout(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
    return new TextInputLayoutB(context);
  }
  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor("targetElevation", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        //noinspection deprecation
        view.setTargetElevation(dimension);
      }
    });

    addAttributeProcessor("orientation", new AttributeProcessor<V>() {

      private final Primitive VERTICAL = new Primitive(AppBarLayout.VERTICAL);
      private final Primitive HORIZONTAL = new Primitive(AppBarLayout.HORIZONTAL);

      @Override
      public void handleValue(V view, Value value) {
        //noinspection WrongConstant


        view.setOrientation(value.getAsInt());
      }

      @Override
      public void handleResource(V view, Resource resource) {
        Integer orientation = resource.getInteger(view.getContext());
        if (orientation != null) {
          //noinspection WrongConstant
          view.setOrientation(orientation);
        }
      }

      @Override
      public void handleAttributeResource(V view, AttributeResource attribute) {
        TypedArray a = attribute.apply(view.getContext());
        int orientation = a.getInt(0, AppBarLayout.VERTICAL);
        //noinspection WrongConstant
        view.setOrientation(orientation);
      }

      @Override
      public void handleStyleResource(V view, StyleResource style) {
        TypedArray a = style.apply(view.getContext());
        int orientation = a.getInt(0, AppBarLayout.VERTICAL);
        //noinspection WrongConstant
        view.setOrientation(orientation);
      }

      @Override
      public Value compile(@Nullable Value value, Context context) {
        if (null != value && value.isPrimitive()) {
          String string = value.getAsString();
          if ("vertical".equals(string)) {
            return VERTICAL;
          } else {
            return HORIZONTAL;
          }
        } else {
          return VERTICAL;
        }
      }
    });

    addAttributeProcessor("expanded", new BooleanAttributeProcessor<V>() {
      @Override
      public void setBoolean(V view, boolean value) {
        view.setExpanded(value);
      }
    });

  }
}
