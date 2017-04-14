package com.ourproject.ui.sq.model;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.sq.bean.FSBean;
import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.ui.sq.contract.FSContract;
import com.ourproject.ui.sq.contract.ZPContract;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public class FSModel implements FSContract.MyModel {

    @Override
    public Observable<FSBean> getFSBean(String vid, String page, String s) {
        return Api.getApiService().getFsBean(vid, page, s).compose(new AndroidIOToMain.IOToMainTransformer<FSBean>());
    }
}
