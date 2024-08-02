package com.example.asct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Train extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        ImageButton websiteButton = findViewById(R.id.tbt2);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.railyatri.in/train-ticket";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.railyatri.in/train-ticket"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton1 = findViewById(R.id.tbt3);
        websiteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.irctc.co.in/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.irctc.co.in/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton2 = findViewById(R.id.tbt4);
        websiteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.makemytrip.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.makemytrip.com/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton3 = findViewById(R.id.tbt1);
        websiteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.confirmtkt.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.confirmtkt.com/"));
                startActivity(intent);
            }
        });

    }
}