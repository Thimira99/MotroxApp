package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.navbar.admin.RegisterActivity;
import com.example.navbar.admin.admin_login;


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



    };
}