package com.example.finalapp;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Quize extends AppCompatActivity {
    RadioGroup radioGroup;
    public static final String res1 = "com.example.quizappfirst.extra.1.result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);
        radioGroup = findViewById(R.id.radioOption);
    }
    public void nextPressListener(View view) {
        Intent intent = new Intent(this, Quize22.class);
        intent.putExtra(res1, rightOrWrongChecker());
        startActivity(intent);
    }
    int rightOrWrongChecker(){
        int selectedID = radioGroup.getCheckedRadioButtonId();
        Button selectedButton = findViewById(selectedID);
        String selectedText = selectedButton.getText().toString();
        switch(selectedText){
            case "Cox's Bazar":
                return 5;
            default:
                return 0;
        }
    }
    public void prePage(View view) {
        Intent intent = new Intent(Quize.this, Quize22.class);
        startActivity(intent);
    }
}