package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity<weight, height> extends AppCompatActivity {

    EditText name_et, height_et, weight_et;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = (EditText) findViewById(R.id.name_et);
        height_et = (EditText) findViewById(R.id.height_et);
        weight_et = (EditText) findViewById(R.id.weight_et);
        submit_btn = (Button) findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // for checking if the user is submitting the empty entries then we have to show toast
                String check1 = height_et.getText().toString(); // check1 for checking height
                String check2 = weight_et.getText().toString(); // check2 for checking weight
                String check3 = name_et.getText().toString();   // check3 for checking name

                if(check1.isEmpty() || check2.isEmpty() || check3.isEmpty()){   // if checks are not valid

                    Toast toast = Toast.makeText(MainActivity.this, "Entries are not valid", Toast.LENGTH_SHORT);
                    toast.show();
                }else{  // if checks are valid

                    float height = Integer.parseInt(height_et.getText().toString());
                    float weight = Integer.parseInt(weight_et.getText().toString());

                    // getting user's first name
                    String whole_user_name = name_et.getText().toString();
                    String[] temp_name_array = whole_user_name.split(" ");

                    height /= 100;  // for converting height into meter
                    float resultant_bmi = (weight / (height * height));

                    // for underweight activity
                    if(resultant_bmi < 18.5){   // if BMI > 18.5


                        // not working : app crash
                        Intent intent = new Intent(MainActivity.this, UnderWeightActivity.class);
                        String underweight_user_first_name = temp_name_array[0];
                        String underweightuser_bmi = String.valueOf(resultant_bmi);

                        intent.putExtra("underweight_username", underweight_user_first_name); // for sending user_name to next activity
                        intent.putExtra("underweight_bmi", underweightuser_bmi);
                        startActivity(intent);
                    }
                    // for normal activity
                    else if(resultant_bmi >= 18.5 && resultant_bmi <= 24.9){   // if BMI >= 18.5 and BMI <= 24.9


                        // This is working fine : showing username
                        Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                        String normal_user_first_name = temp_name_array[0];
                        String normaluser_bmi = String.valueOf(resultant_bmi);

                        intent.putExtra("normal_username", normal_user_first_name); // for sending user_name to next activity
                        intent.putExtra("normal_bmi", normaluser_bmi);
                        startActivity(intent);
                    }
                    // for overweight activity
                    else if(resultant_bmi >= 25 && resultant_bmi <= 29.9){ // BMI >= 25 and BMI <= 29.9

                        // not working : app crash
                        Intent intent = new Intent(MainActivity.this, OverWeightActivity.class);
                        String overweight_user_first_name = temp_name_array[0];
                        String overweigthuser_bmi = String.valueOf(resultant_bmi);

                        intent.putExtra("overweight_username", overweight_user_first_name); // for sending user_name to next activity
                        intent.putExtra("overweight_bmi", overweigthuser_bmi);
                        startActivity(intent);
                    }
                    // for obese activity
                    else{  // BMI >= 30

                        // not working : app crash
                        Intent intent = new Intent(MainActivity.this, ObeseActivity.class);
                        String obese_user_first_name = temp_name_array[0];
                        String obeseuser_bmi = String.valueOf(resultant_bmi);

                        intent.putExtra("obese_username", obese_user_first_name); // for sending user_name to next activity
                        intent.putExtra("obese_bmi", obeseuser_bmi);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}