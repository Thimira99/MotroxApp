package com.example.navbar.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Recoveryc1 extends AppCompatActivity {

    EditText fuel,distance;
    Button button;
    TextView answer;
    Context context;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_recoveryc1);

        final Bundle b = getIntent().getExtras();



        textViewID = Integer.parseInt(b.getString("textViewId"));
        textViewUsernameString = b.getString("textViewUsername");
        textViewNameString = b.getString("textViewUsername");
        textViewEmailString = b.getString("textViewEmail");
        textViewPasswordString = b.getString("textViewPassword");


        Log.d("Data", String.valueOf(textViewID));
        Log.d("Data", "User name: " + textViewUsernameString);
        Log.d("Data", "name: " + textViewNameString);
        Log.d("Data", "Email: " + textViewEmailString);
        Log.d("Data", "password: " + textViewPasswordString);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.dashbaord:
                        i = (new Intent(getApplicationContext() , Iten_Mask.class));
                        Bundle b3 = new Bundle();
                        b3.putString("textViewEmail", textViewEmailString);
                        b3.putString("textViewPassword",  textViewPasswordString);
                        b3.putString("textViewUsername", textViewNameString);
                        b3.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b3);

                        startActivity(i);
                        overridePendingTransition(0, 0);

                        return true;
                    case R.id.home:
                        i = (new Intent(getApplicationContext() , admin_nav_HomeNew.class));
                        Bundle b2 = new Bundle();
                        b2.putString("textViewEmail", textViewEmailString);
                        b2.putString("textViewPassword",  textViewPasswordString);
                        b2.putString("textViewUsername", textViewNameString);
                        b2.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b2);

                        startActivity(i);
                        overridePendingTransition(0, 0);

                        return true;
                    case R.id.about:
                        i = (new Intent(getApplicationContext() , admin_nav_about.class));
                        Bundle b = new Bundle();
                        b.putString("textViewEmail", textViewEmailString);
                        b.putString("textViewPassword",  textViewPasswordString);
                        b.putString("textViewUsername", textViewNameString);
                        b.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b);

                        startActivity(i);
                        overridePendingTransition(0, 0);
                }
                return false;
            }
        });

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
                int number3 = 55;
                double mileage = (double)number1 * (double) number3;


                answer.setText("     Rs   " + String.valueOf(Math.round(mileage * number2)/100.0) + "0 \n     Total per KM");
            }
        });

    }
}



