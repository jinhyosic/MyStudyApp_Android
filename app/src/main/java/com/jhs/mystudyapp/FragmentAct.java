package com.jhs.mystudyapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentAct extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private AFragment fragmentA;
    private BFragment fragmentB;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentManager = getSupportFragmentManager();

        fragmentA = new AFragment();
        fragmentB = new BFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();

        findViewById(R.id.btn_fragmentA).setOnClickListener(mClick);
        findViewById(R.id.btn_fragmentB).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            transaction = fragmentManager.beginTransaction();

            switch(v.getId())
            {
                case R.id.btn_fragmentA:
                    transaction.replace(R.id.frameLayout, fragmentA).commitAllowingStateLoss();
                    System.out.println("a버튼");
                    break;
                case R.id.btn_fragmentB:
                    transaction.replace(R.id.frameLayout, fragmentB).commitAllowingStateLoss();
                    System.out.println("b버튼");
                    break;
            }

        }
    };


}