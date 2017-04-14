package com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan;

/**
 * Created by YC on 2017/4/13.
 */

public class DataBean {
    /**
     * user_id : 1927904
     * create_time : 1491902791
     * nick : 小妖精
     * head_img : http://wx.qlogo.cn/mmopen/Y3WgNLFjO0coI5XiakDvBu0tXhp6yibZCH7rfLl4fcnldSfbibPqfjloSXx9Pvz3magbfQCRiaq8q9ic4W53venR21Hxsx01hIaRp/0
     * istalent : 0
     * create_time_cn : 1天前
     */

    private String user_id;
    private int create_time;
    private String nick;
    private String head_img;
    private int istalent;
    private String create_time_cn;

    @Override
    public String toString() {
        return "DataBean{" +
                "user_id='" + user_id + '\'' +
                ", create_time=" + create_time +
                ", nick='" + nick + '\'' +
                ", head_img='" + head_img + '\'' +
                ", istalent=" + istalent +
                ", create_time_cn='" + create_time_cn + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public int getIstalent() {
        return istalent;
    }

    public void setIstalent(int istalent) {
        this.istalent = istalent;
    }

    public String getCreate_time_cn() {
        return create_time_cn;
    }

    public void setCreate_time_cn(String create_time_cn) {
        this.create_time_cn = create_time_cn;
    }
}
