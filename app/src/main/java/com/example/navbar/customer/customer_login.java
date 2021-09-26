package com.example.navbar.customer;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navbar.Dashboard;
import com.example.navbar.R;
import com.example.navbar.admin.RegisterActivity;

public class customer_login extends AppCompatActivity {
    EditText customer_editTextEmail, customer_editTextPassword;
    Button customer_buttonSignin;
    TextView customer_textViewSignUp, customer_text_forgetpassword;
    customerDatabaseHelper db;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.customer_login);

        db = new customerDatabaseHelper(this);
        customer_editTextEmail = findViewById(R.id.customer_editTextEmail);
        customer_editTextPassword = findViewById(R.id.customer_editTextPassword);
        customer_buttonSignin = findViewById(R.id.customer_buttonSignin);

        customer_text_forgetpassword = findViewById(R.id.customer_text_forgetpassword);
        customer_text_forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerEmail = customer_editTextEmail.getText().toString().trim();
                String customerPassword = customer_editTextPassword.getText().toString().trim();

                Boolean res = db.forgetcheckCus(customerEmail);
                customer customer = new customer();
                Log.d("IDdetail", String.valueOf(customer.getId()));

                if (res == true){
                    Toast.makeText(customer_login.this, "true", Toast.LENGTH_SHORT).show();
                    Intent HomePage = new Intent(customer_login.this, cus_forget_password.class);
                    Bundle bu = new Bundle();
                    bu.putString("textViewCusEmail", customer_editTextEmail.getText().toString());
                    bu.putString("textViewCusPassword", customer_editTextPassword.getText().toString());

                    String y = db.forgetselectOneCusSendCusName(customerEmail);
                    int x = db.forgetselectOneCusSendId(customerEmail);
                    Log.d("TAG_D" , "CUS_ID = " + x);

                    bu.putString("textViewCustomerName",y);
                    bu.putString("textViewCusId", String.valueOf(x));

                    HomePage.putExtras(bu);
                    startActivity(HomePage);
                }
                else{
                    Toast.makeText(customer_login.this, "Customer Email Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        customer_textViewSignUp = findViewById(R.id.customer_textViewSignUp);
        customer_textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customer_login.this, customer_register.class));
            }
        });


        customer_buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerEmail = customer_editTextEmail.getText().toString().trim();
                String customerPassword = customer_editTextPassword.getText().toString().trim();

                Boolean res = db.checkCus(customerEmail, customerPassword);
                customer customer = new customer();
                Log.d("IDdetail",String.valueOf(customer.getId()));

                if (res == true){
                    Intent HomePage =new Intent(customer_login.this, Dashboard.class);
                    Bundle bu = new Bundle();
                    bu.putString("textViewCusEmail", customer_editTextEmail.getText().toString());
                    bu.putString("textViewCusPassword", customer_editTextPassword.getText().toString());

                    String y = db.selectOneCusSendCusName(customerEmail, customerPassword);
                    int x = db.selectOneCusSendId(customerEmail, customerPassword);
                    Log.d("TAG_D", "CUS_ID = " + x);

                    bu.putString("textViewCustomerName",y);
                    bu.putString("textViewCusId", String.valueOf(x));

                    HomePage.putExtras(bu);
                    startActivity(HomePage);

                }
                else {
                    Toast.makeText(customer_login.this, "Login Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
