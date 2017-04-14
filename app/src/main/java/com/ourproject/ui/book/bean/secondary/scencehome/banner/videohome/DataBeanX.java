package com.ourproject.ui.book.bean.secondary.scencehome.banner.videohome;

import java.util.List;

/**
 * Created by YC on 2017/4/12.
 */

public class DataBeanX {
    /**
     * series_id : 182
     * series_name : #去过#如果人间有天堂，那一定是塔希提岛的模样
     * series_title : 这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为“最接近天堂的地方”——塔希提（大溪地）！
     * create_time : Apr 10, 2017 3:10:26 PM
     * last_update : Apr 10, 2017 3:11:26 PM
     * order_no : 1
     * tag :
     * episode : 3
     * series_image : http://img.szzhangchu.com/1491808286329_4810470723.jpg
     * album : 去过
     * album_logo : 1491808226018_3754036436.png
     * relate_activity : 210
     * data : [{"course_id":2159,"course_name":"兔子VS荡漾的日本","course_subject":"前央视体育记者化身旅行达人，放下成见，带你赏樱看日本！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460415322_7264047151.mp4","course_image":"http://img.szzhangchu.com/1491808416546_2708197150.jpg","read_count":0,"video_watchcount":3874,"video_length":184,"series_id":182,"episode":1,"ischarge":"0","price":"0","share_title":"前央视体育记者化身旅行达人，放下成见，带你赏樱看日本！","share_content":"兔子VS荡漾的日本","share_image":"http://img.szzhangchu.com/1491808416151_3744443957.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"},{"course_id":2160,"course_name":"惊险刺激的摩洛哥历险记","course_subject":"90后美女跟骆驼这么玩，一不小心磨破大腿根，撒哈拉沙漠里最磨人屁股的物种竟然是这个！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460385660_4178483654.mp4","course_image":"http://img.szzhangchu.com/1491808547891_1792444181.jpg","read_count":0,"video_watchcount":3877,"video_length":185,"series_id":182,"episode":2,"ischarge":"0","price":"0","share_title":"惊险刺激的摩洛哥历险记","share_content":"90后美女跟骆驼这么玩，一不小心磨破大腿根，撒哈拉沙漠里最磨人屁股的物种竟然是这个！","share_image":"http://img.szzhangchu.com/1491808546858_9986582968.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"},{"course_id":2161,"course_name":"如果人间有天堂，那一定是塔希提岛的模样","course_subject":"这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为\u201c最接近天堂的地方\u201d\u2014\u2014塔希提（大溪地）！","course_introduce":"","course_video":"http://video.szzhangchu.com/1491460436615_2190842413.mp4","course_image":"http://img.szzhangchu.com/1491808664029_4243631504.jpg","read_count":0,"video_watchcount":3966,"video_length":183,"series_id":182,"episode":3,"ischarge":"0","price":"0","share_title":"如果人间有天堂，那一定是塔希提岛的模样","share_content":"这里的人不穿衣服还有八块腹肌、这里是《神盾局特工》中寇森复活的地方、这里被称为\u201c最接近天堂的地方\u201d\u2014\u2014塔希提（大溪地）！","share_image":"http://img.szzhangchu.com/1491808663176_2400224776.jpg","is_collect":0,"is_like":0,"share_url":"/","detail":"","islink":"0"}]
     * play : 11717
     * share_url : http://m.izhangchu.com/micro/shike.php?&material_id=182
     */
    private int series_id;
    private String series_name;
    private String series_title;
    private String create_time;
    private String last_update;
    private String order_no;
    private String tag;
    private int episode;
    private String series_image;
    private String share_title;
    private String share_description;
    private String share_image;
    private String album;
    private String album_logo;
    private String relate_activity;
    private int play;
    private String share_url;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "DataBeanX{" +
                "series_id=" + series_id +
                ", series_name='" + series_name + '\'' +
                ", series_title='" + series_title + '\'' +
                ", create_time='" + create_time + '\'' +
                ", last_update='" + last_update + '\'' +
                ", order_no='" + order_no + '\'' +
                ", tag='" + tag + '\'' +
                ", episode=" + episode +
                ", series_image='" + series_image + '\'' +
                ", share_title='" + share_title + '\'' +
                ", share_description='" + share_description + '\'' +
                ", share_image='" + share_image + '\'' +
                ", album='" + album + '\'' +
                ", album_logo='" + album_logo + '\'' +
                ", relate_activity='" + relate_activity + '\'' +
                ", play=" + play +
                ", share_url='" + share_url + '\'' +
                ", data=" + data +
                '}';
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getSeries_image() {
        return series_image;
    }

    public void setSeries_image(String series_image) {
        this.series_image = series_image;
    }

    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public String getShare_description() {
        return share_description;
    }

    public void setShare_description(String share_description) {
        this.share_description = share_description;
    }

    public String getShare_image() {
        return share_image;
    }

    public void setShare_image(String share_image) {
        this.share_image = share_image;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum_logo() {
        return album_logo;
    }

    public void setAlbum_logo(String album_logo) {
        this.album_logo = album_logo;
    }

    public String getRelate_activity() {
        return relate_activity;
    }

    public void setRelate_activity(String relate_activity) {
        this.relate_activity = relate_activity;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public DataBeanX(int series_id, String series_name, String series_title, String create_time, String last_update, String order_no, String tag, int episode, String series_image, String share_title, String share_description, String share_image, String album, String album_logo, String relate_activity, int play, String share_url, List<DataBean> data) {
        this.series_id = series_id;
        this.series_name = series_name;
        this.series_title = series_title;
        this.create_time = create_time;
        this.last_update = last_update;
        this.order_no = order_no;
        this.tag = tag;
        this.episode = episode;
        this.series_image = series_image;
        this.share_title = share_title;
        this.share_description = share_description;
        this.share_image = share_image;
        this.album = album;
        this.album_logo = album_logo;
        this.relate_activity = relate_activity;
        this.play = play;
        this.share_url = share_url;
        this.data = data;
    }

    public int getSeries_id() {
        return series_id;
    }

    public void setSeries_id(int series_id) {
        this.series_id = series_id;
    }
}