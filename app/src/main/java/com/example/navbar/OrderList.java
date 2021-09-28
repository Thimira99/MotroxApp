package com.example.navbar;

import androidx.annotation.Nullable;
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.NotNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
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