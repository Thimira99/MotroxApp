package com.example.navbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import java.time.format.DateTimeFormatterBuilder;

public class order extends AppCompatActivity {

    EditText NIC_Input, FirstName_Input, LastName_Input, StreetAddress_Input, City_Input,
            Email_Input, PhoneNum_Input, Quantity_Input;
    Button Confirm_Button, View_Button;

    String nic, firstname, lastname, streetAddress, city, email, phoneNum, quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        NIC_Input = findViewById(R.id.NIC_Input);
        FirstName_Input = findViewById(R.id.FirstName_Input);
        LastName_Input = findViewById(R.id.LastName_Input);
        StreetAddress_Input = findViewById(R.id.StreetAddress_Input);
        City_Input = findViewById(R.id.City_Input);
        Email_Input = findViewById(R.id.Email_Input);
        PhoneNum_Input = findViewById(R.id.PhoneNum_Input);
        Quantity_Input = findViewById(R.id.Quantity_Input);
        Confirm_Button = findViewById(R.id.Confirm_Button);
        Confirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nic = NIC_Input.getText().toString().trim();
                firstname = FirstName_Input.getText().toString().trim();
                lastname = LastName_Input.getText().toString().trim();
                streetAddress = StreetAddress_Input.getText().toString().trim();
                city = City_Input.getText().toString().trim();
                email = Email_Input.getText().toString().trim();
                phoneNum = PhoneNum_Input.getText().toString().trim();
                quantity = Quantity_Input.getText().toString().trim();

                OrderDatabaseHelper storeDB = new OrderDatabaseHelper(order.this);
                storeDB.addOrder(nic, firstname, lastname, streetAddress, city, email, phoneNum, quantity);


            }
        });


    }
}