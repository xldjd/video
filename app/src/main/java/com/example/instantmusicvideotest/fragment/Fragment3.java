package com.example.instantmusicvideotest.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instantmusicvideotest.LoginActivity;
import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.untis.HttpGetRequest;
import com.example.instantmusicvideotest.untis.HttpPostRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Fragment3 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText message_text;
    private Button message_btn;
    private SmartRefreshLayout smartRefreshLayout;
    RecyclerView mRecyclerView;
   MyAdapter mMyAdapter;
   private Integer x;
    private  String[]types={};
  List<Gonggao> gonggaolist=new  ArrayList<>();
  private  String[] gongaoes={};
    public Fragment3() {

    }


    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
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

        return inflater.inflate(R.layout.fragment_3, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fargemnt3).setPadding(0, getStatusBarHeight(),0, 0);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        message_text=view.findViewById(R.id.message_text);
        message_btn=view.findViewById(R.id.message_btn);
        smartRefreshLayout=view.findViewById(R.id.refreshLayout);
        getdata(); //初始化数据
        mMyAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mMyAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              gonggaolist.clear();
              mRecyclerView.removeAllViews();
types=null;
gongaoes=null;
                String messgaek;
                String url = "http://192.168.253.1:8085/android/kml";
                RequestBody requestBody = new FormBody.Builder()
                        .add("message",message_text.getText().toString())
                        .build();
                HttpPostRequest.okhttpPost(url, requestBody, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Looper.prepare();
                        Looper.loop();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Looper.prepare();
                        //
                        Message message = new Message();
                        message.what = 2;
                        handle.sendMessage(message);
                        Looper.loop();
                    }
                });
            }
        });

smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        gonggaolist.clear();
        mRecyclerView.removeAllViews();
        types=null;
        gongaoes=null;
        getdata();
    }
});
    }



    private void getdata() {


//获取数据
        String url = "http://192.168.253.1:8085/android/world/gonggao";
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
                    for (int i = 0; i < jsonArray.length()+1; i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String content = jsonObject.optString("content", null);
                        String type=jsonObject.optString("type",null);
                       types=insert(types,type);
                      gongaoes=insert(gongaoes,content);
                    }
                    Log.e("接收公告",result);
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



    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //
            RecyclerView.ViewHolder myViewHoder=null;
            if (viewType == 1) {
                //指定要加载的布局
                View view1 = View.inflate(getContext(), R.layout.message_list, null);
                 myViewHoder = new MyViewHoder1(view1);
            } else if (viewType == 2) {
                //指定要加载的另一个布局
                View view2 = View.inflate(getContext(), R.layout.message2_list, null);
                 myViewHoder = new MyViewHoder2(view2);
            }
            return  myViewHoder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Gonggao gonggao=gonggaolist.get(position);
           if (holder instanceof MyViewHoder1)
           {
((MyViewHoder1) holder).content.setText(gonggao.content);

           }
           else if(holder instanceof MyViewHoder2)
           {
((MyViewHoder2) holder).content.setText(gonggao.content);
           }
        }



        @Override
        public int getItemCount() {

            return gonggaolist.size();
        }

        @Override
        public int getItemViewType(int position) {

            String t1="1",t2="2",t;
            t=gonggaolist.get(position).type.toString();
            if(t.equals(t1)){
                return 1;
            }else if(t.equals(t2)){
                return 2;
            }
            else
                Log.e("出错",t);
                return 1;

        }



    }

private     class MyViewHoder1 extends RecyclerView.ViewHolder {

        LinearLayout mRootView;;
       TextView content;

        public MyViewHoder1(@NonNull View itemView) {
            super(itemView);
            mRootView = itemView.findViewById(R.id.message1);
            content=itemView.findViewById(R.id.message_content);
        }
    }

 private    class MyViewHoder2 extends RecyclerView.ViewHolder {

       FrameLayout mRootView;;
        TextView content;

        public MyViewHoder2(@NonNull View itemView) {
            super(itemView);
            mRootView = itemView.findViewById(R.id.message2);
            content=itemView.findViewById(R.id.message_content2);
        }
    }







    private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    for (int i = 0; i <gongaoes.length; i++) {
                      Gonggao gonggao=new Gonggao();
                      gonggao.content=gongaoes[i];
                      gonggao.type=types[i];
                      gonggaolist.add(gonggao);
                    }
                    mMyAdapter.notifyDataSetChanged();
                    break;
                case 2:

                    getdata();

            }


        };
    };



    private static String[] insert(String[] strings, String string) {
        if (strings == null) {
            strings = new String[0];
        }
        if (string.isEmpty()) {
            Log.e("插入错误","Empty string.");
            return null;
        }
        String[] resultString = new String[strings.length + 1];
        for (int i = 0; i < strings.length; i++) {
            resultString[i] = strings[i];
        }
        resultString[strings.length] = string;
        return resultString;
    }





    public int getStatusBarHeight() {
        int result = 0;

        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }











}