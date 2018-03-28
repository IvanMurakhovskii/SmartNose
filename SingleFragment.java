package com.murik.smartnose;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.murik.smartnose.adapters.GenreAdapter;
import com.murik.smartnose.database.DBHelper;
import com.murik.smartnose.models.DateGroup;
import com.murik.smartnose.models.Time;

import java.util.List;

public class SingleFragment extends Fragment{

    private RecyclerView mRecycleView;
    private GenreAdapter mAdapter;
    private List<DateGroup> date;
    private RecyclerView.LayoutManager mLayoutManager;

    private DBHelper db;

       public static TextView tvText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v;
       v  = inflater.inflate(R.layout.fr_recycler_view, null);
       db = new DBHelper(getActivity());
       mRecycleView = v.findViewById(R.id.recycler_view);
       date = db.getDateSession();
       mAdapter = new GenreAdapter(date, new GenreAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(Time time) {

               Bundle bundle = new Bundle();
               bundle.putLong("millis", time.getDateMillis());
               getActivity().getSupportFragmentManager()
                       .beginTransaction().addToBackStack(null)
                       .replace(R.id.container, RadarChartFragment.newInstance(bundle))
                       .addToBackStack(null)
                       .commit();
           }
       });

       mLayoutManager = new LinearLayoutManager(getContext());
       mRecycleView.setLayoutManager(mLayoutManager);
       mRecycleView.setAdapter(mAdapter);




        return v;

    }





}
