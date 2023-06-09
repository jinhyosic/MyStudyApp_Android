//package com.jhs.mystudyapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class PHPLogin extends AppCompatActivity {
//
//    EditText etId, etPw;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phplogin);
//
//        etId = (EditText) findViewById(R.id.etId);
//        etPw = (EditText) findViewById(R.id.etPw);
//
//        findViewById(R.id.btnLogin).setOnClickListener(mClickListener);
//        findViewById(R.id.btnJoin).setOnClickListener(mClickListener);
//
//    }
//    View.OnClickListener mClickListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btnLogin:
//                    String id = etId.getText().toString();
//                    String pw = etPw.getText().toString();
//                    login(id,pw);
//                    break;
//                case R.id.btnJoin:
//                    Intent intent1 = new Intent(PHPLogin.this, PHPJoin.class);
//                    startActivity(intent1);
//                    break;
//            }
//        }
//    };
//    void login(String id,String pw)
//    {
//        Log.d("로그인성공","22 id:"+ id);
//        Response.Listener<String> responseListener = new Response.Listener<String>()
//        {
//            @Override
//            public void onResponse(String response) {
//                try {
//
//                    ///333333333333333333333333333333
//                    JSONObject jsonObject = new JSONObject(response);
//                    boolean success = jsonObject.getBoolean("success");
//                    String id = jsonObject.getString("id");
//                    String name = jsonObject.getString("name");
//                    String hp = jsonObject.getString("hp");
//                    Log.d("로그인성공","success:"+ success);
//                    Log.d("로그인성공","name:"+ name);
//                    Log.d("로그인성공","hp:"+ hp);
//
//                    if(success) {
//                        Intent intentMain = new Intent(PHPLogin.this, PHPmain.class);
//                        startActivity(intentMain);
//                    }
//                    else {
//                        Toast.makeText(PHPLogin.this,"로그인실패!아이디/비번확인해주세요!",Toast.LENGTH_SHORT).show();
//                        Log.d("로그인실패","로그인 실패 아이디 비번 확인하시오!");
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        ///111111111111111111111111111111111111111111111
//        PHPServerRequestLogin getUserCharLevelStat = new PHPServerRequestLogin(id, pw, responseListener);
//        RequestQueue queue = Volley.newRequestQueue(PHPLogin.this);
//        queue.add(getUserCharLevelStat);
//
//    }
//
//}