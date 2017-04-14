package com.ourproject.ui.sq.activity;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.ourproject.R;
import com.ourproject.R2;
import com.ourproject.base.BaseActivity;
import com.ourproject.ui.sq.bean.TuiJanDetailBean;
import com.ourproject.ui.sq.contract.TuiJanDetailContract;
import com.ourproject.ui.sq.model.TuiJanModel;
import com.ourproject.ui.sq.presenter.TuiJanPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class TuiJanDetailActivity extends BaseActivity<TuiJanPresenter, TuiJanModel> implements TuiJanDetailContract.MyView {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.web)
    WebView web;

    @Override
    public int getLayoutId() {
        return R.layout.activity_tj_detail;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String postId = intent.getStringExtra("postId");
        mPresenter.getTJBean(postId);
    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void returnTJBean(TuiJanDetailBean bean) {
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        web.loadUrl(bean.getData().getShare_url());
    }

    @OnClick(R2.id.back)
    public void finishThis() {
        this.finish();
    }
}
