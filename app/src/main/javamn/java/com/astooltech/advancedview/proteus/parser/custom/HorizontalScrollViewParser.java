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

package com.astooltech.advancedview.proteus.parser.custom;

import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusHorizontalScrollView;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * @author kiran.kumar
 * @author adityasharat
 */
public class HorizontalScrollViewParser<T extends HorizontalScrollView> extends ViewTypeParser<T> {
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable MaterialRippleLayout  parent, int dataIndex) {
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
  public String getType() {
    return "HorizontalScrollView";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "FrameLayout";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusHorizontalScrollView(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  protected void addAttributeProcessors() {
    addAttributeProcessor("Setting", new AttributeProcessor<T>() {
      @Override
      public void handleValue(T view, Value value) {
        try {
          int mode = value.getAsObject().getAsInteger("ScrollModes");

          if (mode == 1) {
            view.setOverScrollMode(HorizontalScrollView.OVER_SCROLL_NEVER);
          }
          if (mode == 2) {
            view.setOverScrollMode(HorizontalScrollView.OVER_SCROLL_ALWAYS);
          }
          if (mode == 3) {
            view.setOverScrollMode(HorizontalScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);
          }
        }catch (Exception ex){

        }
      }

      @Override
      public void handleResource(T view, Resource resource) {

      }

      @Override
      public void handleAttributeResource(T view, AttributeResource attribute) {

      }

      @Override
      public void handleStyleResource(T view, StyleResource style) {

      }});
    addAttributeProcessor(Attributes.HorizontalScrollView.FillViewPort, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setFillViewport(value);
      }
    });
    addAttributeProcessor(Attributes.ScrollView.Scrollbars, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        if ("none".equals(value)) {
          view.setHorizontalScrollBarEnabled(false);
          view.setVerticalScrollBarEnabled(false);
        } else if ("horizontal".equals(value)) {
          view.setHorizontalScrollBarEnabled(true);
          view.setVerticalScrollBarEnabled(false);
        } else if ("vertical".equals(value)) {
          view.setHorizontalScrollBarEnabled(false);
          view.setVerticalScrollBarEnabled(true);
        } else {
          view.setHorizontalScrollBarEnabled(false);
          view.setVerticalScrollBarEnabled(false);
        }
      }
    });
  }
}