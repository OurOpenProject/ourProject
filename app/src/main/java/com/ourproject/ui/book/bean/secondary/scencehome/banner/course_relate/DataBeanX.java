package com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate;

import java.util.List;

/**
 * Created by YC on 2017/4/12.
 */

public class DataBeanX {
    /**
     * page : 1
     * size : 10
     * total : 3
     * count : 3
     * data : [{"media_id":"9784","media_type":"1","relation":{"dishes_id":"9784","dishes_title":"奏响甜蜜的乐章","dishes_image":"http://img.szzhangchu.com/1439978548211_4166740997.JPG","material_video":"http://video.szzhangchu.com/midoudantaA.mp4","process_video":"http://video.szzhangchu.com/midoudantaB.mp4"}},{"media_id":"9815","media_type":"1","relation":{"dishes_id":"9815","dishes_title":"力求做最好的蛋挞","dishes_image":"http://img.szzhangchu.com/1439462756775_5490503634.jpg","material_video":"http://video.szzhangchu.com/qiaokelidantaA.mp4","process_video":"http://video.szzhangchu.com/qiaokelidantaB.mp4"}},{"media_id":"11062","media_type":"1","relation":{"dishes_id":"11062","dishes_title":"外脆里滑好滋味","dishes_image":"http://img.szzhangchu.com/1439448912162_3278633372.jpg","material_video":"http://video.szzhangchu.com/cuipidantaA.mp4","process_video":"http://video.szzhangchu.com/cuipidantaB.mp4"}}]
     */

    private String page;
    private String size;
    private String total;
    private String count;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "DataBeanX{" +
                "page='" + page + '\'' +
                ", size='" + size + '\'' +
                ", total='" + total + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                '}';
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }
}
