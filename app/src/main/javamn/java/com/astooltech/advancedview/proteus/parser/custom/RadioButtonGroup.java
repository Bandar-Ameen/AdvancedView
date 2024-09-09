package com.astooltech.advancedview.proteus.parser.custom;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.exceptions.ProteusInflateException;
import com.astooltech.advancedview.proteus.managers.ViewGroupManager;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.NestedBinding;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;
import java.util.Map;


public class  RadioButtonGroup<T extends RadioGroup> extends ViewTypeParser<T> {

    private static final String LAYOUT_MODE_CLIP_BOUNDS = "clipBounds";
    private static final String LAYOUT_MODE_OPTICAL_BOUNDS = "opticalBounds";
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }
    @NonNull
    @Override
    public String getType() {
        return "RadioGroup";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable RadioGroup parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new ViewGroupManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof ProteusRadioButtonGroup){
            SetGetFindTextInputLayoutRdio((ProteusRadioButtonGroup)view,data,typoper);
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

    private  void getwithanotheroper(ProteusRadioButtonGroup dt, DataValueSelect datb, int typoper){
        ProteusRadioButtonGroup  ccc = dt;
        if (typoper == 2) {

            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {

                    try {
                        ObjectValue val = datb.getAnotherDatat();
                        int xzc = dt.getCheckedRadioButtonId();
                        RadioButton ccv = (RadioButton) dt.findViewById(xzc);
                        String IDDdatx = ccv.getTag(R.id.tag3).toString();
                        datb.setDataGet(IDDdatx);


                        val.add("GetData", new Primitive(IDDdatx));
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
                        for (int cxx = 0; cxx < dt.getChildCount(); cxx++) {
                            try {
                                RadioButton ccv = (RadioButton) dt.getChildAt(cxx);
                                String IDDdatxx = ccv.getTag(R.id.tag3).toString();
                                String getdat = va.getAsString();
                                if (IDDdatxx.equals(getdat)) {

                                    ccv.setChecked(true);
                                }
                            }catch (Exception ex){

                            }
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

    private  void SetGetFindTextInputLayoutRdio( ProteusRadioButtonGroup  dt,DataValueSelect datb,int typoper) {
        if (typoper == 1) {
            boolean typActionname = true;//Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                String IDDdat = dt.getTag(R.id.tag3).toString();
                if (IDDdat.equals(datb.getIDUnit())) {
                    {



                        if(datb.getTypselect().equals("0")) {
                            int xzc = dt.getCheckedRadioButtonId();
                            RadioButton ccv = (RadioButton) dt.findViewById(xzc);
                            String IDDdatx = ccv.getTag(R.id.tag3).toString();
                            datb.setDataGet(IDDdatx);
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
                            for (int cxx = 0; cxx < dt.getChildCount(); cxx++) {
                                try {
                                    RadioButton ccv = (RadioButton) dt.getChildAt(cxx);
                                    String IDDdatxx = ccv.getTag(R.id.tag3).toString();
                                    String getdat = datb.getDataGet();
                                    if (IDDdatxx.equals(getdat)) {

                                        ccv.setChecked(true);
                                    }
                                }catch (Exception ex){

                                }
                            }

                        }


                                /*resultData c = new resultData(cx, IDDdatx,"@"+IDDdatx+"@");
                          }      allunit.add(c);*/

                    }
                }

            }

        }else {
            getwithanotheroper(dt,datb,typoper);

        }
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.RadioGroup.ClipChildren, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipChildren(value);
            }
        });

        addAttributeProcessor(Attributes.RadioGroup.ClipToPadding, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipToPadding(value);
            }
        });

        addAttributeProcessor(Attributes.RadioGroup.LayoutMode, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    if (LAYOUT_MODE_CLIP_BOUNDS.equals(value)) {
                        view.setLayoutMode(RadioGroup.LAYOUT_MODE_CLIP_BOUNDS);
                    } else if (LAYOUT_MODE_OPTICAL_BOUNDS.equals(value)) {
                        view.setLayoutMode(RadioGroup.LAYOUT_MODE_OPTICAL_BOUNDS);
                    }
                }
            }
        });

        addAttributeProcessor(Attributes.RadioGroup.SplitMotionEvents, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setMotionEventSplittingEnabled(value);
            }
        });

        addAttributeProcessor(Attributes.RadioGroup.Children, new AttributeProcessor<T>() {
            @Override
            public void handleBinding(T view, Binding value) {
                handleDataBoundChildren(view, value);
            }

            @Override
            public void handleValue(T view, Value value) {
                handleChildren(view, value);
            }

            @Override
            public void handleResource(T view, Resource resource) {
                throw new IllegalArgumentException("children cannot be a resource");
            }

            @Override
            public void handleAttributeResource(T view, AttributeResource attribute) {
                throw new IllegalArgumentException("children cannot be a resource");
            }

            @Override
            public void handleStyleResource(T view, StyleResource style) {
                throw new IllegalArgumentException("children cannot be a style attribute");
            }
        });
    }

    @Override
    public boolean handleChildren(T view, Value children) {
        ProteusView proteusView = ((ProteusView) view);
        ProteusView.Manager viewManager = proteusView.getViewManager();
        ProteusLayoutInflater layoutInflater = viewManager.getContext().getInflater();
        ObjectValue data = viewManager.getDataContext().getData();
        int dataIndex = viewManager.getDataContext().getIndex();

        if (children.isArray()) {
            ProteusView child;
            Iterator<Value> iterator = children.getAsArray().iterator();
            Value element;
            while (iterator.hasNext()) {
                element = iterator.next();
                if (!element.isLayout()) {
                    throw new ProteusInflateException("attribute  'children' must be an array of 'Layout' objects");
                }
                child = layoutInflater.inflate(element.getAsLayout(), data, view, dataIndex);
                addView(proteusView, child);
            }
        }

        return true;
    }

    protected void handleDataBoundChildren(T view, Binding value) {
        ProteusView parent = ((ProteusView) view);
        ViewGroupManager manager = (ViewGroupManager) parent.getViewManager();
        DataContext dataContext = manager.getDataContext();
        ObjectValue config = ((NestedBinding) value).getValue().getAsObject();

        Binding collection = config.getAsBinding(ProteusConstants.COLLECTION);
        Layout layout = config.getAsLayout(ProteusConstants.LAYOUT);

        manager.hasDataBoundChildren = true;

        if (null == layout || null == collection) {
            throw new ProteusInflateException("'collection' and 'layout' are mandatory for attribute:'children'");
        }

        Value dataset = collection.getAsBinding().evaluate(view.getContext(), dataContext.getData(), dataContext.getIndex());
        if (dataset.isNull()) {
            return;
        }

        if (!dataset.isArray()) {
            throw new ProteusInflateException("'collection' in attribute:'children' must be NULL or Array");
        }

        int length = dataset.getAsArray().size();
        int count = view.getChildCount();
        ObjectValue data = dataContext.getData();
        ProteusLayoutInflater inflater = manager.getContext().getInflater();
        ProteusView child;
        View temp;

        if (count > length) {
            while (count > length) {
                count--;
                view.removeViewAt(count);
            }
        }

        for (int index = 0; index < length; index++) {
            if (index < count) {
                temp = view.getChildAt(index);
                if (temp instanceof ProteusView) {
                    ((ProteusView) temp).getViewManager().update(data);
                }
            } else {
                //noinspection ConstantConditions : We want to throw an exception if the layout is null
                child = inflater.inflate(layout, data, view, index);
                addView(parent, child);
            }
        }
    }
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @Override
    public boolean addView(ProteusView parent, ProteusView view) {
        if (parent instanceof RadioGroup) {
            ((RadioGroup) parent).addView(view.getAsView());
            return true;
        }
        return false;
    }
}