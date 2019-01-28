package com.example.busarrival.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.busarrival.adaptor.MyPagerAdapter;
import com.example.busarrival.ver2.MainActivity;
import com.example.busarrival.ver2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {
    ViewPager viewpager;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("1234", "thrid fragment destroy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("1234", "ThirdFragment OnCreateView 실행");
        View view =  inflater.inflate(R.layout.fragment_third, container, false);
        viewpager = view.findViewById(R.id.viewPager);
        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);

        TabLayout tablayout = (TabLayout)view.findViewById(R.id.tabLayout);
        tablayout.addTab(tablayout.newTab().setCustomView(createTabView(R.drawable.school_bus, "Bus")));
        tablayout.addTab(tablayout.newTab().setCustomView(createTabView(R.drawable.metro, "Subway")));

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public View createTabView(int icon, String tabName){
        View view = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.item_tab,null);
        ImageView image = (ImageView)view.findViewById(R.id.imageViewIcon);
        TextView text = (TextView)view.findViewById(R.id.textViewText);

        image.setImageResource(icon);
        text.setText(tabName);
        return view;
    }

}
