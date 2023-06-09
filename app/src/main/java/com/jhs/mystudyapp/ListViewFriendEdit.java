package com.jhs.mystudyapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewFriendEdit extends AppCompatActivity {

    SQLiteDatabase db;
    FriendManagerSQLHelper helper;
    Switch swSex;
    TextView tvSex;
    EditText etName, etHp, etAddr, etAge;

    Button btnEdit, btnFind;
    //값을 전달할 변수들
    String sendId, sendPw, sendName, sendHp,selectSex="남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_fr_edit);

        helper = new FriendManagerSQLHelper(
                ListViewFriendEdit.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        etName = (EditText) findViewById(R.id.etName);
        etHp = (EditText) findViewById(R.id.etHp);
        etAddr = (EditText) findViewById(R.id.etAddr);
        etAge = (EditText) findViewById(R.id.etAge);

        swSex = (Switch) findViewById(R.id.swSex);
        tvSex = (TextView) findViewById(R.id.tvSex);
        swSex.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    tvSex.setText("여자");
                    selectSex ="여자";
                } else {
                    tvSex.setText("남자");
                    selectSex = "남자";
                }
            }
        });

        btnFind = (Button) findViewById(R.id.btnFind);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        btnFind.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String findName = etName.getText().toString();
                if(findName.equals(""))
                {
                    Toast.makeText(ListViewFriendEdit.this,"이름을 입력하시오.",Toast.LENGTH_SHORT).show();
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
                    etHp.setText(hp);
                    tvSex.setText(sex);
                    etAddr.setText(addr);
                    etAge.setText(age);

                    if ("남자".equals(sex)) {
                        swSex.setChecked(false);
                    }
                    else {
                        swSex.setChecked(true);
                    }
                }
            }
    });

        btnEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String findName = etName.getText().toString();
                String name = etName.getText().toString();
                String hp = etHp.getText().toString();
                String addr = etAddr.getText().toString();

                if(name.equals("")){
                    Toast.makeText(ListViewFriendEdit.this,"이름을 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(hp.equals("")){
                    Toast.makeText(ListViewFriendEdit.this,"연락처를 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(addr.equals("")){
                    Toast.makeText(ListViewFriendEdit.this,"주소를 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(etAge.getText().toString().equals("")){
                    Toast.makeText(ListViewFriendEdit.this,"나이를 입력하시오.",Toast.LENGTH_SHORT).show();
                    return;
                }
                //공백체크 완료 후 나이는 숫자로 변환하여 age에 저장
                int age = Integer.parseInt(etAge.getText().toString());

                db = helper.getWritableDatabase(); //db 객체를 얻어온다. 쓰기가능

                ContentValues values = new ContentValues();
                values.put("name", etName.getText().toString());
                values.put("hp", etHp.getText().toString());
                values.put("sex", selectSex);
                values.put("addr", etAddr.getText().toString());
                values.put("age", etAge.getText().toString());
                db.update("friend", values, "name='"+etName.getText().toString()+"'", null);

                db.close();
                Toast.makeText(getApplicationContext(), etName.getText().toString()+"의 정보가 수정되었습니다.", Toast.LENGTH_SHORT).show();

                etName.setText("");
                etHp.setText("");
                etAddr.setText("");
                etAge.setText("");

                Toast.makeText(ListViewFriendEdit.this,"수정완료",Toast.LENGTH_SHORT).show();
                //메인에 있는 리스트뷰에 변화가 생겨서 갱신.
                ManagerFriend.selectFriendsList();
            }
        });
    }
}