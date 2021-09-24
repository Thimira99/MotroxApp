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


public class admin_login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister,textforgetpassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_login);

        db = new DatabaseHelper(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);






        textforgetpassword = findViewById(R.id.text_forgetpassword);
        textforgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();


                Boolean res = db.forgetcheckUser(email);
                User user = new User();
                Log.d("IDdetails", String.valueOf(user.getId()));


                if (res == true) {
                    Toast.makeText(admin_login.this, "truuuuuuuuuuuuu", Toast.LENGTH_LONG).show();
                    Intent HomePage = new Intent(admin_login.this, forget_password_new.class);
                    Bundle b = new Bundle();
                    b.putString("textViewEmail", editTextEmail.getText().toString());
                    b.putString("textViewPassword", editTextPassword.getText().toString());

                    String y = db.forgetselectOneUserSendUserName(email);
                    int x = db.forgetselectOneUserSendId(email);
                    Log.d("TAG" , "ID =  " + x);

                    b.putString("textViewUsername",y);
                    b.putString("textViewId", String.valueOf(x));

                    HomePage.putExtras(b);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(admin_login.this, "User Email Not Found", Toast.LENGTH_LONG).show();
                }
            }
        });







        textViewRegister = findViewById(R.id.textViewRegister);
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(admin_login.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();


                Boolean res = db.checkUser(email, password);
                User user = new User();
                Log.d("IDdetails", String.valueOf(user.getId()));


                if (res == true) {
                    Intent HomePage = new Intent(admin_login.this, HomeActivity.class);
                    Bundle b = new Bundle();
                    b.putString("textViewEmail", editTextEmail.getText().toString());
                    b.putString("textViewPassword", editTextPassword.getText().toString());

                    String y = db.selectOneUserSendUserName(email, password);
                    int x = db.selectOneUserSendId(email,password);
                    Log.d("TAG" , "ID =  " + x);

                    b.putString("textViewUsername",y);
                    b.putString("textViewId", String.valueOf(x));

                    HomePage.putExtras(b);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(admin_login.this, "Login Error", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
