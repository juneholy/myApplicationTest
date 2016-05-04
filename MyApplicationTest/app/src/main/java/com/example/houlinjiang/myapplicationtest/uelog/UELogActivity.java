package com.example.houlinjiang.myapplicationtest.uelog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;
import com.example.houlinjiang.myapplicationtest.RSSPullservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houlin.jiang on 2016/4/21.
 */
public class UELogActivity extends Activity{
    private TextView tv_log;
    private EditText et;
    private String etStr = "";
    private Intent mServiceIntent;

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uelog);
        tv_log = (TextView) findViewById(R.id.tv_ue_log);
        et = (EditText) findViewById(R.id.et_input);
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (!TextUtils.isEmpty(et.getText().toString()) && !etStr.equals(et.getText().toString())) {
                    etStr = et.getText().toString();
                    UELogManager.getInstance().writelog("user input \" "+ et.getText().toString() + "\"");
                }
                tv_log.setText(UELogManager.getInstance().getLog());
                mHandler.postDelayed(this,1000);
            }
        });
    }

    public void onBtn1click(View view) {
        UELogManager.getInstance().writelog("button 1 clicked");
        CrashHandler.getInstance().init(this);
        List<String> list = new ArrayList<String>();
        list.get(0);
    }

    public void onBtn2click(View view) {
        mServiceIntent = new Intent(this, RSSPullservice.class);
        mServiceIntent.setData(Uri.parse(""));
        this.startService(mServiceIntent);
        UELogManager.getInstance().writelog("button 2 clicked");
    }
    }


