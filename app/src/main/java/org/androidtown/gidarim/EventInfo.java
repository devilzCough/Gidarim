package org.androidtown.gidarim;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by iseungjin on 2017. 12. 13..
 */
// to putExtras this object, need to implements Parcelable
public class EventInfo implements Parcelable {

    // event instances
    String title, memo, date;
    int dDay;

    // to set background color
    int themeNum;

    public EventInfo(String _title, String _date, String _memo, int dday, int _themeNum) {
        title = _title;
        date = _date;
        memo = _memo;
        dDay = dday;
        themeNum = _themeNum;
    }

    public EventInfo(Parcel src) {
        title = src.readString();
        date = src.readString();
        memo = src.readString();
        dDay = src.readInt();
        themeNum = src.readInt();
    }

    public static final Parcelable.Creator CREATOR = new Creator() {
        public EventInfo createFromParcel(Parcel in) {
            return new EventInfo(in);
        }

        public EventInfo[] newArray(int size) {
            return new EventInfo[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(memo);
        dest.writeInt(dDay);
        dest.writeInt(themeNum);
    }

    // get, set method
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getMemo() { return memo; }
    public int getdDay() { return dDay; }
    public int getThemeNum() { return themeNum; }

    public void setTitle(String _title) { title = _title; }
    public void setMemo(String _memo) { memo = _memo; }
    public void setDate(int _year, int _month, int _day) {
        date = _year + ". " + _month + ". " + _day;
    }
    public void setThemeNum(int _themNum) { themeNum = _themNum; }
}
