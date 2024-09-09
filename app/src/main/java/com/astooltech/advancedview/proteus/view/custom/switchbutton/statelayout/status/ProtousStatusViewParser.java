package com.astooltech.advancedview.proteus.view.custom.switchbutton.statelayout.status;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;

import java.util.Iterator;


public class ProtousStatusViewParser<T extends StatusView> extends ViewTypeParser<T> {

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
        return "StatusLayout";
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
        return new ProtousStatusView(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {
        addAttributeProcessor("proper", new AttributeProcessor<T>() {

                    @Override
                    public void handleValue( T view, Value value) {
                        Array cxx=value.getAsObject().getAsArray("child");

int cv=0;
                        Iterator<Value> vv = cxx.iterator();
                        while (vv.hasNext()) {
                            Value ddert = vv.next();
                            // counnnt = ddert.getValue().getAsArray().size();
cv=cv+1;

if(cv==1){

    View f=((ProtousStatusView)view).getViewManager().getContext().getInflater().inflate(ddert.getAsLayout(),new ObjectValue()).getAsView();
view.setmCompleteView(f);
}

                            if(cv==2){

                                View f=((ProtousStatusView)view).getViewManager().getContext().getInflater().inflate(ddert.getAsLayout(),new ObjectValue()).getAsView();
                                view.setmErrorView(f);
                            }


                            if(cv==3){

                                View f=((ProtousStatusView)view).getViewManager().getContext().getInflater().inflate(ddert.getAsLayout(),new ObjectValue()).getAsView();
                                view.setmLoadingView(f);
                            }

                            if(cv==4){

                                View f=((ProtousStatusView)view).getViewManager().getContext().getInflater().inflate(ddert.getAsLayout(),new ObjectValue()).getAsView();
                                view.setmCustomView(f);
                            }
                            //;
                           // ComplexItemEntity y=new ComplexItemEntity("hh","gfg","hgh",ddert.getAsLayout());

                           // uy.add(y);

                        }
                        view.invalidate();

                        final ProtousStatusView dr=(ProtousStatusView)view;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                dr.setStatus(Status.LOADING);
                            }
                        }, 6000);
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

            addAttributeProcessor("knbs", new StringAttributeProcessor<T>() {
            @Override
            public void setString(final T view, String value) {
                boolean dd=false;
                try {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            StatusView d=(StatusView)view;
                            d.setStatus(Status.LOADING);
                        }
                    }, 6000);

                    // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }
}
