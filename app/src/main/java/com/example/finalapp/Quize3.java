package com.example.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quize3 extends AppCompatActivity {
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize3);
        score = findViewById(R.id.nextBtn);
        Intent intent = getIntent();
        Integer finalScore = intent.getIntExtra(com.example.finalapp.Quize22.res2, 0);
        score.setText(" "+finalScore+ " out of 10");
    }
    public void tryAgain(View view) {
        Intent intent = new Intent(Quize3.this, Quize.class);
        startActivity(intent);
    }
}