package com.astooltech.advancedview.proteus.parser.custom;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.managers.ViewGroupManager;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


/**
 * Created by kiran.kumar on 12/05/14.
 */






public class  RappleLayoutParser<T extends MaterialRippleLayout> extends ViewTypeParser<T> {

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
        return "RippleLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProteusRappleLayout(context);
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
                                                 @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable MaterialRippleLayout parent,
                                                 int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new ViewGroupManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.RappleLayout.ClipChildren, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipChildren(value);
            }
        });

        addAttributeProcessor(Attributes.RappleLayout.ClipToPadding, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipToPadding(value);
            }
        });

        addAttributeProcessor(Attributes.RappleLayout.LayoutMode, new StringAttributeProcessor<T>() {
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


        addAttributeProcessor(Attributes.RappleLayout.RappleOverlay, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {
                    String va=value.toUpperCase().substring(0,1);
                    if(va.equals("T")){
                        dd=true;
                    }
                }catch (Exception e){

                }

                view.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });
        addAttributeProcessor(Attributes.RappleLayout.delayclick, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {
                    String va=value.toUpperCase().substring(0,1);
                    if(va.equals("T")){
                        dd=true;
                    }
                }catch (Exception e){

                }

                view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.Rapplhover, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {
                    String va=value.toUpperCase().substring(0,1);
                    if(va.equals("T")){
                        dd=true;
                    }
                }catch (Exception e){

                }

                view.setRippleHover(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.Rappalfa, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                float dd=1.0f;
                try {
                   // String va=value.toUpperCase().substring(0,1);
                    dd=Float.parseFloat(value);
                }catch (Exception e){

                }

                view.setDefaultRippleAlpha(dd);//.setAlpha(dd);//.setRippleAlpha(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.RappleColor, new ColorResourceProcessor<T>() {

            @Override
            public void setColor(T view, int color) {
                view.setRippleColor(color);
            }

            @Override
            public void setColor(T view, ColorStateList colors) {
                view.setRippleColor(colors.getDefaultColor());
            }
        });

        addAttributeProcessor(Attributes.RappleLayout.duration, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                Integer dd=1;
                try {
                   // String va=value.toUpperCase().substring(0,1);
                    dd=Integer.parseInt(value);
                }catch (Exception e){

                }

                view.setRippleDuration(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });


        addAttributeProcessor(Attributes.RappleLayout.roundshap, new  StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                Integer dd=1;
                try {
                    // String va=value.toUpperCase().substring(0,1);
                    dd=Integer.parseInt(value);
                }catch (Exception e){

                }

                view.setRippleRoundedCorners(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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
                                  @Nullable com.google.android.material.textfield.TextInputLayout  parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }
    @Override
    public boolean addView(ProteusView parent, ProteusView view) {
        if (parent instanceof MaterialRippleLayout) {
            ((MaterialRippleLayout) parent).addView(view.getAsView());
            return true;
        }
        return false;
    }
}


