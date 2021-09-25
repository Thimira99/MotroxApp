package com.example.navbar.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class admin_nav_about extends AppCompatActivity {
    TextView textViewUserName;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_nav_about);


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


        textViewUserName = findViewById(R.id.textViewUserName);

        textViewUserName.setText("Hello"  +textViewUsernameString +"\n\nWhat service would you like to do today?");






        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()){
                    case R.id.dashbaord:
                        i = (new Intent(getApplicationContext() , admin_nav_dashboard.class));
                        Bundle b = new Bundle();
                        b.putString("textViewEmail", textViewEmailString);
                        b.putString("textViewPassword",  textViewPasswordString);
                        b.putString("textViewUsername", textViewNameString);
                        b.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b);

                        startActivity(i);

                        overridePendingTransition(0,0);

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
                        return true;
                    case R.id.about:

                        return true;
                }
                return false;
            }
        });
    }
}