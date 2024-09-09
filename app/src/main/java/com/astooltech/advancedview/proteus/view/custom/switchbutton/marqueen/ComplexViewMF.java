package com.astooltech.advancedview.proteus.view.custom.switchbutton.marqueen;

import android.view.View;

import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.ObjectValue;


/**
 * 复合字幕
 *
 * @author xuexiang
 * @since 2019/1/14 下午10:13
 */
public class ComplexViewMF extends MarqueeFactory<View, ComplexItemEntity> {
    private ProteusView inflater;

    public ComplexViewMF(ProteusView v) {
       super(v.getAsView().getContext());
       inflater=v;

    }

    @Override
    public View generateMarqueeItemView(ComplexItemEntity data) {

    ProteusView x= inflater.getViewManager().getContext().getInflater().inflate(data.getMlay(),new ObjectValue());



        return x.getAsView();
    }

   /* @Override
    public RelativeLayout generateMarqueeItemView(ComplexItemEntity data) {
        RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.marqueen_layout_complex_view, null);
        ((TextView) view.findViewById(R.id.title)).setText(data.getTitle());
        ((TextView) view.findViewById(R.id.subTitle)).setText(data.getSubTitle());
        ((TextView) view.findViewById(R.id.time)).setText(data.getTime());
        return view;
    }*/
}