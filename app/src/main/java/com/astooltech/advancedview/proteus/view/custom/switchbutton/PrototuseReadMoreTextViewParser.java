package com.astooltech.advancedview.proteus.view.custom.switchbutton;

import android.annotation.SuppressLint;
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
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProteusTextView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;


public class PrototuseReadMoreTextViewParser<T extends ReadMoreTextView> extends ViewTypeParser<T> {
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
        return "TextViewReadMore";
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
        return new PrototuseReadMoreTextView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof ReadMoreTextView){
            SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmor((ReadMoreTextView )view,data,typoper);
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

    private void getwithanotheroper(ReadMoreTextView  dt, DataValueSelect datb, int typoper){
        ReadMoreTextView  ccc=dt;
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

    private  void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmor( ReadMoreTextView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(dt.getText().toString());


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
                            dt.setText(d);

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



        addAttributeProcessor("proper", new AttributeProcessor<T>() {
                    @Override
                    public void handleValue(T view, Value value) {
                        int durat=value.getAsObject().getAsInteger("TrimLength");
                        int inter=value.getAsObject().getAsInteger("TrimLines");
                        String uinter=value.getAsObject().getAsString("Textcolor");
                        view.setTrimLength(durat);
                        view.setTrimLines(inter);
                        view.setColorClickableText(ParseHelper.parseColor(uinter));
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
            addAttributeProcessor("knbb", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {





                    // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
        addAttributeProcessor(Attributes.View.DateFromat, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {


                    @SuppressLint("SimpleDateFormat")
                    SimpleDateFormat g=new SimpleDateFormat(value);
                    Calendar v=Calendar.getInstance();
                    String ggh=g.format(v.getTime());
                    int yerr,month,day;
                    month=v.get(Calendar.MINUTE);
                    yerr=v.get(Calendar.YEAR);
                    day=v.get(Calendar.DAY_OF_MONTH);
                    view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }
}
