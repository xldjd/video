package com.example.instantmusicvideotest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class FisrtActivity extends AppCompatActivity implements View.OnClickListener {
    private int reclen=30;
    Timer timer=new Timer();
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fisrt);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        findViewById(R.id.fisrtactivity).setPadding(0, getStatusBarHeight(), 0, 0);
        transparentStatusBar(getWindow());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        textView=findViewById(R.id.countdown);
        myprepaer();
        findViewById(R.id.skip).setOnClickListener(this::onClick);

    }


    private void myprepaer() {
        TimerTask task =new TimerTask() {
            @Override
            public void run() {
                reclen--;
                Message message=new Message();
                message.what=1;
                handler.sendEmptyMessage(message.what);
            }
        };
        timer.schedule(task,1000,1000);
    }
    private Handler handler=new Handler(Looper.myLooper()){
        public void handleMessage(Message message){
            switch (1){
                case 1:
                    textView.setText(""+reclen);
                    if (reclen<=0){
                        timer.cancel();
                        Intent intent=new Intent(FisrtActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    super.handleMessage(message);
            }
        }
    };


    //获取状态栏高度
    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onClick(View v) {
        timer.cancel();
        Intent intent=new Intent(FisrtActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public static void transparentStatusBar(@NonNull final Window window) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            int vis = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(option | vis);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

}