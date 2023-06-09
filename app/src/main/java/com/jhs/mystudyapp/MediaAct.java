package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MediaAct extends AppCompatActivity {

    TextView tvState, tvTitle;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        tvState = (TextView)findViewById(R.id.tvState);
        tvTitle = (TextView)findViewById(R.id.tvTitle);

        mp = MediaPlayer.create(MediaAct.this, R.raw.bells);

        findViewById(R.id.play).setOnClickListener(mClickListener);
        findViewById(R.id.sstop).setOnClickListener(mClickListener);
        findViewById(R.id.stop).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.play:
                    mp = MediaPlayer.create(MediaAct.this, R.raw.bells);
                    mp.start();
                    tvState.setText("음악 재생");
                    break;
                case R.id.sstop:
                    mp.pause();
                    tvState.setText("음악 일시정지 중");
                    break;
                case R.id.stop:
                    mp.stop();
                    tvState.setText("음악 중지");
                    break;
            }
        }
    };
}