package com.astooltech.advancedview.proteus;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FontUtil {

    private static Map<String, Typeface> fontCache = new HashMap<>();

    public static void loadAllFonts(Context context) {
        try {
            String[] fontFiles = context.getAssets().list("themes/fonts");
            if (fontFiles != null) {
                for (String fontFile : fontFiles) {
                    Typeface typeface = Typeface.createFromAsset(context.getAssets(), "themes/fonts/" + fontFile);
                    fontCache.put(fontFile, typeface);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Typeface getFont(String fontName,View v) {
      if(fontCache.size()==0){
          loadAllFonts(v.getContext());
      }
      if(fontCache.containsKey(fontName)) {


          return fontCache.get(fontName);
      }
      return  null;
      }

    public static void applyFont(View view, String fontName) {

        Typeface t= getFont(fontName+".ttf",view);
            if(t!=null) {


                if (view instanceof TextView) {
                    ((TextView) view).setTypeface(t);
                }
            }
    }
}
