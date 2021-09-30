package com.example.navbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbar.customer.customer;
import com.example.navbar.customer.customerDatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

//import com.example.navbar.customer.cus_delete_profile;

public class Profile extends AppCompatActivity {

    Button deltebtn, editDetailsbtn, changePasswordbtn;
    TextView logout, cal;
    TextInputEditText cusName, cusEmail, cusPassword;

    private AlertDialog.Builder alertDialogBuilder1;
    private AlertDialog dialog1;
    private LayoutInflater inflater1;


    String cusNameString;
    String cusEmailString;
    String cusPassworString;
    int textViewID1;



    //initialize variable
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //assign variables
        drawerLayout = findViewById(R.id.drawer_layout);
        cusName = findViewById(R.id.c_user_name);
        cusEmail = findViewById(R.id.c_e_mail);
        cusPassword = findViewById(R.id.c_password);
        logout = findViewById(R.id.textViewLogout);
        cal = findViewById(R.id.textViewCal);
        deltebtn = findViewById(R.id.customer_buttonDelete);

        final Bundle b = getIntent().getExtras();


        textViewID1 = Integer.parseInt(b.getString("textViewCusId"));
        cusNameString = b.getString("textViewCustomerName");
        cusEmailString = b.getString("textViewCusEmail");
        cusPassworString = b.getString("textViewCusPassword");

        Log.d("Data1", String.valueOf(textViewID1));
        Log.d("Data1", "Customer name: " + cusNameString);
        Log.d("Data1", "Customer Email:" + cusEmailString);
        Log.d("Data1", "Customer password:" + cusPassworString);

        cusName.setText(cusNameString);
        cusEmail.setText(cusEmailString);
        cusPassword.setText(cusPassworString);


        editDetailsbtn = findViewById(R.id.profile_button_edit);
        editDetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCustomerDetails();
            }
        });

        changePasswordbtn = findViewById(R.id.password_button_edit);
        changePasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });

        deltebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, cusdelete.class);
                        startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, MainActivity.class);
                startActivity(intent);
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, CusCal.class);
                startActivity(intent);
            }
        });
    }

        public void ClickMenu(View view){
            Dashboard.openDrawer(drawerLayout);
         }



        public void ClickLogo(View view){
            Dashboard.closeDrawer(drawerLayout);
        }

        public void ClickProfile(View view){
            recreate();
        }

        public void ClickDashboard(View view){ Dashboard.redirectActivity(this, Dashboard.class);}

        public void ClickStore(View view){Dashboard.redirectActivity(this, Store.class);}

        public void ClickService(View view){
            Dashboard.redirectActivity(this, Service.class);
        }

        public void ClickAboutUs(View view){
            Dashboard.redirectActivity(this, AboutUs.class);
        }

        public void ClickRateUs(View view){
            Dashboard.redirectActivity(this, RateUs.class);
        }

        @Override
        protected void onPause(){
            super.onPause();
            Dashboard.closeDrawer(drawerLayout);
        }

    public void changePassword(){
        alertDialogBuilder1 = new AlertDialog.Builder(Profile.this);
        inflater1 = LayoutInflater.from(Profile.this);
        final View view = inflater1.inflate(R.layout.editpassword, null);
        final EditText editPassword = view.findViewById(R.id.editTextPasswordCus);
        final EditText editConPassword = view.findViewById(R.id.editTextConfPasswordCus);

        alertDialogBuilder1.setView(view);
        dialog1 = alertDialogBuilder1.create();
        dialog1.show();

        final customer customer = new customer();
        customer.setId(textViewID1);
        customer.setCustomerName(cusNameString);
        customer.setCustomerEmail(cusEmailString);
        customer.setCustomerPassword(cusPassworString);

        editPassword.setText(customer.getCustomerPassword());

        final customerDatabaseHelper db = new customerDatabaseHelper(Profile.this);
        Button savePasswordbtn1 = view.findViewById(R.id.saveButtonPassword1);

        savePasswordbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("check", editPassword.getText().toString());
                Log.d("check", editConPassword.getText().toString());

                String password1 = editPassword.getText().toString().trim();
                String passwordConf1 = editConPassword.getText().toString().trim();

                if(password1.equals(passwordConf1)){
                    customer.setCustomerPassword(editPassword.getText().toString());
                    db.updateCustomer(customer);
                    Toast.makeText(Profile.this, "PASSWORD UPDATED", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "details saved", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(Profile.this, MainActivity.class));
                }
                else{
                    Snackbar.make(view, "don't save", Snackbar.LENGTH_SHORT).show();
                    Toast.makeText(Profile.this,"PASSWORD MISMATCH!", Toast.LENGTH_SHORT).show();
                }
                dialog1.dismiss();

            }
        });


    }

    public void editCustomerDetails(){
        alertDialogBuilder1 = new AlertDialog.Builder(Profile.this);
        inflater1 = LayoutInflater.from(Profile.this);
        final View view = inflater1.inflate(R.layout.editcusdetails, null);
        final EditText edittextCustomerName = view.findViewById(R.id.editTextUsername1);
        final EditText editTextCustomerEmail = view.findViewById(R.id.editTextEmail1);

        alertDialogBuilder1.setView(view);
        dialog1 = alertDialogBuilder1.create();
        dialog1.show();

        final customer customer = new customer();
        customer.setId(textViewID1);
        customer.setCustomerName(cusNameString);
        customer.setCustomerEmail(cusEmailString);
        customer.setCustomerPassword(cusPassworString);

        edittextCustomerName.setText(customer.getCustomerName());
        editTextCustomerEmail.setText(customer.getCustomerEmail());

        final customerDatabaseHelper db = new customerDatabaseHelper(Profile.this);

        Button saveDetailsbtn = view.findViewById(R.id.saveButton1);

        saveDetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customer.setCustomerName(edittextCustomerName.getText().toString());
                customer.setCustomerEmail(editTextCustomerEmail.getText().toString());

                if (!edittextCustomerName.getText().toString().isEmpty()
                        && !editTextCustomerEmail.getText().toString().isEmpty()) {
                    db.updateCustomer(customer);
                    Snackbar.make(v, "Details updated!", Snackbar.LENGTH_SHORT).show();
                    startActivity(new Intent(Profile.this, Profile.class));
                } else {
                    Snackbar.make(view, "error!", Snackbar.LENGTH_LONG).show();
                }

                dialog1.dismiss();
            }
        });
    }
}