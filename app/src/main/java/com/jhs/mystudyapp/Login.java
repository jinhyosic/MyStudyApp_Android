package com.jhs.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText etId, etPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //id연동
        etId = (EditText) findViewById(R.id.etId);
        etPw = (EditText) findViewById(R.id.etPw);
        findViewById(R.id.btnLogin).setOnClickListener(mClickListener);
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
    }
    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnLogin:
                    dataTest1();
                    break;
                case R.id.btnJoin:
                    Intent intent1 = new Intent(Login.this, Join.class);
                    startActivity(intent1);
                    break;
            }
        }
    };
    void dataTest1()
    {
        String id = etId.getText().toString();
        String pw = etPw.getText().toString();

        Toast.makeText(Login.this,
                "아이디:"+id+" / 비번:"+pw,
                Toast.LENGTH_SHORT).show();
    }
    void dataTest2()
    {
        String id = etId.getText().toString();
        String pw = etPw.getText().toString();
        Log.d("로그인화면","아이디:"+id+" / 비번:"+pw);

    }


}