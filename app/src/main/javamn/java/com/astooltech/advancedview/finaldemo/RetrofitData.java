package com.astooltech.advancedview.finaldemo;


import android.annotation.SuppressLint;

import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.proteus.parser.ToStringConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("NewApi")
public class RetrofitData  {


    public static final String BASE_URL = "http://192.168.1.101:80";
    public static Retrofit retrofit = null;

    //int cachesize=10*1024*124;
    // Cache cache=new Cache(C,cachesize);
    public static Retrofit getRetrofit(){
        // HttpLoggingInterceptor hh=new HttpLoggingInterceptor();

        OkHttpClient bb=new OkHttpClient.Builder()
                .callTimeout(GlobalClass.time_out, TimeUnit.SECONDS)
                .connectTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .readTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .writeTimeout(GlobalClass.time_out,TimeUnit.SECONDS)//.addInterceptor(hh)
                .build();

        if(retrofit == null){

            retrofit = new Retrofit.Builder().baseUrl(GlobalClass.BseUrl)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .client(bb)
                    .build();
        }
        return retrofit;
    }
}

