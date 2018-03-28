package com.murik.smartnose.recycleview;


import android.view.View;
import android.widget.TextView;

import com.murik.smartnose.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class GenderViewHolder extends GroupViewHolder{

    private TextView genderTitle;

    public GenderViewHolder(View itemView) {
        super(itemView);
        genderTitle = itemView.findViewById(R.id.tvGenderDate);
    }

    public void setGenderName(String name){
        genderTitle.setText(name);
    }

}
