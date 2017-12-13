package org.androidtown.gidarim;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EditActivity extends AppCompatActivity {

    final int DIALOG_DATE = 1;

    EditText etTitle, etMemo;
    TextView date;

    int nYear, nMonth, nDay;

    EventInfo event;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        event = new EventInfo();

        Calendar cal = Calendar.getInstance();
        nYear = cal.get(Calendar.YEAR);
        nMonth = cal.get(Calendar.MONTH);
        nDay = cal.get(Calendar.DAY_OF_MONTH);

        etTitle = (EditText) findViewById(R.id.inputTitle);
        etMemo = (EditText) findViewById(R.id.inputMemo);

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
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_DATE :
                DatePickerDialog dateDialog = new DatePickerDialog
                        (EditActivity.this, new DatePickerDialog.OnDateSetListener() {

                            public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
                                date.setText(year + ". " + (monthOfYear + 1) + ". " + dayOfMonth);

                                nYear = year;
                                nMonth = monthOfYear+1;
                                nDay = dayOfMonth;
                            }
                        }, nYear, nMonth, nDay);

                return dateDialog;
        }
        return super.onCreateDialog(id);
    }



    public void onBackBtnClicked(View v) {

        finish();
    }

    public void onDoneBtnClicked(View v) {

        String title = etTitle.getText().toString();
        String memo = etMemo.getText().toString();

        event.setTitle(title);
        event.setDate(nYear, nMonth, nDay);
        event.setMemo(memo);

        Toast.makeText(EditActivity.this, "Done!!", Toast.LENGTH_SHORT).show();
    }
}
