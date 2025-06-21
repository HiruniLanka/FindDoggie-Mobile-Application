package com.lab1.finddoggie.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PostDbHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "PostPet.db";  // Database name
    public static final String TABLE_NAME = "Post_Pet";  // Table name
    public static final String PET_NAME = "PetName";  // Column name for pet name
    public static final String ID = "ID";  // Column name for ID
    public static final String SPECIES = "Species";  // Column name for species
    public static final String AGE = "Age";  // Column name for age
    public static final String GENDER = "Gender";  // Column name for gender
    public static final String DESCRIPTION = "Description";  // Column name for description
    public static final String CONTACT = "Contact";  // Column name for contact

    public PostDbHelper(Context context) {
        super(context, DBNAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL query to create the table
        String CREATE_USERS_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + " (" +
                "`" + ID + "INTEGER" + "` TEXT PRIMARY KEY AUTOINCREMENT, " +
                "`" + PET_NAME + "` TEXT, " +
                "`" + SPECIES + "` TEXT, " +
                "`" + AGE + "` TEXT, " +
                "`" + GENDER + "` TEXT, " +
                "`" + DESCRIPTION + "` TEXT, " +
                "`" + CONTACT + "` TEXT)";

        // Execute the create table query
        db.execSQL(CREATE_USERS_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String username, String PetName, String Species, String Age, String Gender, String Description, String Contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PET_NAME, PetName);
        values.put(SPECIES, Species);
        values.put(AGE, Age);
        values.put(GENDER, Gender);
        values.put(DESCRIPTION, Description);
        values.put(CONTACT, Contact);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, values);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Execute the query to retrieve all data from the table
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return result;
    }
}
