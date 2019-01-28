package com.example.busarrival.adaptor;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.busarrival.fragment.BusFragment;
import com.example.busarrival.fragment.SubwayFragment;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mData;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        Log.d("1234", "my pageradqpter 생성자 실행");
        mData = new ArrayList<>();
        mData.add(new BusFragment());
        mData.add(new SubwayFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return mData.get(i);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return position + "번째";
    }
}
