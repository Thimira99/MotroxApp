package com.example.navbar.admin;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navbar.Data.DatabaseHelper;
import com.example.navbar.Model.User;
import com.example.navbar.R;
import com.google.android.material.snackbar.Snackbar;

public class forget_password_new extends AppCompatActivity {
    TextView textViewUserName, textViewName, textViewPassword, textViewEmail, textViewLogout;

    Button btnEditDetails, btnChangePassword,emailbtn;

    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private LayoutInflater inflater;

    String textViewUsernameString;
    String textViewNameString;
    String textViewEmailString;
    String textViewPasswordString;
    int textViewID;
    String edit_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_new);
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewName = findViewById(R.id.textViewName);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewLogout = findViewById(R.id.textViewLogout);

        emailbtn = findViewById(R.id.email_btn);

        final Bundle b = getIntent().getExtras();


        textViewID = Integer.parseInt(b.getString("textViewId"));
        textViewUsernameString = b.getString("textViewUsername");
        textViewNameString = b.getString("textViewUsername");
        textViewEmailString = b.getString("textViewEmail");
        textViewPasswordString = b.getString("textViewPassword");


        Log.d("Data", String.valueOf(textViewID));
        Log.d("Data", "User name: " + textViewUsernameString);
        Log.d("Data", "name: " + textViewNameString);
        Log.d("Data", "Email: " + textViewEmailString);
        Log.d("Data", "password: " + textViewPasswordString);


        textViewName.setText(textViewEmailString);

        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
                startActivity(new Intent(forget_password_new.this, admin_login.class));
            }
        });


    }

    private void senEmail() {
        String mEmail = textViewEmailString;
        String mSubject = "Your pasword is ";
        String mMessage = textViewNameString;
        Toast.makeText(forget_password_new.this, "Email sent to "+ mEmail, Toast.LENGTH_SHORT).show();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject + "'" + mMessage + "'","MOTOROX Automobiles\n" +
                "No. 53/17, C.T.B. Tourist Depot Rd,\n" +
                "Katubedda,\n" +
                "Moratuwa.\n" +
                "Tel : 0773-147488, 2632865\n" +
                "Fax : 2622444\n\n\n" + "This is a confirmation that the password for your  account is " + "'" +mMessage + "'" );

        javaMailAPI.execute();
    }




    }

