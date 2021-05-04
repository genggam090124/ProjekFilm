package com.genggam.projekfilm;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static MoService service;

    public static MoService getService(){
        if (service == null){
            String API_BASE_URL = "http://www.omdbapi.com";
            //mempermudah debug
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG){
                loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            }else {
                loggingInterceptor.level(HttpLoggingInterceptor.Level.NONE);
            }
            OkHttpClient.Builder httpCli = new OkHttpClient.Builder();
            httpCli.addInterceptor(loggingInterceptor);

            httpCli.addInterceptor(chain -> {
                Request req = chain.request();
                String newUrl = req.url().toString().replace("http://www.omdbapi.com", "http://www.omdbapi.com?apikey=2268147d&s=batman");
                return chain.proceed(req.newBuilder().url(newUrl).build());
            });

            Retrofit retro = new Retrofit.Builder().baseUrl(API_BASE_URL).client(httpCli.build()).addConverterFactory(GsonConverterFactory.create()).build();
            service = retro.create(MoService.class);
        }
        return service;
    }
}
