package com.astooltech.advancedview.proteus.v4.view;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.CustomTabEntity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.OnTabSelectListener;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.entity.TabEntity;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.parser.custom.PagerAdapter;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DimensionAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.DrawableResourceProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusLinearLayout;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseCommonTabLayout;
import com.astooltech.advancedview.proteus.view.custom.ProtouseExpandIconView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProtouseLinnerLayoutPager<T extends LinearLayout> extends ViewTypeParser<T> {


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
        return "PagerLinearLayout";
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
        return new ProteusLinearLayout(context);
    }

    @NonNull
    @Override
    public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
        return new ProteusRadioButtonGroup(context);
    }

    @Override
    protected void addAttributeProcessors() {

        addAttributeProcessor(Attributes.LinearLayout.Orientation, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if ("horizontal".equals(value)) {
                    view.setOrientation(ProteusLinearLayout.HORIZONTAL);
                } else {
                    view.setOrientation(ProteusLinearLayout.VERTICAL);
                }

/*final View eer=view;
       final   OverlayLayout    mlayout=new OverlayLayout(view.getContext()) {
              @Override
              protected View createOverlayView() {


                  return eer;
              }
          };
         ;*/
            }
        });
        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });

        addAttributeProcessor("ViewEx", new AttributeProcessor<T>() {
            @Override
            public void handleValue(T view, Value value) {
                try{

                    Layout re=value.getAsObject().getAsLayout("Expand");

                    ///String val=value.getAsObject().getAsString("ExpandName");
                    Layout vald=value.getAsObject().getAsLayout("ExpandIconLayout");
                    ProtouseExpandIconView viw=(ProtouseExpandIconView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(re,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    ProteusLinearLayout viwm=(ProteusLinearLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vald,((ProteusLinearLayout) view).getViewManager().getDataContext().getData()).getAsView();
                    viwm.addView(viw);
                    try {
                        //;
   /* if(view.getChildAt(0) instanceof ProteusLinearLayout){
      ProteusLinearLayout t=(ProteusLinearLayout)   view.getChildAt(0);
      t.addView(viw);

    }else{
      view.addView(viw);
    } *///.addView(viw);
                    }catch (Exception ex){
                        // view.addView(viw);
                        // view.addView(viw);
                    }
                    view.addView(viwm);
                    view.addView(viw.GetviewExpand());

                    //   view.setRippleDelayClick(dd);//.setAspectRatioHeight(ParseHelper.parseInt(value));

                }catch (Exception ex){


                }
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


        addAttributeProcessor("ViewPagers", new AttributeProcessor<T>() {
            @Override
            public void handleValue( T view, Value value) {


                final ProteusViewPager pagers=value.getAsObject().isLayout("Pager_Views")?
                        (ProteusViewPager)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsLayout("Pager_Views"),new ObjectValue()):
                        (ProteusViewPager)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsString("Pager_Views"),new ObjectValue());
              ProteusLinearLayout liner=value.getAsObject().isLayout("Linear_Views")?
                        (ProteusLinearLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsLayout("Linear_Views"),new ObjectValue()):
                        (ProteusLinearLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsString("Linear_Views"),new ObjectValue());


                final ProtouseCommonTabLayout mTabLayout_3=value.getAsObject().isLayout("Comman_Views")?
                        (ProtouseCommonTabLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsLayout("Comman_Views"),new ObjectValue()):
                        (ProtouseCommonTabLayout)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(value.getAsObject().getAsString("Comman_Views"),new ObjectValue());
                Array getArray=value.getAsObject().getAsArray("ShowViews");
                String[] mTitles=new String[getArray.size()];
                int[] mIconSelectIds=new int[getArray.size()];
                int[] mIconUnselectIds=new int[getArray.size()];

                Drawable[] selct=new Drawable[getArray.size()];
                Drawable[] unselct=new Drawable[getArray.size()];
                int count=0;
                List<Layout> p=new ArrayList<>();
                Iterator<Value> ffert=getArray.iterator();
                while (ffert.hasNext()){
                    Value vf=ffert.next();
String titleviews=vf.getAsObject().getAsString("Title_Views");
                    mTitles[count]=titleviews;
                    mIconSelectIds[count]=R.drawable.tab_home_select;
                    mIconUnselectIds[count]= R.drawable.tab_home_unselect;
                    if(vf.getAsObject().isLayout("Icon_Select")){

                        ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsLayout("Icon_Select"),new ObjectValue());
                        Drawable uns= po.getAsView().getBackground();
                        selct[count]=uns;
                        // p.add(po);
                    }else {
                        ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsString("Icon_Select"),new ObjectValue());
                        Drawable uns= po.getAsView().getBackground();
                        selct[count]=uns;

                    }
                    if(vf.getAsObject().isLayout("Icon_UnSelect")){

                        ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsLayout("Icon_UnSelect"),new ObjectValue());
                        Drawable uns= po.getAsView().getBackground();
                        unselct[count]=uns;
                    }else {
                        ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsString("Icon_UnSelect"),new ObjectValue());
                        Drawable uns= po.getAsView().getBackground();
                        unselct[count]=uns;

                    }
                    count=count+1;


                    p.add(vf.getAsObject().getAsLayout("Name_View"));
                   /* if(vf.getAsObject().isLayout("Name_View")){

                      //  ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(,new ObjectValue());
                        //p.add(po);
                    }else {
                        ProteusView po =(ProteusView)((ProteusLinearLayout)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsString("Name_View"),new ObjectValue());
                        p.add(po);

                    }*/



                }

                ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
                // = {"首页", "消息", "联系人", "更多"};
              /*  = {
                        R.drawable.tab_home_unselect, R.drawable.tab_speech_unselect,
                        R.drawable.tab_contact_unselect, R.drawable.tab_more_unselect};*/
                for (int i = 0; i < mTitles.length; i++) {
                    mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[0], mIconUnselectIds[0],1,selct[i],unselct[i]));
                    //mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i],0,null,null));
                }
                //String[] color=null;
                // =(ProtouseCommonTabLayout)((ProteusLinearLayout) view).getViewManager().getContext().getInflater().inflate(fragm, new ObjectValue()).getAsView();

                mTabLayout_3.setIndicatorColor(ParseHelper.parseColor("#"+value.getAsObject().getAsString("ColorA")));//="#ffffff"
                mTabLayout_3.setTextSelectColor(ParseHelper.parseColor("#"+value.getAsObject().getAsString("ColorB")));
                mTabLayout_3.setTextUnselectColor(ParseHelper.parseColor("#"+value.getAsObject().getAsString("ColorC")));
                mTabLayout_3.setIndicatorCornerRadius(Float.valueOf(value.getAsObject().get("Content_Radius").toString()));
                mTabLayout_3.setTabData(mTabEntities);
                mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                    @Override
                    public void onTabSelect(int position) {
                        pagers.setCurrentItem(position);
                    }

                    @Override
                    public void onTabReselect(int position) {

                    }

                });
                PagerAdapter px=new PagerAdapter(p,((ProteusLinearLayout)view).getViewManager().getContext().getInflater());


                pagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                        mTabLayout_3.setCurrentTab(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
                pagers.setAdapter(px);
                liner.addView(mTabLayout_3);
                liner.addView(pagers);

                view.addView(liner);
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


        addAttributeProcessor("exview", new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {


            }
        });

        addAttributeProcessor(Attributes.View.Gravity, new GravityAttributeProcessor<T>() {
            @Override
            public void setGravity(T view, @Gravity int gravity) {
                view.setGravity(gravity);
            }
        });
        addAttributeProcessor(Attributes.View.viewTofront, new StringAttributeProcessor<T>() {
            @Override
            public void setString(T view, String value) {
                if(value.equals("1")) {

                    view.bringToFront();
                    view.invalidate();
                }

            }
        });


        addAttributeProcessor(Attributes.LinearLayout.Divider, new DrawableResourceProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDrawable(T view, Drawable drawable) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerDrawable(drawable);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.DividerPadding, new DimensionAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setDimension(T view, float dimension) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    view.setDividerPadding((int) dimension);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.ShowDividers, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {

                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
                    int dividerMode = ParseHelper.parseDividerMode(value);
                    // noinspection ResourceType
                    view.setShowDividers(dividerMode);
                }
            }
        });

        addAttributeProcessor(Attributes.LinearLayout.WeightSum, new StringAttributeProcessor<T>() {
            @SuppressLint("NewApi")
            @Override
            public void setString(T view, String value) {
                view.setWeightSum(ParseHelper.parseFloat(value));
            }
        });
    }


}

