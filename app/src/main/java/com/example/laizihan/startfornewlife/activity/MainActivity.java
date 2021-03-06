package com.example.laizihan.startfornewlife.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.laizihan.startfornewlife.R;


public class MainActivity extends BaseActivity {


    interface OnUpdateUIThreadListener {
        void onDo(Object o);
    }

    SQLiteDatabase database;
    Handler handler;

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SurfaceView surfaceView;

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                startActivity(new Intent(MainActivity.this, SubActivity.class));
//                startService(new Intent(MainActivity.this,MyService.class));


      /*          BottomSheetDialog sheetDialog = new BottomSheetDialog(MainActivity.this);
                sheetDialog.setContentView(R.layout.activity_sub);
                sheetDialog.show();*/
                updateUIView(new OnUpdateUIThreadListener() {
                    @Override
                    public void onDo(Object o) {
                        fab.setBackgroundColor(Color.GREEN);
                        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                            @Override
                            public void uncaughtException(Thread thread, Throwable ex) {

                            }
                        });

                    }
                });


            }
        });


        View view = findViewById(R.id.bottom_sheet_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FuckAdapter());
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.e("rv Intercept touch",e.toString());
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.e("rv touch event",e.toString());
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                Log.e("rv disallow touch event",disallowIntercept+"");
            }
        });


        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
//        createBottomSheetBehavior(view);


//        BottomSheetBehavior<FloatingActionButton> from = BottomSheetBehavior.from(fab);
//        from.setPeekHeight(1000);

/*        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("fuck", "进程间broacast");


            }
        }, new IntentFilter("android.browser.sub"));*/

/*        bindService(new Intent(), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, 102);*/
    }


    private void createBottomSheetBehavior(View view) {
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(view);

        from.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                Log.e("state", "new state:" + newState);
                new ScrollView(MainActivity.this);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.e("slide", "onslide");
            }
        });
        from.setPeekHeight(1000);
//        from.setState(BottomSheetBehavior.STATE_DRAGGING);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            startActivity(new Intent(this,GenericViewsActivity.class));
//            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void getReflect() {
        PackageManager packageManager = getPackageManager();
        try {
            Class.forName(packageManager.getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void updateUIView(final OnUpdateUIThreadListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                listener.onDo("come from " + Thread.currentThread().getName());
            }
        }).start();


    }


    private void testIntent() {
        Intent intent = new Intent();
        int flags = intent.getFlags();
        Looper looper;


    }


    private class FuckAdapter extends RecyclerView.Adapter<FuckAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);

            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 120;
        }




        class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }


}
