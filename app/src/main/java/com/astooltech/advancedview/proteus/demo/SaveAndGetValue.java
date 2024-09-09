package com.astooltech.advancedview.proteus.demo;

import android.content.Context;
import android.content.SharedPreferences;

import com.astooltech.advancedview.GlobalClass;

public class SaveAndGetValue {
    public static void savetoref(String keyname, String kayval, Context cc){
        try {

            SharedPreferences settings = cc.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove(keyname);
            editor.putString(keyname,kayval);
            editor.commit();
        }catch (Exception ex){
            //   Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public static String  getdatafrom(String textt,Context cc){

        SharedPreferences settings =cc.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }

    public static String  getdatafromk(String textt,Context cc){

        SharedPreferences settings =cc.getSharedPreferences(GlobalClass.PREFS_NAME, 0);
        final String mpp = settings.getString(textt, "");
        if (mpp.isEmpty()) {
            return "NO";
        }else {
            return mpp;
        }


    }
}
