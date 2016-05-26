package com.example.houlinjiang.myapplicationtest.web;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

/**
 * Created by houlin.jiang on 2016/5/9.
 */
public class LoadActivity extends Activity {

    private WebView webView;
    String url = "https://ss0.bdstatic.com/l4oZeXSm1A5BphGlnYG/skin/";
    int base = 400;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_load);
        webView = (WebView) findViewById(R.id.load_webview);
        webView.setInitialScale(110);
        WebSettings settings = webView.getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
//        settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
//        settings.setLoadWithOverviewMode(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            //当WebView进度改变时更新窗口进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                //Activity的进度范围在0到10000之间,所以这里要乘以100
                LoadActivity.this.setProgress(newProgress * 100);
            }
        });
        final TextView tv = (TextView) findViewById(R.id.url);
        Button loadURL = (Button) findViewById(R.id.loadURL);
        loadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loadUrl = url + (base++)+".jpg";
                tv.setText(loadUrl);
                webView.loadUrl(loadUrl); //加载url
                webView.clearHistory();
                webView.requestFocus(); //获取焦点
            }
        });

    }

    @Override
    public void onBackPressed() {
        this.finish();
//        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
