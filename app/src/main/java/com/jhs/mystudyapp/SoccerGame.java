package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

public class SoccerGame extends AppCompatActivity {
    ImageView iv;
    int shootN = 10; //슛기회

    //1은 골, 0는 실패
    int[] mShootArr= {1,0,1,0,1,0,1,0,1,0};
    int[] pShootArr= {1,1,1,1,0,1,1,1,1,1};
    int[] hShootArr= {1,0,0,1,0,0,0,0,1,0};
    int result;

    int randIndex = (int)(Math.random()*9);
    int total = 0;
    int goal = 0;
    int fail = 0;

    TextView tvShootN, tvResult,tvTotal,tvGoal,tvFail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soccer_game);
        iv = (ImageView)findViewById(R.id.iv);
        tvShootN = (TextView) findViewById(R.id.tvShootN);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvGoal = (TextView) findViewById(R.id.tvGoal);
        tvFail = (TextView) findViewById(R.id.tvFail);

        tvShootN.setText(shootN+"");
        tvTotal.setText(goal+"");
        tvFail.setText(fail+"");
        findViewById(R.id.mShoot).setOnClickListener(mClickListener);
        findViewById(R.id.pShoot).setOnClickListener(mClickListener);
        findViewById(R.id.hShoot).setOnClickListener(mClickListener);
        findViewById(R.id.restart).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mShoot:
                    if(shootN >= 2) {
                        total++;
                        tvTotal.setText(total + "");
                        shootN -= 2;
                        tvShootN.setText(shootN + "");
                        randIndex = (int)(Math.random()*9);
                        result = mShootArr[randIndex];
                        if(result == 1) {
                            goal++;
                            tvGoal.setText(goal+"");
                            Glide.with(SoccerGame.this).load(R.drawable.middleshoot).into(iv);
                            tvResult.setText("GOAL~!!!");
                            break;
                        }
                        else if(result == 0){
                            fail++;
                            tvFail.setText(fail+"");
                            Glide.with(SoccerGame.this).load(R.drawable.shootfail).into(iv);
                            tvResult.setText("FAIL~!");
                            break;
                        }
                    }
                    else {
                        Toast.makeText(SoccerGame.this, "도전불가능.(기회 부족)", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.pShoot:
                    if(shootN >= 3) {
                        total++;
                        tvTotal.setText(total + "");
                        shootN -= 3;
                        tvShootN.setText(shootN + "");
                        randIndex = (int)(Math.random()*9);
                        result = pShootArr[randIndex];
                        if(result == 1) {
                            goal++;
                            tvGoal.setText(goal+"");
                            Glide.with(SoccerGame.this).load(R.drawable.psh).into(iv);
                            tvResult.setText("GOAL~!!!");
                            break;
                        }
                        else if(result == 0){
                            fail++;
                            tvFail.setText(fail+"");
                            Glide.with(SoccerGame.this).load(R.drawable.ptshootf).into(iv);
                            tvResult.setText("FAIL~!");
                            break;
                        }
                    }
                    else {
                        Toast.makeText(SoccerGame.this, "도전불가능.(기회 부족)", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    break;
                case R.id.hShoot:
                    if(shootN >= 1) {
                        total++;
                        tvTotal.setText(total + "");
                        shootN -= 1;
                        tvShootN.setText(shootN + "");
                        randIndex = (int)(Math.random()*9);
                        result = hShootArr[randIndex];
                        if(result == 1) {
                            goal++;
                            tvGoal.setText(goal+"");
                            Glide.with(SoccerGame.this).load(R.drawable.hhh).into(iv);
                            tvResult.setText("GOAL~!!!");
                            break;
                        }
                        else if(result == 0){
                            fail++;
                            tvFail.setText(fail+"");
                            Glide.with(SoccerGame.this).load(R.drawable.pshootfail).into(iv);
                            tvResult.setText("FAIL~!");
                            break;
                        }
                    }
                    else {
                        Toast.makeText(SoccerGame.this, "도전불가능.(기회 부족)", Toast.LENGTH_SHORT).show();
                        break;
                    }
                case R.id.restart:
                        shootN = 10;
                        tvShootN.setText(shootN+"");
                        tvResult.setText("대기중..");
                        total = 0;
                        tvTotal.setText(total+"");
                        goal = 0;
                        tvGoal.setText(goal+"");
                        fail = 0;
                        tvFail.setText(fail+"");
                        Glide.with(SoccerGame.this).load(R.drawable.andro).into(iv);
                        Toast.makeText(SoccerGame.this, "새 게임", Toast.LENGTH_SHORT).show();
                        break;
            }
        }
    };
}