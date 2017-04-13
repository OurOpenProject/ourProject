package com.ourproject.ui.book.bean.scencehome;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */
public class WidgetListBean {
    /**
     * widget_id : 32
     * widget_type : 1
     * title : 猜你喜欢
     * title_link : null
     * desc : null
     * widget_data : [{"id":1,"type":"image","content":"http://img.szzhangchu.com/1456222953065_6855615159.png","link":"http://h5.izhangchu.com/Tour.html?app_hideheader=1"},{"id":2,"type":"text","content":"新手入门","link":null},{"id":3,"type":"image","content":"http://img.szzhangchu.com/1456222960944_9047013376.png","link":"app://foodmatch"},{"id":4,"type":"text","content":"食材搭配","link":null},{"id":5,"type":"image","content":"http://img.szzhangchu.com/1456222967767_5511783735.png","link":"app://scenelist"},{"id":6,"type":"text","content":"场景菜谱","link":null},{"id":7,"type":"image","content":"http://img.szzhangchu.com/1483785031840_8675873250.png","link":"http://www.meipai.com/user/1047577070"},{"id":8,"type":"text","content":"美食直播","link":null}]
     */

    private int widget_id;
    private int widget_type;
    private String title;
    private String title_link;
    private String desc;
    private List<WidgetDataBean> widget_data;

    public int getWidget_id() {
        return widget_id;
    }

    public void setWidget_id(int widget_id) {
        this.widget_id = widget_id;
    }

    public int getWidget_type() {
        return widget_type;
    }

    public void setWidget_type(int widget_type) {
        this.widget_type = widget_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_link() {
        return title_link;
    }

    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<WidgetDataBean> getWidget_data() {
        return widget_data;
    }

    public void setWidget_data(List<WidgetDataBean> widget_data) {
        this.widget_data = widget_data;
    }


}
