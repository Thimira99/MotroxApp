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

public class forgrt_password extends AppCompatActivity {
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
        setContentView(R.layout.forget_password);
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

        textViewUserName.setText("Hello " + textViewUsernameString);
        textViewName.setText(textViewNameString);
        textViewPassword.setText(textViewPasswordString);
        textViewEmail.setText(textViewEmailString);

        emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }
        });




        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(forgrt_password.this, admin_login.class));
            }
        });

        btnEditDetails = findViewById(R.id.btnEditDetails);
        btnEditDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUserDidals();
            }
        });

        btnChangePassword = findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    private void senEmail() {
        String mEmail = textViewEmail.getText().toString();
        String mSubject = "Your pasword is ";
        String mMessage = textViewName.getText().toString();
        Toast.makeText(forgrt_password.this, mEmail, Toast.LENGTH_SHORT).show();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject + "'" + mMessage + "'","MOTOROX Automobiles\n" +
                "No. 53/17, C.T.B. Tourist Depot Rd,\n" +
                "Katubedda,\n" +
                "Moratuwa.\n" +
                "Tel : 0773-147488, 2632865\n" +
                "Fax : 2622444\n\n\n" + "This is a confirmation that the password for your  account is " + "'" +mMessage + "'" );

        javaMailAPI.execute();
    }

    public void changePassword() {
        alertDialogBuilder = new AlertDialog.Builder(forgrt_password.this);
        inflater = LayoutInflater.from(forgrt_password.this);
        final View view = inflater.inflate(R.layout.popup_password, null);
        final EditText editTextPasswordPopup = view.findViewById(R.id.editTextPasswordPopup);
        final EditText editTextConfPasswordPopup = view.findViewById(R.id.editTextConfPasswordPopup);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        final User user = new User();
        user.setId(textViewID);
        user.setUserName(textViewNameString);
        user.setEmail(textViewEmailString);
        user.setPassword(textViewPasswordString);

        editTextPasswordPopup.setText(user.getPassword());



        final DatabaseHelper db = new DatabaseHelper(forgrt_password.this);

        Button saveButtonPassword = view.findViewById(R.id.saveButtonPassword);

        saveButtonPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("check", editTextConfPasswordPopup.getText().toString());
                Log.d("check", editTextPasswordPopup.getText().toString());

                //user.setPassword(editTextPasswordPopup.getText().toString());
                // String conpass = (editTextConfPasswordPopup.getText().toString());


                String password = editTextPasswordPopup.getText().toString().trim();
                String passwordConf = editTextConfPasswordPopup.getText().toString().trim();

                if (password.equals(passwordConf) ) {
                    user.setPassword(editTextPasswordPopup.getText().toString());
                    db.updateUser(user);
                    Toast.makeText(forgrt_password.this, "hi from if condition ", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Details Saved!", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(forgrt_password.this, admin_login.class));
                } else{
                    Snackbar.make(view, "Don't save ", Snackbar.LENGTH_LONG).show();
                    Toast.makeText(forgrt_password.this, "what else ", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();

            }
        });
    }


    public void editUserDidals() {
        alertDialogBuilder = new AlertDialog.Builder(forgrt_password.this);
        inflater = LayoutInflater.from(forgrt_password.this);
        final View view = inflater.inflate(R.layout.popup, null);
        final EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        final EditText editTextEmail = view.findViewById(R.id.editTextEmail);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        final User user = new User();
        user.setId(textViewID);
        user.setUserName(textViewNameString);
        user.setEmail(textViewEmailString);
        user.setPassword(textViewPasswordString);

        editTextUsername.setText(user.getUserName());
        editTextEmail.setText(user.getEmail());

        final DatabaseHelper db = new DatabaseHelper(forgrt_password.this);

        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user.setUserName(editTextUsername.getText().toString());
                user.setEmail(editTextEmail.getText().toString());

                edit_email = (editTextEmail.getText().toString());

                String mSubject = "new pasword is";
                String mMessage = "qwerty";






                dialog.dismiss();

            }
        });


    }

}