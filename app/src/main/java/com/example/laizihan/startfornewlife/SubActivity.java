package com.example.laizihan.startfornewlife;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SubActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        imageView = (ImageView) findViewById(R.id.iv_ratation);

        ObjectAnimator ratationY = ObjectAnimator.ofFloat(imageView, "rotationX", 0f, 360f);
        ratationY.setDuration(1000*60);
        ratationY.start();


    }


}
