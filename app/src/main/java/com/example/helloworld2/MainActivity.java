package com.example.helloworld2;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.*;
import android.util.Log;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // For logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up a TextView to display the API response (optional)
        TextView textView = new TextView(this);
        textView.setText("Fetching weather data...");
        setContentView(textView);

        // Get the Retrofit instance
        Retrofit retrofit = APILoader.getClient();

        // Create the WeatherAPI interface
        ApiInterface api = retrofit.create(ApiInterface.class);

        // Make the API call
        Call<Object> call = api.getNowcast(62.3955, 17.28611); // Replace Object with your response model if available

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Handle the successful response
                    String responseBody = response.body().toString(); // Replace this with your model's getter
                    textView.setText(responseBody);
                    Log.d(TAG, "API Response: " + responseBody);
                } else {
                    // Handle the error response
                    textView.setText("Error: " + response.code());
                    Log.e(TAG, "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Handle failure
                textView.setText("Failed to fetch data: " + t.getMessage());
                Log.e(TAG, "Failure: " + t.getMessage(), t);
            }
        });
    }
}