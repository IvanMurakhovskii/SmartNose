package com.murik.smartnose.models;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class DateGroup extends ExpandableGroup{
    /*String title = "";
    public void getDateMillis(long datetime){
        title = (String) android.text.format.DateFormat.format("MM-dd-yyyy", datetime);
    }*/

    public DateGroup(String title, List items) {
        super(title, items);


    }
}
