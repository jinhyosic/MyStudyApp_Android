package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemberJoinCheck extends AppCompatActivity {

    String djoinId, djoinPw, djoinName, djoinHp, djoinAddr;
    TextView joinId,joinPw, joinName, joinHp,joinAddr;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_check);

        //Intent로 전달받은 값 받기.
        Intent getData = getIntent();
        djoinId = getData.getStringExtra("id");
        djoinPw = getData.getStringExtra("pw");
        djoinName = getData.getStringExtra("name");
        djoinHp = getData.getStringExtra("hp");
        djoinAddr = getData.getStringExtra("addr");

        joinId = (TextView) findViewById(R.id.joinId);
        joinPw = (TextView) findViewById(R.id.joinPw);
        joinName = (TextView) findViewById(R.id.joinName);
        joinHp = (TextView) findViewById(R.id.joinHp);
        joinAddr = (TextView) findViewById(R.id.joinAddr);

        //가져온 데이타를 textview에 넣기
        joinId.setText(djoinId);
        joinPw.setText(djoinPw);
        joinName.setText(djoinName);
        joinHp.setText(djoinHp);
        joinAddr.setText(djoinAddr);

        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
              //  Intent intent = new Intent(MemberJoinCheck.this, MemberList.class);
            }
        });
    }
}