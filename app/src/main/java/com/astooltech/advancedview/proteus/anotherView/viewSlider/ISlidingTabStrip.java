package com.astooltech.advancedview.proteus.anotherView.viewSlider;

import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.Keep;
import androidx.viewpager.widget.ViewPager;

import com.astooltech.advancedview.proteus.anotherView.viewSlider.other.JTabStyleDelegate;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tabstyle.JTabStyle;

/**
 * @author yun.
 * @date 2017/4/22
 * @des [一句话描述]
 * @since [https://github.com/ZuYun]
 * <p><a href="https://github.com/ZuYun">github</a>
 */
@Keep
public interface ISlidingTabStrip {

    @Keep
    ISlidingTabStrip setPromptNum(int index, int num);

    @Keep
    public interface IconTabProvider {
        /**
         * 如果 返回 null 則調用getPageIconResId
         *
         * @param position 1,简单的背景图片
         * 2，0为checked pressed背景  1为normal背景
         */
        public int[] getPageIconResIds(int position);

        /**
         * 兩個都實現的話 默認使用getPageIconResIds
         */
        @DrawableRes public int getPageIconResId(int position);
    }

    JTabStyleDelegate getTabStyleDelegate();

    void bindViewPager(ViewPager pager);

    ViewGroup getTabsContainer();

    int getTabCount();

    int getState();

    void setJTabStyle(JTabStyle JTabStyle);
}

