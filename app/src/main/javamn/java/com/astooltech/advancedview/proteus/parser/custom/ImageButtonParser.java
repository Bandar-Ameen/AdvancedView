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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusImageButton;
import com.astooltech.advancedview.proteus.view.ProteusImageView;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kirankumar on 25/11/14.
 */
public class ImageButtonParser<T extends ImageButton> extends ViewTypeParser<T> {
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
    return "ImageButton";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "ImageView";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusImageButton(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }
  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);
    if(view instanceof ProteusImageButton){
      SetImage((ProteusImageButton )view,data,typoper);
    }
  }

  private static Drawable convertBitmapToDrawable(Bitmap original, Context context) {

    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
    int width = original.getWidth();
    int height = original.getHeight();

    float scaleWidth = displayMetrics.scaledDensity;
    float scaleHeight = displayMetrics.scaledDensity;
    Matrix matrix = new Matrix();
    matrix.postScale(scaleWidth, scaleHeight);

    Bitmap resizedBitmap = Bitmap.createBitmap(original, 0, 0, width, height, matrix, true);

    return new BitmapDrawable(context.getResources(), resizedBitmap);
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

  private  void getwithanotheroper(ProteusImageButton dt, DataValueSelect datb, int typoper){
    ProteusImageButton  ccc = dt;
    if (typoper == 2) {

      assert ccc != null;
      String IDDdat = dt.getTag(R.id.tag3).toString();
      if (IDDdat.equals(datb.getIDUnit())) {
        if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

          try {
            ObjectValue val = datb.getAnotherDatat();
            ByteArrayOutputStream ary = new ByteArrayOutputStream();

            BitmapDrawable b = (BitmapDrawable) dt.getBackground();
            Bitmap bb = b.getBitmap();
            bb.compress(Bitmap.CompressFormat.JPEG, 100, ary);

            String res = Base64.encodeToString(ary.toByteArray(), Base64.DEFAULT);



            val.add("GetData", new Primitive(res));//.getText().toString()));
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

            try {

              byte[] bbb=Base64.decode(va.getAsString(),0);
              //   ByteArrayOutputStream ary = new ByteArrayOutputStream();
              Drawable dk=   convertBitmapToDrawable(BitmapFactory.decodeByteArray(bbb,0,bbb.length),dt.getContext());
              dt.setBackground(dk);
            }catch (Exception ex){

            }



          }catch(Exception ex){
            Log.e("hhhhhhxxxiiophhh",ex.getMessage());
          }



        } else if (typ.getAsString().equals("1")) {
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

  private  void SetImage(ProteusImageButton  dt,DataValueSelect datb,int typoper) {
    if (typoper == 1) {
      boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
      if (typActionname) {


        String IDDdat = dt.getTag(R.id.tag3).toString();
        if (IDDdat.equals(datb.getIDUnit())) {
          {
            //  dat.get(cxx).setDataGet();
            if(datb.getTypselect().equals("0")) {

              try {
                ByteArrayOutputStream ary = new ByteArrayOutputStream();

                BitmapDrawable b = (BitmapDrawable) dt.getBackground();
                Bitmap bb = b.getBitmap();
                bb.compress(Bitmap.CompressFormat.JPEG, 100, ary);

                String res = Base64.encodeToString(ary.toByteArray(), Base64.DEFAULT);

                datb.setDataGet(res);
              }catch (Exception ex){

              }

            }else   if(datb.getTypselect().equals("1")) {
              dt.setVisibility(View.VISIBLE);
            }
            else   if(datb.getTypselect().equals("2")) {
              dt.setVisibility(View.GONE);
            }
            else   if(datb.getTypselect().equals("3")) {
              dt.setEnabled(false);
            }

            else   if(datb.getTypselect().equals("4")) {
              dt.setEnabled(true);
            }     else   if(datb.getTypselect().equals("5")) {
              String d=datb.getDataGet();
              try {

                byte[] bbb=Base64.decode(d,0);
                //   ByteArrayOutputStream ary = new ByteArrayOutputStream();
                Drawable dk=   convertBitmapToDrawable(BitmapFactory.decodeByteArray(bbb,0,bbb.length),dt.getContext());
                dt.setBackground(dk);
              }catch (Exception ex){

              }


            }
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

          }
        }

      }

    }else{

      getwithanotheroper(dt,datb,typoper);
    }
  }

  @Override
  protected void addAttributeProcessors() {

  }
}
