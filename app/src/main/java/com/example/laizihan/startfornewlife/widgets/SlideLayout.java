package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;

/**
 * 创建时间：2016年04月06日 下午5:28
 * 创建人：赖梓瀚
 * 类名：SlideLayout
 * 用途：
 */
public class SlideLayout extends CoordinatorLayout {

    private Scroller mScroller;
    private static final String TAG = "SlideLayout";
    private boolean mSlide;
    private ViewConfiguration mViewConfiguration;
    private int lastX;
    private int lastY;


    public SlideLayout(Context context) {
        super(context);
        init(context);
    }

    public SlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SlideLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        mScroller = new Scroller(context);
        mViewConfiguration = ViewConfiguration.get(context);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                lastX = (int) ev.getRawX();
                lastY = (int) ev.getRawY();
                Log.e(TAG, "Action Down：X:" + lastX);
//                Log.e(TAG, "Action Down：X work");
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getRawX();

                if (lastX < 50 && moveX - lastX > 200) {
                    Log.e(TAG, "action move消费: ");
                    lastX = moveX;
                    return true;
                } else {
                    return false;
                }

            case MotionEvent.ACTION_UP:
                break;
        }


/*        if (ev.getRawX() < 20) {
            Log.e(TAG, "onInterceptTouchEvent: ");
            mSlide = true;
            return true;
        }*/

        return false;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        super.onTouchEvent(ev);
        int action = ev.getAction();
        int temp = lastX;
        Log.e(TAG, "onTouchEvent: " + ev.toString());
        switch (action) {

            case MotionEvent.ACTION_MOVE:

                int moveX = (int) ev.getRawX();
                int delta = moveX - temp;
                temp = moveX;
                scrollTo(-delta,0);

                break;

            case MotionEvent.ACTION_UP:
                break;


        }


        return false;
    }

    private void scrollToPos() {

    }


    @Override
    public void computeScroll() {
//        super.computeScroll();
    }
}
