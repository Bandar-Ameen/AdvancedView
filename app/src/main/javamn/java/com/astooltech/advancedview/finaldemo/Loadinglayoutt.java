package com.astooltech.advancedview.finaldemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.view.loadingeverywhere.GenericStatusLayout;
import com.astooltech.advancedview.proteus.view.widget.MultiOverlayAdapter;
import com.astooltech.advancedview.proteus.view.widget.MultiOverlayLayout;

public class Loadinglayoutt  extends MultiOverlayLayout implements  showStause{
private Context context;
    public static final int POSITION_LOADING = 0;
    public static final int POSITION_EMPTY = 1;
    public static final int POSITION_ERROR = 2;

    public int getTypshow() {

        return typshow;
    }

    public void setTypshow(int typshow) {
        this.typshow = typshow;
    }

    public showlogin getShowlogin() {
        return showlogin;
    }

    public void setShowlogin(showlogin showlogin) {
        this.showlogin = showlogin;
    }

    private showlogin showlogin;
    private int typshow;
    public String getMessagess() {
       if(Messagess==null){
           Messagess=" ";
       }
        return Messagess;
    }

    public void setMessagess(String messagess) {
        Messagess = messagess;
    }

    private  String Messagess;
    GenericStatusLayout.ILayerCreator mLayerCreator;
    public Loadinglayoutt(Context context) {
        super(context);
        typshow=0;
        setDefalutAdapter();

    }

    public Loadinglayoutt(Context context, AttributeSet attrs) {
        super(context, attrs);
        typshow=0;
        setDefalutAdapter();
    }

    public Loadinglayoutt(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        typshow=0;
        setDefalutAdapter();
    }
    private void setDefalutAdapter() {
        super.setAdapter(new MultiOverlayAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public View getView(int index, View targetView) {
                View retView = null;
                switch (index) {
                    default:
                    case POSITION_LOADING:
                        if(mLayerCreator!=null){
                            retView = mLayerCreator.createLoadingLayer();
                        }else {
                            retView = LayoutInflater.from(getContext()).inflate(R.layout.load_lay, (ViewGroup) getParent(), false);

                               TextView t = retView.findViewById(R.id.textstustuse);

                               t.setText(getMessagess());

                        }
                        break;
                    case POSITION_EMPTY:
                        if(mLayerCreator!=null){
                            retView = mLayerCreator.createEmptyLayer();
                        }else {
                            retView = LayoutInflater.from(getContext()).inflate(R.layout.empty, (ViewGroup) getParent(), false);
                        }
                        break;
                    case POSITION_ERROR:
                        if(mLayerCreator!=null){
                            retView = mLayerCreator.createLoadingLayer();
                        }else {
                            retView = LayoutInflater.from(getContext()).inflate(R.layout.merror, (ViewGroup) getParent(), false);

                            TextView t = retView.findViewById(R.id.textstustuse);
                            Button retry=retView.findViewById(R.id.retrys);
                            retry.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(getShowlogin()!=null){
                                        getShowlogin().OnRetray();
                                    }
                                }
                            });
                            t.setText(getMessagess());

                        }

                        break;
                }
                return retView;
            }
        });
    }
    @Override
    public void setAdapter(MultiOverlayAdapter multiOverlayAdapter) {
        //disable setAdapter
    }

    public void setLayerCreator(GenericStatusLayout.ILayerCreator layerCreator){
        mLayerCreator = layerCreator;
    }

    public void showLoading(){
        showOverlay(POSITION_LOADING);
    }
    public void showEmpty(){
        showOverlay(POSITION_EMPTY);
    }
    public void showError(){
        showOverlay(POSITION_ERROR);
    }


    public void hideLoading(){
        hideOverlay(POSITION_LOADING);
    }
    public void hideEmpty(){
        hideOverlay(POSITION_EMPTY);
    }
    public void hideError(){
        hideOverlay(POSITION_ERROR);
    }

    @Override
    public void setStatuse(String statusemess) {

    }
}

