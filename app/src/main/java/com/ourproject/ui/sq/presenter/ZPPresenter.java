package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.ui.sq.contract.ZPContract;

import rx.Subscriber;

/**
 * Created by admin on 2017/4/11.
 */

public class ZPPresenter extends ZPContract.MyPresenter {

    @Override
    public void getZPBean(String vid, String p, String size) {
        mModel.getZPBean(vid, p, size).subscribe(new Subscriber<ZPBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onNext(ZPBean zpBean) {
                mView.returnZPBean(zpBean);
            }
        });
    }
}
