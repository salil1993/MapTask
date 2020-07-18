package com.example.mapdemo.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLHelperClass extends SQLiteOpenHelper {
    private static final String TAG = "SQLHelperClass";
    public static final String dbName = "Database";
    public static final int dbVersion = '1';
    private Context context;
    public static final String TABLE_NAME = "Location";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE =  "longitude";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_PINCODE = "pincode";


    public SQLHelperClass(Context context) {
        super(context, dbName, null, dbVersion);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABLE_NAME+
                " (" + COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LATITUDE +" TEXT,  "+
                COLUMN_LONGITUDE+"  TEXT, "+
                COLUMN_CITY +" TEXT, "+
                COLUMN_STATE+" TEXT,"+
                COLUMN_PINCODE+" TEXT);";

        sqLiteDatabase.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    /*insertion*/
    public void addLocation(String latitude, String longitude, String city, String state, String pincode){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LATITUDE, latitude);
        cv.put(COLUMN_LONGITUDE, longitude);
        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_STATE, state);
        cv.put(COLUMN_PINCODE, pincode);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllLocation(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateLocation(String row_id,String latitude, String longitude, String city, String state, int pincode){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(String.valueOf(COLUMN_LATITUDE), latitude);
        cv.put(String.valueOf(COLUMN_LONGITUDE), longitude);
        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_STATE, state);
        cv.put(String.valueOf(COLUMN_PINCODE), pincode);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }


}
