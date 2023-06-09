package com.jhs.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Datat2 extends AppCompatActivity {
    TextView stid,sthp,tdid,tdhp;
    Button btnst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datat2);

        stid = (TextView) findViewById(R.id.stid);
        sthp = (TextView) findViewById(R.id.sthp);
        tdid = (TextView) findViewById(R.id.tdid);
        tdhp = (TextView) findViewById(R.id.tdhp);
        btnst = (Button) findViewById(R.id.btnst);
        //전달받은 데이터 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String hp = getData.getStringExtra("hp");
        tdid.setText(id);
        tdhp.setText(hp);

        //onCreate()메서드 안해서 단독형으로 클릭이벤트처리 (스테틱변수가져오기)
        btnst.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                stid.setText(Datat.id);
                sthp.setText(Datat.hp);
            }
        });
    }
}