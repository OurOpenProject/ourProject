package com.ourproject.ui.book.bean.category;

/**
 * Created by YC on 2017/4/10.
 */

public class DataBean {
    /**
     * id : 123
     * text : 素菜
     * tag_isselfdefine : 0
     * type : 1
     * order_no : 1
     * image :
     */

    private String id;
    private String text;
    private int tag_isselfdefine;
    private int type;
    private int order_no;
    private String image;

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

    public int getTag_isselfdefine() {
        return tag_isselfdefine;
    }

    public void setTag_isselfdefine(int tag_isselfdefine) {
        this.tag_isselfdefine = tag_isselfdefine;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}