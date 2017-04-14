package com.ourproject.ui.book.fragments.scencebanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.adapters.scence.banner.CourseRelateAdapter;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate.CourseRelateBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate.DataBean;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YC on 2017/4/13.
 */

public class CourseRelateFrag extends Fragment implements View.OnClickListener {
    public static final String TAG = CourseRelateFrag.class.getSimpleName();
    private CourseRelateAdapter adapter;
    @BindView(R2.id.banner_course_more)
    TextView mCourseMore;
    @BindView(R2.id.banner_course_recycler)
    RecyclerView mRecycler;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.banner_course_relate, container, false);
        ButterKnife.bind(this,layout);

        adapter = new CourseRelateAdapter(getContext(),null);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycler.setLayoutManager(manager);
        mRecycler.setAdapter(adapter);
        mCourseMore.setOnClickListener(this);

        return layout;
    }

    public void setCourseId(String courseId){
        course_id = courseId;
        initData();
    }

    private String course_id;
    public void initData(){
        //3.相关课程
        // http://api.izhangchu.com/?version=4.40&methodName=CourseRelate&page=1&size=10&course_id=3294
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.izhangchu.com")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("methodName","CourseRelate");
        map.put("page","1");
        map.put("size","10");
        map.put("course_id",course_id);
        Call<CourseRelateBean> courseRelateBean = apiService.getCourseRelateBean(map);
        courseRelateBean.enqueue(new Callback<CourseRelateBean>() {
            @Override
            public void onResponse(Call<CourseRelateBean> call, Response<CourseRelateBean> response) {
                CourseRelateBean body = response.body();
                List<DataBean> data = body.getData().getData();
                adapter.updataRes(data);
            }

            @Override
            public void onFailure(Call<CourseRelateBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_course_more:

                break;
        }
    }
}
