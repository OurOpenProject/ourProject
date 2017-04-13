package com.ourproject.ui.book.bean.material;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class DataBeanXX {

    private int id;
    private String text;
    private String name;
    private List<DataBeanX> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }
}
