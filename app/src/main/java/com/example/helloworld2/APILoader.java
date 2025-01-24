package com.example.helloworld2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APILoader {

    private static Retrofit retrofit = null;

    private static final String BASE_URL = "https://api.met.no/weatherapi/nowcast/2.0/complete?lat=62.3955&lon=17.28611";


    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }

}
