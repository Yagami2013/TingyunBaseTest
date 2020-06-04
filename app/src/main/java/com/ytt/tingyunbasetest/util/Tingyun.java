package com.ytt.tingyunbasetest.util;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

import com.networkbench.agent.impl.NBSAppAgent;
import com.networkbench.agent.impl.instrumentation.NBSWebChromeClient;
import com.networkbench.agent.impl.instrumentation.NBSWebChromeX5Client;

import java.util.Map;

public class Tingyun {
    public static void initWukong(Context context){

        NBSAppAgent.setLicenseKey(Keys.ea_wlds)
                .setRedirectHost(Keys.host_wlds)
                .withLocationServiceEnabled(true)
                //.setStartOption(511)
                .start(context); 

        NBSAppAgent.setUserIdentifier(CommonTools.getMac(context));
    }
    public static void setAppStartEnd(String className){
        NBSAppAgent.setCustomOnResumeEndIns(className);
    }
    public static void reportException(String msg, Exception e, Map<String,Object> metaData){
        //NBSAppAgent.reportError(msg,e,metaData);
    }
    public static void reportError(String msg, Map<String,Object> metaData){
        //NBSAppAgent.reportError(msg,metaData);
    }
    public static void reportErrorType(String msg,int type, Map<String,Object> metaData){
        //NBSAppAgent.reportError(msg,type,metaData);
    }
    public static void reportExceptionType(String msg,int type,Exception e,Map<String,Object> metaData){
        //NBSAppAgent.reportError(msg,type,e,metaData);
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
        NBSWebChromeClient.initJSMonitor(view,newProgress);
    }
    public static void embedX5Webview(com.tencent.smtt.sdk.WebView view,int newProgress){
        NBSWebChromeX5Client.initJSMonitorX5(view,newProgress);
    }
    public static void addX5Bridge(com.tencent.smtt.sdk.WebView view){
        NBSWebChromeX5Client.addWebViewBridge(view);
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
