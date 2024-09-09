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

import android.content.res.ColorStateList;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

/**
 * BottomNavigationViewParser
 *
 * @author adityasharat
 */

public class BottomNavigationViewParser<V extends  BottomNavigationView> extends ViewTypeParser<V> {

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
  public String getType() {
    return "BottomNavigationView";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "FrameLayout";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusBottomNavigationView(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  protected void addAttributeProcessors() {


    addAttributeProcessor("itemBackground", new AttributeProcessor<V>() {
      @Override
      public void handleValue(V view, Value value) {
        throw new IllegalArgumentException("itemBackground must be a drawable resource id");
      }

      @Override
      public void handleResource(V view, Resource resource) {
        view.setItemBackgroundResource(resource.resId);
      }

      @Override
      public void handleAttributeResource(V view, AttributeResource attribute) {
        throw new IllegalArgumentException("itemBackground must be a drawable resource id");
      }

      @Override
      public void handleStyleResource(V view, StyleResource style) {
        throw new IllegalArgumentException("itemBackground must be a drawable resource id");
      }
    });

    addAttributeProcessor("itemIconTint", new ColorResourceProcessor<V>() {
      @Override
      public void setColor(V view, int color) {
        throw new IllegalArgumentException("itemIconTint must be a color state list");
      }

      @Override
      public void setColor(V view, ColorStateList colors) {
        view.setItemIconTintList(colors);
      }
    });

    addAttributeProcessor("itemTextColor", new ColorResourceProcessor<V>() {
      @Override
      public void setColor(V view, int color) {

      /*  view.getContext().setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);
       // view.setPopupTheme(R.style.AppTheme_PopupOverlay);
        //  ((AppCompatActivity)view.getContext()).getSupportActionBar();
        view.inflateMenu(R.menu.bottom_nav_menu);
        //view view.getMenu().clear();
//MenuItem hhh=view.getMenu();// MenuItem();
        // view.getMenu()
        view.getMenu().add("kkkkkmnnnnnnnn").setIcon(R.drawable.addbtn);*/
        throw new IllegalArgumentException("itemIconTint must be a color state list");
      }

      @Override
      public void setColor(V view, ColorStateList colors) {
        view.setItemTextColor(colors);
      }
    });

    addAttributeProcessor("menu", new AttributeProcessor<V>() {
      @Override
      public void handleValue(V view, Value value) {
        view.inflateMenu(R.menu.bottom_nav_menu);


        Gson ooi=new Gson();
        Log.i("6677",ooi.toJson(value));
/*
        //  throw new IllegalArgumentException("menu must be a R.menu.<sid>");
Array ccx= value.getAsObject().get("item").getAsArray();//.getAsObject();

for(int i=0;i<ccx.size();i++){


  view.getMenu().add(ccx.get(i).getAsObject().get("itText").getAsString()).setIcon(R.drawable.addbtn);//.getDrawable(view.getContext()));
}


*/
        view.getContext().setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);


       // view.setPopupTheme(R.style.AppTheme_PopupOverlay);
        //  ((AppCompatActivity)view.getContext()).getSupportActionBar();



        view.getMenu().clear();
        //view view.getMenu().clear();
//MenuItem hhh=view.getMenu();// MenuItem();
        // view.getMenu()


      //  view.inflateMenu(R.menu.activity_entry_drawer);
      }

      @Override
      public void handleResource(V view, Resource resource) {

        view.inflateMenu(R.menu.activity_entry_drawer);
       /* PopupMenu pp=new PopupMenu(view.getContext(),view);
       // pp.getMenu().add("bb",0,"hh")

        Integer id = resource.getInteger(view.getContext());
        if (null != id) {
          view.inflateMenu(id);
        }*/
      }

      @Override
      public void handleAttributeResource(V view, AttributeResource attribute) {


      //  ProteusBottomNavigationView ff=(ProteusBottomNavigationView)view;

      //  Menu kkj= findViewById(R.menu.activity_entry_drawer);
        /*   TypedArray a = attribute.apply(view.getContext());
        int id = a.getResourceId(0, 0);*/
        view.inflateMenu(R.menu.activity_entry_drawer);
      }

      @Override
      public void handleStyleResource(V view, StyleResource style) {
      /*  TypedArray a = style.apply(view.getContext());
        int id = a.getResourceId(0, 0);
        view.inflateMenu(id);*/
      }
    });
  }
}
