package com.example.houlinjiang.myapplicationtest.commonUtils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by houlin.jiang on 2016/4/29.
 */
public class CommonUtil {
    public final static String TAG = "Common utils";
    public static File getTempFile(Context context,String path) {
        File file = null;
        if (TextUtils.isEmpty(path)) {
            return file;
        }
        try {
            String fileName = Uri.parse(path).getLastPathSegment();
            file = File.createTempFile(fileName, null, context.getCacheDir());
        }catch (Exception e) {
            Log.d(TAG,"get temp file fail");
        }
        return file;
    }

    public static boolean writeFile(Context context,String path,String text) {
        if (TextUtils.isEmpty(path) || TextUtils.isEmpty(text)) {
            return false;
        }
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(path, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private static FileOutputStream openFileOutput(String path, int mode) {
        return null;
    }

    public static boolean isExtStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExtStorageWrightable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        } else {
            return false;
        }
    }
}
