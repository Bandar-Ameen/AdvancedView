package com.astooltech.advancedview.proteus.parser.adapterskit;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.skeleton.SkeletonViewGroup;


public class mfrg  extends Fragment {

    private SkeletonViewGroup skeletonViewGroup;
    private TextView textTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_shape_xml, container, false);



        // Toolbar


        skeletonViewGroup = view.findViewById(R.id.skeletonGroup);
        textTv = view.findViewById(R.id.textTv);
        skeletonViewGroup.setSkeletonListener(new SkeletonViewGroup.SkeletonListener() {
            @Override
            public void onStartAnimation() {

            }

            @Override
            public void onFinishAnimation() {
                textTv.setText("The Android O release ultimately became Android 8.0 Oreo, as predicted by pretty much everyone the first time they thought of a sweet");
            }
        });


        //after 5 second finish animation s
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                skeletonViewGroup.finishAnimation();
            }
        }, 5000);

   return view;
    }


}