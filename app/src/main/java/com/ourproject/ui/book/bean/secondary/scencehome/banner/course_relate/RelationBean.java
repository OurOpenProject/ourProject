package com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate;

/**
 * Created by YC on 2017/4/12.
 */

public class RelationBean {
    /**
     * dishes_id : 9784
     * dishes_title : 奏响甜蜜的乐章
     * dishes_image : http://img.szzhangchu.com/1439978548211_4166740997.JPG
     * material_video : http://video.szzhangchu.com/midoudantaA.mp4
     * process_video : http://video.szzhangchu.com/midoudantaB.mp4
     */

    private String dishes_id;
    private String dishes_title;
    private String dishes_image;
    private String material_video;
    private String process_video;

    @Override
    public String toString() {
        return "RelationBean{" +
                "dishes_id='" + dishes_id + '\'' +
                ", dishes_title='" + dishes_title + '\'' +
                ", dishes_image='" + dishes_image + '\'' +
                ", material_video='" + material_video + '\'' +
                ", process_video='" + process_video + '\'' +
                '}';
    }

    public String getDishes_id() {
        return dishes_id;
    }

    public void setDishes_id(String dishes_id) {
        this.dishes_id = dishes_id;
    }

    public String getDishes_title() {
        return dishes_title;
    }

    public void setDishes_title(String dishes_title) {
        this.dishes_title = dishes_title;
    }

    public String getDishes_image() {
        return dishes_image;
    }

    public void setDishes_image(String dishes_image) {
        this.dishes_image = dishes_image;
    }

    public String getMaterial_video() {
        return material_video;
    }

    public void setMaterial_video(String material_video) {
        this.material_video = material_video;
    }

    public String getProcess_video() {
        return process_video;
    }

    public void setProcess_video(String process_video) {
        this.process_video = process_video;
    }
}
