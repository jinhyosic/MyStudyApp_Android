package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemberEdit extends AppCompatActivity {
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    EditText editId,editPw,editName,editHp,editAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_edit);

        helper = new MySQLiteOpenHelper(
                MemberEdit.this, // 현재 화면의 context
                "member.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        editId = (EditText) findViewById(R.id.editId);
        editPw = (EditText) findViewById(R.id.editPw);
        editName = (EditText) findViewById(R.id.editName);
        editHp = (EditText) findViewById(R.id.editHp);
        editAddr = (EditText) findViewById(R.id.editAddr);

        findViewById(R.id.btnFind).setOnClickListener(mClickListener);
        findViewById(R.id.btnEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotList).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotDel).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFind:
                    String editId1 = editId.getText().toString();
                    if(editId1.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    searchEditId(editId1);

                    break;

                case R.id.btnEdit:
                    String id = editId.getText().toString();
                    String pw = editPw.getText().toString();
                    String name = editName.getText().toString();
                    String hp = editHp.getText().toString();
                    String addr = editAddr.getText().toString();
                    if(id.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(pw.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 패스워드를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(name.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(hp.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 연락처를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(addr.equals(""))
                    {
                        Toast.makeText(MemberEdit.this, "수정할 주소를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    update(id,pw,name,hp,addr);

                    break;
                case R.id.btnBotList:
                    Intent intent1 = new Intent(MemberEdit.this, MemberList.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                    break;
                case R.id.btnBotEdit:
                    Intent intent2 = new Intent(MemberEdit.this, MemberEdit.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    break;
                case R.id.btnBotDel:
                    Intent intent3 = new Intent(MemberEdit.this, MemberDel.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    break;
            }
        }
    };

    // 수정 아이디 찾기
    public void searchEditId(String editId1) {

        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.rawQuery("SELECT * FROM member where id='"+editId1+"'", null);

        String Result = "";
        boolean check=false;
        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String id = c.getString(1);
            String pw = c.getString(2);
            String name = c.getString(3);
            String hp = c.getString(4);
            String addr = c.getString(5);

            editId.setText(id);
            editPw.setText(pw);
            editName.setText(name);
            editHp.setText(hp);
            editAddr.setText(addr);
            check=true;
        }
        if(check==false)
        {
            editPw.setText("");
            editName.setText("");
            editHp.setText("");
            editAddr.setText("");
            Toast.makeText(MemberEdit.this, "찾는 대상이없습니다!", Toast.LENGTH_SHORT).show();
        }
        c.close();
        db.close();
    }

    public void update(String editId1,String pw,String name, String hp, String addr) {
        db = helper.getWritableDatabase(); //db 객체를 얻어온다. 쓰기가능

        ContentValues values = new ContentValues();
        values.put("pw", pw);
        values.put("name", name);
        values.put("hp", hp);
        values.put("addr", addr);
        db.update("member", values, "id='"+editId1+"'", null);

        db.close();
        Toast.makeText(getApplicationContext(), editId1+"의 정보가 수정되었습니다.", Toast.LENGTH_SHORT).show();
        //수정완료후 초기화

        editId.setText("");
        editPw.setText("");
        editName.setText("");
        editHp.setText("");
        editAddr.setText("");
    }

}