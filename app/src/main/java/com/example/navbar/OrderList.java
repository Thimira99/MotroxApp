package com.example.navbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbar.Data.MyDataBaseAdmin;
import com.example.navbar.admin.AddActivity;
import com.example.navbar.admin.Iten_Mask;
import com.example.navbar.admin.bmw1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    RecyclerView recyclerView;
    Button placeOrder_button;
    OrderDatabaseHelper myDB;
    ArrayList<String> id,nic,firstName,lastName,streetAddress,city,email,phoneNum,qty;
    ItemCustomAdapter customAdapter;
    TextView textViewUserName;
        String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
        int textViewID;
        FloatingActionButton add_button;
        ImageView empty_imageview;
        TextView no_data;
        ArrayList<String> itemid, itemNmae, itemDetails, itemPrize;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_list);


            ActionBar ab = getSupportActionBar();
            if (ab != null) {
                ab.setTitle("BMW VEHICAL PARTS");
            }







            recyclerView = findViewById(R.id.recyclerView);
            add_button = findViewById(R.id.add_button);
            empty_imageview = findViewById(R.id.empty_imageview);
            no_data = findViewById(R.id.no_data);

            add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(OrderList.this, Store.class);
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

            customAdapter = new ItemCustomAdapter(OrderList.this,this, id, nic, firstName,lastName,streetAddress,city,email,phoneNum,qty);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(OrderList.this));

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == 1){
                recreate();
            }
        }

        void storeDataInArrays(){
            Cursor cursor = myDB.readAllData();
            if(cursor.getCount() == 0){
                empty_imageview.setVisibility(View.VISIBLE);
                no_data.setVisibility(View.VISIBLE);
            }else{
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
                empty_imageview.setVisibility(View.GONE);
                no_data.setVisibility(View.GONE);
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.my_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if(item.getItemId() == R.id.delete_all){
                confirmDialog();
            }else if(item.getItemId() == R.id.logout){
                Intent i;
                i = new Intent(this, Store.class);
                startActivity(i);
            }
            return super.onOptionsItemSelected(item);
        }

        void confirmDialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Delete All?");
            builder.setMessage("Are you sure you want to delete all Data?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MyDataBaseAdmin myDB = new MyDataBaseAdmin(OrderList.this);
                    myDB.deleteAllData();
                    //Refresh Activity

                    //not working need to do in database


                    Intent intent = new Intent(OrderList.this, OrderList.class);
                    startActivity(intent);
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
