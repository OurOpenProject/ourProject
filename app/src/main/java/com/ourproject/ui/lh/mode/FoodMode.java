package com.ourproject.ui.lh.mode;

import android.util.Log;

import com.ourproject.api.Api;
import com.ourproject.event.AndroidIOToMain;
import com.ourproject.ui.lh.bean.FoodBean;
import com.ourproject.ui.lh.contract.FoodContract;

import rx.Observable;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class FoodMode implements FoodContract.FoodMode {
    @Override
    public Observable<FoodBean> getFoodBeanList(int page, int size) {
        Log.e("1024", "getFoodBeanList: " );
        return Api.getApiService().getFoodBeanList(page,size).compose(new AndroidIOToMain.IOToMainTransformer<FoodBean>());
    }
}
