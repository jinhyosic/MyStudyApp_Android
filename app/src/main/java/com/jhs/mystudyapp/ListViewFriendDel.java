package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewFriendDel extends AppCompatActivity {

    SQLiteDatabase db;
    FriendManagerSQLHelper helper;

    TextView tvHp,tvSex,tvAddr,tvAge;
    EditText etName;
    Button btnDel, btnFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_fr_del);

        helper = new FriendManagerSQLHelper(
                ListViewFriendDel.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        etName = (EditText) findViewById(R.id.etName);

        tvAddr = (TextView) findViewById(R.id.tvAddr);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvHp = (TextView) findViewById(R.id.tvHp);
        tvSex = (TextView) findViewById(R.id.tvSex);

        btnFind = (Button) findViewById(R.id.btnFind);
        btnDel = (Button) findViewById(R.id.btnDel);

        btnFind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                String findName = etName.getText().toString();

                if(findName.equals(""))
                {
                    Toast.makeText(ListViewFriendDel.this,"이름을 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }

                // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
                db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
                Cursor c = db.rawQuery("SELECT * FROM friend where name='"+etName.getText()+"'", null);

                while (c.moveToNext()) {
                    int idx = c.getInt(0);
                    String name = c.getString(1);
                    String hp = c.getString(2);
                    String sex = c.getString(3);
                    String addr = c.getString(4);
                    String age = c.getString(5);

                    etName.setText(name);
                    tvHp.setText(hp);
                    tvSex.setText(sex);
                    tvAddr.setText(addr);
                    tvAge.setText(age);

                }
            }

        });

        btnDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {

                String findName = etName.getText().toString();

                if(findName.equals(""))
                {
                    Toast.makeText(ListViewFriendDel.this,"이름을 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }

                //db값 삭제
                db=helper.getWritableDatabase();
                db.delete("friend","name='"+findName+"'",null);

                Toast.makeText(getApplicationContext(), findName+"님의 정보가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                db.close();

                //삭제후처리
                etName.setText("");
                tvHp.setText("");
                tvSex.setText("");
                tvAddr.setText("");
                tvAge.setText("");

                //메인에 있는 리스트뷰에 변화가 생겨서 갱신.
             //   ManagerFriend.adapter.notifyDataSetChanged();

                Toast.makeText(ListViewFriendDel.this,"삭제완료!",Toast.LENGTH_SHORT).show();
                ManagerFriend.selectFriendsList();
            }
        });
    }
}