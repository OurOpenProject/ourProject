package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.ui.sq.contract.ZPContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public class ZPModel implements ZPContract.MyModel {

    @Override
    public Observable<ZPBean> getZPBean(String vid, String page, String s) {
        return Api.getApiService().getZpBean(vid, page, s).compose(new AndroidIOToMain.IOToMainTransformer<ZPBean>());
    }
}
