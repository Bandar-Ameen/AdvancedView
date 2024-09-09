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

package com.astooltech.advancedview.proteus.value;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.LruCache;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringDef;

import com.astooltech.advancedview.R;
import com.astooltech.advancedview.proteus.androidsvg.SvgChecker;
import com.astooltech.advancedview.proteus.parser.ParseHelper;
import com.astooltech.advancedview.proteus.value.fontdrawable.EnumFont;
import com.astooltech.advancedview.proteus.value.fontdrawable.FontDrawable;
import com.astooltech.advancedview.proteus.value.fontdrawable.icon_map;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ColorResource
 *
 * @author aditya.sharat
 */

public class Resource extends Value {

  public static final String RESOURCE_PREFIX_ANIMATION = "@anim/";
  public static final String RESOURCE_PREFIX_BOOLEAN = "@bool/";
  public static final String RESOURCE_PREFIX_COLOR = "@color/";
  public static final String RESOURCE_PREFIX_DIMENSION = "@dimen/";
  public static final String RESOURCE_PREFIX_DRAWABLE = "@drawable/";
  public static final String RESOURCE_PREFIX_DRAWABLEFont = "@drawableFont/";
  public static final String RESOURCE_PREFIX_STRING = "@string/";

  public static final String ANIM = "anim";
  public static final String BOOLEAN = "bool";
  public static final String COLOR = "color";
  public static final String DIMEN = "dimen";
  public static final String DRAWABLE = "drawable";
  public static final String DRAWABLEFONT = "drawableFont";
  public static final String STRING = "string";

  public static final Resource NOT_FOUND = new Resource(0,false,"0");

  public final int resId;
  public  final  boolean isdroblefont;
public final  String fontfont;
  private Resource(int resId,boolean isdroblefontt,String getfont) {

    this.resId = resId;
    this.isdroblefont=isdroblefontt;
    this.fontfont=getfont;
  }

  public static boolean isAnimation(String string) {
    return string.startsWith(RESOURCE_PREFIX_ANIMATION);
  }

  public static boolean isBoolean(String string) {
    return string.startsWith(RESOURCE_PREFIX_BOOLEAN);
  }

  public static boolean isColor(String string) {
    return string.startsWith(RESOURCE_PREFIX_COLOR);
  }

  public static boolean isDimension(String string) {
    return string.startsWith(RESOURCE_PREFIX_DIMENSION);
  }

  public static boolean isDrawable(String string) {
    return string.startsWith(RESOURCE_PREFIX_DRAWABLE);
  }
  public static boolean isDrawableFont(String string) {
    return string.startsWith(RESOURCE_PREFIX_DRAWABLEFont);
  }
  public static boolean isString(String string) {
    return string.startsWith(RESOURCE_PREFIX_STRING);
  }

  public static boolean isResource(String string) {
    return isAnimation(string) ||isDrawableFont(string) || isBoolean(string) || isColor(string) || isDimension(string) || isDrawable(string) || isString(string);
  }

  @Nullable
  public static Boolean getBoolean(int resId, Context context) {
    try {
      return context.getResources().getBoolean(resId);
    } catch (Resources.NotFoundException e) {
      return null;
    }
  }

