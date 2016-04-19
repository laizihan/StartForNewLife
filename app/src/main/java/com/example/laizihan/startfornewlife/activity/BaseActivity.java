package com.example.laizihan.startfornewlife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.laizihan.startfornewlife.R;

/**
 * 创建时间：2016年04月05日 下午3:41
 * 创建人：赖梓瀚
 * 类名：BaseActivity
 * 用途：
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
