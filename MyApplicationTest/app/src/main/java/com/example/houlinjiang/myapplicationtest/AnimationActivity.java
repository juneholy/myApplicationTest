package com.example.houlinjiang.myapplicationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by houlin.jiang on 2016/4/29.
 */
public class AnimationActivity extends Activity{

    private View mContentView;
    private View mLoadingView;
    private int mShortAnimationDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mContentView = findViewById(R.id.content);
        mLoadingView = findViewById(R.id.loading_spinner);
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);
    }
}
