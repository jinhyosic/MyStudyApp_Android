package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Join2 extends AppCompatActivity {

    TextView joinId,joinPw,joinName,joinHp,joinSex,joinLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        joinId = (TextView) findViewById(R.id.joinId);
        joinPw = (TextView) findViewById(R.id.joinPw);
        joinName = (TextView) findViewById(R.id.joinName);
        joinHp = (TextView) findViewById(R.id.joinHp);
        joinSex = (TextView)findViewById(R.id.joinSex);
        joinLocal = (TextView)findViewById(R.id.joinLocal);


        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String pw = getData.getStringExtra("pw");
        String name = getData.getStringExtra("name");
        String hp = getData.getStringExtra("hp");
        String sex = getData.getStringExtra("sex");
        String local =getData.getStringExtra("local");

        joinId.setText(id);
        joinPw.setText(pw);
        joinName.setText(name);
        joinHp.setText(hp);
        joinSex.setText(sex);
        joinLocal.setText(local);

    }
}