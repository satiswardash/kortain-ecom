package com.kortain.enterprise.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static String TAG = MyFirebaseInstanceIDService.class.getName();

    public MyFirebaseInstanceIDService() {
    }

    @Override
    public void onTokenRefresh() {

        String tokenId = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "onTokenRefresh: "+tokenId);

    }
}
