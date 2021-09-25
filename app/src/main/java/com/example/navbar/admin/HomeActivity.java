package com.example.navbar.admin;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navbar.Model.User;
import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.example.navbar.Data.DatabaseHelper;

public class HomeActivity extends AppCompatActivity {

    TextView textViewUserName, textViewName, textViewPassword, textViewEmail, textViewLogout;

    Button btnEditDetails, btnChangePassword , byn_dashboard;

    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private LayoutInflater inflater;

    String textViewUsernameString;
    String textViewNameString;
    String textViewEmailString;
    String textViewPasswordString;
    int textViewID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewName = findViewById(R.id.textViewName);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewLogout = findViewById(R.id.textViewLogout);

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


        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, admin_login.class));
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







        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.about);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()){
                    case R.id.dashbaord:
                        i = (new Intent(getApplicationContext() , Iten_Mask.class));
                        Bundle b = new Bundle();
                        b.putString("textViewEmail", textViewEmailString);
                        b.putString("textViewPassword",  textViewPasswordString);
                        b.putString("textViewUsername", textViewNameString);
                        b.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b);

                        startActivity(i);

                        overridePendingTransition(0,0);

                        return true;
                    case R.id.home:
                        i = (new Intent(getApplicationContext() , admin_nav_HomeNew.class));
                        Bundle b2 = new Bundle();
                        b2.putString("textViewEmail", textViewEmailString);
                        b2.putString("textViewPassword",  textViewPasswordString);
                        b2.putString("textViewUsername", textViewNameString);
                        b2.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b2);

                        startActivity(i);
                        return true;
                    case R.id.about:

                        return true;
                }
                return false;
            }
        });











    }

    public void changePassword() {
        alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        inflater = LayoutInflater.from(HomeActivity.this);
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



        final DatabaseHelper db = new DatabaseHelper(HomeActivity.this);

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
                    Toast.makeText(HomeActivity.this, "hi from if condition ", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Details Saved!", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(HomeActivity.this, admin_login.class));
                } else{
                    Snackbar.make(view, "Don't save ", Snackbar.LENGTH_LONG).show();
                    Toast.makeText(HomeActivity.this, "what else ", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();

            }
        });
    }


    public void editUserDidals() {
        alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
        inflater = LayoutInflater.from(HomeActivity.this);
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

        final DatabaseHelper db = new DatabaseHelper(HomeActivity.this);

        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(editTextUsername.getText().toString());
                user.setEmail(editTextEmail.getText().toString());

                if (!editTextUsername.getText().toString().isEmpty()
                        && !editTextEmail.getText().toString().isEmpty()) {
                    db.updateUser(user);
                    Snackbar.make(v, "Details Saved!", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                } else {
                    Snackbar.make(view, "Don't save ", Snackbar.LENGTH_LONG).show();
                }
                dialog.dismiss();

            }
        });
    }

}
