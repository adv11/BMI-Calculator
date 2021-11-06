package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NormalActivity extends AppCompatActivity {

    String user_name, user_bmi;
    TextView normal_username, normal_activity_txt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        normal_username = findViewById(R.id.normal_username);
        Intent intent = getIntent();

        user_name = intent.getStringExtra("normal_username");
        normal_username.setText("Hi! " + user_name);

        normal_activity_txt = findViewById(R.id.normal_activity_txt);
        Intent intent1 = getIntent();

        user_bmi = intent1.getStringExtra("normal_bmi");
        normal_activity_txt.setText("Your BMI is : " + user_bmi);
    }
}