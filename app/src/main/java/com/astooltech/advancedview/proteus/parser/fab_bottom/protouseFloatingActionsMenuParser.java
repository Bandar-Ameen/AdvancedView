package com.astooltech.advancedview.proteus.parser.fab_bottom;

import android.content.res.ColorStateList;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.managers.ViewGroupManager;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.ColorResourceProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;


public class  protouseFloatingActionsMenuParser<T extends FloatingActionsMenu> extends ViewTypeParser<T> {

    private static final String LAYOUT_MODE_CLIP_BOUNDS = "clipBounds";
    private static final String LAYOUT_MODE_OPTICAL_BOUNDS = "opticalBounds";
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }
    @NonNull
    @Override
    public String getType() {
        return "FabLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new protouseFloatingActionsMenu(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return null;
    }


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable TextInputLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
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


        addAttributeProcessor("proper", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                int size=value.getAsObject().getAsInteger("Fab_Size");
                int leb=value.getAsObject().getAsInteger("Fab_Label_Postion");
                int lebb=value.getAsObject().getAsInteger("Fab_Expand");
                String color=value.getAsObject().getAsString("Fab_ColorA");
                String colors=value.getAsObject().getAsString("Fab_ColorC");
                String colorsv=value.getAsObject().getAsString("Fab_ColorD");
               // String fabtit=    value.getAsObject().getAsString("Fab_Title");
               // protouseFloatingActionsMenu ew=(protouseFloatingActionsMenu)view;
                view.setmAddButtonColorNormal(ParseHelper.parseColor("#"+color));
                view.setmAddButtonColorPressed(ParseHelper.parseColor("#"+colors));
                view.setmAddButtonPlusColor(ParseHelper.parseColor("#"+colorsv));
               // ew.setmAddButtonSize();
                view.setmAddButtonSize(size==0?FloatingActionButton.SIZE_NORMAL:FloatingActionButton.SIZE_MINI);
            if(lebb==0) {
                view.setmExpandDirection(FloatingActionsMenu.EXPAND_UP);
            }
                if(lebb==1) {
                    view.setmExpandDirection(FloatingActionsMenu.EXPAND_DOWN);
                }
                if(lebb==2) {
                    view.setmExpandDirection(FloatingActionsMenu.EXPAND_LEFT);
                }
                if(lebb==3) {
                    view.setmExpandDirection(FloatingActionsMenu.EXPAND_RIGHT);
                }

                Log.e("oo","ghghghghghg");
             try {
                 view.setmLabelsPosition(leb == 0 ? FloatingActionsMenu.LABELS_ON_LEFT_SIDE : FloatingActionsMenu.LABELS_ON_RIGHT_SIDE);
                 Array getFabview = value.getAsObject().getAsArray("AddFabView");
                 for (int cxx = 0; cxx < getFabview.size(); cxx++) {
                     ProteusView ffdse = ((protouseFloatingActionsMenu) view).viewManager.getContext().getInflater().inflate(getFabview.get(cxx).getAsLayout(), new ObjectValue());
                     protuseFloatinggActionButton q = (protuseFloatinggActionButton) ffdse.getAsView();
//view.addView(q);
                     view.addButton(q);
                 }
//view.expand();
             }catch (Exception ex){

                 Log.e("oo",ex.getMessage());
             }
               // view.setTitle(fabtit);
            }

            @Override
            public void handleResource(T view, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T view, AttributeResource attribute) {

            }

            @Override
            public void handleStyleResource(T view, StyleResource style) {

            }});
        addAttributeProcessor(Attributes.RappleLayout.ClipChildren, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipChildren(value);
                protouseFloatingActionsMenu ww=(protouseFloatingActionsMenu)view;

            }
        });

        addAttributeProcessor(Attributes.RappleLayout.ClipToPadding, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setClipToPadding(value);
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

               // view.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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

               // view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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

              //  view.setRippleHover(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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
               //view.setRippleColor(colors.getDefaultColor());
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

               // view.setRippleDuration(dd);//.setRippleAlpha(dd);//.setRippleOverlay(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

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




}
