package com.example.houlinjiang.myapplicationtest.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.houlinjiang.myapplicationtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houlin.jiang on 2016/4/29.
 */
public class ImageActivity extends FragmentActivity{


    private ImagePagerAdapter mAdapter;
    private ViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mPager = (ViewPager) findViewById(R.id.pager);

        List<String> urlList = new ArrayList<String>();
        urlList.add("http://static.oschina.net/uploads/space/2016/0418/081400_PAqf_12.jpg");
        urlList.add("http://static.oschina.net/uploads/space/2016/0418/081400_PAqf_12.jpg");
        urlList.add("http://static.oschina.net/uploads/space/2016/0418/081400_PAqf_12.jpg");
        urlList.add("http://static.oschina.net/uploads/space/2016/0418/081400_PAqf_12.jpg");
        mAdapter = new ImagePagerAdapter(getSupportFragmentManager(), urlList);
        mPager.setAdapter(mAdapter);
        openImage();
    }

    private void openImage() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),R.drawable.image1111,options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;
        Log.d("==========", "h = " + imageHeight + "   w=" + imageWidth + "  type= " + imageType);

    }

    public static class ImagePagerAdapter extends FragmentStatePagerAdapter {

        private List<String> urlList = new ArrayList<String>();

        public ImagePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public ImagePagerAdapter(FragmentManager fm,List<String> urlList) {
            super(fm);
            this.urlList = urlList;
        }

        @Override
        public Fragment getItem(int position) {
            return ImageDetailFragment.newInstance(position,urlList.get(position));
        }

        @Override
        public int getCount() {
            return urlList.size();
        }
    }




}
