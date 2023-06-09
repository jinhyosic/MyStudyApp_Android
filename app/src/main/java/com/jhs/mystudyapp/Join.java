package com.jhs.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Join extends AppCompatActivity {

    Button btnJoin;
    EditText joinId, joinPw, joinName, joinHp;
    TextView tvSex,spLocal;
    Switch swt;

    Spinner sp;

    String local;
    String[] items = {"서울","대전","대구","부산","청주","충주","강원"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        btnJoin = (Button) findViewById(R.id.btnJoin);


        joinId = (EditText)findViewById(R.id.joinId);
        joinPw = (EditText)findViewById(R.id.joinPw);
        joinName = (EditText)findViewById(R.id.joinName);
        joinHp = (EditText)findViewById(R.id.joinHp);

        sp = (Spinner)findViewById(R.id.sp);
       // spLocal = (TextView)findViewById(R.id.spLocal);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 스피너에 어댑터 설정
        sp.setAdapter(adapter);

        // 스피너에서 선택 했을 경우 이벤트 처리
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                local = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                local = "서울";
            }
        });

        swt = (Switch) findViewById(R.id.sw);
        tvSex = (TextView)findViewById(R.id.tvSex);
        swt.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvSex.setText("여자");
                } else {
                    tvSex.setText("남자");
                }
            }
        });
        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
                    String getId = joinId.getText().toString();
                    String getPw = joinPw.getText().toString();
                    String getName = joinName.getText().toString();
                    String getHp = joinHp.getText().toString();
                    String getSex = tvSex.getText().toString();

                    Intent intent1 = new Intent(Join.this, Join2.class);
                    intent1.putExtra("id",getId);
                    intent1.putExtra("pw",getPw);
                    intent1.putExtra("name",getName);
                    intent1.putExtra("hp",getHp);
                    intent1.putExtra("sex",getSex);
                    intent1.putExtra("local",local);
                    startActivity(intent1);

        }
    };

}