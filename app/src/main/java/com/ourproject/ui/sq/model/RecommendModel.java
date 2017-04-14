package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.SqBean;
import com.ourproject.ui.sq.contract.RecommendContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/10.
 */

public class RecommendModel implements RecommendContract.MyModel {
    @Override
    public Observable<SqBean> getSqList() {
        return Api.getApiService().getSqList().compose(new AndroidIOToMain.IOToMainTransformer<SqBean>());
    }
}
