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
import com.astooltech.advancedview.proteus.parser.custom.GetDrawbileFromString;
import com.astooltech.advancedview.proteus.parser.shapeofview.ShapeOfView;
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


public class  ProtoShapViewParser<T extends ShapeOfView> extends ViewTypeParser<T> {


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
        return "CustomLayout";
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
        return new  ProtoShapView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("Shape_Path", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {


               /* Array Datad=value.getAsObject().getAsArray("Path_Object");//.replace('#','"');
               int pathwid=value.getAsObject().get("Path_Width").getAsInt();
                int pathwh=value.getAsObject().get("Path_Height").getAsInt();
                int pathwida=value.getAsObject().get("Path_WidthA").getAsInt();
                int pathwha=value.getAsObject().get("Path_HeightA").getAsInt();
List<VectorDrawableCreator.PathData> fer=new ArrayList<>();
                for (int cx = 0; cx < Datad.size(); cx++) {
Value vvewq=Datad.get(cx).getAsObject();
String pathdat=vvewq.getAsObject().getAsString("Path_data");
                    String color=vvewq.getAsObject().getAsString("Path_color");
                    VectorDrawableCreator.PathData ddg=new VectorDrawableCreator.PathData(pathdat,Color.parseColor("#"+color));
                fer.add(ddg);
                }
                  /*  List<VectorDrawableCreator.PathData> pathList = Arrays.asList(new VectorDrawableCreator.PathData("M128.09 5.02a110.08 110.08 0 0 0-110 110h220a109.89 109.89 0 0 0-110-110z", Color.parseColor("#7cb342")),
                        new VectorDrawableCreator.PathData("M128.09 115.02h-110a110.08 110.08 0 0 0 110 110 110.08 110.08 0 0 0 110-110z", Color.parseColor("#8bc34a")),
                        new VectorDrawableCreator.PathData("M207.4 115.2v-.18h-5.1l-61.43-61.43h-25.48v20.6h-6.5a11.57 11.57 0 0 0-11.53 11.53v26.09h.11c-.11.9.5 2 1.7 3.32.12.08.12.08.12.2l3.96 4-46.11 79.91c5.33 4.5 11.04 8.4 17 11.8a109.81 109.81 0 0 0 108.04 0 110.04 110.04 0 0 0 51.52-64.65c.38-1.28.68-2.57 1.1-3.78z", Color.parseColor("#30000000")),
                        new VectorDrawableCreator.PathData("M216.28 230.24a6.27 6.27 0 0 0-.9-2.8l-31.99-55.57-10.58-18.48-19.85-34.21-15.08 15.12 18.6 32.28 10.2 17.73 30.92 53.37a5.6 5.6 0 0 0 1.97 2.12l15.42 10.5c.6.39 1.29.39 1.9.08.6-.37.9-.98.9-1.7z", Color.parseColor("#e1e1e1")),
                        new VectorDrawableCreator.PathData("M186.98 115.02a58.9 58.9 0 0 1-30.5 51.6 58.4 58.4 0 0 1-56.7 0l18.6-32.28-15.13-15.12-62.48 108.22c-.5.9-.8 1.78-.9 2.8l-1.4 18.6c-.12.71.3 1.28.9 1.7.6.37 1.29.3 1.9-.12l15.41-10.4a7.87 7.87 0 0 0 1.97-2.07l30.92-53.53a78.74 78.74 0 0 0 77.23 0 76.65 76.65 0 0 0 16.6-12.4 79.3 79.3 0 0 0 24.07-56.89z", Color.parseColor("#f1f1f1")),
                        new VectorDrawableCreator.PathData("M147.3 74.12h-6.43v-20.6h-25.48v20.6h-6.5a11.57 11.57 0 0 0-11.53 11.5v26.07h.11c-.11 1.02.5 2.12 1.82 3.4l23.05 23.14a8.3 8.3 0 0 0 5.75 2.38v-.07l.07.07c2.12 0 4.2-.75 5.71-2.38l23.1-23.1c1.32-1.32 1.81-2.53 1.81-3.4h.12V85.7a11.68 11.68 0 0 0-11.6-11.6zm-19.14 40.9h-.07a15.4 15.4 0 0 1 0-30.8v-.2l.07.2a15.46 15.46 0 0 1 15.31 15.38 15.46 15.46 0 0 1-15.3 15.42z", Color.parseColor("#646464")));

             */
            //    Drawable c=   VectorDrawableCreator.getVectorDrawable(view.getContext(),pathwid,pathwh,pathwida,pathwha,fer);

                //pathList.addAll(fer);

                try {
                    Drawable c  =GetDrawbileFromString.getDrawble(value,view.getContext());
                    view.setDrawable(c);

                }catch (Exception ex){

                }
               /* view.setClipPathCreator(new ClipPathManager.ClipPathCreator() {
                    @Override
                    public Path createClipPath(int width, int height) {
                       Path b=new Path();
                       b.

                       return b;
                    }

                    @Override
                    public boolean requiresBitmap() {
                        return false;
                    }
                });*/
                /*int  numbb=value.getAsObject().get("Layout_Typ").getAsInt();


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

                    final Path b=new Path();

                    view.Setda(0);
                }
                else if(numbb==3){
                    int numb = value.getAsObject().get("Bubble_Height").getAsInt();
                    int numbw = value.getAsObject().get("Bubble_Width").getAsInt();
                    int numbv = value.getAsObject().get("Bubble_border").getAsInt();
                    int numbwv = value.getAsObject().get("Bubble_Position").getAsInt();
view.dra

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


        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringToFront();
                    view.invalidate();
                }

            }
        });


        addAttributeProcessor("mask", new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {



                view.setDrawable(drawable);
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
