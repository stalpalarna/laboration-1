package com.example.helloworld2;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ApiInterface {
        @GET("weatherapi/nowcast/2.0/complete/")
        Call<Object> getNowcast(
                @Query("lat") double latitude,
                @Query("lon") double longitude
        );
}
