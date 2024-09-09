package com.astooltech.advancedview.proteus.view.custom;

import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.BooleanAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


public class PrototousShadowLayoutParser<T extends ShadowLayout> extends ViewTypeParser<T> {

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
        return "ShadowLayout";
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
        return new PrototousShadowLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.FrameLayout.urlpath, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {


                //view.setPathOrUrl(value);
             //   view.setGravity(VideoLayout.VGravity.centerCrop);
                // view.setAspectRatioHeight(ParseHelper.parseInt(value));

            }
        });

        addAttributeProcessor(Attributes.FrameLayout.enabshado, new BooleanAttributeProcessor<T>() {
            @Override
            public void setBoolean(T view, boolean value) {
                view.setIsShadowed(value);
                view.setShadowAngle(45);
                view.setShadowRadius(20);
                view.setShadowDistance(30);
                view.setShadowColor(R.color.green);
            }
        });

        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringChildToFront(view);
                    //.bringToFront();
                    view.invalidate();
                }

            }
        });
        addAttributeProcessor(Attributes.FrameLayout.WidthRatio, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                // view.setAspectRatioWidth(ParseHelper.parseInt(value));

            }
        });
    }
}
