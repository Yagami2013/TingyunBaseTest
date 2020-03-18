package com.ytt.tingyunbasetest.util;

import android.util.Log;

import java.security.PrivateKey;

public class LogY {
    private String gloableTag="yttTag";
    public LogY(String className){
        gloableTag=gloableTag.concat("."+className);
    }
    public void msg(String msg){
        Log.d(gloableTag,msg);
    }
    public void err(StackTraceElement[] stackTraceElements){
        for (StackTraceElement stack:stackTraceElements
             ) {
            Log.e(gloableTag,stack.getClassName()
                    .concat(".")
                    .concat(stack.getMethodName())
                    .concat("(")
                    .concat(stack.getFileName())
                    .concat(":")
                    .concat(stack.getLineNumber()+")"));
        }

    }
    public void warning(String msg){
        Log.w(gloableTag,msg);
    }
}
