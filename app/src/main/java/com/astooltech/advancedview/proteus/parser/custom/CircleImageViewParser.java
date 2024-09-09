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
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

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
import com.astooltech.advancedview.proteus.view.CircleImageView;
import com.astooltech.advancedview.proteus.view.ProteusImageView;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by kiran.kumar on 12/05/14.
 */
public class CircleImageViewParser<T extends de.hdodenhof.circleimageview.CircleImageView> extends ViewTypeParser<T> {
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }
    @NonNull
    @Override
    public String getType() {
        return "CircleImageView";
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
        return new CircleImageView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof CircleImageView){
            SetImage((CircleImageView )view,data,typoper);
        }
    }

    private static   Drawable convertBitmapToDrawable(Bitmap original, Context context) {

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

    private  void getwithanotheroper(CircleImageView dt, DataValueSelect datb, int typoper){
        CircleImageView   ccc = dt;
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

    private void SetImage(CircleImageView  dt,DataValueSelect datb,int typoper) {
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

            }else{

                getwithanotheroper(dt,datb,typoper);
            }

        }
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.ImageView.Src, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                view.setImageDrawable(drawable);
            }
        });

        addAttributeProcessor("from_base64", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                String typp=value.getAsObject().get("base64").toString();

                try {

                    byte[] bbb=Base64.decode(typp,0);
                    //   ByteArrayOutputStream ary = new ByteArrayOutputStream();
                    Drawable dk=   convertBitmapToDrawable(BitmapFactory.decodeByteArray(bbb,0,bbb.length),view.getContext());
                    view.setBackground(dk);
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
                ProteusImageView.ScaleType scaleType;
                scaleType = ParseHelper.parseScaleType(value);
                if (scaleType != null)
                    view.setScaleType(scaleType);
            }
        });

        addAttributeProcessor(Attributes.ImageView.AdjustViewBounds, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if ("true".equals(value)) {
                    view.setAdjustViewBounds(true);
                } else {
                    view.setAdjustViewBounds(false);
                }
            }
        });
    }
}
