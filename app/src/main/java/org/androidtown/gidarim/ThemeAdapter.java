package org.androidtown.gidarim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by iseungjin on 2017. 12. 14..
 */

public class ThemeAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<ThemeInfo> data;
    private int layout;

    public ThemeAdapter(Context context, int layout, ArrayList<ThemeInfo> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    // get list size
    public int getCount() { return data.size(); }

    @Override
    // get one item in list
    public ThemeInfo getItem(int position) { return data.get(position); }

    @Override
    // get item position(index)
    public long getItemId(int position) { return position; }

    @Override
    // set list name and background color
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        ThemeInfo item = data.get(position);
        TextView name = (TextView) convertView.findViewById(R.id.themeTitle);

        name.setBackgroundColor(item.getBackground());
        name.setText(item.getTitle());

        return convertView;
    }
}
