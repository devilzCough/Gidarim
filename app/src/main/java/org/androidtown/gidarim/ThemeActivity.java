package org.androidtown.gidarim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThemeActivity extends AppCompatActivity {

    String[] themeList = {"MODERN", "CHOCOLATE"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        listView = (ListView) findViewById(R.id.themeList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, themeList);

        listView.setAdapter(adapter);
    }
}
