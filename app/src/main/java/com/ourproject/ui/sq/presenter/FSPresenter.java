package com.ourproject.ui.sq.presenter;

import com.ourproject.ui.sq.bean.FSBean;
import com.ourproject.ui.sq.contract.FSContract;


import rx.Subscriber;

/**
 * Created by admin on 2017/4/11.
 */

public class FSPresenter extends FSContract.MyPresenter {

    @Override
    public void getFSBean(String vid, String p, String size) {
        mModel.getFSBean(vid, p, size).subscribe(new Subscriber<FSBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(FSBean fsBean) {
                mView.returnFSBean(fsBean);
            }
        });
    }
}
