package com.example.farmer_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.farmer_app.databinding.ActivityAlarmBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {

    private ActivityAlarmBinding binding;
    private MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlarmBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        createnotificationchannel();

        binding.selecttimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowTimepicker();

            }

         
        });


        binding.setalarmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setAlarm();

            }
        });

        binding.canclebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cancelAlarm();
            }
        });
    }

    private void cancelAlarm() {

        Intent intent = new Intent(this,Alarmrecriver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE);
        if(alarmManager == null)
        {
            alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        }
        alarmManager.cancel(pendingIntent);
        Toast.makeText(getApplicationContext(),"cancle",Toast.LENGTH_LONG).show();
    }

    private void ShowTimepicker() {

        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Alaram Time")
                .build();
        picker.show(getSupportFragmentManager(),"foxandroid");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(picker.getHour() > 12)
                {
                    binding.selectedtime.setText(
                            String.format("%02d",(picker.getHour()-12)) + ": " + String.format("%02d",picker.getMinute()) + "PM"
                    );


                }
                else {
                    binding.selectedtime.setText(picker.getHour() + ":" + picker.getMinute() + "AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,picker.getHour());
                calendar.set(Calendar.MINUTE,picker.getMinute());
                calendar.set(Calendar.SECOND,0);
                calendar.set(Calendar.MILLISECOND,0);

            }
        });
    }

    private void setAlarm() {
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,Alarmrecriver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();


    }

    private void createnotificationchannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1)

        {

            CharSequence name = "foxandroidreminderchannel";
            String description ="channel for alram";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("foxandroid",name,importance);

                channel.setDescription(description);

                NotificationManager notificationManager = getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);

            }

        }
    }
}