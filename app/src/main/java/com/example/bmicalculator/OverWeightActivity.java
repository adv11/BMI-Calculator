package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OverWeightActivity extends AppCompatActivity {

    String user_name, user_bmi;
    TextView overweight_username, overweight_activity_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight);

        overweight_username = findViewById(R.id.overweight_username);
        Intent intent = getIntent();
        user_name = intent.getStringExtra("overweight_username");
        overweight_username.setText("Hi! " + user_name);

        overweight_activity_txt = findViewById(R.id.overweight_activity_txt);
        Intent intent1 = getIntent();
        user_bmi = intent1.getStringExtra("overweight_bmi");
        overweight_activity_txt.setText("Your BMI is : " + user_bmi);
    }
}