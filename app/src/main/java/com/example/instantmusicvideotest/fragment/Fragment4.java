package com.example.instantmusicvideotest.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.untis.HttpPostRequest;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Fragment4 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private Button button1,button2,fbtn2,fbtn3,fbtn4,fbtn5;
    private TextView zhanghao,sex,nichen;
    private  String zh;
    private View fragment;
    private ImageView touxiang;



    public Fragment4() {

    }


    public static Fragment4 newInstance(String param1, String param2) {
        Fragment4 fragment = new Fragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_4, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fargemnt4).setPadding(0, getStatusBarHeight(),0, 0);
        zhanghao=view.findViewById(R.id.zhanghao);
        Bundle bundle=getArguments();
       zh=bundle.getString("one");
        zhanghao.setText("账号："+zh);
        sex=view.findViewById(R.id.sex);
        nichen=view.findViewById(R.id.nichen);
        fragment=view.findViewById(R.id.fargemnt4);
        fbtn2=view.findViewById(R.id.fragment4_button2);
        fbtn3=view.findViewById(R.id.fragment4_button3);
        fbtn4=view.findViewById(R.id.fragment4_button4);
        fbtn5=view.findViewById(R.id.fragment4_button5);

        touxiang=view.findViewById(R.id.touxiang);

//
        String url="http://192.168.253.1:8085/android/fragment4";
        RequestBody requestBody = new FormBody.Builder()
                .add("zhanghao", zh)
                .build();
        HttpPostRequest.okhttpPost(url, requestBody, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Toast.makeText(getContext(), "post请求失败", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();
                        Log.e("dwd", result);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                      sex.setText(jsonObject.optString("sex", null));
                    nichen.setText(jsonObject.optString("user_name", null));
                    }
                });

        button1=view.findViewById(R.id.quweixiaogongju);
        button2=view.findViewById(R.id.shezhi);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog  myaler = new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.d1)
                        .setTitle("更换背景")
                        .setMessage("更换背景图！")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                fragment.setBackgroundResource(R.drawable.login1);
                                fbtn2.setBackgroundColor(Color.YELLOW);
                                fbtn3.setBackgroundColor(Color.YELLOW);
                                fbtn4.setBackgroundColor(Color.YELLOW);
                                fbtn5.setBackgroundColor(Color.YELLOW);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                myaler.show();
            }
        });

touxiang.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
doTake();
    }
});

//
    }


    private void doTake() {
        Matisse.from(this)
                .choose(MimeType.ofImage(), false)
                .theme(com.zhihu.matisse.R.style.Matisse_Zhihu)
                .countable(true)
                .capture(true)
                .captureStrategy(new CaptureStrategy(
                        true,
                        "com.example.instantmusicvideotest.fragment",
                        ""/*"abc"*/))
                .maxSelectable(1)
                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.dp_72))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                .thumbnailScale(0.45f)
                .imageEngine(new GlideEngine())
                .setOnSelectedListener((uriList, pathList) -> {
                    Log.e("onSelected", "onSelected: pathList=" + pathList);
                })
                .showSingleMediaType(true)//true表示不能同时显示图片和视频
                .originalEnable(true)
                .maxOriginalSize(10)
                .autoHideToolbarOnSingleTap(true)
                .setOnCheckedListener(isChecked -> {
                    Log.e("isChecked", "onCheck: isChecked=" + isChecked);
                })
                .forResult(2);
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
}