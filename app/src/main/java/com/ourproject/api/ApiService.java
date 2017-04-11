package com.ourproject.api;

import com.ourproject.ui.lh.bean.FoodBean;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2017/4/9.
 */

public interface ApiService {

    //book





    //lh
    //food list http://api.izhangchu.com/?methodName=CourseIndex&page=1&size=20&version=4.40
    @GET("/?methodName=CourseIndex&version=4.40")
    Observable<FoodBean> getFoodBeanList(@Query("page") int page,@Query("size") int  size );



    //sq
}
