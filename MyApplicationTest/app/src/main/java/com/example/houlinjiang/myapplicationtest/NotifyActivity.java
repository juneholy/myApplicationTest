package com.example.houlinjiang.myapplicationtest;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by houlin.jiang on 2016/4/18.
 */
public class NotifyActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                Toast.makeText(this,"receive message : " + intent.getStringExtra(Intent.EXTRA_TEXT),Toast.LENGTH_LONG).show();
            } else if (type.startsWith("image/")) {
            }
        } else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
            if (type.startsWith("image/")) {
            }
        } else {
            NotificationManager mNotifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            mNotifyManager.cancelAll();
        }
    }
}
