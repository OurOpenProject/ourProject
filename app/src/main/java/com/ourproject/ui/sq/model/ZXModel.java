package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.ZXBean;
import com.ourproject.ui.sq.contract.ZXContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public class ZXModel implements ZXContract.MyModel {
    @Override
    public Observable<ZXBean> getZXFoodList(String page, String s) {
        return Api.getApiService().getZxList(page, s).compose(new AndroidIOToMain.IOToMainTransformer<ZXBean>());
    }
}
