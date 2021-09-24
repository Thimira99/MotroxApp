package com.example.navbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ServiceList extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    Button button;

    MyDatabaseHelper myDB;
    ArrayList<String> Service_id,Owner_NIC,Owner_Name,Vehicle_Number,Service_Type,Date,Time;

    ServiceAdapter serviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.add_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceList.this,AddService.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(ServiceList.this);
        Service_id = new ArrayList<>();
        Owner_NIC = new ArrayList<>();
        Owner_Name = new ArrayList<>();
        Vehicle_Number = new ArrayList<>();
        Service_Type = new ArrayList<>();
        Date = new ArrayList<>();
        Time = new ArrayList<>();

        StoreDataInArrays();

        serviceAdapter = new ServiceAdapter(ServiceList.this,ServiceList.this,Service_id,Owner_NIC,Owner_Name,Vehicle_Number,Service_Type,Date,Time);
        recyclerView.setAdapter(serviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceList.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void StoreDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                Service_id.add(cursor.getString(0));
                Owner_NIC.add(cursor.getString(1));
                Owner_Name.add(cursor.getString(2));
                Vehicle_Number.add(cursor.getString(3));
                Service_Type.add(cursor.getString(4));
                Date.add(cursor.getString(5));
                Time.add(cursor.getString(6));
            }
        }
    }

    public void ClickMenu(View view){
        //open drawer
        Dashboard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        Dashboard.closeDrawer(drawerLayout);
    }

    public void ClickProfile(View view){
        Dashboard.redirectActivity(this,Profile.class);
    }

    public void ClickDashboard(View view){
        Dashboard.redirectActivity(this,Dashboard.class);
    }

    public void ClickStore(View view){
        Dashboard.redirectActivity(this,Store.class);
    }

    public void ClickService(View view){
        recreate();
    }

    public void ClickAboutUs(View view){
        Dashboard.redirectActivity(this,AboutUs.class);
    }

    public void ClickRateUs(View view){
        Dashboard.redirectActivity(this,RateUs.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Dashboard.closeDrawer(drawerLayout);
    }
}