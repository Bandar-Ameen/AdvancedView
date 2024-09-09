package com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
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
import com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget.inboxlayout.protouseInboxBackgroundScrollView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class protouseInboxLayoutScrollViewParser<T extends InboxLayoutScrollView> extends ViewTypeParser<T> {
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
        return "InboxLayout";
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
        return new protouseInboxLayoutScrollView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("child", new AttributeProcessor<T>() {


            @Override
            public void handleValue(T view, Value value) {
                Layout dir=value.getAsObject().getAsLayout("back");
                protouseInboxLayoutScrollView rr=(protouseInboxLayoutScrollView)view;
              ProteusView e=  rr.getViewManager().getContext().getInflater().inflate(dir,new ObjectValue());

                protouseInboxBackgroundScrollView er=(protouseInboxBackgroundScrollView)e.getAsView();

                rr.setBackgroundScrollView(er);



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
        addAttributeProcessor(Attributes.View.DateFromat, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {

                    @SuppressLint("SimpleDateFormat")
                    SimpleDateFormat g=new SimpleDateFormat(value);
                    Calendar v=Calendar.getInstance();
                    String ggh=g.format(v.getTime());
                    int yerr,month,day;
                    month=v.get(Calendar.MINUTE);
                    yerr=v.get(Calendar.YEAR);
                    day=v.get(Calendar.DAY_OF_MONTH);
                   // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }
}
