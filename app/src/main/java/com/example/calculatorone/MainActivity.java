package com.example.calculatorone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText numberOne, numberTwo;
    TextView resultTV;
    MaterialButton buttonAC, buttonAddition, buttonSubtraction, buttonDivide, buttonMultiplication, buttonModulus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTV = findViewById(R.id.result_tv);
        numberOne = findViewById(R.id.numberOne);
        numberTwo = findViewById(R.id.numberTwo);

        assignId(buttonAC, R.id.button_ac);
        assignId(buttonAddition, R.id.button_addition);
        assignId(buttonSubtraction, R.id.button_subtraction);
        assignId(buttonDivide, R.id.button_division);
        assignId(buttonModulus, R.id.button_modulus);
        assignId(buttonMultiplication, R.id.button_multiplication);
    }

    void assignId(MaterialButton btn , int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        String a = numberOne.getText().toString();
        String b = numberTwo.getText().toString();

        float number1, number2;

        if(a.equals("")){
            number1 = 0;
        }
        else{
            number1 = Float.parseFloat(a);
        }
        if(b.equals("")){
            number2 = 0;
        }else{
            number2 = Float.parseFloat(b);
        }


        if(buttonText.equals("+")){
            float r = number1 + number2;
            String result = Float.toString(r);
            if(result.endsWith(".0")){
                result = result.replace(".0","");
            }
            resultTV.setText(result);
        }
        if(buttonText.equals("-")){
            float r = number1 - number2;
            String result = Float.toString(r);
            if(result.endsWith(".0")){
                result = result.replace(".0","");
            }
            resultTV.setText(result);
        }
        if(buttonText.equals("/")){
            if(number2 == 0){
                resultTV.setText("Undefined");
                return;
            }
            float r = number1 / number2;
            String result = Float.toString(r);
            if(result.endsWith(".0")){
                result = result.replace(".0","");
            }
            resultTV.setText(result);
        }
        if(buttonText.equals("*")){
            float r = number1 * number2;
            String result = Float.toString(r);
            if(result.endsWith(".0")){
                result = result.replace(".0","");
            }
            resultTV.setText(result);
        }
        if(buttonText.equals("%")){
            if(number2 == 0){
                resultTV.setText("Undefined");
                return;
            }

            float r = number1 % number2;
            String result = Float.toString(r);
            if(result.endsWith(".0")){
                result = result.replace(".0","");
            }
            resultTV.setText(result);
        }

        if(buttonText.equals("AC")){
            resultTV.setText("0");
            numberOne.setText("");
            numberTwo.setText("");
        }
    }
}