package com.jhs.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class LottoSelect extends Fragment {

    EditText num1, num2, num3,num4,num5,num6,numBonus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_lotto_select,container,false);

        num1 = (EditText) view.findViewById(R.id.num1);
        num2 = (EditText) view.findViewById(R.id.num2);
        num3 = (EditText) view.findViewById(R.id.num3);
        num4 = (EditText) view.findViewById(R.id.num4);
        num5 = (EditText) view.findViewById(R.id.num5);
        num6 = (EditText) view.findViewById(R.id.num6);
        numBonus = (EditText) view.findViewById(R.id.numBonus);

        Button btn_select = (Button) view.findViewById(R.id.btn_select);
        Button btn_main = (Button) view.findViewById(R.id.btn_main);

        btn_select.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

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

}