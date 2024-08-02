package com.example.asct;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.Date;

public class world extends AppCompatActivity {
    private EditText destinationEditText;
    private DatePicker startDatePicker;
    private DatePicker endDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);

        destinationEditText = findViewById(R.id.destinationEditText);
        startDatePicker = findViewById(R.id.fromDateEditText);
        endDatePicker = findViewById(R.id.toDateEditText);

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input values
                String destination = destinationEditText.getText().toString();
                Date startDate = new Date(startDatePicker.getYear() - 1900, startDatePicker.getMonth(), startDatePicker.getDayOfMonth());
                Date endDate = new Date(endDatePicker.getYear() - 1900, endDatePicker.getMonth(), endDatePicker.getDayOfMonth());

                // Create a new TravelPlan object
                TravelPlan travelPlan = new TravelPlan(destination, startDate, endDate);

                // Save the travel plan to the device
                saveTravelPlan(travelPlan);

                // Finish the activity
                finish();
            }
        });
        findViewById(R.id.vb1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(world.this,travelplan.class));
            }
        });
    }

    private void saveTravelPlan(TravelPlan travelPlan) {
        SharedPreferences sharedPreferences = getSharedPreferences("TravelPlans", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(travelPlan);
        editor.putString("travelPlan_" + System.currentTimeMillis(), json);
        editor.apply();
    }
        public class TravelPlan {
            private String destination;
            private Date startDate;
            private Date endDate;
            private String notes;

            public TravelPlan(String destination, Date startDate, Date endDate) {
                this.destination = destination;
                this.startDate = startDate;
                this.endDate = endDate;
                this.notes = notes;
            }

            public String getDestination() {
                return destination;
            }

            public void setDestination(String destination) {
                this.destination = destination;
            }

            public Date getStartDate() {
                return startDate;
            }

            public void setStartDate(Date startDate) {
                this.startDate = startDate;
            }

            public Date getEndDate() {
                return endDate;
            }

            public void setEndDate(Date endDate) {
                this.endDate = endDate;
            }

            public String getNotes() {
                return notes;
            }

            public void setNotes(String notes) {
                this.notes = notes;
            }
        }
        }
