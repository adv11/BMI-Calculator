package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ObeseActivity extends AppCompatActivity {

    String user_name, user_bmi;
    TextView obese_username, obese_activity_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obese);

        obese_username = findViewById(R.id.obese_username);
        Intent intent = getIntent();
        user_name = intent.getStringExtra("obese_username");
        obese_username.setText("Hi! " + user_name);

        obese_activity_txt = findViewById(R.id.obese_activity_txt);
        Intent intent1 = getIntent();
        user_bmi = intent1.getStringExtra("obese_bmi");
        obese_activity_txt.setText("Your BMI is : " + user_bmi);
    }
}