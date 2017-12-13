package org.androidtown.gidarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 101;
    public static final int REQUEST_CODE_THEME = 103;

    int themeNum;
    ArrayList<EventInfo> eventList;
    EventInfo event;

    RecyclerView recyclerView;

    TextView dday;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themeNum = 0;
        eventList = new ArrayList<>();

        // set for recyclerView(d-day list is recycler card list)
        recyclerView = (RecyclerView) findViewById(R.id.ddayRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        dday = (TextView) findViewById(R.id.textDday);
        title = (TextView) findViewById(R.id.textTitle);
    }

    @Override
    // get results from the invoked Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // after add Event
        if (requestCode == REQUEST_CODE_ADD) {
            if (resultCode == RESULT_OK) {
                // get event data
                Bundle bundle = data.getExtras();
                event = (EventInfo) bundle.getParcelable("event");

                eventList.add(event);
                // apply event data to d-day recyclerView
                recyclerView.setAdapter(new DDayCardRecyclerAdapter(getApplicationContext(), eventList, R.id.mainView));

                // set dashboard textView.
                // recently added event are exposed
                int size = eventList.size() - 1;
                int diff = eventList.get(size).getdDay();
                if (diff <= 0) {
                    dday.setText("D " + diff);
                } else {
                    dday.setText("D +" + diff);
                }

                title.setText(eventList.get(size).getTitle());
            }
        }
        // after change theme
        else if (requestCode == REQUEST_CODE_THEME) {
            if (resultCode == RESULT_OK) {

                // get theme data
                themeNum = data.getExtras().getInt("theme");

                GridLayout bar = (GridLayout) findViewById(R.id.topBar);
                LinearLayout dashboard = (LinearLayout) findViewById(R.id.dashboard);

                // if there is more than one event added,
                // changes the background color of the event cards
                if (eventList.size() > 0) {
                    for (int i = 0; i < eventList.size(); i++) {
                        eventList.get(i).setThemeNum(themeNum);
                    }
                    recyclerView.setAdapter(new DDayCardRecyclerAdapter(getApplicationContext(), eventList, R.id.mainView));
                }

                // change topBar & dashboard background color
                bar.setBackgroundColor(GidarimConstants.BAR_COLOR[themeNum]);
                dashboard.setBackgroundColor(GidarimConstants.THEME_COLOR[themeNum]);
            }
        }
    }

    // go Theme Activity with theme info
    public void onSettingsBtnClicked(View v) {

        Intent intent = new Intent(this, ThemeActivity.class);
        intent.putExtra("theme", themeNum);
        startActivityForResult(intent, REQUEST_CODE_THEME);
    }

    // go Edit Activity with theme info
    public void onAddBtnClicked(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("theme", themeNum);
        startActivityForResult(intent, REQUEST_CODE_ADD);
    }
}
