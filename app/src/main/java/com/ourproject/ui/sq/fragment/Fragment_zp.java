package com.ourproject.ui.sq.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseFragment;
import com.ourproject.ui.sq.adapter.ZPAdapter;
import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.ui.sq.contract.ZPContract;
import com.ourproject.ui.sq.model.ZPModel;
import com.ourproject.ui.sq.presenter.ZPPresenter;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/11.
 */

public class Fragment_zp extends BaseFragment<ZPPresenter, ZPModel> implements ZPContract.MyView {
    @BindView(R2.id.zp_recycler)
    RecyclerView zp_recycler;
    ZPAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.zp_recyclerview;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        String userId = bundle.getString("userId");
        mPresenter.getZPBean(userId, "1", "20");
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        zp_recycler.setLayoutManager(manager);
        adapter = new ZPAdapter(null, getActivity());
        zp_recycler.setAdapter(adapter);

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
    public void returnZPBean(ZPBean zpBean) {
        adapter.addRes(zpBean);
    }
}
