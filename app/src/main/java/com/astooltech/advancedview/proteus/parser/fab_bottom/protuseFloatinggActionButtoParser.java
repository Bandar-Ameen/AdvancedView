package com.astooltech.advancedview.proteus.parser.fab_bottom;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
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


public class protuseFloatinggActionButtoParser<T extends FloatingActionButton> extends ViewTypeParser<T> {

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
        return "FabView" ;
    }

    @Nullable
    @Override
    public String getParentType() {
        return "View";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {
        return new protuseFloatinggActionButton(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new protuseFloatinggActionButton(context);
    }

    @Override
    protected void addAttributeProcessors() {



        addAttributeProcessor("proper", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
              int size=value.getAsObject().getAsInteger("Fab_Size");
              String color=value.getAsObject().getAsString("Fab_ColorA");
              String colors=value.getAsObject().getAsString("Fab_ColorC");
            String fabtit=    value.getAsObject().getAsString("Fab_Title");

            view.setColorNormal(ParseHelper.parseColor("#"+color));
            view.setColorPressed(ParseHelper.parseColor("#"+colors));
            view.setSize(size==0?FloatingActionButton.SIZE_NORMAL:FloatingActionButton.SIZE_MINI);
            view.setTitle(fabtit);
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

            addAttributeProcessor(Attributes.RadioButton.Button, new DrawableResourceProcessor<T>() {
            @Override
            public void setDrawable(T view, Drawable drawable) {
                //view.setButtonDrawable(drawable);
            }
        });

        addAttributeProcessor(Attributes.RadioButton.Checked, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
               // view.setChecked(Boolean.parseBoolean(value));
            }
        });
    }
}