package com.jhs.mystudyapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Anime extends AppCompatActivity {

    ImageView imgV;
    Animation ani1, ani2, ani3, ani4, ani5, ani6, ani7, ani8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        imgV = (ImageView)findViewById(R.id.imgV);

        ani1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.translate);
        ani4 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        ani5 = AnimationUtils.loadAnimation(this, R.anim.set);
        ani6 = AnimationUtils.loadAnimation(this, R.anim.dynamic);
        ani7 = AnimationUtils.loadAnimation(this, R.anim.dynamic);
        ani8 = AnimationUtils.loadAnimation(this, R.anim.cust);

        findViewById(R.id.btnA1).setOnClickListener(mClickListener);
        findViewById(R.id.btnA2).setOnClickListener(mClickListener);
        findViewById(R.id.btnA3).setOnClickListener(mClickListener);
        findViewById(R.id.btnA4).setOnClickListener(mClickListener);
        findViewById(R.id.btnA5).setOnClickListener(mClickListener);
        findViewById(R.id.btnA6).setOnClickListener(mClickListener);
        findViewById(R.id.btnA7).setOnClickListener(mClickListener);
        findViewById(R.id.btnA8).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnA1:
                    imgV.startAnimation(ani1);
                    break;
                case R.id.btnA2:
                    imgV.startAnimation(ani2);
                    break;
                case R.id.btnA3:
                    imgV.startAnimation(ani3);
                    break;
                case R.id.btnA4:
                    imgV.startAnimation(ani4);
                    break;
                case R.id.btnA5:
                    imgV.startAnimation(ani5);
                    break;
                case R.id.btnA6:
                    imgV.setImageResource(R.drawable.star);
                    imgV.startAnimation(ani6);
                    break;
                case R.id.btnA7:
                    imgV.setImageResource(R.drawable.chang);
                    imgV.startAnimation(ani7);
                    break;
                case R.id.btnA8:
                    imgV.setImageResource(R.drawable.star);
                    imgV.startAnimation(ani8);
                    break;
            }
        }
    };
}