package com.example.navbar.customer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.navbar.Model.User;
import com.example.navbar.Uti.Constants;

public class customerDatabaseHelper extends SQLiteOpenHelper {
    private Context con;



    public customerDatabaseHelper(@Nullable Context context) {
        super(context, uti_customer.DB_NAME, null, uti_customer.DB_VERSION);
        this.con = context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REGISTER_TABLE = "CREATE TABLE " + uti_customer.TABLE_NAME + "("
                + uti_customer.KEY_ID + " INTEGER PRIMARY KEY,"
                + uti_customer.KEY_CUSNAME + " TEXT,"
                + uti_customer.KEY_PASSWORD + " TEXT,"
                + uti_customer.KEY_CUSEMAIL + " TEXT UNIQUE)";
        Log.d("TableCreated", "done");
        db.execSQL(CREATE_REGISTER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + uti_customer.TABLE_NAME);

    }

    public Boolean forgetcheckCus(String customerEmail) {
        String[] columns = {uti_customer.KEY_ID};

        SQLiteDatabase db = getReadableDatabase();

        String selection = uti_customer.KEY_CUSEMAIL + "=?" ;

        String[] selectionArgs = {customerEmail};

        Cursor cursor = db.query(uti_customer.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }

    public String forgetselectOneCusSendCusName(String customerEmail) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + uti_customer.TABLE_NAME + " WHERE " + uti_customer.KEY_CUSEMAIL + " = '"+customerEmail.trim()+"'", null);
        c.moveToFirst();

        int x = 0 ;
        String y = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(uti_customer.KEY_ID)));
            y = c.getString(c.getColumnIndex(uti_customer.KEY_PASSWORD));
            Log.d("tagOneUser", Integer.toString(x) );
            Log.d("tagOneUser", y );
            break;
        }
        c.moveToNext();
        return y;
    }

    public int forgetselectOneCusSendId(String customerEmail) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + uti_customer.TABLE_NAME+ " WHERE " + uti_customer.KEY_CUSEMAIL + " = '"+customerEmail.trim()+"'" , null);
        c.moveToFirst();

        int x = 0 ;
        String y = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(uti_customer.KEY_ID)));
            y = c.getString(c.getColumnIndex(uti_customer.KEY_PASSWORD));
            Log.d("tagOneUser", Integer.toString(x) );
            Log.d("tagOneUser", y );
            break;
        }
        c.moveToNext();
        return x;
    }

    public Boolean checkCus(String customerEmail, String customerPassword) {
        String[] columns = {uti_customer.KEY_ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = uti_customer.KEY_CUSEMAIL + "=?" + " and " + uti_customer.KEY_PASSWORD + "=?";
        String[] selectionArgs = {customerEmail, customerPassword};
        Cursor cursor = db.query(uti_customer.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }

    public String selectOneCusSendCusName(String customerEmail, String customerPassword) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + uti_customer.TABLE_NAME+ " WHERE " + uti_customer.KEY_CUSEMAIL + " = '"+customerEmail.trim()+"'" +" and "+ uti_customer.KEY_PASSWORD + " = '"+customerPassword.trim()+"'" , null);
        c.moveToFirst();

        int x = 0 ;
        String y = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(uti_customer.KEY_ID)));
            y = c.getString(c.getColumnIndex(uti_customer.KEY_CUSNAME));
            Log.d("tagOneUser", Integer.toString(x) );
            Log.d("tagOneUser", y );
            break;
        }
        c.moveToNext();
        return y;
    }

    public int selectOneCusSendId(String customerEmail, String customerPassword) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + uti_customer.TABLE_NAME + " WHERE " + uti_customer.KEY_CUSEMAIL + " = '" + customerEmail.trim() + "'" + " and " + uti_customer.KEY_PASSWORD + " = '" + customerPassword.trim() + "'", null);
        c.moveToFirst();

        int x = 0;
        String y = "";
        while (c != null) {
            x = Integer.parseInt(c.getString(c.getColumnIndex(uti_customer.KEY_ID)));
            y = c.getString(c.getColumnIndex(uti_customer.KEY_CUSNAME));
            Log.d("tagOneUser", Integer.toString(x));
            Log.d("tagOneUser", y);
            break;
        }
        c.moveToNext();
        return x;
    }

    public long addCustomer(customer cus) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(uti_customer.KEY_CUSNAME, cus.getCustomerName());
        values.put(uti_customer.KEY_PASSWORD, cus.getCustomerPassword());
        values.put(uti_customer.KEY_CUSEMAIL, cus.getCustomerEmail());

        // Error
        long res = db.insert(uti_customer.TABLE_NAME, null, values);
        Log.d("Saved!", "saved to DB");
        db.close();
        return res;

    }

    public int getCustomerCount() {
        String countQuery = "SELECT * FROM " + uti_customer.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }

}
