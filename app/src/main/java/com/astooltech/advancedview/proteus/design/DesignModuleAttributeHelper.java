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

package com.astooltech.advancedview.proteus.design;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.astooltech.advancedview.proteus.ProteusBuilder;
import com.astooltech.advancedview.proteus.ProteusConstants;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.processor.AttributeProcessor;
import com.astooltech.advancedview.proteus.processor.GravityAttributeProcessor;
import com.astooltech.advancedview.proteus.processor.StringAttributeProcessor;
import com.astooltech.advancedview.proteus.toolbox.Attributes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * DesignModuleAttributeHelper
 *
 * @author adityasharat
 */

public class DesignModuleAttributeHelper {


  public static <V extends View> void register(ProteusBuilder builder) {

    Map<String, AttributeProcessor> processors = new LinkedHashMap<>(4);

    processors.put("layout_scrollFlags", new StringAttributeProcessor<V>() {
      @Override
      public void setString(V view, String value) {
        AppBarLayoutParamsHelper.setLayoutScrollFlags(view, value);
      }
    });

    processors.put("layout_collapseMode", new StringAttributeProcessor<V>() {
      @Override
      public void setString(V view, String value) {
        CollapsingToolbarLayoutParamsHelper.setCollapseMode(view, value);
      }
    });

    processors.put("layout_parallaxMultiplier", new StringAttributeProcessor<V>() {
      @Override
      public void setString(V view, String value) {
        CollapsingToolbarLayoutParamsHelper.setParallaxMultiplier(view, value);
      }
    });

    processors.put("layout_behavior", new StringAttributeProcessor<V>() {
      @Override
      public void setString(V view, String value) {
        CoordinatorLayoutParamsHelper.setLayoutBehavior(view, value);
      }
    });

    processors.put(Attributes.View.LayoutGravity, new GravityAttributeProcessor<V>() {
      @Override
      public void setGravity(V view, @Gravity int gravity) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        if (layoutParams instanceof LinearLayout.LayoutParams) {
          LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layoutParams;
          params.gravity = gravity;
          view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
          FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
          params.gravity = gravity;
          view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
          CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) layoutParams;
          params.gravity = gravity;
          view.setLayoutParams(layoutParams);
        }
      }
    });

    builder.register("View", processors);

  }

  private static class AppBarLayoutParamsHelper {
    private static final String SCROLL_FLAG_SCROLL = "scroll";
    private static final String SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = "exitUntilCollapsed";
    private static final String SCROLL_FLAG_ENTER_ALWAYS = "enterAlways";
    private static final String SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = "enterAlwaysCollapsed";
    private static final String SCROLL_FLAG_SNAP = "snap";

    private static final HashMap<String, Integer> sScrollFlagMap = new HashMap<>();

    private static boolean sInitialized = false;

    private static void initialize() {
      if (!sInitialized) {
        sInitialized = true;

        sScrollFlagMap.put(SCROLL_FLAG_SCROLL, AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        sScrollFlagMap.put(SCROLL_FLAG_EXIT_UNTIL_COLLAPSED, AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        sScrollFlagMap.put(SCROLL_FLAG_ENTER_ALWAYS, AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        sScrollFlagMap.put(SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED, AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
        sScrollFlagMap.put(SCROLL_FLAG_SNAP, AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
      }
    }


    private static AppBarLayout.LayoutParams getLayoutParams(View v) {
      initialize();
      AppBarLayout.LayoutParams result = null;
      ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
      if (null != layoutParams && layoutParams instanceof AppBarLayout.LayoutParams) {
        result = (AppBarLayout.LayoutParams) layoutParams;
      }
      return result;
    }

    static void setLayoutScrollFlags(View v, String scrollFlags) {
      AppBarLayout.LayoutParams layoutParams = getLayoutParams(v);
      if (null != layoutParams && !TextUtils.isEmpty(scrollFlags)) {
        String[] listFlags = scrollFlags.split("\\|");
        int scrollFlag = 0;
        for (String flag : listFlags) {
          Integer flags = sScrollFlagMap.get(flag.trim());
          if (null != flags) {
            scrollFlag |= flags;
          }
        }

        if (scrollFlag != 0) {
          layoutParams.setScrollFlags(scrollFlag);
        }
      }
    }
  }

  private static class CollapsingToolbarLayoutParamsHelper {
    private static final String COLLAPSE_MODE_OFF = "off";
    private static final String COLLAPSE_MODE_PARALLAX = "parallax";
    private static final String COLLAPSE_MODE_PIN = "pin";

    private static final HashMap<String, Integer> sCollapseModeMap = new HashMap<>();

    private static boolean sInitialized = false;

    private static void initialize() {
      if (!sInitialized) {
        sInitialized = true;

        sCollapseModeMap.put(COLLAPSE_MODE_OFF, CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_OFF);
        sCollapseModeMap.put(COLLAPSE_MODE_PARALLAX, CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX);
        sCollapseModeMap.put(COLLAPSE_MODE_PIN, CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN);
      }
    }


    private static CollapsingToolbarLayout.LayoutParams getLayoutParams(View v) {
      initialize();
      CollapsingToolbarLayout.LayoutParams result = null;
      ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
      if (null != layoutParams && layoutParams instanceof CollapsingToolbarLayout.LayoutParams) {
        result = (CollapsingToolbarLayout.LayoutParams) layoutParams;
      }
      return result;
    }

    static void setCollapseMode(View v, String mode) {
      CollapsingToolbarLayout.LayoutParams layoutParams = getLayoutParams(v);
      if (null != layoutParams) {
        Integer collapseMode = sCollapseModeMap.get(mode);
        if (null != collapseMode) {
          layoutParams.setCollapseMode(collapseMode);
        }
      }
    }

    static void setParallaxMultiplier(View v, String multiplier) {
      CollapsingToolbarLayout.LayoutParams layoutParams = getLayoutParams(v);
      if (null != layoutParams && !TextUtils.isEmpty(multiplier)) {
        layoutParams.setParallaxMultiplier(ParseHelper.parseFloat(multiplier));
      }

    }
  }

  private static class CoordinatorLayoutParamsHelper {
    private static final HashMap<String, Class> sBehaviorMap = new HashMap<>();

    private static CoordinatorLayout.LayoutParams getLayoutParams(View v) {
      CoordinatorLayout.LayoutParams result = null;
      ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
      if (null != layoutParams && layoutParams instanceof CoordinatorLayout.LayoutParams) {
        result = (CoordinatorLayout.LayoutParams) layoutParams;
      }
      return result;
    }

    static void setLayoutBehavior(View v, String behavior) {
      CoordinatorLayout.LayoutParams layoutParams = getLayoutParams(v);
      if (null != layoutParams && !TextUtils.isEmpty(behavior)) {

        //noinspection TryWithIdenticalCatches since there are min API requirements
        try {
          Class clazz = sBehaviorMap.get(behavior);
          if (null == clazz) {
            clazz = Class.forName(behavior);
            sBehaviorMap.put(behavior, clazz);
          }
          Object behaviorObj = clazz.newInstance();
          if (null != behaviorObj && behaviorObj instanceof CoordinatorLayout.Behavior) {
            layoutParams.setBehavior((CoordinatorLayout.Behavior) behaviorObj);
          }
        } catch (ClassNotFoundException e) {
          if (ProteusConstants.isLoggingEnabled()) {
            e.printStackTrace();
          }
        } catch (InstantiationException e) {
          if (ProteusConstants.isLoggingEnabled()) {
            e.printStackTrace();
          }
        } catch (IllegalAccessException e) {
          if (ProteusConstants.isLoggingEnabled()) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
