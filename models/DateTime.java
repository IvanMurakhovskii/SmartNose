package com.murik.smartnose.models;


import android.text.format.DateFormat;

public class DateTime {

    public static String  getDateFormat(long millis) {
        return (String) DateFormat.format("dd.MM.yyyy", millis);
    }
    public static String getTimeFormat(long millis) {
        return (String) DateFormat.format("kk:mm:ss", millis);


    }

    /*public static String getTime(long milliSeconds)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("kk:mm:ss", Locale.ENGLISH);
        Calendar customCalendar = Calendar.getInstance();
        customCalendar.setTimeInMillis(milliSeconds);

        return dateFormat.format(customCalendar.getTime());
    }*/
}
