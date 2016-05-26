package com.example.houlinjiang.myapplicationtest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houlinjiang.myapplicationtest.commonUtils.CommonUtil;

import java.util.List;

/**
 * Created by houlin.jiang on 2016/5/3.
 */
public class BarActivity extends ActionBarActivity{

    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        et = (EditText) findViewById(R.id.et_send);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_bar_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this,"search clicked",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this,"setting clicked",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sendText(View view) {
        Intent senIntent = new Intent();
        senIntent.setAction(Intent.ACTION_SEND);
        senIntent.putExtra(Intent.EXTRA_TEXT,et.getText().toString());
        senIntent.setType("text/plain");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(senIntent, 0);
        Toast.makeText(this,"如果触发了一个intent，而且没有任何一个app会去接收这个intent，则app会crash。",Toast.LENGTH_LONG).show();
        if (!CommonUtil.isEmpty(activities)) {
            startActivity(senIntent);
        }
    }
}
