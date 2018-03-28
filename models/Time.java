package com.murik.smartnose.models;


import android.text.format.DateFormat;

public class Time {
    private String time;
    private long datetime;

    public Time(long datetime){
        this.datetime = datetime;
        time = (String) DateFormat.format("kk:mm:ss",datetime);
    }

    public long getDateMillis() {
        return datetime;
    }

    public void setDateMillis(long datetime) {
        this.datetime = datetime;
    }

    public String getTimeName(){
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
