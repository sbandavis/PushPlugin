package com.plugin.gcm;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HeartbeatService extends IntentService {

  public HeartbeatService() {
     super("HeartbeatService");
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    this.sendBroadcast(new Intent("com.google.android.intent.action.GTALK_HEARTBEAT"));
    this.sendBroadcast(new Intent("com.google.android.intent.action.MCS_HEARTBEAT"));
    Log.d("HeartbeatService", "Heartbeat for GCM");
  }
}