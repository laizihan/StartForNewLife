package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
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
    private Paint mPaint;


    private PointF mControllPointF = new PointF();

    public FlingView(Context context) {
        super(context);
        init(context);
    }

    public FlingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public FlingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        mScroller = new OverScroller(context);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        mControllPointF.x = rawX;
        mControllPointF.y = rawY;
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(getWidth() / 2, getHeight() / 2);

//        canvas.drawRect(0,0,300,300,mPaint);
        PointF start = new PointF(-100, 0);
        PointF end = new PointF(100, 0);
        Path path = new Path();
        path.moveTo(start.x, start.y);
//        path.lineTo(100, 100);
        path.quadTo(mControllPointF.x, mControllPointF.y, end.x, end.y);
        canvas.drawPath(path, mPaint);


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
