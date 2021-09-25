package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateMileage extends AppCompatActivity {

    EditText fuel,distance;
    Button button;
    TextView answer;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_mileage);

        fuel = findViewById(R.id.fuel);
        distance = findViewById(R.id.distance);
        button = findViewById(R.id.calculate_mileage_button);
        answer = findViewById(R.id.answer);
        context = context;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(fuel.getText().toString());
                int number2 = Integer.parseInt(distance.getText().toString());
                double mileage = (double)number2 / (double) number1;

                answer.setText("Mileage: " + String.valueOf(Math.round(mileage * 100)/100.0) + " Km/Litre");
            }
        });

    }
}