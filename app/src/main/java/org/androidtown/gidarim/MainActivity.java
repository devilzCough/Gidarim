package org.androidtown.gidarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 101;
    public static final int REQUEST_CODE_THEME = 103;

    int themeNum;
    // ImageButton btnSettings, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_THEME) {
            if (resultCode == RESULT_OK) {

                themeNum = data.getExtras().getInt("theme");

                GridLayout bar = (GridLayout) findViewById(R.id.topBar);
                LinearLayout dashboard = (LinearLayout) findViewById(R.id.dashboard);

                bar.setBackgroundColor(GidarimConstants.BAR_COLOR[themeNum]);
                dashboard.setBackgroundColor(GidarimConstants.THEME_COLOR[themeNum]);
            }
        }
    }

    public void onSettingsBtnClicked(View v) {

        Intent intent = new Intent(this, ThemeActivity.class);
        startActivityForResult(intent, REQUEST_CODE_THEME);
    }

    public void onAddBtnClicked(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("theme", themeNum);
        startActivityForResult(intent, REQUEST_CODE_ADD);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch(curId) {
            case R.id.menu_add:
                Toast.makeText(this, "                .", Toast.LENGTH_SHORT).show(); break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
