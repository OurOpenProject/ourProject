package com.ourproject.ui.book.fragments.scencebanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ourproject.R;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.comment_list.CommentListBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YC on 2017/4/13.
 */

public class CommentListFragment extends Fragment {

    private static final String TAG = CommentListFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.banner_commentlist, container, false);


        return layout;
    }
    enum State{
        START,END;
    }
    public void setRelateId(String relateId){
        this.relateId = relateId;
    }
    private int page = 1;
    private String relateId;
    private void initDate(State state,int page) {
        //4.评论数据源
        // http://api.izhangchu.com/?version=4.40&methodName=CommentList&type=2&page=1&size=20&relate_id=163

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.izhangchu.com")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("methodName","CommentList");
        map.put("type","2");
        map.put("size","20");
        map.put("page",page + "");
        map.put("relate_id",relateId);
        Call<CommentListBean> commentListBean = apiService.getCommentListBean(map);
        commentListBean.enqueue(new Callback<CommentListBean>() {
            @Override
            public void onResponse(Call<CommentListBean> call, Response<CommentListBean> response) {

            }

            @Override
            public void onFailure(Call<CommentListBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });

    }
}
