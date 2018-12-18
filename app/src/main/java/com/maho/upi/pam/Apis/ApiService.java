package com.maho.upi.pam.Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("ALL")
public class ApiService {

    private static Retrofit retrofit ;
    private  static final String BASE_URL = "https://api.myjson.com/";

    public static Retrofit getDataPemain(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
