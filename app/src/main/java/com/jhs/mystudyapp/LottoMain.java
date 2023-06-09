package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class LottoMain extends AppCompatActivity {

    private FragmentManager fragmentManager;

    SQLiteDatabase db;
    DB_lotto db_lotto;
    private LottoInsert lottoInsert;
    private LottoSelect lottoSelect;

    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_main);

        db_lotto = new DB_lotto(
                LottoMain.this, // 현재 화면의 context
                "testlotto.db", // 파일명
                null, // 커서 팩토리
                1); // 버전 번호

        fragmentManager = getSupportFragmentManager();

        lottoInsert = new LottoInsert();
        lottoSelect = new LottoSelect();

        transaction = fragmentManager.beginTransaction();

        findViewById(R.id.btn_select).setOnClickListener(mClick);
        findViewById(R.id.btn_insert).setOnClickListener(mClick);

    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            transaction = fragmentManager.beginTransaction();

            switch(v.getId())
            {
                case R.id.btn_select:
                    transaction.replace(R.id.frameLayout1, lottoSelect).commitAllowingStateLoss();
                    break;
                case R.id.btn_insert:
                    transaction.replace(R.id.frameLayout1, lottoInsert).commitAllowingStateLoss();
                    break;
            }

        }
    };
}