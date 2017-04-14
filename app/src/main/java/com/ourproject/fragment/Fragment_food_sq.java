package com.ourproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.ui.sq.adapter.MyPageAdapter;
import com.ourproject.ui.sq.fragment.Fragment_recommend;
import com.ourproject.ui.sq.fragment.Frament_new;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2017/4/10.
 */

public class Fragment_food_sq extends Fragment implements ViewPager.OnPageChangeListener {
    @BindView(R2.id.recommend)
    TextView recommd;
    @BindView(R2.id.top_new)
    TextView top;
    @BindView(R2.id.page_indicator)
    View indicator;
    @BindView(R2.id.sq_vp)
    ViewPager sq_vp;
    View layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_sq, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment_recommend());
        fragments.add(new Frament_new());
        sq_vp.setAdapter(new MyPageAdapter(getChildFragmentManager(), fragments));
        sq_vp.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int width = indicator.getWidth();
        indicator.setTranslationX((position+positionOffset)*width);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick({R2.id.recommend, R2.id.top_new})
    public void click(TextView v) {
        switch (v.getId()) {
            case R.id.recommend:
                sq_vp.setCurrentItem(0);
                break;
            case R.id.top_new:
                sq_vp.setCurrentItem(1);
                break;
        }
    }

}
