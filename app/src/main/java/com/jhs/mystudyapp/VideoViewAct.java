package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewAct extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = (VideoView)findViewById(R.id.videoView);

        Uri vurl= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pizzamove);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(vurl);

        findViewById(R.id.start).setOnClickListener(mClickListener);
        findViewById(R.id.sstop).setOnClickListener(mClickListener);
        findViewById(R.id.stop).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.start:
                    videoView.start();
                    break;
                case R.id.sstop:
                    videoView.pause();
                    break;
                case R.id.stop:
                    videoView.pause();
                    break;
            }
        }
    };
}