package com.example.helloworld2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APILoader {

    private static Retrofit retrofit = null;

    private static final String BASE_URL = "https://api.met.no/";


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
