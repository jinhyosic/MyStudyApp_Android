package com.jhs.mystudyapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter{


    public int mCount;

    public ViewPagerAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new ViewpagerFragment1();
        else if(index==1) return new ViewpagerFragment2();
        else if(index==2) return new ViewpagerFragment3();
        else return new ViewpagerFragment4();
    }

    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) { return position % mCount; }

}
