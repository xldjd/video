package com.example.instantmusicvideotest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.instantmusicvideotest.untis.HttpPostRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private TextView textView;
    private Button register;
    private EditText et_username;
    private EditText et_zhanghao;
    private  EditText et_password1;
    private  EditText et_password2;
    private  Boolean register_currect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        findViewById(R.id.rgeisteractivity).setPadding(0, getStatusBarHeight(), 0, 0);
        //
        textView=findViewById(R.id.register_fanhui);
        register=findViewById(R.id.btnReg);
        et_username=findViewById(R.id.edtUserName);
        et_password1=findViewById(R.id.edtPassWd);
        et_password2=findViewById(R.id.edtConfirmPassWd);
        et_zhanghao=findViewById(R.id.edzhanghao);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
//注册实现
      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(et_password1.getText().toString().equals(et_password2.getText().toString())) {

                  //注册开始
                  String url = "http://192.168.253.1:8085/android/register";
                  //请求传入的参数
                  RequestBody requestBody = new FormBody.Builder()
                          .add("username", et_username.getText().toString())
                          .add("password", et_password1.getText().toString())
                          .add("zhanghao", et_zhanghao.getText().toString())
                          .build();
                  HttpPostRequest.okhttpPost(url, requestBody, new Callback() {
                      @Override
                      public void onFailure(Call call, IOException e) {
                          Looper.prepare();
                          Toast.makeText(RegisterActivity.this, "post请求失败", Toast.LENGTH_SHORT).show();
                          Looper.loop();
                      }

                      @Override
                      public void onResponse(Call call, Response response) throws IOException {
                          Looper.prepare();
                          //
                          String jsonStr;
                          jsonStr = response.body().string();// 需要解析json格式的字符串
                          System.out.println(jsonStr);
                          try {
                              JSONObject jsonObject = new JSONObject(jsonStr);
                              if (jsonObject.getBoolean("result") == true) {
                                  register_currect = true;
                              } else {
                                  register_currect = false;
                              }
                          } catch (JSONException e) {
                              e.printStackTrace();
                          }
                          if (register_currect == true) {
                              Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                          } else {
                              Toast.makeText(RegisterActivity.this, "注册失败，用户名重复", Toast.LENGTH_SHORT).show();
                          }
                          //
                          Looper.loop();
                      }
                  });
                  //注册结束
              }
              else
              {
                  System.out.println(et_password2.getText().toString()+et_password1.getText().toString());
                  Toast.makeText(RegisterActivity.this, "请检查密码，两次密码输入不正确", Toast.LENGTH_SHORT).show();
              }


          }
      });

    }


    public int getStatusBarHeight() {
        int result = 0;
        //获取状态栏高度的资源id
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}