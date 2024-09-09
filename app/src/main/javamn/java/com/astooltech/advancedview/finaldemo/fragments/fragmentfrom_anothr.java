package com.astooltech.advancedview.finaldemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.fragments.AbstractFragment;
import com.astooltech.advancedview.proteus.demo.api.getmessage_status;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.view.StatuseLayout;

public class fragmentfrom_anothr extends AbstractFragment implements getmessage_status {

    private Fragment mFragments;
    public static fragmentfrom_anothr newInstance(Fragment fragments) {


        fragmentfrom_anothr fragment = new fragmentfrom_anothr(fragments);

        return fragment;
    }
   public fragmentfrom_anothr(Fragment fragments) {

       mFragments=fragments;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_recycler_view, container, false);

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
            }
        }
    }

    @Override
    public void showmessage(String message, int typ, String keyname) {

    }
}
