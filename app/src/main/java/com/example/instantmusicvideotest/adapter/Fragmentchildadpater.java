package com.example.instantmusicvideotest.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class Fragmentchildadpater extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    private List<String> mtitles;
    public Fragmentchildadpater(@NonNull FragmentManager fm, List<Fragment> fragmentList, List<String> mtitles) {
        super(fm);
        this.fragmentList=fragmentList;
        this.mtitles=mtitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList==null ? null:fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null ? 0 :fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles==null ?"":mtitles.get(position);
    }
}
