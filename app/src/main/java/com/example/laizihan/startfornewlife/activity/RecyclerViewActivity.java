package com.example.laizihan.startfornewlife.activity;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.laizihan.startfornewlife.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private View mFloatButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
    }

    private void initViews() {
        initFAB();
        mRecyclerView = getView(R.id.rv_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent,state);
            }
        });
        Log.e("view", mRecyclerView.toString());
    }


    private void initFAB() {
        mFloatButton = getView(R.id.fab);
        Log.e("view", mFloatButton.toString());
    }

    private <T extends View> T getView(@IdRes int id) {
        return (T) findViewById(id);
    }


}
