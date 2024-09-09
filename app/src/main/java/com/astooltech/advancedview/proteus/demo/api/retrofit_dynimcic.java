package com.astooltech.advancedview.proteus.demo.api;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface retrofit_dynimcic {


    @POST
    Call<ResponseBody> PostMethod(@Url String url
            , @Body RequestBody k


    );

    @GET
    Call<ResponseBody> GetMethod(@Url String url
            , @Body RequestBody k


    );



    @GET
    Call<ResponseBody> GetMethod(@Url String url


    );
    @POST
    Call<ResponseBody> PostMethod(@Url String url
            , @Body RequestBody k, @HeaderMap Map<String, Object> heder, @QueryMap HashMap<String, String> Quary


    );
    @POST
    Call<ResponseBody> PostMethod(@Url String url
            , @Body RequestBody k, @HeaderMap Map<String, Object> heder, @QueryMap HashMap<String, String> Quary, @Header("Content-Type") String kont


    );


    @GET
    Call<ResponseBody> GetMethod(@Url String url
            , @Body RequestBody k, @HeaderMap Map<String, Object> heder, @QueryMap HashMap<String, String> Quary


    );

    @GET
    Call<ResponseBody> GetMethod(@Url String url
            , @HeaderMap Map<String, Object> heder, @QueryMap HashMap<String, String> Quary


    );
}
