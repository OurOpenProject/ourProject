package com.ourproject.ui.sq.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.sq.bean.ZPBean;
import com.ourproject.ui.sq.bean.ZXBean;

import rx.Observable;

/**
 * Created by admin on 2017/4/11.
 */

public interface ZPContract {
    abstract class MyPresenter extends BasePresenter<MyModel, MyView> {
        public abstract void getZPBean(String vid, String p, String size);
    }

    interface MyModel extends BaseModel {
        Observable<ZPBean> getZPBean(String vid, String page, String s);
    }

    interface MyView extends BaseView {
        void returnZPBean(ZPBean zpBean);
    }
}
