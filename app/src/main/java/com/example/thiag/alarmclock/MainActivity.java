package com.example.thiag.alarmclock;

import android.app.AlarmManager;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edt_time;
    Button btn_set, btn_dismiss, btn_snooze, btn_repeat;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notifications.createChannel(this);

        btn_set = (Button) findViewById(R.id.btn_set);
        btn_dismiss = (Button) findViewById(R.id.btn_dismiss);
        btn_snooze = (Button) findViewById(R.id.btn_snooze);
        btn_repeat = (Button) findViewById(R.id.btn_repeat);
        edt_time = (EditText) findViewById(R.id.edt_time);

        btn_set.setOnClickListener(new View.OnClickListener() {
            Boolean check = false;
            @Override
            public void onClick(View view) {
            if(edt_time.equals("")){
            check = false;
            Toast.makeText(getApplicationContext(), " Type an alarm ", Toast.LENGTH_SHORT);


            }
            }
        });

    }

        //Date/time to set an alarm
    public long getTime(){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 00);
        long time = c.getTimeInMillis();
        return time;
    }






    public void onClickSet(View view){

        Intent intent = new Intent(WakeupThiagoReceiver.ACTION);
            //Set an alarm
            AlarmUtils.schedule(this, intent, getTime());
            //sendBroadcast(intent);
            Toast.makeText(this, "Alarm set sucessfully.", Toast.LENGTH_SHORT).show();
    }




        public void onClickRepeat(View view){
            Intent intent = new Intent(WakeupThiagoReceiver.ACTION);
            //Repeat the alarm how many times you want
                AlarmUtils.scheduleRepeat(this, intent, getTime(), AlarmManager.INTERVAL_DAY);
                //sendBroadcast(intent)
                Toast.makeText(this, "Alarm is going to repeat every day", Toast.LENGTH_SHORT).show();
        }

        public void onClickDismiss(View view){
            Intent intent = new Intent(WakeupThiagoReceiver.ACTION);
            //Dismiss an alarm
            AlarmUtils.dismiss(this, intent);
            Toast.makeText(this, "Alarm dismissed.",Toast.LENGTH_SHORT).show();
        }




}


























