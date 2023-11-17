package com.example;

import android.annotation.SuppressLint;
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

        double discriminant = Math.pow(b, 2) - (4 * a * c);
        double squareOne = (-b - Math.sqrt(discriminant)) / (2 * a);
        double squareTwo = (-b + Math.sqrt(discriminant)) / (2 * a);

        TextView answerDiscriminant = findViewById(R.id.discriminant);
        TextView answerSquareOne = findViewById(R.id.squareOne);
        TextView answerSquareTwo = findViewById(R.id.squareTwo);

        if (discriminant < 0) {
            @SuppressLint({"StringFormatInvalid", "LocalSuppress"})
            String discriminantText = String.format(getResources().getString(R.string.discriminantZero), discriminant);
            answerDiscriminant.setText(discriminantText);

            String SquareOneText = String.format(getResources().getString(R.string.Zero), discriminant);
            answerSquareOne.setText(SquareOneText);

            String SquareTwoText = String.format(getResources().getString(R.string.Zero), discriminant);
            answerSquareTwo.setText(SquareTwoText);

        } else {
            String discriminantText = getResources().getString(R.string.discriminantText, String.valueOf(discriminant));
            answerDiscriminant.setText(discriminantText);

            String SquareOneText = getResources().getString(R.string.squareOne, String.valueOf(discriminant));
            answerSquareOne.setText(SquareOneText);

            if (squareTwo != squareOne) {
                String SquareTwoText = getResources().getString(R.string.squareTwo, String.valueOf(discriminant));
                answerSquareTwo.setText(SquareTwoText);
            } else {
                answerSquareTwo.setText("Второго корня нет!");
            }
        }
    }
}
