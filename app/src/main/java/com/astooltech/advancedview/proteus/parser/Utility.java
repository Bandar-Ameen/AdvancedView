package com.astooltech.advancedview.proteus.parser;

import com.android.volley.NetworkResponse;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Utility {


    public static Map<String, Object> networkResponseToMap(NetworkResponse networkResponse) {
        Map<String, Object> response = new HashMap();
        response.put("headers", networkResponse.headers);
Object obj=null;
     boolean f= checkjson(new String(networkResponse.data));
     if(f){
         boolean q=checkjsosn(new String(networkResponse.data));

         if(q) {
             try{
           obj=  new JSONObject(new String(networkResponse.data));
         }catch (Exception ex){

             }
         }else {
             try{
                obj= new JSONArray(new String(networkResponse.data));
             }catch (JSONException ex1){


             }
         }

     }
     if(obj==null){
         obj=new String(networkResponse.data);
     }
        response.put("data",obj);
        response.put("networkTimeMs", Long.valueOf(networkResponse.networkTimeMs));
        response.put("notModified", Boolean.valueOf(networkResponse.notModified));
        response.put("statusCode", Integer.valueOf(networkResponse.statusCode));
        return response;
    }

    public static String listToString(ArrayList<ValuesModel> list) {
        return String.valueOf(new Gson().toJsonTree(list).getAsJsonArray());
    }
    private static  boolean checkjson(String json){

        try{
            new JSONObject(json);
        }catch (JSONException ex){

            try{
                new JSONArray(json);
            }catch (JSONException ex1){
                return  false;

            }
        }
        return true;
    }
    private static  boolean checkjsosn(String json){
boolean ss=false;
        try{
            new JSONObject(json);
            ss=true;
        }catch (JSONException ex){

            try{
                new JSONArray(json);
            }catch (JSONException ex1){
                return  false;

            }
        }
        return ss;
    }

}