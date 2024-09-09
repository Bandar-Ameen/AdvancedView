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

package com.astooltech.advancedview.proteus.processor;

import android.view.View;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;

/**
 * NumberAttributeProcessor
 *
 * @author adityasharat
 */

public abstract class NumberAttributeProcessor<V extends View> extends AttributeProcessor<V> {

  @Override
  public void handleValue(V view, Value value) {
    if (value.isPrimitive()) {
      setNumber(view, value.getAsPrimitive().getAsNumber());
    }
  }

  @Override
  public void handleResource(V view, Resource resource) {
    Integer number = resource.getInteger(view.getContext());
    setNumber(view, null != number ? number : 0);
  }

  @Override
  public void handleAttributeResource(V view, AttributeResource attribute) {
    setNumber(view, attribute.apply(view.getContext()).getFloat(0, 0f));
  }

  @Override
  public void handleStyleResource(V view, StyleResource style) {
    setNumber(view, style.apply(view.getContext()).getFloat(0, 0f));
  }

  public abstract void setNumber(V view, @NonNull Number value);
}
