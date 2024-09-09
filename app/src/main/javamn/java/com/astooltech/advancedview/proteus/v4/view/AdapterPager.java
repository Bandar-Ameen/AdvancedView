package com.astooltech.advancedview.proteus.v4.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AdapterPager extends FragmentStatePagerAdapter {


    public AdapterPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       return  new myFrigment();
    }

    @Override
    public int getCount() {
        return 0;
    }
}
