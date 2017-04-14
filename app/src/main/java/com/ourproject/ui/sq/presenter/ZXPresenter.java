package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.ZXBean;
import com.ourproject.ui.sq.contract.ZXContract;

import rx.Subscriber;

/**
 * Created by admin on 2017/4/11.
 */

public class ZXPresenter extends ZXContract.MyPresenter {
    @Override
    public void getZXList(String p, String size) {
        mModel.getZXFoodList(p, size).subscribe(new Subscriber<ZXBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ZXBean zxBean) {
                mView.returnZXBean(zxBean);
            }
        });
    }
}
