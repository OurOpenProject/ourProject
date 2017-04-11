package com.ourproject.ui.lh.presenter;

import android.util.Log;

import com.ourproject.ui.lh.bean.FoodBean;
import com.ourproject.ui.lh.contract.FoodContract;
import com.ourproject.ui.lh.mode.FoodMode;

import rx.Subscriber;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class FoodPresenter extends FoodContract.FoodPresenter {
    @Override
    public void getFoodBeanList(int page, int size) {
        mModel.getFoodBeanList(page,size).subscribe(new Subscriber<FoodBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("有出错了", "onError: "+e.getMessage() );
            }

            @Override
            public void onNext(FoodBean foodBean) {
                mView.returnFoodBeanList(foodBean);
            }
        });
    }
}
