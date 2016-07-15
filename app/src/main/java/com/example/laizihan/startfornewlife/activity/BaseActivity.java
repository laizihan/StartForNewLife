package com.example.laizihan.startfornewlife.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.laizihan.startfornewlife.R;

import java.io.File;

/**
 * 创建时间：2016年04月05日 下午3:41
 * 创建人：赖梓瀚
 * 类名：BaseActivity
 * 用途：
 */
public class BaseActivity extends AppCompatActivity {


    public static void deleteFile(File file) {
        if (file.isFile()) {//表示该文件不是文件夹
            file.delete();
        } else {
            //首先得到当前的路径
            String[] childFilePaths = file.list();
            for (String childFilePath : childFilePaths) {
                File childFile = new File(file.getAbsolutePath() + "\\" + childFilePath);
                deleteFile(childFile);
            }
            file.delete();
        }
    }


    //递归
    private int gaoTa(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return gaoTa(n - 1) * gaoTa(n - 2);
        }
    }


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


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
