package com.example.laizihan.startfornewlife.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.laizihan.startfornewlife.IMyAidlInterface;
import com.example.laizihan.startfornewlife.R;
import com.example.laizihan.startfornewlife.service.RemoteService;

public class PathActivity extends AppCompatActivity {

    Button mButton;
    ViewGroup mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        mButton = (Button) findViewById(R.id.position_btn);
        mViewGroup = (RelativeLayout) findViewById(R.id.rl_parent);


/*        mButton.setOnClickListener((view)->{
            mButton.scrollTo(-100,-100);

        });*/


        mViewGroup.setOnClickListener((view) -> {
            mViewGroup.scrollTo(-100, -100);
        });
        mButton.setOnClickListener((v) -> {

            bindService(new Intent(PathActivity.this, RemoteService.class), new ServiceConnection() {

                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    IMyAidlInterface asInterface = IMyAidlInterface.Stub.asInterface(service);
                    try {
                        asInterface.add(2, 3);
                        Log.e("add", "remote process id ::" + asInterface.getPid() + " current pid ::" + Process.myPid());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {


                }
            }, BIND_AUTO_CREATE);

            Toast.makeText(PathActivity.this, "toast", Toast.LENGTH_LONG).show();
        });


    }
}
