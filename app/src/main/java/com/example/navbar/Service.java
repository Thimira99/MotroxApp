package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Service extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button button;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        drawerLayout = findViewById(R.id.drawer_layout);
        button = findViewById(R.id.booking_button);
        calculate = findViewById(R.id.calculate_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Service.this,ServiceList.class);
                startActivity(intent);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Service.this,CalculateMileage.class);
                startActivity(intent);
            }
        });
    }

    public void ClickMenu(View view){
        //open drawer
        Dashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        Dashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        Dashboard.redirectActivity(this,Profile.class);
    }

    public void ClickDashboard(View view){
        Dashboard.redirectActivity(this,Dashboard.class);
    }

    public void ClickStore(View view){
        Dashboard.redirectActivity(this,Store.class);
    }

    public void ClickService(View view){
        recreate();
    }

    public void ClickAboutUs(View view){
        Dashboard.redirectActivity(this,AboutUs.class);
    }

    public void ClickRateUs(View view){
        Dashboard.redirectActivity(this,RateUs.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Dashboard.closeDrawer(drawerLayout);
    }
}