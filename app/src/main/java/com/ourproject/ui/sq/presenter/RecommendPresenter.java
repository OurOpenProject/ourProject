package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.SqBean;
import com.ourproject.ui.sq.contract.RecommendContract;

import rx.Subscriber;

/**
 * Created by admin on 2017/4/10.
 */

public class RecommendPresenter extends RecommendContract.MyPresenter {
    @Override
    public void getSqList() {
        mModel.getSqList().subscribe(new Subscriber<SqBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError(e.getMessage());
            }

            @Override
            public void onNext(SqBean sqBean) {
                mView.returnSqBean(sqBean);
            }
        });
    }
}
