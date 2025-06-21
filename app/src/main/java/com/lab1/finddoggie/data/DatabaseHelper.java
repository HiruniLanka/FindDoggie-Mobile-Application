package com.lab1.finddoggie.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper  {

    public static final String DATABASE_WORK = "Pet Profile";
    public static final String TABLE_LIST = "Pet_details";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "Pet Name";
    public static final String COLUMN_GENDER = "Gender";
    public static final String COLUMN_NUMBER = "Pet Number";

//    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context) {
        super(context,"DATABASE_STUDENT",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE_QUERY = "CREATE TABLE " + TABLE_LIST
                + "(" + COLUMN_ID + " INTEGER " + "PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_GENDER + " TEXT, "
                + COLUMN_NUMBER +" INT)";
        db.execSQL(CREATE_STUDENT_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIST);
        onCreate(db);
    }
    public boolean insertData(String string, String toString, String s, String work, String date, String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,work);
        contentValues.put(COLUMN_GENDER,date);
        contentValues.put(COLUMN_NUMBER,time);
        long result = db.insert(TABLE_LIST,null,contentValues);
        return result != -1;


    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_LIST, null);
        return result;
    }


    public boolean upDateData(String id, String work, String date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,work);
        contentValues.put(COLUMN_GENDER,date);
        contentValues.put(COLUMN_NUMBER,time);
        db.update(TABLE_LIST,contentValues,"id = ?", new String[] {id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_LIST,"ID = ?",new String[] {id});
    }
}

