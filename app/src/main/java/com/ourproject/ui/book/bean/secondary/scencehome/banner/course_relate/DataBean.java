package com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate;

/**
 * Created by YC on 2017/4/12.
 */

public class DataBean {
    /**
     * media_id : 9784
     * media_type : 1
     * relation : {"dishes_id":"9784","dishes_title":"奏响甜蜜的乐章","dishes_image":"http://img.szzhangchu.com/1439978548211_4166740997.JPG","material_video":"http://video.szzhangchu.com/midoudantaA.mp4","process_video":"http://video.szzhangchu.com/midoudantaB.mp4"}
     */

    private String media_id;
    private String media_type;
    private RelationBean relation;

    @Override
    public String toString() {
        return "DataBean{" +
                "media_id='" + media_id + '\'' +
                ", media_type='" + media_type + '\'' +
                ", relation=" + relation +
                '}';
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public RelationBean getRelation() {
        return relation;
    }

    public void setRelation(RelationBean relation) {
        this.relation = relation;
    }
}