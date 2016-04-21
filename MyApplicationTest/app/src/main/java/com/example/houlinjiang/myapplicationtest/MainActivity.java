package com.example.houlinjiang.myapplicationtest;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.houlinjiang.myapplicationtest.eventbus.EventBusActivity;
import com.example.houlinjiang.myapplicationtest.lifecycle.LifeCycleActivity;
import com.example.houlinjiang.myapplicationtest.sqlite.SQLiteActivity;
import com.example.houlinjiang.myapplicationtest.uelog.UELogActivity;
import com.example.houlinjiang.myapplicationtest.uelog.UELogManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLifeCycleActivity(View v) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, LifeCycleActivity.class);
        startActivity(intent);
    }

    public void openEventBusActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, EventBusActivity.class);
        startActivity(intent);
    }

    public void openSQLiteActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SQLiteActivity.class);
        startActivity(intent);
    }

    public void openViewActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ViewActivity.class);
        startActivity(intent);
    }

    public void sendNotify(View view) {
        NotificationManager mNotifyManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notify = new Notification();

        Notification.Builder builder = new Builder(this).setTicker("通知消息提示栏~~通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏").setSmallIcon(R.drawable.notify);
        notify.flags = Notification.FLAG_ONGOING_EVENT;
        Intent intent = new Intent(this,NotifyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this,100, new Intent[]{intent},PendingIntent.FLAG_UPDATE_CURRENT);
        notify = builder.setContentIntent(pendingIntent).setContentTitle("通知").setContentText("点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧点我吧").build();
        mNotifyManager.notify(0, notify);
    }


    public void openUELog(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, UELogActivity.class);
        startActivity(intent);
    }
}
