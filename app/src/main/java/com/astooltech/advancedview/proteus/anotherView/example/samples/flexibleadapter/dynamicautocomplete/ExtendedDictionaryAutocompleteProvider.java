/*
 * Copyright (C) 2017 Sylwester Sokolowski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.astooltech.advancedview.proteus.anotherView.example.samples.flexibleadapter.dynamicautocomplete;

import static com.astooltech.advancedview.proteus.ALLEvent.getBeforOrafetrEven;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

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
import com.astooltech.advancedview.proteus.ALLEvent;
import com.astooltech.advancedview.proteus.ProteusLayoutInflater;
import com.astooltech.advancedview.proteus.ProteusView;
import com.astooltech.advancedview.proteus.anotherView.flexibleadapter.items.AbstractFlexibleItem;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimcic;
import com.astooltech.advancedview.proteus.demo.api.retrofit_dynimic;
import com.astooltech.advancedview.proteus.parser.CustomStringRequest;
import com.astooltech.advancedview.proteus.parser.Utility;
import com.astooltech.advancedview.proteus.parser.adapterskit.IValuesData;
import com.astooltech.advancedview.proteus.parser.hedaerOrQuary;
import com.astooltech.advancedview.proteus.v7.adapter.OOverIttem;
import com.astooltech.advancedview.proteus.v7.adapter.modeltypeview;
import com.astooltech.advancedview.proteus.value.Array;
import com.astooltech.advancedview.proteus.value.Layout;
import com.astooltech.advancedview.proteus.value.ObjectValue;
import com.astooltech.advancedview.proteus.value.Primitive;
import com.astooltech.advancedview.proteus.value.Value;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;


public class ExtendedDictionaryAutocompleteProvider extends AbstractProvider implements DynamicAutocompleteProvider<AbstractFlexibleItem> {

    private static final String REST_URL = "http://sstgadh.wirt09.biznes-host.pl/rest/api/country/%s";
private  List<AbstractFlexibleItem> mlistdat;

private ProteusView zxbx;
private List<modeltypeview> datatyp;
private  boolean usemultiple;
    public  ExtendedDictionaryAutocompleteProvider(List<AbstractFlexibleItem> cx,ProteusView  zxbb,List<modeltypeview> datatyp,boolean usemultiple){
    this.mlistdat=cx;
    this.zxbx=zxbb;
    this.datatyp=datatyp;
    this.usemultiple=usemultiple;
}

    @Override
    public Collection<AbstractFlexibleItem> provideDynamicAutocompleteItems(String constraint) {
boolean checkk=false;


        List<AbstractFlexibleItem> mItemss = new ArrayList<AbstractFlexibleItem>();
        try {

            for (AbstractFlexibleItem v:mlistdat){

                OOverIttem ov=(OOverIttem)v;
                if(ov.filter(constraint)){
                    mItemss.add(v);
                }
            }


        } catch (Exception ex) {
        }
        Collection<AbstractFlexibleItem> uu = new ArrayList<AbstractFlexibleItem>(mItemss);
        return uu;
    }
}