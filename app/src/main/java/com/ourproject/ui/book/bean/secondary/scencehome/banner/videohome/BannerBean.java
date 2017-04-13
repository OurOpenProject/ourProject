package com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome;

/**
 * Created by YC on 2017/4/11.
 */

public class BannerBean {

    /**
     * data : {"series_id":182,"series_name":"#去过#如果人间有天堂，那一定是塔希提岛的模样","series_title":"这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为\u201c最接近天堂的地方\u201d\u2014\u2014塔希提（大溪地）！","create_time":"Apr 10, 2017 3:10:26 PM","last_update":"Apr 10, 2017 3:11:26 PM","order_no":"1","tag":"","episode":3,"series_image":"http://img.szzhangchu.com/1491808286329_4810470723.jpg","album":"去过","album_logo":"1491808226018_3754036436.png","relate_activity":"210","data":[{"course_id":2159,"course_name":"兔子VS荡漾的日本","course_subject":"前央视体育记者化身旅行达人，放下成见，带你赏樱看日本！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460415322_7264047151.mp4","course_image":"http://img.szzhangchu.com/1491808416546_2708197150.jpg","read_count":0,"video_watchcount":3874,"video_length":184,"series_id":182,"episode":1,"ischarge":"0","price":"0","share_title":"前央视体育记者化身旅行达人，放下成见，带你赏樱看日本！","share_content":"兔子VS荡漾的日本","share_image":"http://img.szzhangchu.com/1491808416151_3744443957.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"},{"course_id":2160,"course_name":"惊险刺激的摩洛哥历险记","course_subject":"90后美女跟骆驼这么玩，一不小心磨破大腿根，撒哈拉沙漠里最磨人屁股的物种竟然是这个！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460385660_4178483654.mp4","course_image":"http://img.szzhangchu.com/1491808547891_1792444181.jpg","read_count":0,"video_watchcount":3877,"video_length":185,"series_id":182,"episode":2,"ischarge":"0","price":"0","share_title":"惊险刺激的摩洛哥历险记","share_content":"90后美女跟骆驼这么玩，一不小心磨破大腿根，撒哈拉沙漠里最磨人屁股的物种竟然是这个！","share_image":"http://img.szzhangchu.com/1491808546858_9986582968.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"},{"course_id":2161,"course_name":"如果人间有天堂，那一定是塔希提岛的模样","course_subject":"这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为\u201c最接近天堂的地方\u201d\u2014\u2014塔希提（大溪地）！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460436615_2190842413.mp4","course_image":"http://img.szzhangchu.com/1491808664029_4243631504.jpg","read_count":0,"video_watchcount":3966,"video_length":183,"series_id":182,"episode":3,"ischarge":"0","price":"0","share_title":"如果人间有天堂，那一定是塔希提岛的模样","share_content":"这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为\u201c最接近天堂的地方\u201d\u2014\u2014塔希提（大溪地）！","share_image":"http://img.szzhangchu.com/1491808663176_2400224776.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"}],"play":11717,"share_url":"http://m.izhangchu.com/micro/shike.php?&material_id=182"}
     * code : 0
     * msg : success
     * timestamp : 1491957695570
     * version : 4.4
     */

    private DataBeanX data;
    private String code;
    private String msg;
    private long timestamp;
    private String version;

    @Override
    public String toString() {
        return "BannerBean{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", timestamp=" + timestamp +
                ", version='" + version + '\'' +
                '}';
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
