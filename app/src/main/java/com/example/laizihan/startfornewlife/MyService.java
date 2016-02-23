package com.example.laizihan.startfornewlife;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;

public class MyService extends Service {
    public MyService() {
        Parcel.obtain();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        ActivityManager activityManager;
        Binder binder;
        Process process;
        HandlerThread thread;
        throw new UnsupportedOperationException("Not yet implemented");



    }
}
