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


import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusProgressBar;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.spinkit.sprite.Sprite;
import com.astooltech.advancedview.spinkit.style.ChasingDots;
import com.astooltech.advancedview.spinkit.style.CubeGrid;
import com.astooltech.advancedview.spinkit.style.Wave;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Aditya Sharat
 */
public class ProgressBarParser<T extends ProgressBar> extends ViewTypeParser<T> {

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
    return "ProgressBar";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "View";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusProgressBar(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);

    if(view instanceof ProteusProgressBar){
      prograssbarr((ProteusProgressBar)view,data,typoper);
    }
  }


  private Value getvaluefromdat(String keyna, ObjectValue erx){
    Value val=null;
    Iterator<Map.Entry<String, Value>> uuo = erx.getAsObject().entrySet().iterator();
    while (uuo.hasNext()) {
      Map.Entry<String, Value> qqe = uuo.next();
      try {
        if (qqe.getKey().toLowerCase().equals(keyna.toLowerCase())) {
          val=qqe.getValue();
        }
      }catch (Exception ex){

      }
    }
    return val;
  }

  private void getwithanotheroper(ProteusProgressBar dt, DataValueSelect datb, int typoper){
    ProteusProgressBar ccc=dt;
    if (typoper == 2) {

      assert ccc != null;
      String IDDdat = dt.getTag(R.id.tag3).toString();
      if (IDDdat.equals(datb.getIDUnit())) {
        if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

          try {
            ObjectValue val = datb.getAnotherDatat();



            val.add("GetData", new Primitive(ccc.isShown()));
            val.add("ViewId", new Primitive(IDDdat));
            val.add("index_id", new Primitive(datb.getIdexid()));
            val.add("Type", new Primitive(datb.getTypselect()));
          }catch(Exception ex){
            Log.e("hhhhhhxxxiiop",ex.getMessage());
          }



        } else if (datb.getTypselect().equals("1") ||datb.getTypselect().toLowerCase().equals("getvisibility")) {
          try {
            ObjectValue val = datb.getAnotherDatat();
            val.add("GetData", new Primitive(dt.getVisibility()));
            val.add("ViewId", new Primitive(IDDdat));
            val.add("index_id", new Primitive(datb.getIdexid()));
            val.add("Type", new Primitive(datb.getTypselect()));
          }catch(Exception ex){
            Log.e("hhhhhhxxx",ex.getMessage());
          }


        } else {


          try {
            ObjectValue val = datb.getAnotherDatat();
            val.add("GetData", new Primitive(dt.isEnabled()));
            val.add("ViewId", new Primitive(IDDdat));
            val.add("index_id", new Primitive(datb.getIdexid()));
            val.add("Type", new Primitive(datb.getTypselect()));
          }catch(Exception ex){
            Log.e("hhhhhhxxx",ex.getMessage());
          }
        }

      }


    }else   if (typoper == 3) {

      assert ccc != null;
      String IDDdat = dt.getTag(R.id.tag3).toString();
      Value typ=  getvaluefromdat("Type",datb.getAnotherDatat());

      if (IDDdat.equals(datb.getIDUnit())) {
        if (typ.getAsString().equals("0")) {

          try {
            Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());


            //  dt.setText(va.getAsString());
          }catch(Exception ex){
            Log.e("hhhhhhxxxiiophhh",ex.getMessage());
          }



        }
        else   if(datb.getTypselect().equals("5")) {
          Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
          String s=  va.getAsString();



        }

        else if (typ.getAsString().equals("1")) {
          try {

            Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
            String s=  va.getAsString();
            if(s.startsWith("true")){
              dt.setVisibility(View.VISIBLE);
            }
            else if(s.startsWith("1")){
              dt.setVisibility(View.VISIBLE);
            }else{
              dt.setVisibility(View.GONE);
            }
          }catch(Exception ex){
            Log.e("hhhhhhxxx",ex.getMessage());
          }


        }

        else if (typ.getAsString().equals("2")) {
          try {

            Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
            String s=  va.getAsString();
            if(s.toLowerCase().equals("true")){
              dt.setEnabled(true);
            }
            else if(s.equals("1")){
              dt.setEnabled(true);
            }else{
              dt.setEnabled(false);
            }
          }catch(Exception ex){
            Log.e("hhhhhhxxx",ex.getMessage());
          }


        }


      }


    }
  }


  private  void prograssbarr(ProteusProgressBar dt,DataValueSelect datb,int ty ){

    if (ty == 1) {
    String IDDdat = dt.getTag(R.id.tag3).toString();
    if (IDDdat.equals(datb.getIDUnit())) {
      {


        //  dat.get(cxx).setDataGet();
        if (datb.getTypselect().equals("1")) {
          dt.setVisibility(View.VISIBLE);
        } else if (datb.getTypselect().equals("2")) {
          dt.setVisibility(View.GONE);
        }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

      }
    }
    }else{

      getwithanotheroper(dt,datb,ty);
    }


    ;
    //  String IDDdat = zxb.getTag(R.id.tag3).toString();
                   /* if(IDDdat.equals(nameprograss)){

                        if(visabl.equals("1")) {
                            //  Log.i("ProteusEventWithTag", "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+visabl);

                            zxb.setVisibility(View.VISIBLE);
                        }else {
*/

    //  }}



  }


  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor(Attributes.ProgressBar.Max, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setMax((int) ParseHelper.parseDouble(value));
      }
    });
    addAttributeProcessor(Attributes.ProgressBar.Progress, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setProgress((int) ParseHelper.parseDouble(value));

      }
    });
