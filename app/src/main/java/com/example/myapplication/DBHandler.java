package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import com.example.myapplication.model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "userdatabase";
    private static final int DB_VERSION = 4;
    private static final String TABLENAME = "users";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    Connection connection;


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLENAME + " (" + FIRSTNAME + " TEXT " + " , " + LASTNAME + " TEXT" + " , " + EMAIL + " TEXT " + " , " + PASSWORD + " TEXT " + " )";
        sqLiteDatabase.execSQL(query);
    }

    public List<User> getAllUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM "+ TABLENAME;
        Cursor cursor = db.rawQuery(query,null);
        List<User> userDetails = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {
                User user = new User();
                user.setFirstName(cursor.getString(0));
                user.setLastName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                userDetails.add(user);
            }while (cursor.moveToNext());
        }
        return userDetails;
    }
    public String getUserName() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "select " + FIRSTNAME + " from " + TABLENAME;
        String name = "";
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            name = cursor.getColumnName(0);
        }

        return name;
    }

    public void addUserSignUpPage(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRSTNAME, user.getFirstName());
        contentValues.put(LASTNAME, user.getLastName());
        contentValues.put(PASSWORD, user.getPassword());
        contentValues.put(EMAIL, user.getEmail());
        long value = db.insert(TABLENAME, null, contentValues);
        Log.e("db", "data has been inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(sqLiteDatabase);
    }
}
