package com.example.instantmusicvideotest.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Toast;
import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.VideoActivity;
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


public class Fragment2_1 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static Bitmap bz;


    private String mParam1;
    private String mParam2;
    private String[] titiles = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] addresses = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] images={"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response"
            ,"http://192.168.253.1:8085/img-response",
            "http://192.168.253.1:8085/img-response"
    , "http://192.168.253.1:8085/img-response"};
    RecyclerView mRecyclerView;
    MyAdapter mMyAdapter;
    private ImageView imageView;
    private Integer play=0;
    List<News> mNewsList = new ArrayList<>();

    public Fragment2_1() {
    }


    public static Fragment2_1 newInstance(String param1, String param2) {
        Fragment2_1 fragment = new Fragment2_1();
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
        return inflater.inflate(R.layout.fragment_fragment2_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = new ImageView(getContext());
        mRecyclerView = view.findViewById(R.id.recyclerview);
        getdata(); //初始化数据
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int postion) {
                if (postion % 9 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });


        mRecyclerView.setLayoutManager(gridLayoutManager);


        RefreshLayout refreshLayout = view.findViewById(R.id.refreshLayout);
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
            View view = View.inflate(getContext(), R.layout.item_list, null);
            MyViewHoder myViewHoder = new MyViewHoder(view);
            return myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHoder holder, @SuppressLint("RecyclerView") final int position) {
            News news = mNewsList.get(position);
            holder.mTitleTv.setText(news.title);
            holder.mContent.setBackground(news.content.getBackground());
            holder.address=news.address;
            Picasso.with(getContext()).load(news.imageurl)
                    .tag("RecyclerView") //参数为 Object
                    .into(holder.mContent);
            holder.mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(), VideoActivity.class);
                    //将text框中的值传入
                    intent.putExtra("title",news.title);
                    intent.putExtra("video",news.address);
                    //为了接受SecondActivity中的值，不用startAcitivity(intent)
                    startActivityForResult(intent,1000);

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
        ImageView mContent;
        LinearLayout mRootView;
        String imgeurl;
        String address;

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.textView);
            mContent = itemView.findViewById(R.id.image);
            mRootView = itemView.findViewById(R.id.rootview);
        }
    }





    private void getdata() {
//获取数据
        String url = "http://192.168.253.1:8085/android/world/users";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String result = response.body().string();

                try{
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject     jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("video_name", null);
                        String imagerurl=jsonObject.optString("video_image",null);
                        String address=jsonObject.optString("video_address",null);
                        titiles[i]=title;
                        images[i]=imagerurl;
                        addresses[i]=address;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Message message=new Message();
                    message.what=0;
                    handle.sendMessage(message);

            }
        });

//获取数据结束
    }


    private void getrefresh() {
//获取数据
        String url = "http://192.168.253.1:8085/android/world/users";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                try{
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject     jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("video_name", null);
                        titiles[i]=title;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message message=new Message();
                message.what=0;
                handle.sendMessage(message);

            }
        });

//获取数据结束
    }

    private void getmore() {
        play=play+9;
        String url = "http://192.168.253.1:8085/android/world/users";
        RequestBody requestBody = new FormBody.Builder().build();
        HttpGetRequest.sendOkHttpGetRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();

                try{
                    JSONArray jsonArray = new JSONArray(result);
                    for (int i = play; i < jsonArray.length(); i++) {
                        JSONObject     jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.optString("video_name", null);
                        titiles[i-play]=title;
                        String imagerurl=jsonObject.optString("video_image",null);
                        images[i-play]=imagerurl;
                        String address=jsonObject.optString("video_address",null);
                        addresses[i-play]=address;
                    }
                    System.out.println(jsonArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Message message=new Message();
                message.what=0;
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
                        News news = new News();
                        news.title = titiles[i];
                     news.content=imageView;
                     news.imageurl=images[i];
                     news.address=addresses[i];
                        mNewsList.add(news);
                    }
                    mMyAdapter.notifyDataSetChanged();
                    break;


            }


        };
    };

}

