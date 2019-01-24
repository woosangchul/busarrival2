package com.example.busarrival.ver2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class adapter {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewDepartText, textViewArriveText, textViewFirstBusArriveText,
                textViewNextBusArriveText, textViewFirstSubArriveText, textViewNextSubArriveText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDepartText = itemView.findViewById(R.id.textview)
        }
    }
}
