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

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseExpandIconView;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class LinearLayoutParser<T extends LinearLayout> extends ViewTypeParser<T> {


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
    return "LinearLayout";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "ViewGroup";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusLinearLayout(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        if ("horizontal".equals(value)) {
          view.setOrientation(ProteusLinearLayout.HORIZONTAL);
        } else {
          view.setOrientation(ProteusLinearLayout.VERTICAL);
        }

/*final View eer=view;
       final   OverlayLayout    mlayout=new OverlayLayout(view.getContext()) {
              @Override
              protected View createOverlayView() {


                  return eer;
              }
          };
         ;*/
      }
    });
    addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
      @Override
      public void setGravity(T view, @Gravity int gravity) {
        view.setGravity(gravity);
      }
    });

    addAttributeProcessor("ViewEx", new AttributeProcessor<T>() {
              @Override
              public void handleValue(T view, Value value) {
try{
    int indexicon=0;
    Layout re=value.getAsObject().getAsLayout("Expand");
try {
    indexicon = value.getAsObject().getAsInteger("index_icon");
}catch (Exception ex){

}
  ///String val=value.getAsObject().getAsString("ExpandName");
 Layout vald=value.getAsObject().getAsLayout("ExpandIconLayout");
  ProtouseExpandIconView viw=(ProtouseExpandIconView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(re,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
  ProteusLinearLayout viwm=(ProteusLinearLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vald,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();

  viwm.addView(viw,indexicon);
  try {
    //;
   /* if(view.getChildAt(0) instanceof ProteusLinearLayout){
      ProteusLinearLayout t=(ProteusLinearLayout)   view.getChildAt(0);
      t.addView(viw);

    }else{
      view.addView(viw);
    } *///.addView(viw);
  }catch (Exception ex){
    // view.addView(viw);
   // view.addView(viw);
  }
  view.addView(viwm);
  view.addView(viw.GetviewExpand());

  //   view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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

              }
            });
      addAttributeProcessor("exview", new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {


      }
    });

    addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
      @Override
      public void setGravity(T view, @Gravity int gravity) {
        view.setGravity(gravity);
      }
    });
    addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        if(value.equals("1")) {

          view.bringToFront();
          view.invalidate();
        }

      }
    });


    addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
      @SuppressLint("NewApi")
      @Override
      public void setDrawable(T view, Drawable drawable) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
          view.setDividerDrawable(drawable);
        }
      }
    });

    addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
      @SuppressLint("NewApi")
      @Override
      public void setDimension(T view, float dimension) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
          view.setDividerPadding((int) dimension);
        }
      }
    });

    addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
      @SuppressLint("NewApi")
      @Override
      public void setString(T view, String value) {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
          int dividerMode = ParseHelper.parseDividerMode(value);
          // noinspection ResourceType
          view.setShowDividers(dividerMode);
        }
      }
    });

    addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
      @SuppressLint("NewApi")
      @Override
      public void setString(T view, String value) {
        view.setWeightSum(ParseHelper.parseFloat(value));
      }
    });
  }


}
