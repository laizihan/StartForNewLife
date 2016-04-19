package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

/**
 * 创建时间：2016年03月31日 下午1:50
 * 创建人：赖梓瀚
 * 类名：MyScrollView
 * 用途：
 */
public class MyScrollView extends ScrollView {
    private OnSccrollChangeListener mListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        return false;
    }




    interface OnSccrollChangeListener {
        void onChange();
    }

    public void setOnScrollChangeListener(OnSccrollChangeListener listener){
        mListener = listener;
    }




}
