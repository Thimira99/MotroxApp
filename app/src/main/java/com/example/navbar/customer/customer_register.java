package com.example.navbar.customer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navbar.Data.DatabaseHelper;
import com.example.navbar.Model.User;
import com.example.navbar.R;
import com.example.navbar.admin.RegisterActivity;
import com.example.navbar.admin.admin_login;

public class customer_register extends AppCompatActivity {

    customerDatabaseHelper db;
    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_register);

        db = new customerDatabaseHelper(this);
        editTextUsername = findViewById(R.id.editTextUsername1);
        editTextEmail = findViewById(R.id.editTextEmail1);
        editTextPassword = findViewById(R.id.editTextPassword1);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword1);
        buttonRegister = findViewById(R.id.buttonRegister1);

        textViewLogin = findViewById(R.id.textViewLogin1);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customer_register.this, customer_login.class));
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer cus = new customer();
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();

                if (password.equals(passwordConf)) {
                    cus.setCustomerName(userName);
                    cus.setCustomerEmail(email);

                    cus.setCustomerPassword(password);
                    long val = db.addCustomer(cus);
                    if (val > 0) {
                        Toast.makeText(customer_register.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(customer_register.this, customer_login.class);


                        startActivity(moveToLogin);
                    }

                    else

                        Toast.makeText(customer_register.this, "Registeration Error", Toast.LENGTH_SHORT).show();

                    Log.d("Item Added ID : ", String.valueOf(db.getCustomerCount()));
                }
                else
                    {
                    Toast.makeText(customer_register.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }



}
