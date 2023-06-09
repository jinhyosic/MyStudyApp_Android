package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberList extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    TextView tvMemberList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        findViewById(R.id.btnBotList).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotDel).setOnClickListener(mClickListener);

        helper = new MySQLiteOpenHelper(
                MemberList.this, // 현재 화면의 context
                "member.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        tvMemberList = (TextView) findViewById(R.id.tvMemberList);

        //첫화면이 회원리스트라 한번 호출
        selectMemberList();
    }

    //하단 버튼 3개의 동작
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnBotList:
                    Intent intent1 = new Intent(MemberList.this, MemberList.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    selectMemberList();
                    startActivity(intent1);
                    break;
                case R.id.btnBotEdit:
                    Intent intent2 = new Intent(MemberList.this, MemberEdit.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    break;
                case R.id.btnBotDel:
                    Intent intent3 = new Intent(MemberList.this, MemberDel.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    break;
            }
        }
    };
    //데이터베이스에서 아이디를 검색하는 메서드
    public void selectMemberList() {
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.rawQuery("SELECT * FROM member", null);

        String Result = "";
        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String id = c.getString(1);
            String name = c.getString(3);
            String hp = c.getString(4);
            String addr = c.getString(5);

            Result += "  "+id+" | "+name+" | "+hp+" | "+addr+"\n";
        }
        tvMemberList.setText(Result);
        c.close();
        db.close();
    }
}