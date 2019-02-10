package com.example.busarrival.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.busarrival.adaptor.MyTransportationRecyclerAdapter;
import com.example.busarrival.ver2.MainActivity;
import com.example.busarrival.ver2.MyItemDecoration;
import com.example.busarrival.ver2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubwayFragment extends Fragment {
    RecyclerView recycler;
    MyTransportationRecyclerAdapter adapter;
    MyItemDecoration itemDeco;
    public SubwayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subway, container, false);
        itemDeco = new MyItemDecoration(((MainActivity)getActivity()).bus2camToJiSchedule);
        recycler = view.findViewById(R.id.recyclerViewSub);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyTransportationRecyclerAdapter(((MainActivity)getActivity()).bus2camToJiSchedule);
        recycler.setAdapter(adapter);
        recycler.addItemDecoration(itemDeco);
        return view;
    }

}
