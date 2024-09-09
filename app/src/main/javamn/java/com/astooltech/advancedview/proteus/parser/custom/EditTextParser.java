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


import static com.astooltech.advancedview.proteus.ALLEvent.getBeforOrafetrEven;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.ObjectAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusEditText;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.PrototuseShoppingView;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by kirankumar on 25/11/14.
 */
public class EditTextParser<T extends EditText> extends ViewTypeParser<T> {

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
    return "EditText";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "TextView";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusEditText(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

  @Override
  public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
    super.GetAndSetData(view, data, typoper, anotherdat, viewname);
    if(view instanceof ProteusEditText){
      SetGetFindTextInputLayoutEditText((ProteusEditText)view,data,typoper);
    }
  }


  private Value getvaluefromdat(String keyna,ObjectValue erx){
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

  private  void getwithanotheroper(EditText  dt,DataValueSelect datb,int typoper){

    if (typoper == 2) {
      EditText ccc = dt;
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
      EditText ccc = dt;
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

  private  void SetGetFindTextInputLayoutEditText( EditText  dt,DataValueSelect datb,int typoper) {
    if (typoper == 1) {
      boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
      if (typActionname) {



        String IDDdat = dt.getTag(R.id.tag3).toString();
        if(IDDdat!=null) {

          if (IDDdat.equals(datb.getIDUnit())) {
            {
              //  dat.get(cxx).setDataGet();
              if (datb.getTypselect().equals("0")) {
                datb.setDataGet(dt.getText().toString());
                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

              } else if (datb.getTypselect().equals("1")) {
                dt.setVisibility(View.VISIBLE);
              } else if (datb.getTypselect().equals("2")) {
                dt.setVisibility(View.GONE);
              } else if (datb.getTypselect().equals("3")) {
                dt.setEnabled(false);
              } else if (datb.getTypselect().equals("4")) {
                dt.setEnabled(true);
              } else if (datb.getTypselect().equals("5")) {
                String d = datb.getDataGet();
                dt.setText(d);

              }
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



    addAttributeProcessor(Attributes.View.Inputtyp, new StringAttributeProcessor<T>() {
              @Override
              public void setString(final T view, String value) {



                if(value.equals("DateTime")) {
                  view.setInputType(InputType.TYPE_CLASS_DATETIME);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Number")) {
                  view.setInputType(InputType.TYPE_CLASS_NUMBER);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Text")) {
                  view.setInputType(InputType.TYPE_CLASS_TEXT);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }

                if(value.equals("Decimal")) {
                  view.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Email")) {
                  view.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Url")) {
                  view.setInputType(InputType.TYPE_TEXT_VARIATION_URI);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Short")) {
                  view.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Password")) {
                  view.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Phone")) {
                  view.setInputType(InputType.TYPE_CLASS_PHONE);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
              }
            });
    addAttributeProcessor(Attributes.View.Recyle_use_serchh, new   AttributeProcessor<T>() {

      @Override
      public void handleValue(final T view,final Value value) {
        view.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            ProteusEditText v=   ((ProteusEditText)view);
            try {
              v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), value, 0, v);
            }catch(Exception ex){

            }

           // uuip.triggerAdapter(6, false, charSequence.toString(), charSequence.toString(), null, ((ProteusEditText) view));


            //((ProteusEditText) view).getViewManager().getDataContext()

            // Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+charSequence);
          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
        });
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
    addAttributeProcessor(Attributes.View.Recyle_use_serch, new StringAttributeProcessor<T>() {
      @Override
      public void setString(final T view, String value) {

       // view.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
        view.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            EventProcessor uuip = new EventProcessor() {
              @Override
              public void setOnEventListener(View view, Value value) {

              }
            }; //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);


            uuip.triggerAdapter(6, false, charSequence.toString(), charSequence.toString(), null, ((ProteusEditText) view));


            //((ProteusEditText) view).getViewManager().getDataContext()

           // Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+charSequence);
          }

          @Override
          public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

          }

          @Override
          public void afterTextChanged(Editable editable) {

          }
        });



        //view.setText(value);
      }
    });
  }
}
