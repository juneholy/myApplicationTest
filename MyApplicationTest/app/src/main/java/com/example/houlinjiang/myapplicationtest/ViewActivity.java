package com.example.houlinjiang.myapplicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by houlin.jiang on 2016/4/15.
 */
public class ViewActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void onButtonClick(View view) {
        Toast.makeText(this, "normal button clicked",Toast.LENGTH_SHORT).show();
    }

    public void onImageButtonClick(View view) {
        Toast.makeText(this, "image button clicked",Toast.LENGTH_SHORT).show();
    }

    public void onImageClick(View view) {
        Toast.makeText(this, "I am imageView",Toast.LENGTH_SHORT).show();

    }
}
