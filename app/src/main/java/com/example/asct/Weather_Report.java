package com.example.asct;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather_Report extends AppCompatActivity {

    private EditText cityEditText;
    private TextView resultTextView;
    private Button searchButton;

    private String API_KEY = "079e73596d3ebd0eef0da8e33baa2659";
    private String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_report);

        cityEditText = findViewById(R.id.city_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        searchButton = findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityName = cityEditText.getText().toString();
                String url = BASE_URL + cityName + "&appid=" + "079e73596d3ebd0eef0da8e33baa2659";
                new GetWeatherTask().execute(url);
            }
        });
    }

    private class GetWeatherTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);

                String cityName = jsonObject.getString("name");
                String country = jsonObject.getJSONObject("sys").getString("country");
                String temperature = jsonObject.getJSONObject("main").getString("temp");
                double temperatureKelvin = Double.parseDouble(temperature);
                double temperatureCelsius = temperatureKelvin - 273.15;

                String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

                resultTextView.setText("City: " + cityName + ", " + country + "\n" +
                        "Temperature: " + temperatureCelsius + "°C\n" +
                        "Description: " + description);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
