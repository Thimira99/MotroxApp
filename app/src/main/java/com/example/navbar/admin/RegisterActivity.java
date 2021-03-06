package com.example.navbar.admin;

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

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText editTextUsername, editTextEmail, editTextPassword, editTextCnfPassword;
    Button buttonRegister;

    TextView textViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_register);

        db = new DatabaseHelper(this);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextCnfPassword = findViewById(R.id.editTextCnfPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, admin_login.class));
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                String userName = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String passwordConf = editTextCnfPassword.getText().toString().trim();


                if (password.equals(passwordConf)) {
                    user.setUserName(userName);
                    user.setEmail(email);

                    user.setPassword(password);
                    long val = db.addUser(user);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this, admin_login.class);


                        startActivity(moveToLogin);
                    } else
                        Toast.makeText(RegisterActivity.this, "Registeration Error", Toast.LENGTH_SHORT).show();

                    Log.d("Item Added ID : ", String.valueOf(db.getUsersCount()));
                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
