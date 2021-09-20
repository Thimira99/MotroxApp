package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //initialize variables
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign variable
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check conditions
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //initialize intent
        Intent intent = new Intent(activity,aClass);

        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //start activity
        activity.startActivity(intent);
    }

    public void ClickProfile(View view){
        //Redirect activity
        redirectActivity(this,Profile.class);

    }

    public void ClickDashboard(View view){
        //recreate activity
        recreate();
    }

    public void ClickStore(View view){
        //Redirect activity
        redirectActivity(this,Service.class);
    }

    public void ClickService(View view){
        //Redirect activity
        redirectActivity(this, Service.class);
    }

    public void ClickAboutUs(View view){
        //Redirect activity
        redirectActivity(this,AboutUs.class);
    }

    public void ClickRateUs(View view){
        //Redirect activity
        redirectActivity(this,RateUs.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}