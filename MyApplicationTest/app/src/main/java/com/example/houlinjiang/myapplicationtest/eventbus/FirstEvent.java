package com.example.houlinjiang.myapplicationtest.eventbus;

/**
 * Created by houlin.jiang on 2016/4/14.
 */
public class FirstEvent {
    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
