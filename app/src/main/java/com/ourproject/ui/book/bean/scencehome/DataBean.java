package com.ourproject.ui.book.bean.scencehome;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class DataBean {
    private List<Banner> banner;
    private List<WidgetListBean> widgetList;

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<WidgetListBean> getWidgetList() {
        return widgetList;
    }

    public void setWidgetList(List<WidgetListBean> widgetList) {
        this.widgetList = widgetList;
    }
}