package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Button;

public class Quize22 extends AppCompatActivity {
    RadioGroup radioGroup;
    public static final String res2 = "com.example.quizappfirst.extra.2.result";
    Integer quizScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize22);
        radioGroup = findViewById(R.id.radioOptionQ2);
        Intent intent = getIntent();
        quizScore = intent.getIntExtra(Quize.res1, 0);
    }
    public void nextPage(View view) {
        Intent intent = new Intent(this, Quize3.class);
        intent.putExtra(res2, rightOrWrongChecker()+quizScore);
        startActivity(intent);
    }
    int rightOrWrongChecker(){
        int selectedID = radioGroup.getCheckedRadioButtonId();
        Button selectedButton = findViewById(selectedID);
        String selectedText = selectedButton.getText().toString();
        switch(selectedText){
            case "Google":
                return 5;
            default:
                return 0;
        }
    }
}