  @Nullable
  public static Integer getColor(int resId, Context context) {
    try {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return context.getResources().getColor(resId, context.getTheme());
      } else {
        //noinspection deprecation
        return context.getResources().getColor(resId);
      }
    } catch (Resources.NotFoundException e) {
      return null;
    }
  }

  @Nullable
  public static ColorStateList getColorStateList(int resId, Context context) {
    try {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        return context.getColorStateList(resId);
      } else {
        //noinspection deprecation
        return context.getResources().getColorStateList(resId);
      }

    } catch (Resources.NotFoundException nfe) {
      return null;
    }
  }

  @Nullable
  public static Drawable getDrawable(int resId, Context context,String fontdrawble) {
    try {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        String svgString = SvgChecker.getSvgString(fontdrawble);


        if(svgString != null){

          Drawable dr= SvgChecker.svgToDrawable(context,svgString);
          if(dr!=null){
            return dr;
          }else{
         return   context.getResources().getDrawable(R.drawable.b_round, context.getTheme());
          }

        }

        else if(!fontdrawble.startsWith(RESOURCE_PREFIX_DRAWABLEFont)) {

          return context.getResources().getDrawable(resId, context.getTheme());
        }else{

        //  GetDrawbileFromString.getDrawble(getAsObject(),context);
         try {
           String CUSTOM_FONT_PATH = "fontawesome-webfont.ttf";
           String FA_FONT_REGULAR = "fa-regular-400.ttf";
           String FA_FONT_SOLID = "fa-solid-900.ttf";
           String FA_FONT_BRANDS = "fa-brands-400.ttf";
           String val[] = fontdrawble.split("/");
           int typfon = Integer.parseInt(val[2]);
           int size = Integer.parseInt(val[3]);
           if (typfon == 2) {
             CUSTOM_FONT_PATH = FA_FONT_REGULAR;
           } else if (typfon == 3) {
             CUSTOM_FONT_PATH = FA_FONT_SOLID;
           } else if (typfon == 4) {
             CUSTOM_FONT_PATH = FA_FONT_BRANDS;
           }

           String dde = val[1]; //"\uf196";
           EnumFont mytypaction = EnumFont.valueOf(dde);
           char SPACE_SHUTTLE_CODE = icon_map.geticon(mytypaction);// dde.charAt(0); //'\uf198'
           // ParseHelper.getResId()

           //  AFontDrawable drawablex = new AFontDrawable(view.getAsView().getContext(), R.string.fa_heart, false, true);
           @ColorInt
           int MATERIAL_BLUE = ParseHelper.parseColor(val[4]);

           FontDrawable spaceShuttle = new FontDrawable.Builder(context, SPACE_SHUTTLE_CODE, CUSTOM_FONT_PATH)
                   .setSizeDp(size)
                   .setColor(MATERIAL_BLUE)
                   .build();

           return spaceShuttle;
         }catch (Exception ex){

           return context.getResources().getDrawable(resId, context.getTheme());
         }
        }
      } else {
        String svgString = SvgChecker.getSvgString(fontdrawble);


        if(svgString != null){

          Drawable dr= SvgChecker.svgToDrawable(context,svgString);
          if(dr!=null){
            return dr;
          }else{
            return  context.getResources().getDrawable(R.drawable.b_round);//, context.getTheme());
          }

        }
     else   if(!fontdrawble.startsWith(RESOURCE_PREFIX_DRAWABLEFont)) {
          //noinspection deprecation
          return context.getResources().getDrawable(resId);
        }else {

          try {
            String CUSTOM_FONT_PATH = "fontawesome-webfont.ttf";
            String FA_FONT_REGULAR = "fa-regular-400.ttf";
            String FA_FONT_SOLID = "fa-solid-900.ttf";
            String FA_FONT_BRANDS = "fa-brands-400.ttf";
            String val[] = fontdrawble.split("/");
            int typfon = Integer.parseInt(val[2]);
            int size = Integer.parseInt(val[3]);
            if (typfon == 2) {
              CUSTOM_FONT_PATH = FA_FONT_REGULAR;
            } else if (typfon == 3) {
              CUSTOM_FONT_PATH = FA_FONT_SOLID;
            } else if (typfon == 4) {
              CUSTOM_FONT_PATH = FA_FONT_BRANDS;
            }

            String dde = val[1]; //"\uf196";
            EnumFont mytypaction = EnumFont.valueOf(dde);
            char SPACE_SHUTTLE_CODE = icon_map.geticon(mytypaction);// dde.charAt(0); //'\uf198'
            // ParseHelper.getResId()

            //  AFontDrawable drawablex = new AFontDrawable(view.getAsView().getContext(), R.string.fa_heart, false, true);
            @ColorInt
            int MATERIAL_BLUE = ParseHelper.parseColor(val[4]);

            FontDrawable spaceShuttle = new FontDrawable.Builder(context, SPACE_SHUTTLE_CODE, CUSTOM_FONT_PATH)
                    .setSizeDp(size)
                    .setColor(MATERIAL_BLUE)
                    .build();

            return spaceShuttle;
          }catch (Exception ex){
            return context.getResources().getDrawable(resId);
          }
        }
      }
    } catch (Resources.NotFoundException e) {
      return null;
    }
  }

  @Nullable
  public static Float getDimension(int resId, Context context) {
    try {
      return context.getResources().getDimension(resId);
    } catch (Resources.NotFoundException e) {
      return null;
    }
  }

  @Nullable
  public static String getString(int resId, Context context) {
    try {
      return context.getString(resId);
    } catch (Resources.NotFoundException e) {
      return null;
    }
  }

  @Nullable
  public static Resource valueOf(String value, @Nullable @ResourceType String type, Context context) {
    if (null == value) {
      return null;
    }
    Resource resource = ResourceCache.cache.get(value);


    if (null == resource) {
if(value.startsWith(RESOURCE_PREFIX_DRAWABLEFont)){
  //int resId = context.getResources().getIdentifier(value, type, context.getPackageName());
  resource =  new Resource(0, true, value);
  ResourceCache.cache.put(value, resource);
}else {


  int resId = context.getResources().getIdentifier(value, type, context.getPackageName());
  resource = resId == 0 ? NOT_FOUND : new Resource(resId, false, value);
  ResourceCache.cache.put(value, resource);
}
    }
    return NOT_FOUND == resource ? null : resource;
  }

  @NonNull
  public static Resource valueOf(int resId) {
    return new Resource(resId,false,"0");
  }

  @Nullable
  public Boolean getBoolean(Context context) {
    return getBoolean(resId, context);
  }

  @Nullable
  public Integer getColor(Context context) {
    return getColor(resId, context);
  }

  @Nullable
  public ColorStateList getColorStateList(Context context) {
    return getColorStateList(resId, context);
  }

  @Nullable
  public Drawable getDrawable(Context context) {
    return getDrawable(resId, context,fontfont);
  }

  @Nullable
  public Float getDimension(Context context) {
    return getDimension(resId, context);
  }

  @Nullable
  public Integer getInteger(Context context) {
    return getInteger(resId, context);
  }

  @Nullable
  public String getString(Context context) {
    return getString(resId, context);
  }

  @Nullable
  public Integer getInteger(int resId, Context context) {
    return context.getResources().getInteger(resId);
  }

  @Override
  public Value copy() {
    return this;
  }

  @StringDef({ANIM, BOOLEAN, COLOR, DRAWABLE, DIMEN, STRING,DRAWABLEFONT})
  @Retention(RetentionPolicy.SOURCE)
  public @interface ResourceType {
  }

  private static class ResourceCache {
    static final LruCache<String, Resource> cache = new LruCache<>(64);
  }
}
