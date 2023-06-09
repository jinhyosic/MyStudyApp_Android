package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ManagerFriend extends AppCompatActivity {

    public static ListView listView;
    public static ListViewFrAdapter adapter = null;

    static SQLiteDatabase db;
    static DB_lotto helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_friend);
        //사용자정의 함수
       // mInitData(); //mList 객체 생성및 데이터 넣기
       // mInitAdapterView(); //리스트뷰와 어댑터를 연결

        helper = new DB_lotto(
                ManagerFriend.this, // 현재 화면의 context
                "friend.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호


        //리스트뷰 id연동
        listView = (ListView)findViewById(R.id.listView);
        //버튼이벤트처리
        findViewById(R.id.btnAdd).setOnClickListener(mClickListener);
        findViewById(R.id.btnEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);

        //초기화면처리 리스트뷰
        adapter = new ListViewFrAdapter();
        selectFriendsList();

    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Intent intent1 = new Intent(ManagerFriend.this, ListViewFriendAdd.class );
                    startActivity(intent1);
                    break;
                case R.id.btnEdit:
                    Intent intent2 = new Intent(ManagerFriend.this, ListViewFriendEdit.class );
                    startActivity(intent2);
                    break;
                case R.id.btnDel:
                    Intent intent3 = new Intent(ManagerFriend.this, ListViewFriendDel.class );
                    startActivity(intent3);
                    break;
            }
        }
    };

    static void addData(String name, String hp, String addr, String sex, int age){
        if("".equals(name)||"".equals(hp)||"".equals(addr)||"".equals(sex)||"".equals(age)){
            System.out.println("공백발생");
        }
        else {
            adapter.addItem(new ListViewFrItem(name, hp, sex, addr, age));
            listView.setAdapter(adapter);
        }
    }

    static void selectFriendsList() {
        //화면 초기화
      adapter.items.clear();
        // 1) db의 데이터를 읽어와서, 2) 결과 저장, 3)해당 데이터를 꺼내 사용
        db = helper.getReadableDatabase(); // db객체를 얻어온다. 읽기 전용
        Cursor c = db.rawQuery("SELECT * FROM friend", null);

        while (c.moveToNext()) {
            int idx = c.getInt(0);
            String name = c.getString(1);
            String hp = c.getString(2);
            String sex = c.getString(3);
            String addr = c.getString(4);
            String age = c.getString(5);

            int dbAge = Integer.parseInt(age);

            //DB에서 어댑터로 데이터를 뿌림
            adapter.addItem(new ListViewFrItem(name, hp, sex, addr, dbAge));

        }
       // c.close();
       // db.close();
        listView.setAdapter(adapter);
    }
}