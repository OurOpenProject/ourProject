package com.ourproject.ui.lh.contract;

import com.ourproject.base.BaseModel;
import com.ourproject.base.BasePresenter;
import com.ourproject.base.BaseView;
import com.ourproject.ui.lh.bean.FoodBean;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public interface FoodContract {

     abstract class FoodPresenter extends BasePresenter<FoodMode,FoodView>{
        public abstract void getFoodBeanList(int  page,int size);
    }

    interface FoodMode extends BaseModel{
        Observable<FoodBean>  getFoodBeanList(int page,int size );
    }
    interface FoodView extends BaseView{
        void returnFoodBeanList(FoodBean foodBean);
    }
}
