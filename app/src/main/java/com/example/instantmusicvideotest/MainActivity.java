package com.example.instantmusicvideotest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.instantmusicvideotest.adapter.FragmentstateVPadapter;
import com.example.instantmusicvideotest.adapter.ViewPagerAdapter;
import com.example.instantmusicvideotest.entity.ShortVideoInfo;
import com.example.instantmusicvideotest.fragment.Fragment1;
import com.example.instantmusicvideotest.fragment.Fragment2;
import com.example.instantmusicvideotest.fragment.Fragment3;
import com.example.instantmusicvideotest.fragment.Fragment4;
import com.example.instantmusicvideotest.untis.DemoEvent;
import com.example.instantmusicvideotest.untis.NoScrollViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private NoScrollViewPager mviewpager;
    private BottomNavigationView bottomNavigationView;
    private FragmentstateVPadapter fragmentstateVPadapter;
    private List<Fragment> fragmentList;
    private  String zhanghao;

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        transparentStatusBar(getWindow());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        //正式代码开始
        mviewpager = findViewById(R.id.mainviewpager);
        mviewpager.setScrollable(false);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        inindata();
        fragmentstateVPadapter = new FragmentstateVPadapter(getSupportFragmentManager(), fragmentList);
        mviewpager.setAdapter(fragmentstateVPadapter);
        mviewpager.setOffscreenPageLimit(5);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fargemnt1:
                        mviewpager.setCurrentItem(0);
                        //发送消息，参数为自己定义的事件类
                        EventBus.getDefault().post(
                                new DemoEvent("fragment1_selected"));
                        break;
                    case R.id.fargemnt2:
                        mviewpager.setCurrentItem(1);
                        //发送消息，参数为自己定义的事件类
                        EventBus.getDefault().post(
                                new DemoEvent("fragment1_unselected"));
                        break;
//                    case R.id.fargemnt3:
//                        Intent intent=new Intent(MainActivity.this,ShangchuangActivity.class);
//                        startActivity(intent);
//                        //发送消息，参数为自己定义的事件类
//                        EventBus.getDefault().post(
//                                new DemoEvent("fragment1_unselected"));
//                        break;
                    case R.id.fargemnt4:
                        mviewpager.setCurrentItem(2);
                        //发送消息，参数为自己定义的事件类
                        EventBus.getDefault().post(
                                new DemoEvent("fragment1_unselected"));
                        break;
                    case R.id.fargemnt5:
                        mviewpager.setCurrentItem(3);
                        //发送消息，参数为自己定义的事件类
                        EventBus.getDefault().post(
                                new DemoEvent("fragment1_unselected"));
                        break;
                }
                return true;
            }
        });

        Intent  intent = getIntent();
   zhanghao= intent.getStringExtra("zhanghao");

        Bundle bundle=new Bundle();
        bundle.putString("one",zhanghao);
        fragmentList.set(3, fragmentList.get(3)).setArguments(bundle);

    }

    private void inindata() {
        fragmentList = new ArrayList<Fragment>();  //3.1 先实例化列表对象
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());

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


    @Subscribe
    public void onEventMainThread(DemoEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
}
}