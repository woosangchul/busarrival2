package com.example.busarrival.adaptor;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.busarrival.domain.ScheduleVO;
import com.example.busarrival.domain.TransportationNew;
import com.example.busarrival.ver2.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyRecyclerAdapter extends  RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{
    private final List<TransportationNew> mDataList;
    private final List<ViewHolder> holderList;
    private MyRecyclerViewClickListener mListener;

    public interface MyRecyclerViewClickListener{
        void onItemClicked(int position);
    }

    public void setOnClickListener(MyRecyclerViewClickListener listener){
        mListener = listener;
    }

    public MyRecyclerAdapter(List<TransportationNew> dataList) {
        mDataList = dataList;
        holderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card4, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int position = i;
        TransportationNew.calendar = Calendar.getInstance();
        viewHolder.setData(mDataList.get(position));
        if(mListener != null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(position);
                }
            });

        }



    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDepartText, textViewArriveText, textViewFirstBusArriveText,
                textViewNextBusArriveText, textViewFirstSubUpArriveText, textViewNextSubUpArriveText;
        TransportationNew itemlist;

        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDepartText = itemView.findViewById(R.id.textViewDepart); //출발지 텍스트뷰
            textViewArriveText = itemView.findViewById(R.id.textViewArrive); //도착지 텍스트뷰
            textViewFirstBusArriveText = itemView.findViewById(R.id.textViewFirstBusText); //지금 도착할 버스시간
            textViewNextBusArriveText = itemView.findViewById(R.id.textViewNextBusText); // 다음 도착
            textViewFirstSubUpArriveText = itemView.findViewById(R.id.textViewFirstSubUpText); // 지금 지하철
            textViewNextSubUpArriveText = itemView.findViewById(R.id.textViewNextSubUpText); // 다음 도착 지하철
            cardView = itemView.findViewById(R.id.cardView);
            cardView.bringToFront();
        }

        public void setData(TransportationNew item){
            ScheduleVO schduleText;
            this.itemlist = item;

            schduleText = itemlist.getSchedule();
            textViewDepartText.setText(item.getDepartText());
            textViewArriveText.setText(item.getArriveText());
            textViewFirstBusArriveText.setText(schduleText.getBusTimeFirstTypeTime());
            textViewNextBusArriveText.setText(schduleText.getBusTimeNextTypeTime());
            textViewFirstSubUpArriveText.setText(schduleText.getSubTimeFirstTypeTime());
            textViewNextSubUpArriveText.setText(schduleText.getSubTimeNextTypeTime());

        }
    }
}
