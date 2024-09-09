package com.astooltech.advancedview.proteus.view.custom;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.ProtouseHorizontalScrollMenuView;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

public class ProtouseHorizontalScrollMenuViewParser <T extends ProtouseHorizontalScrollMenuView> extends ViewTypeParser<T> {


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
        return "MenuLine";
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
        return new ProtouseHorizontalScrollMenuView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("navga", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {

            view.addItem("ggggg",R.drawable.icon_add);
                view.addItem("ggggsdfsdfg",R.drawable.icon_save32);
               /* ActionBarDrawerToggle bb=new ActionBarDrawerToggle((Activity) view.getContext(),view ,R.string.drawer_open,R.string.drawer_closed);
               // view.addDrawerListener();

                view.addDrawerListener(bb);
                bb.syncState();
                try {
                    ((AppCompatActivity) view.getContext()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                }catch (Exception ex){

                }*/


                //  view.openDrawer();

              /*  if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }*/
            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                //  view.setGravity(gravity);
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

               /* if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerDrawable(drawable);
                }*/
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
              /*  if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerPadding((int) dimension);
                }*/
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

              /*  if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    int dividerMode = ParseHelper.parseDividerMode(value);
                    // noinspection ResourceType
                    view.setShowDividers(dividerMode);
                }*/
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