;

    addAttributeProcessor(Attributes.ProgressBar.typBar, new AttributeProcessor<T>() {

      @Override
      public void handleValue(T view, Value value) {
        if (value.isObject()) {
          String type = value.getAsObject().getAsString(Attributes.ProgressBar.typBarA);
          String colorbar = value.getAsObject().getAsString(Attributes.ProgressBar.colorbar);
          if (type != null) {

           // Wave dg=new Wave();
            int   background = ParseHelper.parseColor(colorbar);
            Sprite g= (type.equals("1")? new Wave():(type.equals("2")?new ChasingDots():new CubeGrid()));
            g.setColor(background);

            view.setIndeterminateDrawable(g);

          }
        }
      }

      @Override
      public void handleResource(T view, Resource resource) {
        throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
      }

      @Override
      public void handleAttributeResource(T view, AttributeResource attribute) {
        throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
      }

      @Override
      public void handleStyleResource(T view, StyleResource style) {
        throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
      }
    });


    addAttributeProcessor(Attributes.ProgressBar.ProgressTint, new AttributeProcessor<T>() {
      @Override
      public void handleValue(T view, Value value) {
        if (!value.isObject()) {
          return;
        }
        int background = Color.TRANSPARENT;
        int progress = Color.TRANSPARENT;
        ObjectValue object = value.getAsObject();
        String string = object.getAsString("background");
        if (string != null) {
          background = ParseHelper.parseColor(string);
        }
        string = object.getAsString("progress");
        if (string != null) {
          progress = ParseHelper.parseColor(string);
        }

        view.setProgressDrawable(getLayerDrawable(progress, background));
      }

      @Override
      public void handleResource(T view, Resource resource) {
        Drawable d = resource.getDrawable(view.getContext());
        view.setProgressDrawable(d);
      }

      @Override
      public void handleAttributeResource(T view, AttributeResource attribute) {
        TypedArray a = attribute.apply(view.getContext());
        view.setProgressDrawable(a.getDrawable(0));
      }

      @Override
      public void handleStyleResource(T view, StyleResource style) {
        TypedArray a = style.apply(view.getContext());
        view.setProgressDrawable(a.getDrawable(0));
      }
    });

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      addAttributeProcessor(Attributes.ProgressBar.SecondaryProgressTint, new ColorResourceProcessor<T>() {
        @Override
        public void setColor(T view, int color) {

        }

        @Override
        public void setColor(T view, ColorStateList colors) {
          //noinspection AndroidLintNewApi
          view.setSecondaryProgressTintList(colors);
        }
      });
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      addAttributeProcessor(Attributes.ProgressBar.IndeterminateTint, new ColorResourceProcessor<T>() {
        @Override
        public void setColor(T view, int color) {

        }

        @Override
        public void setColor(T view, ColorStateList colors) {
          //noinspection AndroidLintNewApi
          view.setIndeterminateTintList(colors);
        }
      });
    }
  }

  Drawable getLayerDrawable(int progress, int background) {
    ShapeDrawable shape = new ShapeDrawable();
    shape.getPaint().setStyle(Paint.Style.FILL);
    shape.getPaint().setColor(background);

    ShapeDrawable shapeD = new ShapeDrawable();
    shapeD.getPaint().setStyle(Paint.Style.FILL);
    shapeD.getPaint().setColor(progress);
    ClipDrawable clipDrawable = new ClipDrawable(shapeD, Gravity.LEFT, ClipDrawable.HORIZONTAL);

    return new LayerDrawable(new Drawable[]{shape, clipDrawable});
  }
}
