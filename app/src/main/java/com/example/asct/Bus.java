package com.example.asct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Bus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        ImageButton websiteButton = findViewById(R.id.bus1);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.abhibus.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.abhibus.com/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton1 = findViewById(R.id.bus2);
        websiteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.bus.irctc.co.in/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bus.irctc.co.in/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton2 = findViewById(R.id.bus3);
        websiteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://m.redbus.in/bus-tickets";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.redbus.in/bus-tickets"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton3 = findViewById(R.id.bus4);
        websiteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.railyatri.in/bus-booking";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.railyatri.in/bus-booking"));
                startActivity(intent);
            }
        });

    }
}