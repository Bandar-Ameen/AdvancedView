package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusCheckBox;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.PrototoseSwiperView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class PrototoseSwiperViewParser<T extends SwipeRefreshLayout > extends ViewTypeParser<T> {


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
        return "SwipeRefreshLayout";
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

        getview=new PrototoseSwiperView(context);
        return getview;
       // return new );
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    @Override
    public void BordcastRecever(String Broad) {
        super.BordcastRecever(Broad);

        if(getview!=null){

            getview.getViewManager().getActionEventView().sendEvent(null,7000,Broad);
        }

    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof  PrototoseSwiperView){
            SetGetFindTSppinerSweep((PrototoseSwiperView)view,data,typoper);
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

    private  void getwithanotheroper(PrototoseSwiperView dt, DataValueSelect datb, int typoper){
        PrototoseSwiperView  ccc = dt;
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
                            dt.setRefreshing(true);
                            try {
                                ObjectValue ar=new ObjectValue();
                                List<Layout.Attribute> re=    dt.getViewManager().getLayout().attributes;
                                Iterator<Layout.Attribute> w=re.iterator();
                                while (w.hasNext()){
                                    Layout.Attribute q=w.next();
                                    if(q.keyname.toLowerCase().equals(Attributes.View.SweepTypevent.toLowerCase())){

                                        ar=q.value.getAsObject();
                                    }

                                }
                                //  ObjectValue ar =dt.getViewManager().getLayout().attributes;//.getAsObject().getAsObject("");

                                dt.getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(dt.getAsView().getContext(), dt.getViewManager().getContext().getActvityAllt(), ar, 0, dt);
                            }catch (Exception ex){

                                Log.e("sweep",ex.getMessage());
                                dt.setRefreshing(false);
                            }
                        }
                        else if(dt.equals("1")){
                            dt.setRefreshing(true);
                            try {
                                ObjectValue ar=new ObjectValue();
                                List<Layout.Attribute> re=    dt.getViewManager().getLayout().attributes;
                                Iterator<Layout.Attribute> w=re.iterator();
                                while (w.hasNext()){
                                    Layout.Attribute q=w.next();
                                    if(q.keyname.toLowerCase().equals(Attributes.View.SweepTypevent.toLowerCase())){

                                        ar=q.value.getAsObject();
                                    }

                                }
                                //  ObjectValue ar =dt.getViewManager().getLayout().attributes;//.getAsObject().getAsObject("");

                                dt.getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(dt.getAsView().getContext(), dt.getViewManager().getContext().getActvityAllt(), ar, 0, dt);
                            }catch (Exception ex){

                                Log.e("sweep",ex.getMessage());
                                dt.setRefreshing(false);
                            }
                        }else{
                            dt.setRefreshing(false);
                        }



                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }



                }


                  else if (typ.getAsString().equals("5")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.startsWith("true")){
                            dt.setRefreshing(true);
                            try {
                                ObjectValue ar=new ObjectValue();
                                List<Layout.Attribute> re=    dt.getViewManager().getLayout().attributes;
                                Iterator<Layout.Attribute> w=re.iterator();
                                while (w.hasNext()){
                                    Layout.Attribute q=w.next();
                                    if(q.keyname.toLowerCase().equals(Attributes.View.SweepTypevent.toLowerCase())){

                                        ar=q.value.getAsObject();
                                    }

                                }
                              //  ObjectValue ar =dt.getViewManager().getLayout().attributes;//.getAsObject().getAsObject("");

                                dt.getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(dt.getAsView().getContext(), dt.getViewManager().getContext().getActvityAllt(), ar, 0, dt);
                            }catch (Exception ex){

                                Log.e("sweep",ex.getMessage());
                                dt.setRefreshing(false);
                            }

                        }
                        else if(s.startsWith("1")){
                            dt.setRefreshing(true);
                            try {
                                ObjectValue ar=new ObjectValue();
                                List<Layout.Attribute> re=    dt.getViewManager().getLayout().attributes;
                                Iterator<Layout.Attribute> w=re.iterator();
                                while (w.hasNext()){
                                    Layout.Attribute q=w.next();
                                    if(q.keyname.toLowerCase().equals(Attributes.View.SweepTypevent.toLowerCase())){

                                        ar=q.value.getAsObject();
                                    }

                                }
                                //  ObjectValue ar =dt.getViewManager().getLayout().attributes;//.getAsObject().getAsObject("");

                                dt.getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(dt.getAsView().getContext(), dt.getViewManager().getContext().getActvityAllt(), ar, 0, dt);
                            }catch (Exception ex){

                                Log.e("sweep",ex.getMessage());
                                dt.setRefreshing(false);
                            }
                        }else{
                            dt.setRefreshing(false);
                        }
                    }catch(Exception ex){
                        Log.e("hhhhhhxxx",ex.getMessage());
                    }


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


    private void SetGetFindTSppinerSweep(PrototoseSwiperView  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true; //Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {


                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {
                        //  dat.get(cxx).setDataGet();
                        if(datb.getTypselect().equals("0")) {

                            /// dt.set
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


                            //  dt.getSelectedItem();
                          /*  flexAdapterrrr tur=( flexAdapterrrr) dt.getAdapter();
                            int postin=  tur.getallItemPostionByname(d);
*/
                            dt.setRefreshing(false);
                        }

                    }
                }

            }

        }else{



            getwithanotheroper(dt,datb,typoper);
        }
    }


    @SuppressLint("StaticFieldLeak")
    private static PrototoseSwiperView getview;
    @Override
    protected void addAttributeProcessors() {
       /* addAttributeProcessor(Attributes.View.SweepTyp, new StringAttributeProcessor<T>() {
                    @Override
                    public void setString(final T view, String value) {

                        view.setDirection(SwipyRefreshLayoutDirection.BOTH);
                    }
                });
*/
        boolean found=false;

        addAttributeProcessor(Attributes.View.SweepTypevent, new AttributeProcessor<T>() {

            @Override
            public void handleValue(final T view,final Value value) {


                view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        //    PrototoseSwiperView erty=      (PrototoseSwiperView)view;
                        disabll();

                        //   view.setRefreshing(false);
                     /*  final  PrototoseSwiperView cc= (PrototoseSwiperView)view;
                       EventProcessor uuip = new EventProcessor() {
                           @Override
                           public void setOnEventListener(View view, Value value) {

                           }
                       };*/

                        // uuip.triggerAdapter(7,false,"noo","jj",null,(PrototoseSwiperView)view);

                    }

                    public  void disabll(){
                        try {

                            ObjectValue ar = value.getAsObject();

                            ((PrototoseSwiperView) view).getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(((PrototoseSwiperView) view).getAsView().getContext(), ((PrototoseSwiperView) view).getViewManager().getContext().getActvityAllt(), ar, 0, ((PrototoseSwiperView) view));
                        }catch (Exception ex){

                            Log.e("sweep",ex.getMessage());
                        }

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
        addAttributeProcessor(Attributes.View.SweepTyp, new StringAttributeProcessor<T>() {
           // @RequiresApi(api = Build.VERSION_CODES.M)


            @Override
            public void setString(final T view, final String value) {


               view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                   @Override
                   public void onRefresh() {

                   //    PrototoseSwiperView erty=      (PrototoseSwiperView)view;
                       disabl();

                    //   view.setRefreshing(false);
                     /*  final  PrototoseSwiperView cc= (PrototoseSwiperView)view;
                       EventProcessor uuip = new EventProcessor() {
                           @Override
                           public void setOnEventListener(View view, Value value) {

                           }
                       };*/

                      // uuip.triggerAdapter(7,false,"noo","jj",null,(PrototoseSwiperView)view);

                   }

                   public  void disabl(){
                       String getId=view.getTag(R.id.tag3).toString();
                       ((PrototoseSwiperView) view).getViewManager().getContext().getParser("ARecyclerView").BordcastRecever(value+"#"+getId);

                   }
               });
            //    final PrototoseSwiperView ertv=   ((PrototoseSwiperView) view);
                if(((PrototoseSwiperView) view).getViewManager().getActionEventView()==null){

                    ((PrototoseSwiperView) view).getViewManager().setActionEventView(new ProteusView.Manager.ActionEventView() {
                        @Override
                        public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {
                /*  AAadpterme refresha= (AAadpterme) ert.getAdapter();
                  refresha.reftesh();*/
                        }

                        @Override
                        public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {
                            String[] dattyps=anotherdata.split("#");
                            // PrototoseSwiperView ert=   ((PrototoseSwiperView) view);
                            Log.e("ooo",dattyps[0]);
                           // Log.e("ooo",getId);
                           // if(getId.equals(dattyps[0])) {

                            disabl();
                                //ertv.setRefreshing(false);
                           // }
                        }

                        @Override
                        public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                        }

                        @Override
                        public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                        }

                        public  void disabl(){
view.setRefreshing(false);

                        }
                    });
                }

            }
        });
        addAttributeProcessor(Attributes.View.onSweep, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {

            view.setTag(R.id.onsweep,value);
               /* if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }*/
            }
        });
        addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
               /* if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }*/
            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
               // view.setGravity(gravity);
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                   // view.setDividerDrawable(drawable);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                   // view.setDividerPadding((int) dimension);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    int dividerMode = ParseHelper.parseDividerMode(value);
                    // noinspection ResourceType
                   // view.setShowDividers(dividerMode);
                }
            }
        });



        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {
              //  view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
    }
}
