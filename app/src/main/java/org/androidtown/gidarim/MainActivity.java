package org.androidtown.gidarim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnSettings, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onSettingsBtnClicked(View v) {

        Intent intent = new Intent(this, ThemeActivity.class);
        startActivity(intent);
    }

    public void onAddBtnClicked(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
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
