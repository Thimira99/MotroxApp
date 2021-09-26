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



    Button button,adminloginbtn,customerloginbtn;

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

    };
}


