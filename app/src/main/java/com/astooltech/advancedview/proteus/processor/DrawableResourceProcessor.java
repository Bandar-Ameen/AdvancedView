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

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.DrawableValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;

/**
 * Use this as the base processor for references like @drawable or remote resources with http:// urls.
 */
public abstract class DrawableResourceProcessor<V extends View> extends AttributeProcessor<V> {

  @Nullable
  public static Drawable evaluate(Value value, ProteusView view) {
    if (null == value) {
      return null;
    }
    final Drawable[] d = new Drawable[1];
    DrawableResourceProcessor<View> processor = new DrawableResourceProcessor<View>() {
      @Override
      public void setDrawable(View view, Drawable drawable) {
        d[0] = drawable;
      }
    };
    processor.process(view.getAsView(), value);
    return d[0];
  }

  public static Value staticCompile(@Nullable Value value, Context context) {
    if (null == value) {
      return DrawableValue.ColorValue.BLACK;
    }
    if (value.isDrawable()) {
      return value;
    }

    else if (value.isPrimitive()) {
      Value precompiled = AttributeProcessor.staticPreCompile(value.getAsPrimitive(), context, null);
      if (null != precompiled) {
        return precompiled;
      }
      return DrawableValue.valueOf(value.getAsString(), context);
    } else if (value.isObject()) {
      return DrawableValue.valueOf(value.getAsObject(), context);
    } else {
      return DrawableValue.ColorValue.BLACK;
    }
  }

  @Override
  public void handleValue(final V view, Value value)  {
    if (value.isDrawable()) {
      DrawableValue d = value.getAsDrawable();
      if (null != d) {
        ProteusLayoutInflater.ImageLoader loader = ((ProteusView) view).getViewManager().getContext().getLoader();
        d.apply((ProteusView) view, view.getContext(), loader, new DrawableValue.Callback() {
          @Override
          public void apply(Drawable drawable) {
            if (null != drawable) {
              setDrawable(view, drawable);
            }
          }
        });
      }
    } else {
      process(view, precompile(value, view.getContext(), ((ProteusContext) view.getContext()).getFunctionManager()));
    }
  }

  @Override
  public void handleResource(V view, Resource resource) {


   // resource.isdroblefont
    Drawable d = resource.getDrawable(view.getContext());
    if (null != d) {
      setDrawable(view, d);
    }
  }

  @Override
  public void handleAttributeResource(V view, AttributeResource attribute) {
   TypedArray a = attribute.apply(view.getContext());
    set(view, a);
  }

  @Override
  public void handleStyleResource(V view, StyleResource style) {
    TypedArray a = style.apply(view.getContext());
    set(view, a);
  }

  private void set(V view, TypedArray a) {
    Drawable d = a.getDrawable(0);
    if (null != d) {
      setDrawable(view, d);
    }
  }

  public abstract void setDrawable(V view, Drawable drawable);

  @Override
  public Value compile(@Nullable Value value, Context context) {
    return staticCompile(value, context);
  }
}
