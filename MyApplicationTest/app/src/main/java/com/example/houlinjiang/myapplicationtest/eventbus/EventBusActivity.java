package com.example.houlinjiang.myapplicationtest.eventbus;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.houlinjiang.myapplicationtest.R;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by houlin.jiang on 2016/4/13.
 */
public class EventBusActivity extends Activity {
    TextView tv, tv_app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        EventBus.getDefault().register(this);
        tv = (TextView) findViewById(R.id.tv_event1);
        tv_app = (TextView) findViewById(R.id.tv_app);
        List<AppInfo> appInfos = getAllApps();
        String str = "";
        for (AppInfo a:appInfos) {
            if (!a.isSystemApp) {
                str = str + a.appName + "\n";
            }
        }
        tv_app.setText(str);

    }

    public List<AppInfo> getAllApps(){
        List<AppInfo> list = new ArrayList<AppInfo>();
        AppInfo myAppInfo;
        //获取到所有安装了的应用程序的信息，包括那些卸载了的，但没有清除数据的应用程序
        PackageManager packageManager = this.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        for(PackageInfo info:packageInfos){
            myAppInfo = new AppInfo();
            //拿到包名
            String packageName = info.packageName;
            //拿到应用程序的信息
            ApplicationInfo appInfo = info.applicationInfo;
            //拿到应用程序的图标
            Drawable icon = appInfo.loadIcon(packageManager);
            //拿到应用程序的大小
            //long codesize = packageStats.codeSize;
            //Log.i("info", "-->"+codesize);
            //拿到应用程序的程序名
            String appName = appInfo.loadLabel(packageManager).toString();
            myAppInfo.setPackageName(packageName);
            myAppInfo.setAppName(appName);

            if(filterApp(appInfo)){
                myAppInfo.setSystemApp(false);
            }else{
                myAppInfo.setSystemApp(true);
            }
            list.add(myAppInfo);
        }
        return list;
    }

    public boolean filterApp(ApplicationInfo info){
        //有些系统应用是可以更新的，如果用户自己下载了一个系统的应用来更新了原来的，它还是系统应用，这个就是判断这种情况的
        if((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0){
            return true;
        }else if((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0){//判断是不是系统应用
            return true;
        }
        return false;
    }
    public class AppInfo {
        private String appName;
        private String packageName;
        private boolean isSystemApp;
        private long codesize;
        public long getCodesize() {
            return codesize;
        }
        public void setCodesize(long codesize) {
            this.codesize = codesize;
        }
        public String getAppName() {
            return appName;
        }
        public void setAppName(String appName) {
            this.appName = appName;
        }
        public String getPackageName() {
            return packageName;
        }
        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }
        public boolean isSystemApp() {
            return isSystemApp;
        }
        public void setSystemApp(boolean isSystemApp) {
            this.isSystemApp = isSystemApp;
        }
    }
    public void startEventBus(View view) {
        Intent intent = new Intent(this,EventBusActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        tv.setText(msg);
    }
}