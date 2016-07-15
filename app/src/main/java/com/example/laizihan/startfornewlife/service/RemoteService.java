package com.example.laizihan.startfornewlife.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.example.laizihan.startfornewlife.IMyAidlInterface;

public class RemoteService extends Service {


    public RemoteService() {


    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new IMyAidlInterface.Stub() {
            @Override
            public void add(int a, int b) throws RemoteException {
                Log.e("add ", "execute in process" + Process.myPid());
            }

            @Override
            public int getPid() throws RemoteException {
                return Process.myPid();
            }


        }.asBinder();
    }
}
