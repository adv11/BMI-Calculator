package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // for hiding the Status bar(present on the top of the screen)
        getSupportActionBar().hide();   // for hiding the Action bar/ Tool bar / App bar(present under the status bar)

        // for making splashScreen sleep for 5 seconds(5000 milliseconds) then shift activity from splashScreen to MainActivity
        // Using Thread for making splashScreen sleep
        Thread td = new Thread(){
          public void run(){
              try {
                  sleep(5000);
              }catch (Exception e){
                  e.printStackTrace();
              }finally {
                  Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                  startActivity(intent);
                  finish(); // writing finish(); because we don't want to show splashScreen again after pressing the back button
              }
          }
        };
        td.start(); // for starting the thread
    }
}