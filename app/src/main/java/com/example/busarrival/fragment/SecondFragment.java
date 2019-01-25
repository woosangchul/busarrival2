package com.example.busarrival.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.busarrival.ver2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends android.support.v4.app.Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(int position){
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("Position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_second, container, false);
    }

}
