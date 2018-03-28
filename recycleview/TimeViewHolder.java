package com.murik.smartnose.recycleview;

import android.view.View;
import android.widget.TextView;

import com.murik.smartnose.R;
import com.murik.smartnose.adapters.GenreAdapter;
import com.murik.smartnose.models.Time;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;


public class TimeViewHolder extends ChildViewHolder {

    private TextView timeTitle;

    public TimeViewHolder(View itemView) {
        super(itemView);
        timeTitle = itemView.findViewById(R.id.tvTime);
    }

    public void binData(final Time items, final GenreAdapter.OnItemClickListener listener)
    { timeTitle.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { listener.onItemClick(items); } }); }

    public void setTimeTitle(String time){
        timeTitle.setText(time);
    }


}
