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

import com.example.navbar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;




public class Iten_Mask extends AppCompatActivity implements View.OnClickListener{

    public CardView c1, c2, c3, c4,c5,c6;
    TextView textViewUserName;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_iten_mask);
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

        textViewUserName.setText(""  +textViewUsernameString+"," +"\nSelect the vehical type?");







        c1 = ((CardView) findViewById(R.id.bmwc1));
        c2 = ((CardView) findViewById(R.id.benzec2));
        c3 = ((CardView) findViewById(R.id.audic3));
        c4 = ((CardView) findViewById(R.id.toyotac4));
        c5 = ((CardView) findViewById(R.id.rangroverc5));
        c6 = ((CardView) findViewById(R.id.othersc6));
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        c6.setOnClickListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i;
                switch (item.getItemId()) {
                    case R.id.dashbaord:
                        i = (new Intent(getApplicationContext() , Iten_Mask.class));
                        Bundle b3 = new Bundle();
                        b3.putString("textViewEmail", textViewEmailString);
                        b3.putString("textViewPassword",  textViewPasswordString);
                        b3.putString("textViewUsername", textViewNameString);
                        b3.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b3);

                        startActivity(i);
                        overridePendingTransition(0, 0);

                        return true;
                    case R.id.home:
                        i = (new Intent(getApplicationContext() , admin_nav_HomeNew.class));
                        Bundle b2 = new Bundle();
                        b2.putString("textViewEmail", textViewEmailString);
                        b2.putString("textViewPassword",  textViewPasswordString);
                        b2.putString("textViewUsername", textViewNameString);
                        b2.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b2);

                        startActivity(i);
                        overridePendingTransition(0, 0);

                        return true;
                    case R.id.about:
                        i = (new Intent(getApplicationContext() , admin_nav_about.class));
                        Bundle b = new Bundle();
                        b.putString("textViewEmail", textViewEmailString);
                        b.putString("textViewPassword",  textViewPasswordString);
                        b.putString("textViewUsername", textViewNameString);
                        b.putString("textViewId", String.valueOf( textViewID ));
                        i.putExtras(b);

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
            case R.id.bmwc1:
                i = new Intent(this,bmw1.class);
                Bundle b1 = new Bundle();
                b1.putString("textViewEmail", textViewEmailString);
                b1.putString("textViewPassword",  textViewPasswordString);
                b1.putString("textViewUsername", textViewNameString);
                b1.putString("textViewId", String.valueOf( textViewID ));
                i.putExtras(b1);

                startActivity(i);
                break;

            case R.id.benzec2:
                i = new Intent(this,benze2.class);
                Bundle b3 = new Bundle();
                b3.putString("textViewEmail", textViewEmailString);
                b3.putString("textViewPassword",  textViewPasswordString);
                b3.putString("textViewUsername", textViewNameString);
                b3.putString("textViewId", String.valueOf( textViewID ));
                i.putExtras(b3);

                startActivity(i);
                break;

            case R.id.audic3:
                i = new Intent(this,audi3.class);
                startActivity(i);
                break;

            case R.id.toyotac4:
                i = new Intent(this,toyata4.class);
                Bundle b = new Bundle();
                b.putString("textViewEmail", textViewEmailString);
                b.putString("textViewPassword",  textViewPasswordString);
                b.putString("textViewUsername", textViewNameString);
                b.putString("textViewId", String.valueOf( textViewID ));
                i.putExtras(b);

                startActivity(i);
                break;

            case R.id.rangroverc5:
                i = new Intent(this,rangerover5.class);
                startActivity(i);
                break;

            case R.id.othersc6:
                i = new Intent(this,others6.class);
                startActivity(i);
                break;

        }
    }
}

