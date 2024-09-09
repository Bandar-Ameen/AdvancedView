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
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.design.spinnerdatepicker.DatePicker;
import com.astooltech.advancedview.proteus.design.spinnerdatepicker.DatePickerDialog;
import com.astooltech.advancedview.proteus.design.spinnerdatepicker.SpinnerDatePickerDialogBuilder;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusButton;
import com.astooltech.advancedview.proteus.view.ProteusCheckBox;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.good.GoodView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kiran.kumar on 12/05/14.
 */
public class ButtonParser<T extends Button> extends ViewTypeParser<T> {
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
    return "Button";
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
    return new ProteusButton(context);
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof ProteusButton ){
            SetGetFindTextInputLayoutEditTextB((ProteusButton )view,data,typoper);
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

    private  void getwithanotheroper(ProteusButton dt, DataValueSelect datb, int typoper){
        ProteusButton   ccc = dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();



                        val.add("GetData", new Primitive("0"));//.getText().toString()));
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
                        if(va.getAsString().toLowerCase().equals("true")){
                           // dt.setChecked(true);
                        }
                        else if(va.getAsString().equals("1")){
                            //dt.setChecked(true);
                        }else{
                          //  dt.setChecked(false);
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

    private  void SetGetFindTextInputLayoutEditTextB( ProteusButton dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
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
                        else   if(datb.getTypselect().equals("5")) {
                            String d=datb.getDataGet();
                            dt.setText(d);

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
    addAttributeProcessor("child", new AttributeProcessor<T>() {


              @Override
              public void handleValue(T view, Value value) {
              //  int durat=value.getAsObject().getAsInteger("Duration");
                new GoodView(view.getContext()).show(view);
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
        addAttributeProcessor(Attributes.View.DateFromatt, new AttributeProcessor<T>() {
                    @Override
                    public void handleValue(final T viewx, Value value) {

                        String format=value.getAsObject().get("format").getAsString();

                      final   SimpleDateFormat g = new SimpleDateFormat(format);
                        Calendar v = Calendar.getInstance();
                        String ggh = g.format(v.getTime());
                      /*  int yerr, month, day;
                        month = v.get(Calendar.MINUTE);
                        yerr = v.get(Calendar.YEAR);
                        day = v.get(Calendar.DAY_OF_MONTH);*/
                        viewx.setText(ggh);

                        viewx.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DatePickerDialog.OnDateSetListener c  =new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker viewt, int year, int monthOfYear, int dayOfMonth) {
                                        Calendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
                                      viewx.setText(g.format(calendar.getTime()));
                                    }
                                };

                                DatePickerDialog.OnDateCancelListener b=new DatePickerDialog.OnDateCancelListener() {
                                    @Override
                                    public void onCancelled(DatePicker view) {

                                    }
                                };
                                Calendar v = Calendar.getInstance();
                                int yerr, month, day;
                                month = v.get(Calendar.MONTH);
                                yerr = v.get(Calendar.YEAR);
                                day = v.get(Calendar.DAY_OF_MONTH);

                                showDate( yerr, month,day, R.style.DatePickerSpinner,c,b,viewx.getContext());
                            }
                        });

                    }
                   public void showDate(int year, int monthOfYear, int dayOfMonth, int spinnerTheme, DatePickerDialog.OnDateSetListener ca, DatePickerDialog.OnDateCancelListener canc, Context c) {
                        new SpinnerDatePickerDialogBuilder()
                                .context(c)
                                .callback(ca)
                                .onCancel(canc)
                                .spinnerTheme(spinnerTheme)
                                .defaultDate(year, monthOfYear, dayOfMonth)
                                .build()
                                .show();
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
                addAttributeProcessor(Attributes.View.DateFromat, new StringAttributeProcessor<T>() {
                    @Override
                    public void setString(T view, String value) {
                        boolean dd = false;
                        try {

                            @SuppressLint("SimpleDateFormat")
                            SimpleDateFormat g = new SimpleDateFormat(value);
                            Calendar v = Calendar.getInstance();
                            String ggh = g.format(v.getTime());
                            int yerr, month, day;
                            month = v.get(Calendar.MINUTE);
                            yerr = v.get(Calendar.YEAR);
                            day = v.get(Calendar.DAY_OF_MONTH);
                            view.setText(ggh);

                        } catch (Exception e) {

                        }

                        // view.setCalendarViewShown(false);
                        //  view .setSpinnersShown(dd);
                    }
                });
  }
}
