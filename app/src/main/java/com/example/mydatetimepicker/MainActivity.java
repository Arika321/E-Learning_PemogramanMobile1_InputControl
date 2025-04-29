package com.example.mydatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText etJam, etTanggal;
    private ImageButton btnJam, btnTanggal;

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_TIME = "selectedTime";
    private static final String KEY_DATE = "selectedDate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etJam = findViewById(R.id.etJam);
        etTanggal = findViewById(R.id.eTanggal);
        btnJam = findViewById(R.id.btnJam);
        btnTanggal = findViewById(R.id.btnTanggal);

        // Load saved data
        loadSavedData();

        btnJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        etJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        etTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int jam = calendar.get(Calendar.HOUR_OF_DAY);
        int menit = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = String.format(Locale.getDefault(), "%d:%02d %s",
                        hourOfDay % 12 == 0 ? 12 : hourOfDay % 12,
                        minute,
                        hourOfDay < 12 ? "am" : "pm");
                etJam.setText(time);
                saveTime(time);
            }
        }, jam, menit, true);
        dialog.show();
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int tahun = calendar.get(Calendar.YEAR);
        int bulan = calendar.get(Calendar.MONTH);
        int tanggal = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = String.format("%02d - %02d - %d", dayOfMonth, month + 1, year);
                etTanggal.setText(date);
                saveDate(date);
            }
        }, tahun, bulan, tanggal);
        dialog.show();
    }

    private void saveTime(String time) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TIME, time);
        editor.apply();
    }

    private void saveDate(String date) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_DATE, date);
        editor.apply();
    }

    private void loadSavedData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedTime = sharedPreferences.getString(KEY_TIME, "");
        String savedDate = sharedPreferences.getString(KEY_DATE, "");
        etJam.setText(savedTime);
        etTanggal.setText(savedDate);
    }
}