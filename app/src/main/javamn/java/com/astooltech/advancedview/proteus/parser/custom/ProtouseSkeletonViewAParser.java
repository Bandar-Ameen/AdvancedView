package com.astooltech.advancedview.proteus.parser.custom;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.skeleton.SkeletonView;
import com.astooltech.advancedview.proteus.skeleton.master.SkeletonModel;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProtouseSkeletonViewAParser<T extends SkeletonView> extends ViewTypeParser<T> {

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
        return "SkeView";
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
        return new ProtouseSkeletonViewA(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof ProtouseSkeletonViewA ){
            SetGetFindTextInputLayoutEditTextB(( ProtouseSkeletonViewA)view,data,typoper);
        }
    }

    private boolean checknullvalues( ProtouseSkeletonViewA dt){
        boolean checkvalue=false;
        ProtouseSkeletonViewA  ccc = dt;
        try {
            boolean typActionname = Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {




                checkvalue = false;

            } else {

                checkvalue = false;
            }
        }catch(Exception ex){

        }
        return checkvalue;


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

    private void getwithanotheroper( ProtouseSkeletonViewA  dt, DataValueSelect datb, int typoper){
        ProtouseSkeletonViewA ccc = dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {
                    datb.setChecknull(checknullvalues(dt));
                    try {
                        ObjectValue val = datb.getAnotherDatat();



                        val.add("GetData", new Primitive(0));
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
                            dt.animate().start();
                        }
                        else  if(va.getAsString().toLowerCase().equals("1")){
                            dt.animate().start();
                        }
                        else  {
                            dt.animate().cancel();
                        }
                        //dt.setBadgeNumber(Integer.parseInt(va.toString()));
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




    private  void SetGetFindTextInputLayoutEditTextB( ProtouseSkeletonViewA dt, DataValueSelect datb, int typoper) {
        if (typoper == 1) {
            boolean typActionname =true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {



                String IDDdat = dt.getTag(com.astooltech.advancedview.R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {
                            datb.setDataGet(String.valueOf(0));
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
                                ;
                            }catch (Exception ex){

                            }
                        }
                        else   if(datb.getTypselect().equals("6")) {
                            String d=datb.getDataGet();
                            try {

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
        addAttributeProcessor("proper", new AttributeProcessor<T>() {
            @Override
            public void handleValue(final T view, Value value) {
String getcolorr=value.getAsObject().getAsString("ColorA");
                String getcolorrt=value.getAsObject().getAsString("ColorB");
                int getcolorrr=value.getAsObject().getAsInteger("dir");
                boolean getcolorrrx=value.getAsObject().getAsBoolean("auto");
                int getcolorrrf=value.getAsObject().getAsInteger("Duration");
                int getcolorrref=value.getAsObject().getAsInteger("Anim_finsh");

                int getcolorrredf=value.getAsObject().getAsInteger("Anim_typ");
            int xc=    ParseHelper.parseColor(getcolorr);
            int we=ParseHelper.parseColor(getcolorrt);
//R.color.md_grey_200
                SkeletonModel r=new SkeletonModel();
                r.setColorBackgroundViews(xc);
                if(getcolorrr==0){
                    r.setAnimationDirection(SkeletonModel.ANIMATION_DIRECTION_RTL);
                }
                if(getcolorrr==1){
                    r.setAnimationDirection(SkeletonModel.ANIMATION_DIRECTION_LTR);
                }
                if(getcolorrr==2){
                    r.setAnimationDirection(SkeletonModel.ANIMATION_DIRECTION_BTT);
                }
                if(getcolorrr==3){
                    r.setAnimationDirection(SkeletonModel.ANIMATION_DIRECTION_TTB);
                }


                r.setAutoStartAnimation(getcolorrrx);
                r.setAnimationDuration(getcolorrrf);

                if(getcolorrref==0){
                    r.setAnimationFinishType(SkeletonModel.DEFAULT_ANIMATION_TYPE);
                }
                if(getcolorrref==1){
                    r.setAnimationFinishType(SkeletonModel.DEFAULT_SHAPE_TYPE);
                }

                if(getcolorrredf==0){
                    r.setAnimationNormalType(SkeletonModel.ANIMATION_TYPE_ALPHA);
                }
                if(getcolorrredf==1){
                    r.setAnimationNormalType(SkeletonModel.ANIMATION_TYPE_GRADIENT);
                }
                if(getcolorrredf==2){
                    r.setAnimationNormalType(SkeletonModel.ANIMATION_TYPE_NON);
                }
                if(getcolorrredf==3){
                    r.setAnimationNormalType(SkeletonModel.SHAPE_TYPE_RECT);
                }
                if(getcolorrredf==4){
                    r.setAnimationNormalType(SkeletonModel.DEFAULT_CORNER_RADIUS);
                }
                r.setColorBackgroundMain(android.R.color.transparent);
                r.setColorHighLight(we);//R.color.md_grey_3002
view.setSkeletonModel(r);
                ProtouseSkeletonViewA ttui=   (ProtouseSkeletonViewA)view;
                ttui.getViewManager().setActionEventView(new ProteusView.Manager.ActionEventView() {
                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

                    }

                    @Override
                    public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {

                    }

                    @Override
                    public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                    }

                    @Override
                    public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                    }
                });

                        /*Skeleton:SK_BackgroundViewsColor="#EEEEEE"
                        Skeleton:SK_animationAutoStart="true"
                        Skeleton:SK_animationDirection="LTR"
                        Skeleton:SK_animationDuration="1000"
                        Skeleton:SK_animationFinishType="none"
                        Skeleton:SK_animationNormalType="alpha"
                        Skeleton:SK_backgroundMainColor="@android:color/transparent"
                        Skeleton:SK_highLightColor="#DEDEDE"*/
              //  view.startAnimation();

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
        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });
    }
}