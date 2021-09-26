package com.example.navbar.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navbar.Data.MyDataBaseAdmin;
import com.example.navbar.R;

public class UpdateActivity2 extends AppCompatActivity {

    EditText item_input, description_input, prize_input;
    Button update_button, delete_button;

    String itemid, itemname, itemdetails, prize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_bmw_update2);

        item_input = findViewById(R.id.title_input2);
        description_input = findViewById(R.id.author_input2);
        prize_input = findViewById(R.id.pages_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(itemname);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDataBaseAdmin myDB = new MyDataBaseAdmin(UpdateActivity2.this);
                itemname = item_input.getText().toString().trim();
                itemdetails = description_input.getText().toString().trim();
                prize = prize_input.getText().toString().trim();
                myDB.updateData(itemid, itemname, itemdetails, prize);
                startActivity(new Intent(UpdateActivity2.this, bmw1.class));
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            //Getting Data from Intent
            itemid = getIntent().getStringExtra("id");
            itemname = getIntent().getStringExtra("title");
            itemdetails = getIntent().getStringExtra("author");
            prize = getIntent().getStringExtra("pages");

            //Setting Intent Data
            item_input.setText(itemname);
            description_input.setText(itemdetails);
            prize_input.setText(prize);
            Log.d("stev", itemname+" "+itemdetails+" "+prize);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + itemname + " ?");
        builder.setMessage("Are you sure you want to delete " + itemname+ " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDataBaseAdmin myDB = new MyDataBaseAdmin(UpdateActivity2.this);
                myDB.deleteOneRow(itemid);
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
