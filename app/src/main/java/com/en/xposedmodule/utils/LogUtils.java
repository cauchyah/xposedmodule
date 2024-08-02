package com.en.xposedmodule.utils;

import android.util.Log;

public class LogUtils {
    public static final String TAG="XposedHook";
    public static void printStack(){
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                Log.d(TAG, "Dump Stack"+i+": "+stackElements[i].getClassName()
                        +"----"+stackElements[i].getFileName()
                        +"----" + stackElements[i].getLineNumber()
                        +"----" +stackElements[i].getMethodName());
            }
        }

    }

    public static void d(String msg){
        Log.d(TAG,msg);
    }
}
