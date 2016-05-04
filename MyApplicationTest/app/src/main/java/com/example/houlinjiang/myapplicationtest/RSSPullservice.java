package com.example.houlinjiang.myapplicationtest;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by houlin.jiang on 2016/5/3.
 */
public class RSSPullservice extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RSSPullservice(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
