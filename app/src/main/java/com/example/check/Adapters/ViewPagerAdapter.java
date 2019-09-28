package com.example.check.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter  extends FragmentPagerAdapter {
    private final List<Fragment> lastFragment = new ArrayList<>();
    private final List<String> lastTitles = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lastFragment.get(position);
    }

    @Override
    public int getCount() {
        return lastTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lastTitles.get(position);
    }

    public void AddFragment (Fragment fragment, String title){
        lastFragment.add(fragment);
        lastTitles.add(title);



    }


}
