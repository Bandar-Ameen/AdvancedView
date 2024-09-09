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
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.utils.imgeparse;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProteusTextView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class TextViewParser<T extends TextView> extends ViewTypeParser<T> {

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
    return new TextInputLayoutB(context);
  }
  @NonNull
  @Override
  public String getType() {
    return "TextView";
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
    return new ProteusTextView(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable MaterialRippleLayout  parent, int dataIndex) {
    return new ProteusRappleLayout(context);
  }
  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return null;
  }

  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);
   try {
     if (view instanceof ProteusTextView) {
       SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextView((ProteusTextView) view, data, typoper);
     }
   }catch (Exception ex){

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

  private void getwithanotheroper(ProteusTextView  dt,DataValueSelect datb,int typoper){
    ProteusTextView ccc=dt;
    if (typoper == 2) {

      assert ccc != null;
      String IDDdat = dt.getTag(R.id.tag3).toString();
      if (IDDdat.equals(datb.getIDUnit())) {
        if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

          try {
            ObjectValue val = datb.getAnotherDatat();



            val.add("GetData", new Primitive(ccc.getText().toString()));
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
            dt.setText(va.getAsString());
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


  private  void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextView( ProteusTextView  dt,DataValueSelect datb,int typoper) {
    if (typoper == 1) {
      boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
      if (typActionname) {


        String IDDdat = dt.getTag(R.id.tag3).toString();
        if (IDDdat.equals(datb.getIDUnit())) {
          {
            //  dat.get(cxx).setDataGet();
            if(datb.getTypselect().equals("0")) {
              datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/
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
            }
           else if (datb.getTypselect().equals("5")) {
            dt.setText(datb.getDataGet());
          }
          }
        }

      }

    }else{

      getwithanotheroper(dt,datb,typoper);
    }
  }


  @Override
  protected void addAttributeProcessors() {

    addAttributeProcessor(Attributes.TextView.HTML, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        try {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            view.setText(Html.fromHtml(value, new imgeparse(view, view.getContext()), null));
          } else {
            //noinspection deprecation
            view.setText(Html.fromHtml(value, new imgeparse(view, view.getContext()), null));
          }
        }catch (Exception ex){

        }
      }
    });
    addAttributeProcessor(Attributes.TextView.Text, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setText(value);
      }
    });

    addAttributeProcessor(Attributes.TextView.DrawablePadding, new DimensionAttributeProcessor<T>() {
      @Override
      public void setDimension(T view, float dimension) {
        view.setCompoundDrawablePadding((int) dimension);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextSize, new DimensionAttributeProcessor<T>() {
      @Override
      public void setDimension(T view, float dimension) {
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimension);
      }
    });
    addAttributeProcessor(Attributes.TextView.Gravity, new GravityAttributeProcessor<T>() {
      @Override
      public void setGravity(T view, @Gravity int gravity) {
        view.setGravity(gravity);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextColor, new ColorResourceProcessor<T>() {

      @Override
      public void setColor(T view, int color) {
        view.setTextColor(color);
      }

      @Override
      public void setColor(T view, ColorStateList colors) {
        view.setTextColor(colors);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextColorHint, new ColorResourceProcessor<T>() {

      @Override
      public void setColor(T view, int color) {
        view.setHintTextColor(color);
      }

      @Override
      public void setColor(T view, ColorStateList colors) {
        view.setHintTextColor(colors);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextColorLink, new ColorResourceProcessor<T>() {

      @Override
      public void setColor(T view, int color) {
        view.setLinkTextColor(color);
      }

      @Override
      public void setColor(T view, ColorStateList colors) {
        view.setLinkTextColor(colors);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextColorHighLight, new ColorResourceProcessor<T>() {

      @Override
      public void setColor(T view, int color) {
        view.setHighlightColor(color);
      }

      @Override
      public void setColor(T view, ColorStateList colors) {
        //
      }
    });

    addAttributeProcessor(Attributes.TextView.DrawableLeft, new DrawableResourceProcessor<T>() {
      @Override
      public void setDrawable(T view, Drawable drawable) {
        Drawable[] compoundDrawables = view.getCompoundDrawables();
        view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
      }
    });
    addAttributeProcessor(Attributes.TextView.DrawableTop, new DrawableResourceProcessor<T>() {
      @Override
      public void setDrawable(T view, Drawable drawable) {
        Drawable[] compoundDrawables = view.getCompoundDrawables();
        view.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
      }
    });
    addAttributeProcessor(Attributes.TextView.DrawableRight, new DrawableResourceProcessor<T>() {
      @Override
      public void setDrawable(T view, Drawable drawable) {
        Drawable[] compoundDrawables = view.getCompoundDrawables();
        view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], drawable, compoundDrawables[3]);
      }
    });
    addAttributeProcessor(Attributes.TextView.DrawableBottom, new DrawableResourceProcessor<T>() {
      @Override
      public void setDrawable(T view, Drawable drawable) {
        Drawable[] compoundDrawables = view.getCompoundDrawables();
        view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], compoundDrawables[2], drawable);
      }
    });

    addAttributeProcessor(Attributes.TextView.MaxLines, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setMaxLines(ParseHelper.parseInt(value));
      }
    });

    addAttributeProcessor(Attributes.TextView.Ellipsize, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        Enum ellipsize = ParseHelper.parseEllipsize(value);
        view.setEllipsize((android.text.TextUtils.TruncateAt) ellipsize);
      }
    });

    addAttributeProcessor(Attributes.TextView.PaintFlags, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        if (value.equals("strike"))
          view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
      }
    });

    addAttributeProcessor(Attributes.TextView.Prefix, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setText(value + view.getText());
      }
    });

    addAttributeProcessor(Attributes.TextView.Suffix, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setText(view.getText() + value);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextStyle, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        int typeface = ParseHelper.parseTextStyle(value);
        view.setTypeface(Typeface.defaultFromStyle(typeface));
      }
    });

    addAttributeProcessor(Attributes.TextView.SingleLine, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setSingleLine(value);
      }
    });

    addAttributeProcessor(Attributes.TextView.TextAllCaps, new BooleanAttributeProcessor<T>() {
      @Override
      public void setBoolean(T view, boolean value) {
        view.setAllCaps(value);
      }
    });
    addAttributeProcessor(Attributes.TextView.Hint, new StringAttributeProcessor<T>() {
      @Override
      public void setString(T view, String value) {
        view.setHint(value);
      }
    });
  }
}
