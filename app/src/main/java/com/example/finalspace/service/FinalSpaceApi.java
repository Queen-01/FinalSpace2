package com.example.finalspace.service;

import com.example.finalspace.model.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FinalSpaceApi {
    @GET("/api/v0/episode")
    Call<List<Episode>> getEpisode();
}
