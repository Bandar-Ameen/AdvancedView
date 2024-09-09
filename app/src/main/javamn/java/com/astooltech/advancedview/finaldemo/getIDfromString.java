package com.astooltech.advancedview.finaldemo;

import android.content.Context;

public class getIDfromString {

    private static Context con;
    public  getIDfromString(Context con){
        this.con=con;
    }
    public static int getID(Context con,String na,String ty,String pak){
       return con.getResources().getIdentifier(na,ty,pak);
    }

}
