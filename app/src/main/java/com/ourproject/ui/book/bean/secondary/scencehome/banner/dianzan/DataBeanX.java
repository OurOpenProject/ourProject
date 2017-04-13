package com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan;

import java.util.List;

/**
 * Created by YC on 2017/4/13.
 */

public class DataBeanX {
    /**
     * page : 1
     * size : 10
     * total : 1
     * count : 1
     * data : [{"user_id":"1927904","create_time":1491902791,"nick":"小妖精","head_img":"http://wx.qlogo.cn/mmopen/Y3WgNLFjO0coI5XiakDvBu0tXhp6yibZCH7rfLl4fcnldSfbibPqfjloSXx9Pvz3magbfQCRiaq8q9ic4W53venR21Hxsx01hIaRp/0","istalent":0,"create_time_cn":"1天前"}]
     */

    private String page;
    private String size;
    private String total;
    private String count;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "DataBeanX{" +
                "page='" + page + '\'' +
                ", size='" + size + '\'' +
                ", total='" + total + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                '}';
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }


}