package com.example.houlinjiang.myapplicationtest.uelog;

/**
 * Created by houlin.jiang on 2016/4/21.
 */
public class UELogManager {

    private static UELogManager mUELogManager;
    private StringBuffer logSb = new StringBuffer();
    public UELogManager() {
    }

    public static UELogManager getInstance() {
        if (mUELogManager == null) {
            synchronized (UELogManager.class){
              if (mUELogManager == null) {
                  mUELogManager = new UELogManager();
              }

            }
        }
        return mUELogManager;
    }

    public void writelog(String log) {
        logSb = logSb.append(log + "\n");
    }

    public void clearlog() {
        logSb = new StringBuffer();
    }

    public StringBuffer getLog() {
        return logSb;
    }

}
