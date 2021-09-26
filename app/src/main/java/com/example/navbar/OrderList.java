package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    Button placeOrder_button;
    OrderDatabaseHelper myDB;
    ArrayList<String> id,nic,firstName,lastName,streetAddress,city,email,phoneNum,qty;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        recyclerView = findViewById(R.id.recyclerView);
        placeOrder_button = findViewById(R.id.placeOrder_button);
        placeOrder_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderList.this,order.class);
                startActivity(intent);
            }
        });
        myDB = new OrderDatabaseHelper(OrderList.this);
        id = new ArrayList<>();
        nic = new ArrayList<>();
        firstName = new ArrayList<>();
        lastName = new ArrayList<>();
        streetAddress = new ArrayList<>();
        city = new ArrayList<>();
        email = new ArrayList<>();
        phoneNum = new ArrayList<>();
        qty = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(OrderList.this, id,nic,firstName,lastName,
                streetAddress,city,email,phoneNum,qty);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderList.this));
    }

    void storeDataInArrays(){
        Cursor cursor =  myDB.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this,"no data.",Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                nic.add(cursor.getString(1));
                firstName.add(cursor.getString(2));
                lastName.add(cursor.getString(3));
                streetAddress.add(cursor.getString(4));
                city.add(cursor.getString(5));
                email.add(cursor.getString(6));
                phoneNum.add(cursor.getString(7));
                qty.add(cursor.getString(8));

            }
        }
    }
}