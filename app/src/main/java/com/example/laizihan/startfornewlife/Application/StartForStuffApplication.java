package com.example.laizihan.startfornewlife.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 创建时间：2016年04月01日 下午4:15
 * 创建人：赖梓瀚
 * 类名：StartForStuffApplication
 * 用途：
 */
public class StartForStuffApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());

    }
}
