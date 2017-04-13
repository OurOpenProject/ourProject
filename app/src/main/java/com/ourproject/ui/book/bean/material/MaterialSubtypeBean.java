package com.ourproject.ui.book.bean.material;

import java.util.List;

/**
 * Created by YC on 2017/4/10.
 */

public class MaterialSubtypeBean {

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataBeanXX data;

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

    public DataBeanXX getData() {
        return data;
    }

    public void setData(DataBeanXX data) {
        this.data = data;
    }
}
