package com.ourproject.ui.book.bean.scencehome;

/**
 * Created by YC on 2017/4/10.
 */

public class WidgetDataBean {
    /**
     * id : 1
     * type : image
     * content : http://img.szzhangchu.com/1456222953065_6855615159.png
     * link : http://h5.izhangchu.com/Tour.html?app_hideheader=1
     */

    private int id;
    private String type;
    private String content;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}