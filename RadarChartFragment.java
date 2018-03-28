package com.murik.smartnose;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.murik.smartnose.database.DBHelper;

import java.util.ArrayList;

public class RadarChartFragment extends android.support.v4.app.Fragment implements RadioGroup.OnCheckedChangeListener{


    com.github.mikephil.charting.charts.RadarChart radarChart;
    RadioGroup rg;
    DBHelper DB;


    public static RadarChartFragment newInstance(Bundle args) {

        RadarChartFragment fragment = new RadarChartFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_radar_chart, null);
        DB = new DBHelper(getActivity());

        radarChart = v.findViewById(R.id.radarChart);
        rg = (RadioGroup)v.findViewById(R.id.rg_radar);
        rg.setOnCheckedChangeListener(this);

        ArrayList<String> lable = new ArrayList<>();

        lable.add("1");
        lable.add("2");
        lable.add("3");
        lable.add("4");
        lable.add("5");
        lable.add("6");
        lable.add("7");
        lable.add("8");


        ArrayList<Integer> entries = new ArrayList<>();
        entries.add(8);
        entries.add(1);
        entries.add(9);
        entries.add(8);
        entries.add(3);
        entries.add(7);
        entries.add(10);
        entries.add(3);
        entries.add(15);
        entries.add(12);
        entries.add(4);
        entries.add(10);
        entries.add(15);
        entries.add(5);
        entries.add(35);
        entries.add(19);
        entries.add(9);
        entries.add(20);
        entries.add(8);
        entries.add(2);
        entries.add(17);
        entries.add(10);
        entries.add(5);
        entries.add(10);
        entries.add(5);
        entries.add(1);
        entries.add(8);
        entries.add(6);
        entries.add(2);
        entries.add(5);
        entries.add(1);
        entries.add(-1);
        entries.add(-6);
        entries.add(1);
        entries.add(-2);
        entries.add(-3);

        ArrayList<Entry> ent = new ArrayList<>();
        ArrayList<String> lable2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < entries.size(); i++){

            ent.add(new Entry(entries.get(i),i));
            lable2.add(String.valueOf(i));
        }



        ArrayList<Entry> ent2 = new ArrayList<>();
        ent2.add(new Entry(1,0));
        ent2.add(new Entry(2,1));
        ent2.add(new Entry(3,2));
        ent2.add(new Entry(4,3));



        RadarDataSet dataset_1 = new RadarDataSet(ent, "Sensor");
        dataset_1.setColor(Color.GREEN);
        dataset_1.setDrawFilled(true);


        RadarData data = new RadarData(lable2, dataset_1);
        XAxis x = radarChart.getXAxis();
        x.setDrawLabels(false);
        radarChart.getRadius();
        radarChart.setData(data);
        radarChart.invalidate();


        return v;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.radar_sens:
                break;
            case R.id.radar_max:

                Cursor cur;

                int a = DB.getMaxSensorCount(getArguments().getLong("millis"));
                Toast.makeText(getActivity(), "a = " + a, Toast.LENGTH_SHORT).show();
                break;
        }


    }
}

