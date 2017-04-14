package com.ourproject.ui.sq.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.sq.bean.ZXBean;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public interface ZXContract {
    abstract class MyPresenter extends BasePresenter<MyModel, MyView> {
        public abstract void getZXList(String p, String size);
    }

    interface MyModel extends BaseModel {
        Observable<ZXBean> getZXFoodList(String page, String s);
    }

    interface MyView extends BaseView {
        void returnZXBean(ZXBean zxBean);
    }
}
