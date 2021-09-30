package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddService extends AppCompatActivity {

    EditText Owner_NIC_input,Owner_Name_input,Vehicle_Number_input,Service_type_input,Date_input,time_input;
    Button add_service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

        Owner_NIC_input = findViewById(R.id.Owner_NIC_input);
        Owner_Name_input = findViewById(R.id.Owner_Name_input);
        Vehicle_Number_input = findViewById(R.id.Vehicle_Number_input);
        Service_type_input = findViewById(R.id.Service_type_input);
        Date_input = findViewById(R.id.Date_input);
        time_input = findViewById(R.id.time_input);

        add_service = findViewById(R.id.add_service);



        add_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    MyDatabaseHelper myDB = new MyDatabaseHelper(AddService.this);
                    if(TextUtils.isEmpty(Owner_NIC_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter National Identity Number",Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(Owner_Name_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter Name",Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(Vehicle_Number_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter Vehicle Number",Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(Service_type_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter Service Type",Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(Date_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter Date",Toast.LENGTH_SHORT).show();
                    }else if(TextUtils.isEmpty(time_input.getText().toString())){
                        Toast.makeText(AddService.this,"Enter Time",Toast.LENGTH_SHORT).show();
                    } else {
                        myDB.addService(Owner_NIC_input.getText().toString(),Owner_Name_input.getText().toString(),Vehicle_Number_input.getText().toString(),
                                Service_type_input.getText().toString(),Date_input.getText().toString(),time_input.getText().toString());
                    }

            }
        });
    }
}