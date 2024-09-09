package com.astooltech.advancedview.proteus.v7.widget;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.AAadpterme;
import com.astooltech.advancedview.proteus.view.ProteusTextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete.DynamicAutoCompleteTextView;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.flexAdapterrrr;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.HeaderItem;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.items.OverallItem;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.AutoCompleteTextViewFactory;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.v7.layoutmanager.LayoutManagerFactory;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;


public class AutoCompleteTextViewBparser<V extends DynamicAutoCompleteTextView> extends ViewTypeParser<V> {
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
        return new AutoCompleteTextViewB(context);
        //return new ProteusRadioButtonGroup(context);
    }
    public static final String ATTRIBUTE_ADAPTER = "adapter";
    public static final String ATTRIBUTE_LAYOUT_MANAGER = "layout_manager";

    public static final String ATTRIBUTE_TYPE = ProteusConstants.TYPE;
    //public static final String oritation = ProteusConstants.oritation;

    @NonNull
    private final AutoCompleteTextViewFactory adapterFactory;

    @NonNull
    private final LayoutManagerFactory layoutManagerFactory;

    public AutoCompleteTextViewBparser(@NonNull  AutoCompleteTextViewFactory adapterFactory, @NonNull LayoutManagerFactory layoutManagerFactory) {
        this.adapterFactory = adapterFactory;
        this.layoutManagerFactory = layoutManagerFactory;
    }

    @NonNull
    @Override
    public String getType() {
        return "AutoText";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new AutoCompleteTextViewB(context);
    }

    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new AdapterBasedViewManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof AutoCompleteTextViewB){
            SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextViewAuto((AutoCompleteTextViewB )view,data,typoper);
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

    private void getwithanotheroper( AutoCompleteTextViewB  dt, DataValueSelect datb, int typoper){
        AutoCompleteTextViewB  ccc=dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();

                        String vaa=null;
                        try {
                            AdapterView y = (AdapterView) dt.getAdapter();
                            //flexAdapterrrr y=(flexAdapterrrr)dt.getAdapter() ;
                            AbstractFlexibleItem tru = (AbstractFlexibleItem) y.getItemAtPosition(y.getSelectedItemPosition());
                            OOverIttem kjnm = (OOverIttem) tru;
                            ObjectValue obj = kjnm.getdataa().getAsObject();


                            Value fr = val.get("from_select_item");
                            Value u = fr.getAsObject().get("key_value");


                            val.add("GetData", obj.get(u.getAsString()));
                            vaa="fffff";
                        }catch(Exception ex){

                        }
                        if(vaa==null){
                            val.add("GetData", new Primitive(ccc.getText().toString()));
                        }

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
                        AdapterView y = (AdapterView) dt.getAdapter();
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        Value vaa=  getvaluefromdat("from_select_item",datb.getAnotherDatat());




                        String valueselect=va.getAsString();
                        String keyname=vaa.getAsString();
                        boolean nfond=false;
                        for (int cx = 0; cx < y.getCount(); cx++) {
                            if(!nfond) {
                                AbstractFlexibleItem trub = (AbstractFlexibleItem) y.getItemAtPosition(cx);
                                OOverIttem kjnmn = (OOverIttem) trub;
                                String sel = kjnmn.getdataa().getAsObject().get(keyname).getAsString();
                                if (sel.equals(valueselect)) {

                                    nfond=true;
                                    y.setSelection(cx);
                                }
                            }
                        }




                        // dt.setText(va.getAsString());
                    }catch(Exception ex){
                        Log.e("hhhhhhxxxiiophhh",ex.getMessage());
                    }





                }

                else if (typ.getAsString().equals("5")) {
                    try {

                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        String s=  va.getAsString();
                        if(s.startsWith("true")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");

                        }
                        else if(s.startsWith("1")){
                            AAadpterme refresha = (AAadpterme) dt.getAdapter();


                            refresha.reftesh("na");
                        }else{

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

    private  void SetGetFindTextInputLayoutEditTextCheckBoxSwiRedmorTextViewAuto(AutoCompleteTextViewB  dt,DataValueSelect datb,int typoper) {
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

        addAttributeProcessor(Attributes.View.Recyle_use_reload, new BooleanAttributeProcessor<V>() {
            @Override
            public void setBoolean(V view, boolean value) {



                // view.setSingleLine(value);
            }
        });

        addAttributeProcessor(Attributes.View.souce, new AttributeProcessor<V>() {
            @Override
            public void handleValue(final V view, Value value) {
                String sourceb=null;
                Value va=null;
                try{
                    try {
                        sourceb= value.getAsObject().getAsString("source_name");
                        //.Statuselayout().showLoading();
                    }catch(Exception ex){

                    }
                    if(sourceb==null){
                        va=value;
                    }else{
                        va = ((AutoCompleteTextViewB) view).getViewManager().getContext().getdata_Source(value.getAsObject().getAsString("source_name"));
                    }
                    final Value  values=va;
                        Value ghh = va.getAsObject().get("Data_From");
                        // List<AbstractFlexibleItem> itt=new ArrayList<>();
                        final ProteusView.Manager.ActionEventViewForUto wer = new ProteusView.Manager.ActionEventViewForUto() {
                            @Override
                            public void sendEventA(@Nullable ObjectValue data, int typ, Object anotherdata) {

                            }

                            @Override
                            public void sendEventA(@Nullable ObjectValue data, int typ, String anotherdata) {

                            }

                            @Override
                            public void getresultsearchA(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

                            }

                            @Override
                            public void getFragmentA(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                            }
                        };
                        final IValuesData iop = new IValuesData() {
                            @Override
                            public void sendData(String datab, int typdata) {

                            }

                            @Override
                            public void setDataAdvanced(Map<String, List<AbstractFlexibleItem>> datresult, int typ) {
                                Iterator<Map.Entry<String, List<AbstractFlexibleItem>>> ddd = datresult.entrySet().iterator();
                                while (ddd.hasNext()) {
                                    Map.Entry<String, List<AbstractFlexibleItem>> ddert = ddd.next();
                                    if (ddert.getKey().equals("main")) {
                                        OOverIttem cc = (OOverIttem) ddert.getValue().get(0);
                                        if (((AutoCompleteTextViewB) view).getAdapter() == null) {

                                            flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(), android.R.layout.simple_list_item_1, ddert.getValue(), ((AutoCompleteTextViewB) view).getViewManager().getContext().getInflater(), ((AutoCompleteTextViewB) view), cc.getWith(), cc.Usemul());//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);

                                            ((AutoCompleteTextViewB) view).setAdapter(mnbb);
                                        }
                                    } else {
                                       /* if(this.mListItemsSer==null) {
                                            this.mListItemsSer = ddert.getValue();
                                        }else {
                                            this.mListItemsSer.addAll(ddert.getValue());

                                        }*/
                                    }

                                }

                                //   final FlexibleAdapter hv = (FlexibleAdapter) view.getAdapter();
                                //  hv.onLoadMoreComplete(datresult);

                            }
                        };

                        boolean found = false;
                        try {
                            Value ff = value.getAsObject().get("on_select_item");

                            if (ff.isNull()) {
                                found = false;
                            } else {
                                if (ff != null) {

                                    found = true;
                                }

                            }
                        } catch (Exception ex) {


                        }

                        final boolean fon = found;
                        final Value v = ghh.getAsObject().getAsArray("Set_Data");
                        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View viewv, int i, long l) {
                                try {
                                    AbstractFlexibleItem tru = (AbstractFlexibleItem) adapterView.getItemAtPosition(i);

                                    OOverIttem kjnm = (OOverIttem) tru;
                                    ObjectValue obj = kjnm.getdataa().getAsObject();
                                    if (fon) {
                                        ((AutoCompleteTextViewB) view).getViewManager().getContext().getAllEven("Set_Data_From_View_To_View").call(view.getContext(), ((AutoCompleteTextViewB) view).getViewManager().getContext().getActvityAllt(), values, 1, ((AutoCompleteTextViewB) view), v, obj);
                                    } else {

                                        ((AutoCompleteTextViewB) view).getViewManager().getContext().getAllEven("Set_Data_Only").call(view.getContext(), ((AutoCompleteTextViewB) view).getViewManager().getContext().getActvityAllt(), values, 0, ((AutoCompleteTextViewB) view), v, obj);

                                    }
                                    // String dataame = ((AutoCompleteTextViewB) view).getTag(R.id.tagWhenClickItem).toString();
                                    Gson gg = new Gson();
                                    // String reselts = dataame.replace('#', '"');
                                   /* Type type = new TypeToken<List<DataValueSelect>>() {

                                    }.getType();
                                    List<DataValueSelect> kmn = gg.fromJson(reselts, type);
                                    for (int ii = 0; ii < kmn.size(); ii++) {

                                        kmn.get(ii).setDataGet(obj.getAsString(kmn.get(ii).getDataGet()));


                                    }

                                    Gson vbc = new Gson();*/
                                    //  Log.i("0000",);

                                    // uuip.triggerAdapter(9, false, "Select_item", vbc.toJson(kmn), null, ((AutoCompleteTextViewB) view));
                                } catch (Exception ex) {

                                }


                            }
                        });

                        view.setThreshold(1);
                        loadalltegret(iop, wer, ((AutoCompleteTextViewB) view), 0, 0, ghh);
                        //view.setAdapter(AAadpterme.newInstaince(itt,ghh,((AutoCompleteTextViewB) view)));

                    }catch(Exception ex){

            }
                    }
            public void loadalltegret(IValuesData vc , ProteusView.Manager.ActionEventViewForUto dd, ProteusView infl, int numberreload, int counrtnumber, Value v){

                Gson bbc=new Gson();
//Layout ret= infl.getViewManager().getContext().getLayout()

                Value getval=v;//this.lay.extras.get("Data_From");

    /*String ttrt[]=new String[]{apiurl,apimethod,apibody,apiData,apiheader,apimequary,keyfromresponse};
    String datv=bbc.toJson(ttrt);*/
                try {
                    Value countt=new Primitive(numberreload);
                    Value tot=new Primitive(counrtnumber);

                    infl.getViewManager().getContext().getAllEven("Data_From").callToRecycleview(infl.getAsView().getContext(),

                            infl.getViewManager().getContext().getActvityAllt(), getval, 0, infl, vc, dd,countt,tot);


                    // this.infl.getViewManager().getContext().getCallback().onEventAdapter(15550, datv, String.valueOf(numberreload),null , infl);

                    // this.infl.getViewManager().getContext().getCallback().onEventAdapter(3550, true, String.valueOf(0), String.valueOf(numberreload),null, null,null);
                }catch (Exception ex){

                }
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
            addAttributeProcessor(ATTRIBUTE_ADAPTER, new AttributeProcessor<V>() {


            @Override
            public void handleValue(final V view, final Value value) {
                if (value.isObject()) {
                    String type = value.getAsObject().getAsString(ATTRIBUTE_TYPE);
                    String typp="0";
                    try {
                        typp = ((AutoCompleteTextViewB) view).getTag(R.id.istree).toString();
                    }catch (Exception ex){

                    }
                    // String typp = value.getAsObject().getAsString("isTree");
                    // String typp="1";
                    if (type != null) {


                        //  Gson gg = new Gson();
                        // String typev = value.getAsObject().getAsString("or");//oritation
                        //  Log.i("hhhhhhhhhh", gg.toJson(value.getAsObject().));//.getAsObject().toString());
                        final String typex = "kk"; //value.getAsObject().getAsString("tname");
                        boolean useMultiple = false;
                        boolean useOfline = false;
                        List<modeltypeview> temppxm = new ArrayList<>();
                        String valuu = "[]";


                        ObjectValue anima = value.getAsObject().getAsObject("animation");
                        try {
                            Gson gsonn = new Gson();

                            useOfline = anima.getAsBoolean("a_use_offline");
                            ObjectValue usemultiple = value.getAsObject().getAsObject("UseMultiple");


                            useMultiple = usemultiple.getAsBoolean("a_enable");
                            valuu = usemultiple.getAsString("a_View").replace('#', '"');
//JSONObject hk=new JSONObject(valuu);

                            //  Log.i("9988xxm",valuu);// gsonn.toJson(hk.getJSONObject("Value")));//.get("v_Name").toString().get(cx)..toString().opt(0)));

                            ;

                            //  Log.i("9988xx",gsonn.toJson(jkm));
                            Type typez = new TypeToken<List<modeltypeview>>() {

                            }.getType();
                            temppxm = gsonn.fromJson(valuu, typez);

                        } catch (Exception ex) {
                            //  Log.i("9988",ex.getMessage());
                        }
                        Gson gsonnx = new Gson();
                        // Log.i("9988",gsonnx.toJson(temppxm));
                        view.setTag(R.id.useMultipl, temppxm);
                        view.setTag(R.id.useMultiplenb, useMultiple);
                        final boolean useMultiplex = useMultiple;
                        final boolean useof = useOfline;
                        final List<modeltypeview> temppxmx = temppxm;
                        final Integer numberload = anima.getAsInteger("CountItem");


                        //   Log.i("6666", ((AutoCompleteTextViewB) view).manager.findViewById("bandar").getId()+"gg");
                        //  ObjectValue data = ;
                        String nametypData = "no";
                        ObjectValue data = ((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData();
                        Iterator<Map.Entry<String, Value>> vvk = ((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData().entrySet().iterator();
                        while (vvk.hasNext()) {
                            Map.Entry<String, Value> ddert = vvk.next();
                            nametypData = ddert.getKey();
                        }


                        final List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
                        // final List< OOverIttem> mItemss = new ArrayList<OOverIttem>();
                        //   anotherAdapter iiop=new anotherAdapter(value.getAsObject());


                        try {


                            ProteusContext contextv = (ProteusContext) view.getContext();

                            // ObjectValue datax = ((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData();
                            // data.entrySet().clear();
                            Iterator<Map.Entry<String, Value>> vv = data.entrySet().iterator();
                            while (vv.hasNext()) {

                                Map.Entry<String, Value> ddert = vv.next();

                                // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {

                                    OOverIttem ioppp = new OOverIttem(temppxm, useMultiple, cx, typex, value.getAsObject(), contextv.getInflater(), ddert.getValue().getAsArray().get(cx)).withDescription(temppxm.get(0).getV_Name()).WithMutlip(temppxm);

                                    mItemss.add(ioppp);

                                    //   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

                                }
                            }
                            Gson g = new Gson();


                        } catch (Exception ex) {


                        }


                        view.setTag(R.id.Objectlayout, value.getAsObject());
                        final String keyy = view.getTag(R.id.tagfirstload).toString();
                        final Integer IDrecycleview = view.getId();

                        final Value mVal = value;

                        //  FlexibleAdapter.useTag("OverallAdapter");
                        flexAdapterrrr mnbb = new flexAdapterrrr(view.getContext(),android.R.layout.simple_list_item_1,mItemss,((AutoCompleteTextViewB) view).getViewManager().getContext().getInflater(),((AutoCompleteTextViewB) view),temppxm,useMultiplex);//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);

                        //fdd.add(adapterFactory.create(type, (AutoCompleteTextViewB) view, value.getAsObject()));

                        long INITIAL_DELAY_300 = 300L;

                        //mRecyclerView = getView().findViewById(R.id.recycler_view);
                        // view.setItemViewCacheSize(0); //Setting ViewCache to 0 (default=2) will animate items better while scrolling down+up with LinearLayout



/*try {
    view.setText(view.getAdapter().getItem(3).toString(), false);
}catch (Exception ex){

}*/
                        final String finalNametypData = nametypData;
                        final EventProcessor uuip = new EventProcessor() {


                            @Override
                            public void setOnEventListener(View view, Value value) {

                            }

                            @Override
                            public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view, EventProcessor proces, String[] somedsta) {
                                super.triggerAdapter(typ, withtage, Tagv, event, value, view, proces, somedsta);

                                if (typ == 51) {

                                    if (view.getAsView().getId() == IDrecycleview) {
                                        Gson hncv = new Gson();
                                        Type typex = new TypeToken<String[]>() {

                                        }.getType();
                                        String[] mnb = hncv.fromJson(Tagv, typex);
                                        new AsyncTaskRunnerv(view, "0", proces, withtage, somedsta, useof).execute(mnb[0], mnb[1], mnb[2], mnb[3], mnb[4], mnb[5], mnb[6], mnb[7], mnb[8], mnb[9], mnb[10], mnb[11]);

                                        // Log.i("999", mnb[0]);
                                        //Log.i("999", Tagv);
                                    }
                                    // }

                                } else if (typ == 52) {


                                    if (withtage) {

                                        if (view.getAsView().getId() == IDrecycleview) {
                                            Gson gg = new Gson();

                                            //  Log.i("6666","88888888888888"+gg.toJson(value));

                                            //  Log.i("0x0x","999999999999999999999101010"+gg.toJson(view.getViewManager().getDataContext().getData().get(finalNametypData)));
                                            ObjectValue zz = new ObjectValue();
                                            zz.add(keyy, value.get("s1"));
                                            //  Log.i("6666", "88888888888888" + gg.toJson(view.getViewManager().getDataContext().getData().get("items")));
                                            if (gg.toJson(view.getViewManager().getDataContext().getData().get(finalNametypData)).equals("{}")) {

                                                // Log.i("0x0x","999999999999999999999101010xxxxx");
                                                view.getViewManager().update(zz);

                                            }

                                        }

                                    } else {
                                        // Log.i("0x0x","999999999999999999999101010");
                                        if (view.getAsView().getId() == IDrecycleview) {
                                          //  FlexibleAdapter hvk = (FlexibleAdapter) ((AutoCompleteTextViewB) view).getAdapter();
                                            Log.i("000", "$$$");
                                            List<OOverIttem> mItemssk = new ArrayList<OOverIttem>();
                                            ObjectValue zz = new ObjectValue();
                                            zz.add(keyy, value.get("s1"));
                                            //  ObjectValue data = zz;//((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData();

                                            Gson x = new Gson();
                                            // Log.i("000", "$$$" + x.toJson(data));
                                            ProteusContext contextv = (ProteusContext) view.getViewManager().getContext();
                                            int counnnt = 0;
                                            Array uu = new Array();

                                            Iterator<Map.Entry<String, Value>> vv = zz.entrySet().iterator();
                                            while (vv.hasNext()) {
                                                Map.Entry<String, Value> ddert = vv.next();
                                                counnnt = ddert.getValue().getAsArray().size();
                                                Gson gg = new Gson();
                                                //  Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                                                // Iterator<Value> vvx = ddert.getValue().getAsArray().iterator();
                                                for (int cx = 0; cx < ddert.getValue().getAsArray().size(); cx++) {

                                                    // Log.i("000", ddert.getValue().getAsArray().size()+"$$$0000" + gg.toJson(ddert.getValue()));
                                                    // uu.add(ddert.getValue().getAsArray().get(cx));

                                                    //   mItems.add(new anotherAdapter(ddert.getValue().getAsArray().get(cx-1).getAsObject(), contextv.getInflater(), typex));

                                                    Integer iom = ((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData().get(finalNametypData).getAsArray().size();//.add(ddert.getValue().getAsArray().size();
                                                    OOverIttem ioppp = new OOverIttem(temppxmx, useMultiplex, iom + 1, "no", mVal.getAsObject(), contextv.getInflater(), ddert.getValue().getAsArray().get(cx)).WithMutlip(temppxmx);
                                                   // assert hvk != null;
                                                    // hvk.addItem(ioppp);
                                                    ((AutoCompleteTextViewB) view).getViewManager().getDataContext().getData().get(finalNametypData).getAsArray().add(ddert.getValue().getAsArray().get(cx));
                                                    mItemssk.add(ioppp);
                                                    // mmArr.add();

                                                }
                                                if (counnnt == 0) {
                                                   // assert hvk != null;
                                                 //   hvk.notifyDataSetChanged();

  /*  AutoCompleteTextViewB hh=(AutoCompleteTextViewB)view;
    hh.setAdapter(hvk);*/
                                                    // hvk.removeAllScrollableFooters();
                                                   // hvk.setEndlessProgressItem(null);
                                                   // hvk.notifyDataSetChanged();
                                                } else {
                                                    // FlexibleAdapter hv = (FlexibleAdapter) ((AutoCompleteTextViewB) view).getAdapter();
                                                  /*  assert hvk != null;
                                                    hvk.notifyDataSetChanged();
                                                    hvk.removeAllScrollableFooters();
                                                    hvk.onLoadMoreComplete(mItemssk);
                                                    hvk.notifyDataSetChanged();*/
                                                }
                                                //


                                            }
                                        }
                                    }


                                               /*  }else{
                                                     check=false;
                                                 }*/


                                  /*   for (int cx = 0; cx < mItemssk.size(); cx++) {


                                         //   mmArr.add(mItemssk.get(cx).getdataa());
                                     }
*/
                                    // h.notifyDataSetChanged();
                                    // if(check) {

                                    //  h.onLoadMoreComplete(null);
                                    //  }


                                    //  Log.i("999", Tagv);
                                }
                            }

                            @Override
                            public void triggerAdapter(int typ, boolean withtage, String Tagv, String event, ObjectValue value, ProteusView view) {
                                super.triggerAdapter(typ, withtage, Tagv, event, value, view);


                            }


                        };



                        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View viewv, int i, long l) {
try {
    AbstractFlexibleItem tru = (AbstractFlexibleItem) adapterView.getItemAtPosition(i);

    OOverIttem kjnm = (OOverIttem) tru;
    ObjectValue obj = kjnm.getdataa().getAsObject();
    String dataame = ((AutoCompleteTextViewB) view).getTag(R.id.tagWhenClickItem).toString();
    Gson gg = new Gson();
    String reselts = dataame.replace('#', '"');
    Type type = new TypeToken<List<DataValueSelect>>() {

    }.getType();
    List<DataValueSelect> kmn = gg.fromJson(reselts, type);
    for (int ii = 0; ii < kmn.size(); ii++) {

        kmn.get(ii).setDataGet(obj.getAsString(kmn.get(ii).getDataGet()));


    }

    Gson vbc = new Gson();
    //  Log.i("0000",);

    uuip.triggerAdapter(9, false, "Select_item", vbc.toJson(kmn), null, ((AutoCompleteTextViewB) view));
}catch (Exception ex){

}
                               /* ProteusView googlePlace =(ProteusView) viewv; //adapterView.getItemAtPosition(i);//.getItemAtPosition(i).toString();//.getAdapter().getItem(i);
                                // ObjectValue ffert= (ObjectValue)googlePlace.getAsView().getTag(R.id.tageSetvalue);
                                Gson bb=new Gson();
                                Iterator<Map.Entry<String, Value>> vv = googlePlace.getViewManager().getDataContext().getData().entrySet().iterator();
                                int count=0;

                                while (vv.hasNext()) {
                                    Map.Entry<String, Value> uu=vv.next();
                                    count=count+1;
                                    if(count==1){


                                        EventProcessor uuipp = new EventProcessor() {
                                            @Override
                                            public void setOnEventListener(View view, Value value) {

                                            }
                                        }; //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                                        String dataame=     ((AutoCompleteTextViewB) view).getTag(R.id.tagWhenClickItem).toString();
                                        Gson gg=new Gson();
                                        String reselts=dataame.replace('#','"');
                                        Type type = new TypeToken<List<DataValueSelect>>() {

                                        }.getType();
                                        List<DataValueSelect> kmn = gg.fromJson(reselts, type);
                                        SetallValue(uu.getValue(),kmn);

                                        String datajs=gg.toJson(kmn);

                                        uuipp.triggerAdapter(9, false, "Select_item", datajs, null, ((AutoCompleteTextViewB) view));

                                    }

                                }
*/
                                //d_groupID=googlePlace.getID_group();

                            }
                        });

                        view.setThreshold(1);
                        view.setAdapter(mnbb);
                        final String[] ggg = new String[]{"0"};

                        //  Log.i("iioopp","uuuuuuuu");
                        uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, ggg);

                        ProteusView.Manager.ActionEventView Act = new ProteusView.Manager.ActionEventView() {
                            @Override
                            public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

                            }

                            @Override
                            public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {
                                String[] fdc = new String[]{anotherdata};
                                char k = '"';
                                if (typ == 1) {//التحديث
                                    String uiopp = "{}";
                                    uiopp = uiopp.replace('#', k);
                                    ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(view.getContext());
                                    Gson gsonn = new GsonBuilder()
                                            .registerTypeAdapterFactory(adapter)
                                            .create();
                                    Type type = new TypeToken<Value>() {

                                    }.getType();
                                    Value tempp = gsonn.fromJson(uiopp, type);
                                    ObjectValue zz = new ObjectValue();
                                    // zz.add(keyy, tempp.getAsObject().get("s1"));

                                    ((AutoCompleteTextViewB) view).getViewManager().update(tempp.getAsObject());


                                    uuip.triggerAdapter(50, true, String.valueOf(0), String.valueOf(numberload), null, (ProteusView) view, uuip, fdc);
                                }

                                if (typ == 2) {//التحديث
                                    //   Log.i("0x0x","999999999999999999999");
                                    uuip.triggerAdapter(53, false, "0", anotherdata, null, (ProteusView) view, uuip, fdc);


                                }

                            }

                            @Override
                            public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {
                              //  FlexibleAdapter hv = (FlexibleAdapter) ((AutoCompleteTextViewB) view).getAdapter();
//إرجاع قيمة البحث

                                view.dismissDropDown();

                            }

                            @Override
                            public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {

                            }
                        };


                        //((AutoCompleteTextViewB) view).setViewManager().getViewManager().setActionEventView(Act);
                        if (((AutoCompleteTextViewB) view).manager.getActionEventView() == null) {
                            ((AutoCompleteTextViewB) view).manager.setActionEventView(Act);
                            //((AutoCompleteTextViewB) view).getViewManager().setActionEventView(Act);

                        }


                        // mRecyclerView.setLayoutManager(createNewStaggeredGridLayoutManager());
                        // mRecyclerView.setAdapter(mAdapter);
                               /* view.setHasFixedSize(true); //Size of RV will not change
                                FlexibleItemDecoration mItemDecoration;
                                mItemDecoration = new FlexibleItemDecoration(view.getContext())

                                        .withOffset(8) // This helps when top items are removed!!
                                        .withEdge(true);
                                view.addItemDecoration(mItemDecoration);*/

                        // After Adapter is attached to RecyclerView
                        //   mnbb.setLongPressDragEnabled(      anima.getAsBoolean("a_drage"));


                              /*  ScrollableLayoutItem scrollHeader = new ScrollableLayoutItem("SLI");
                                scrollHeader.setTitle("Endless Scrolling");
                                scrollHeader.setSubtitle("...with ScrollableHeaderItem");
                              mnbb.addScrollableHeader(scrollHeader);*/

//mnbb.onLoadMoreComplete();
/*mnbb.setNotifyMoveOfFilteredItems(true);
mnbb.setNotifyChangeOfUnfilteredItems(true);
mnbb.setFilter("الاصول الثابتة");*/

                    }

                }






            }
            public  void  SetallValue(Value uub,List<DataValueSelect> damy){
                if(uub.isArray()){



                } else if(uub.isObject()){

                    Iterator<Map.Entry<String, Value>> vv = uub.getAsObject().entrySet().iterator();
                    int count=0;

                    while (vv.hasNext()) {
                        Map.Entry<String, Value> uu = vv.next();
                        setval(uu.getKey(),uu.getValue().toString(),damy);
                    }
                }
            }
            public  void setval(String keynam,String valuu,List<DataValueSelect> kj){
                for (int xxc = 0; xxc < kj.size(); xxc++) {

                    if(kj.get(xxc).getDataGet().equals(keynam)){
                        kj.get(xxc).setDataGet(valuu);

                    }

                }

            }
            public List<AbstractFlexibleItem> getdataIt(Resources resources){
                List<AbstractFlexibleItem> mItems=new ArrayList<>();

                mItems.add(new OverallItem(R.id.nav_selection_modes, resources.getString(R.string.selection_modes))
                        .withDescription(resources.getString(R.string.selection_modes_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_select_all_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_filter, resources.getString(R.string.filter))
                        .withDescription(resources.getString(R.string.filter_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_filter_outline_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_animator, resources.getString(R.string.animator))
                        .withDescription(resources.getString(R.string.animator_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_chart_gantt_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_headers_and_sections, resources.getString(R.string.headers_sections))
                        .withDescription(resources.getString(R.string.headers_sections_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_sections_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_expandable_sections, resources.getString(R.string.expandable_sections))
                        .withDescription(resources.getString(R.string.expandable_sections_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_expandable_grey_600_24dp)));

                mItems.add(new OverallItem(R.id.nav_multi_level_expandable, resources.getString(R.string.multi_level_expandable))
                        .withDescription(resources.getString(R.string.multi_level_expandable_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_expandable_grey_600_24dp)));

                mItems.add(new OverallItem(R.id.nav_endless_scrolling, resources.getString(R.string.endless_scrolling))
                        .withDescription(resources.getString(R.string.endless_scrolling_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_playlist_play_grey600_24dp)));

                //Special Use Cases
                mItems.add(new OverallItem(R.id.nav_db_headers_and_sections, resources.getString(R.string.databinding))
                        .withDescription(resources.getString(R.string.databinding_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_link_grey_600_24dp)));

                mItems.add(new OverallItem(R.id.nav_model_holders, resources.getString(R.string.model_holders))
                        .withDescription(resources.getString(R.string.model_holders_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_select_inverse_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_instagram_headers, resources.getString(R.string.instagram_headers))
                        .withDescription(resources.getString(R.string.instagram_headers_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_instagram_grey600_24dp)));


                mItems.add(new OverallItem(R.id.nav_instagram_headers, resources.getString(R.string.instagram_headers))
                        .withDescription("هههههههههههههههههههههههههه")
                        .withIcon(resources.getDrawable(R.drawable.ic_instagram_grey600_24dp)));



                mItems.add(new OverallItem(R.id.nav_staggered, resources.getString(R.string.staggered_layout))
                        .withDescription(resources.getString(R.string.staggered_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_dashboard_grey600_24dp)));

                mItems.add(new OverallItem(R.id.nav_viewpager, resources.getString(R.string.viewpager))
                        .withDescription(resources.getString(R.string.viewpager_description))
                        .withIcon(resources.getDrawable(R.drawable.ic_view_carousel_grey600_24dp)));


                return mItems;
            }
            private  List<HeaderItem> createList(int size, int headers) {

                List<HeaderItem> vvc=new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    HeaderItem ffedd=new HeaderItem(String.valueOf(i));
                    ffedd.setTitle("item"+String.valueOf(i));
                    ffedd.setSubtitle(String.valueOf(i));
                    // SimpleItem gg=new SimpleItem(String.valueOf(i),ffedd);
                    vvc.add(ffedd);
                }


                return vvc;
            }
            class AsyncTaskRunnerv extends AsyncTask<String, String, String> {

                private String resp;
                boolean tt=false;

                // ProgressDialog progressDialog;
                String bbaa="0";
                String bbaat="0";
                public ProteusView protvv;
                public   String prograssnn;
                public EventProcessor uuip;
                public  boolean checkk;
                public  String[] anoth;
                public boolean useoffline;
                AsyncTaskRunnerv(ProteusView myview, String prograssnnm, EventProcessor uuipp,boolean checkkm,String[] anothh,boolean useofflinee) {
                    this.protvv = myview;
                    this.prograssnn=prograssnnm;
                    this.uuip=uuipp;
                    this.checkk=checkkm;
                    this.anoth=anothh;
                    this.useoffline=useofflinee;

                }

                @Override
                protected String doInBackground(final String... params) {
                    // publishProgress("Sleeping..."); // Calls onProgressUpdate()
                    try {
                        //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                        //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);

                        String URL=params[0];
                        String Postmethod=params[1];
                        String requestbody=params[2];
                        final String refresh=params[3];
                        final String without=params[4];

                        Map<String,Object> hedermap=new HashMap<>();//Map<String, Object>();
                        HashMap<String,String> quarymap=new HashMap<>();//HashMap<String, String>();
                        try {
                            String heder=params[8];
                            String quary=params[9];
                            //  Log.i("4444444",heder);
                            Gson hnb = new Gson();
                            Type type = new TypeToken<List<hedaerOrQuary>>() {

                            }.getType();
                            List<hedaerOrQuary> hedde = hnb.fromJson(heder, type);
                            for (int cx = 0; cx < hedde.size(); cx++) {
                                hedermap.put(hedde.get(cx).getKeyName(),hedde.get(cx).getKeyValue());
                                //  Log.i("44444446555",hedde.get(cx).getKeyName());
                            }
                            List<hedaerOrQuary> qur = hnb.fromJson(quary, type);
                            for (int cx = 0; cx < qur.size(); cx++) {
                                quarymap.put(qur.get(cx).getKeyName(),qur.get(cx).getKeyValue());

                            }

                            //  dd.put()
                        }catch (Exception ex){
//Log.i("4444444vvv",ex.getMessage());

                        }

                        String contettyp="application/json; charset=UTF-8";
                        String userAgentt="fromandroid";
                        final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);
                        RequestBody requestBodyBinary = null;

                        requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                        // sendreq(params[0],params[1],params[2]);
                        Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary,hedermap,quarymap):Retrofitapi.GetMethod(URL,hedermap,quarymap);
                        call.enqueue(new Callback<ResponseBody>() {


                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                try {
                                    assert response.body() != null;

                                    //   showResult(response.body().string(),protvv.getAsView());
                                    String x="mydesin";

                                    if(response.isSuccessful()) {

                                        String kk= response.body().string();
                                        // assert response.errorBody() != null;
                                        try {
                                            String responseKey = params[11];

                                            if(!responseKey.equals("0")) {
                                                JSONObject js = new JSONObject(kk);
                                                kk = js.get(responseKey).toString();
                                            }
                                        }catch (Exception ex){

                                        }
                                        String k="{s1:"+kk+"}";
                                        if(refresh.equals("1")) {
                                            try {

                                                if(useoffline) {
                                                    String mng = ((AutoCompleteTextViewB) protvv).getTag(R.id.tag3).toString();
                                                    ScriptModel g = new ScriptModel(0, k, mng);
                                                    DatabaseHelper db_operations;
                                                    db_operations = new DatabaseHelper(((AutoCompleteTextViewB) protvv).getContext());
                                                    db_operations.insert(g);
                                                }
                                            }catch (Exception ex){

                                            }

                                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                            Gson gsonn = new GsonBuilder()
                                                    .registerTypeAdapterFactory(adapter)
                                                    .create();
                                            Type type = new TypeToken<Value>() {

                                            }.getType();
                                            Value tempp = gsonn.fromJson(k, type);
                                            uuip.triggerAdapter(52, checkk, k, prograssnn, tempp.getAsObject(), ((AutoCompleteTextViewB) protvv),uuip,anoth);


                                            //  loadrefd();
                                            // aooldder(without,container, tempp.getAsObject());
                                        }else {
                                            //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                            // loadrefd();

                                            // masss.showmessage(k);

                                        }
                                        String   prograssnam="0";
                                        try {
                                            prograssnam =anoth[0];//enabprograss
                                        }catch (Exception ex){

                                        }
                                        if(!prograssnam.equals("0")) {
                                            // JSONObject js = new JSONObject(kk);
                                            ((AutoCompleteTextViewB) protvv).manager.getActionEventView().sendEvent(null,2,prograssnam);
                                        }

                                    }else{
                                        try {
                                            assert response.errorBody() != null;


                                            String kk= response.errorBody().string();
                                            // assert response.errorBody() != null;
                                            try {
                                                String responseKey = params[11];

                                                if(!responseKey.equals("0")) {
                                                    JSONObject js = new JSONObject(kk);
                                                    kk = js.get(responseKey).toString();
                                                }
                                            }catch (Exception ex){

                                            }


                                            String k="{s1:"+kk+"}";
                                            if(refresh.equals("1")) {
                                                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                                Gson gsonn = new GsonBuilder()
                                                        .registerTypeAdapterFactory(adapter)
                                                        .create();
                                                Type type = new TypeToken<Value>() {

                                                }.getType();
                                                Value tempp = gsonn.fromJson(k, type);
                                                uuip.triggerAdapter(52, checkk, k, prograssnn, tempp.getAsObject(), ((AutoCompleteTextViewB) protvv),uuip,anoth);


                                                //  loadrefd();
                                                // aooldder(without,container, tempp.getAsObject());
                                            }else {
                                                //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                                // loadrefd();

                                                // masss.showmessage(k);

                                            }
                                            // masss.showmessage(ex.getMessage());

                                            String   prograssnam="0";
                                            try {
                                                prograssnam =anoth[0];//enabprograss
                                            }catch (Exception ex){

                                            }
                                            if(!prograssnam.equals("0")) {
                                                // JSONObject js = new JSONObject(kk);
                                                ((AutoCompleteTextViewB) protvv).manager.getActionEventView().sendEvent(null,2,prograssnam);
                                            }

                                            //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                            // savetoref(x, response.errorBody().string());
                                            //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                        }catch (IOException ex){

                                            //   uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                            Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                        }
                                    }


                                } catch (Exception ex) {

                                    //  uuip.triggerAdapter(20, false, ex.getMessage(), prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                    Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                    // loadrefd();
                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                //  stoptimertask();

                                // Log.i("9999",t.getMessage()+"لا يوجد إتصال بالشبكة");
                                if(t.getMessage().startsWith("Unable to resolve host")){
                                    try {

                                        if(useoffline) {
                                            String mng = ((AutoCompleteTextViewB) protvv).getTag(R.id.tag3).toString();
                                          //  FlexibleAdapter uk=(FlexibleAdapter) ((AutoCompleteTextViewB) protvv).getAdapter();


                                                ScriptModel g = new ScriptModel(0, "no", mng);
                                                DatabaseHelper db_operations;
                                                db_operations = new DatabaseHelper(((AutoCompleteTextViewB) protvv).getContext());
                                                List<ScriptModel> x = db_operations.getAllNotes(g);
                                                String val = x.get(0).getContent();
                                                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                                Gson gsonn = new GsonBuilder()
                                                        .registerTypeAdapterFactory(adapter)
                                                        .create();
                                                Type type = new TypeToken<Value>() {

                                                }.getType();
                                                Value tempp = gsonn.fromJson(val, type);
                                                uuip.triggerAdapter(52, checkk, val, prograssnn, tempp.getAsObject(), ((AutoCompleteTextViewB) protvv), uuip, anoth);

                                        }else {
                                            uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                        }
                                    }catch (Exception ex){

                                    }

                                }else {
                                    uuip.triggerAdapter(20, false, t.getMessage() + "لا يوجد إتصال بالشبكة", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                }
                                // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                                // loadrefd();
                                // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                                //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                            }
                        });


                    } catch (Exception ex) {

                        Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                        // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));
                        //  loadrefd();
                        // masss.showmessage(ex.getMessage());
                        // ex.getMessage();

                    }
                    return bbaa;
                }
                private void showResult(String result,View c) {
                    new AlertDialog.Builder(c.getContext())
                            .setMessage(result)
                            .setCancelable(true)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create()
                            .show();
                }

                @Override
                protected void onPostExecute(String result) {
                    try {

                    }catch (Exception e){

                        e.printStackTrace();
                    }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

                    // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
                }


                @Override
                protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
                }


                @Override
                protected void onProgressUpdate(String... text) {
                    // finalResult.setText(text[0]);

                }
            }

            class VH extends RecyclerView.ViewHolder {
                // TextView tvLoading;

                public VH(View itemView) {
                    super(itemView);
                    // tvLoading = (TextView) itemView.findViewById(R.id.tv_loading_text);
                }
            }
            @Override
            public void handleResource(V view, Resource resource) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {
                throw new IllegalArgumentException("Recycler View 'adapter' expects only object values");
            }
        });

        addAttributeProcessor(ATTRIBUTE_LAYOUT_MANAGER, new AttributeProcessor<V>() {

            @Override
            public void handleValue(final V view, Value value) {
                if (value.isObject()) {
                    String type = value.getAsObject().getAsString(ATTRIBUTE_TYPE);
                    String usere = value.getAsObject().getAsString(Attributes.View.Recyle_use_reload);
               //     RecyclerView.LayoutManager layoutManager = layoutManagerFactory.create(type, (AutoCompleteTextViewB) view, value.getAsObject());

                    assert usere != null;
                    if(usere.equals("1")){
                        if (type != null) {


                        }

                    }
                  //  view.setLayoutManager(layoutManager);
                }
            }

            public  void showprograssbarr(ProteusView view,String countItem,String prograssnam,EventProcessor uuipx) throws MalformedURLException {



                String useapi =String.valueOf(view.getAsView().getTag(R.id.Recleapi_use));
                if(useapi.equals("1")) {

                    String urldat = String.valueOf(view.getAsView().getTag(R.id.Recleapi_url));
                    String resul[] = GlobalClass.getBaseURL(urldat);

                  // GlobalClass.BseUrl2 = resul[0];
                    String methodtap = String.valueOf(view.getAsView().getTag(R.id.Recleapi_Method));
                    String requestbody = String.valueOf(view.getAsView().getTag(R.id.Recleapi_body));
                    String mmn = "'";
                    char d = mmn.charAt(0);
                    String mmnd = "@";
                    char dd = mmnd.charAt(0);
                    requestbody = requestbody.replace('#', '"').replace(dd, d);
                    String bbb = "[]";
                    try {
                        bbb = String.valueOf(view.getAsView().getTag(R.id.tag2));

                        CharSequence oopp=countItem;

                        bbb = bbb.replace('#', '"').replace(dd, d).replace("$",oopp);



                        new AsyncTaskRunner(view,prograssnam,uuipx).execute(resul[1],methodtap,bbb,"1","0");

                        // JSONObject js=new JSONObject(datab);
                        // Gson hnn = new Gson();
                        // bbb=hnn.toJson(datab);
                    } catch (Exception ex) {


                    }
                    // checknull = false;
                    // Log.i("ProteusEventWithTag", bbb);
      /*  Gson hn = new Gson();
        Type type = new TypeToken<List<DataValueSelect>>() {

        }.getType();
        List<DataValueSelect> kmn = hn.fromJson(bbb, type);
*/
                    //   String typad = kmn.get(0).getUnitName();
        /*allunit = null;
        allunit = new ArrayList<resultData>();
        serchhview(container, kmn);
        for (int cxx = 0; cxx < allunit.size(); cxx++) {

            Log.i("ProteusEventWithTag", allunit.get(cxx).getDataGet());
            Log.i("ProteusEventWithTag", allunit.get(cxx).getUnitName());
            requestbody = requestbody.replace(allunit.get(cxx).getDataGet(), allunit.get(cxx).getUnitName());
        }*/
                    Log.i("ProteusEventWithTag", requestbody);
                }


            }

            class AsyncTaskRunner extends AsyncTask<String, String, String> {

                private String resp;
                boolean tt=false;

                // ProgressDialog progressDialog;
                String bbaa="0";
                String bbaat="0";
                public ProteusView protvv;
                public   String prograssnn;
                public EventProcessor uuip;
                AsyncTaskRunner(ProteusView myview, String prograssnnm, EventProcessor uuipp) {
                    this.protvv = myview;
                    this.prograssnn=prograssnnm;
                    this.uuip=uuipp;


                }

                @Override
                protected String doInBackground(final String... params) {
                    // publishProgress("Sleeping..."); // Calls onProgressUpdate()
                    try {
                        //.evaluate(dataview.getAsView().getContext(),data.get("0"),data.get("0"),0);

                        Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+this.prograssnn);
                        // uuip.triggerAdapter(5, false, "1", this.prograssnn, null, ((AutoCompleteTextViewB) protvv));


                        //  Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");
                        String URL=params[0];
                        String Postmethod=params[1];
                        String requestbody=params[2];
                        final String refresh=params[3];
                        final String without=params[4];
                        String contettyp="application/json; charset=UTF-8";
                        String userAgentt="fromandroid";
                        final retrofit_dynimcic Retrofitapi = retrofit_dynimic.getRetrofit().create(retrofit_dynimcic.class);
                        RequestBody requestBodyBinary = null;

                        requestBodyBinary = RequestBody.create(MediaType.parse("application/json"),requestbody);

                        // sendreq(params[0],params[1],params[2]);
                        Call<ResponseBody> call = Postmethod.toLowerCase().equals("post")? Retrofitapi.PostMethod(URL,requestBodyBinary):Retrofitapi.GetMethod(URL,requestBodyBinary);

                        call.enqueue(new Callback<ResponseBody>() {


                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                try {

                                    assert response.body() != null;
                                    // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii");
                                    String x="mydesin";

                                    if(response.isSuccessful()) {

                                        String jm= "{s1:"+response.body().string()+"}";

                                        if(refresh.equals("1")) {
                                            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                            Gson gsonn = new GsonBuilder()
                                                    .registerTypeAdapterFactory(adapter)
                                                    .create();
                                            Type type = new TypeToken<Value>() {

                                            }.getType();
                                            Value tempp = gsonn.fromJson(jm, type);

                                            //   Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+jm);

                                            //  uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((AutoCompleteTextViewB) protvv));

                                            // aooldder(without,container, tempp.getAsObject());
                                        }else{

                                            //  uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                            //  masss.showmessage(jm);
                                        }


                                    }else{
                                        try {
                                            assert response.errorBody() != null;
                                            String k="{s1:"+response.errorBody().string()+"}";
                                            if(refresh.equals("1")) {
                                                ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(protvv.getAsView().getContext());
                                                Gson gsonn = new GsonBuilder()
                                                        .registerTypeAdapterFactory(adapter)
                                                        .create();
                                                Type type = new TypeToken<Value>() {

                                                }.getType();
                                                Value tempp = gsonn.fromJson(k, type);

                                                // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiii"+k);


                                                //    uuip.triggerAdapter(5, false, "0", prograssnn, tempp.getAsObject(), ((AutoCompleteTextViewB) protvv));

                                                // aooldder(without,container, tempp.getAsObject());
                                            }else {
                                                //uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));


                                                // masss.showmessage(k);

                                            }
                                            // masss.showmessage(ex.getMessage());



                                            //  masss.showmessage(k);
                                  /*  typ_message v=typ_message.messagrror;
                                    mess.customToast(k,v,true);*/
                                            // savetoref(x, response.errorBody().string());
                                            //  Log.i("dddmmmmmmmkkkkkkkkk", response.errorBody().string());
                                        }catch (IOException ex){
                                            // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                            // Log.i("mm", "iiiiiiiiiiiiiiiiiiiiijjji"+ex.getMessage());
                                        }
                                    }


                                } catch (Exception ex) {
                                    // uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                    // masss.showmessage(ex.getMessage());
                                    // stoptimertask();
                                }

                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                //  stoptimertask();
                                //  uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                                // masss.showmessage(t.getMessage()+"لا يوجد إتصال بالشبكة");
                                //  Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();


                            }
                        });


                    } catch (Exception ex) {
                        //   uuip.triggerAdapter(5, false, "0", prograssnn, null, ((AutoCompleteTextViewB) protvv));

                        // masss.showmessage(ex.getMessage());
                        // ex.getMessage();

                    }
                    return bbaa;
                }


                @Override
                protected void onPostExecute(String result) {
                    try {

                    }catch (Exception e){

                        e.printStackTrace();
                    }
           /* while(!tt) {
                try {
                    Thread.sleep(2000);
                    Log.d("tag", "Error -> توقف");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bbaat.equals("1")) {
                    Log.d("tag", "Error -> اكتمل");
                    tt = true;
                    break;
                }
            }*/
         /*  if(result.isEmpty()){
               Log.d("tag", "Error -> سعيد");

           }else{

               Log.d("tag", "Error -> علي");

           }*/

                    // execution of result of Long time consuming operation

        /*  while(!tt){
if(bbaa.equals("1")) {
    progressDialog.dismiss();
    //finalResult.setText(result);
}
           }*/
                }


                @Override
                protected void onPreExecute() {
           /* progressDialog = ProgressDialog.show(MainActivity.this,
                    "انتظر",
                    "يتم الان تحميل البيانات");*/
                }


                @Override
                protected void onProgressUpdate(String... text) {
                    // finalResult.setText(text[0]);

                }
            }
            @Override
            public void handleResource(V view, Resource resource) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }

            @Override
            public void handleAttributeResource(V view, AttributeResource attribute) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }

            @Override
            public void handleStyleResource(V view, StyleResource style) {
                throw new IllegalArgumentException("Recycler View 'layout_manager' expects only object values");
            }
        });

    }


}
