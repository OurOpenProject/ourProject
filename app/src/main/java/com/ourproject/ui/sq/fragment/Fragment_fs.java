package com.ourproject.ui.sq.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseFragment;
import com.ourproject.ui.sq.adapter.FsAdapter;
import com.ourproject.ui.sq.bean.FSBean;
import com.ourproject.ui.sq.contract.FSContract;
import com.ourproject.ui.sq.model.FSModel;
import com.ourproject.ui.sq.presenter.FSPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/11.
 */

public class Fragment_fs extends BaseFragment<FSPresenter, FSModel> implements FSContract.MyView {
    @BindView(R2.id.drfs_recycler)
    RecyclerView drfs_recycler;
    FsAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.daren_fs;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        String userId = bundle.getString("userId");
        Log.e("ee", "initView: "+userId);
        mPresenter.getFSBean(userId, "1", "20");
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        drfs_recycler.setLayoutManager(manager);
        adapter = new FsAdapter(null, getActivity());
        drfs_recycler.setAdapter(adapter);

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
    public void returnFSBean(FSBean bean) {
        List<FSBean.DataBeanX.DataBean> data = bean.getData().getData();
        adapter.addRes(data);

    }
}
