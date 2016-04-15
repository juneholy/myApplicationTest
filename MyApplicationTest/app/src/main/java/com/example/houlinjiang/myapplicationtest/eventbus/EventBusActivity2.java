package com.example.houlinjiang.myapplicationtest.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houlinjiang.myapplicationtest.R;

import de.greenrobot.event.EventBus;

/**
 * Created by houlin.jiang on 2016/4/14.
 */
public class EventBusActivity2 extends Activity{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus_2);
        tv  = (TextView) findViewById(R.id.tv_event2);
        EventBus.getDefault().register(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void onEventMainThread(FirstEvent event) {
        Toast.makeText(this,event.getMsg(),Toast.LENGTH_SHORT);
    }

    public void sendMessage(View view) {
        EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
        tv.setText("send message \"FirstEvent btn clicked \"" );
    }
}
