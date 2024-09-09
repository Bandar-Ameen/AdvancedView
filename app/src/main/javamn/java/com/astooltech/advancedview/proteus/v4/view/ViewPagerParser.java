/*
 * Copyright 2019 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.astooltech.advancedview.proteus.v4.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.DataContext;
import com.astooltech.advancedview.proteus.ProteusContext;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.ViewTypeParser;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.ISlidingTabStrip;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.exam.fragment.DemoCardFragment;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.other.JTabStyleDelegate;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.OnTabSelectListener;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.ui.SimpleCardFragment;
import com.astooltech.advancedview.proteus.managers.AdapterBasedViewManager;
import com.astooltech.advancedview.proteus.parser.custom.PagerAdapter;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.EventProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.AttributeResource;
import com.astooltech.advancedview.proteus.value.Binding;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Resource;
import com.astooltech.advancedview.proteus.value.StyleResource;
import com.astooltech.advancedview.proteus.value.Value;
import com.astooltech.advancedview.proteus.view.ProteusRadioButtonGroup;
import com.astooltech.advancedview.proteus.view.ProteusRappleLayout;
import com.astooltech.advancedview.proteus.view.TextInputLayoutB;
import com.astooltech.advancedview.proteus.view.custom.ProtouseSegementLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ViewPagerParser
 *
 * @author adityasharat
 */

