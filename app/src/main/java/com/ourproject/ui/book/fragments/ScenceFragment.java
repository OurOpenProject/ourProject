package com.ourproject.ui.book.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.api.Api;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.adapters.ScenceAdapter;
import com.ourproject.ui.book.bean.scencehome.ScenceHomeBean;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YC on 2017/4/10.
 */

public class ScenceFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = ScenceFragment.class.getSimpleName();
    @BindView(R2.id.scence_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R2.id.scence_recycler)
    RecyclerView mRecycler;
    private ScenceAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.frag_book_scence, container, false);
        ButterKnife.bind(this,layout);

        adapter = new ScenceAdapter(getContext(), null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), 1, false);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(adapter);

        mRefresh.setOnRefreshListener(this);

        initData(State.START);

        return layout;
    }
    // ================== SwipeRefreshLayout.OnRefreshListener  ====================================
    @Override
    public void onRefresh() {
        initData(State.START);
    }

    enum State{
        START,END;
    }

    public void initData(State state){
        ApiService apiService = Api.getApiService();
        HashMap<String, String> map = new HashMap<>();
        Call<ScenceHomeBean> scenceHomeBean = apiService.getScenceHomeBean(map);
        scenceHomeBean.enqueue(new Callback<ScenceHomeBean>() {
            @Override
            public void onResponse(Call<ScenceHomeBean> call, Response<ScenceHomeBean> response) {
                ScenceHomeBean body = response.body();
                if (body.isMsg()) {
                    adapter.updataRes(body.getData());
                    if (mRefresh.isRefreshing()) {
                        mRefresh.setRefreshing(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<ScenceHomeBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });


    }
}
