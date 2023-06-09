package com.jhs.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Datat extends AppCompatActivity {

    public static String id,hp;
    EditText stid,sthp,tdid,tdhp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datat);

        stid = (EditText) findViewById(R.id.stid);
        sthp = (EditText) findViewById(R.id.sthp);
        tdid = (EditText) findViewById(R.id.tdid);
        tdhp = (EditText) findViewById(R.id.tdhp);

        findViewById(R.id.btnst).setOnClickListener(mClickListener);
        findViewById(R.id.btntd).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnst:
                    id = stid.getText().toString();
                    hp = sthp.getText().toString();

                    stid.setText("");
                    sthp.setText("");
                    Toast.makeText(Datat.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btntd:
                    String getId = tdid.getText().toString();
                    String getHp = tdhp.getText().toString();
                    Intent intent1 = new Intent(Datat.this, Datat2.class);
                    intent1.putExtra("id",getId);
                    intent1.putExtra("hp",getHp);
                    startActivity(intent1);
                    break;
            }
        }
    };
}