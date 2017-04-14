package com.ourproject.ui.sq.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.orhanobut.logger.Logger;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseFragment;
import com.ourproject.ui.sq.adapter.ZXAdapter;
import com.ourproject.ui.sq.bean.ZXBean;
import com.ourproject.ui.sq.contract.ZXContract;
import com.ourproject.ui.sq.model.ZXModel;
import com.ourproject.ui.sq.presenter.ZXPresenter;

import butterknife.BindView;

/**
 * Created by admin on 2017/4/10.
 */

public class Frament_new extends BaseFragment<ZXPresenter, ZXModel> implements ZXContract.MyView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R2.id.zx_recycler)
    RecyclerView zx_recycler;
    @BindView(R2.id.swipe)
    SwipeRefreshLayout refreshLayout;
    ZXAdapter adapter;
    GridLayoutManager manager;
    public int page = 1;
    private static final int SIZE = 20;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zx;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
        mPresenter.getZXList("1", "20");
    }

    @Override
    public void initView() {
        refreshLayout.setOnRefreshListener(this);
        adapter = new ZXAdapter(null, getActivity());
        manager = new GridLayoutManager(getActivity(), 2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        zx_recycler.setLayoutManager(manager);
        zx_recycler.setAdapter(adapter);
        zx_recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (adapter.isHaveMore() && !refreshLayout.isRefreshing() && !adapter.isLoadMore() && manager.findLastVisibleItemPosition() == adapter.getItemCount() - 1) {
                    adapter.setLoadMore(true);
                    page++;
                    mPresenter.getZXList(String.valueOf(page), String.valueOf(SIZE));
                }
            }
        });
    }

    @Override
    public void returnZXBean(ZXBean zxBean) {
        if (zxBean.getData().getData() != null && zxBean.getData().getData().size() > 0) {
            if (adapter.isLoadMore() && adapter.isHaveMore()) {
                adapter.setLoadMore(false);
                if (zxBean.getData().getData().size() != SIZE) {
                    adapter.setLoadMore(true);
                    adapter.setHaveMore(false);
                }
                adapter.addRes(zxBean.getData().getData());
            } else {
                adapter.updateRes(zxBean.getData().getData());
                adapter.setHaveMore(true);
                adapter.setLoadMore(false);
                refreshLayout.setRefreshing(false);
            }
        } else {
            adapter.setLoadMore(true);
            adapter.setHaveMore(false);
            adapter.notifyDataSetChanged();
        }
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
    public void onRefresh() {
        page = 1;
        mPresenter.getZXList(String.valueOf(page), "20");
    }
}
