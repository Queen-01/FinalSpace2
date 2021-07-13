package com.example.finalspace.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinalSpaceClient {
    private static final String FINAL_SPACE_BASE_URL = "https://finalspaceapi.com/api/v0/";
    private static Retrofit retrofit = null;
    public static FinalSpaceApi getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(FINAL_SPACE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FinalSpaceApi.class);
    }
}
