package com.jhs.mystudyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class WebViewAct extends AppCompatActivity {


    EditText etAddr;

    WebView wv;

    String[] urlItems = {"네이버", "다음", "유튜브", "구글"};
    //urlItems의 실제 url주소가 들어가는곳
    String[] urlGo = {
            "http://naver.com","http://daum.net",
            "http://youtube.co.kr","http://google.co.kr"
    };
    int urlIdx=0; //스피너 선택 포지션
    TextView tvSitePick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        etAddr = (EditText) findViewById(R.id.etAddr);
        tvSitePick = (TextView) findViewById(R.id.tvSitePick);
        wv = (WebView) findViewById(R.id.wv);

        //웹뷰 옵션 설정하기. ==========================================
        wv.setWebViewClient(new WebViewClient());  // 새 창 띄우기 않기
        wv.setWebChromeClient(new WebChromeClient());

        wv.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용여부
        wv.loadUrl("https://naver.com");

        //웹뷰 ==========================================
        //스피너 처리...............////////////////////////
        Spinner spBestAddr = (Spinner) findViewById(R.id.spBestAddr);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, urlItems
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 스피너에 어댑터 설정
        spBestAddr.setAdapter(adapter);
        // 스피너에서 선택 했을 경우 이벤트 처리
        spBestAddr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSitePick.setText(urlItems[position]);
                urlIdx = position;//선택한 url의 idx값 넣기...
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvSitePick.setText("미선택..");
            }
        });
        //스피너 처리...............////////////////////////

        //버튼이벤트
        findViewById(R.id.btnAddrMove).setOnClickListener(mClickListener);
        findViewById(R.id.btnBAddrMove).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAddrMove:
                    String url = etAddr.getText().toString();
                    wv.loadUrl("https://"+url);
                    break;
                case R.id.btnBAddrMove:
                    wv.loadUrl(urlGo[urlIdx]);
                    break;
            }
        }
    };
}