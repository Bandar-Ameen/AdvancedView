package com.astooltech.advancedview.proteus.demo;

import com.astooltech.advancedview.proteus.ProteusLayoutInflater;

public class connectedActivityMdel {

    private static   connectedActivityMdel minstance;

    private connectedActivityMdel(){

    }
    private ProteusLayoutInflater infll;
    public  ProteusLayoutInflater getInflater(){

       return infll;
    }
    public  void setInflater(ProteusLayoutInflater u){

    infll=u;
    }
private ProteusLayoutInflater.Callback mlisner;
    public static connectedActivityMdel getinstance(){
        if(minstance==null){
            minstance=new connectedActivityMdel();
        }
        return  minstance;
    }
    public void setlisner(ProteusLayoutInflater.Callback mlisnerr){

        mlisner=mlisnerr;
    }
    public  ProteusLayoutInflater.Callback getlisiner(){
        return mlisner;


    }

}
