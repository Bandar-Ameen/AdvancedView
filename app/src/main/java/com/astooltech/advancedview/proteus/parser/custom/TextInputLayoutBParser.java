package com.astooltech.advancedview.proteus.parser.custom;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
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


public class  TextInputLayoutBParser<T extends com.google.android.material.textfield.TextInputLayout> extends ViewTypeParser<T> {

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
        return "TextInputLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout,
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable com.google.android.material.textfield.TextInputLayout parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new ViewGroupManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }
    private boolean checknullvalues(TextInputLayoutB dt){
        boolean checkvalue=false;
       try {
           boolean typActionname = Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
           if (typActionname) {
               EditText ccc = dt.getEditText();
               assert ccc != null;

               if (ccc.getText().toString().equals("")) {
                   try {
                       String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                       ccc.setError(cvv);
                       dt.setHelperText(cvv);
                       dt.setErrorEnabled(true);
                       checkvalue = true;
                   } catch (Exception ex) {

                       Log.i("Proteus1", ex.getMessage() + "@@@@@@");
                       //  return;
                   }

               } else {
                   dt.setHelperTextEnabled(false);
                   dt.setHelperText("");
                   dt.setError("");
                   dt.setErrorEnabled(false);
                   checkvalue = false;
               }
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

    private void getwithanotheroper(TextInputLayoutB  dt,DataValueSelect datb,int typoper){

        if (typoper == 2) {
            EditText ccc = dt.getEditText();
            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            if (IDDdat.equals(datb.getIDUnit())) {
                if (datb.getTypselect().equals("0")||datb.getTypselect().toLowerCase().equals("gettext")) {
                    datb.setChecknull(checknullvalues(dt));
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
            EditText ccc = dt.getEditText();
            assert ccc != null;
            String IDDdat = dt.getTag(R.id.tag3).toString();
            Value typ=  getvaluefromdat("Type",datb.getAnotherDatat());

            if (IDDdat.equals(datb.getIDUnit())) {
                if (typ.getAsString().equals("0")) {

                    try {
                        Value va=  getvaluefromdat("GetData",datb.getAnotherDatat());
                        dt.getEditText().setText(va.getAsString());
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


    private  void SetGetFindTextInputLayout(TextInputLayoutB  dt,DataValueSelect datb,int typoper){
      try {

          if (typoper == 1) {
              boolean typActionname = Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
              if (typActionname) {
                  EditText ccc = dt.getEditText();
                  assert ccc != null;

                  String IDDdat = dt.getTag(R.id.tag3).toString();
                  //   Log.e("ProteusEventWithTag11", "iiiiiiiiiiimm" + datb.getIDUnit() + "@@@@@@" + IDDdat);
                  if (IDDdat.equals(datb.getIDUnit())) {
                      if (datb.getTypselect().equals("0")) {
                          if (ccc.getText().toString().equals("")) {
                              try {
                                  // Log.i("ProteusEventWithTag11", "iiiiiiiiiiimm" + "@@@@@@");
                                  String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                                  ccc.setError(cvv);
                                  dt.setHelperText(cvv);
                                  dt.setErrorEnabled(true);
                                  datb.setChecknull(true);
                                  // checknull = true;
                              } catch (Exception ex) {

                                  Log.i("Proteus1", ex.getMessage() + "@@@@@@");
                                  //  return;
                              }

                          } else {
                              //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiikk" + "@@@@@@");
                              dt.setHelperTextEnabled(false);
                              dt.setHelperText("");
                              dt.setError("");
                              dt.setErrorEnabled(false);
                              // Log.i("ProteusEventWithTag11", "iiiiiiiiiiipp" + "@@@@@@");
                              datb.setDataGet(ccc.getText().toString());
                              //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiiuuuu" + "@@@@@@");
                                           /* resultData c = new resultData(cx, ccc.getText().toString(),"@"+IDDdat+"@");
                                            // unit_model c = new unit_model(cx, ccc.getText().toString() + " " + ccc.getId());
                                            allunit.add(c);*/
                          }

                      } else if (datb.getTypselect().equals("1")) {
                          dt.setVisibility(View.VISIBLE);
                      } else if (datb.getTypselect().equals("2")) {
                          dt.setVisibility(View.GONE);
                      } else if (datb.getTypselect().equals("3")) {
                          dt.setEnabled(false);
                      } else if (datb.getTypselect().equals("4")) {
                          dt.setEnabled(true);
                      } else if (datb.getTypselect().equals("5")) {
                          dt.getEditText().setText(datb.getDataGet());
                      }

                  }

              }else{

                  EditText ccc = dt.getEditText();
                  assert ccc != null;
                  String IDDdat = dt.getTag(R.id.tag3).toString();
                  // Log.e("ProteusEventWithTag11", "iiiiiiiiiiimm" + datb.getIDUnit() + "@@@@@@" + IDDdat);
                  if (IDDdat.equals(datb.getIDUnit())) {
                      if (datb.getTypselect().equals("0")) {
                          datb.setDataGet(ccc.getText().toString());


                      } else if (datb.getTypselect().equals("1")) {
                          dt.setVisibility(View.VISIBLE);
                      } else if (datb.getTypselect().equals("2")) {
                          dt.setVisibility(View.GONE);
                      } else if (datb.getTypselect().equals("3")) {
                          dt.setEnabled(false);
                      } else if (datb.getTypselect().equals("4")) {
                          dt.setEnabled(true);
                      } else if (datb.getTypselect().equals("5")) {
                          dt.getEditText().setText(datb.getDataGet());
                      }

                  }
              }

          }else{

              getwithanotheroper(dt,datb,typoper);

          }



      }catch (Exception ex){
          Log.i("Protehhhhus1", ex.getMessage() + "@@@@@@");
      }
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(view instanceof  TextInputLayoutB){
            SetGetFindTextInputLayout((TextInputLayoutB)view,data,typoper);
        }
    }

    @Override
    protected void addAttributeProcessors() {




        addAttributeProcessor(Attributes.TextInputLayout.ClipChildren, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipChildren(value);
            }
        });

        addAttributeProcessor(Attributes.TextInputLayout.ClipToPadding, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipToPadding(value);
            }
        });


        addAttributeProcessor(Attributes.TextInputLayout.starticon, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                view.setStartIconDrawable(drawable);
            }
        });
        addAttributeProcessor(Attributes.TextInputLayout.endicon, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
            //   view.setBoxStrokeErrorColor(R.color.astoolTextColor);
                view.setEndIconDrawable(drawable);
            }
        });

        addAttributeProcessor(Attributes.TextInputLayout.LayoutMode, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    if (LAYOUT_MODE_CLIP_BOUNDS.equals(value)) {
                        view.setLayoutMode(RadioGroup.LAYOUT_MODE_CLIP_BOUNDS);
                    } else if (LAYOUT_MODE_OPTICAL_BOUNDS.equals(value)) {
                        view.setLayoutMode(RadioGroup.LAYOUT_MODE_OPTICAL_BOUNDS);
                    }
                }

              //  view.
            }

        });

        addAttributeProcessor(Attributes.TextInputLayout.SplitMotionEvents, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setMotionEventSplittingEnabled(value);
            }
        });
        addAttributeProcessor(Attributes.TextInputLayout.Lhint, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {


                view.setHint(value);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });
      /*  addAttributeProcessor(Attributes.TextInputLayout.PlaceHoldercolor, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {

                view.set.setPlaceholderTextColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setBoxStrokeColor(colors.getDefaultColor());
            }
        });
*/
        addAttributeProcessor(Attributes.TextInputLayout.Lboxcolor, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {

                view.setBoxStrokeColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setBoxStrokeColor(colors.getDefaultColor());
            }
        });

        addAttributeProcessor(Attributes.TextInputLayout.Lmode, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {



            }
        });
        addAttributeProcessor(Attributes.TextInputLayout.Children, new AttributeProcessor<T>() {
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

    @Override
    public boolean addView(ProteusView parent, ProteusView view) {
        if (parent instanceof com.google.android.material.textfield.TextInputLayout) {
            ((com.google.android.material.textfield.TextInputLayout) parent).addView(view.getAsView());
            return true;
        }
        return false;
    }
}
