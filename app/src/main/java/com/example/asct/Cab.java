package com.example.asct;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class Cab extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab);

        ImageButton websiteButton = findViewById(R.id.imageButton10);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.olacabs.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.olacabs.com/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton1 = findViewById(R.id.imageButton11);
        websiteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.meru.in/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.meru.in/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton2 = findViewById(R.id.imageButton12);
        websiteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.solocabs.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.solocabs.com/"));
                startActivity(intent);
            }
        });
        ImageButton websiteButton3 = findViewById(R.id.imageButton13);
        websiteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.uber.com/in/en/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uber.com/in/en/"));
                startActivity(intent);
            }
        });



    }
}