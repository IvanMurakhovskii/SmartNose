package com.murik.smartnose.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.murik.smartnose.R;
import com.murik.smartnose.models.Time;
import com.murik.smartnose.recycleview.GenderViewHolder;
import com.murik.smartnose.recycleview.TimeViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class GenreAdapter extends ExpandableRecyclerViewAdapter<GenderViewHolder, TimeViewHolder>{

    private final GenreAdapter.OnItemClickListener listener;

    public GenreAdapter(List<? extends ExpandableGroup> groups, GenreAdapter.OnItemClickListener listener) {
        super(groups);
        this.listener = listener;


    }

    public interface OnItemClickListener { void onItemClick(Time time); }

    @Override
    public GenderViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gender_date, parent, false);
        return new GenderViewHolder(view);
    }

    @Override
    public TimeViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_time_layout, parent, false);
        return new TimeViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(TimeViewHolder holder, int flatPosition, final ExpandableGroup group, final int childIndex) {
        Time t = (Time) group.getItems().get(childIndex);
        holder.setTimeTitle(t.getTimeName());

        holder.binData(t, listener);

    }




    @Override
    public void onBindGroupViewHolder(GenderViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenderName(group.getTitle());
    }


}
