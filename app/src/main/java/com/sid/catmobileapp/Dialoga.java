package com.sid.catmobileapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Dialoga extends AppCompatActivity {
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialoga);

        Button alert = findViewById(R.id.alert);
        Button progress1 = findViewById(R.id.progress);
        Button date1 = findViewById(R.id.Date);
        Button time1 = findViewById(R.id.Time);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(Dialoga.this);
                builder.setTitle("Title");

                builder.setMessage("Hi");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dialoga.this, "You have selected yes", Toast.LENGTH_SHORT).show();



                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dialoga.this, "You have cancelled", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();



            }
        });
    progress1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            progress=new ProgressDialog(Dialoga.this);
            progress.setMessage("Downloading Music");
            progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            progress.setMax(100);

            progress.show();

            final int totalProgressTime = 100;
            final Thread t = new Thread() {
                @Override
                public void run() {
                    int jumpTime = 0;

                    while(jumpTime < totalProgressTime) {
                        try {
                            sleep(1000);
                            jumpTime += 5;
                            progress.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };
            t.start();
        }
    });

    date1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        DatePickerDialog datePickerDialog = new DatePickerDialog(Dialoga.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        Toast.makeText(Dialoga.this, dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();

                    }
                },2022,7,2);
        datePickerDialog.show();
        }
    });
    time1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


        TimePickerDialog timePickerDialog = new TimePickerDialog(Dialoga.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        Toast.makeText(Dialoga.this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, 12, 44, false);
        timePickerDialog.show();


        }
    });


    }
}