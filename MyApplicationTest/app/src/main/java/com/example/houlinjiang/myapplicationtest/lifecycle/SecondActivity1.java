package com.example.houlinjiang.myapplicationtest.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

/**
 * Created by houlin.jiang on 2016/5/23.
 */
public class SecondActivity1 extends Activity{
    TextView tvLog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        setContentView(R.layout.second_activity);
        tvLog = (TextView) findViewById(R.id.tv_second);
        String log = intent.getStringExtra("log");
        log = log  + this.toString() + "\n" + "====Activity2===onCreate=======" + "\n";
        tvLog.setText(log);
    }

    @Override
    protected void onStart() {
        Log.d("lifecycle", "=======onStart=======");
        String log = tvLog.getText()  + "====Activity2===onStart=======" + "\n";
        tvLog.setText(log);
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("lifecycle","====Activity2===onRestart=======");
        String log = tvLog.getText()  + "====Activity2===onRestart=======" + "\n";
        tvLog.setText(log);
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d("lifecycle", "====Activity2===onResume=======");
        String log = tvLog.getText()  + "====Activity2===onResume=======" + "\n";
        tvLog.setText(log);
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("lifecycle","====Activity2===onPause=======");
        String log = tvLog.getText()  + "====Activity2===onPause=======" + "\n";
        tvLog.setText(log);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("lifecycle","====Activity2===onPause=======");
        String log = tvLog.getText()  + "====Activity2===onResume=======" + "\n";
        tvLog.setText(log);

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifecycle", "====Activity2===onDestroy=======");
        String log = tvLog.getText()  + "====Activity2===onDestroy=======" + "\n";
        tvLog.setText(log);
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("lifecycle", "====Activity2===onNewIntent=======");
        String log = tvLog.getText()  + "====Activity2===onNewIntent=======" + "\n";
        tvLog.setText(log);
        super.onDestroy();
        super.onNewIntent(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,LifeCycleActivity.class);
        intent.putExtra("log", tvLog.getText());
        super.onBackPressed();
    }

    public void restartThis(View view) {
        Intent intent = new Intent(this,SecondActivity1.class);
        intent.putExtra("log", tvLog.getText());
        startActivity(intent);
    }
}