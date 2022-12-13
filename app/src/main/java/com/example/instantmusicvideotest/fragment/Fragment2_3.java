package com.example.instantmusicvideotest.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.untis.HttpGetRequest;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Fragment2_3 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private String[] titiles = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] contents = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] addresses = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] images = {"http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response",
            "http://192.168.253.1:8085/img-response"
            , "http://192.168.253.1:8085/img-response"};
    MyAdapter mMyAdapter;
    RecyclerView mRecyclerView;
    private ImageView imageView;
    private Integer play=0;
    List<Xiaoshuo> mNewsList = new ArrayList<>();
    public Fragment2_3() {

    }


    public static Fragment2_3 newInstance(String param1, String param2) {
        Fragment2_3 fragment = new Fragment2_3();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment2_3, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = new ImageView(getContext());
        mRecyclerView = view.findViewById(R.id.xiaoshuo);
        getdata(); //初始化数据
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);

        mRecyclerView.setLayoutManager(gridLayoutManager);


        RefreshLayout refreshLayout = view.findViewById(R.id.xsrefreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                mNewsList.clear();
                getrefresh();
            }
        });

        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() { //加载更多
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                getmore();
                mMyAdapter.notifyDataSetChanged();
            }
        });


    }


    class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

        @NonNull
        @Override
        public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(getContext(), R.layout.item_manhua_list, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, @SuppressLint("RecyclerView") final int position) {
           Xiaoshuo xiaoshuo= mNewsList.get(position);
            holder.mTitleTv.setText(xiaoshuo.title);
            holder.mTitleTv2.setText(xiaoshuo.content);
            holder.mContent.setBackground(xiaoshuo.image.getBackground());
            Picasso.with(getContext()).load(xiaoshuo.imageurl)
                    .tag("RecyclerView") //参数为 Object
                    .into(holder.mContent);
            holder.mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse(xiaoshuo.address);
                    startActivity(new Intent(Intent.ACTION_VIEW,uri));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }

    class MyViewHoder extends RecyclerView.ViewHolder {
        TextView mTitleTv;
        TextView mTitleTv2;
        ImageView mContent;
        LinearLayout mRootView;
        String imgeurl;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.textView1);
            mTitleTv2 = itemView.findViewById(R.id.textView2);
            mContent = itemView.findViewById(R.id.image);
            mRootView = itemView.findViewById(R.id.rootview);
        }
    }


    private void getdata() {
//获取数据
        String url = "http://192.168.253.1:8085/android/world/xiaoshuo";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String result = response.body().string();

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("title", null);
                        String content = jsonObject.optString("content", null);
                        String imagerurl = jsonObject.optString("xiaoshuo_image", null);
                        String address = jsonObject.optString("address", null);
                        addresses[i]=address;
                        contents[i]=content;
                        titiles[i] = title;
                        images[i] = imagerurl;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Message message = new Message();
                message.what = 0;
                handle.sendMessage(message);

            }
        });

//获取数据结束
    }


    private void getrefresh() {
//获取数据
        String url = "http://192.168.253.1:8085/android/world/xiaoshuo";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("title", null);
                        String content = jsonObject.optString("content", null);
                        String imagerurl = jsonObject.optString("xiaoshuo_image", null);
                        contents[i]=content;
                        titiles[i] = title;
                        images[i] = imagerurl;
                        titiles[i] = title;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 0;
                handle.sendMessage(message);

            }
        });

//获取数据结束
    }

    private void getmore() {
        play = play + 9;
        String url = "http://192.168.253.1:8085/android/world/xiaoshuo";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                try {
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = play; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("title", null);
                        titiles[i - play] = title;
                        String content = jsonObject.optString("content", null);
                        String imagerurl = jsonObject.optString("xiaoshuo_image", null);
                        String address = jsonObject.optString("address", null);
                        addresses[i-play]=address;
                        contents[i-play]=content;
                        images[i-play] = imagerurl;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 0;
                handle.sendMessage(message);

            }
        });

//获取数据结束
    }

    //在消息队列中实现对控件的更改

    private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    for (int i = 0; i < 9; i++) {
                       Xiaoshuo xiaoshuo=new Xiaoshuo();
                        xiaoshuo.title = titiles[i];
                        xiaoshuo.content=contents[i];
                        xiaoshuo.image = imageView;
                        xiaoshuo.imageurl = images[i];
                        xiaoshuo.address=addresses[i];
                        mNewsList.add(xiaoshuo);
                    }
                    mMyAdapter.notifyDataSetChanged();
                    break;


            }


        }

        ;
    };

}