package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        EditText editText1 =findViewById(R.id.weightText);
        EditText edittext2 = findViewById(R.id.heightText);
        TextView bmiview =findViewById(R.id.bmitextview);
        Button button=findViewById(R.id.bmibutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float w = Float.parseFloat(String.valueOf(editText1.getText()));
                float h = Float.parseFloat(String.valueOf(edittext2.getText()));
                float result = w / (h * h);
                bmiview.setText("BMI Score is "+result);
            }
        });


    }
}