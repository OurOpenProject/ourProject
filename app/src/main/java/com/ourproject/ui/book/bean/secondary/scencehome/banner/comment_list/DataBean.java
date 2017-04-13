package com.ourproject.ui.book.bean.secondary.scencehome.banner.comment_list;

import java.util.List;

/**
 * Created by YC on 2017/4/13.
 */

public class DataBean {
    /**
     * id : 97214
     * user_id : 1917977
     * type : 2
     * relate_id : 86
     * content : 👈看着都有食欲 一看就是大厨师💗💜💚
     * create_time : 03月30日
     * parent_id : 0
     * parents : []
     * nick : 淘宝招聘打字员
     * head_img : http://img.szzhangchu.com/IMG_20170330_115001.jpg
     * istalent : 0
     */

    private String id;
    private String user_id;
    private String type;
    private String relate_id;
    private String content;
    private String create_time;
    private String parent_id;
    private String nick;
    private String head_img;
    private int istalent;
    private List<ParentBean> parents;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelate_id() {
        return relate_id;
    }

    public void setRelate_id(String relate_id) {
        this.relate_id = relate_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
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

    public List<ParentBean> getParents() {
        return parents;
    }

    public void setParents(List<ParentBean> parents) {
        this.parents = parents;
    }
}