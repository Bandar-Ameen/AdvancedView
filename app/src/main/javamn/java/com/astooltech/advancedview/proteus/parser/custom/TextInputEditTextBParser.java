package com.astooltech.advancedview.proteus.parser.custom;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
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
import com.astooltech.advancedview.proteus.view.TextInputEditTextB;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;
import java.util.Map;

//com.google.android.material.textfield.TextInputEditText


/**
 * Created by kirankumar on 25/11/14.
 */
public class TextInputEditTextBParser<T extends com.google.android.material.textfield.TextInputEditText> extends ViewTypeParser<T> {
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
        return "TextInputEditText";
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
        return new TextInputEditTextB(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    private boolean checknullvalues(TextInputEditTextB dt){
        boolean checkvalue=false;
        TextInputEditTextB ccc = dt;
        try {
            boolean typActionname = Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
            if (typActionname) {

                assert ccc != null;

                if (ccc.getText().toString().equals("")) {
                    try {
                        String cvv = String.valueOf(dt.getTag(R.id.otagOnerrortext));
                        ccc.setError(cvv);

                        checkvalue = true;
                    } catch (Exception ex) {

                        Log.i("Proteus1", ex.getMessage() + "@@@@@@");
                        //  return;
                    }

                } else {

                    dt.setError("");

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

    private void getwithanotheroper(TextInputEditTextB  dt, DataValueSelect datb, int typoper){
        TextInputEditTextB ccc = dt;
        if (typoper == 2) {

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


    private  void SetGetFindTextInputLayout(TextInputEditTextB  dt,DataValueSelect datb,int typoper){
        try {
            TextInputEditTextB ccc = dt;
            if (typoper == 1) {
                boolean typActionname = Boolean.parseBoolean(String.valueOf(dt.getTag(R.id.tagechecknullValue)));
                if (typActionname) {

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

                                    datb.setChecknull(true);
                                    // checknull = true;
                                } catch (Exception ex) {

                                    Log.i("Proteus1", ex.getMessage() + "@@@@@@");
                                    //  return;
                                }

                            } else {
                                //  Log.i("ProteusEventWithTag11", "iiiiiiiiiiikk" + "@@@@@@");

                                dt.setError("");

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
                            dt.setText(datb.getDataGet());
                        }

                    }

                }else{


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
                            dt.setText(datb.getDataGet());
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
        if(view instanceof  TextInputEditTextB){
            SetGetFindTextInputLayout((TextInputEditTextB)view,data,typoper);
        }
    }


    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("With_Search", new AttributeProcessor<T>() {
            @Override
            public void handleValue(final T view, Value value) {
                final String vewId=value.getAsObject().getAsString("ViewID");

                view.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        //DynamicAutocompleteFilterA tu=	mnbb.getFilter(DynamicAutocompleteFilterA.class);
                        ((TextInputEditTextB)view).getViewManager().getContext().getParser("ARecyclerView").ReceveSearch(charSequence.toString(),vewId);
                        //	mnbb.fflt(charSequence.toString());
                        //   mnbb.SearchText(charSequence.toString());
				/*if (mnbb.hasNewFilter(charSequence.toString())) {
					mnbb.setFilter(charSequence.toString());

					// Fill and Filter mItems with your custom list and automatically animate the changes
					// - Option A: Use the internal list as original list
					mnbb.filterItems(eet,DatabaseConfiguration.delay);

					// - Option B: Provide any new list to filter
					//mAdapter.filterItems(DatabaseService.getInstance().getDatabaseList(), DatabaseConfiguration.delay);
				}*/
                        ;


                        //uuip.triggerAdapter(6, false, charSequence.toString(), charSequence.toString(), null, ((ProteusEditText) view));


                        //((ProteusEditText) view).getViewManager().getDataContext()

                        // Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+charSequence);
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

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

        addAttributeProcessor("With_Search_Web", new AttributeProcessor<T>() {
            @Override
            public void handleValue(final T view, Value value) {
                final String vewId=value.getAsObject().getAsString("ViewID");
                final String script=value.getAsObject().getAsString("Script");

                view.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
String[] dattg=new String[]{charSequence.toString()};
                        String results=String.format(script,dattg);
                        //DynamicAutocompleteFilterA tu=	mnbb.getFilter(DynamicAutocompleteFilterA.class);
                        ((TextInputEditTextB)view).getViewManager().getContext().getParser("WebView").ReceveSearch(results,vewId);
                        //	mnbb.fflt(charSequence.toString());
                        //   mnbb.SearchText(charSequence.toString());
				/*if (mnbb.hasNewFilter(charSequence.toString())) {
					mnbb.setFilter(charSequence.toString());

					// Fill and Filter mItems with your custom list and automatically animate the changes
					// - Option A: Use the internal list as original list
					mnbb.filterItems(eet,DatabaseConfiguration.delay);

					// - Option B: Provide any new list to filter
					//mAdapter.filterItems(DatabaseService.getInstance().getDatabaseList(), DatabaseConfiguration.delay);
				}*/
                        ;


                        //uuip.triggerAdapter(6, false, charSequence.toString(), charSequence.toString(), null, ((ProteusEditText) view));


                        //((ProteusEditText) view).getViewManager().getDataContext()

                        // Log.i("rrrrrrrmmkkkkkkkknnnnn", "vvvvvvv"+charSequence);
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

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
            addAttributeProcessor(Attributes.View.Inputtyp, new StringAttributeProcessor<T>() {
            @Override
            public void setString(final T view, String value) {



                if(value.equals("DateTime")) {
                    view.setInputType(InputType.TYPE_CLASS_DATETIME);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Number")) {
                    view.setInputType(InputType.TYPE_CLASS_NUMBER);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Text")) {
                    view.setInputType(InputType.TYPE_CLASS_TEXT);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }

                if(value.equals("Decimal")) {
                    view.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Email")) {
                    view.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Url")) {
                    view.setInputType(InputType.TYPE_TEXT_VARIATION_URI);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Short")) {
                    view.setInputType(InputType.TYPE_TEXT_VARIATION_SHORT_MESSAGE);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Password")) {
                    view.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
                if(value.equals("Phone")) {
                    view.setInputType(InputType.TYPE_CLASS_PHONE);//.setTransformationMethod(Meth );//.setInputType(EditText.AUTOFILL_HINT_PASSWORD);
                }
            }
        });
        addAttributeProcessor(Attributes.TextView.HTML, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.setText(Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY));
                } else {
                    //noinspection deprecation
                    view.setText(Html.fromHtml(value));
                }
            }
        });
        addAttributeProcessor(Attributes.TextView.Text, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setText(value);
            }
        });

        addAttributeProcessor(Attributes.TextView.DrawablePadding, new DimensionAttributeProcessor<T>() {
            @Override
            public void setDimension(T view, float dimension) {
                view.setCompoundDrawablePadding((int) dimension);

            }
        });

        addAttributeProcessor(Attributes.TextView.TextSize, new DimensionAttributeProcessor<T>() {
            @Override
            public void setDimension(T view, float dimension) {
                view.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimension);
            }
        });
        addAttributeProcessor(Attributes.TextView.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextColor, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                view.setTextColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setTextColor(colors);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextColorHint, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                view.setHintTextColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setHintTextColor(colors);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextColorLink, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                view.setLinkTextColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setLinkTextColor(colors);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextColorHighLight, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                view.setHighlightColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                //

            }
        });

        addAttributeProcessor(Attributes.TextView.DrawableLeft, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                Drawable[] compoundDrawables = view.getCompoundDrawables();
                view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            }
        });
        addAttributeProcessor(Attributes.TextView.DrawableTop, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                Drawable[] compoundDrawables = view.getCompoundDrawables();
                view.setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], drawable, compoundDrawables[2], compoundDrawables[3]);
            }
        });
        addAttributeProcessor(Attributes.TextView.DrawableRight, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                Drawable[] compoundDrawables = view.getCompoundDrawables();
                view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], drawable, compoundDrawables[3]);
            }
        });
        addAttributeProcessor(Attributes.TextView.DrawableBottom, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                Drawable[] compoundDrawables = view.getCompoundDrawables();
                view.setCompoundDrawablesWithIntrinsicBounds(drawable, compoundDrawables[1], compoundDrawables[2], drawable);
            }
        });

        addAttributeProcessor(Attributes.TextView.MaxLines, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setMaxLines(ParseHelper.parseInt(value));
            }
        });

        addAttributeProcessor(Attributes.TextView.Ellipsize, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                Enum ellipsize = ParseHelper.parseEllipsize(value);
                view.setEllipsize((android.text.TextUtils.TruncateAt) ellipsize);
            }
        });

        addAttributeProcessor(Attributes.TextView.PaintFlags, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if (value.equals("strike"))
                    view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });

        addAttributeProcessor(Attributes.TextView.Prefix, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setText(value + view.getText());
            }
        });

        addAttributeProcessor(Attributes.TextView.Suffix, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setText(view.getText() + value);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextStyle, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                int typeface = ParseHelper.parseTextStyle(value);
                view.setTypeface(Typeface.defaultFromStyle(typeface));
            }
        });

        addAttributeProcessor(Attributes.TextView.SingleLine, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setSingleLine(value);
            }
        });

        addAttributeProcessor(Attributes.TextView.TextAllCaps, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setAllCaps(value);
            }
        });
        addAttributeProcessor(Attributes.TextView.Hint, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setHint(value);
            }
        });
    }
}
