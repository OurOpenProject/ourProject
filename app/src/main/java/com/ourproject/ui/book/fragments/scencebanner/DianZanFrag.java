package com.ourproject.ui.book.fragments.scencebanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.adapters.scence.banner.DianZanGridAdapter;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan.DianZanBean;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YC on 2017/4/12.
 */

public class DianZanFrag extends Fragment {
    public static final String TAG = DianZanFrag.class.getSimpleName();
    @BindView(R2.id.banner_dianzan_count)
    TextView mDianZanCount;
    @BindView(R2.id.banner_dianzan_image)
    ImageView mDianZanImg;
    @BindView(R2.id.banner_dianzan_list_user)
    GridView mGrid;
    private DianZanGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.banner_dianzanlist, container, false);
        ButterKnife.bind(this,layout);

        adapter = new DianZanGridAdapter(getContext(), null);
        mGrid.setAdapter(adapter);

        return layout;
    }

    public void setSeriesId(String seriesId){
        initDate(seriesId,page);
    }

    private int page = 1;
    public void initDate(String seriesId,int page){
        // http://api.izhangchu.com/?methodName=DianzanList&version=4.40&media_type=3&post_id=3294&page=1&size=10

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.izhangchu.com")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("methodName","DianzanList");
        map.put("media_type","3");
        map.put("page",page+"");
        map.put("size","10");
        map.put("post_id",seriesId);
        Call<DianZanBean> dianZanBean = apiService.getDianZanBean(map);
        dianZanBean.enqueue(new Callback<DianZanBean>() {
            @Override
            public void onResponse(Call<DianZanBean> call, Response<DianZanBean> response) {
                DianZanBean body = response.body();
                if (!body.getData().getCount().equals("0")) {
                    mDianZanCount.setText(body.getData().getCount()+"位厨友觉得很赞");
                    adapter.updataRes(body.getData().getData());
                }
            }
            @Override
            public void onFailure(Call<DianZanBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });
    }
}
