package com.example.busarrival.adaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.busarrival.ver2.R;

import java.util.ArrayList;

public class MyTransportationRecyclerAdapter extends RecyclerView.Adapter<MyTransportationRecyclerAdapter.ViewHolder> {
    private ArrayList<String> schedule;

    public MyTransportationRecyclerAdapter(ArrayList<String> schedule) {
        this.schedule = schedule;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_transportation,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(schedule.get(i));
    }

    @Override
    public int getItemCount() {
        return schedule.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text1);
        }


    }


}
