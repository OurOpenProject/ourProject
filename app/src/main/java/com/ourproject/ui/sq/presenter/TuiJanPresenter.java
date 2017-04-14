package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.TuiJanDetailBean;
import com.ourproject.ui.sq.contract.TuiJanDetailContract;

import rx.Subscriber;

/**
 * Created by admin on 2017/4/12.
 */

public class TuiJanPresenter extends TuiJanDetailContract.MyPresenter {
    @Override
    public void getTJBean(String postId) {
        mModel.getTJBean(postId).subscribe(new Subscriber<TuiJanDetailBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TuiJanDetailBean bean) {
                mView.returnTJBean(bean);
            }
        });
    }
}
