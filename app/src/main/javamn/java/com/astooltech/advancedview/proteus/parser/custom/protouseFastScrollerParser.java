package com.astooltech.advancedview.proteus.parser.custom;

import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.fastscroller.FastScroller;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
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


public class protouseFastScrollerParser<T extends FastScroller> extends ViewTypeParser<T> {

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
        return "FastScroll";
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
        return new protouseFastScroller(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {


        addAttributeProcessor("Fast", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {

                view.setAutoHideEnabled(true);
                view.setAutoHideDelayInMillis(1000);
                view.setbubbleEnabled(true);
                view.setBubblePosition(FastScroller.FastScrollerBubblePosition.ADJACENT);
                view.setHandleAlwaysVisible(true);
                view.setIgnoreTouchesOutsideHandle(false);

                /* app:fastScrollerAutoHideDelayInMillis="1000"
                app:fastScrollerAutoHideEnabled="true"
                app:fastScrollerBubbleEnabled="true"
                app:fastScrollerBubblePosition="adjacent"
                app:fastScrollerHandleAlwaysVisible="true"
                app:fastScrollerIgnoreTouchesOutsideHandle="false"*/
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

                    view.bringChildToFront(view);
                    //.bringToFront();
                    view.invalidate();
                }

            }
        });

    }
}
