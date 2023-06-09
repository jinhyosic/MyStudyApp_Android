package com.jhs.mystudyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class calcul extends AppCompatActivity {
TextView tvResult;
    boolean mid = false; //앞의 피연산자 입력받기
    boolean h = false;
    int[] number = new int[20]; //입력받을 피연산자들의 배열

    int n1;
    int n2;
    int yon; //연산자
    int result = 0;


    String fN = "";
    String bN = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);

        tvResult = (TextView) findViewById(R.id.tvResult);

        findViewById(R.id.btn1).setOnClickListener(mClickListener);
        findViewById(R.id.btn2).setOnClickListener(mClickListener);
        findViewById(R.id.btn3).setOnClickListener(mClickListener);
        findViewById(R.id.btn4).setOnClickListener(mClickListener);
        findViewById(R.id.btn5).setOnClickListener(mClickListener);
        findViewById(R.id.btn6).setOnClickListener(mClickListener);
        findViewById(R.id.btn7).setOnClickListener(mClickListener);
        findViewById(R.id.btn8).setOnClickListener(mClickListener);
        findViewById(R.id.btn9).setOnClickListener(mClickListener);
        findViewById(R.id.btn0).setOnClickListener(mClickListener);
        findViewById(R.id.btnSum).setOnClickListener(mClickListener);
        findViewById(R.id.btnMin).setOnClickListener(mClickListener);
        findViewById(R.id.btnMul).setOnClickListener(mClickListener);
        findViewById(R.id.btnDiv).setOnClickListener(mClickListener);
        findViewById(R.id.btnC).setOnClickListener(mClickListener);
        findViewById(R.id.btnResult).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn1: tvResult.setText(tvResult.getText()+"1");
                    if(mid == false) {
                        fN += "1";
                    }
                    else if(mid == true) {
                        bN += "1";
                    }
                    break;
                case R.id.btn2: tvResult.setText(tvResult.getText()+"2");
                    if(mid == false) {
                        fN += "2";
                    }
                    else if(mid == true) {
                        bN += "2";
                    }
                    break;
                case R.id.btn3: tvResult.setText(tvResult.getText()+"3");
                    if(mid == false) {
                        fN += "3";
                    }
                    else if(mid == true) {
                        bN += "3";
                    }
                    break;
                case R.id.btn4: tvResult.setText(tvResult.getText()+"4");
                    if(mid == false) {
                        fN += "4";
                    }
                    else if(mid == true) {
                        bN += "4";
                    }
                    break;
                case R.id.btn5: tvResult.setText(tvResult.getText()+"5");
                    if(mid == false) {
                        fN += "5";
                    }
                    else if(mid == true) {
                        bN += "5";
                    }
                    break;
                case R.id.btn6: tvResult.setText(tvResult.getText()+"6");
                    if(mid == false) {
                        fN += "6";
                    }
                    else if(mid == true) {
                        bN += "6";
                    }
                    break;
                case R.id.btn7: tvResult.setText(tvResult.getText()+"7");
                    if(mid == false) {
                        fN += "7";
                    }
                    else if(mid == true) {
                        bN += "7";
                    }
                    break;
                case R.id.btn8: tvResult.setText(tvResult.getText()+"8");
                    if(mid == false) {
                        fN += "8";
                    }
                    else if(mid == true) {
                        bN += "8";
                    }
                    break;
                case R.id.btn9: tvResult.setText(tvResult.getText()+"9");
                    if(mid == false) {
                        fN += "9";
                    }
                    else if(mid == true) {
                        bN += "9";
                    }
                    break;
                case R.id.btn0: tvResult.setText(tvResult.getText()+"0");
                    if(mid == false) {
                        fN += "0";
                    }
                    else if(mid == true) {
                        bN += "0";
                    }
                    break;
                case R.id.btnSum:
                    tvResult.setText(tvResult.getText()+"+");
                    mid = true; //뒤에 오는 피연산자 입력모드 전환
                    yon = 1;

                    break;
                case R.id.btnMin:
                    tvResult.setText(tvResult.getText()+"-");
                    mid = true;
                    yon = 2;

                    break;
                case R.id.btnMul:
                    tvResult.setText(tvResult.getText()+"*");
                    mid = true;
                    yon = 3;

                    break;
                case R.id.btnDiv:
                    tvResult.setText(tvResult.getText()+"/");
                    mid = true;
                    yon = 4;

                    break;
                case R.id.btnC:
                    tvResult.setText("");
                    mid = false;
                    fN = "";
                    bN = "";
                    n1 = 0;
                    n2 = 0;
                    yon = 0;
                    break;
                case R.id.btnResult:
                    n1 = Integer.parseInt(fN);
                    n2 = Integer.parseInt(bN);
                    func(n1, n2, yon);
                    tvResult.setText(func(n1, n2, yon) + "");
                    n1 = 0;
                    n2 = 0;
                    break;
            }
        }
    };

    int func (int x, int y, int g){
        if(g == 1) {
            result = x + y;
        }
        if(g == 2) {
            result = x - y;
        }
        if(g == 3) {
            result = x * y;
        }
        if(g == 4) {
            try {
                result = x / y; //나눗셈 예외처리
            } catch(ArithmeticException e) {
                Toast.makeText(calcul.this, "0으로 나눌수없습니다.", Toast.LENGTH_LONG).show();;
            }
        }
        return result;
    }
}