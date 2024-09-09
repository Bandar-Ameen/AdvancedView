package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.widget.OverlayLayout;


/**
 * Created by kirankumar on 10/07/14.
 */
public class ProtouseMultipleStatusViewParser<T extends OverlayLayout> extends ViewTypeParser<T> {

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
        return "LoadingLayout";
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
        return new ProtouseMultipleStatusView(context);
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
try{

    Layout fffd=value.getAsObject().get("LoaderView").getAsLayout();
   Layout fffdd=value.getAsObject().get("LoaderViewChild").getAsLayout();
    ProtouseMultipleStatusView ggf=(ProtouseMultipleStatusView)view;

    ProteusView ert=           ggf.getViewManager().getContext().getInflater().inflate(fffd,new ObjectValue());
    ProteusView ertt=           ggf.getViewManager().getContext().getInflater().inflate(fffdd,new ObjectValue());

    ggf.SetOverlayView(ert.getAsView());



    ggf.attachTo(ertt.getAsView());
    ggf.showOverlay();
    final ProtouseMultipleStatusView u=ggf;
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

           u.hideOverlay();
        }
    }, 6000);

}catch (Exception ex){

}
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
            addAttributeProcessor("knb", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                boolean dd=false;
                try {



                   /* view.showCustom(new CustomStateOptions());
view.setAnimationEnabled(true);
view.showContent();
                    view.showLoading();
*/
                   // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }
}
