package com.jhs.mystudyapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class LottoInsert extends Fragment {

    SQLiteDatabase db;
    DB_lotto db_lotto;

    int db1,db2,db3,db4,db5,db6,dbBonus;

    EditText num1, num2, num3,num4,num5,num6,numBonus;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_lotto_insert,container,false);

        db_lotto = new DB_lotto(
                getActivity(),
                "testlotto.db",
                null,
                1
        );

        num1 = (EditText) view.findViewById(R.id.num1);
        num2 = (EditText) view.findViewById(R.id.num2);
        num3 = (EditText) view.findViewById(R.id.num3);
        num4 = (EditText) view.findViewById(R.id.num4);
        num5 = (EditText) view.findViewById(R.id.num5);
        num6 = (EditText) view.findViewById(R.id.num6);
        numBonus = (EditText) view.findViewById(R.id.numBonus);

        Button btn_insert = (Button) view.findViewById(R.id.btn_insert);
        Button btn_main = (Button) view.findViewById(R.id.btn_main);


        btn_insert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                if (num1.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num2.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num3.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num4.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num5.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num6.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (numBonus.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "공백이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //공백 없을 시 db로 전달할 변수에 숫자 저장
                db1 = Integer.parseInt(num1.getText().toString());
                db2 = Integer.parseInt(num2.getText().toString());
                db3 = Integer.parseInt(num3.getText().toString());
                db4 = Integer.parseInt(num4.getText().toString());
                db5 = Integer.parseInt(num5.getText().toString());
                db6 = Integer.parseInt(num6.getText().toString());
                dbBonus = Integer.parseInt(numBonus.getText().toString());

                //모든 값이 1부터 45까지의 수만 입력됨
                if ((0 < db1 && 46 > db1) && (0 < db2 && 46 > db2) && (0 < db3 && 46 > db3) &&
                        (0 < db4 && 46 > db4) && (0 < db5 && 46 > db5) &&
                        (0 < db6 && 46 > db6) && (0 < dbBonus && 46 > dbBonus)) {
                    //db생성

                    db_lotto.insert(db1, db2, db3, db4, db5, db6, dbBonus);
                    Toast.makeText(getActivity(),"당첨번호 갱신완료",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"로또는 정수 1부터 45까지만  입력 받습니다.",Toast.LENGTH_LONG).show();
            }
        });

        btn_main.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), LottoMain.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        return view;
    }



    //현재 db 연동 불가

}