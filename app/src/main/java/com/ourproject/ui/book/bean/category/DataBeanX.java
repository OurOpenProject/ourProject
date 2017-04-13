package com.ourproject.ui.book.bean.category;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class DataBeanX {
    /**
     * image : http://pub.szzhangchu.com/web/images/tags/1xiaochao.jpg
     * id : 1
     * text : 3分钟小炒
     * type : 1
     * order_no : 501
     * tag_isselfdefine : 0
     * data : [{"id":"123","text":"素菜","tag_isselfdefine":0,"type":1,"order_no":1,"image":""},{"id":"397","text":"肉类","tag_isselfdefine":0,"type":1,"order_no":1,"image":""},{"id":"126","text":"河鲜海鲜","tag_isselfdefine":0,"type":1,"order_no":3,"image":""},{"id":"141","text":"炒饭","tag_isselfdefine":0,"type":1,"order_no":4,"image":""},{"id":"142","text":"炒面","tag_isselfdefine":0,"type":1,"order_no":5,"image":""},{"id":"143","text":"其他","tag_isselfdefine":0,"type":1,"order_no":6,"image":""}]
     * banner : {}
     */

    private String image;
    private String id;
    private String text;
    private int type;
    private int order_no;
    private int tag_isselfdefine;
    private BannerBean banner;
    private List<DataBean> data;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public int getTag_isselfdefine() {
        return tag_isselfdefine;
    }

    public void setTag_isselfdefine(int tag_isselfdefine) {
        this.tag_isselfdefine = tag_isselfdefine;
    }

    public BannerBean getBanner() {
        return banner;
    }

    public void setBanner(BannerBean banner) {
        this.banner = banner;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class BannerBean {
    }
}
