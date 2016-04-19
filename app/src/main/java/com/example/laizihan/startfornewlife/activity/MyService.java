package com.example.laizihan.startfornewlife.activity;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.laizihan.startfornewlife.IMyAidlInterface;

import java.util.concurrent.Executors;

public class MyService extends Service {
    public MyService() {
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        new SimpleItemAnimator() {
            @Override
            public void runPendingAnimations() {
                Executors.newCachedThreadPool();
            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item) {

            }

            @Override
            public void endAnimations() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }

            @Override
            public boolean animateRemove(RecyclerView.ViewHolder holder) {
                return false;
            }

            @Override
            public boolean animateAdd(RecyclerView.ViewHolder holder) {
                return false;
            }

            @Override
            public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
                return false;
            }

            @Override
            public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
                return false;
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Object o;
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setItemAnimator(new RecyclerView.ItemAnimator() {
            @Override
            public boolean animateDisappearance(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @Nullable ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animateAppearance(@NonNull RecyclerView.ViewHolder viewHolder, @Nullable ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animatePersistence(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public boolean animateChange(@NonNull RecyclerView.ViewHolder oldHolder, @NonNull RecyclerView.ViewHolder newHolder, @NonNull ItemHolderInfo preLayoutInfo, @NonNull ItemHolderInfo postLayoutInfo) {
                return false;
            }

            @Override
            public void runPendingAnimations() {

            }

            @Override
            public void endAnimation(RecyclerView.ViewHolder item) {

            }

            @Override
            public void endAnimations() {

            }

            @Override
            public boolean isRunning() {
                return false;
            }
        });
        String s;
        installButton();
        Log.e("service","service execute");
        return START_STICKY;
    }


    private void installButton() {
        final WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        final Button view = new Button(this.getBaseContext());
        view.setText("点击删除");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowManager.removeView(view);
            }
        });
        windowManager.addView(view,createLayoutParams());


    }

    private WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.type = WindowManager.LayoutParams.TYPE_PHONE;
        lp.gravity = Gravity.CENTER;
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        return lp;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        ActivityManager activityManager;
        Binder binder;
        Process process;
        HandlerThread thread;

        IMyAidlInterface.Stub stub = new IMyAidlInterface.Stub() {
            @Override
            public void add(int a, int b) throws RemoteException {
                Looper.prepareMainLooper();
            }
        };
        return null;


    }

/*    private void testOnAsync() {
        AsyncTask asyncTask = null;
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);

    }*/
}
