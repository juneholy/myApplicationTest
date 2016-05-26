package com.example.houlinjiang.myapplicationtest.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.houlinjiang.myapplicationtest.R;

import java.io.FileOutputStream;

/**
 * Created by houlin.jiang on 2016/5/9.
 */
public class CaptureActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        webView = (WebView) findViewById(R.id.load_webview);
        webView.loadUrl("http://www.baidu.com");

        Button capture = (Button) findViewById(R.id.loadURL);
        capture.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Picture picture = webView.capturePicture();
                int width = picture.getWidth();
                int height = picture.getHeight();
                if (width > 0 && height > 0) {
                    //创建指定高宽的Bitmap对象
                    Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    //创建Canvas,并以bitmap为绘制目标
                    Canvas canvas = new Canvas(bitmap);
                    //将WebView影像绘制在Canvas上
                    picture.draw(canvas);
                    try {
                        String fileName = "/sdcard/webview_capture.jpg";
                        FileOutputStream fos = new FileOutputStream(fileName);
                        //压缩bitmap到输出流中
                        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                        fos.close();
                        Toast.makeText(CaptureActivity.this, "CAPTURE SUCCESS", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Log.e("===========", e.getMessage());
                    }
                }
            }
        });
    }
}
