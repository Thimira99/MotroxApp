package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class RateUs extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        drawerLayout= findViewById(R.id.drawer_layout);
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

        Dashboard.redirectActivity(this,Service.class);
    }

    public void ClickAboutUs(View view){
        Dashboard.redirectActivity(this,AboutUs.class);
    }

    public void ClickRateUs(View view){
        recreate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Dashboard.closeDrawer(drawerLayout);
    }
}