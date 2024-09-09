package com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget.inboxlayout;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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
import com.astooltech.advancedview.proteus.view.custom.switchbutton.inbox.widget.InboxBackgroundScrollView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class protouseInboxBackgroundScrollViewParser<T extends InboxBackgroundScrollView> extends ViewTypeParser<T> {
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
        return "BackgroundScroll";
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
        return new protouseInboxBackgroundScrollView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor("child", new AttributeProcessor<T>() {


            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void handleValue(T view, Value value) {


                        boolean dir=value.getAsObject().getAsBoolean("a11");

                        view.setActivated(dir);
                        view.setAlpha(value.getAsObject().getAsInteger("a3"));
                        view.setElevation(value.getAsObject().getAsInteger("a2"));
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
                  //  view.set
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
