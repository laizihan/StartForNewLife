package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * 创建时间：2016年07月03日 上午1:34
 * 创建人：赖梓瀚
 * 类名：PullToRefreshLayout
 * 用途：
 */
public class PullToRefreshLayout<T extends View> extends FrameLayout {


    T mContentView;


    public PullToRefreshLayout(Context context) {
        super(context);
    }

    public PullToRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
