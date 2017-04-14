package com.ourproject.ui.book.bean.secondary.scencehome.banner.course_relate;

/**
 * Created by YC on 2017/4/12.
 */

public class CourseRelateBean {

    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1491976651000
     * data : {"page":"1","size":"10","total":"3","count":"3","data":[{"media_id":"9784","media_type":"1","relation":{"dishes_id":"9784","dishes_title":"奏响甜蜜的乐章","dishes_image":"http://img.szzhangchu.com/1439978548211_4166740997.JPG","material_video":"http://video.szzhangchu.com/midoudantaA.mp4","process_video":"http://video.szzhangchu.com/midoudantaB.mp4"}},{"media_id":"9815","media_type":"1","relation":{"dishes_id":"9815","dishes_title":"力求做最好的蛋挞","dishes_image":"http://img.szzhangchu.com/1439462756775_5490503634.jpg","material_video":"http://video.szzhangchu.com/qiaokelidantaA.mp4","process_video":"http://video.szzhangchu.com/qiaokelidantaB.mp4"}},{"media_id":"11062","media_type":"1","relation":{"dishes_id":"11062","dishes_title":"外脆里滑好滋味","dishes_image":"http://img.szzhangchu.com/1439448912162_3278633372.jpg","material_video":"http://video.szzhangchu.com/cuipidantaA.mp4","process_video":"http://video.szzhangchu.com/cuipidantaB.mp4"}}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataBeanX data;

    @Override
    public String toString() {
        return "DianZanBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", version='" + version + '\'' +
                ", timestamp=" + timestamp +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }
}
