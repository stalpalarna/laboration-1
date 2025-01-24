package com.example.helloworld2;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.*;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Retrofit retrofit = APILoader.getClient("https://api.met.no/weatherapi/nowcast/2.0/complete?lat=62.3955&lon=17.28611");

        System.out.println(retrofit.baseUrl());


    }


}