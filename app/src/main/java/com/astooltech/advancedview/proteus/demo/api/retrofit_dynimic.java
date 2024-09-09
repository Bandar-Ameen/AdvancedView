package com.astooltech.advancedview.proteus.demo.api;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.astooltech.advancedview.GlobalClass;
import com.astooltech.advancedview.proteus.gson.ProteusTypeAdapterFactory;
import com.astooltech.advancedview.proteus.parser.ToStringConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressLint("NewApi")
public class retrofit_dynimic  {


    public static final String BASE_URL = "http://192.168.1.101:80";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        // HttpLoggingInterceptor hh=new HttpLoggingInterceptor();


        //return new RetrofitClient(GlobalClass.BseUrl2).getRetrofitClient();
        OkHttpClient bb=new OkHttpClient.Builder()
                .callTimeout(GlobalClass.time_out, TimeUnit.SECONDS)
                .connectTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .readTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .writeTimeout(GlobalClass.time_out,TimeUnit.SECONDS)//.addInterceptor(hh)
                .build();

        if(retrofit == null){



            retrofit = new Retrofit.Builder().baseUrl(GlobalClass.BseUrl2)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .client(bb)
                    .build();
        }
        return retrofit;
    }
    public static Retrofit getRetrofit(String url){
        // HttpLoggingInterceptor hh=new HttpLoggingInterceptor();


        //return new RetrofitClient(GlobalClass.BseUrl2).getRetrofitClient();
        OkHttpClient bb=new OkHttpClient.Builder()
                .callTimeout(GlobalClass.time_out, TimeUnit.SECONDS)
                .connectTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .readTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .writeTimeout(GlobalClass.time_out,TimeUnit.SECONDS)//.addInterceptor(hh)
                .build();




         return new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .client(bb)
                    .build();


    }

    public static Retrofit getRetrofit(Context c){
        // HttpLoggingInterceptor hh=new HttpLoggingInterceptor();


        //return new RetrofitClient(GlobalClass.BseUrl2).getRetrofitClient();
        OkHttpClient bb=new OkHttpClient.Builder()
                .callTimeout(GlobalClass.time_out, TimeUnit.SECONDS)
                .connectTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .readTimeout(GlobalClass.time_out,TimeUnit.SECONDS)
                .writeTimeout(GlobalClass.time_out,TimeUnit.SECONDS)//.addInterceptor(hh)
                .build();

        if(retrofit == null){

            ProteusTypeAdapterFactory adapter = new ProteusTypeAdapterFactory(c);
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(adapter)
                    .create();

            retrofit = new Retrofit.Builder().baseUrl(GlobalClass.BseUrl2)
                    .addConverterFactory(new ToStringConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    // .addConverterFactory(ScalarsConverterFactory.create())
                    .client(bb)
                    .build();
        }
        return retrofit;
    }
}
