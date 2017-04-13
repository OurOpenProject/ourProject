package com.ourproject.ui.book.bean.material;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class DataBeanX {
    /**
     * id : 39
     * text : 常见食材
     * image : http://pub.szzhangchu.com/web/images/material_type/1changjianshicai.jpg
     * data : [{"id":"2","text":"菠菜","image":"http://img.szzhangchu.com/20141107110043154.jpg"},{"id":"3","text":"菜心","image":"http://img.szzhangchu.com/20141230150657647.jpg"},{"id":"5","text":"小白菜","image":"http://img.szzhangchu.com/20141107103757137.jpg"},{"id":"6","text":"上海青","image":"http://img.szzhangchu.com/1439782526400_9389049634.jpg"},{"id":"8","text":"生菜","image":"http://img.szzhangchu.com/20141107105347572.jpg"},{"id":"35","text":"西蓝花","image":"http://img.szzhangchu.com/20150518151207847.jpg"},{"id":"37","text":"胡萝卜","image":"http://img.szzhangchu.com/20141107101536959.jpg"},{"id":"41","text":"莲藕","image":"http://img.szzhangchu.com/20150413094130659.jpg"},{"id":"42","text":"芦笋","image":"http://img.szzhangchu.com/2015051815160675.jpg"},{"id":"44","text":"山药","image":"http://img.szzhangchu.com/20141107102023496.jpg"},{"id":"45","text":"土豆","image":"http://img.szzhangchu.com/20141107101800229.jpg"},{"id":"47","text":"洋葱","image":"http://img.szzhangchu.com/20141107095705968.jpg"},{"id":"48","text":"玉米","image":"http://img.szzhangchu.com/20150413100811690.jpg"},{"id":"52","text":"蒜头","image":"http://img.szzhangchu.com/20150413100345395.jpg"},{"id":"53","text":"生姜","image":"http://img.szzhangchu.com/20150518151740428.jpg"},{"id":"55","text":"黄瓜","image":"http://img.szzhangchu.com/20141107104529623.jpg"},{"id":"57","text":"青椒","image":"http://img.szzhangchu.com/20150418103625297.jpg"},{"id":"59","text":"彩椒","image":"http://img.szzhangchu.com/20150418103505845.jpg"},{"id":"62","text":"茄子","image":"http://img.szzhangchu.com/20141107110900207.jpg"},{"id":"63","text":"丝瓜","image":"http://img.szzhangchu.com/20141107110435278.jpg"},{"id":"64","text":"西红柿","image":"http://img.szzhangchu.com/1439718049593_3151099996.jpg"},{"id":"81","text":"豆腐","image":"http://img.szzhangchu.com/20141107103210151.jpg"},{"id":"92","text":"香菇","image":"http://img.szzhangchu.com/20141107164744880.jpg"},{"id":"93","text":"平菇","image":"http://img.szzhangchu.com/20150413101822528.jpg"},{"id":"94","text":"金针菇","image":"http://img.szzhangchu.com/20150413101613115.jpg"},{"id":"100","text":"杏鲍菇","image":"http://img.szzhangchu.com/20141107165643255.jpg"},{"id":"103","text":"猪肉","image":"http://img.szzhangchu.com/20141107102317371.jpg"},{"id":"119","text":"牛肉","image":"http://img.szzhangchu.com/20141107102627560.jpg"},{"id":"132","text":"鸭肉","image":"http://img.szzhangchu.com/20141107102815921.jpg"},{"id":"138","text":"鸡蛋","image":"http://img.szzhangchu.com/2014110710253590.jpg"},{"id":"145","text":"草鱼","image":"http://img.szzhangchu.com/2014110709091341.jpg"},{"id":"212","text":"花生","image":"http://img.szzhangchu.com/20150413111004526.jpg"},{"id":"221","text":"粉丝","image":"http://img.szzhangchu.com/20150418135656191.jpg"},{"id":"240","text":"面粉","image":"http://img.szzhangchu.com/20150418165721363.jpg"},{"id":"246","text":"大米","image":"http://img.szzhangchu.com/20141107095925575.jpg"},{"id":"251","text":"牛奶","image":"http://img.szzhangchu.com/20150530161229599.jpg"},{"id":"265","text":"面条","image":"http://img.szzhangchu.com/20150418170004365.jpg"},{"id":"485","text":"鲫鱼","image":"http://img.szzhangchu.com/1440139100663_7811167460.jpg"},{"id":"488","text":"鸡肉","image":"http://img.szzhangchu.com/1439643177463_8570501229.jpg"}]
     */

    private String id;
    private String text;
    private String image;
    private List<DataBean> data;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
