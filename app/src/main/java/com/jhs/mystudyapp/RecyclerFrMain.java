package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RecyclerFrMain extends AppCompatActivity implements RecyclerFrAdapter.MyRecyclerViewClickListener{

    RecyclerView recyclerView;

    ArrayList<RecyclerFrItemData> frList = new ArrayList<>();

    final RecyclerFrAdapter adapter = new RecyclerFrAdapter(frList);
    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycelr_fr_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 20; i++){
            frList.add(new RecyclerFrItemData("testName["+i+"]","testAge["+i+"]","testSex["+i+"]"));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정



       // RecyclerFrAdapter customAdapter = new RecyclerFrAdapter(adapter);
        recyclerView.setAdapter(adapter); // 어댑터 설정
        adapter.setOnClickListener(this);

        findViewById(R.id.btnAdd).setOnClickListener(mClickListener);
        findViewById(R.id.btnEdit).setOnClickListener(mClickListener);
        findViewById(R.id.btnDel).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAdd:
                    Intent intent1 = new Intent(RecyclerFrMain.this, RecyclerFrAdd.class );
                    startActivity(intent1);
                    break;
                case R.id.btnEdit:
                  //  Intent intent2 = new Intent(ManagerFriend.this, ListViewFriendEdit.class );
                   // startActivity(intent2);
                    break;
                case R.id.btnDel:
                 //   Intent intent3 = new Intent(ManagerFriend.this, ListViewFriendDel.class );
                  //  startActivity(intent3);
                    break;
            }
        }
    };


    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onTitleClicked(int position) {

    }

    @Override
    public void onContentClicked(int position) {

    }

    @Override
    public void onItemLongClicked(int position) {

    }

    @Override
    public void onImageViewClicked(int position) {

    }
}