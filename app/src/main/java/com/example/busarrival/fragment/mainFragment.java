package com.example.busarrival.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.busarrival.ver2.R;

import java.net.InterfaceAddress;


/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragment extends Fragment {
    private OnMainFragmentSelectedListener mListener;

    interface OnMainFragmentSelectedListener{
        void onMainFragmentSelected();
    }

    public void setOnMainFragmentSeletedListener(OnMainFragmentSelectedListener listener){
        mListener = listener;
    }


    LinearLayout layout;
    public mainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        layout = (LinearLayout)view.findViewById(R.id.linearLayoutMainLayout);



        layout.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("1234","Asdg");
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("1234","if문 바ㄸㄲ");
                        if(mListener != null){
                            Log.d("1234","if문 내부");
                            mListener.onMainFragmentSelected();
                        }
                        break;
                    default :
                        return false;
                }

                return true;
            }
        });

        return view;
    }



}
