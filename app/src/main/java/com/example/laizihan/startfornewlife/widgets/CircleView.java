package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.laizihan.startfornewlife.R;

/**
 * 创建时间：2016年04月03日 上午10:04
 * 创建人：赖梓瀚
 * 类名：CircleView
 * 用途：
 */
public class CircleView extends View {

    private Paint mPaint;

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context) {
        super(context);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.CYAN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

    }

    private Bitmap createBitman() {


        return BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }


    private RectF createRect() {
        return new RectF(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawArc();
        canvas.drawArc(createRect(), 0, 45, false, mPaint);


    }
}
