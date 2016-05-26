package com.example.houlinjiang.myapplicationtest;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by houlin.jiang on 2016/4/29.
 */
public class AnimationActivity extends Activity{

    private TextView tvAnim;
    private ImageView imageView;
    private boolean swith = true;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        tvAnim = (TextView) findViewById(R.id.tv_anim);
        imageView = (ImageView) findViewById(R.id.im_frame);
        imageView.setBackgroundResource(R.drawable.movie);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
    }

    public void startScale(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        tvAnim.startAnimation(animation);
    }

    public void startAlpha(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        tvAnim.startAnimation(animation);
    }

    public void startRotate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        tvAnim.startAnimation(animation);
    }

    public void startTranslate(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
        tvAnim.startAnimation(animation);
    }

    public void startFrame(View view) {
        if (swith) {
            animationDrawable.start();
            swith =false;
        } else {
            animationDrawable.stop();
            swith = true;
        }

    }
}
