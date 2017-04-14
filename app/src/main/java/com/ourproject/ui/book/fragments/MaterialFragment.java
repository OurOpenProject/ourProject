package com.ourproject.ui.book.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.api.Api;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.adapters.MaterialAdapter;
import com.ourproject.ui.book.bean.material.MaterialSubtypeBean;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by YC on 2017/4/10.
 */

public class MaterialFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R2.id.m_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R2.id.m_recycler)
    RecyclerView mRecycler;
    private MaterialAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.frag_book_material, container, false);
        ButterKnife.bind(this,layout);

        adapter = new MaterialAdapter(getContext(), null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(adapter);

        initData(State.START);

        mRefresh.setOnRefreshListener(this);

        return layout;
    }

    @Override
    public void onRefresh() {
        initData(State.START);
    }

    enum State{
        START,END;
    }

    private void initData(State state) {
        ApiService apiService = Api.getApiService();
        HashMap<String, String> map = new HashMap<>();
        Call<MaterialSubtypeBean> materialSubtypeBean = apiService.getMaterialSubtypeBean(map);
        materialSubtypeBean.enqueue(new Callback<MaterialSubtypeBean>() {
            @Override
            public void onResponse(Call<MaterialSubtypeBean> call, Response<MaterialSubtypeBean> response) {
                MaterialSubtypeBean body = response.body();
                if (body.getMsg().equals("success")) {
                    adapter.updataRes(body.getData().getData());
                    if (mRefresh.isRefreshing()) {
                        mRefresh.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<MaterialSubtypeBean> call, Throwable t) {

            }
        });
    }

}
