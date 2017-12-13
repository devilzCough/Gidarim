package org.androidtown.gidarim;

/**
 * Created by iseungjin on 2017. 12. 13..
 */

public class EventInfo {

    String title, memo, date;
    int year, month, day;

    public EventInfo() {

    }

    public String getTitle() { return title; }
    public String getMemo() { return memo; }
    public String getDate() { return date; }

    public void setTitle(String _title) { title = _title; }
    public void setMemo(String _memo) { memo = _memo; }
    public void setDate(int _year, int _month, int _day) {

        date = _year + ". " + _month + ". " + _day;

        year = _year;
        month = _month;
        day = _day;
    }
}
