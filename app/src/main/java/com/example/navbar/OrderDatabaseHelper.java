package com.example.navbar;

//import static android.widget.Toast.LENGTH_SHORT;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class OrderDatabaseHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME= "Store.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "OrderTable";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NIC = "NIC";
    private static final String COLUMN_FName = "FirstName";
    private static final String COLUMN_LName = "LastName";
    private static final String COLUMN_SAddress = "StreetAddress";
    private static final String COLUMN_CITY = "City";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_MOBILE = "PhoneNum";
    private static final String COLUMN_QUANTITY = "Quantity";


    public OrderDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NIC + " TEXT, " +
                COLUMN_FName + " TEXT, " +
                COLUMN_LName + " TEXT, " +
                COLUMN_SAddress + " TEXT, " +
                COLUMN_CITY + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_MOBILE + " TEXT, " +
                COLUMN_QUANTITY + " INTEGER);";

        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }

    void addOrder(String nic, String Firstname, String Lastname, String StreetAddress,
                  String city, String Email, String mobile, String qty){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NIC, nic);
        cv.put(COLUMN_FName, Firstname);
        cv.put(COLUMN_LName, Lastname);
        cv.put(COLUMN_SAddress, StreetAddress);
        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_EMAIL, Email);
        cv.put(COLUMN_MOBILE, mobile);
        cv.put(COLUMN_QUANTITY, qty);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Order Successful", Toast.LENGTH_SHORT).show();
        }



    }
}