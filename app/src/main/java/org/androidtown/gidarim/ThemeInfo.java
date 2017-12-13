package org.androidtown.gidarim;

/**
 * Created by iseungjin on 2017. 12. 14..
 */

// set theme list
public class ThemeInfo {

    private String title;
    private int background;

    public ThemeInfo(String _title, int _color) {

        title = _title;
        background = _color;
    }

    // get, set method
    public String getTitle() { return title;}
    public int getBackground() { return background; }

    public void setTitle(String _title) { title = _title; }
}
