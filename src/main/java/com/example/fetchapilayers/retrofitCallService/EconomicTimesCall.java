package com.example.fetchapilayers.retrofitCallService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EconomicTimesCall {

    @GET("/fetch-by-category")
    Call<String> fetchByCategory(@Query("tag") String tag);
}

