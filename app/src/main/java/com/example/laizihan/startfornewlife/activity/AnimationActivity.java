package com.example.laizihan.startfornewlife.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

import com.example.laizihan.startfornewlife.R;

public class AnimationActivity extends AppCompatActivity {

    private String mString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contraint);
        mString = "ss";
//        installButton();

//        ImageView imageView = (ImageView) findViewById(R.id.iv_andriod);
//        TextView testView = (TextView) findViewById(R.id.tv_test);
/*        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_in_top);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_to_top_outside);
        animation.setDuration(2000);
        loadAnimation.setDuration(2000);
        loadAnimation.setFillAfter(true);
        animation.setFillAfter(true);
*//*
        animation.setFillAfter(true);
        loadAnimation.setFillAfter(true);
        testView.setVisibility(View.VISIBLE);*//*
        testView.setVisibility(View.VISIBLE);
        imageView.startAnimation(loadAnimation);
        testView.startAnimation(animation);*/



    }







    private String getString() {
        return mString;
    }




    private void installButton() {

        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams layoutParams = createLayoutParams();
        Button button = new Button(this);
        button.setText("悬浮Button");
        windowManager.addView(button, layoutParams);
    }


    private WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.height = layoutParams.WRAP_CONTENT;
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        return layoutParams;
    }
}
