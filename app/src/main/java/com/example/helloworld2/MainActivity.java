package com.example.helloworld2;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.*;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        APILoader.WeatherAPI weatherAPI;

        Retrofit retrofit;


        System.out.println(weatherAPI.getNowcast(62.3955 , 17.28611));



    }


}