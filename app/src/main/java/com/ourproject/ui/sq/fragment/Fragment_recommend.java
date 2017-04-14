package com.ourproject.ui.sq.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseFragment;
import com.ourproject.ui.sq.adapter.RecommendAdapter;
import com.ourproject.ui.sq.bean.SqBean;
import com.ourproject.ui.sq.contract.RecommendContract;
import com.ourproject.ui.sq.model.RecommendModel;
import com.ourproject.ui.sq.presenter.RecommendPresenter;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/10.
 */

public class Fragment_recommend extends BaseFragment<RecommendPresenter, RecommendModel> implements RecommendContract.MyView {
    @BindView(R2.id.recommend_recycler)
    RecyclerView recommend_recycler;
    RecommendAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;

    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getSqList();
    }

    @Override
    public void initView() {
        adapter = new RecommendAdapter(getActivity(), null);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recommend_recycler.setLayoutManager(manager);
        recommend_recycler.setAdapter(adapter);
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
    public void returnSqBean(SqBean sqBean) {
        adapter.addRes(sqBean);
    }
}
