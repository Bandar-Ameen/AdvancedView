package com.astooltech.advancedview.finaldemo;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.CommonTabLayout;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.CustomTabEntity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.listener.OnTabSelectListener;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.entity.TabEntity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.ui.CommonTabActivity;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.ui.SimpleCardFragment;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.tablayoutsamples.utils.ViewFindUtils;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.utils.UnreadMsgUtils;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tablayout.widget.MsgView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Random;

import static com.astooltech.advancedview.proteus.anotherView.viewSlider.widget.JToolbar.dp2px;

public class bittomshitdaloge extends BottomSheetDialogFragment {
    private Context mContext;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            com.astooltech.advancedview.R.drawable.tab_home_unselect, com.astooltech.advancedview.R.drawable.tab_speech_unselect,
            com.astooltech.advancedview.R.drawable.tab_contact_unselect, com.astooltech.advancedview.R.drawable.tab_more_unselect};
    private int[] mIconSelectIds = {
            com.astooltech.advancedview.R.drawable.tab_home_select, com.astooltech.advancedview.R.drawable.tab_speech_select,
            com.astooltech.advancedview.R.drawable.tab_contact_select, com.astooltech.advancedview.R.drawable.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private ViewPager mViewPager;
    private CommonTabLayout mTabLayout_1;
    private CommonTabLayout mTabLayout_2;
    private CommonTabLayout mTabLayout_3;
    private CommonTabLayout mTabLayout_4;
    private CommonTabLayout mTabLayout_5;
    private CommonTabLayout mTabLayout_6;
    private CommonTabLayout mTabLayout_7;
    private CommonTabLayout mTabLayout_8;

    public bittomshitdaloge(Context c) {
        mContext = c;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View mDecorView= inflater.inflate(com.astooltech.advancedview.R.layout.activity_common_tab, container, false);


        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment " + title));
        }


        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i], 0, null, null));
        }

       // mDecorView = getWindow().getDecorView();
        mViewPager = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.vp_2);
        mViewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));
        /** with nothing */
        mTabLayout_1 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_1);
        /** with ViewPager */
        mTabLayout_2 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_2);
        /** with Fragments */
        mTabLayout_3 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_3);
        /** indicator固定宽度 */
        mTabLayout_4 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_4);
        /** indicator固定宽度 */
        mTabLayout_5 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_5);
        /** indicator矩形圆角 */
        mTabLayout_6 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_6);
        /** indicator三角形 */
        mTabLayout_7 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_7);
        /** indicator圆角色块 */
        mTabLayout_8 = ViewFindUtils.find(mDecorView, com.astooltech.advancedview.R.id.tl_8);

        mTabLayout_1.setTabData(mTabEntities);
        tl_2();
        mTabLayout_3.setTabData(mTabEntities, getActivity(), com.astooltech.advancedview.R.id.fl_change, mFragments2);
        mTabLayout_4.setTabData(mTabEntities);
        mTabLayout_5.setTabData(mTabEntities);
        mTabLayout_6.setTabData(mTabEntities);
        mTabLayout_7.setTabData(mTabEntities);
        mTabLayout_8.setTabData(mTabEntities);

        mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mTabLayout_1.setCurrentTab(position);
                mTabLayout_2.setCurrentTab(position);
                mTabLayout_4.setCurrentTab(position);
                mTabLayout_5.setCurrentTab(position);
                mTabLayout_6.setCurrentTab(position);
                mTabLayout_7.setCurrentTab(position);
                mTabLayout_8.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mTabLayout_8.setCurrentTab(2);
        mTabLayout_3.setCurrentTab(1);

        //显示未读红点
        mTabLayout_1.showDot(2);
        mTabLayout_3.showDot(1);
        mTabLayout_4.showDot(1);

        //两位数
        mTabLayout_2.showMsg(0, 55);
        mTabLayout_2.setMsgMargin(0, -5, 5);

        //三位数
        mTabLayout_2.showMsg(1, 100);
        mTabLayout_2.setMsgMargin(1, -5, 5);

        //设置未读消息红点
        mTabLayout_2.showDot(2);
        MsgView rtv_2_2 = mTabLayout_2.getMsgView(2);
        if (rtv_2_2 != null) {
            UnreadMsgUtils.setSize(rtv_2_2, dp2px(7.5f));
        }

        //设置未读消息背景
        mTabLayout_2.showMsg(3, 5);
        mTabLayout_2.setMsgMargin(3, 0, 5);
        MsgView rtv_2_3 = mTabLayout_2.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }

        return mDecorView;
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
    Random mRandom = new Random();

    private void tl_2() {
        mTabLayout_2.setTabData(mTabEntities);
        mTabLayout_2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    mTabLayout_2.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout_2.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(1);
    }

}
