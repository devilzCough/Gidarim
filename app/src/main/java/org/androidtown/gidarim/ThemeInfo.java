package org.androidtown.gidarim;

/**
 * Created by iseungjin on 2017. 12. 14..
 */

public class ThemeInfo {

    private int index;
    private String title;
    private int background;

    public ThemeInfo(int _index, String _title, int _color) {
        index = _index;
        title = _title;
        background = _color;
    }

    public String getTitle() { return title;}
    public int getBackground() { return background; }
    public void setTitle(String _title) { title = _title; }

}
