package com.example.helloworld2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class APILoader {

    private static Retrofit retrofit = null;

    public interface WeatherAPI {

        @GET("complete")
        Call<ResponseBody> getNowcast(@Query("lat") double lattitude, @Query("lon") double longditude);



    }
    private static final String BASE_URL = "https://api.met.no/weatherapi/nowcast/2.0/";


    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
