package com.example.basicbankingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyHelper extends SQLiteOpenHelper
{
private static final String dbname="Customers";
private static  final int version=1;

    public MyHelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE  CUSTOMERS (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,ACCOUNT_BALANCE REAL)";

        sqLiteDatabase.execSQL(sql);

        insertData("Tejbir Singh","ks.singh7888@gmail.com",70000,sqLiteDatabase);
        insertData("Vikas Gupta","vi4vikas@gmail.com",70000,sqLiteDatabase);
        insertData("Gurvijay ","gurvijay123@gmail.com",60000,sqLiteDatabase);
        insertData("Rohan","rohan123@gmail.com",61000,sqLiteDatabase);
        insertData("Prerna","prerna456@gmail.com",63000,sqLiteDatabase);
        insertData("akash","akash56@gmail.com",68000,sqLiteDatabase);
        insertData("yogesh","yogeash1234@gmail.com",60000,sqLiteDatabase);

    }


    private void insertData(String name,String email,long balance,SQLiteDatabase database){
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("EMAIL",email);
        values.put("ACCOUNT_BALANCE",balance);
        database.insert("CUSTOMERS",null,values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
    public boolean ontransferAmt(String recievername, String updatedAmt){
      SQLiteDatabase database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("ACCOUNT_BALANCE",updatedAmt);
        database.update("CUSTOMERS",values,"NAME=?",new String[]{recievername});
      return  true;
    }

}
