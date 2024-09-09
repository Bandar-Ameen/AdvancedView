package com.astooltech.advancedview.proteus.view.custom;

import static com.astooltech.advancedview.proteus.ALLEvent.getBeforOrafetrEven;

import android.graphics.drawable.Drawable;
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
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
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
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.switchbutton.protusePasswordEditText;

import java.util.Iterator;
import java.util.Map;


public class PrototuseShoppingViewParser<T extends ShoppingView> extends ViewTypeParser<T> {

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
        return "ShopView";
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
        return new PrototuseShoppingView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);


    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof  PrototuseShoppingView){

            SetGetFindTextInputLayoutEditTextB((PrototuseShoppingView)view,data,typoper);
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

    private void getwithanotheroper(PrototuseShoppingView dt, DataValueSelect datb, int typoper){
        PrototuseShoppingView  ccc=dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();



                        val.add("GetData", new Primitive(ccc.getmNum()));
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
                        dt.setmNum(va.getAsInt());
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

    private  void SetGetFindTextInputLayoutEditTextB(PrototuseShoppingView dt, DataValueSelect datb, int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(String.valueOf(dt.getmNum()));//.toString());
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
                            try {
                                dt.setmNum(Integer.valueOf(d));
                            }catch (Exception ex){

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

        addAttributeProcessor("Shop_data", new AttributeProcessor<T>() {
                    @Override
                    public void handleValue(final T view, Value value) {
                        Value even=null;
                        Value evnn=null;
                        String back1=value.getAsObject().getAsString("Shop_Back1");
                        String Textt=value.getAsObject().getAsString("Shop_Text");
                        String back2=value.getAsObject().getAsString("Shop_Back2");
                        String col1=value.getAsObject().getAsString("Shop_Count_Color");
                        String col2=value.getAsObject().getAsString("Shop_Min_Color");
                        String Addc=value.getAsObject().getAsString("Shop_Add_Color");
                        String Width=value.getAsObject().getAsString("Shop_Width");
                        String Widthv=value.getAsObject().getAsString("Shop_R");

                      view.SetSomeProperttes(ParseHelper.parseColor(col2),ParseHelper.parseColor(Addc),ParseHelper.parseColor(col1),ParseHelper.parseColor(back1),ParseHelper.parseColor(back2),Float.valueOf(Width),Float.valueOf(Widthv));
                      try {
                          even = value.getAsObject().get("on_add_click");
                          evnn = value.getAsObject().get("on_minus_click");
                      }catch(Exception ex){


                      }
                      final Value evenm=even;
                        final Value evenmk=evnn;
                      view.setOnShoppingClickListener(new ShoppingView.ShoppingClickListener() {
                          @Override
                          public void onAddClick(int num) {

                              if(evenm!=null){
                                  PrototuseShoppingView v=   ((PrototuseShoppingView)view);
                                 try {
                                     v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), evenm, 0, v);
                                 }catch(Exception ex){

                                 }
                                 }
                          }

                          @Override
                          public void onMinusClick(int num) {
                              if(evenmk!=null){
                                  PrototuseShoppingView v=   ((PrototuseShoppingView)view);
                                  try {
                                      v.getViewManager().getContext().getAllEven(getBeforOrafetrEven()).call(v.getAsView().getContext(), v.getViewManager().getContext().getActvityAllt(), evenmk, 0, v);
                                  }catch(Exception ex){

                                  }
                              }
                          }
                      });
                        view.SetShoppingText(Textt);

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

        addAttributeProcessor(Attributes.ImageView.Src, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
              //  view.setImageDrawable(drawable);
            }
        });
   /* addAttributeProcessor(Attributes.ImageView.from_url, new DrawableResourceProcessor<T>() {
      @Override
      public void setDrawable(T view, Drawable drawable) {
       try {
        // Log.i("ProteusEvent", view.ImageView.from_url);
         Bitmap v = Picasso.get().load(Attributes.ImageView.from_url).placeholder(R.drawable.placeholder).get();
         // view.setBackground(v);


        // view.setImageBitmap(v);
       }catch (IOException ex){

       }
       // view.setImageDrawable(drawable);
      }
    });*/
        addAttributeProcessor(Attributes.ImageView.ScaleType, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {

            }
        });


    }
}
