package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(mClickListener);
        findViewById(R.id.button2).setOnClickListener(mClickListener);
        findViewById(R.id.button3).setOnClickListener(mClickListener);
        findViewById(R.id.button4).setOnClickListener(mClickListener);
        findViewById(R.id.button5).setOnClickListener(mClickListener);
        findViewById(R.id.button6).setOnClickListener(mClickListener);
        findViewById(R.id.button7).setOnClickListener(mClickListener);
        findViewById(R.id.button8).setOnClickListener(mClickListener);
        findViewById(R.id.button9).setOnClickListener(mClickListener);
        findViewById(R.id.button10).setOnClickListener(mClickListener);
        findViewById(R.id.button11).setOnClickListener(mClickListener);
        findViewById(R.id.button12).setOnClickListener(mClickListener);
        findViewById(R.id.button13).setOnClickListener(mClickListener);
        findViewById(R.id.button14).setOnClickListener(mClickListener);
        findViewById(R.id.button15).setOnClickListener(mClickListener);
        findViewById(R.id.button16).setOnClickListener(mClickListener);
        findViewById(R.id.button17).setOnClickListener(mClickListener);
        findViewById(R.id.button18).setOnClickListener(mClickListener);
        findViewById(R.id.button19).setOnClickListener(mClickListener);
        findViewById(R.id.button20).setOnClickListener(mClickListener);
        findViewById(R.id.button21).setOnClickListener(mClickListener);
        findViewById(R.id.button22).setOnClickListener(mClickListener);
        findViewById(R.id.button23).setOnClickListener(mClickListener);
        findViewById(R.id.button24).setOnClickListener(mClickListener);
        findViewById(R.id.button25).setOnClickListener(mClickListener);
        findViewById(R.id.button26).setOnClickListener(mClickListener);
        findViewById(R.id.button27).setOnClickListener(mClickListener);

    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Intent intent1 =
                            new Intent(MainActivity.this, Stlayout.class);
                    startActivity(intent1);
                    break;
                case R.id.button2:
                    Intent intent2 =
                            new Intent(MainActivity.this, Login.class);
                    startActivity(intent2);
                    break;
                case R.id.button3:
                    Intent intent3 =
                            new Intent(MainActivity.this, Anime.class);
                    startActivity(intent3);
                    break;
                case R.id.button4:
                    Intent intent4 =
                            new Intent(MainActivity.this, GifAct.class);
                    startActivity(intent4);
                    break;
                case R.id.button5:
                    Intent intent5 =
                            new Intent(MainActivity.this, Datat.class);
                    startActivity(intent5);
                    break;
                case R.id.button6:
                    Intent intent6 =
                            new Intent(MainActivity.this, WebViewAct.class);
                    startActivity(intent6);
                    break;
                case R.id.button7:
                    Intent intent7 =
                            new Intent(MainActivity.this, VideoViewAct.class);
                    startActivity(intent7);
                    break;
                case R.id.button8:
                    Intent intent8 =
                            new Intent(MainActivity.this, MediaAct.class);
                    startActivity(intent8);
                    break;
                case R.id.button9:
                    Intent intent9 =
                            new Intent(MainActivity.this, GalleryAct.class);
                    startActivity(intent9);
                    break;
                case R.id.button10:
                    Intent intent10 =
                            new Intent(MainActivity.this, SoccerGame.class);
                    startActivity(intent10);
                    break;
                case R.id.button11:
                    Intent intent11 =
                            new Intent(MainActivity.this, HandlerAct.class);
                    startActivity(intent11);
                    break;
                case R.id.button12:
                    Intent intent12 =
                            new Intent(MainActivity.this, PreferencesAct.class);
                    startActivity(intent12);
                    break;
                case R.id.button13:
                    Intent intent13 =
                            new Intent(MainActivity.this, calcul.class);
                    startActivity(intent13);
                    break;
                case R.id.button14:
                    Intent intent14 =
                            new Intent(MainActivity.this, FrameLayoutAct.class);
                    startActivity(intent14);
                    break;
                case R.id.button15:
                    Intent intent15 =
                            new Intent(MainActivity.this, PhoneNumberAct.class);
                    startActivity(intent15);
                    break;
                case R.id.button16:
                    Intent intent16 =
                            new Intent(MainActivity.this, ListViewAct.class);
                    startActivity(intent16);
                    break;
                case R.id.button17:
                    Intent intent17 =
                            new Intent(MainActivity.this, PhoneNumberAct.class);
                    startActivity(intent17);
                    break;
                case R.id.button18:
                    Intent intent18 =
                            new Intent(MainActivity.this, ManagerFriend.class);
                    startActivity(intent18);
                    break;
                case R.id.button19:
                    Intent intent19 =
                            new Intent(MainActivity.this, GpsTrackerAct.class);
                    startActivity(intent19);
                    break;
                case R.id.button20:
                    Intent intent20 =
                            new Intent(MainActivity.this, CalendarAct.class);
                    startActivity(intent20);
                    break;
                case R.id.button21:
                    Intent intent21 =
                            new Intent(MainActivity.this, TimerAct.class);
                    startActivity(intent21);
                    break;
                case R.id.button22:
                    Intent intent22 =
                            new Intent(MainActivity.this, MemberMain.class);
                    startActivity(intent22);
                    break;
                case R.id.button23:
                    Intent intent23 =
                            new Intent(MainActivity.this, RecyclerFrMain.class);
                    startActivity(intent23);
                    break;
                case R.id.button24:
                    Intent intent24 =
                            new Intent(MainActivity.this, Ex28RecyclerViewFriends.class);
                    startActivity(intent24);
                    break;
                case R.id.button25:
                    Intent intent25 =
                            new Intent(MainActivity.this, FragmentAct.class);
                    startActivity(intent25);
                    break;
                case R.id.button26:
                    Intent intent26 =
                            new Intent(MainActivity.this, LottoMain2.class);
                    startActivity(intent26);
                    break;
                case R.id.button27:
                    Intent intent27 =
                            new Intent(MainActivity.this, Ex32webPhpLogin.class);
                    startActivity(intent27);
                    break;
            }
        }
    };

}