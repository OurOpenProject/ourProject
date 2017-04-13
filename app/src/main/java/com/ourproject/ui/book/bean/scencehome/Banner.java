package com.ourproject.ui.book.bean.scencehome;

/**
 * Created by YC on 2017/4/10.
 */

public class Banner {
    /**
     * banner_id : 101
     * banner_title : 白桃乌龙奶泡茶
     * banner_picture : http://img.szzhangchu.com/1491559226739_4671098440.jpg
     * banner_link : app://food_course_series#109#
     * is_link : 1
     * refer_key : 1
     * type_id : 1
     */

    private int banner_id;
    private String banner_title;
    private String banner_picture;
    private String banner_link;
    private int is_link;
    private int refer_key;
    private int type_id;

    @Override
    public String toString() {
        return "Banner{" +
                "banner_id=" + banner_id +
                ", banner_title='" + banner_title + '\'' +
                ", banner_picture='" + banner_picture + '\'' +
                ", banner_link='" + banner_link + '\'' +
                ", is_link=" + is_link +
                ", refer_key=" + refer_key +
                ", type_id=" + type_id +
                '}';
    }

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_picture() {
        return banner_picture;
    }

    public void setBanner_picture(String banner_picture) {
        this.banner_picture = banner_picture;
    }

    public String getBanner_link() {
        return banner_link;
    }

    public void setBanner_link(String banner_link) {
        this.banner_link = banner_link;
    }

    public int getIs_link() {
        return is_link;
    }

    public void setIs_link(int is_link) {
        this.is_link = is_link;
    }

    public int getRefer_key() {
        return refer_key;
    }

    public void setRefer_key(int refer_key) {
        this.refer_key = refer_key;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
