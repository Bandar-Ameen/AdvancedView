package com.astooltech.advancedview;

import android.annotation.SuppressLint;
import android.provider.Settings;


import com.astooltech.advancedview.proteus.value.ObjectValue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class GlobalClass {


   // public static List<myArrayAuto> datsorce;
    public static final String PREFS_NAME = "TCPClientConf";
    public  static  String WebURL="";
    public static  String APPURL="";
    public  static  int UserID=1;
public  static  String serverIP="";
    public  static  String BseUrl="";
    public  static  String BseUrl2="";
    /***
     * معرف بيانات الدخول
     * **/
    public  static  String idlogin="idlogin";

    /***
     *بيانات الدخول
     * **/
    public  static  String datafromlogin="{}";
    public  static  String appnameen="Astooltech";
    public  static  String appnamear="اسطول التقنية";
    public  static  String Whiting="Please Waite";
    public  static  String[] titl_notfi= new String[]{"تم تاكيد الطلب"
            ,
            "رسالة","إشعار"
    };
    public  static  String MessageErorr="Connect To NetWork";
   // public  static  ObjectValue objjj;
//public static List<OOverIttem> datttt;

    public  static  int time_out=240;
    public  static  String updateVierstion="0.1";

    public  static void SetDataLogin(ObjectValue obb){
      ob=obb;
    }
    public static ObjectValue getLoginvalue(){

        return  ob;
    }
    private static ObjectValue ob;
    public static String UserAppID=Settings.Secure.ANDROID_ID+"@"+updateVierstion;
    public  static  String replay="فتح";
    public  static  String  User_Agent=UserAppID;
    public  static  int LastNewsID=1;
    public  static  int FontSize=16;
   public static final String fileDIRECTORY = "/astooltech_app";
    public  static  Boolean UpdateHisReourcess=false; // call when he update his resouress
    public  static  String acesstoken="Bearer FqLIvWCTRfUnmDiTmiUQuO2TvYWutpAMvPbeyk5Lgh9m_5KSyzcOGh9crvTOkS8386rTje4-j89u2F4MB6LrzkdFp2s7sIeuzas9AzIM0-kZmUdE2kwsixXqOdpca0ExLpQ-_aljupQpRkHS0g4e8c27kZVqRyEqZ_tEvl1FerSxZEpNj9GDnz0Bp899nu4vP9mRLs-cSaddvDw7uR3oSay8CbC2qcesgIHaflZ12VfMMdZ5kcg4sgwg2XrtfQNKIXIwjjE6a8ynVgDMwyiNKUrNDYdMhsesxDTHhNkwPl9w41HHseZvhsgHNeNi5qjW48o_KAyngz6zFGjlmebPlA";
    public  static  String username="bandarameen";
    public  static  String password="1234";
    public  static  String refreshtoken="1234567";
    public  static  String userIDD="1";
    public  static  String DeviceID="1";
    public  static  String alfraname=" ";
    public  static  String stockname=" ";
    public  static  String alfranameID=" ";
    public  static  String stocknameID=" ";
    public  static  String companeynames=" ";
    public  static  String companeysaddres=" ";
    public  static  String companeysaphones=" ";
    public static final String DATABASE_NAME = "astooltechs.db";
    public static final int DATABASE_VERSION = 1;

   public static boolean check1=false;
    public static boolean check2=false;
    public static boolean check3=false;
    public static boolean check4=false;
    @SuppressLint("DefaultLocale")
    public  static  String[] getBaseURL(String URll) throws MalformedURLException {


        URL url=new URL(URll);

        String protocol = url.getProtocol();
        String host = url.getHost();
        int port = url.getPort();
        String hostt = url.getHost();
        String full=";";
        if (port == -1) {
            full =String.format("%s://%s", protocol, host);
        } else {
            full=String.format("%s://%s:%d", protocol, host, port);
        }
        return new String[]{ full,url.getPath()};

    }
}
