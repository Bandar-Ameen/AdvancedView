package com.astooltech.advancedview.proteus.design.widget;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


public class TabLayoutParser<T extends TabLayout> extends ViewTypeParser<T> {
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
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }
    @NonNull
    @Override
    public String getType() {
        return "TabLayout";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
        return new ProteusTabLayout(context);
    }

    @NonNull
    @Override
    public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent, int dataIndex) {
        DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
        return new AdapterBasedViewManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("titlev", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {

                Log.i("9999","000000000000000");
                view.setTabGravity(TabLayout.GRAVITY_FILL);
view.setTabMode(TabLayout.MODE_FIXED);

            //    view.setEdgeEffectColor(R.color.white);
             /*  FragmentManager fm= ((Activity)view.getContext())..getSupportFragmentManager();

                AdapterPager hh=new AdapterPager(fm,1);

                ggg.setAdapter(hh);*/
                //FragmentManager fm=
//ggg.setBackgroundColor(R.color.green);
               // TabLayout.Tab vv=view.newTab();

              //  ProteusView viewm = ().inflate(namee, proteusManager.getData());
              //  vv.setText("hghghg");
               // TabLayout.Tab bb=new TabLayout.Tab();
              /*  vv.setText("hghghglllllkkk");
               view.addTab(vv,0);*/
            //  view.setupWithViewPager(ggg);
              // view.addTab(bb,1,true);
            // view.

              //  view.setTitle(value);
            }
        });
    }
}
