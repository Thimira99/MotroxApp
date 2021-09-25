package com.example.navbar.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.navbar.Model.User;
import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class admin_nav_HomeNew extends AppCompatActivity implements View.OnClickListener {

    public CardView c1, c2, c3, c4;
    TextView textViewUserName;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_nav_home_new);

        final Bundle b = getIntent().getExtras();



        textViewID = Integer.parseInt(b.getString("textViewId"));
        textViewUsernameString = b.getString("textViewUsername");
        textViewNameString = b.getString("textViewUsername");
        textViewEmailString = b.getString("textViewEmail");
        textViewPasswordString = b.getString("textViewPassword");


        Log.d("Data", String.valueOf(textViewID));
        Log.d("Data", "User name: " + textViewUsernameString);
        Log.d("Data", "name: " + textViewNameString);
        Log.d("Data", "Email: " + textViewEmailString);
        Log.d("Data", "password: " + textViewPasswordString);




    textViewUserName = findViewById(R.id.textViewUserName);

    textViewUserName.setText("Hello "  +textViewUsernameString+"," +"\n\nWhat service would you like to do today?");







        c1 = ((CardView) findViewById(R.id.ITEM_MASK));
        c2 = ((CardView) findViewById(R.id.recovery));
        c3 = ((CardView) findViewById(R.id.services));
        c4 = ((CardView) findViewById(R.id.profile));
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.dashbaord:
                        i = (new Intent(getApplicationContext() , Iten_Mask.class));
                        Bundle b = new Bundle();
                        b.putString("textViewEmail", textViewEmailString);
                        b.putString("textViewPassword",  textViewPasswordString);
                        b.putString("textViewUsername", textViewNameString);
                        b.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b);

                        startActivity(i);


                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.about:
                        i = (new Intent(getApplicationContext() , admin_nav_about.class));
                        Bundle b2 = new Bundle();
                        b2.putString("textViewEmail", textViewEmailString);
                        b2.putString("textViewPassword",  textViewPasswordString);
                        b2.putString("textViewUsername", textViewNameString);
                        b2.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b2);

                        startActivity(i);
                        overridePendingTransition(0, 0);
                }
                return false;
            }
        });


    }




    @Override
    public void onClick(View v) {

        Intent i;
        switch(v.getId()){
            case R.id.ITEM_MASK:
                i = new Intent(this,Iten_Mask.class);
                Bundle b1 = new Bundle();
                b1.putString("textViewEmail", textViewEmailString);
                b1.putString("textViewPassword",  textViewPasswordString);
                b1.putString("textViewUsername", textViewNameString);
                b1.putString("textViewId", String.valueOf( textViewID ));
                i.putExtras(b1);
                startActivity(i);
                break;

            case R.id.recovery:
                i = new Intent(this,Iten_Mask.class);
                startActivity(i);
                break;

            case R.id.services:
                i = new Intent(this,admin_login.class);
                startActivity(i);
                break;

            case R.id.profile:
                i = new Intent(this,HomeActivity.class);
                Bundle b = new Bundle();
                b.putString("textViewEmail", textViewEmailString);
                b.putString("textViewPassword",  textViewPasswordString);
                b.putString("textViewUsername", textViewNameString);
                b.putString("textViewId", String.valueOf( textViewID ));
                i.putExtras(b);

                startActivity(i);
                break;

        }
    }
}

