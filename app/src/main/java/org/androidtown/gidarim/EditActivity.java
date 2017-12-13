package org.androidtown.gidarim;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    final int DIALOG_DATE = 1;

    int themeNum;
    EditText etTitle, etMemo;
    TextView date;

    int nYear, nMonth, nDay;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // to set topBar background color, get theme info
        Intent intent = getIntent();
        themeNum = intent.getExtras().getInt("theme");
        GridLayout layout = (GridLayout) findViewById(R.id.topBar);
        layout.setBackgroundColor(GidarimConstants.BAR_COLOR[themeNum]);

        etTitle = (EditText) findViewById(R.id.inputTitle);
        etMemo = (EditText) findViewById(R.id.inputMemo);

        // get today date
        Calendar cal = Calendar.getInstance();
        nYear = cal.get(Calendar.YEAR);
        nMonth = cal.get(Calendar.MONTH);
        nDay = cal.get(Calendar.DAY_OF_MONTH);

        // set default date to today
        date = (TextView) findViewById(R.id.selectDate);
        date.setText(nYear + ". " + nMonth + ". " + nDay);
        date.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                showDialog(DIALOG_DATE);
                return true;
            }
        });
    }

    @Override
    @Deprecated
    // make date picker dialog
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DATE :
                DatePickerDialog dateDialog = new DatePickerDialog(EditActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                        // set date to selected day
                        date.setText(year + ". " + (monthOfYear + 1) + ". " + dayOfMonth);

                        nYear = year;
                        nMonth = monthOfYear + 1;
                        nDay = dayOfMonth;
                    }
                }, nYear, nMonth, nDay); // set default picker date
                return dateDialog;
        }
        return super.onCreateDialog(id);
    }

    // finish Activity
    // then go MainActivity
    public void onBackBtnClicked(View v) {
        finish();
    }

    // save input event data
    // then send data to Main Activity
    public void onDoneBtnClicked(View v) {

        String title = etTitle.getText().toString();
        String date = nYear + ". " + nMonth + ". " + nDay;
        String memo = etMemo.getText().toString();

        // calculated d-day
        Calendar today = Calendar.getInstance();
        Calendar dday = Calendar.getInstance();
        int tmpMonth = nMonth - 1;
        dday.set(nYear, tmpMonth, nDay);

        long nToday = today.getTimeInMillis() / 86400000;
        long nDday = dday.getTimeInMillis() / 86400000;
        long diff = nToday - nDday;

        // make one event data object
        EventInfo event = new EventInfo(title, date, memo, (int)diff, themeNum);

        // send event data to MainActivity
        Intent intent = new Intent();
        intent.putExtra("event", event);
        setResult(RESULT_OK, intent);
        finish();
    }
}
