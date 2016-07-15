package com.example.laizihan.startfornewlife.activity.fragment;


import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * 创建时间：2016年05月26日 下午6:19
 * 创建人：赖梓瀚
 * 类名：BaseFragment
 * 用途：
 */
public class BaseFragment extends Fragment {


    private void normal() {


        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("normal");

            }
        }).start();


    }

/*    private void lamda() {
        new Thread(() -> {

            System.out.println("normal");

        }).start();
    }*/


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("fragment", getClass().getName() + "::" + isVisibleToUser + "");
    }


    private void testRunnable() {

/*
        getView().post(() -> {


        });
*/


    }


}
