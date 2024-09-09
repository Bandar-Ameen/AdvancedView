package com.astooltech.advancedview.proteus.parser.custom;

import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.chatview.data.Message;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProteusTextView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import com.google.gson.Gson;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class WatingLayoputParser<V extends WatingLayout> extends ViewTypeParser<V> {

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
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new WatingLayoutProtuse(context.getActvityAllt());
    }
    @NonNull
    @Override
    public String getType() {
        return "Layout_Wait";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new WatingLayoutProtuse(context.getActvityAllt());
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof WatingLayoutProtuse){
         SetGetFindTextInputLayoutEditTextB((WatingLayoutProtuse)view,data,typoper);
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

    private void getwithanotheroper(WatingLayoutProtuse dt, DataValueSelect datb, int typoper){
        WatingLayoutProtuse ccc=dt;
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
                    dt.showError(s);


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


                }else   if(typ.getAsString().equals("6")) {
                   // String d=datb.getDataGet();
                    dt.setViewContiners();


                }
                else   if(typ.getAsString().equals("7")) {

                    dt.startWating();


                }
                else   if(typ.getAsString().equals("8")) {

                    dt.Stopwa();


                }

            }


        }
    }


    private void SetGetFindTextInputLayoutEditTextB(WatingLayoutProtuse dt, DataValueSelect datb, int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                //Button b=null;
                // b.setCompoundDrawables(dt.getIndeterminateDrawable(),null,null,null);

                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {


                            // datb.setDataGet(dt.getText().toString());
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
                            dt.showError(d);


                        }
                        else   if(datb.getTypselect().equals("6")) {
                            String d=datb.getDataGet();
                            dt.setViewContiners();


                        }
                        else   if(datb.getTypselect().equals("7")) {

                            dt.startWating();


                        }
                    }
                }

            }

        }else{

            getwithanotheroper(dt,datb,typoper);
        }
    }
    public String getTime(){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd MMM yyyy HH:mm");
        String time = mdformat.format(calendar.getTime());
        return time;
    }
    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("proper", new AttributeProcessor<V>() {
            private boolean km(boolean a,boolean name){
                a=name;
                return  a;
            }
            private File createImageFile() {
                // External location
                //TODO: Ver si cambiar a almacenamiento interno o externo no publico
                File mediaStorageDir = new File(
                        Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                        GlobalClass.fileDIRECTORY);

                // Create the storage directory if it does not exist
                if (!mediaStorageDir.exists()) {
                    if (!mediaStorageDir.mkdirs()) {

                        return null;
                    }
                }

                // Create a media file name
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
                File mediaFile;
                mediaFile = new File(mediaStorageDir.getPath() + File.separator
                        + "IMG_" + timeStamp + ".jpg");


                return mediaFile;
            }
            public String getPathVideo(Uri uri, AppCompatActivity ac, int typ) {
                System.out.println("getpath "+uri.toString());
                String[] projection = {typ==50? MediaStore.Video.Media.DATA:MediaStore.Images.Media.DATA };
                Cursor cursor = ac.getContentResolver().query(uri, projection, null, null, null);
                if(cursor!=null) {
                    int column_index = cursor.getColumnIndexOrThrow(typ==50? MediaStore.Video.Media.DATA:MediaStore.Images.Media.DATA );
                    cursor.moveToFirst();
                    String res=cursor.getString(column_index);
                    //storage/emulated/0/DCIM/Screenshots/Screenshot_20231016-070902_Facebook.jpg
                    Log.e("rrrrrr",res);
                    return res;
                }
                else return null;
            }


           public void handleValue(final V view, final Value value) {

                Gson g=new Gson();

                Value getproper=value.getAsObject().get("proper");
                int wait=1000;
                String Errorbton="Error";
                try{
                  wait=  value.getAsObject().getAsInteger("daley");
                    Errorbton=  value.getAsObject().getAsString("errorText");
                }catch (Exception ex){

                }


//A_al
                //A_alpha
                //int cxx= ((ProteusView)view).getViewManager().getLayout().attributes.lastIndexOf("A_alpha");
                //   int cxx=((ProteusView)view).getViewManager().getLayout()

               WatingLayoutProtuse   chatView=(WatingLayoutProtuse)view;
               final WatingLayoutProtuse viez=(WatingLayoutProtuse)view;
                chatView.setProperPrograss(getproper);
                chatView.getError_btton().setText(Errorbton);

                chatView.startWating();
                        new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
try {
  ProteusView v = ((WatingLayoutProtuse) view).getViewManager().getContext().getInflater().inflate(value.getAsObject().get("view").getAsLayout(), ((WatingLayoutProtuse) view).getViewManager().getDataContext().getData());
    ((WatingLayoutProtuse) view).setViewContiners(v.getAsView());

}catch (Exception ex){
    ((WatingLayoutProtuse) view).showError(ex.getMessage());
}

                    }
                },  wait);



            }

            @Override
            public void handleResource(V view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {

            }
        });

        addAttributeProcessor("mm", new GravityAttributeProcessor<V>() {
            @Override
            public void setGravity(V view, @Gravity int gravity) {


                // com.astooltech.advancedview.spinkit.SpinKitView ss=new com.astooltech.advancedview.spinkit.SpinKitView();
                view.setFitsSystemWindows(true);


                //  Wave ff=new Wave();

                //  ff.setBounds(0,0,100,100);

                //Sprite ee=new Sprite();
                //  view.setBackground(ff);

                //.setLayerType(SpinKitView.OVER_SCROLL_ALWAYS,).setCollapsedTitleGravity(gravity);
            }
        });
/*
        addAttributeProcessor("contentScrim", new DrawableResourceProcessor<V>() {
            @Override
            public void setDrawable(V view, Drawable drawable) {
                view.setContentScrim(drawable);
            }
        });

        addAttributeProcessor("expandedTitleGravity", new GravityAttributeProcessor<V>() {
            @Override
            public void setGravity(V view, @Gravity int gravity) {
                view.setExpandedTitleGravity(gravity);
            }
        });

        addAttributeProcessor("expandedTitleMargin", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMargin((int) dimension, (int) dimension, (int) dimension, (int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginBottom", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginBottom((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginEnd", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginEnd((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginStart", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginStart((int) dimension);
            }
        });

        addAttributeProcessor("expandedTitleMarginTop", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setExpandedTitleMarginTop((int) dimension);
            }
        });

        addAttributeProcessor("scrimAnimationDuration", new NumberAttributeProcessor<V>() {
            @Override
            public void setNumber(V view, @NonNull Number value) {
                view.setScrimAnimationDuration(value.longValue());
            }
        });


        addAttributeProcessor("scrimVisibleHeightTrigger", new DimensionAttributeProcessor<V>() {
            @Override
            public void setDimension(V view, float dimension) {
                view.setScrimVisibleHeightTrigger((int) dimension);
            }
        });

        addAttributeProcessor("statusBarScrim", new DrawableResourceProcessor<V>() {
            @Override
            public void setDrawable(V view, Drawable drawable) {
                view.setStatusBarScrim(drawable);
            }
        });

        addAttributeProcessor("title", new StringAttributeProcessor<V>() {
            @Override
            public void setString(V view, String value) {
                view.setTitle(value);
            }
        });

        addAttributeProcessor("titleEnabled", new BooleanAttributeProcessor<V>() {
            @Override
            public void setBoolean(V view, boolean value) {
                view.setTitleEnabled(value);
            }
        });*/
    }
}
