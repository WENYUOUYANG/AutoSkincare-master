package com.example.auto_skincare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AutoSkincare.db";

    public static final String TABLE_NAME_PROFILE = "Profile_table";
    public static final String TABLE_NAME_PREFERENCE = "Preference_table";
    public static final String TABLE_NAME_HISTORY = "History_table";

    public static final String PROFILE_COL_1 = "name", PROFILE_COL_2 = "age", PROFILE_COL_3 = "skin_type", PROFILE_COL_4 = "product_preference";
    public static final String PREFERENCE_COL_1 = "name", PREFERENCE_COL_2 = "products", PREFERENCE_COL_3 = "speed";
    public static final String HISTORY_COL_1 = "date", HISTORY_COL_2 = "morning/products", HISTORY_COL_3 = "morning/orders", HISTORY_COL_4 = "morning/speed",
            HISTORY_COL_5 = "evening/products", HISTORY_COL_6 = "evening/order", HISTORY_COL_7 = "evening/speed";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME_PROFILE + " (name TEXT PRIMARY KEY,age INTERGER, skin_type TEXT, product_preference TEXT) ");
        db.execSQL("CREATE TABLE " + TABLE_NAME_PREFERENCE + " (name TEXT PRIMARY KEY, products TEXT, speed INTEGER)");
        db.execSQL("CREATE TABLE " + TABLE_NAME_HISTORY + " (date TEXT PRIMARY KEY, morning/products TEXT, morning/orders TEXT, morning/speed TEXT, evening/products TEXT, evening/orders TEXT, evening/speed TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean insertData_profile(String name, int age, String skin_type, String product_preference){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PROFILE_COL_1, name);
        contentValues.put(PROFILE_COL_2, age);
        contentValues.put(PROFILE_COL_3, skin_type);
        contentValues.put(PROFILE_COL_4, product_preference);

        long result = db.insert(TABLE_NAME_PROFILE,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertData_preference(String name, String products, int speed){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PREFERENCE_COL_1, name);
        contentValues.put(PREFERENCE_COL_2, products);
        contentValues.put(PREFERENCE_COL_3, speed);

        long result = db.insert(TABLE_NAME_PREFERENCE,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertData_history(String date, String morning_pro, String morning_ord, String morning_speed, String evening_pro, String evening_ord, String evening_speed){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HISTORY_COL_1, date);
        contentValues.put(HISTORY_COL_2, morning_pro);
        contentValues.put(HISTORY_COL_3, morning_ord);
        contentValues.put(HISTORY_COL_4, morning_speed);
        contentValues.put(HISTORY_COL_5, evening_pro);
        contentValues.put(HISTORY_COL_6, evening_ord);
        contentValues.put(HISTORY_COL_7, evening_speed);

        long result = db.insert(TABLE_NAME_PREFERENCE,null,contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * This method would return the whole DB as result.
     * @return
     */
    public Cursor getAllData(String table){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+ table,null);
        return result;
    }
}
