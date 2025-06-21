package com.lab1.finddoggie;

import android.content.Context;
import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "signup.db";
    public static final String TABLE_NAME = "users";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmpassword";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public DbHelper(Context context) {
        super(context, DBNAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
                "`" + USERNAME + "` TEXT PRIMARY KEY, " +
                "`" + PASSWORD + "` TEXT, " +
                "`" + CONFIRM_PASSWORD + "` TEXT, " +
                "`" + EMAIL + "` TEXT, " +
                "`" + PHONE + "` TEXT)";

        db.execSQL(CREATE_USERS_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
    public boolean insertData(String username, String password, String confirmpassword, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, username);
        values.put(PASSWORD, password);
        values.put(CONFIRM_PASSWORD, confirmpassword);
        values.put(EMAIL, email);
        values.put(PHONE, phone);

        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=?", new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[] {username, password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean updatePassword(String username, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PASSWORD, newPassword);
        values.put(CONFIRM_PASSWORD, newPassword);

        int rowsAffected = db.update(TABLE_NAME, values, USERNAME + "=?", new String[]{username});
        return rowsAffected > 0;
    }

}