public class ViewPagerParser<T extends ViewPager> extends ViewTypeParser<T> {
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
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable RadioGroup parent, int dataIndex) {
    return new ProteusRadioButtonGroup(context);
  }
  @NonNull
  @Override
  public String getType() {
    return "ViewPager";
  }

  @Nullable
  @Override
  public String getParentType() {
    return "ViewGroup";
  }

  @NonNull
  @Override
  public ProteusView createView(@NonNull ProteusContext context, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewGroup parent, int dataIndex) {
    return new ProteusViewPager(context);
  }

  @NonNull
  @Override
  public ProteusView.Manager createViewManager(@NonNull ProteusContext context, @NonNull ProteusView view, @NonNull Layout layout, @NonNull ObjectValue data, @Nullable ViewTypeParser caller, @Nullable ViewGroup parent, int dataIndex) {
    DataContext dataContext = createDataContext(context, layout, data, parent, dataIndex);
    return new AdapterBasedViewManager(context, null != caller ? caller : this, view.getAsView(), layout, dataContext);
  }

  private class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles_3 = {"首页", "消息", "联系人", "更多"};
    public MyPagerAdapter(FragmentManager fm) {
      super(fm);
      for (String title : mTitles_3) {
        mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
      }
    }

    @Override
    public int getCount() {
      return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mTitles_3[position];
    }

    @Override
    public Fragment getItem(int position) {
      return mFragments.get(position);
    }
  }
  public class MyPagerAdapterr extends FragmentPagerAdapter implements ISlidingTabStrip.IconTabProvider {

    String mTitles[];
    int[] mSelectors;
    public MyPagerAdapterr(FragmentManager fm,String mTitles[],int[] mSelectors){
      super(fm);
      this.mTitles=mTitles;
      this.mSelectors=mSelectors;
    }


    @Override
    public CharSequence getPageTitle(int position){
      return mTitles[position%4];
    }


    @Override
    public int getCount(){
      return mTitles.length;
    }


    @Override
    public Fragment getItem(int position){
      return DemoCardFragment.newInstance(position);
    }


    @Override
    public int[] getPageIconResIds(int position){
      //return new int[]{mNormal[position%4],mPressed[position%4]};
      return null;
    }


    @Override
    public int getPageIconResId(int position){
      //		return mPressed[position];
      return mSelectors[position%4];
    }
  }

  @Override
  protected void addAttributeProcessors() {





    addAttributeProcessor("mg", new StringAttributeProcessor<T>() {
      @Override
      public void setString(final T view, String value) {
        //view.setMax((int) ParseHelper.parseDouble(value));
          Log.i("888877","jhjhjhjhjhjhjhjh");
        String Idtag3="5";//view.getTag(R.id.tag3).toString();
       final String[] mTitles_3 = {"首页", "消息", "联系人", "更多"};
        final  String  nametage=Idtag3;
    final ArrayList<Fragment> mFragments = new ArrayList<>();
        ProteusView.Manager.ActionEventView Act = new ProteusView.Manager.ActionEventView() {
          @Override
          public void sendEvent(@Nullable ObjectValue data, int typ, Object anotherdata) {

          }

          @Override
          public void sendEvent(@Nullable ObjectValue data, int typ, String anotherdata) {

          }

          @Override
          public void getresultsearch(@Nullable List<OOverIttem> data, int typ, String anotherdata) {

          }

          @Override
          public void getFragment(ProteusView vm, int typ, String anotherdata, FragmentManager mfrag) {
              ProteusViewPager dd=(ProteusViewPager) vm;
            String IDDdat = "5";//vm.getAsView().getTag(R.id.tag3).toString();
            //  Log.i("888877","jhjhjhjhjhjhjhjh");
            if(nametage.equals(IDDdat)) {
            /*  String mt[] =dd.getContext().getResources().getStringArray(R.array.tabs);
              int ms[] = new int[]{R.drawable.tab1, R.drawable.tab2, R.drawable.tab3, R.drawable.tab4};
              MyPagerAdapterr adapter = new MyPagerAdapterr(mfrag, mt, ms);
              dd.setAdapter(adapter);
              //  Log.i("888877","jhjhjhjhjhjhjhjh");

              final int pageMargin = (int) TypedValue
                      .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4,dd.getContext().getResources().getDisplayMetrics());
             dd.setPageMargin(pageMargin);

                ISlidingTabStrip drt = (ISlidingTabStrip) ((ProteusViewPager) dd).getViewManager().getContext().getInflater().inflate("mlov", new ObjectValue()).getAsView();

             //   drt.getTabsContainer().setBackgroundColor(R.color);
                setupStrip(drt.getTabStyleDelegate(), STYLE_DEFAULT,dd.getContext());

                drt.bindViewPager(dd);
*/
            //  ISlidingTabStrip drt = (ISlidingTabStrip)

              final ProtouseSegementLayout mTabLayout_3=(ProtouseSegementLayout)((ProteusViewPager) dd).getViewManager().getContext().getInflater().inflate("mlov", new ObjectValue()).getAsView();

              mTabLayout_3.setTabData(mTitles_3,mfrag,1, mFragments );
             view.setAdapter(new MyPagerAdapter(mfrag));

              mTabLayout_3.setTabData(mTitles_3);
              mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
                @Override
                public void onTabSelect(int position) {
                 view.setCurrentItem(position);
                }

                @Override
                public void onTabReselect(int position) {
                }
              });

            view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
             view.setCurrentItem(1);
              //adapter.notifyDataSetChanged();
            }
          }
        };


        if (((ProteusViewPager) view).getViewManager().getActionEventView() == null) {
          ((ProteusViewPager) view).getViewManager().setActionEventView(Act);
          //((ProteusRecyclerView) view).getViewManager().setActionEventView(Act);

        }
        final String[] ggg = new String[]{"0"};
        final EventProcessor uuip = new EventProcessor() {
          @Override
          public void setOnEventListener(View view, Value value) {

          }
        };


        uuip.triggerAdapter(150, true, Idtag3, Idtag3, null, (ProteusView) view, uuip, ggg);

        // drt.bindViewPager(view);

      }
    });

    addAttributeProcessor("Show_View", new AttributeProcessor<T>() {
      @Override
      public void handleBinding(T view, Binding value) {


      }

      @Override
      public void handleValue(T view, Value value) {
        Array getArray=value.getAsObject().getAsArray("ShowViews");
List<Layout> p=new ArrayList<>();
        Iterator<Value> ffert=getArray.iterator();
        while (ffert.hasNext()){
          Value vf=ffert.next();
         /*if(vf.getAsObject().isLayout("Name_View")){

          ProteusView po =(ProteusView)((ProteusViewPager)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsLayout("Name_View"),new ObjectValue());
          p.add(po);
         }else {
           ProteusView po =(ProteusView)((ProteusViewPager)view).getViewManager().getContext().getInflater().inflate(vf.getAsObject().getAsString("Name_View"),new ObjectValue());
           p.add(po);

         }*/
            p.add(vf.getAsObject().getAsLayout("Name_View"));


        }
        /* int[] mIconSelectIds = {
                  R.drawable.tab_home_select, R.drawable.tab_speech_select,
                  R.drawable.tab_contact_select, R.drawable.tab_more_select};
       ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
          private String[] mTitles = {"首页", "消息", "联系人", "更多"};
          for (int i = 0; i < mTitles.length; i++) {
              mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i],0,null,null));
          }*/
          PagerAdapter px=new PagerAdapter(p,((ProteusViewPager)view).getViewManager().getContext().getInflater());


          view.setAdapter(px);
        //handleChildren(view, value);
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
  }

  private void setupStrip(JTabStyleDelegate tabStyleDelegate, int type,Context cc){
    tabStyleDelegate.setJTabStyle(type).setShouldExpand(true).setFrameColor(Color.parseColor("#45C01A"))
            .setTabTextSize(getDimen(R.dimen.tabstrip_textsize,cc))
            .setTextColor(Color.parseColor("#45C01A"), Color.GRAY)
//                .setDividerWidth(6)
            //.setTextColor(R.drawable.tabstripbg)
            .setDividerColor(Color.parseColor("#45C01A")).setDividerPadding(0)
            .setUnderlineColor(Color.parseColor("#3045C01A")).setUnderlineHeight(0)
            .setIndicatorColor(Color.parseColor("#7045C01A"))
            .setIndicatorHeight(getDimen(R.dimen.sug_event_tabheight,cc)).setFrameColor(Color.TRANSPARENT);
  }
  private int getDimen(int dimen, Context c){
    return (int)c.getResources().getDimension(dimen);
  }


}
