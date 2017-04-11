package com.ourproject.ui.lh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class LHPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> title_data;
    public LHPagerAdapter(FragmentManager fm, List<Fragment> data,List<String> title_data) {
        super(fm);
        this.data=data;
        this.title_data=title_data;

    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_data.get(position);
    }
}
