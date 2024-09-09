package com.astooltech.advancedview.proteus.parser.custom;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
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


public class ProtouseFlowLayoutParser<T extends FlowLayout> extends ViewTypeParser<T> {


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
        return "FlowerLayout";
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
        return new ProtouseFlowLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("proper", new AttributeProcessor<T>() {
                    @Override
                    public void handleValue(T view, Value value) {
                        int sp=value.getAsObject().getAsInteger("View_Space");
                        int spv=value.getAsObject().getAsInteger("View_Row");
                        int spvk=value.getAsObject().getAsInteger("View_RowMax");
                        int spe=value.getAsObject().getAsInteger("View_SpaceRow");
                        boolean spvv=value.getAsObject().getAsBoolean("Use_Flow");
                        boolean spvvv=value.getAsObject().getAsBoolean("Use_FlowRtl");
                        ProtouseFlowLayout  dder=     (ProtouseFlowLayout)view;
                      if(sp==0) {
                          dder.setChildSpacing(ProtouseFlowLayout.SPACING_AUTO);
                      }else {
                          dder.setChildSpacing(sp);
                      }

                        if(spv==0) {
                            dder.setChildSpacingForLastRow(ProtouseFlowLayout.SPACING_ALIGN);
                        }else {
                            dder.setChildSpacingForLastRow(spv);
                        }
                        dder.setFlow(spvv);
                        dder.setRtl(spvvv);
                        if(spe==0) {
                           dder.setRowSpacing(ProtouseFlowLayout.SPACING_AUTO);
                        }else {
                            dder.setRowSpacing(spe);
                        }
                     // dder.setRowSpacing(spe);
                     dder.setMaxRows(spvk);
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


/*final View eer=view;
       final   OverlayLayout    mlayout=new OverlayLayout(view.getContext()) {
              @Override
              protected View createOverlayView() {


                  return eer;
              }
          };
         ;*/
            }
        });
        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
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

                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {

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

                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

            }
        });
    }


}
