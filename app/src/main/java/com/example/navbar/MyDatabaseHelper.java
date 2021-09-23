package com.example.navbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "Motrox.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Book_Service";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NIC = "Owner_NIC";
    private static final String COLUMN_NAME = "Owner_Name";
    private static final String COLUMN_NUMBER = "Vehicle_Number";
    private static final String COLUMN_TYPE = "Service_Type";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_TIME = "Time";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NIC + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_NUMBER + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_DATE + " DATE, " +
                COLUMN_TIME + " TEXT);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addService(String nic, String name, String number, String type, String date, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NIC,nic);
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_NUMBER,number);
        cv.put(COLUMN_TYPE,type);
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_TIME,time);

        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Added Successfully",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    void updateService(String id,String nic,String name,String number,String type,String date,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cc = new ContentValues();

        cc.put(COLUMN_NIC,nic);
        cc.put(COLUMN_NAME,name);
        cc.put(COLUMN_NUMBER,number);
        cc.put(COLUMN_TYPE,type);
        cc.put(COLUMN_DATE,date);
        cc.put(COLUMN_TIME,time);

        long result = db.update(TABLE_NAME,cc,  "_id=?",new String[]{id});
        if(result == -1){
            Toast.makeText(context,"Failed To Update",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Successfully Updated",Toast.LENGTH_SHORT).show();
        }

    }
}
