package com.astooltech.advancedview.proteus.demo.api;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

public class fragmentexam extends Fragment {


   // private Context context;
       String namefrag;
    ProteusLayoutInflater inflaterr;
    ProteusManager proteusManager;
private  boolean ccd=false;
    Layout proteusManagerlay;
    public  fragmentexam(String name,    ProteusLayoutInflater inflater,ProteusManager proteusManager,View v
    ){

        this.namefrag=name;
        this.inflaterr=inflater;
        this.proteusManager=proteusManager;

    }
    public  fragmentexam(String name,    ProteusLayoutInflater inflater,View v
    ){

        this.namefrag=name;
        this.inflaterr=inflater;


    }

    public  fragmentexam(Layout proteusManagerlayy,    ProteusLayoutInflater inflater,View v
    ){
this.ccd=true;
        this.proteusManagerlay=proteusManagerlayy;
        this.inflaterr=inflater;


    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
if(this.ccd) {
    ProteusView vieww = inflaterr.inflate(proteusManagerlay, proteusManager == null ? new ObjectValue() : proteusManager.getData());
    vieww.getAsView().getId();
    return vieww.getAsView();
}else{
    ProteusView vieww = inflaterr.inflate(namefrag, proteusManager == null ? new ObjectValue() : proteusManager.getData());
    vieww.getAsView().getId();
    return vieww.getAsView();

}
    }


}
