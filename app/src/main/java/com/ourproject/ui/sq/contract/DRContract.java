package com.ourproject.ui.sq.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.sq.bean.DRBean;
import com.ourproject.ui.sq.bean.ZXBean;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public interface DRContract {
    abstract class MyPresenter extends BasePresenter<MyModel, MyView> {
        public abstract void getDRBean(String vid);
    }

    interface MyModel extends BaseModel {
        Observable<DRBean> getDRBean(String vid);
    }

    interface MyView extends BaseView {
        void returnDRBean(DRBean drBean);
    }
}
