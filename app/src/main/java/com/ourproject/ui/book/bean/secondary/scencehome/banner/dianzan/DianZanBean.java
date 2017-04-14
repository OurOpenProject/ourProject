package com.ourproject.ui.book.bean.secondary.scencehome.banner.dianzan;

import java.util.List;

/**
 * Created by YC on 2017/4/13.
 */

public class DianZanBean {

    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1492044927000
     * data : {"page":"1","size":"10","total":"1","count":"1","data":[{"user_id":"1927904","create_time":1491902791,"nick":"小妖精","head_img":"http://wx.qlogo.cn/mmopen/Y3WgNLFjO0coI5XiakDvBu0tXhp6yibZCH7rfLl4fcnldSfbibPqfjloSXx9Pvz3magbfQCRiaq8q9ic4W53venR21Hxsx01hIaRp/0","istalent":0,"create_time_cn":"1天前"}]}
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
