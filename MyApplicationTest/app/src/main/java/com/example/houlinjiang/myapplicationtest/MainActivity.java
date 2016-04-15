package com.example.houlinjiang.myapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.houlinjiang.myapplicationtest.eventbus.EventBusActivity;
import com.example.houlinjiang.myapplicationtest.lifecycle.LifeCycleActivity;
import com.example.houlinjiang.myapplicationtest.sqlite.SQLiteActivity;

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
}
