package com.example.navbar.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.navbar.Model.User;
import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class admin_nav_HomeNew extends AppCompatActivity implements View.OnClickListener {

    public CardView c1, c2, c3, c4;
    TextView textViewUserName;

    String textViewUsernameString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_nav_home_new);




    textViewUserName = findViewById(R.id.textViewUserName);

    textViewUserName.setText("Hello   \n\nWhat service would you like to do today?");







        c1 = ((CardView) findViewById(R.id.ITEM_MASK));
        c2 = ((CardView) findViewById(R.id.recovery));
        c3 = ((CardView) findViewById(R.id.services));
        c4 = ((CardView) findViewById(R.id.profile));
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dashbaord:
                        startActivity(new Intent(getApplicationContext()
                                , admin_nav_dashboard.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                , admin_nav_about.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }




    @Override
    public void onClick(View v) {

        Intent i;
        switch(v.getId()){
            case R.id.ITEM_MASK:
                i = new Intent(this,admin_nav_about.class);
                startActivity(i);
                break;

            case R.id.recovery:
                i = new Intent(this,admin_nav_dashboard.class);
                startActivity(i);
                break;

            case R.id.services:
                i = new Intent(this,admin_login.class);
                startActivity(i);
                break;

            case R.id.profile:
                i = new Intent(this,HomeActivity.class);
                startActivity(i);
                break;

        }
    }
}

