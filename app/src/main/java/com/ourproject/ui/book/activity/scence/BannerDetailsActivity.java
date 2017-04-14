package com.ourproject.ui.book.activity.scence;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.api.ApiService;
import com.ourproject.ui.book.adapters.scence.banner.BannerGridAdapter;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome.BannerBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome.DataBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome.DataBeanX;
import com.ourproject.ui.book.fragments.scencebanner.CommentListFragment;
import com.ourproject.ui.book.fragments.scencebanner.CourseRelateFrag;
import com.ourproject.ui.book.fragments.scencebanner.DianZanFrag;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BannerDetailsActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    private static final String TAG = BannerDetailsActivity.class.getSimpleName();

    @BindView(R2.id.banner_loading_container)
    LinearLayout mLoadingCon;
    @BindView(R2.id.banner_loading_image)
    ImageView mLoadingImage;
    @BindView(R2.id.banner_container)
    ScrollView mContainer;
    @BindView(R2.id.banner_back)
    ImageView mBack;
    @BindView(R2.id.banner_share_friend)
    ImageView mShareFriend;
    @BindView(R2.id.banner_series_name)
    TextView mSeriesName;
    @BindView(R2.id.banner_course_video)
    VideoView mVideo;
    @BindView(R2.id.banner_course_image)
    ImageView mImage;
    @BindView(R2.id.banner_course_play)
    ImageView mPlay;
    @BindView(R2.id.banner_course_video_watchcount)
    TextView mWatchCount;
    @BindView(R2.id.banner_course_isLike)
    ImageView mIsLike;
    @BindView(R2.id.banner_course_share)
    ImageView mShare;
    @BindView(R2.id.banner_course_name)
    TextView mCourseName;
    @BindView(R2.id.banner_course_name_expand)
    CheckBox mCourseNameExpand;
    @BindView(R2.id.banner_course_subkect)
    TextView mCourseSubject;
    @BindView(R2.id.banner_episode_expand)
    CheckBox mEpisodeExpand;
    @BindView(R2.id.banner_episode)
    TextView mEpisode;
    @BindView(R2.id.banner_episode_list)
    GridView mGridView;
    private BannerGridAdapter adapter;
    private DianZanFrag Fdianzan;
    private CourseRelateFrag FcourseRelate;
    private CommentListFragment FcommentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_details);
        ButterKnife.bind(this);

        jsonSeriesID();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fdianzan = new DianZanFrag();
        FcourseRelate = new CourseRelateFrag();
        FcommentList = new CommentListFragment();
        transaction.add(R.id.banner_frag_dianzan, Fdianzan);
        transaction.add(R.id.banner_frag_CourseRelate,FcourseRelate);
        transaction.add(R.id.banner_frag_CommentList,FcommentList);
        transaction.commit();

    }
    // 格式化获取到的数据，从中取出需要的 series_id
    private void jsonSeriesID() {
        Intent intent = getIntent();
        String bannerLink = intent.getStringExtra("banner_link");
        bannerLink = "app://food_course_series#163#";
        //例如：app://food_course_series#163#-----> 163
        series_id = StringUtils.substringBetween(bannerLink, "#", "#");
        // 从网络获取数据
        initDate();
    }

    private String series_id;
    private void initDate() {
        //1.1 Banner-->CourseSeriesView 视频播放
        // http://api.izhangchu.com/?version=4.40&methodName=CourseSeriesView&series_id=86
        //2.厨友觉得很赞数据源
        // http://api.izhangchu.com/?version=4.40&methodName=DianzanList&media_type=3&post_id=3303
        //3.相关课程
        // http://api.izhangchu.com/?version=4.40&methodName=CourseRelate&page=1&size=10&course_id=3294
        //4.评论数据源
        // http://api.izhangchu.com/?version=4.40&methodName=CommentList&type=2&page=1&size=20&relate_id=163

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.izhangchu.com")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("methodName","CourseSeriesView");
        map.put("series_id",series_id);
        Call<BannerBean> bannerBean = apiService.getBannerBean(map);
        bannerBean.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                BannerBean body = response.body();
                if (body.getData()!=null) {
                    goneLoadingImage();
                    setViewData(body.getData());
                }
            }
            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
            }
        });
    }
    // 获取到数据之后开始为空间附加数据
    private void setViewData(DataBeanX data) {
        mBack.setOnClickListener(this);
        mShareFriend.setOnClickListener(this);

        mSeriesName.setText(data.getSeries_name());
        mEpisode.setText("更新至"+data.getEpisode()+"集");

        adapter = new BannerGridAdapter(this, data.getData());
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
        // 默认打开最后一个数据源
        openLastData(data.getData().get(data.getEpisode()-1));
        adapter.savaPosition(data.getEpisode()-1);

    }

    // 获取到数据之后，取消加载动画
    private void goneLoadingImage() {
        if (mLoadingCon.getVisibility() == View.VISIBLE) {
            mLoadingCon.setVisibility(View.GONE);
        }
        if (mContainer.getVisibility() == View.INVISIBLE) {
            mContainer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_back:
                this.finish();
                break;
            case R.id.banner_course_play:
                mVideo.start();
                break;
        }
    }
    // GridView item点击事件，更改视频、介绍的数据源
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e(TAG, "onItemClick: " + position);
        // 切换数据源之前，要将VideoView暂停，覆盖的ImageView显示出来
        if (mVideo.isPlaying()) {
            mVideo.pause();
            mImage.setVisibility(View.VISIBLE);
        }
        adapter.savaPosition(position);
        openLastData(adapter.getItem(position));
    }


    // 通过GridView 更改数据源
    private void openLastData(DataBean dataBean) {
        Log.e(TAG, "openLastData: " + dataBean.toString() );
        // 为Fragment传值（点击item的course_id）
        Fdianzan.setSeriesId(dataBean.getCourse_id()+"");
        FcourseRelate.setCourseId(dataBean.getCourse_id()+"");

        mVideo.setVideoPath(dataBean.getCourse_video());
        Log.e(TAG, "openLastData: " + dataBean.getCourse_video() );
        mVideo.setMediaController(new MediaController(this));
        mVideo.setOnPreparedListener(this);
        mVideo.setOnCompletionListener(this);
        mVideo.setOnErrorListener(this);


        mVideo.requestFocus();

        Glide.with(this)
                .load(dataBean.getCourse_image())
                .into(mImage);
        mWatchCount.setText("上课人数："+dataBean.getVideo_watchcount());
        mCourseName.setText(dataBean.getCourse_name());
        mCourseSubject.setText(dataBean.getCourse_subject());
    }
    // VideoView 资源转备好的监听
    @Override
    public void onPrepared(MediaPlayer mp) {
        if (mImage.getVisibility() == View.VISIBLE) {
            mImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }
}
