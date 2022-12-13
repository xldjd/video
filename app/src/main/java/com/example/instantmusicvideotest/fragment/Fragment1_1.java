package com.example.instantmusicvideotest.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instantmusicvideotest.LoginActivity;
import com.example.instantmusicvideotest.MainActivity;
import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.adapter.ViewPagerAdapter;
import com.example.instantmusicvideotest.entity.ShortVideoInfo;
import com.example.instantmusicvideotest.holder.RecyclerItemNormalHolder;
import com.example.instantmusicvideotest.untis.DemoEvent;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment1_1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    @BindView(R.id.view_pager2)
    ViewPager2 viewPager2;
    private List<ShortVideoInfo> mList = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;
private  Boolean selected=true;


    public Fragment1_1() {

    }


    public static Fragment1_1 newInstance(String param1, String param2) {
        Fragment1_1 fragment = new Fragment1_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);//注册EventBus
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//取消注册EventBus
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment1_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager2=view.findViewById(R.id.view_pager2);
        ButterKnife.bind((Activity) getContext());
        getData();

    }

    private void getData() {

        setData();
        viewPagerAdapter = new ViewPagerAdapter(getActivity(), mList);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setAdapter(viewPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // 大于0说明有播放
                int playPosition = GSYVideoManager.instance().getPlayPosition();
                if (playPosition >= 0) {
                    // 对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(RecyclerItemNormalHolder.TAG)
                            && (position != playPosition)) {
                        playPosition(position);
                    }
                }
            }
        });
        viewPager2.post(new Runnable() {
            @Override
            public void run() {
                playPosition(0);
            }
        });

    }

    private void playPosition(int position) {
        RecyclerView.ViewHolder viewHolder = ((RecyclerView) viewPager2.getChildAt(0)).findViewHolderForAdapterPosition(position);
        if (viewHolder != null) {
            RecyclerItemNormalHolder recyclerItemNormalHolder = (RecyclerItemNormalHolder) viewHolder;
            recyclerItemNormalHolder.getPlayer().startPlayLogic();
        }
    }

    /**
     * 模拟数据
     */
    private void setData() {



        ShortVideoInfo data1= new ShortVideoInfo();
        data1.setTextContent("蜂鸟计划 中国预告片：速度与金钱版 (中文字幕)");
        data1.setVideoCover("https://img3.doubanio.com/img/trailer/medium/2631410731.jpg?1611566097");
        data1.setVideoUrl("https://vt1.doubanio.com/202102020903/722442386dcd5076fd70c4ac2bf093bb/view/movie/M/402710160.mp4");
        mList.add(data1);

        ShortVideoInfo data2= new ShortVideoInfo();
        data2.setTextContent("旺达幻视 预告片");
        data2.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2628042057.jpg?");
        data2.setVideoUrl("https://vt1.doubanio.com/202102011621/94e560ba4d88c562e0768f6339822d99/view/movie/M/402690624.mp4");
        mList.add(data2);

        ShortVideoInfo data3 = new ShortVideoInfo();
        data3.setTextContent("无耻之徒(美版) 第十一季 预告片");
        data3.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2626877508.jpg?");
        data3.setVideoUrl("https://vt1.doubanio.com/202102020903/722442386dcd5076fd70c4ac2bf093bb/view/movie/M/402710160.mp4");
        mList.add(data3);

        ShortVideoInfo data4 = new ShortVideoInfo();
        data4.setTextContent("发现女巫 第二季 预告片");
        data4.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2626877508.jpg?");
        data4.setVideoUrl("https://vt1.doubanio.com/202102020903/722442386dcd5076fd70c4ac2bf093bb/view/movie/M/402710160.mp4");
        mList.add(data4);

        ShortVideoInfo data5 = new ShortVideoInfo();
        data5.setTextContent("天国与地狱 预告片");
        data5.setVideoCover("https://img1.doubanio.com/img/trailer/medium/2626877508.jpg?");
        data5.setVideoUrl("https://prod-streaming-video-msn-com.akamaized.net/ba258271-89c7-47bc-9742-bcae67c23202/f7ff4fe4-1346-47bb-9466-3f4662c1ac3a.mp4");
        mList.add(data5);

    }

    @Subscribe
    public void onEventMainThread(DemoEvent event) {

        String msg = "接收消息   " + event.getMsg();
        System.out.println(msg);
if (event.getMsg().equals("fragment1_1nuselected")) {
    Message message = new Message();
    message.what = 1;
    handler.sendMessage(message);
}
else if(event.getMsg().equals("fragment1_1selected"))
{

    Message message2 = new Message();
    message2.what = 2;
    handler.sendMessage(message2);
}
else if(event.getMsg().equals("fragment1_unselected"))
{

    Message message3 = new Message();
    message3.what = 3;
    handler.sendMessage(message3);
}
else if(event.getMsg().equals("fragment1_selected"))
{
    Message message4 = new Message();
    message4.what = 4;
    handler.sendMessage(message4);
}

    }


    private Handler handler=new Handler(Looper.myLooper()){
        public void handleMessage(Message message){
            switch (message.what){
                case 1:
                    selected=false;
                    GSYVideoManager.onPause();
                    break;
                case 2:
                    selected=true;
                    GSYVideoManager.onResume();
                    break;
                case 3:
                    GSYVideoManager.onPause();
                    break;
                case 4:
                    if(selected==true)
                        GSYVideoManager.onResume();
                    break;
            }
            super.handleMessage(message);
        }
    };

}