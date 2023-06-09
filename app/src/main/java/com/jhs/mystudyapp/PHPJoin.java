//package com.jhs.mystudyapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.Volley;
//import com.google.android.gms.common.api.Response;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class PHPJoin extends AppCompatActivity {
//
//    EditText joinId,joinPw,joinName,joinHp;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phpjoin);
//
//        joinId = (EditText) findViewById(R.id.joinId);
//        joinPw = (EditText) findViewById(R.id.joinPw);
//        joinName = (EditText) findViewById(R.id.joinName);
//        joinHp = (EditText) findViewById(R.id.joinHp);
//
//
//        findViewById(R.id.btnCheck).setOnClickListener(mClickListener);
//        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
//    }
//    View.OnClickListener mClickListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btnCheck:
//
//                    break;
//                case R.id.btnJoin:
//                    String id = joinId.getText().toString();
//                    String pw = joinPw.getText().toString();
//                    String name = joinName.getText().toString();
//                    String hp = joinHp.getText().toString();
//
//                    join(id,pw,name,hp);
//
//                    break;
//            }
//        }
//    };
//
//    void join(String id, String pw, String name, String hp){
//        Response.Listener<String> responseListener = new Response.Listener<String>()
//        {
//            @Override
//            public void onResponse(String response) {
//                try {
//
//                    JSONObject jsonObject = new JSONObject(response);
//                    boolean success = jsonObject.getBoolean("success");
//                    Log.d("로그인체크","로그인성공:"+ success);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        PHPServerRequestJoin getUserCharLevelStat = new PHPServerRequestJoin(id, pw, name, hp, responseListener);
//        RequestQueue queue = Volley.newRequestQueue(PHPJoin.this);
//        queue.add(getUserCharLevelStat);
//    }
//
//
//}