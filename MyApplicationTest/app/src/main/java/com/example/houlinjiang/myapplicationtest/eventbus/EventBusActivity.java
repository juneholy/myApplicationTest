package com.example.houlinjiang.myapplicationtest.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

import de.greenrobot.event.EventBus;

/**
 * Created by houlin.jiang on 2016/4/13.
 */
public class EventBusActivity extends Activity {
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        EventBus.getDefault().register(this);
        tv = (TextView) findViewById(R.id.tv_event1);
    }


    public void startEventBus(View view) {
        Intent intent = new Intent(this,EventBusActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        tv.setText(msg);
    }
}