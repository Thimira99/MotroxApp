package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.navbar.admin.RegisterActivity;
import com.example.navbar.admin.admin_login;
import com.example.navbar.customer.customer_login;

public class MainActivity extends AppCompatActivity{



    Button adminloginbtn,customerloginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adminloginbtn = findViewById(R.id.adminlogin_btn);
        customerloginbtn = findViewById(R.id.customerlogin_btn);




        adminloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, admin_login.class);
                startActivity(intent);
            }
        });


        customerloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, customer_login.class);
                startActivity(intent);
            }
        });

    };
}



        //assign variable
//        drawerLayout = findViewById(R.id.drawer_layout);


//    public void ClickMenu(View view){
//        //open drawer
//        openDrawer(drawerLayout);
//    }
//
//    public static void openDrawer(DrawerLayout drawerLayout) {
//        //open drawer layout
//        drawerLayout.openDrawer(GravityCompat.START);
//    }
//
//    public void ClickLogo(){
//        //close drawer
//        closeDrawer(drawerLayout);
//    }
//
//    public static void closeDrawer(DrawerLayout drawerLayout) {
//        //close drawer layout
//        //check conditions
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            //when drawer is open
//            //close drawer
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }
//    }
//
//    public static void redirectActivity(Activity activity,Class aClass) {
//        //initialize intent
//        Intent intent = new Intent(activity,aClass);
//
//        //set flag
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        //start activity
//        activity.startActivity(intent);
//    }
//
//    public void ClickProfile(View view){
//        //Redirect activity
//        redirectActivity(this,Profile.class);
//
//    }
//
//    public void ClickDashboard(View view){
//        //recreate activity
//        recreate();
//    }
//
//    public void ClickStore(View view){
//        //Redirect activity
//        redirectActivity(this,Store.class);
//    }
//
//    public void ClickService(View view){
//        //Redirect activity
//        redirectActivity(this, Service.class);
//    }
//
//    public void ClickAboutUs(View view){
//        //Redirect activity
//        redirectActivity(this,AboutUs.class);
//    }
//
//    public void ClickRateUs(View view){
//        //Redirect activity
//        redirectActivity(this,RateUs.class);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //close drawer
//        closeDrawer(drawerLayout);
//    }




