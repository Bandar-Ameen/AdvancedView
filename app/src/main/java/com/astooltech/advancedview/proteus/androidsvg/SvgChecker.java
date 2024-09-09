package com.astooltech.advancedview.proteus.androidsvg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SvgChecker {
    public static Drawable svgToDrawable(Context context, String svgString) {
        try {
            SVG svg = SVG.getFromString(svgString);
            return new PictureDrawable(svg.renderToPicture());
        } catch (SVGParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String getSvgString(String input) {
        String svgPattern = "<svg\\b[^>]*>(.*?)<\\/svg>";
        Pattern pattern = Pattern.compile(svgPattern, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group(0); // Return the full match which includes the entire <svg>...</svg> block
        } else {
            return null; // Return null if no SVG is found
        }
    }


}

