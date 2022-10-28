package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper{


    public DBHelper(Context context){
        super(context,"registration",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(id INTEGER primary key AUTOINCREMENT , name TEXT, email TEXT,country TEXT,gender TEXT, username TEXT , password TEXT )");
//    SQLiteDatabase database=this.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop table if exists users");
    }

    public Boolean insertData(String name, String email,String gender,String country,  String username,String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("country",country);
        contentValues.put("gender",gender);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = myDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;

    }


      public Boolean checkusername(String username){

        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor;
        cursor = myDB.rawQuery("select * from users where username =? and password = ?",new String[]{ username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    }

