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

package com.astooltech.advancedview.proteus.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

/**
 * ViewGroupManager
 *
 * @author adityasharat
 */

public class ViewGroupManager extends ViewManager {

  public boolean hasDataBoundChildren;

  public ViewGroupManager(@NonNull ProteusContext context, @NonNull ViewTypeParser parser,
                          @NonNull View view, @NonNull Layout layout, @NonNull DataContext dataContext) {
    super(context, parser, view, layout, dataContext);
    hasDataBoundChildren = false;
  }

  @Override
  public void update(@Nullable ObjectValue data) {
    super.update(data);
    updateChildren();
  }

  protected void updateChildren() {
 /*   try{

      Statuselayout().showLoading();
    }catch (Exception ex){

    }*/
    if (!hasDataBoundChildren && view instanceof ViewGroup) {
      ViewGroup parent = (ViewGroup) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }
   /* if (!hasDataBoundChildren && view instanceof LinearLayout) {
      LinearLayout parent = (LinearLayout) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }*/
    if (!hasDataBoundChildren && view instanceof RadioGroup) {
      RadioGroup parent = (RadioGroup) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }

    if (!hasDataBoundChildren && view instanceof com.google.android.material.textfield.TextInputLayout) {
      com.google.android.material.textfield.TextInputLayout parent = (com.google.android.material.textfield.TextInputLayout) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }
    if (!hasDataBoundChildren && view instanceof SwipeRefreshLayout) {
      SwipeRefreshLayout parent = (SwipeRefreshLayout) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }
    if (!hasDataBoundChildren && view instanceof com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout) {
      com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout parent = (com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout) view;
      int count = parent.getChildCount();
      View child;

      for (int index = 0; index < count; index++) {
        child = parent.getChildAt(index);
        if (child instanceof ProteusView) {
          ((ProteusView) child).getViewManager().update(dataContext.getData());
        }
      }
    }
  }
}
