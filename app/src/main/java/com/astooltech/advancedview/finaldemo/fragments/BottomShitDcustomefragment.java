package com.astooltech.advancedview.finaldemo.fragments;

import static com.astooltech.advancedview.GlobalClass.Whiting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractShitFragment;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.view.StatuseLayout;

public class BottomShitDcustomefragment extends AbstractShitFragment implements getmessage_status, StatuseLayout {

    private Fragment mFragments;
    public static BottomShitDcustomefragment newInstance(Fragment fragments) {


        BottomShitDcustomefragment fragment = new BottomShitDcustomefragment(fragments);

        return fragment;
    }
    public BottomShitDcustomefragment(Fragment fragments) {

        mFragments=fragments;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_recycler_view, container, false);
        addloadin();
        childFragments(view, savedInstanceState);

        return view;
    }
    @Override
    protected void childFragments(View view, Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            if(mFragments!=null) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.baaa, mFragments);

                transaction.commit();
                try {
                    A_loadingbar.hideLoading();
                    A_loadingbar.hideError();
                }catch (Exception ex){

                }
            }
        }
    }

    @Override
    public void showmessage(String message, int typ, String keyname) {

    }
private void addloadin(){
    try {
        A_loadingbar = getView().findViewById(R.id.fragment_Loading);
        A_loadingbar.setShowlogin(this);
        A_loadingbar.setMessagess(Whiting);
        //  dqq.attachTo(loginsys);
        A_loadingbar.showLoading();
    }catch (Exception ex){

    }
}
    @Override
    public void loadfinshed() {
        try {
            A_loadingbar.hideLoading();
            A_loadingbar.hideError();
        }catch (Exception ex){

        }
    }

    @Override
    public void onerror(String mess, Object ob) {
        try {
            A_loadingbar.setMessagess(mess);
            A_loadingbar.hideLoading();
            A_loadingbar.showError();
        }catch (Exception ex){

        }
    }

    @Override
    public void OnRetray() {

    }
}
