package com.murik.smartnose.recycleview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.murik.smartnose.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static final String COLUMN_DATE = "date";
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.rec_text_date);
        }
    }

    public MyAdapter(ArrayList<String> date){
        this.date = date;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.rec_view_item, parent, false);
       ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(date.get(position));

    }

    @Override
    public int getItemCount() {
        return date.size();
    }


}
