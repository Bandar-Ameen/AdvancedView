package com.astooltech.advancedview.proteus.view.custom;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.chatview.photoview.ExpandIconView;
import com.astooltech.advancedview.proteus.managers.ViewGroupManager;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


public class  ProtouseExpandIconViewParser<T extends ExpandIconView> extends ViewTypeParser<T> {

    private static final String LAYOUT_MODE_CLIP_BOUNDS = "clipBounds";
    private static final String LAYOUT_MODE_OPTICAL_BOUNDS = "opticalBounds";

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }

    @NonNull
    @Override
    public String getType() {
        return "ExpandLayoutView";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProtouseExpandIconView(context);
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
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new ViewGroupManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("uu", new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                //view.setClipChildren(value);

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.ClipToPadding, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                //  view.setClipToPadding(value);
            }
        });
        addAttributeProcessor("ViewEx", new AttributeProcessor<T>() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void handleValue(T view, Value value) {

                       Layout getvalu=value.getAsObject().getAsLayout("ViewEx_View");
                        String getvaluc=value.getAsObject().getAsString("ViewEx_Color");
                      Layout getvalucm=value.getAsObject().getAsLayout("ViewEx_up");
                      Layout getvalucmm=value.getAsObject().getAsLayout("ViewEx_down");


                        int col= ParseHelper.parseColor(getvaluc);
                        View viw= ((ProtouseExpandIconView)view).getViewManager().getContext().getInflater().inflate(getvalu,((ProtouseExpandIconView) view).getViewManager().getDataContext().getData()).getAsView();
                  final    View viwx= ((ProtouseExpandIconView) view).getViewManager().getContext().getInflater().inflate(getvalucm,new ObjectValue()).getAsView();
                  final      View viwxx= ((ProtouseExpandIconView) view).getViewManager().getContext().getInflater().inflate(getvalucmm,new ObjectValue()).getAsView();

                        viw.setVisibility(View.GONE);
                        view.SetviewExpand(viw);
                       view.SetColor(col,col,col);

                        view.setBackground(viwx.getBackground());
                        view.setState(0,true);



                        view.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("WrongConstant")
                            @Override
                            public void onClick(View view) {


                                if (((ProtouseExpandIconView) view).getState() == 1) {
                                    ((ProtouseExpandIconView) view).setState(0, true);
                                    ((ProtouseExpandIconView) view).GetviewExpand().setVisibility(View.VISIBLE);
                                    view.setBackground(viwx.getBackground());

                                } else {
                                    ((ProtouseExpandIconView) view).setState(1, true);
                                    ((ProtouseExpandIconView) view).GetviewExpand().setVisibility(View.GONE);
                                    view.setBackground(viwxx.getBackground());
                                }
                            /*moreHSV.setVisibility(View.GONE);
                            more=false;*
                        }
                        else{
                            expandIconView.setState(0,true);
                            moreHSV.setVisibility(View.VISIBLE);
                            more=true;
                        }*/
                            }
                        });
                        view.callOnClick();
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
            addAttributeProcessor("viewlayout", new StringAttributeProcessor<T>() {
            @SuppressLint("WrongConstant")
            @Override
            public void setString(final T view, String value) {
                View viw= ((ProtouseExpandIconView)view).getViewManager().getContext().getInflater().inflate(value,new ObjectValue()).getAsView();
               view.SetviewExpand(viw);
                view.setState(0,true);



                view.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void onClick(View view) {


                        if(((ProtouseExpandIconView)view).getState()==0) {
                            ((ProtouseExpandIconView)view).setState(1, true);
                            ((ProtouseExpandIconView)view).GetviewExpand().setVisibility(View.VISIBLE);

                        }else{
                            ((ProtouseExpandIconView)view).setState(0, true);
                            ((ProtouseExpandIconView)view).GetviewExpand().setVisibility(View.GONE);
                        }
                            /*moreHSV.setVisibility(View.GONE);
                            more=false;*
                        }
                        else{
                            expandIconView.setState(0,true);
                            moreHSV.setVisibility(View.VISIBLE);
                            more=true;
                        }*/
                    }
                });

            }



        });


        addAttributeProcessor(Attributes.RappleLayout.RappleOverlay, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd = false;
                try {
                    String va = value.toUpperCase().substring(0, 1);
                    if (va.equals("T")) {
                        dd = true;
                    }
                } catch (Exception e) {

                }

                //   view.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });
        addAttributeProcessor(Attributes.RappleLayout.delayclick, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd = false;
                try {
                    String va = value.toUpperCase().substring(0, 1);
                    if (va.equals("T")) {
                        dd = true;
                    }
                } catch (Exception e) {

                }

                //   view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.Rapplhover, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd = false;
                try {
                    String va = value.toUpperCase().substring(0, 1);
                    if (va.equals("T")) {
                        dd = true;
                    }
                } catch (Exception e) {

                }

                //view.setRippleHover(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.Rappalfa, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                float dd = 1.0f;
                try {
                    // String va=value.toUpperCase().substring(0,1);
                    dd = Float.parseFloat(value);
                } catch (Exception e) {

                }

                //  view.setDefaultRippleAlpha(dd);//.setAlpha(dd);//.setRippleAlpha(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.RappleColor, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                // view.setRippleColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                // view.setRippleColor(colors.getDefaultColor());
            }
        });

        addAttributeProcessor(Attributes.RappleLayout.duration, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                Integer dd = 1;
                try {
                    // String va=value.toUpperCase().substring(0,1);
                    dd = Integer.parseInt(value);
                } catch (Exception e) {

                }

                //view.setRippleDuration(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });


        addAttributeProcessor(Attributes.RappleLayout.roundshap, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                Integer dd = 1;
                try {
                    // String va=value.toUpperCase().substring(0,1);
                    dd = Integer.parseInt(value);
                } catch (Exception e) {

                }

                // view.setRippleRoundedCorners(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });
     /*   addAttributeProcessor(Attributes.RadioGroup.SplitMotionEvents, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setMotionEventSplittingEnabled(value);
            }
        });
*/

    }


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
}


