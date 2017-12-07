package com.kortain.enterprise.services;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String NOTIFICATION_BADGE_PREF = "notification_badge";
    public static final String NOTIFICATION_BADGE_COUNTER_KEY = "notification_badge_counter";

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.i("message_received", "onMessageReceived: "+remoteMessage.getNotification().getBody());


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int count = preferences.getInt(NOTIFICATION_BADGE_COUNTER_KEY, MODE_PRIVATE);
        if(count > 0){
            SharedPreferences.Editor editor = preferences.edit();
            editor.remove(NOTIFICATION_BADGE_COUNTER_KEY);
            editor.putInt(NOTIFICATION_BADGE_COUNTER_KEY, ++count);
            editor.commit();
        }
        else{
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(NOTIFICATION_BADGE_COUNTER_KEY, 1);
            editor.commit();
        }

    }
}
