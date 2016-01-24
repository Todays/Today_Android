package com.today.android.Utils;

import android.util.Log;

/**
 * Created by sushil on 1/16/16.
 */
public class LoggerCommon {

    private static LoggerCommon mLogger;
    private static boolean isLogEnabled = false;

    private LoggerCommon() {
        // TODO Auto-generated constructor stub
        mLogger = this;

    }

    public static LoggerCommon getInstanceLogger() {

        // TODO Auto-generated constructor stub
        if(mLogger == null){
            mLogger = new LoggerCommon();
        }
        return mLogger;
    }

    public  void setLogEnable(boolean isEnabled){
        isLogEnabled = isEnabled;

    }


    public  void printVerbose(String tag, String message){
        if(message!=null && isLogEnabled)
            Log.v(tag, message);
    }


    public  void printDebugger(String tag, String message){
        if(message!=null && isLogEnabled)
            Log.d(tag, message);
    }


    public  void printError(String tag, String message){
        if(message!=null && isLogEnabled)
            Log.e(tag, message);
    }

}
