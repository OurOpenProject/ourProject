package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.DRBean;
import com.ourproject.ui.sq.contract.DRContract;

import rx.Subscriber;

/**
 * Created by admin on 2017/4/11.
 */

public class DRPresenter extends DRContract.MyPresenter {

    @Override
    public void getDRBean(String vid) {
        mModel.getDRBean(vid).subscribe(new Subscriber<DRBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DRBean drBean) {
                mView.returnDRBean(drBean);
            }
        });
    }
}
