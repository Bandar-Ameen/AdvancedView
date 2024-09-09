package com.astooltech.advancedview.proteus.parser.custom;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.util.List;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

    private List<Layout> prop;
    private ProteusLayoutInflater inflater;
    public PagerAdapter(List<Layout> pro,ProteusLayoutInflater inflaterr){

        prop=pro;
        this.inflater=inflaterr;
    }

    @Override
    public int getCount() {
        return prop.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ProteusView)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        ProteusView p=inflater.inflate(prop.get(position),new ObjectValue());
        ProteusView v=p;
        container.addView(v.getAsView());
        return  v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View)object);
    }
}
