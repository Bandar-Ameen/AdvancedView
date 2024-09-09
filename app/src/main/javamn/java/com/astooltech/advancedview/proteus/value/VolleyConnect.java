package com.astooltech.advancedview.proteus.value;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.database.DatabaseHelper;
import com.astooltech.advancedview.database.model.ScriptModel;
import com.astooltech.advancedview.proteus.parser.CustomStringRequest;
import com.astooltech.advancedview.proteus.parser.Utility;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VolleyConnect {
  Context cx;
    public VolleyConnect(Context cxx){
        this.cx=cxx;
    }

    HashMap<String, String>  hedermapVolley = new HashMap<>();
    public void conn(String Postmethod, final Map<String, String> Header, final HashMap<String, String> Quray, String URL, String requestbody, String contettyp, final ResultResponse Respn){

        final   String contettypp =contettyp==null?"application/json; charset=UTF-8":contettyp;
         //  public  void settreq(final String auth, final String usertyp, final String email){
         // String BASE_URL = "http://192.168.1.101:80/api/astoolacount/login";
       // com.android.volley.Request ApiRequest;
         RequestQueue q = Volley.newRequestQueue(cx);
         int typmethod = Request.Method.POST;
         if (Postmethod.toLowerCase().startsWith("g")) {
             typmethod = Request.Method.GET;
         }
         if (Postmethod.toLowerCase().startsWith("d")) {
             typmethod = Request.Method.DELETE;
         }
         if (Postmethod.toLowerCase().startsWith("pu")) {
             typmethod = Request.Method.PUT;
         }
         if (Postmethod.toLowerCase().startsWith("pa")) {
             typmethod = Request.Method.PATCH;
         }
         if (Postmethod.toLowerCase().startsWith("h")) {
             typmethod = Request.Method.HEAD;
         }
         CustomStringRequest rrrr = new CustomStringRequest(typmethod, URL, requestbody, new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {

                 Respn.OnSucess(response);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {
                 Gson gv = new Gson();
                 try {
if(error.networkResponse==null){
    Respn.OnError(error.toString());

}else {
    String da = gv.toJson(Utility.networkResponseToMap(error.networkResponse));

    Respn.OnError(da);

}
                   //  views.getViewManager().getContext().getAllEven("After_Process").call(views.getAsView().getContext(), views.getViewManager().getContext().getActvityAllt(), afterprocess, 0, views);
                    // String da = gv.toJson(Utility.networkResponseToMap(error.networkResponse));
                    // showmessagea(da, 2, responsekeyy);
                 } catch (Exception ex) {
                     Respn.OnError(ex.getMessage());
                 }
             }
         }) {
             @Override
             public Map<String, String> getHeaders() throws AuthFailureError {
                 return Header;
             }

             @Override
             public String getBodyContentType() {
                 return contettypp;
             }

             @Override
             protected Map<String, String> getParams() throws AuthFailureError {
                 return Quray;
             }
         };

        rrrr.setRetryPolicy(new DefaultRetryPolicy(GlobalClass.time_out * 1000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
         q.add(rrrr);
     }
        //}

    public interface ResultResponse{

       void OnSucess(String resul);
        void OnError(String resul);
    }

}
