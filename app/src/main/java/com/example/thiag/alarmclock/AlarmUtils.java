package com.example.thiag.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by thiag on 18/03/2018.
 */

public class AlarmUtils {
    private static final String TAG = "MyAlarmClock";
    //Set an alarm for the day/time chosen by the user
    public static void schedule(Context context, Intent intent, long triggerAtMillis){
        PendingIntent p  = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmclock = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmclock.set(AlarmManager.RTC_WAKEUP, triggerAtMillis, p);
        Log.d("MyAlarmClock", "Alarm set sucessfully");

    }
    //Set an alarm with the repeat action
    public static void scheduleRepeat(Context context, Intent intent, long triggerAtMillis, long intervalMillis){
        PendingIntent p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, p);
        Log.d("MyAlarmClock", "Alarm set with repeat sucessfully");


    }

    //Dismiss an alarm
    public static void dismiss(Context context, Intent intent){
        AlarmManager alarm = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent p = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarm.cancel(p);
        Log.d("MyAlarmClock", "Alarm canceled sucessfully.");

    }

}
