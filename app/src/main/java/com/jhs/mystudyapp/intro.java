package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class intro extends AppCompatActivity {

    ImageView introLogo;
    Animation ani1,ani2,ani3,ani5,ani6;

    TextView tvLogo,tvLogo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introLogo = (ImageView) findViewById(R.id.introLogo);
        tvLogo = (TextView)findViewById(R.id.tvLogo);
        tvLogo2 = (TextView)findViewById(R.id.tvLogo2);

        ani1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.alpha2);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.mainlogo);
        ani5 = AnimationUtils.loadAnimation(this, R.anim.mainlogo2);
        introLogo.startAnimation(ani1);
        tvLogo.startAnimation(ani3);
        tvLogo2.startAnimation(ani5);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                introLogo.startAnimation(ani2);
            }
        },3000);

        Handler handlerStart = new Handler();
        handlerStart.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainStart = new Intent(intro.this,MainActivity.class);
                startActivity(mainStart);
            }
        },9000);
    }
}