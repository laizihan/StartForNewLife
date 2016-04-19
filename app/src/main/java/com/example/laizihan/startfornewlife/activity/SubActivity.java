package com.example.laizihan.startfornewlife.activity;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.laizihan.startfornewlife.R;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {
    private SimpleDraweeView imageView;
    private final static String TAG = "GestureDetector";
    private GestureDetector mGestureDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);
        imageView = (SimpleDraweeView) findViewById(R.id.iv_ratation);
        Uri uri = Uri.parse("http://pic.mmfile.net/2013/08/1315595G7-2.jpg");
        imageView.setImageURI(uri);

//        createGesture();
    }






    private void setImageView(SimpleDraweeView simpleDraweeView){
//        DraweeController controller = simpleDraweeView.getController();
        ItemTouchHelper touchHelper;


    }





    private void createGesture() {

        mGestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.e(TAG, "onDown: ");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.e(TAG, "onShowPress: ");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e(TAG, "onSingleTapUp: ");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.e(TAG, "onScroll: ");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.e(TAG, "onLongPress: ");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.e(TAG, "onFling: ");
                return false;
            }
        });

        mGestureDetector.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Log.e(TAG, "onSingleTapConfirmed: ");
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.e(TAG, "onDoubleTap: ");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                Log.e(TAG, "onDoubleTapEvent: ");
                return false;
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

    }

    private void creatAnimation() {
        ObjectAnimator ratationY = ObjectAnimator.ofFloat(imageView, "rotationX", 0f, 360f);
        ratationY.setDuration(1000 * 60);
        ratationY.start();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    private <T extends View> T getViewById(@IdRes int resource) {
        return (T) findViewById(resource);
    }


    private class CutomizeImageView<DH extends RecyclerView.ViewHolder> extends ImageView {


        DH listSource;

        public CutomizeImageView(Context context) {
            super(context);

        }


        private void getData(List<?> data) {
            data.get(0);
        }

        private DH getListSource() {
            return listSource;
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);


    }
}
