package com.example.navbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
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

import com.example.navbar.Data.MyDataBaseAdmin;
import com.example.navbar.admin.AddActivity;
import com.example.navbar.admin.CustomAdapter;
import com.example.navbar.admin.Iten_Mask;
import com.example.navbar.admin.bmw1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Store extends AppCompatActivity {

    TextView textViewUserName;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;



    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    MyDataBaseAdmin myDB;
    ArrayList<String> itemid, itemNmae, itemDetails, itemPrize;
    CustomItemAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("ALL VEHICLE PARTS");
        }


        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Store.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDataBaseAdmin(Store.this);
        itemid = new ArrayList<>();
        itemNmae = new ArrayList<>();
        itemDetails = new ArrayList<>();
        itemPrize = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomItemAdapter(Store.this,this, itemid, itemNmae, itemDetails,
                itemPrize);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Store.this));

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
                itemid.add(cursor.getString(0));
                itemNmae.add(cursor.getString(1));
                itemDetails.add(cursor.getString(2));
                itemPrize.add(cursor.getString(3));
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

}

