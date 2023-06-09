package com.jhs.mystudyapp;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LottoDBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "testlotto2.db";

    public LottoDBHelper(Context context, int version){
        super(context, DB_NAME, null, version);
    }

    //테이블생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE testLotto2(" +
                "`idx` INTEGER PRIMARY KEY AUTOINCREMENT," +
                " `n1` text ," +
                " `n2` text ," +
                " `n3` text ," +
                " `n4` text ," +
                " `n5` text ," +
                " `n6` text ," +
                " `nb` text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS testLotto2");
        onCreate(db);
    }
    //INSERT문 메서드
    public void insert(int n1,int n2,int n3,int n4,int n5,int n6,int nb){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO testlotto2(n1,n2,n3,n4,n5,n6,nb) VALUES('" + n1 + "','" + n2 + "','" + n3 + "','" + n4 + "', '" + n5 + "'," + n6 + ",'" + nb + "')");
    }

    public void delete(int idx){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM testLotto2 WHERE (idx = '" + idx + "');");
    }

    public void update(int idx, int n1,int n2,int n3,int n4,int n5,int n6,int nb){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE testLotto2 SET n1 ='"+ n1 +"', n2 ='"+ n2 +"', n3 ='"+ n3 +"',n4 ='"+ n4 +"',n5 ='"+ n5 +"',n6 ='"+ n6 +"', nb ='"+nb+"' WHERE (idx = '"+idx+"')");
    }

}
