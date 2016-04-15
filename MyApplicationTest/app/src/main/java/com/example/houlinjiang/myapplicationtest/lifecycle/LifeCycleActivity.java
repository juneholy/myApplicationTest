package com.example.houlinjiang.myapplicationtest.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

/**
 * Created by houlin.jiang on 2016/1/6.
 */
public class LifeCycleActivity extends Activity {

    private TextView tvLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifecycle","=======onCreate=======");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        tvLog = (TextView) findViewById(R.id.tv_lifeCycle);
    }

    @Override
    protected void onStart() {
        Log.d("lifecycle", "=======onStart=======");
        String log = tvLog.getText()  + "====Activity1===onStart=======" + "\n";
        tvLog.setText(log);
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d("lifecycle","====Activity1===onRestart=======");
        String log = tvLog.getText()  + "====Activity1===onRestart=======" + "\n";
        tvLog.setText(log);
        super.onRestart();
    }


    @Override
    protected void onResume() {
        Intent intent = this.getIntent();
        String  log = intent.getStringExtra("log");
        Log.d("lifecycle", "====Activity1===onResume=======");
        log = log + tvLog.getText()  + "====Activity1===onResume=======" + "\n";
        tvLog.setText(log);
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d("lifecycle","====Activity1===onPause=======");
        String log = tvLog.getText()  + "====Activity1===onPause=======" + "\n";
        tvLog.setText(log);
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("lifecycle","====Activity1===onPause=======");
        String log = tvLog.getText()  + "====Activity1===onResume=======" + "\n";
        tvLog.setText(log);

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifecycle","====Activity1===onDestroy=======");
        String log = tvLog.getText()  + "====Activity1===onDestroy=======" + "\n";
        tvLog.setText(log);
        super.onDestroy();
    }

    public void startSecondAcitivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("log", tvLog.getText());
        startActivity(intent);
    }


}
