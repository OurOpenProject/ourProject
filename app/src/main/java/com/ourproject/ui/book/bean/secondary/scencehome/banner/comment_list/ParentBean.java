package com.ourproject.ui.book.bean.secondary.scencehome.banner.comment_list;

/**
 * Created by YC on 2017/4/13.
 */

public class ParentBean {

    /**
     * id : 89655
     * user_id : 1750410
     * content : 嗯哦哦0呢1哦哦莫名大额1
     * parent_id : 84949
     * nick :      茉
     * head_img : http://wx.qlogo.cn/mmopen/RmLI7RnVg7PGC9n21YoT4eQU4ZkRtg99RNENbQIu7MHlXDUM5AjFsuiaDecnwmb4icibBGULcicsFphstlbsve01p5v1PtRsEL5j/0
     * istalent : 0
     */

    private String id;
    private String user_id;
    private String content;
    private String parent_id;
    private String nick;
    private String head_img;
    private int istalent;

    @Override
    public String toString() {
        return "ParentBean{" +
                "id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", content='" + content + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", nick='" + nick + '\'' +
                ", head_img='" + head_img + '\'' +
                ", istalent=" + istalent +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
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
}
