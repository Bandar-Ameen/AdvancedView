package com.astooltech.advancedview.proteus.demo.api;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class URLParsers {
    private  Context cc;
    private String Url;
    private String data;
    private   Document doc;
    public URLParsers(Context x,String Urll,String dat){

        cc=x;
        Url=Urll;
        data=dat;

    }
    public void showResults(){

        try {

  doc = Jsoup.connect(Url).get();

            Thread.sleep(100);
        }catch (Exception ex){
            Log.i("9999",ex.getMessage());
        }
      String cz=  dataFirst(data,"0").toString();
        showResult(cz,cc);

    }
    public Elements dataFirst(String datv,String dataeql){
        Elements dataFirstd=null;
        String sdfsdf[]=datv.split("#");
        for (int xxc = 0; xxc < sdfsdf.length; xxc++) {

            String datawitheql[]=sdfsdf[xxc].split("=");
            String dataonee=datawitheql[0];
            if(dataFirstd==null) {
               if(datawitheql.length<0){
                   dataFirstd=doc.select(dataonee).eq(Integer.parseInt(datawitheql[1]));
               }else
               {
                   dataFirstd=doc.select(dataonee);
               }

            }else {

                if(datawitheql.length<0){
                    dataFirstd=dataFirstd.select(dataonee).eq(Integer.parseInt(datawitheql[1]));
                }else
                {
                    dataFirstd=dataFirstd.select(dataonee);
                }

            }
        }

        return dataFirstd;
    }


    private void showResult(final String result,Context c) {
        new AlertDialog.Builder(c)
                .setMessage(result)
                .setCancelable(true)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
