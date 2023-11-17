package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.docjava.R;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solveEquation(View view) {
        // ax+b=c
        double a = Double.parseDouble(((EditText)findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble(((EditText)findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble(((EditText)findViewById(R.id.coefficient_c)).getText().toString());

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        double squareOne = (-b + Math.pow(discriminant, 0.5)) / 2 * a;
        double squareTwo = (-b - Math.pow(discriminant, 0.5)) / 2 * a;

        TextView answerDiscriminant = findViewById(R.id.discriminant);
        TextView answerSquareOne = findViewById(R.id.squareOne);
        TextView answerSquareTwo = findViewById(R.id.squareTwo);


        answerDiscriminant.setText("Дискриминант: " + discriminant);
        answerSquareOne.setText("Первый корень: " + squareOne);
        answerSquareTwo.setText("Второй корень: " + squareTwo);
    }
}
