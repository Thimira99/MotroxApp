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

public class UpdateService extends AppCompatActivity {

    EditText Owner_nic_input,Owner_name_input,Vehicle_number_input,Service_type_input,Date_input,Time_input;
    Button update_service,delete_service;

    String id,owner_nic,owner_name,vehicle_number,service_type,date,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_service);

        Owner_nic_input = findViewById(R.id.Owner_NIC_input2);
        Owner_name_input = findViewById(R.id.Owner_Name_input2);
        Vehicle_number_input = findViewById(R.id.Vehicle_Number_input2);
        Service_type_input = findViewById(R.id.Service_type_input2);
        Date_input = findViewById(R.id.Date_input2);
        Time_input = findViewById(R.id.Time_input2);

        update_service = findViewById(R.id.update_service);
        delete_service = findViewById(R.id.delete_service);

        getAndSetIntentData();

        update_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper db = new MyDatabaseHelper(UpdateService.this);
                owner_nic = Owner_nic_input.getText().toString().trim();
                owner_name = Owner_name_input.getText().toString().trim();
                vehicle_number = Vehicle_number_input.getText().toString().trim();
                service_type = Service_type_input.getText().toString().trim();
                date = Date_input.getText().toString().trim();
                time = Time_input.getText().toString().trim();
                db.updateService(id,owner_nic,owner_name,vehicle_number,service_type,date,time);
            }
        });

        delete_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("owner_name") &&
                getIntent().hasExtra("owner_nic") &&
                getIntent().hasExtra("vehicle_number") &&
                getIntent().hasExtra("service_type") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("time")){

            //Getting Data From intent
            id = getIntent().getStringExtra("id");
            owner_nic = getIntent().getStringExtra("owner_nic");
            owner_name = getIntent().getStringExtra("owner_name");
            vehicle_number = getIntent().getStringExtra("vehicle_number");
            service_type = getIntent().getStringExtra("service_type");
            date = getIntent().getStringExtra("date");
            time = getIntent().getStringExtra("time");

            //Setting Intent Data
            Owner_nic_input.setText(owner_nic);
            Owner_name_input.setText(owner_name);
            Vehicle_number_input.setText(vehicle_number);
            Service_type_input.setText(service_type);
            Date_input.setText(date);
            Time_input.setText(time);
        }else {
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + owner_name + " ?");
        builder.setMessage("Are you sure you want to delete " + owner_name + " ?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateService.this);
                myDB.deleteRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


}