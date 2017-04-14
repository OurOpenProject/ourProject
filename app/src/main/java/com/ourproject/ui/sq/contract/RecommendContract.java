package com.ourproject.ui.sq.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.sq.bean.SqBean;

import rx.Observable;

/**
 * Created by admin on 2017/4/10.
 */

public interface RecommendContract {
    abstract class MyPresenter extends BasePresenter<MyModel, MyView> {
        public abstract void getSqList();
    }

    interface MyModel extends BaseModel {
        Observable<SqBean> getSqList();
    }

    interface MyView extends BaseView {
        void returnSqBean(SqBean sqBean);
    }
}
