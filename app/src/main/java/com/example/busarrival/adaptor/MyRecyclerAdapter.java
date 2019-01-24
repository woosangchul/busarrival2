package com.example.busarrival.adaptor;


import android.support.annotation.NonNull;
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

    public MyRecyclerAdapter(List<TransportationNew> dataList) {
        mDataList = dataList;
        holderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TransportationNew.calendar = Calendar.getInstance();
        viewHolder.setData(mDataList.get(i));

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDepartText, textViewArriveText, textViewFirstBusArriveText,
                textViewNextBusArriveText, textViewFirstSubArriveText, textViewNextSubArriveText;
        TransportationNew itemlist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDepartText = itemView.findViewById(R.id.textViewDepart); //출발지 텍스트뷰
            textViewArriveText = itemView.findViewById(R.id.textViewArrive); //도착지 텍스트뷰
            textViewFirstBusArriveText = itemView.findViewById(R.id.textViewFirstBusText); //지금 도착할 버스시간
            textViewNextBusArriveText = itemView.findViewById(R.id.textViewNextBusText); // 다음 도착
            textViewFirstSubArriveText = itemView.findViewById(R.id.textViewFirstSubText); // 지금 지하철
            textViewNextSubArriveText = itemView.findViewById(R.id.textViewNextSubText); // 다음 도착 지하철
        }

        public void setData(TransportationNew item){
            ScheduleVO schduleText;
            this.itemlist = item;

            schduleText = itemlist.getSchedule();

            textViewFirstBusArriveText.setText(schduleText.getBusTimeFirstTypeMiute());
            textViewNextBusArriveText.setText(schduleText.getBusTimeNextTypeMiute());
            textViewFirstSubArriveText.setText(schduleText.getSubTimeFirstTypeMiute());
            textViewNextSubArriveText.setText(schduleText.getSubTimeNextTypeMiute());

        }
    }
}
