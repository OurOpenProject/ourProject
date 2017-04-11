package com.ourproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ourproject.R;
import com.ourproject.ui.lh.fragment.FoodFragment;
import com.ourproject.ui.lh.fragment.HealthFragment;
import com.ourproject.ui.lh.adapter.LHPagerAdapter;

import java.util.ArrayList;


/**
 * Created by admin on 2017/4/10.
 */

public class Fragment_food_class extends Fragment {
    private View lh;
    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<Fragment> data;
    private ArrayList<String> title_data;
    private LHPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lh = inflater.inflate(R.layout.fragment_class,container,false);
        initView();
        initData();
        return lh;
    }
    private void initView() {
        tab = (TabLayout) lh.findViewById(R.id.fragment_class_tab);
        tab.setTabMode(TabLayout.MODE_FIXED);
        pager = (ViewPager) lh.findViewById(R.id.fragment_class_pager);
//        tab.addTab(tab.newTab().setText("美食IP"));
//        tab.addTab(tab.newTab().setText("健康IP"));



    }
    private void initData() {
        FoodFragment food = new FoodFragment();
        HealthFragment health = new HealthFragment();
        data = new ArrayList<>();
        data.add(food);
        data.add(health);
        title_data = new ArrayList<>();
        title_data.add("美食IP");
        title_data.add("健康IP");
        adapter = new LHPagerAdapter(getChildFragmentManager(),data,title_data);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);

    }
}
