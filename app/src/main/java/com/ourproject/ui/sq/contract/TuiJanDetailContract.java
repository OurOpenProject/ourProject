package com.ourproject.ui.sq.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.sq.bean.TuiJanDetailBean;
import com.ourproject.ui.sq.bean.ZXBean;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public interface TuiJanDetailContract {
    abstract class MyPresenter extends BasePresenter<MyModel, MyView> {
        public abstract void getTJBean(String postId);
    }

    interface MyModel extends BaseModel {
        Observable<TuiJanDetailBean> getTJBean(String postId);
    }

    interface MyView extends BaseView {
        void returnTJBean(TuiJanDetailBean bean);
    }
}
