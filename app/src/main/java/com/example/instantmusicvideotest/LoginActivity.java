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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instantmusicvideotest.untis.DemoEvent;
import com.example.instantmusicvideotest.untis.HttpPostRequest;
import com.example.instantmusicvideotest.untis.UserEvent;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private Button button_login;
    private TextView login1,login2,login3;
    private  Boolean password_currect;

    private EditText et_username;

    private EditText et_password;

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        findViewById(R.id.loginactivity).setPadding(0, getStatusBarHeight(), 0, 0);
        transparentStatusBar(getWindow());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
  //正式代码开始
        //绑定控件
        et_username = findViewById(R.id.ed_name);
        et_password = findViewById(R.id.ed_password);
      button_login = findViewById(R.id.login_login);
        checkBox=findViewById(R.id.login_checkbox);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()==false)
                {
                    Toast.makeText(LoginActivity.this,"请先勾选阅读提示",Toast.LENGTH_SHORT).show();
                }
                else {
//后期加代码
   //登入开始
                    String url = "http://192.168.253.1:8085/android/login";
                    //请求传入的参数
                    RequestBody requestBody = new FormBody.Builder()
                            .add("zhanghao", et_username.getText().toString())
                            .add("password", et_password.getText().toString())
                            .build();
                    HttpPostRequest.okhttpPost(url, requestBody, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, "post请求失败", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                            startActivity(intent);
//                            finish();
                            Looper.loop();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Looper.prepare();
                            //
                            String jsonStr;
                            jsonStr=response.body().string();// 需要解析json格式的字符串
                   System.out.println(jsonStr);
                            try {
                                JSONObject jsonObject = new JSONObject(jsonStr);
                                if(jsonObject.getBoolean("result") == true) {
                                                password_currect = true;
                                } else {
                                             password_currect = false;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if (password_currect==true)
                            {
                                Message message=new Message();
                                message.what=1;
                                handler.sendMessage(message);
                            }
else
                            {
                                Message message=new Message();
                                message.what=2;
                                handler.sendMessage(message);
                            }
                            //
                            Looper.loop();
                        }
                    });



 //登入结束
                }
            }

        });
        //3个textview设置
        login1=findViewById(R.id.login_1);
        login2=findViewById(R.id.login_2);
        login3=findViewById(R.id.login_3);
        login3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();;
            }
        });
        initView();

        //代码结束

    }

    private void initView() {

    }


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

    private Handler handler=new Handler(Looper.myLooper()){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("zhanghao",et_username.getText().toString());
                   startActivity(intent);

                    break;
                case 2:
                    Toast.makeText(LoginActivity.this, "用户名密码错误", Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(message);
        }
    };
}