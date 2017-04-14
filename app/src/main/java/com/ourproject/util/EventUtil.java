package com.ourproject.util;

/**
 * Created by admin on 2017/4/12.
 */

public class EventUtil {
    public final int what;
    private String id;

    public EventUtil(int what) {
        this.what = what;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
