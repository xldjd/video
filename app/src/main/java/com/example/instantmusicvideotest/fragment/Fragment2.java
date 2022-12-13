package com.example.instantmusicvideotest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.adapter.Fragmentchildadpater;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private ViewPager mview;
    private List<Fragment> fragmentList;
    private TabLayout mtablayout;
    private  List<String> mtitls;
    private Fragmentchildadpater fragmentchildadpater;

    public Fragment2() {

    }


    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.fargemnt2).setPadding(0, getStatusBarHeight(),0, 0);
        mview=view.findViewById(R.id.mViewPager);
        mtablayout=view.findViewById(R.id.mtablayout);
        ininData();
        fragmentchildadpater = new Fragmentchildadpater(getChildFragmentManager(),fragmentList,mtitls);
        mview.setAdapter(fragmentchildadpater);
        mtablayout.setupWithViewPager(mview);
        mview.setOffscreenPageLimit(3);



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

    private void ininData() {
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new Fragment2_1());
        fragmentList.add(new Fragment2_2());
        fragmentList.add(new Fragment2_3());
        mtitls=new ArrayList<String>();
        mtitls.add("趣味视频");
        mtitls.add("趣味漫画");
        mtitls.add("趣味小说");
    }
}