package com.ourproject.api;

import com.ourproject.ui.book.bean.category.CategoryIndexBean;
import com.ourproject.ui.book.bean.material.MaterialSubtypeBean;
import com.ourproject.ui.book.bean.scencehome.ScenceHomeBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.comment_list.CommentListBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate.CourseRelateBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan.DianZanBean;
import com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome.BannerBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by admin on 2017/4/9.
 */

public interface ApiService {
    //book  ----> baseUrl("http://api.izhangchu.com")
    //食谱----推荐 http://api.izhangchu.com/?methodName=SceneHome&version=4.40
    @GET("/?methodName=SceneHome&version=4.40")
    Call<ScenceHomeBean> getScenceHomeBean(@QueryMap Map<String,String> map);
         //1.Banner--
         //1.1 Banner-->CourseSeriesView 视频播放
         // http://api.izhangchu.com/?version=4.40&methodName=CourseSeriesView&series_id=86
         @GET("?version=4.40&")
         Call<BannerBean> getBannerBean(@QueryMap Map<String,String> map);
         //1.2 Banner -->
         // http://api.izhangchu.com/?methodName=DianzanList&version=4.40&media_type=3&post_id=3294
         @GET("?version=4.40&")
         Call<DianZanBean> getDianZanBean(@QueryMap Map<String,String> map);
         //1.3 Banner-->CourseRelate 点赞部分的布局
         // http://api.izhangchu.com/?version=4.40&methodName=CourseRelate&page=1&size=10&course_id=3300
         @GET("?version=4.40&")
         Call<CourseRelateBean> getCourseRelateBean(@QueryMap Map<String,String> map);
         //4.评论数据源
         // http://api.izhangchu.com/?version=4.40&methodName=CommentList&type=2&page=1&size=20&relate_id=163
         @GET("?version=4.40&")
         Call<CommentListBean> getCommentListBean(@QueryMap Map<String,String> map);

    //食谱----食材 http://api.izhangchu.com/?methodName=MaterialSubtype&version=4.40
    @GET("/?methodName=MaterialSubtype&version=4.40")
    Call<MaterialSubtypeBean> getMaterialSubtypeBean(@QueryMap Map<String,String> map);

    //食谱----分类 http://api.izhangchu.com/?methodName=CategoryIndex&version=4.40
    @GET("/?methodName=CategoryIndex&version=4.40")
    Call<CategoryIndexBean> getCategoryIndexBean(@QueryMap Map<String,String> map);

    //lh


    //sq
}
