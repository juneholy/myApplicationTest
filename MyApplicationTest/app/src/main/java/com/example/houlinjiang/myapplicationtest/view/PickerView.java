package com.example.houlinjiang.myapplicationtest.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by houlin.jiang on 2016/5/23.
 */
public class PickerView extends View{
    public PickerView(Context context) {
        super(context);
    }

    public PickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(VERSION_CODES.LOLLIPOP)
    public PickerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
