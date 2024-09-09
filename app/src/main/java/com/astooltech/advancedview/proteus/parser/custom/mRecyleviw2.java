package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.AAadpterme;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.adapterskit.getAllvalue;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.v7.widget.ProteusRecyclerView;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseExpandIconView;

import java.util.ArrayList;
import java.util.List;

public class mRecyleviw2<T extends LinearLayout> extends ViewTypeParser<T> {


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
        return "MMLinearLayout";
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
        return new ProteusLinearLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {


        addAttributeProcessor("Da", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                String typp=value.getAsObject().get("re").toString();
                String typpx=value.getAsObject().get("de").toString();
                String typpxv=value.getAsObject().get("dde").toString();
                ProteusRecyclerView tter=(ProteusRecyclerView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(typp,new ObjectValue());
                getAllvalue eerr=new getAllvalue(((ProteusLinearLayout)view),typpxv);
                Layout gg=((ProteusLinearLayout) view).getViewManager().getContext().getLayout(typpx);
                List<modeltypeview> f=new ArrayList<>();
                final List<AbstractFlexibleItem> eet=	eerr.getDataAll(gg);
                List<AbstractFlexibleItem> ui=new ArrayList<>();

                TextInputLayoutB serr=eerr.getSearchtext();
                final AAadpterme mnbb = new AAadpterme(eet,eerr,eerr.getProgras());//view.getContext(),android.R.layout.simple_list_item_1,mItemss,((AutoCompleteTextViewB) view).getViewManager().getContext().getInflater(),temppxm,false);//getdataIt(((AutoCompleteTextViewB) view).getViewManager().getContext().getResources())); //FlexibleAdapter<IFlexible>(mItems);
                //eerr.loadalltegret(0);
mnbb.setLoadingMoreAtStartUp(true);
                tter.setLayoutManager(new LinearLayoutManager(view.getContext()));
                tter.setAdapter(mnbb);
                protouseFastScroller uto=	eerr.getFastscroll();
                if(uto!=null){
                    uto.addOnScrollStateChangeListener(new FastScroller.OnScrollStateChangeListener() {
                        @Override
                        public void onFastScrollerStateChange(boolean scrolling) {

                        }
                    });
                    mnbb.setFastScroller(uto);
                }


		/*ScrollableLayoutItem scrollHeader = new ScrollableLayoutItem("SLI");
		scrollHeader.setTitle("Endless Scrolling");
		scrollHeader.setSubtitle("...with ScrollableHeaderItem");
		mnbb.addScrollableHeader(scrollHeader);*/
                mnbb.setTopEndless(true);

                if(serr!=null) {
                    serr.getEditText().addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            //DynamicAutocompleteFilterA tu=	mnbb.getFilter(DynamicAutocompleteFilterA.class);

                            //	mnbb.fflt(charSequence.toString());
                            mnbb.SearchText(charSequence.toString());
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
                    view.addView(serr);
                }
                view.addView(tter);
                /*if(typp.equals("v")) {
                    view.setLayoutManager(new  LinearLayoutManager(view.getContext()));
                }else{
                    view.setLayoutManager(new LinearLayoutManager(view.getContext()));
                }*/
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
            addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }
            }
        });
        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });

        addAttributeProcessor("ViewEx", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                try{

                    Layout re=value.getAsObject().getAsLayout("Expand");

                    ///String val=value.getAsObject().getAsString("ExpandName");
                    Layout vald=value.getAsObject().getAsLayout("ExpandIconLayout");
                    ProtouseExpandIconView viw=(ProtouseExpandIconView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(re,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    ProteusLinearLayout viwm=(ProteusLinearLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vald,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    viwm.addView(viw);
                    try {
                        //;
   /* if(view.getChildAt(0) instanceof ProteusLinearLayout){
      ProteusLinearLayout t=(ProteusLinearLayout)   view.getChildAt(0);
      t.addView(viw);

    }else{
      view.addView(viw);
    } *///.addView(viw);
                    }catch (Exception ex){
                        // view.addView(viw);
                        // view.addView(viw);
                    }
                    view.addView(viwm);
                    view.addView(viw.GetviewExpand());

                    //   view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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
        addAttributeProcessor("exview", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {


            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });
        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringToFront();
                    view.invalidate();
                }

            }
        });


        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerDrawable(drawable);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerPadding((int) dimension);
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
                    view.setShowDividers(dividerMode);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {
                view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
    }


}
