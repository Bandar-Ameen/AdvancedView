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
import android.content.res.ColorStateList;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.NumberAttributeProcessor;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * FloatingActionButtonParser
 *
 * @author adityasharat
 */

public class FloatingActionButtonParser<V extends FloatingActionButton> extends ViewTypeParser<V> {
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
    return "FloatingActionButton";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "ImageButton";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusFloatingActionButton(context);
  }

  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor("elevation", new DimensionAttributeProcessor<V>() {
      @Override
      public void setDimension(V view, float dimension) {
        view.setCompatElevation(dimension);
      }
    });

    addAttributeProcessor("fabSize", new NumberAttributeProcessor<V>() {

      private final Primitive AUTO = new Primitive(FloatingActionButton.SIZE_AUTO);
      private final Primitive MINI = new Primitive(FloatingActionButton.SIZE_MINI);
      private final Primitive NORMAL = new Primitive(FloatingActionButton.SIZE_NORMAL);

      @Override
      public void setNumber(V view, @NonNull Number value) {
        //noinspection WrongConstant
        view.setSize(value.intValue());
      }

      @Override
      public Value compile(@Nullable Value value, Context context) {
        if (value != null) {
          String string = value.getAsString();
          switch (string) {
            case "auto":
              return AUTO;
            case "mini":
              return MINI;
            case "normal":
              return NORMAL;
            default:
              return AUTO;
          }
        } else {
          return AUTO;
        }
      }
    });

    addAttributeProcessor("rippleColor", new ColorResourceProcessor<V>() {
      @Override
      public void setColor(V view, int color) {
        view.setRippleColor(color);
      }

      @Override
      public void setColor(V view, ColorStateList colors) {
        throw new IllegalArgumentException("rippleColor must be a color int");
      }
    });

    addAttributeProcessor("useCompatPadding", new BooleanAttributeProcessor<V>() {
      @Override
      public void setBoolean(V view, boolean value) {
        view.setUseCompatPadding(value);
      }
    });

  }
}
