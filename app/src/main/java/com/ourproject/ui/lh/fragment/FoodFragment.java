package com.ourproject.ui.lh.fragment;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseFragment;
import com.ourproject.ui.lh.activity.FoodDetailActivity;
import com.ourproject.ui.lh.adapter.FoodAdapter;
import com.ourproject.ui.lh.bean.FoodBean;
import com.ourproject.ui.lh.callback.OnRecClickListener;
import com.ourproject.ui.lh.contract.FoodContract;
import com.ourproject.ui.lh.mode.FoodMode;
import com.ourproject.ui.lh.presenter.FoodPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/4/10 0010.
 */


public class FoodFragment extends BaseFragment<FoodPresenter,FoodMode> implements FoodContract.FoodView, SwipeRefreshLayout.OnRefreshListener, OnRecClickListener {
    int page=1;
    int count=20;

    @BindView(R2.id.fragment_food_rec)
    RecyclerView rec;
    @BindView(R2.id.fragment_food_swi)
    SwipeRefreshLayout swip;
    private FoodAdapter adapter;
    private List<FoodBean.DataBeanX.DataBean> data;
    private boolean isLoad;
    private LinearLayoutManager manager;

    @Override
    protected int getLayoutId() {
        Log.e("1024", "getLayoutId: " );
        return R.layout.fragment_food;
    }

    @Override
    public void initPresenter() {
        Log.e("1024", "initPresenter: " );
        mPresenter.setVM(this,mModel);
        mPresenter.getFoodBeanList(page,count);
    }

    @Override
    public void initView() {
        Log.e("1024", "initView: " );
        adapter = new FoodAdapter(null,getActivity());
        adapter.setOnRecClickListener(this);
        manager = new LinearLayoutManager(getActivity());
        swip.setOnRefreshListener(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(manager);
        rec.setAdapter(adapter);
        rec.addOnScrollListener(new OnScrollListener() {


            private int lastVisibleItemPosition;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
               if(newState==RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition==adapter.getItemCount()-1){
                   mPresenter.getFoodBeanList(++page,20);
                   isLoad=true;
               }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                manager.findLastVisibleItemPosition();
                lastVisibleItemPosition = manager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {
        Log.e("error", "onError: "+errorInfo );
    }

    @Override
    public void returnFoodBeanList(FoodBean foodBean) {
        Log.e("FoodBean", "returnFoodBeanList: "+foodBean.getData().getData().size() );
        data = foodBean.getData().getData();
        if (isLoad) {
            adapter.addData(data);

        }else{
            adapter.updateRes(data);
            swip.setRefreshing(false);
        }


    }

    @Override
    public void onRefresh() {
        mPresenter.getFoodBeanList(0,count);
        isLoad=false;
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, int position) {
        FoodBean.DataBeanX.DataBean item = adapter.getItem(position);
        int series_id = item.getSeries_id();
        Intent intent=new Intent(getActivity(),FoodDetailActivity.class);
        intent.putExtra("series_id",series_id);
        Log.e("点击事件传过去的值", "onItemClick: "+series_id );
        startActivity(intent);
    }
}
