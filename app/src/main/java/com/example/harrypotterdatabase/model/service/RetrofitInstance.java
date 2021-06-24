package com.example.harrypotterdatabase.model.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;

    private static String BASE_URL = "https://hp-api.herokuapp.com/api/";

    public static HogwartsService getService(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
            return retrofit.create(HogwartsService.class);
    };

}
