package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemberDel extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    EditText findId;
    TextView tvDel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_del);

        helper = new MySQLiteOpenHelper(
                MemberDel.this, // 현재 화면의 context
                "member.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        findId =(EditText) findViewById(R.id.findId);
        tvDel = (TextView) findViewById(R.id.tvDel);

        findViewById(R.id.btnFind).setOnClickListener(mClickListener);
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotList).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnBotDel).setOnClickListener(mClickListener);

    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFind:
                    String delId = findId.getText().toString();
                    if(delId.equals(""))
                    {
                        Toast.makeText(MemberDel.this, "삭제할 아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    searchDelId(delId);
                    break;
                case R.id.btnDel:
                    String delIdOk = findId.getText().toString();
                    if(delIdOk.equals(""))
                    {
                        Toast.makeText(MemberDel.this, "삭제할 아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    delete(delIdOk);
                    break;
                case R.id.btnBotList:
                    Intent intent1 = new Intent(MemberDel.this, MemberList.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                    break;
                case R.id.btnBotEdit:
                    Intent intent2 = new Intent(MemberDel.this, MemberEdit.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    break;
                case R.id.btnBotDel:
                    Intent intent3 = new Intent(MemberDel.this, MemberDel.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    break;
            }
        }
    };

    public void delete(String delId) {
        db = helper.getWritableDatabase();
        db.delete("member", "id='" + delId + "'", null);

        Toast.makeText(getApplicationContext(), delId + "의 정보가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
        db.close();

        //삭제후처리
        findId.setText("");
        tvDel.setText("[ 대상이 삭제되었습니다. ]");
    }

    public void searchDelId(String delId) {
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.rawQuery("SELECT * FROM member where id = '" + delId + "'", null);

        String Result = "";
        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String id = c.getString(1);
            //String pw = c.getString(2);
            String name = c.getString(3);
            String hp = c.getString(4);
            String addr = c.getString(5);

            Result += id + " | " + name + " | " + hp + " | " + addr;

        }
        tvDel.setText(Result);
        c.close();
        db.close();
    }
}