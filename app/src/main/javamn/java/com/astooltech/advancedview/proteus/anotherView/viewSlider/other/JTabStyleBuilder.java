package com.astooltech.advancedview.proteus.anotherView.viewSlider.other;

import androidx.annotation.IntDef;
import androidx.annotation.Keep;

import com.astooltech.advancedview.proteus.anotherView.viewSlider.ISlidingTabStrip;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tabstyle.DefaultTabStyle;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tabstyle.DotsTabStyle;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tabstyle.JTabStyle;
import com.astooltech.advancedview.proteus.anotherView.viewSlider.tabstyle.RoundTabStyle;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
public class JTabStyleBuilder {
    public static final int STYLE_DEFAULT = 0;
    public static final int STYLE_ROUND = 1;
    public static final int STYLE_DOTS = 2;
    public static final int STYLE_GRADIENT = -1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ STYLE_DEFAULT, STYLE_ROUND, STYLE_DOTS }) public @interface TabStyle {}


    public static JTabStyle createJTabStyle(ISlidingTabStrip slidingTabStrip, @TabStyle int tabStyle) {
        if (tabStyle == STYLE_DEFAULT) {
            return new DefaultTabStyle(slidingTabStrip);
        }
        else if (tabStyle == STYLE_ROUND) {
            return new RoundTabStyle(slidingTabStrip);
        }
        else if (tabStyle == STYLE_DOTS) {
            return new DotsTabStyle(slidingTabStrip);
        }
        return new DefaultTabStyle(slidingTabStrip);
    }
}