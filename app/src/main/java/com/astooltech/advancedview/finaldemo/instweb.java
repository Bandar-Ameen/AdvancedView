package com.astooltech.advancedview.finaldemo;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;

import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.parser.webview.gm.AdvancedWebView;

import java.util.List;

public   class  instweb {


    public static class Builderweb {
        static   Context instwebf;
static showlogin evenn;
     static    com.astooltech.advancedview.database.DatabaseHelper helper;
        public static AdvancedWebView getViewweb() {
            return viewwebx;
        }

        private static void setViewweb(AdvancedWebView viewweb) {
            viewwebx = viewweb;

        }

        private static   AdvancedWebView viewwebx;

        public   Builderweb Builderweb(Context c,showlogin e,com.astooltech.advancedview.database.DatabaseHelper helperr){
            instwebf=c;
            evenn=e;
            helper=helperr;
            newInstince();
            return this;
        }
       private static   AdvancedWebView newInstince(){
            if(viewwebx==null){

                ScriptModel g=new ScriptModel(0,"00", "mainlogin");
                List<ScriptModel> h=helper.getAllNotes(g);
             //   hedde.get(cx).setKeyValue(h.get(0).getContent());
                String getvall =h.get(0).getContent(); //com.astooltech.advancedview.proteus.demo.SaveAndGetValue.getdatafrom("mainlogin", instwebf);
                loginonlly log=new loginonlly(instwebf,evenn);
                AdvancedWebView qaa=new AdvancedWebView(instwebf);

                qaa.setLayoutParams(new ViewGroup.LayoutParams(AdvancedWebView.LayoutParams.MATCH_PARENT,AdvancedWebView.LayoutParams.WRAP_CONTENT));
                log.runwebview(qaa, getvall);
                setViewweb(qaa);
            }else {
                evenn.loadfinshed();
            }

            return viewwebx;
        }
    }





}
