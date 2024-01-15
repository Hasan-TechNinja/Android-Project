package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;
import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    TextView primaryView, secondaryView;
    Button numberBtn;
    String primaryValue,check;
    String num1,num2,operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        primaryView=findViewById(R.id.primaryTextViewID);
        secondaryView=findViewById(R.id.secondayTextViewID);
    }

    public void numberFunction(View view) {
        numberBtn=findViewById(view.getId());
        primaryValue=primaryView.getText().toString();
        if(primaryValue.equals("0")){
            primaryView.setText(numberBtn.getText().toString());
        }
        else {
            primaryView.setText(primaryValue+numberBtn.getText().toString());
        }
    }

    public void clearToast(View view) {
        primaryView.setText("0");
        primaryValue = "0";
    }

    public void operatorFunction(View view) {
        num1=primaryView.getText().toString();
        numberBtn=findViewById(view.getId());
        operator=numberBtn.getText().toString();
        secondaryView.setText(num1+" "+operator);
        primaryView.setText("0");
    }

    public void resultFunction(View view) {
        Double value1,value2,result;
        value1=Double.parseDouble(num1);
        value2=Double.parseDouble(primaryView.getText().toString());
        if(operator.equals("+")){
            result=value1+value2;
            check = String.format("%.2f", result);
            result = Double.parseDouble(check);
        }else if (operator.equals("-")){
            result=value1-value2;
            check = String.format("%.2f", result);
            result = Double.parseDouble(check);
        }else if (operator.equals("*")){
            result=value1*value2;
            check = String.format("%.2f", result);
            result = Double.parseDouble(check);
        }else if(operator.equals("%")) {
            result = value1%value2;
        }else{
            result=value1/value2;
            check = String.format("%.2f", result);
            result = Double.parseDouble(check);
        }
        secondaryView.setText(num1 +operator+primaryView.getText().toString()+" =");
        primaryView.setText(""+result);
    }

    public void lastElementRemove(View view) {
        num1=primaryView.getText().toString();
        if(num1.equals("0")){
            primaryView.setText("0");
            primaryValue = "0";
        }else{
            num1 = num1.substring(0, num1.length() - 1);
            if(num1.equals("")){
                primaryView.setText("0");
                primaryValue = "0";
            }else {
                primaryView.setText(num1);
                primaryValue = num1;
            }
        }
    }
}