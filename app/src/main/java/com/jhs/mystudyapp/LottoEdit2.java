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
////////////값 제어 할차례
public class LottoEdit2 extends AppCompatActivity {

    boolean findRound = false;
    EditText etedit,et1 , et2, et3, et4, et5, et6, etb;
    TextView tv0;
    int round = 0; //db처리를 위한 변수
    //db
    LottoDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_edit2);

        etedit = (EditText) findViewById(R.id.etedit);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        etb = (EditText) findViewById(R.id.etb);

        tv0 = (TextView) findViewById(R.id.tv0);

        Button btn_find = (Button) findViewById(R.id.btn_find);
        Button btn_edit = (Button) findViewById(R.id.btn_edit);
        Button btn_main = (Button) findViewById(R.id.btn_main);

        dbHelper = new LottoDBHelper(LottoEdit2.this, 1);

        btn_main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1 = new Intent(LottoEdit2.this,LottoMain2.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
            }
        });

        btn_find.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int idx = 0; //db조회를 위한 변수

                if(etedit.getText().toString().equals("")){
                    Toast.makeText(LottoEdit2.this, "수정할 회차를 입력해야 합니다.", Toast.LENGTH_SHORT).show();
                    round = 0;
                    return;
                }

                SQLiteDatabase db = dbHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery(("SELECT * FROM testlotto2"),null);

                idx = Integer.parseInt(etedit.getText().toString());
                round = Integer.parseInt(etedit.getText().toString());
                while(cursor.moveToNext()){
                    if (idx ==0){
                        Toast.makeText(LottoEdit2.this, "해당 회차를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
                        tv0.setText(round+"회차를 찾을 수 없습니다.");
                        round = 0;
                    }
                    if(idx == cursor.getInt(0)){
                        Toast.makeText(LottoEdit2.this, "해당 회차를 찾았습니다.", Toast.LENGTH_SHORT).show();
                        tv0.setText("로또 제"+ cursor.getString(0)+"회차");
                        et1.setText(cursor.getString(1));
                        et2.setText(cursor.getString(2));
                        et3.setText(cursor.getString(3));
                        et4.setText(cursor.getString(4));
                        et5.setText(cursor.getString(5));
                        et6.setText(cursor.getString(6));
                        etb.setText(cursor.getString(7));
                        etedit.setText("");
                        findRound = true;
                    }
                }
                if(findRound == false){
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    etb.setText("");
                    etedit.setText("");
                    Toast.makeText(LottoEdit2.this, "해당 회차를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
                    tv0.setText(round+"회차를 찾을 수 없습니다.");
                    round = 0;
                }
                findRound = false;
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                if (et1.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et2.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et3.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et4.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et5.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et6.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (etb.getText().toString().equals("")) {
                    Toast.makeText(LottoEdit2.this, "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());
                int n3 = Integer.parseInt(et3.getText().toString());
                int n4 = Integer.parseInt(et4.getText().toString());
                int n5 = Integer.parseInt(et5.getText().toString());
                int n6 = Integer.parseInt(et6.getText().toString());
                int nb = Integer.parseInt(etb.getText().toString());

                if ((0 < n1 && 46 > n1) && (0 < n2 && 46 > n2) && (0 < n3 && 46 > n3) &&
                        (0 < n4 && 46 > n4) && (0 < n5 && 46 > n5) &&
                        (0 < n6 && 46 > n6) && (0 < nb && 46 > nb)) {

                    if (round == 0) {
                        Toast.makeText(LottoEdit2.this, "해당 회차를 수정 할 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else {
                        dbHelper.update(round, n1, n2, n3, n4, n5, n6, nb);
                        Toast.makeText(LottoEdit2.this, "로또 제 " + round + " 회차 데이터 수정 완료", Toast.LENGTH_SHORT).show();
                        round = 0;
                        etedit.setText("");
                    }
                }
                else
                    Toast.makeText(LottoEdit2.this,"로또 번호는 정수 1부터 45까지만 입력 받습니다.",Toast.LENGTH_SHORT).show();
            }
        });
    }


}