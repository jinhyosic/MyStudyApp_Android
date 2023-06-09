package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GifAct extends AppCompatActivity {

    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        imgV = (ImageView)findViewById(R.id.imgV);

        findViewById(R.id.btn1).setOnClickListener(mClickListener);
        findViewById(R.id.btn2).setOnClickListener(mClickListener);
        findViewById(R.id.btn3).setOnClickListener(mClickListener);


    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    Glide.with(GifAct.this).load(R.drawable.pizzacreate).into(imgV);
                    break;
                case R.id.btn2:
                    Glide.with(GifAct.this).load(R.drawable.pizzaeating).into(imgV);
                    break;
                case R.id.btn3:
                    Glide.with(GifAct.this).load(R.drawable.pizza).into(imgV);
                    break;
            }
        }
    };
}