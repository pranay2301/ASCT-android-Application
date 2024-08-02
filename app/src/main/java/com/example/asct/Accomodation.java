package com.example.asct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Accomodation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);
        ImageButton websiteButton = findViewById(R.id.hbt2);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.trivago.in/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trivago.in/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton1 = findViewById(R.id.hbt3);
        websiteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.airbnb.co.in/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.airbnb.co.in/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton2 = findViewById(R.id.hbt4);
        websiteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.makemytrip.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.makemytrip.com/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton3 = findViewById(R.id.hbt1);
        websiteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.hotels.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hotels.com/"));
                startActivity(intent);
            }
        });





    }
}