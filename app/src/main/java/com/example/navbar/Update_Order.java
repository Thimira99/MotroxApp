package com.example.navbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Order extends AppCompatActivity {

    //initialize datas
    EditText NIC_Input, FirstName_Input, LastName_Input, StreetAddress_Input, City_Input, Email_Input, PhoneNum_Input, Quantity_Input;
    Button Update_Button,Delete_Button;

    String id,nic,firstName,lastName,streetAddress,city,email,phoneNum,qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_order);

        //assingning values
        NIC_Input = findViewById(R.id.NIC_Input2);
        FirstName_Input = findViewById(R.id.FirstName_Input2);
        LastName_Input = findViewById(R.id.LastName_Input2);
        StreetAddress_Input = findViewById(R.id.StreetAddress_Input2);
        City_Input = findViewById(R.id.City_Input2);
        Email_Input = findViewById(R.id.Email_Input2);
        PhoneNum_Input = findViewById(R.id.PhoneNum_Input2);
        Quantity_Input = findViewById(R.id.Quantity_Input2);
        Update_Button = findViewById(R.id.Update_Button);
        Delete_Button = findViewById(R.id.Delete_Button);

        //call getAndset method
        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(id);
        }

        Update_Button.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

                OrderDatabaseHelper myDB = new OrderDatabaseHelper(Update_Order.this);
                nic = NIC_Input.getText().toString().trim();         firstName = FirstName_Input.getText().toString().trim();
                lastName = LastName_Input.getText().toString().trim();
                streetAddress = StreetAddress_Input.getText().toString().trim();
                city = City_Input.getText().toString().trim();
                email = Email_Input.getText().toString().trim();
                phoneNum = PhoneNum_Input.getText().toString().trim();
                qty = Quantity_Input.getText().toString().trim();
                myDB.updateData(id, nic, firstName, lastName, streetAddress, city, email, phoneNum, qty);

            }
       });

        Delete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
}
    void getAndSetIntentData() {

        //getting data from intent
        id = getIntent().getStringExtra("id");
        nic = getIntent().getStringExtra("nic");
        firstName = getIntent().getStringExtra("firstName");
        lastName = getIntent().getStringExtra("lastName");
        streetAddress = getIntent().getStringExtra("streetAddress");
        city = getIntent().getStringExtra("city");
        email = getIntent().getStringExtra("email");
        phoneNum = getIntent().getStringExtra("phoneNum");
        qty = getIntent().getStringExtra("qty");

        //setting intent data
        NIC_Input.setText(nic);
        FirstName_Input.setText(firstName);
        LastName_Input.setText(lastName);
        StreetAddress_Input.setText(streetAddress);
        City_Input.setText(city);
        Email_Input.setText(email);
        PhoneNum_Input.setText(phoneNum);
        Quantity_Input.setText(qty);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete "+ id + "?");
        builder.setMessage("Are you sure you want to delete" + id + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                OrderDatabaseHelper myDB = new OrderDatabaseHelper(Update_Order.this);
                myDB.deleteOneRow(id);
                finish();

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}