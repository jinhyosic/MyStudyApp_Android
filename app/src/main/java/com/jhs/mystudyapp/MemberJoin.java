package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MemberJoin extends AppCompatActivity {

    MySQLiteOpenHelper helper;

    String id,pw,name,hp,addr; //입력값을 변수에 저장해서 insert처리할변수

    Button btnJoin;
    EditText joinId, joinPw, joinHp, joinName, joinAddr;
    int viewNumber;

    String TAG ="회원가입 예제";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join);

        //데이베이스 생성.
        helper = new MySQLiteOpenHelper(
                MemberJoin.this, // 현재 화면의 context
                "member.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호


        btnJoin = (Button)findViewById(R.id.btnJoin);

        joinId = (EditText)findViewById(R.id.joinId);
        joinPw = (EditText)findViewById(R.id.joinPw);
        joinHp = (EditText)findViewById(R.id.joinHp);
        joinName = (EditText)findViewById(R.id.joinName);
        joinAddr = (EditText)findViewById(R.id.joinAddr);


        btnJoin.setOnClickListener(mClickListener);



    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnJoin:
                    //공백체크
                    if(joinId.getText().toString().equals(""))
                    {
                        Toast.makeText(MemberJoin.this, "아이디를 입력하세요.",  Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백없이 입력잘되었을경우 변수에 저장
                    id = joinId.getText().toString();

                    if(joinPw.getText().toString().equals(""))
                    {
                        Toast.makeText(MemberJoin.this, "비번을 입력하세요.",  Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백없이 입력잘되었을경우 변수에 저장
                    pw = joinPw.getText().toString();

                    if(joinName.getText().toString().equals(""))
                    {
                        Toast.makeText(MemberJoin.this, "이름을 입력하세요.",  Toast.LENGTH_SHORT).show();
                        break;
                    }
                    //공백없이 입력잘되었을경우 변수에 저장
                    name = joinName.getText().toString();

                    if(joinHp.getText().toString().equals(""))
                    {
                        Toast.makeText(MemberJoin.this, "연락처를 입력하세요.",  Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력잘되었을경우 변수에 저장
                    hp = joinHp.getText().toString();

                    if(joinAddr.getText().toString().equals(""))
                    {
                        Toast.makeText(MemberJoin.this, "주소를 입력하세요.",  Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //공백없이 입력잘되었을경우 변수에 저장
                    addr = joinAddr.getText().toString();

                    // 디비에 삽입..
                    insert(id, pw, name, hp, addr);

                    //회원가입 후 저장정보 확인하기.
                    Intent intentJoinOk = new Intent(MemberJoin.this, MemberJoinCheck.class);
                    intentJoinOk.putExtra("id", id);
                    intentJoinOk.putExtra("pw", pw);
                    intentJoinOk.putExtra("name", name);
                    intentJoinOk.putExtra("hp", hp);
                    intentJoinOk.putExtra("addr", addr);
                    startActivity(intentJoinOk);
                    finish();
                    break;
            }
        }
    };


    //데이타베이스 메서드 처리  ////////////////////////////
    public void insert(String id, String pw, String name, String hp, String addr) {

        SQLiteDatabase db = helper.getWritableDatabase(); // db 객체를 얻어온다. 쓰기 가능

        //값들을 컨트롤 하려고 클래스 생성
        ContentValues values = new ContentValues();

        // db.insert의 매개변수인 values가 ContentValues 변수이므로 그에 맞춤
        // 데이터의 삽입은 put을 이용한다.
        values.put("id", id);
        values.put("pw", pw);
        values.put("name", name);
        values.put("hp", hp);
        values.put("addr", addr);
        db.insert("member", null, values); // 테이블/널컬럼핵/데이터(널컬럼핵=디폴트)

        // tip : 마우스를 db.insert에 올려보면 매개변수가 어떤 것이 와야 하는지 알 수 있다.
        db.close();
        Toast.makeText(getApplicationContext(), id+"로 회원 가입 완료.", Toast.LENGTH_LONG).show();

        Log.d(TAG, id+"/"+pw+"/"+name+"/"+hp+"/"+addr+" 의 정보로 디비저장완료.");
    }
}