package com.astooltech.advancedview.proteus.parser.shapeofview.shapes;

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


public class StarViewparse<T extends StarView> extends ViewTypeParser<T> {


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
    public String getType() {
        return "StarLayout";
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
        return new StarA(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("Star_data", new AttributeProcessor<T>() {
                    @Override
                    public void handleValue(T view, Value value) {

                        int  numbb=value.getAsObject().get("Layout_Typ").getAsInt();
                      view.setType(numbb);
                      if(numbb==0) {
                          int numb = value.getAsObject().get("Star_Number").getAsInt();


                          view.Setda(numb);
                      }
                      else if(numbb==2){
                          int numb = value.getAsObject().get("Bubble_Height").getAsInt();
                          int numbw = value.getAsObject().get("Bubble_Width").getAsInt();
                          int numbv = value.getAsObject().get("Bubble_border").getAsInt();
                          int numbwv = value.getAsObject().get("Bubble_Position").getAsInt();


                          view.setArrowHeight(numb);
                          view.setArrowWidth(numbw);
                          view.setBorderRadius(numbv);

                          if(numbwv==0) {
                              view.setPosition(StarView.POSITION_BOTTOM);
                          } else     if(numbwv==1) {
                              view.setPosition(StarView.POSITION_LEFT);
                          } else     if(numbwv==2) {
                              view.setPosition(StarView.POSITION_RIGHT);
                          }else

                              {

                                  view.setPosition(StarView.POSITION_TOP);
                              }




                      }
                      else if(numbb==3){
                          int numb = value.getAsObject().get("Bubble_Height").getAsInt();
                          int numbw = value.getAsObject().get("Bubble_Width").getAsInt();
                          int numbv = value.getAsObject().get("Bubble_border").getAsInt();
                          int numbwv = value.getAsObject().get("Bubble_Position").getAsInt();


                          view.setArcHeight(numb);

                         // view.setBorderRadius(numbv);

                          if(numbwv==0) {
                              view.setPosition(StarView.POSITION_BOTTOM);
                          } else     if(numbwv==1) {
                              view.setPosition(StarView.POSITION_LEFT);
                          } else     if(numbwv==2) {
                              view.setPosition(StarView.POSITION_RIGHT);
                          }else

                          {

                              view.setPosition(StarView.POSITION_TOP);
                          }
                      }
                      else{
                          int numb = value.getAsObject().get("Ploy_Number").getAsInt();


                          view.setNoOfPoints(numb);
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
                  //  view.setDividerDrawable(drawable);
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
               // view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
    }


}
