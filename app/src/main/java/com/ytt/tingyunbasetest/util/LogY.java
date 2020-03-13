package com.ytt.tingyunbasetest.util;

import android.util.Log;

import java.security.PrivateKey;

public class LogY {
    private static String gloableTag="yttTag";
    public LogY(String className){
        gloableTag=gloableTag.concat("."+className);
    }
    public void msg(String msg){
        Log.d(gloableTag,msg);
    }
    public void err(String msg){
        Log.e(gloableTag,msg);
    }
}
