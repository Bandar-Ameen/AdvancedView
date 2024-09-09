package com.astooltech.advancedview.proteus.v4.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.JPagerSlidingTabStrip;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.other.JTabStyleDelegate;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;

public class protouseJPagerSlidingTabStripParser <T extends JPagerSlidingTabStrip> extends ViewTypeParser<T> {

@NonNull
@Override
public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
@Nullable com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout  parent, int dataIndex) {
        return new ProteusRappleLayout(context);
        }
@NonNull
@Override
public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
@Nullable TextInputLayout  parent, int dataIndex) {
        return new protouseJPagerSlidingTabStrip(context);
        }
@NonNull
@Override
public String getType() {
        return "mslider";
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
        return new protouseJPagerSlidingTabStrip(context);
        }

@NonNull
@Override
public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
        }

@Override
protected void addAttributeProcessors() {

        addAttributeProcessor("km", new StringAttributeProcessor<T>() {
                @Override
                public void setString(T view, String value) {
                        //view.setMax((int) ParseHelper.parseDouble(value));


                }
        });




}

    private void setupStrip(JTabStyleDelegate tabStyleDelegate, int type, Context cc){
        tabStyleDelegate.setJTabStyle(type).setShouldExpand(true).setFrameColor(Color.parseColor("#45C01A"))
                .setTabTextSize(getDimen(R.dimen.tabstrip_textsize,cc))
                .setTextColor(Color.parseColor("#45C01A"), Color.GRAY)
//                .setDividerWidth(6)
                //.setTextColor(R.drawable.tabstripbg)
                .setDividerColor(Color.parseColor("#45C01A")).setDividerPadding(0)
                .setUnderlineColor(Color.parseColor("#3045C01A")).setUnderlineHeight(0)
                .setIndicatorColor(Color.parseColor("#7045C01A"))
                .setIndicatorHeight(getDimen(R.dimen.sug_event_tabheight,cc)).setFrameColor(Color.TRANSPARENT);
    }
    private int getDimen(int dimen, Context c){
        return (int)c.getResources().getDimension(dimen);
    }

        }
