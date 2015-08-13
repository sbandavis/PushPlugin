package com.plugin.gcm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.lang.System;

public class HeartbeatKeepAliveReceiver extends BroadcastReceiver {

  private boolean heartbeatStarted = true;

    @Override
    public void onReceive(Context context, Intent intent) {
      if (!heartbeatStarted) {
        Log.d("HeartbeatKeepAliveReceiver", "Heartbeat keep alive trigger received");
        int delay = 300000; // 5 minutes
        Intent i = new Intent(context, HeartbeatService.class);
        PendingIntent sender = PendingIntent.getService(context, 0, i, 0);

        // We want the alarm to go off 2 seconds from now.
        long firstTime = System.currentTimeMillis() + 2 * 1000;

        // Schedule the alarm!
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstTime, delay, sender);//5min interval
        heartbeatStarted = true;
      }
    }
}
