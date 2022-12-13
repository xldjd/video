package com.example.instantmusicvideotest.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentstateVPadapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public FragmentstateVPadapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList == null ? null:mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? null:mFragmentList.size();
    }
}
