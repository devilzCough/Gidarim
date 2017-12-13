package org.androidtown.gidarim;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    int nTheme;
    String[] themeList = {"MODERN", "CHOCOLATE"};
    int[] themeColor = {Color.rgb(83, 142, 166), Color.rgb(92, 75, 81)};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        nTheme = 2;
        listView = (ListView) findViewById(R.id.themeList);
        ArrayList<ThemeInfo> themeInfo = new ArrayList<>();
        for (int i = 0; i < nTheme; i++) {
            ThemeInfo tmp = new ThemeInfo(i, themeList[i], themeColor[i]);
            themeInfo.add(tmp);
        }

        ThemeAdapter adapter=new ThemeAdapter(this, R.layout.list_theme, themeInfo);
        listView.setAdapter(adapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, themeList);

        listView.setAdapter(adapter);
    }

    public void onBackBtnClicked(View v) {
        finish();
    }
}
