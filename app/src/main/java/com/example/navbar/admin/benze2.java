package com.example.navbar.admin;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navbar.Data.MyDataBaseAdmin;
import com.example.navbar.Data.benzeDatabase;
import com.example.navbar.MyDatabaseHelper;
import com.example.navbar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class benze2 extends AppCompatActivity {


    TextView textViewUserName;

    String textViewUsernameString,textViewNameString,textViewEmailString,textViewPasswordString;
    int textViewID;



    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    benzeDatabase myDB;
    ArrayList<String> itemid, itemNmae, itemDetails, itemPrize;
    CustomeBenzeAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_vehical_benze2);


        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("BENZE VEHICAL PARTS");
        }



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





        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(benze2.this, benze_Add_Activity.class);
                startActivity(intent);
            }
        });

        myDB = new benzeDatabase(benze2.this);
        itemid = new ArrayList<>();
        itemNmae = new ArrayList<>();
        itemDetails = new ArrayList<>();
        itemPrize = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomeBenzeAdapter(benze2.this,this, itemid, itemNmae, itemDetails,
                itemPrize);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(benze2.this));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }else if(item.getItemId() == R.id.logout){
            Intent i;
            i = new Intent(this,Iten_Mask.class);
            Bundle b = new Bundle();
            b.putString("textViewEmail", textViewEmailString);
            b.putString("textViewPassword",  textViewPasswordString);
            b.putString("textViewUsername", textViewNameString);
            b.putString("textViewId", String.valueOf( textViewID ));
            i.putExtras(b);

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
                benzeDatabase myDB = new benzeDatabase(benze2.this);
                myDB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(benze2.this, benze2.class);
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
