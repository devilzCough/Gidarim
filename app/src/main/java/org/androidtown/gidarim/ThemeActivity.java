package org.androidtown.gidarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ThemeActivity extends AppCompatActivity {

    int themeNum;

    ListView listView;
    ArrayList<ThemeInfo> themeInfo;

    // GridLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        Intent intent = getIntent();
        themeNum = intent.getExtras().getInt("theme");
        GridLayout layout = (GridLayout) findViewById(R.id.topBar);
        layout.setBackgroundColor(GidarimConstants.BAR_COLOR[themeNum]);

        listView = (ListView) findViewById(R.id.themeList);
        themeInfo = new ArrayList<>();
        for (int i = 0; i < GidarimConstants.NTHEME; i++) {
            ThemeInfo tmp = new ThemeInfo(GidarimConstants.THEME_TITLE[i], GidarimConstants.THEME_COLOR[i]);
            themeInfo.add(tmp);
        }

        ThemeAdapter adapter = new ThemeAdapter(this, R.layout.list_theme, themeInfo);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                GridLayout layout = (GridLayout) findViewById(R.id.topBar);
                layout.setBackgroundColor(GidarimConstants.BAR_COLOR[position]);
                themeNum = position;
            }
        });
    }

    public void onBackBtnClicked(View v) {

        Intent intent = new Intent();
        intent.putExtra("theme", themeNum);
        setResult(RESULT_OK, intent);
        finish();
    }
}
