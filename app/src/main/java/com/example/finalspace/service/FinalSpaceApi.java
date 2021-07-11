package com.example.finalspace.service;

import com.example.finalspace.model.FinalSpaceSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FinalSpaceApi {
    @GET("/search")
    Call<FinalSpaceSearchResponse> getFinalSpace(
            @Query("location") String location,
            @Query("term") String term
    );
}
