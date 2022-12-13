package com.example.instantmusicvideotest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.instantmusicvideotest.R;
import com.example.instantmusicvideotest.adapter.Fragmentchildadpater;
import com.example.instantmusicvideotest.adapter.ViewPagerAdapter;
import com.example.instantmusicvideotest.entity.ShortVideoInfo;
import com.example.instantmusicvideotest.holder.RecyclerItemNormalHolder;
import com.example.instantmusicvideotest.untis.DemoEvent;
import com.google.android.material.tabs.TabLayout;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Fragment1 extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private ViewPager mview;
    private List<Fragment> fragmentList;
    private TabLayout mtablayout;
    private  List<String> mtitls;
    private Fragmentchildadpater fragmentchildadpater;
    private  int selected;


    public Fragment1() {
    }
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      view.findViewById(R.id.fargemnt1).setPadding(0, getStatusBarHeight(), 0, 0);
        mview=view.findViewById(R.id.mViewPager);
        mtablayout=view.findViewById(R.id.mtablayout);
        ininData();
        fragmentchildadpater = new Fragmentchildadpater(getChildFragmentManager(),fragmentList,mtitls);
        mview.setAdapter(fragmentchildadpater);
        mtablayout.setupWithViewPager(mview);
        mview.setOffscreenPageLimit(4);
      mview.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

          }

          @Override
          public void onPageSelected(int position) {
selected=position;
if (selected!=0)
{
    //发送消息，参数为自己定义的事件类
    EventBus.getDefault().post(
            new DemoEvent("fragment1_1nuselected"));
}
else
{
    EventBus.getDefault().post(
            new DemoEvent("fragment1_1selected"));
}
          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });



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
        fragmentList.add(new Fragment1_1());
        fragmentList.add(new Fragment1_2());
        fragmentList.add(new Fragment1_3());
        fragmentList.add(new Fragment1_4());
        mtitls=new ArrayList<String>();
        mtitls.add("共青城市");
        mtitls.add("关注");
        mtitls.add("推荐");
        mtitls.add("好友");
    }

}
