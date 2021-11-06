package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UnderWeightActivity extends AppCompatActivity {

    String user_name, user_bmi;
    TextView underweight_username, underweight_activity_txt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_weight);

        underweight_username = findViewById(R.id.underweight_username);
        Intent intent = getIntent();
        user_name = intent.getStringExtra("underweight_username");
        underweight_username.setText("Hi! " + user_name);

        underweight_activity_txt = findViewById(R.id.underweight_activity_txt);
        Intent intent1 = getIntent();
        user_bmi = intent1.getStringExtra("underweight_bmi");
        underweight_activity_txt.setText("Your BMI is : " + user_bmi);
    }
}