package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    //initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //assign variables
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        recreate();
    }

    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickStore(View view){
        MainActivity.redirectActivity(this,Store.class);
    }

    public void ClickService(View view){
        MainActivity.redirectActivity(this,Service.class);
    }

    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,AboutUs.class);
    }

    public void ClickRateUs(View view){
        MainActivity.redirectActivity(this,RateUs.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}