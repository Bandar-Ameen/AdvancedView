package com.astooltech.advancedview.proteus.view.custom.switchbutton.marqueen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.astooltech.advancedview.R;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProtouseMarqueeViewParser<T extends MarqueeView> extends ViewTypeParser<T> {

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
        return "ComplexLayout";
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

      //  StatusLoader.from( new loaderStatus()).wrap(context.getActvityAllt()).showLoading();

        return new ProtouseMarqueeView(context);
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


                        int durat=value.getAsObject().getAsInteger("Duration");
                        int inter=value.getAsObject().getAsInteger("Interval");
                        int dir=value.getAsObject().getAsInteger("dir");
                        List<ComplexItemEntity> uy=new ArrayList<>();
Array cxx=value.getAsObject().getAsArray("child");


                        Iterator<Value> vv = cxx.iterator();
                        while (vv.hasNext()) {
                         Value ddert = vv.next();
                            // counnnt = ddert.getValue().getAsArray().size();


                            //;
                            ComplexItemEntity y=new ComplexItemEntity("hh","gfg","hgh",ddert.getAsLayout());

                            uy.add(y);

                        }

MarqueeFactory<View,ComplexItemEntity> rre= new ComplexViewMF((ProtouseMarqueeView)view);//SimpleNoticeMF(view.getContext());

//List<String> dder= Arrays.asList("mmnbbbb","jhjhjgjghjg","jghjghjghjg","hjghjghghjg","hgjhghjg");
view.setMarqueeFactory(rre);

view.setAnimDuration(durat);
view.setInterval(inter);
if(dir==1) {
    view.setAnimInAndOut(R.anim.marquee_left_in, R.anim.marquee_right_out);
    view.startFlipping();
}else {
    view.setAnimInAndOut(R.anim.marquee_right_in, R.anim.marquee_left_out);
    view.startFlipping();
}
/*rre.setOnItemClickListener(new MarqueeFactory.OnItemClickListener<TextView, String>() {
    @Override
    public void onItemClick(View view, MarqueeFactory.ViewHolder<TextView, String> holder) {
        Toast.makeText(view.getContext(),holder.getData(),Toast.LENGTH_LONG).show();
    }
});*/
rre.setData(uy);

                      //  StatusLoader.from( new loaderStatus()).wrap(view).showLoading();

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

                    /*view.setAnimationEnabled(true);
                    view.showContent();
                    view.showLoading();*/

                    // view.setText(ggh);

                }catch (Exception e){

                }

                // view.setCalendarViewShown(false);
                //  view .setSpinnersShown(dd);
            }
        });
    }
}
