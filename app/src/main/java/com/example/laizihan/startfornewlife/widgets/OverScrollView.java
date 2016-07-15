package com.example.laizihan.startfornewlife.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 创建时间：2016年07月15日 下午5:12
 * 创建人：赖梓瀚
 * 类名：OverScrollView
 * 用途：
 */
public class OverScrollView extends ScrollView {
    public OverScrollView(Context context) {
        super(context);
    }

    public OverScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OverScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }







    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, 200, isTouchEvent);
    }
}
