package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.TuiJanDetailBean;
import com.ourproject.ui.sq.contract.TuiJanDetailContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public class TuiJanModel implements TuiJanDetailContract.MyModel {
    @Override
    public Observable<TuiJanDetailBean> getTJBean(String postId) {
        return Api.getApiService().getTj(postId).compose(new AndroidIOToMain.IOToMainTransformer<TuiJanDetailBean>());
    }
}
