package com.ourproject.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            initApiService();
        }
        return apiService;
    }

    private static void initApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.izhangchu.com")
                .build();
        apiService = retrofit.create(ApiService.class);
    }

}
