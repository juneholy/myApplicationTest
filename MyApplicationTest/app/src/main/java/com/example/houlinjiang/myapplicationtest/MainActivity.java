package com.example.houlinjiang.myapplicationtest;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.houlinjiang.myapplicationtest.bitmap.ImageActivity;
import com.example.houlinjiang.myapplicationtest.eventbus.EventBusActivity;
import com.example.houlinjiang.myapplicationtest.lifecycle.LifeCycleActivity;
import com.example.houlinjiang.myapplicationtest.sqlite.SQLiteActivity;
import com.example.houlinjiang.myapplicationtest.uelog.UELogActivity;
import com.example.houlinjiang.myapplicationtest.web.LoadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("fhuiehwuirh", 1);
        editor.commit();
//        startHttp();
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
        notify.flags = Notification.FLAG_SHOW_LIGHTS;
        notify.flags |= Notification.DEFAULT_VIBRATE;
        notify.ledARGB = 0xff0000ff;
        notify.ledOnMS = 300;
        notify.ledOffMS = 300;
        Notification.Builder builder = new Builder(this).setTicker("通知消息提示栏~~通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏通知消息提示栏").setSmallIcon(R.drawable.notify);
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
    public void openImage(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ImageActivity.class);
        startActivity(intent);
    }

    public void openAnimation(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AnimationActivity.class);
        startActivity(intent);
    }

    public void openActivityWithBar(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, BarActivity.class);
        startActivity(intent);
    }

    public void openAnimationFlip(View view) {
    }

    public void openWebView(View view) {
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }
}
