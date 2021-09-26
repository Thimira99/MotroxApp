package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Store extends AppCompatActivity {

    RecyclerView recyclerView;
    Button order_Button;


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        recyclerView = findViewById(R.id.recyclerView);
        order_Button = findViewById(R.id.order_Button);
        order_Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent intent = new Intent(Store.this,OrderList.class);
                startActivity(intent);
            }
        });


        drawerLayout = findViewById(R.id.drawer_layout);
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
        recreate();
    }

    public void ClickService(View view){
        Dashboard.redirectActivity(this,Service.class);
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