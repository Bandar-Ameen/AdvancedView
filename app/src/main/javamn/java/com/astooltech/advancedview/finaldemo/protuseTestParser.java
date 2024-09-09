package com.astooltech.advancedview.finaldemo;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.parser.DataValueSelect;
import com.astooltech.advancedview.proteus.parser.custom.MaterialRippleLayout;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;


public class protuseTestParser<T extends Loadinglayoutt> extends ViewTypeParser<T> {


    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable MaterialRippleLayout parent, int dataIndex) {
        return new ProteusRappleLayout(context);
    }



    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable com.google.android.material.textfield.TextInputLayout parent, int dataIndex) {
        return new TextInputLayoutB(context);
    }

    @NonNull
    @Override
    public String getType() {
        return "LinearLayoutAna";
    }

    @Nullable
    @Override
    public String getParentType() {
        return "ViewGroup";
    }
private  protuseTest it;
    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data,
                                  @Nullable ViewGroup parent, int dataIndex) {


           it=new protuseTest(context);

        return it;
    }

    @Override
    public void GetAndSetData(ProteusView view, DataValueSelect data, int typoper, Object anotherdat, String viewname) {
        super.GetAndSetData(view, data, typoper, anotherdat, viewname);
        if(it.getTag(R.id.tag3).toString().equals(viewname)) {
          if(typoper==1) {
              it.hideLoading();
          }else {
              it.showLoading();
          }
        }
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("Cus", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T t, Value value) {


                showlogin f=new showlogin() {
                    @Override
                    public void loadfinshed() {

                    }

                    @Override
                    public void onerror(String mess, Object ob) {

                    }

                    @Override
                    public void OnRetray() {

                    }

                    @Override
                    public void loadmainActivity() {

                    }
                };

                t.setShowlogin(f);
                t.setMessagess("Now Loading ffffffff wait");
                t.showLoading();
            }

            @Override
            public void handleResource(T t, Resource resource) {

            }

            @Override
            public void handleAttributeResource(T t, AttributeResource attributeResource) {

            }

            @Override
            public void handleStyleResource(T t, StyleResource styleResource) {

            }
        });
        }
}