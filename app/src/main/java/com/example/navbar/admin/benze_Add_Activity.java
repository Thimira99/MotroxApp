package com.example.navbar.admin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.navbar.Data.MyDataBaseAdmin;
import com.example.navbar.Data.benzeDatabase;
import com.example.navbar.R;

public class benze_Add_Activity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_benze_add);
        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        add_button = findViewById(R.id.add_button);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Add Item");
        }

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                benzeDatabase myDB = new benzeDatabase(benze_Add_Activity.this);
                myDB.addItem(title_input.getText().toString().trim(),
                        author_input.getText().toString().trim(),
                        Integer.valueOf(pages_input.getText().toString().trim()));
                startActivity(new Intent(benze_Add_Activity.this, benze2.class));
            }
        });
    }
}
