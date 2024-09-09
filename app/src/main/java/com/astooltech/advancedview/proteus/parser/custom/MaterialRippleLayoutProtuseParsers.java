package com.astooltech.advancedview.proteus.parser.custom;

import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusAspectRatioFrameLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.AspectRatioFrameLayout;


public class MaterialRippleLayoutProtuseParsers<T extends AspectRatioFrameLayout> extends ViewTypeParser<T> {

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
        return "RippleFrame";
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
        return new ProteusRappleLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("load", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                //  view.setAspectRatioHeight(ParseHelper.parseInt(value));
       /* DynamicBox  box=new DynamicBox(((ProteusAspectRatioFrameLayout)view).getViewManager().getContext().getActvityAllt(),view);
        box.setLoadingMessage("now Loading....");
        box.setInternetOffMessage("no Enternet Connection");
        box.setOtherExceptionMessage("noooo other");
        box.setClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

          }
        });
        box.showLoadingLayout();*/
            }
        });

        addAttributeProcessor(Attributes.FrameLayout.HeightRatio, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                view.setAspectRatioHeight(ParseHelper.parseInt(value));

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
                view.setAspectRatioWidth(ParseHelper.parseInt(value));

            }
        });
    }
}
