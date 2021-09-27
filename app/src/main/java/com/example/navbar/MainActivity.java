package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.navbar.admin.RegisterActivity;
import com.example.navbar.admin.admin_login;
import com.example.navbar.customer.customer_login;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

public class MainActivity extends AppCompatActivity{




    Button button,adminloginbtn,customerloginbtn;

    OrderDatabaseHelper myDB;
    ArrayList<String>id,nic,firstName,lastName,streetAddress,city,email,mobile,qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.dashboard);
        adminloginbtn = findViewById(R.id.adminlogin_btn);
        customerloginbtn = findViewById(R.id.customerlogin_btn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });

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


        myDB = new OrderDatabaseHelper(MainActivity.this);
        id = new ArrayList<>();
        nic = new ArrayList<>();
        firstName = new ArrayList<>();
        lastName = new ArrayList<>();
        streetAddress = new ArrayList<>();
        city = new ArrayList<>();
        mobile = new ArrayList<>();
        qty = new ArrayList<>();
    };
}





        //assign variable
//        drawerLayout = findViewById(R.id.drawer_layout);
    }

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


}

