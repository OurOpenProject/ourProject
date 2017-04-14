package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.DRBean;
import com.ourproject.ui.sq.contract.DRContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public class DRModel implements DRContract.MyModel {

    @Override
    public Observable<DRBean> getDRBean(String vid) {
        return Api.getApiService().getDrBean(vid).compose(new AndroidIOToMain.IOToMainTransformer<DRBean>());
    }
}
