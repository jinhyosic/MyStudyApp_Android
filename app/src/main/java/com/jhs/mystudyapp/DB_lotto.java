package com.jhs.mystudyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DB_lotto extends SQLiteOpenHelper
{


    public DB_lotto(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        // SQLiteOpenHelper 가 최초 실행 되었을 때
        String sql = "create table if not exists testlotto ("+
                "idx integer primary key autoincrement, " +
                "num1 integer, " +
                "num2 integer, " +
                "num3 integer, " +
                "num4 integer, " +
                "num5 integer, " +
                "num6 integer, " +
                "numBonus integer);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists testlotto";
        db.execSQL(sql);
        onCreate(db); // 테이블을 지웠으므로 다시 테이블을 만들어주는 과정
    }
    public void insert(int n1,int n2,int n3,int n4,int n5,int n6,int nB){

        SQLiteDatabase db = getReadableDatabase(); //db객체 얻기(쓰기가능)

        ContentValues values = new ContentValues();

        values.put("num1", n1);
        values.put("num2", n2);
        values.put("num3", n3);
        values.put("num4", n4);
        values.put("num5", n5);
        values.put("num6", n6);
        values.put("numBonus", nB);
        db.insert("testlotto.db",null,values);


    }

}