package com.example.busarrival.ver2;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.busarrival.domain.TransportationNew;

import java.util.ArrayList;

public class MyItemDecoration extends RecyclerView.ItemDecoration{
    private ArrayList<String> schedule;

    public MyItemDecoration(ArrayList<String> schedule) {
        this.schedule = schedule;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if(position != 0){
            if(Integer.parseInt(schedule.get(position -1).substring(0,2)) != Integer.parseInt(schedule.get(position).substring(0,2))){
                outRect.set(0,10,0,0);


            }
        }
    }


}
