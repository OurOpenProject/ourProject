package com.ourproject.ui.sq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseActivity;
import com.ourproject.ui.sq.adapter.DaRenPageAdapter;
import com.ourproject.ui.sq.bean.DRBean;
import com.ourproject.ui.sq.contract.DRContract;
import com.ourproject.ui.sq.fragment.Fragment_fs;
import com.ourproject.ui.sq.fragment.Fragment_zp;
import com.ourproject.ui.sq.model.DRModel;
import com.ourproject.ui.sq.presenter.DRPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class DaRenActivity extends BaseActivity<DRPresenter, DRModel> implements DRContract.MyView {
    @BindView(R2.id.dr_vp)
    ViewPager dr_vp;
    @BindView(R2.id.toolBar)
    Toolbar toolBar;
    @BindView(R2.id.background)
    ImageView background;
    @BindView(R2.id.nick_name)
    TextView nick_name;
    @BindView(R2.id.declaration)
    TextView declaration;
    ActionBar actionBar;
    @BindView(R2.id.ctl)
    CollapsingToolbarLayout ctl;
    @BindView(R2.id.dr_tab)
    TabLayout dr_tab;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dr_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        mPresenter.getDRBean(userId);
        setSupportActionBar(toolBar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        List<Fragment> fragments = new ArrayList<>();
        Fragment_zp zp = new Fragment_zp();
        Bundle b = new Bundle();
        b.putString("userId", userId);
        zp.setArguments(b);
        fragments.add(zp);
        Fragment_fs fs = new Fragment_fs();
        fs.setArguments(b);
        fragments.add(fs);
        List<String> titles = new ArrayList<>();
        titles.add("作品");
        titles.add("粉丝");
        dr_vp.setAdapter(new DaRenPageAdapter(getSupportFragmentManager(), fragments, titles));
        dr_tab.setupWithViewPager(dr_vp);

    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnDRBean(DRBean drBean) {
        Glide.with(this).load(drBean.getData().getBackground()).into(background);
        nick_name.setText(drBean.getData().getNickname());
        declaration.setText(drBean.getData().getDeclaration());
        //ctl.setTitle(drBean.getData().getNickname());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
