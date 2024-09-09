package com.astooltech.advancedview.proteus.parser;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

import static com.astooltech.advancedview.proteus.parser.Utility.networkResponseToMap;


public class CustomStringRequest extends JsonRequest<String> {
    public CustomStringRequest(int method, String url, String requestBody, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }

    /* Access modifiers changed, original: protected */
    public Response<String> parseNetworkResponse(NetworkResponse response) {
        return Response.success(String.valueOf(new JSONObject(networkResponseToMap(response))), HttpHeaderParser.parseCacheHeaders(response));
    }



}
