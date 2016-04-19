package com.example.laizihan.startfornewlife.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.laizihan.startfornewlife.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class GenericViewsActivity extends BaseActivity {

    private SimpleDraweeView imageView;

    private RecyclerView mRecyclerView;
    private static final String TAG = "GenericViewsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_views);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();
    }


    private void init() {
        imageView = (SimpleDraweeView) findViewById(R.id.iv_ratation);
        Uri uri = Uri.parse("http://pic.mmfile.net/2013/08/1315595G7-2.jpg");
        imageView.setImageURI(uri);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
            }
        });
    }
}
