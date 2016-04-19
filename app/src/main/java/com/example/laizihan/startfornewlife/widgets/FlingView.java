package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.net.Uri;
import android.provider.UserDictionary;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;

/**
 * Created by laizihan on 16/3/8.
 */
public class FlingView extends View {
    OverScroller mScroller;
    Context mContext;

    public FlingView(Context context) {
        super(context);
    }

    public FlingView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public FlingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init(Context context) {
        mScroller = new OverScroller(context);

        GestureDetector gestureDetector = new GestureDetector(context, new MyGestureListener());
        Uri contentUri = UserDictionary.Words.CONTENT_URI;
    }




    private class MyGestureListener implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }


}
