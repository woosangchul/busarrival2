package com.example.busarrival.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.busarrival.Listener.FragmentSelectedListener;
import com.example.busarrival.domain.ScheduleVO;
import com.example.busarrival.domain.TransportationNew;
import com.example.busarrival.ver2.MainActivity;
import com.example.busarrival.ver2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends android.support.v4.app.Fragment implements  View.OnClickListener{

    FragmentSelectedListener mListener;

    public void setOnSecondFragmentSelectedListener(FragmentSelectedListener listener){
        mListener = listener;
    }


    TransportationNew transportation;
    ScheduleVO schduleText;
    Button buttonSchedule;
    TextView textViewDepartText, textViewFirstBusArriveText, textViewNextBusArriveText, textViewFirstSubArriveText, textViewNextSubArriveText;
    ImageView imageViewLeftArrow, imageViewRightArrow;

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

        if(getArguments() != null){
            transportation = ((MainActivity)getActivity()).getDataList(getArguments().getInt("Position"));
        }
        View view =  inflater.inflate(R.layout.fragment_second, container, false);
        textViewDepartText = view.findViewById(R.id.textViewDepartFrag2);
        textViewFirstBusArriveText = view.findViewById(R.id.textViewFirstBusTextFrag2);
        textViewNextBusArriveText = view.findViewById(R.id.textViewNextBusTextFrag2);
        textViewFirstSubArriveText = view.findViewById(R.id.textViewFirstSubTextFrag2);
        textViewNextSubArriveText = view.findViewById(R.id.textViewNextSubTextFrag2);
        imageViewLeftArrow = view.findViewById(R.id.imageviewLeftArrow);
        imageViewRightArrow = view.findViewById(R.id.imageviewRightArrow);
        buttonSchedule = view.findViewById(R.id.buttonSchedule);


        schduleText = transportation.getSchedule();
        textViewDepartText.setText(transportation.getDepartText());
        textViewFirstBusArriveText.setText(schduleText.getBusTimeFirstTypeTime());
        textViewNextBusArriveText.setText(schduleText.getBusTimeNextTypeTime());
        textViewFirstSubArriveText.setText(schduleText.getSubTimeFirstTypeTime());
        textViewNextSubArriveText.setText(schduleText.getSubTimeNextTypeTime());

        imageViewLeftArrow.setOnClickListener(this);
        imageViewRightArrow.setOnClickListener(this);
        buttonSchedule.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageviewLeftArrow:
                schduleText = transportation.getPrevButton(schduleText);
                textViewFirstBusArriveText.setText(schduleText.getBusTimeFirstTypeTime());
                textViewNextBusArriveText.setText(schduleText.getBusTimeNextTypeTime());
                textViewFirstSubArriveText.setText(schduleText.getSubTimeFirstTypeTime());
                textViewNextSubArriveText.setText(schduleText.getSubTimeNextTypeTime());
                break;
            case R.id.imageviewRightArrow:
                schduleText = transportation.getNextButton(schduleText);
                textViewFirstBusArriveText.setText(schduleText.getBusTimeFirstTypeTime());
                textViewNextBusArriveText.setText(schduleText.getBusTimeNextTypeTime());
                textViewFirstSubArriveText.setText(schduleText.getSubTimeFirstTypeTime());
                textViewNextSubArriveText.setText(schduleText.getSubTimeNextTypeTime());
                break;

            case R.id.buttonSchedule:
                if(mListener != null){
                    mListener.onSecondFragmentSelected(getArguments().getInt("Position"));
                }
                break;

        }
    }
}
