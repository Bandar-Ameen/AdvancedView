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

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusAspectRatioFrameLayout;
import com.astooltech.advancedview.proteus.view.ProteusProgressBar;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.AspectRatioFrameLayout;

import java.util.Iterator;
import java.util.Map;


/**
 * Created by kiran.kumar on 12/05/14.
 */
public class FrameLayoutParser<T extends AspectRatioFrameLayout> extends ViewTypeParser<T> {

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
    return "FrameLayout";
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
    return new ProteusAspectRatioFrameLayout(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);

    if(view instanceof AspectRatioFrameLayout){
      prograssbarr((AspectRatioFrameLayout)view,data,typoper);
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

  private void getwithanotheroper(AspectRatioFrameLayout dt, DataValueSelect datb, int typoper){
    AspectRatioFrameLayout ccc=dt;
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

  private  void prograssbarr(AspectRatioFrameLayout dt,DataValueSelect datb,int ty ){

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
    addAttributeProcessor("load", new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
      //  view.setAspectRatioHeight(ParseHelper.parseInt(value));
       /* DynamicBox  box=new DynamicBox(((ProteusAspectRatioFrameLayout)view).getViewManager().getContext().getActvityAllt(),view);
        box.setLoadingMessage("now Loading....");
        box.setInternetOffMessage("no Enternet Connection");
        box.setOtherExceptionMessage("noooo other");
        box.setClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

          }
        });
        box.showLoadingLayout();*/
      }
    });

    addAttributeProcessor(Attributes.FrameLayout.HeightRatio, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setAspectRatioHeight(ParseHelper.parseInt(value));

      }
    });


    addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
     if(value.equals("1")) {

       view.bringChildToFront(view);
               //.bringToFront();
       view.invalidate();
     }

      }
    });
    addAttributeProcessor(Attributes.FrameLayout.WidthRatio, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setAspectRatioWidth(ParseHelper.parseInt(value));

      }
    });
  }
}
