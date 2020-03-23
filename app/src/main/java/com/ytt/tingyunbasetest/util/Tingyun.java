package com.ytt.tingyunbasetest.util;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

import com.networkbench.agent.impl.NBSAppAgent;
import com.networkbench.agent.impl.instrumentation.NBSWebChromeClient;

import java.util.Map;

public class Tingyun {
    public static void initWukong(Context context){
        NBSAppAgent.setLicenseKey(AppKey.yangtt3_0)
                .setHttpEnabled(true)
                .setRedirectHost("10.128.1.7:7071")
                //.setRedirectHost("10.128.1.52:8603")
                .start(context);

        NBSAppAgent.setUserIdentifier("111");
    }
    public static void setAppStartEnd(String className){
        NBSAppAgent.setCustomOnResumeEndIns(className);
    }
    public static void reportException(String msg, Exception e, Map<String,Object> metaData){
        NBSAppAgent.reportError(msg,e,metaData);
    }
    public static void reportError(String msg, Map<String,Object> metaData){
        NBSAppAgent.reportError(msg,metaData);
    }
    public static void setUserIdentifier(String uid){
        NBSAppAgent.setUserIdentifier(uid);
    }
    public static void sleepWithCustomTrace(int num){
        String traceLabel=String.format("sleep-%d-s",num);
        NBSAppAgent.beginTracer(traceLabel);
        CommonTools.wait(num);
        NBSAppAgent.endTracer(traceLabel);
    }
    public static void embedWebview(WebView view, int newProgress){
        //NBSWebChromeClient.initJSMonitor(view,newProgress);
    }
    public static void setCrashMsg(String key,String value){
        NBSAppAgent.setUserCrashMessage(key,value);
    }
    public static void setMianBaoXie(String msg){
        NBSAppAgent.leaveBreadcrumb(msg);
    }

    public static void setViewID(View v, String vid){
        NBSAppAgent.setViewId(v,vid);
    }
}
