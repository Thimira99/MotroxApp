package com.example.navbar.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class admin_nav_about extends AppCompatActivity {
    TextView textViewUserName;

    String textViewUsernameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_nav_about);






        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashbaord:
                        startActivity(new Intent(getApplicationContext()
                                ,admin_nav_dashboard.class));
                        overridePendingTransition(0,0);

                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,admin_nav_HomeNew.class));
                        overridePendingTransition(0,0);

                        return true;
                    case R.id.about:

                        return true;
                }
                return false;
            }
        });
    }
}