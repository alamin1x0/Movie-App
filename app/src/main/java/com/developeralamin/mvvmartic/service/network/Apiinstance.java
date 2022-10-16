package com.developeralamin.mvvmartic.service.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiinstance {

    public static String BASE_URL = "https://api.themoviedb.org/";
    private static Retrofit retrofit;

    public static Retrofit getApiInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
