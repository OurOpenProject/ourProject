package com.ourproject.ui.book.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class BookPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager fm;
    private List<Fragment> fragments;
    private List<String> titles;

    public BookPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
